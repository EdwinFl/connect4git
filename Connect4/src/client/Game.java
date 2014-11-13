package client;

public class Game {
	private Player p1;
	private Player p2;
	private Board board;
	
	public Game()
	{
		p1 = new Player("Henk");
		p2 = new Player("Piet");
		board = new Board();
		board.draw();
	}
	
	public static void main(String args[])
	{
		new Game();
	}
}
