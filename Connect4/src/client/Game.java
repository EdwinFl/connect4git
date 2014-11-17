package client;

public class Game {
	private Player p1;
	private Player p2;
	private Board board;
	
	public Game()
	{
		p1 = new Player("Henk");
		p2 = new Player("Piet");
		TUI tui = new TUI();
		board = new Board();
		tui.showBoard(board);
	}
	
	public static void main(String args[])
	{
		new Game();
	}
}
