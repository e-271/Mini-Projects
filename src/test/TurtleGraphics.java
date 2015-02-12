import java.util.Scanner;

class TurtleGraphics {
	
	private static int turtleRow = 0, turtleCol = 0;
	private static boolean penDown = false;
	private static int[][] floor = new int[20][20];

	public static void main( String[] args ) {
		
		for( int m = 0 ; m < floor.length ; m++ ) {
			for( int n = 0 ; n < floor[m].length ; n++ )
				floor[m][n] = 0;
		}
		
		System.out.printf("TURTLE GRAPHICS%n%nCommands:" +
						  "%n1 Pen up or down %n2 Move" +
						  "%n3 Display the 20-by-20 array %n9 End%n");
		Scanner scan = new Scanner(System.in);
		
		int choice = scan.nextInt();
		while( choice != 9 ) {
			switch( choice ) {
			case 1: 
				penSwitch();
				break;
			case 2:
				System.out.print("Enter lowercase cardinal direction and number of spaces: ");
				String direction = scan.next();
				int distance = scan.nextInt();
				draw( distance , direction );
				break;
			case 3:
				display(floor);
				break;
			default:
				System.out.printf("Commands:%n1 Pen up or down %n2 Move%n3 Display the 20-by-20 array %n9 End%n");
				break;
			}
			choice = scan.nextInt();
		}
		
		
	}
	
	public static void draw( int distance , String direction ) {
		
		switch( direction ) {
		case "north": 
			if( distance + turtleRow < 20 ) {
				 
				if( penDown ) {
					for( int m = turtleRow ; m <= turtleRow + distance ; m++ )
						floor[m][turtleCol] = 1;
				}
				turtleRow += distance;
							
				break;
			}
		case "east":
			if( distance + turtleCol < 20 ){
				if( penDown ) {
					for( int n = turtleCol ; n <= turtleCol + distance ; n++ )
						floor[turtleRow][n] = 1;
				}
				turtleCol += distance; 
				break;
			}
		case "south": 
			if( turtleRow - distance >= 0) {
				if( penDown ) {
					for( int m = turtleRow ; m >= turtleRow - distance ; m-- )
						floor[m][turtleCol] = 1;
				}
				turtleRow -= distance; 
				break;
			}
		case "west": 
			if( turtleCol - distance >= 0 ) {
				if( penDown ) {
					for( int n = turtleCol ; n >= turtleCol - distance ; n-- )
						floor[turtleRow][n] = 1;
				}
				turtleCol -= distance; 
				break;
			}
		default: System.out.println("Error: You hit a wall! Turtle returns to its previous position.");
		}
	}
	
	public static void penSwitch() {
		if( penDown ) {
			penDown = false;
			System.out.println("Pen up.");
		}
		else {
			penDown = true;
			System.out.println("Pen down.");
		}
	}

	
	public static void display( int[][] array ) {
		for( int m = 0 ; m < array.length ; m++ ) {
			for( int n = 0 ; n < array[m].length ; n++ ) {
				
				if( array[m][n] == 0 )
					System.out.print("   ");
				else
					System.out.print(" * ");
			}
			System.out.println();		
			}
	}
}