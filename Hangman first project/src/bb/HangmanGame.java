package bb;

public class HangmanGame  {
	    private int wins = 0;
	    private int losses = 0;
	    private int plays = 0;
	    
	    public void play() {
	        while (true) {
	            Menu menu = new Menu();
	            char choice = menu.print1();
	            
	            if (choice == 'S') {
	                menu.statistics(plays, losses, wins);
	            } else if (choice == 'E') {
	                System.out.println("The game is over!");
	                break;
	            } else if (choice == 'N') {
	                Game game = new Game();
	                game.playGame();
	                
	                if (game.isGameWon()) {
	                    wins++;
	                } else {
	                    losses++;
	                }
	                
	                plays++;
	            }
	        }
	    }
	
}
