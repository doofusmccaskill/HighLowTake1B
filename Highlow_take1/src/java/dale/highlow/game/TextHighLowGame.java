package dale.highlow.game;

import java.util.Scanner;

/**
 * A first attempt at a HighLow game for for players, no graphics, just Text 
 * Hands. This will be a first attempt and will reveal all hands - this will test out
 * the playability of the Object model.
 * 
 * @author dale.macdonald
 *
 */
public class TextHighLowGame {

	private HighLowTeam teamOne;
	private HighLowTeam teamTwo;
	
	public static void main(String[] args) {
		System.out.println("High Low Jack Game");
		System.out.println("Press 'Y' to start game, 'N' to quit");
		Scanner scanner = new Scanner(System.in);
		
		done:
		while (true) {
			String str = scanner.next();
			
			switch (str) {
				case "Y":
				case "y":
					break done;
				case "N":
				case "n":
					System.out.println("Exiting game!");
					System.exit(0);
			}
		}
		System.out.println("Starting game...");
		TextHighLowGame game = new TextHighLowGame();
		
		
	}
	
	private TextHighLowGame() {
		setUpTeams();
	}
	
	private void setUpTeams() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type first team's name:");
		String str = scanner.nextLine();
		teamOne = new HighLowTeam(str);
		
		System.out.println("Type first player's name:");
		String player = scanner.nextLine();
	}
}
