package myCalculator;

import java.util.Arrays;

public class SumTest {

	public static void main(String[] args) {
		/*
		 *  Let us have 100,000,000 observations all with the same
		 *  value. Say the value is 47.0047
		 *  We sure expect the mean to be 47.0047
		 *  Let us approach the problem in a trivial way and then using our
		 *  compensated sum formula
		 */
		double y = 47.0047;
		int n = 100000000;
		double[] array = new double[n];
		Arrays.fill(array, y);
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		System.out.println("Trivial sum is:  " + sum);
		System.out.println("My comp. sum is: " + Calculator.getSum(array));
		System.out.println();
		System.out.println("Trivial mean is:  " + (sum/n) + " which is distant from 47.0047 by: " 
				+ Calculator.getAbs(sum/n - y));
		System.out.println("My comp. mean is: " + (Calculator.getSum(array)/n) + " which is distant from 47.0047 by: " 
				+ Calculator.getAbs(Calculator.getSum(array)/n - y));
	}

}
