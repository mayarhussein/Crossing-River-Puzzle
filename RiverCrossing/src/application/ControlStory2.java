package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ControlStory2 implements IRiverCrossingController, IControlStory2 {

	private static ControlStory2 c2 = null;

	private ControlStory2() {
	}

	public static ControlStory2 getControlStory2() {
		if (c2 == null)
			return c2 = new ControlStory2();
		return c2;
	}

	private Herbivorous herbivorous = Herbivorous.getHerbivorous();
	// private Carnivorous carnivorous = Carnivorous.getCarnivorous();

	public Herbivorous getHerbivorous() {
		return herbivorous;
	}

	public void setHerbivorous(Herbivorous herbivorous) {
		this.herbivorous = herbivorous;
	}

	private Story2 s2 = Story2.getStory2();

	public static Stack<IButtonCommand> commandStack = new Stack<>();

	private int cF1 = 1, cF2 = 1, cF3 = 1, cF4 = 1, cHerb = 1;
	

	public int getcHerb() {
		return cHerb;
	}

	public void setcHerb(int cHerb) {
		this.cHerb = cHerb;
	}

	public void setCounter(int c, ICrosser crosser) {
		if (crosser.equals(s2.getFarmer1()))
			setcF1(c);
		else if (crosser.equals(s2.getFarmer2()))
			setcF2(c);
		else if (crosser.equals(s2.getFarmer3()))
			setcF3(c);
		else if (crosser.equals(s2.getFarmer4()))
			setcF4(c);
		else if (crosser.equals(s2.getAnimal()))
			setcHerb(c);

	}

	// public void moveFarmer(Farmer f) {
	// int x = getMoves(f);
	// x++;
	// setCounter(x, f);
	// }

	// public boolean isOnTheBoat(Farmer f) {
	// if (getMoves(f) % 2 == 0)

	// {
	// RemoveBoatRiders(f);
	// AddCharacterToBank(f);
	// return true;
	// }
	// return false;
	// }

	public boolean validateMove(ICrosser crosser) {
		/** disable the button **/
		if ((isBoatOnTheLeftBank()) && (getCrossersOnRightBank().contains(crosser))
				|| (!isBoatOnTheLeftBank()) && (getCrossersOnLeftBank().contains(crosser)))
			return true;
		return false;
	}

	public boolean removeRight(ICrosser crosser) {
		if ((!isBoatOnTheLeftBank()) && (getCrossersOnRightBank().contains(crosser))) {
			AddBoatRiders(crosser);
			getCrossersOnRightBank().remove(crosser);

			return true;
		}
		return false;
	}

	public boolean removeLeft(ICrosser f) {
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

	private List<ICrosser> rightBankCrossers = new ArrayList<>();
	private List<ICrosser> leftBankCrossers = new ArrayList<>();
	private List<ICrosser> boatRiders = new ArrayList<>();

	private int numberOfSails = 0, undoCount = 0, redoCount = 0;
	private ICrossingStrategy story;

	public List<ICrosser> getBoatRiders() {

		return boatRiders;
	}

	public List<ICrosser> AddBoatRiders(ICrosser crosser) {

		boatRiders.add(crosser);
		return boatRiders;
	}

	public List<ICrosser> RemoveBoatRiders(ICrosser crosser) {

		boatRiders.remove(crosser);
		return boatRiders;
	}

	public ICrossingStrategy getStory() {
		return story;
	}

	public void setStory(ICrossingStrategy story) {
		/**/
		this.story = story;
	}

	public void setRightBankCrossers(List<ICrosser> rightBankCrossers) {

		this.rightBankCrossers = rightBankCrossers;

	}

	public void setLeftBankCrossers(List<ICrosser> leftBankCrossers) {

		this.leftBankCrossers = leftBankCrossers;
	}

	public void setBoatRiders(List<ICrosser> boatRiders) {
		this.boatRiders = boatRiders;
	}

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {
		story = gameStrategy;
		rightBankCrossers = story.getInitialCrossers();
		leftBankCrossers = null;
		boatRiders = null;
	}

	@Override
	public void resetGame() { // dont know what to do yet
		story = null;
	}

	@Override
	public String[] getInstructions() {

		return story.getInstructions();
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {

		return rightBankCrossers;
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {

		return leftBankCrossers;
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		if (getNumberOfSails() % 2 == 0)
			return false;
		return true;
	}

	@Override
	public int getNumberOfSails() {
		// something missing
		return numberOfSails;
	}

	public void setNumberOfSails(int numberOfSails) {
		this.numberOfSails = numberOfSails;
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

		return fromLeftToRightBank;
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		// TODO Auto-generated method stub
		// n3mel counter yezed m3 el moves 3shan l score
		int x = getNumberOfSails();
		x++;
		setNumberOfSails(x);
	}

	@Override
	public boolean canUndo() {
		return (numberOfSails == 0);
	}

	@Override
	public boolean canRedo() {
		if (numberOfSails == 0 || undoCount == 0)
			return false;
		else
			return true;
	}

	@Override
	public void undo() {
		numberOfSails--;
		undoCount++;
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}

	public void moveCrosser(ICrosser crosser) {
		if (crosser.equals(s2.getFarmer1())) {
			int x = getcF1();
			x++;
			setcF1(x);
		}

		else if (crosser.equals(s2.getFarmer2())) {
			int x = getcF2();
			x++;
			setcF2(x);
		}

		else if (crosser.equals(s2.getFarmer3())) {
			int x = getcF3();
			x++;
			setcF3(x);
		}

		else if (crosser.equals(s2.getFarmer4())) {
			int x = getcF4();
			x++;
			setcF4(x);
		} else if (crosser.equals(s2.getAnimal())) {
			int x = getcHerb();
			x++;
			setcHerb(x);
		}

	}

	public boolean isOnBoat(ICrosser crosser) {
		if (crosser.equals(s2.getFarmer1())) {
			if (getcF1() % 2 == 0)
				return true;

		} else if (crosser.equals(s2.getFarmer2())) {
			if (getcF2() % 2 == 0)
				return true;
		} else if (crosser.equals(s2.getFarmer3())) {
			if (getcF3() % 2 == 0)
				return true;
		} else if (crosser.equals(s2.getFarmer4())) {
			if (getcF4() % 2 == 0)
				return true;
		} else if (crosser.equals(s2.getAnimal())) {
				if (getcHerb() % 2 == 0)
					return true;
			}
		return false;

	}

	public void AddCharacterToBank(ICrosser crosser) {
		if (isBoatOnTheLeftBank())
			leftBankCrossers.add(crosser);
		else
			rightBankCrossers.add(crosser);

	}

	public void removeBoat(ICrosser crosser) {
		RemoveBoatRiders(crosser);
		AddCharacterToBank(crosser);

	}

	@Override
	public int getMoves(ICrosser crosser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMoves(int moves) {
		// TODO Auto-generated method stub

	}

	
	
	public void decreaseMoves(String obj) {
		int x ;
	
		if (obj.equals("boat")) {
		x = getNumberOfSails();
		x--;
		System.out.println(x);
		setNumberOfSails(x);
		for (int i = 0 ; i< getBoatRiders().size() ; i++) {
			if (getBoatRiders().contains(s2.getFarmer1())) {
				setcF1(getcF1() -1);
			}
			if (getBoatRiders().contains(s2.getFarmer2())) {
				setcF2(getcF2() -1);
			}
			if (getBoatRiders().contains(s2.getFarmer3())) {
				setcF3(getcF3() -1);
			}
			if (getBoatRiders().contains(s2.getFarmer4())) {
				setcF4(getcF4() -1);
			}
			if (getBoatRiders().contains(s2.getAnimal())) {
				setcHerb(getcHerb()-1);
			}
		}
		}

		if (getcF1() > 0 && obj.equals("farmer1")) {

			x = getcF1();
			x--;
			setcF1(x);
		}

		if (getcF2() > 0 && obj.equals("farmer2")) {

			x = getcF2();
			x--;
			setcF2(x);
		}
		if (getcF3() > 0 && obj.equals("farmer3")) {

			x = getcF3();
			x--;
			setcF3(x);
		}
		if (getcF4() > 0 && obj.equals("farmer4")) {

			x = getcF4();
			x--;
			setcF4(x);
		}
		if (getcHerb() > 0 && obj.equals("farmer1")) {

			x = getcHerb();
			x--;
			setcHerb(x);;
		}
	}
}
