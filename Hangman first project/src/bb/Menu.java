package bb;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Menu {

	Input new1= new Input();
	public char print1() {
		char str1;
	
		Scanner sc= new Scanner(System.in);
		System.out.println("MAIN MENU\r\n"
				+ "- Start a new Game (N)\r\n"
				+ "- Statistics (S)\r\n"
				+ "- Exit (E)"
				 );
		
		while(true) {
			System.out.print("Please enter your choice: ");
			str1= sc.next().charAt(0);
		   if (Character.isLetter(str1) && Character.isLetter(str1)) {
			   str1=Character.toUpperCase(str1);
			   if(str1=='N' || str1=='E' || str1=='S') {
				   break;}
				   else {System.out.println("Invalid input. Please enter a valid letter.");}
			
		   } else {
	            System.out.println("Invalid input. Please enter a valid letter.");
	        }}
			
		
		return str1;}
	Random random = new Random();
    
	
    public int Get_number() {
        int randomNumber = random.nextInt(50); // generate random numbers from 0-49
       return randomNumber;
    }
    
    public void statistics(int plays,int loses,int wins) {
    	System.out.println("Statistics");
		System.out.println("You have played so far "+plays+" games. You won "+wins+" times and lost "+loses+" times.");
		
		
	}
    
    
//    public String get_string(LinkedList<Character> L)
//    {
//    	StringBuilder charactersStringBuilder = new StringBuilder();
//    	for (char c : L) {
//		    charactersStringBuilder.append(c);
//		}
//
//		String charactersString = charactersStringBuilder.toString();
//		return charactersString;
//    	
//    }
//	
    
    
	public String getWord(int index) {
	    switch (index) {
	        case 0: return "UNIVERSITY";
	        case 1: return "COMPUTER";
	        case 2: return "LAPTOP";
	        case 3: return "HEADPHONES";
	        case 4: return "FUZZY";
	        case 5: return "DOG";
	        case 6: return "KEYHOLE";
	        case 7: return "TELEPHONE";
	        case 8: return "PRINTER";
	        case 9: return "BUILDING";
	        case 10: return "CAR";
	        case 11: return "GUITAR";
	        case 12: return "PIZZA";
	        case 13: return "SUNSHINE";
	        case 14: return "BEACH";
	        case 15: return "WATERMELON";
	        case 16: return "LIBRARY";
	        case 17: return "MOUNTAIN";
	        case 18: return "OCEAN";
	        case 19: return "CAMERA";
	        case 20: return "HAMBURGER";
	        case 21: return "FIREWORKS";
	        case 22: return "SUNGLASSES";
	        case 23: return "SWIMMING";
	        case 24: return "JUICE";
	        case 25: return "BICYCLE";
	        case 26: return "BANANA";
	        case 27: return "PINEAPPLE";
	        case 28: return "ELEPHANT";
	        case 29: return "TIGER";
	        case 30: return "RAINBOW";
	        case 31: return "DOLPHIN";
	        case 32: return "VOLCANO";
	        case 33: return "ZEBRA";
	        case 34: return "FISH";
	        case 35: return "HELICOPTER";
	        case 36: return "DRAGON";
	        case 37: return "ROCKET";
	        case 38: return "BUTTERFLY";
	        case 39: return "SPACESHIP";
	        case 40: return "SATELLITE";
	        case 41: return "HURRICANE";
	        case 42: return "SUNFLOWER";
	        case 43: return "BEE";
	        case 44: return "TORNADO";
	        case 45: return "RAINBOW";
	        case 46: return "MOON";
	        case 47: return "ECLIPSE";
	        case 48: return "PARROT";
	        case 49: return "KOALA";
	        default: return "Illegal index";
	    }
	}
	
}
