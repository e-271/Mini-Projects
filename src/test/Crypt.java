package Crypt;
import java.util.Scanner;

public class Crypt{
	public static void main( String[] args ) {
		Crypt crypt = new Crypt();
		Scanner input = new Scanner(System.in);

		System.out.print("Enter an integer to be encoded: ");
		int num = input.nextInt();
		int encrypted = crypt.encode( num );
		int decrypted = crypt.decode( encrypted );
		System.out.printf("Encoded number: %d%nDecoded number: %d" , encrypted , decrypted );
	}
	
	int encode( int num ) {
		boolean odd = false , Switch = true;
		int digit , crypt = 0, place = 1;
		
		if ( (int)Math.log10(num) % 2 == 0 )
			odd = true;

		while( num / place > 0 ){
			digit = ( num % ( place * 10 ) ) / place;
			digit = (digit + 7 ) % 10;
			
				if( odd == true && num / place < 10) {
					crypt += digit * place;
					break;
				}
				if( Switch == true ) {
					crypt += digit * place * 10;
					Switch = false;
				}
				else {
					crypt += digit * place / 10;
					Switch = true;
				}
			place *= 10;
			int test = num / place;
		}
		
		return crypt;
		

		}

	int decode( int num ) {
		boolean odd = false , Switch = true;
		int digit , decrypt = 0 , place = 1;
		
		if( (int)Math.log10(num) % 2 == 0 )
			odd = true;
		
		while(  num / place > 0  ) {
			digit = ( num % ( place * 10 ) ) / place;
			digit = ( digit + 3 ) % 10 ;
			
			if( odd == true && num / place < 10) {
				decrypt += digit * place;
				break;
			}
			if( Switch == true ) {
				decrypt += digit * place * 10;
				Switch = false;
			}
			else {
				decrypt += digit * place / 10;
				Switch = true;
			}
		place *= 10;	
		}
		return decrypt;
	}
}
