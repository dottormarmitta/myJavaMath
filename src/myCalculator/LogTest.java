package myCalculator;

public class LogTest {

	public static void main(String[] args) {
		double x = (Math.random()*1547);
		System.out.println("In the following we test my LOG functions");
		System.out.println();
		System.out.println("The number this time is: " + x);
		System.out.println("Natural logarithm test:");
		System.out.println("Delta is: " + Calculator.getAbs((Calculator.getNatLog(x) - Math.log(x))));
		//
		System.out.println();
		double base = (Math.random()*120);
		System.out.println("The base of the log this time is: " + base);
		System.out.println("Logarithm given base test:");
		System.out.println("Delta is: " + Calculator.getAbs(( Calculator.getBaseLog(x, base) - (Math.log(x)/Math.log(base)))));

	}

}
