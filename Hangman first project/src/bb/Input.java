package bb;

import java.util.Scanner;

public class Input {
	public char Get_char() {
	char str1;
	Scanner sc1= new Scanner(System.in);
	while(true){
		System.out.print("Your guess: ");
		
			str1= sc1.next().charAt(0);
		   if (Character.isLetter(str1) && Character.isLetter(str1)) {
			   	break;
		   } else {
	            System.out.println("Invalid input. Please enter a valid letter.");
	        }
			}
		str1=Character.toUpperCase(str1);
		return str1;
		
	
}}
