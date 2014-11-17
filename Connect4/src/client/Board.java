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
				
				lastMoveY = i-1;
				lastMoveX = row-1;
				i=0;
			}
		}
	}

	public boolean checkWin(Team t) 
	{
		boolean win = false;
		Disc d = t.getDisc();
		
		int number = d.getDiscNumber();
		int counter = 4;
		int counted = 1;
		boolean vert = false;
		int vSteps = 1;
		
		while(!vert && counted<counter) {
			if((lastMoveY + vSteps) > board.length-1){
			vert = true;
			} else {
				if(board[lastMoveY+vSteps][lastMoveX] == number){
					counted += 1;
					vSteps +=1;
					win = counted==counter;
				} else {
					vert = true;
					counted = 1;
				}
			}
		}
		
		if(win!=true){
			boolean horL = false;
			boolean horR = false;
			int hSteps = 1;
			while(!horR && counted<counter){
				if(!horL){
					if(board[lastMoveY][lastMoveX-hSteps] == number){
						counted += 1;
						hSteps +=1;
						win = counted==counter;
					} else {
						horL = true;
					}
				} else {
					if(board[lastMoveY][lastMoveX+hSteps] == number){
						counted += 1;
						hSteps +=1;
						win = counted==counter;
					} else {
						horR = true;
						counted = 1;
					}
				}
			}
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
