package client;

public class Player {
	private String name;
	private Disc disc;
	
	public Player(String name)
	{
		this.name = name;
		this.disc = new Disc();
	}
	
	public Disc getDisc()
	{
		return disc;
	}
}
