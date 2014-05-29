package dale.highlow.game;


/**
 * This represents a team of 2 HighLow Players, holds their names, the Team name, and
 * Game Scores
 * 
 * 
 * @author dale.macdonald
 *
 */
//TODO Pull out interface, perhaps
public class HighLowTeam {

	private String teamName;
	
	public Player[] players = new HighLowPlayer[2];
	
	public int score;

	
	public HighLowTeam(String teamName) {
		this.teamName = teamName;
	}
	
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Player[] getPlayers() {
		return players;
	}
	

	public Player getPlayer(int playerNum) {
		return players[playerNum];
	}
	
	public void setPlayer(int playerNum, Player player) {
		players[playerNum] = player;
	}
		
	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString() {
		return teamName;
	}
}
