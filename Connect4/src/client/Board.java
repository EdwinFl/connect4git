package client;

public class Board {
	private int[][] board;
	public static final int[][] BOARD_INIT = {{0,0,0,0,0,0,0},
											  {0,0,0,0,0,0,0},
											  {0,0,0,0,0,0,0},
											  {0,0,0,0,0,0,0},
											  {0,0,0,0,0,0,0},
											  {0,0,0,0,0,0,0}};
	
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
	
	public void addDisc(int row, Player p)
	{
		for(int i=board.length;i>0;i--)
		{
			System.out.println(i);
			if(board[i-1][row-1]== 0)
			{
				board[i-1][row-1] = p.getDisc().getDiscNumber();
				i=0;
			}
		}
	}

	public boolean checkWin(Player p) 
	{
		return false;
	}
	
	public boolean checkDraw()
	{
		boolean draw = true;
		for(int i=0;i<board[0].length;i++)
		{
			if(board[board.length-1][i] == 0)
			{
				draw = false;
			}
		}
		
		return draw;
	}
}
