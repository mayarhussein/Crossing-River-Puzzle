package application;

public interface IControlStory2 {

	public void setCounter(int c, Farmer f);
	public void moveFarmer(Farmer f);
	public boolean isOnTheBoat(Farmer f);
	public boolean validateMove(Farmer f);
	
	public boolean removeRight(Farmer f);
	public boolean removeLeft(Farmer f);
	public int getcF1();
	public int getcF2();
	public int getcF3();
	public int getcF4();

	public void setcF1(int cF1);
	public void setcF2(int cF2);
	public void setcF3(int cF3);
	public void setcF4(int cF4);
	public int getMoves(Farmer f);
	public void setMoves(int moves);
}

