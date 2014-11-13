package client;

public class Disc {
	public static int firstDiscAvailable = 1;
	private int disc;
	
	public Disc()
	{
		disc = firstDiscAvailable;
		firstDiscAvailable++;
	}
	
	public int getDiscNumber()
	{
		return disc;
	}
}
