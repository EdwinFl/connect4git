package client;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private Board board;
	public boolean running;
	private boolean won;
	private Scanner scanner;
	private ArrayList<Player> players;
	private ArrayList<Team> teams;
	
	public Game()
	{
		running = true;
		won=false;
		scanner = new Scanner(System.in);
		players = new ArrayList<Player>();
		teams = new ArrayList<Team>();
		teams.add(new Team());
		teams.add(new Team());
		players.add(new Player("Henkie"));
		players.add(new Player("Jaap"));
		players.add(new Player("Henkie2"));
		players.add(new Player("Jaap2"));
		teams.get(0).addPlayer(players.get(0));
		teams.get(0).addPlayer(players.get(2));
		teams.get(1).addPlayer(players.get(1));
		teams.get(1).addPlayer(players.get(3));
		
		TUI tui = new TUI();
		board = new Board();
		tui.showWelcomeMessage();
		tui.showBoard(board);
		int input=0;
		
		while(running)
		{
			for(Team team:teams)
			{
				for(Player player:team.getPlayers())
				{
					tui.askMoveOfPlayer(player);
					input = scanner.nextInt();
					board.addDisc(input, team);
					tui.showBoard(board);
					running = !board.checkWin(team);
					System.out.println(running);
					if(!running)
					{
						break;
					}
				}
				if(!running)
				{
					break;
				}
			}
			//running = !board.checkDraw();
		}
	}
	
	public static void main(String args[])
	{
		new Game();
	}
}
