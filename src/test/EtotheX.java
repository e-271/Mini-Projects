import java.util.Scanner;

public class EtotheX {
	public static void main( String[] args ) {
		Scanner scan = new Scanner(System.in);
		double eX = 0;
		System.out.println("This program approximates the value of e ^ x.");
		System.out.println("Please input an integer for x, followed by an integer for degree of accuracy.");
		int x = scan.nextInt();
		int acc = scan.nextInt();
		 for( int n = 0 ; n <= acc ; n++)
			 eX += (double)power( x , n ) / factorial( n );
		 System.out.printf( "e ^ %d = %f" , x , eX );

	}
	
	public static int power( int base , int exp ) {
		int result = 1;
		for( int i = 1; i <= exp; i++ )
			result *= base;
		return result;
	}
	
	public static long factorial( int n ){
		long fact = 1;
		for( int i = n ; i > 1 ; i--)
			fact *= i;
		return fact;
	}
}