package client;

public class TUI {
	public void showBoard(Board b)
	{
		b.draw();
	}

	public void showWelcomeMessage() 
	{
		System.out.println("Welcome to our game! \n\nYou can submit your move by typing a number from 1 to 7 corresponding to the rows of the board starting from the left.");
	}

	public void askMoveOfPlayer(Player player) 
	{
		System.out.println("It's " + player.getName() + "'s turn");
		System.out.println("Please make your move...");
	}
}
