package CreditValidation;
import java.util.Scanner;

public class CreditValidation {

	public static void main( String[] args ){
		CreditValidation valid = new CreditValidation();
		Scanner in = new Scanner(System.in);
		long cc;
		
		System.out.print("Enter a credit card number: ");
		cc = in.nextLong();
		
		if( valid.isValid(cc) ){
			System.out.printf( "%d is valid.", cc );
		}
		else{
			System.out.printf( "%d is not valid.", cc );
		}		
	}
	
	boolean isValid( long cc ) {
		long num = cc;
		int i;
		
		for( i = 1 ; num > 10 ; i++ ){
			num /= 10;
		}
		if( i < 13 || i > 16)
			return false;
		else if ( (sumOfEvenDigits(cc) + sumOfOddDigits(cc)) % 10 == 0 )
			return true;
		else
			return false;
	}
	
	int sumOfEvenDigits( long cc ){
		int sum = 0;
		
		while( cc > 0 ){
			cc /= 10;
			sum += (((cc % 10)*2) % 10) + (((cc % 10)*2) / 10);
			cc /= 10;
		}
		
		return sum;
	}
	
	int sumOfOddDigits( long cc ){
		int sum = 0;
		
		while( cc > 0 ){
			sum += cc % 10;
			cc /= 100;
		}
		return sum;
		
	}
}

