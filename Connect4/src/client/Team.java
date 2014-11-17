package client;

import java.util.ArrayList;

public class Team {
	private int teamID;
	private static int lastID = -1;
	private ArrayList<Player> players;
	
	public Team()
	{
		teamID=lastID+1;
		players = new ArrayList<Player>();
	}
	
	public ArrayList<Player> getPlayers()
	{
		return players;
	}
	
	public int getID()
	{
		return teamID;
	}
	
	public void addPlayer(Player player)
	{
		players.add(player);
	}
}