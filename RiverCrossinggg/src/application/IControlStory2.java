package application;

public interface IControlStory2 {

	public void setCounter(int c, ICrosser crosser);

	public boolean isOnBoat(ICrosser crosser);

	public boolean isSheepOnBoat(Herbivorous crosser);

	public boolean validateMove(ICrosser crosser);

	public void moveCrosser(ICrosser crosser);

	public boolean removeRight(ICrosser crosser);

	public boolean removeLeft(ICrosser crosser);

	public int getcF1();

	public int getcF2();

	public int getcF3();

	public int getcF4();

	public void setcF1(int cF1);

	public void setcF2(int cF2);

	public void setcF3(int cF3);

	public void setcF4(int cF4);

	public int getMoves(ICrosser crosser);

	public void setMoves(int moves);
}
