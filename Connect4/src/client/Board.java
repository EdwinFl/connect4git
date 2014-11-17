package client;

public class Board {
	private int[][] board;
	public static final int[][] BOARD_INIT = {{0,0,0,0,0,0,0},
											  {0,0,0,0,0,0,0},
											  {0,0,0,0,0,0,0},
											  {0,0,0,0,0,0,0},
											  {0,0,0,0,0,0,0},
											  {0,0,0,0,0,0,0}};
	
	private int lastMoveX;
	private int lastMoveY;
	
	public Board()
	{
		board = BOARD_INIT;
	}
	
	public void draw()
	{
		for(int i=0;i<board.length;i++)
		{
			String output = "";
			for(int j=0;j<board[i].length;j++)
			{
				output+=board[i][j] + "\t";
			}
			System.out.println(output);
		}
	}
	
	public void addDisc(int row, Team t)
	{
		for(int i=board.length;i>0;i--)
		{
			if(board[i-1][row-1]== 0)
			{
				board[i-1][row-1] = t.getDisc().getDiscNumber();
				i=0;
				lastMoveY = i-1;
				lastMoveX = row-1;
			}
		}
	}

	public boolean checkWin(Team t) 
	{
		boolean win = false;
		Disc d = t.getDisc();
		
		int number = d.getDiscNumber();
		if(	board[lastMoveY][lastMoveX-1] == number 
			&& board[lastMoveY][lastMoveX-2] == number
			&& board[lastMoveY][lastMoveX-3] == number)
		{
			win = true;		
		}
		
		
		return win;
	}
	
	public boolean checkDraw()
	{
		boolean draw = true;
		for(int i=0;i<board[0].length;i++)
		{
			if(board[0][i] == 0)
			{
				draw = false;
			}
		}
		
		return draw;
	}
}
