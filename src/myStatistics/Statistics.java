package myStatistics;
import myCalculator.Calculator;

public class Statistics {
	
	/*
	 * 	Basic descriptive statistic
	 */
	
	// Mean:
	public static double getMean(double[] data) {
		double sum = Calculator.getSum(data);
		return sum/data.length;
		
	}
	
	// Median (without altering original array)
	public static double getMedian(double[] data) {
		int n = data.length;
		double[] localData = new double[n];
		for (int i = 0; i < n; i++) {
			localData[i] = data[i];
		}
		Calculator.getArraySorted(localData);
		if (n%2 != 0) {
			return localData[n/2];
		} else {
			int indexLeft = n/2;
			int indexRight = indexLeft - 1;
			return (localData[indexLeft] + localData[indexRight])/2 ;
		}
	}
	
	
	// Sample Variance:
	public static double getVariance(double[] data) {
		if (data.length == 1) {
			return 0;
		}
		double mean = getMean(data);
		double[] localData = Calculator.performScalarSum(data, -mean);
		localData = Calculator.performArrayEWPower(localData, 2);
		double sum = Calculator.getSum(localData);
		return sum/(localData.length - 1);
	}
	
	// Sample standard deviation:
	public static double getStdev(double[] data) {
		double variance =  getVariance(data);
		double stdev = Calculator.getSqrt(variance);
		return stdev;
	}
	
	// TODO: Geometric mean
	
	// TODO: Curtosi
	
}
