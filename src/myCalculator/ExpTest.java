package myCalculator;

public class ExpTest {
	
	public static void main(String[] args) {
		double x = Math.random()*40;
		System.out.println("x is equal to: " + x);
		double e_x = Math.pow(Math.E, x);
		double mye_x = Calculator.getExponential(x);
		System.out.println("True e^x: " + e_x);
		System.out.println("My e^x:   " + mye_x);
		System.out.println("The delta is: " + (Calculator.getAbs(e_x - mye_x)));
		System.out.println("Relative error is " + (Calculator.getAbs(mye_x - e_x)/e_x));
		System.out.println();
		double y = Math.random()*40;
		System.out.println("a is equal to: " + y);
		double mya_b = Calculator.getPower(y, x);
		double a_b = Math.pow(y, x);
		System.out.println("True a^x is: " + a_b);
		System.out.println("My a^x is:   " + mya_b);
		System.out.println("The delta is: " + (Calculator.getAbs(mya_b - a_b)));
		System.out.println("Relative error is " + (Calculator.getAbs(mya_b - a_b)/a_b));
		System.out.println();
			
	}

}
