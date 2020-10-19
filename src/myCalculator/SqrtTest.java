package myCalculator;

public class SqrtTest {

	public static void main(String[] args) {
		double x = (Math.random()*1547);
		System.out.println("In the following we test my SQRT functions");
		System.out.println();
		System.out.println("The number this time is: " + x);
		System.out.println("SQRT test:");
		System.out.println("Delta is: " + Calculator.getAbs((Calculator.getSqrt(x) - Math.sqrt(x))));
	}

}
