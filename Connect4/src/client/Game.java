package client;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private Board board;
	public boolean running;
	private boolean won;
	private Scanner scanner;
	private ArrayList<Player> players;
	private Team team1;
	private Team team2;
	
	public Game()
	{
		running = true;
		won=false;
		scanner = new Scanner(System.in);
		players = new ArrayList<Player>();
		players.add(new Player("Henkie"));
		players.add(new Player("Jaap"));
		players.add(new Player("Henkie2"));
		players.add(new Player("Jaap2"));
		
		TUI tui = new TUI();
		board = new Board();
		tui.showWelcomeMessage();
		tui.showBoard(board);
		int input=0;
		
		while(running)
		{
			for(Player player:players)
			{
				tui.askMoveOfPlayer(player);
				input = scanner.nextInt();
				board.addDisc(input, player);
				tui.showBoard(board);
				running = !board.checkWin(player);
				if(!running)
				{
					break;
				}
			}
			running = !board.checkDraw();
		}
	}
	
	public static void main(String args[])
	{
		new Game();
	}
}
