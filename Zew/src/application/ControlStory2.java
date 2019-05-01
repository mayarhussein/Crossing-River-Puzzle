package application;
import java.util.Stack;

public class ControlStory2 extends Controller {
	
	
	private static ControlStory2 c2 = null;

	private ControlStory2() {
	}

	public static ControlStory2 getControlStory1() {
		if (c2 == null)
			return c2 = new ControlStory2();
		return c2;
	}

	private Herbivorous herbivorous = Herbivorous.getHerbivorous();
	private Carnivorous carnivorous = Carnivorous.getCarnivorous();
	private Story2 s2 = Story2.getStory2();
	public static Stack<IButtonCommand> commandStack = new Stack<>();

	private int cF1, cF2, cF3, cF4, moves = 1;

	public void setCounter(int c, Farmer f) {
		if (f.equals(s2.getFarmer1()))
			setcF1(c);
		else if (f.equals(s2.getFarmer2()))
			setcF2(c);
		else if (f.equals(s2.getFarmer3()))
			setcF3(c);
		else if (f.equals(s2.getFarmer4()))
			setcF4(c);

	}

	public void moveFarmer(Farmer f) {
		int x = getMoves(f);
		x++;
		setCounter(x, f);
	}

	public boolean isOnTheBoat(Farmer f) {
		if (getMoves(f) % 2 == 0)

		{
			RemoveBoatRiders(f);
			AddCharacterToBank(f);
			return true;
		}
		return false;
	}

	public boolean validateMove(Farmer f) {
		/** disable the button **/
		if ((isBoatOnTheLeftBank()) && (getCrossersOnRightBank().contains(f))
				|| (!isBoatOnTheLeftBank()) && (getCrossersOnLeftBank().contains(f)))
			return true;
		return false;
	}

	public boolean removeRight(Farmer f) {
		if ((!isBoatOnTheLeftBank()) && (getCrossersOnRightBank().contains(f))) {
			AddBoatRiders(f);
			getCrossersOnRightBank().remove(f);

			return true;
		}
		return false;
	}

	public boolean removeLeft(Farmer f) {
		if ((isBoatOnTheLeftBank()) && (getCrossersOnLeftBank().contains(f))) {
			AddBoatRiders(f);
			getCrossersOnLeftBank().remove(f);

			return true;
		}
		return false;
	}

	public int getcF1() {
		return cF1;
	}

	public void setcF1(int cF1) {
		this.cF1 = cF1;
	}

	public int getcF2() {
		return cF2;
	}

	public void setcF2(int cF2) {
		this.cF2 = cF2;
	}

	public int getcF3() {
		return cF3;
	}

	public void setcF3(int cF3) {
		this.cF3 = cF3;
	}

	public int getcF4() {
		return cF4;
	}

	public void setcF4(int cF4) {
		this.cF4 = cF4;
	}

	public int getMoves(Farmer f) {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}


}
