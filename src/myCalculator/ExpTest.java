package myCalculator;

public class ExpTest {
	
	public static void main(String[] args) {
		double x = Math.random()*40;
		System.out.println(x);
		System.out.println("True exponential is: " + Math.pow(Math.E, x));
		System.out.println("My exponential is:   " + Calculator.getExponential(x));
		System.out.println("The delta is: " + (Calculator.getAbs(Calculator.getExponential(x) - Math.pow(Math.E, x))));
		System.out.println("Relative error is " + (Calculator.getAbs(Calculator.getExponential(x) - Math.pow(Math.E, x))/Math.pow(Math.E, x)));
		System.out.println();
			
	}

}
