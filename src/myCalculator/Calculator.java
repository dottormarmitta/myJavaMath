package myCalculator;

public class Calculator {

		/*
		 * BASIC ALGEBRA
		 */
	
		// Find Extreme values:
		// - Maximum
		public static double getMax(double[] args) {
			double max = args[0];
			for (int i = 1; i < args.length; i++) {
				if (args[i] > max) {
					max = args[i];
				}
			}
			return max;
		}
		// - Minimum
		public static double getMin(double[] args) {
			double min = args[0];
			for (int i = 1; i < args.length; i++) {
				if (args[i] < min) {
					min = args[i];
				}
			}
			return min;
		}
		
		// Doing the same with integer numbers:
		// - Maximum
		public static int getMax(int[] args) {
			int max = args[0];
			for (int i = 1; i < args.length; i++) {
				if (args[i] > max) {
					max = args[i];
					}
				}
			return max;
		}
		// - Minimum
		public static int getMin(int[] args) {
			int min = args[0];
			for (int i = 1; i < args.length; i++) {
				if (args[i] < min) {
					min = args[i];
				}
			}
			return min;
		}
				
		/* next */
		
		// Addition
		// - double (with compensation)
		public static double getSum(double[] elements) {
			double sum = 0.0;
			double compensation = 0.0;
			for (int i = 0; i < elements.length; i++) {
				double y = elements[i] - compensation;
				double t = sum + y;
				compensation = (t - sum) - y;
				sum = t;
			}
			return sum;
		}
		// - Integer (no compensation needed)
		public static int getSum(int[] elements) {
			int sum = 0;
			for (int i = 0; i < elements.length; i++) {
				sum += elements[i];
			}
			return sum;
		}
		
		/* next */
		
		// Subtraction
		// - Double
		public static double getSubtraction(double[] elements) {
			for (int i = 0; i < elements.length; i++) {
				elements[i]*= (-1);
			}
			return getSum(elements);
		}
		// - integer
		public static int getSubtraction(int[] elements) {
			int sub = 0;
			for (int i = 0; i < elements.length; i++) {
				sub -= elements[i];
			}
			return sub;
		}
		
		/* next */
		
		// Multiplication
		public static double getProduct(double[] args) {
			double product = 1;
			
			for (int i = 0; i < args.length; i++) {
				product *= args[i];
			}
			return product;
			
		}
		// Doing the same with integers:
		public static int getProduct(int[] args) {
			int product = 1;
			
			for (int i = 0; i < args.length; i++) {
				product *= args[i];
			}
			return product;
			
		}
		
		/* next */
		
		// Percentage of a given number. we may have the percentage given as:
		// * Integer (e.g 30 as 30%)
		public static double getPercentage(double n, int prc) {
			return n*((double) (prc)/100);
		}
		// - Decimal (e.g 0.3 as 30%)
		public static double getPercentage(double n, double prc) {
			return n*prc;
		}
		
		/* next */
		
		// Absolute value
		// - Integer
		public static int getAbs(int n) {
			if (n >= 0) {return n;}
			return -n;
		}
		// - Double
		public static double getAbs(double n) {
			if (n >= 0) {return n;}
			return -n;
		}
		
		
		/*
		 * POWERS AND RELATED
		 */
		
		
		// Square Root
		public static double getSqrt(double n) {
			double epsilon = 1.0E-30;
			int numberOfIter = 0;
			double root = n;
			while (getAbs(n - root*root) > epsilon && numberOfIter < 5000000) {
				root = (root + n/root)/2;
				numberOfIter++;
			}
			return root;
		}
		
		/* next */
		
		// Power
		// - Integer exponent
		public static double getPower(double base, int exponent) {
			double power = 1;
			while (exponent > 0) {
				power *= base;
				exponent--;
			}
			return power;
		}
		
		/*
		 * 	Exponential function: e^x
		 * 	TODO: Relative error (see ExpTest) is kept to the magnitude of 10^(-15)
		 * 	however, absolute error (specified as delta) become higher and higher as
		 * 	exponent increases!! We should improve this function, but it is not such
		 * an easy task!
		 */
		public static double getExponential(double x) {
			/*
			 * 	We start from the fact that:
			 * 	e^x = e^floor(x) * e^real(x)
			 */
			// We find e^floor(x):
			double integerPart;
			integerPart = getPower(Math.E, (int) (x));
			x -= (int) (x);
			if (x == 0) {
				return integerPart;
			}
			/*
			 * 	To find e^real(x), we recall:
			 * 	e^real(x) = y <--> real(x) = ln(y) <--> ln(y) - real(x) = 0
			 * 	Calling g(y) = ln(y) - real(x) --> g'(y) = 1/y
			 * 	We seek such y using Newton tangent method
			 */
			double y = 1.6487212707001282; // e^0.5
			double epsilon = 0.000000000001;
			while (getAbs(getNatLog(y) - x) > epsilon) {
				y = y - y*(getNatLog(y) - x);
			}
			return integerPart*y;
			
		}
		// Let, with the same intuition as above, compute a^b with both double:
		public static double getPower(double a, double b) {
			/*
			 * 	We start from the fact that:
			 * 	a^b = a^floor(b) * a^real(b)
			 */
			// We find a^floor(b):
			double integerPart;
			integerPart = getPower(a, (int) (b));
			b -= (int) (b);
			if (b == 0) {
				return integerPart;
			}
			/*
			 * 	To find e^real(x), we recall:
			 * 	a^real(b) = z <--> real(b) = log_a(y) <--> log_a(y) - real(b) = 0
			 * 	Calling g(y) = log_a(y) - real(b) --> g'(y) = 1/(y*ln(a))
			 * 	We seek such y using Newton tangent method
			 */
			double z = a/5; // starting point
			double epsilon = 0.000000000001;
			while (getAbs(getBaseLog(a, z) - b) > epsilon) {
				z = z - (getBaseLog(a, z) - b)*(z*getNatLog(a));
			}
			return integerPart*z;
			
		}
	
		/* next */
		
		// Logarithm:
		// - Natural logarithm
		public static double getNatLog(double x) {
			double minimumS = 4294967296.0;
			int precision = 1;
			while (x*getPower(2, precision) <= minimumS) {
				precision ++;
			}
			double s = x*getPower(2, precision);
			return (Math.PI/(2*performAgm(1, 4/s)) - ((double) (precision)*0.6931471805599453));
		}
		// - Log given a certain base:
		public static double getBaseLog(double base, double x) {
			return getNatLog(x)/getNatLog(base);
		}
		
		/*
		 * SORTING
		 */
		
		// Quick sort
		// - Loosing your original vector:
		public static void getArraySorted(double[] array) {
			quickSort(array, 0, array.length -1);
		}
		// Preserving your original vector:
		public static double[] getSortedArray(double[] array) {
			double[] localArray = performCopy(array);
			quickSort(localArray, 0, array.length -1);
			return localArray;
		}
		private static void quickSort(double[] array, int left, int right) {
			if (left >= right) {
				return;
			}
			double pivot = array[left + (right-left)/2]; // Preventing overflow
			int index = partition(array, left, right, pivot);
			quickSort(array, left, index-1);
			quickSort(array, index, right);
		}
		private static int partition(double[] array, int left, int right, double pivot) {
			while (left <= right) {
				while (array[left] < pivot) {
					left++;
				}
				while (array[right] > pivot) {
					right--;
				}
				if (left <= right) {
					swap(array, left, right);
					left++;
					right--;
				}
			}
			return left;
		}
		private static void swap(double[] array, int left, int right) {
			double memorize = array[right];
			array[right] = array[left];
			array[left] = memorize;
		}
		
		/*
		 * AUXILIARY FUNCTIONS
		 */
		
		// Arithmetic - Geometric mean
		public static double performAgm(double x, double y) {
			double a_n = x;
			double g_n = y;
			double store;
			while(getAbs(a_n - g_n) >= 1.0E-15) {
				store = a_n;
				a_n = (a_n + g_n) / 2.0;
				g_n = getSqrt(store*g_n);
			}
			return a_n;
		}
		// Power with long exponent
		// - Integer exponent
		public static double getPower(double base, long exponent) {
			double power = 1;
			while (exponent > 0) {
				power *= base;
				exponent--;
			}
			return power;
		}
		
		// Vector scalar addition
		// given an array v and a scalar b
		// it returns v1 where v1[i] = v[i] + b
		public static double[] performScalarSum(double[] v, double b) {
			double[] a = new double[v.length];
			for (int i = 0; i < v.length; i++) {
				a[i] = v[i];
			}
			for (int i = 0; i < v.length; i++) {
				a[i] = a[i] + b;
			}
			return a;
		}
		// Vector element-wise power
		// given an array v and an integer b
		// it returns v1 where v1[i] = v[i]^b
		public static double[] performArrayEWPower(double[] v, int b) {
			double[] a = new double[v.length];
			for (int i = 0; i < v.length; i++) {
				a[i] = v[i];
			}
			for (int i = 0; i < v.length; i++) {
				a[i] = getPower(a[i], b);
			}
			return a;
		}
		// Perform a copy of an array
		public static double[] performCopy(double[] array) {
			double[] localArray = new double[array.length];
			for (int i = 0; i < array.length; i++) {
				localArray[i] = array[i];
			}
			return localArray;
		}
}
