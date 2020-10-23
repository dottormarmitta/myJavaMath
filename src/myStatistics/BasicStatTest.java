package myStatistics;


public class BasicStatTest {

	public static void main(String[] args) {
		// Let us create an array:
		double[] data = {0.003, 1.92, 0.000432, 3.53, 2, 0.0323232, 0.0001, 0.001, 1.2321, 0.32143, 0.0000034, 1.21213, 10, 11.34234, 0.00012, 
				-0.02302, -11, -23.329932, -0.3023, -4.3232, 5.5343, 2.34343, -7.543232,0.403043, 0.004, 3.546532, -3.431313, 2.5432324, 
				0.0004, 0.003, 0.0003, 0.00435, 3.234, 2.14, -7.32341, -6.3231,2.3434, -0.0000432, -0.032, 9.342, -5.342, 2, -6.342, 3.432,
				3.546};
		System.out.println("Numpy mean is: " + "-0.07334631555555553" );
		System.out.println("Our mean is:   " + Statistics.getMean(data));
		System.out.println();
		System.out.println("Numpy sample variance is: " + "30.869194618566112" );
		System.out.println("Our sample variance is:   " + Statistics.getVariance(data));
		System.out.println();
		System.out.println("Numpy sdev is: " + "5.5560052752464255" );
		System.out.println("Our sdev is:   " + Statistics.getStdev(data));
		System.out.println();
		System.out.println("Numpy median is: " + "0.004" );
		System.out.println("Our median is:   " + Statistics.getMedian(data));
		System.out.println();
		System.out.println("Data insert are left untouched. See data header:" );
		for (int i = 0; i < 6; i++) {
			System.out.print(data[i] + " ");
		}
		
	}

}
