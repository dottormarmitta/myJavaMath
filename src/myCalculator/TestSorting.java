package myCalculator;

public class TestSorting {

	public static void main(String[] args) {
		
		// Build a random array
		int n = 5;
		double[] array = new double[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) ((Math.random() * (1 + 1 + 1) + -1)*50);
		}
		
		// Get it sorted
		System.out.println("My original array is: ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println();
		Calculator.getArraySorted(array);
		System.out.println("My sorted array is: ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
