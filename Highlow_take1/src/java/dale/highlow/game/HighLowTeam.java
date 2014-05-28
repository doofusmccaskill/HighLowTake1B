package dale.highlow.game;

import dale.highlow.cards.Player;

/**
 * This represents a team of 2 HighLow Players, holds their names, the Team name, and
 * Game Scores
 * 
 * 
 * @author dale.macdonald
 *
 */
public class HighLowTeam {

	private String teamName;
	
	public Player[] players = new String[2];
	
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

	public String[] getPlayers() {
		return players;
	}
	

	public void setPlayerOne(String player) {
		players[0] = 
	}
	public void setPlayers(String[] players) {
		this.players = players;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
