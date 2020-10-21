package myStatistics;
import myCalculator.Calculator;

public class Statistics {
	
	/*
	 * 	Basic descriptive stat
	 */
	
	// Mean:
	public static double getMean(double[] data) {
		Calculator calculator = new Calculator();
		double mean = 0;
		double sum = Calculator.getSum(data);
		return sum/data.length;
		
	}
	// TODO: median
	// I guess sorting is needed
	
	// TODO: variance
	
	// TODO: standard deviation
	
	// TODO: Geometric mean
	
	// TODO: Curtosi
	
}
