package bb;

import java.util.LinkedList;

public class Game {
	private LinkedList<Character> charactersList;
    private LinkedList<Character> underscoresList;
    private String word;
    private int tries = 8;
    private int trueguess = 0;
	Input newInput= new Input();;
	Menu Menu1= new Menu();
    
    public void playGame() {
        initializeGame();
        
        while (tries > 0) {
            System.out.println("The random word is now: " + getWordDisplay());
            System.out.println("You have " + tries + " guesses left.");
            char guess = newInput.Get_char();
            
            boolean found = processGuess(guess);
            
            if (found) {
                System.out.println("The guess is CORRECT!");
            } else {
                tries--;
                System.out.println("There are no " + guess + "’s in the word.");
            }
            
            if (trueguess == charactersList.size()) {
                System.out.println("Congratulations! You guessed the word: " + word);
                return;
            }
        }
        
        System.out.println("Unfortunately you did not guess the word: " + word);
    }
    public boolean isGameWon() {
        return trueguess == charactersList.size();
    }
    
    private void initializeGame() {
        Menu menu = new Menu();
        word = Menu1.getWord(menu.Get_number());
        charactersList = new LinkedList<>();
        underscoresList = new LinkedList<>();
        
        for (char c : word.toCharArray()) {
            charactersList.add(c);
            underscoresList.add('-');
        }
        
        trueguess = 0;
        tries = 8;
    }
    
    private String getWordDisplay() {
        StringBuilder display = new StringBuilder();
        for (char c : underscoresList) {
            display.append(c);
        }
        return display.toString();
    }
    
    private boolean processGuess(char guess) {
        boolean found = false;
        int index = 0;
        
        for (char c : charactersList) {
            if (c == guess) {
                found = true;
                trueguess++;
                underscoresList.set(index, c);
            }
            
            index++;
        }
        
        return found;
    }
   

}
