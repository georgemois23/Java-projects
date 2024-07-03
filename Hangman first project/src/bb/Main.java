package bb;


public class Main {

	public static void main(String[] args) {
		HangmanGame hang=new HangmanGame();
		hang.play();
		
	}}
		/*Menu Menu1= new Menu();
		
		
		
//		System.out.println(word);
//		System.out.println(word.length());
		
		int wins=0; //total wins of games
		int trueguess=0;
		int loses=0; //total lost of games
		int plays=0; //total plays of games
		boolean wordfound = false; 
		int notfound = 0;
		int guess = 0; 
		int tries;
//		Scanner sc1= new Scanner(System.in);
//		Random random = new Random();
		Input newInput= new Input();
		Character str1; //the guess of user
		
		while(true) {
			trueguess=0; //count every char that exists in the word
//			create two parallel linked lists  
			 LinkedList<Character> charactersList = new LinkedList<>(); //contains the word
			 LinkedList<Character> underscoresList = new LinkedList<>(); //contains the word with (-)
		char menuu=Menu1.print1();		
		if(menuu=='S') { //statistics
			Menu1.statistics(plays, loses, wins);
			
		}
//		if(Menu1.print1().equals("E")) break;
//		if(Menu1.print1().equals("N")) break;
		
		if(menuu=='E') { //exit
			System.out.println("The game is over!");
			break;
		
		}
		if(menuu=='N') { //new game
			 tries=8;
			 guess=0; //how many times a character is in the word 
			
			String word = Menu1.getWord(Menu1.Get_number());
//			System.out.println(word); //delete it after
			
			//fill the charlist with every char separately
			for (char c : word.toCharArray()) {
			    charactersList.add(c);
			    underscoresList.add('-');
			}
//			System.out.println("The word is: "+Menu1.get_string(charactersList)); //delete it after 
			wordfound=false;
			notfound=0;
			plays++;
			while(tries>0 && wordfound==false) {
		System.out.println("The random word is now: "+Menu1.get_string(underscoresList));	
		System.out.println("You have "+tries+" guesses left.");	
		str1= newInput.Get_char(); //get user's guess
//		System.out.println(str1);
		

		
		
			
		boolean found = false;
		int x=0;
        for (char c : charactersList) {
            if (c == str1) {
                found = true; //if a char exists in the word
                trueguess++; //count the total correct chars
                underscoresList.set(x, c);  //put the char that the user found from the charlist to the list with the (-)
                
                
            }         
            x++;}
        
        if (found==true) { //if the user's guess is correct
        	System.out.println("The guess is CORRECT!");
        	guess++;
        }
        if (found==false) { //not correct guess
        	tries--;
        	notfound++;
        	System.out.println("There are no "+str1+"’s in the word.");
        
        }
//        System.out.println("Guesses correct: "+trueguess+" Size: "+charactersList.size());
        if (trueguess==charactersList.size()) { //if the total correct chars from user's guess is equal to the size of the list
        	wordfound=true;
        	break;
        }}
			
       // System.out.println(charactersList);
//		System.out.println("The random word is now: "+Menu1.get_string(underscoresList));}
//		 Boolean xy = charactersList.equals(underscoresList);   
//	        System.out.println("Same: " + xy);
//        System.out.println(tries);
//		System.out.println(charactersList);
//		System.out.println(underscoresList);
//		underscoresList.set(0, charactersList.get(0));
//		System.out.println(charactersList.get(0));
//		System.out.println(underscoresList.get(0));
			
		if (wordfound==true) { //if the word is correct 
//			System.out.println("The guess is CORRECT!");
			System.out.println("Congratulations! You guessed the word: "+Menu1.get_string(charactersList));
			System.out.println("You made "+guess+" correct guesses and "+notfound+" wrong guesses.");
			wins++;
			
		}
		else { //if the word is incorrect 
			System.out.println("Unfortunately you did not guess the word: "+Menu1.get_string(charactersList));
			loses++;
		}}
		}}



}*/
		
		