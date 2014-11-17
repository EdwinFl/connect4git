package client;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private Board board;
	public boolean RUNNING=true;
	private boolean won=false;
	private Scanner scanner;
	private ArrayList<Player> players;
	
	public Game()
	{
		scanner = new Scanner(System.in);
		players = new ArrayList<Player>();
		players.add(new Player("Henkie"));
		players.add(new Player("Jaap"));
		TUI tui = new TUI();
		board = new Board();
		tui.showWelcomeMessage();
		tui.showBoard(board);
		int input=0;
		
		while(RUNNING)
		{
			for(Player player:players)
			{
				tui.askMoveOfPlayer(player);
				input = scanner.nextInt();
				board.addDisc(input, player);
				tui.showBoard(board);
				RUNNING = !board.checkWin(player);
				if(!RUNNING)
				{
					break;
				}
			}
			RUNNING = !board.checkDraw();
		}
	}
	
	public static void main(String args[])
	{
		new Game();
	}
}
