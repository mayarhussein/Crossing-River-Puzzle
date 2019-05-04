package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.FileWriter;

public class ControlStory1 implements IRiverCrossingController {

	private int numberOfSails = 0, undoCount = 0, redoCount = 0;
	private int sheepMoves = 1;
	private int lionMoves = 1;
	private int PlantMoves = 1;

	static Stack<ButtonCommand> undoStack = new Stack<>();
	static Stack<ButtonCommand> redoStack = new Stack<>();
	static Stack<String> undoStack1 = new Stack<>();

	private Herbivorous herbivorous = Herbivorous.getHerbivorous();
	private Carnivorous carnivorous = Carnivorous.getCarnivorous();
	private Plants plant = Plants.getPlants();

	private List<ICrosser> rightBankCrossers = new ArrayList<>();
	private List<ICrosser> leftBankCrossers = new ArrayList<>();
	private List<ICrosser> boatRiders = new ArrayList<>();

	private static ControlStory1 control = null;
	private ButtonCommand currentCommand;
	private ICrossingStrategy story;

	private ControlStory1() {
	}

	public static ControlStory1 getControl() {
		if (control == null)
			return control = new ControlStory1();
		return control;
	}

	private Story1 story1;

	public int getPlantMoves() {
		return PlantMoves;
	}

	public void setPlantMoves(int Moves) {
		PlantMoves = Moves;
	}

	public int getLionMoves() {
		return lionMoves;
	}

	public void setLionMoves(int lionMoves) {
		this.lionMoves = lionMoves;
	}

	public int getSheepMoves() {
		return sheepMoves;
	}

	public void setSheepMoves(int sheepMoves) {
		this.sheepMoves = sheepMoves;
	}

	// private Stack<Command> undo = new Stack<>();
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

	public Story1 getStory1() {
		return story1;
	}

	public void setStory1(Story1 story1) {
		this.story1 = story1;
	}

	public void AddBoatRiders(ICrosser crosser) {
		boatRiders.add(crosser);
		// return boatRiders;
	}

	public void RemoveBoatRiders(ICrosser crosser) {
		boatRiders.remove(crosser);
		// return boatRiders;
	}

	public List<ICrosser> getBoatRiders() {
		return boatRiders;
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
		// getCrossersOnLeftBank();
		// getBoatRiders();
		boatRiders = null;
	}

	@Override
	public void resetGame() { // dont know what to do yet//lesa 3amlo lazem ntest
		// story = gameStrategy;
		rightBankCrossers = story.getInitialCrossers();
		leftBankCrossers = null;
		boatRiders = null;
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
		// if (story1.isValid(rightBankCrossers, leftBankCrossers, boatRiders))
		// return true;
		if ((getCrossersOnRightBank().contains(herbivorous)) && (getCrossersOnRightBank().contains(plant))
				&& (!getCrossersOnRightBank().contains(carnivorous)))
			return false;
		if ((getCrossersOnLeftBank().contains(herbivorous)) && (getCrossersOnLeftBank().contains(carnivorous))
				&& (!getCrossersOnLeftBank().contains(plant)))
			return false;

		if ((getCrossersOnRightBank().contains(herbivorous)) && (getCrossersOnRightBank().contains(carnivorous))
				&& (!getCrossersOnRightBank().contains(plant)))
			return false;

		if ((getCrossersOnLeftBank().contains(herbivorous)) && (getCrossersOnLeftBank().contains(plant))
				&& (!getCrossersOnLeftBank().contains(carnivorous)))
			return false;
		else
			return true;

	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

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
		// if (canUndo()) {
		// numberOfSails--;
		// undoCount++;
		// ButtonCommand currentCommand = new ButtonCommand(undoStack.pop());
		// redoStack.push(currentCommand);
		// }

	}

	@Override
	public void redo() {
		if (canRedo()) {
			ButtonCommand currentCommand = new ButtonCommand(redoStack.pop());
			undoStack.push(currentCommand);
			undoCount--;
			redoCount++;

		}

	}

	@Override
	public void saveGame() {
		try {
			FileOutputStream fos = new FileOutputStream(new File("./Saveleft.xml"));
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(leftBankCrossers);
			encoder.close();
			fos.close();
		} catch (IOException ex) {
		}
		;

		try {
			FileOutputStream fos2 = new FileOutputStream(new File("./Saveright.xml"));
			XMLEncoder encoder2 = new XMLEncoder(fos2);
			encoder2.writeObject(rightBankCrossers);
			encoder2.close();
			fos2.close();
		} catch (IOException ex) {
		}
		;

		try {
			FileOutputStream fos3 = new FileOutputStream(new File("./Boat.xml"));
			XMLEncoder encoder3 = new XMLEncoder(fos3);
			encoder3.writeObject(boatRiders);
			encoder3.close();
			fos3.close();
		} catch (IOException ex) {
		}
		;

		// try {
		// FileOutputStream fos = new FileOutputStream(new File("./Save.xml"));

		// }catch(IOException ex) {};

	}

	@Override
	public void loadGame() {
		try {
			FileInputStream fis = new FileInputStream(new File("./Saveleft.xml"));
			XMLDecoder decoder = new XMLDecoder(fis);
			leftBankCrossers = (List<ICrosser>) decoder.readObject();
			setLeftBankCrossers(leftBankCrossers);
			decoder.close();
			fis.close();
		} catch (IOException ex2) {
		}
		;

		try {
			FileInputStream fis2 = new FileInputStream(new File("./Saveright.xml"));
			XMLDecoder decoder2 = new XMLDecoder(fis2);
			rightBankCrossers = (List<ICrosser>) decoder2.readObject();
			setRightBankCrossers(rightBankCrossers);
			decoder2.close();
			fis2.close();
		} catch (IOException ex2) {
		}
		;

		try {
			FileInputStream fis3 = new FileInputStream(new File("./Boat.xml"));
			XMLDecoder decoder3 = new XMLDecoder(fis3);
			boatRiders = (List<ICrosser>) decoder3.readObject();
			setBoatRiders(boatRiders);
			decoder3.close();
			fis3.close();
		} catch (IOException ex2) {
		}
		;

	}

	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}

	public void moveSheep() {
		int x = getSheepMoves();
		x++;
		setSheepMoves(x);

	}

	public boolean IsSheepOnBoat() {
		if (getSheepMoves() % 2 == 0)
			return true;
		return false;

	}

	public void moveLion() {
		int x = getLionMoves();
		x++;
		setLionMoves(x);

	}

	public boolean IsLionOnBoat() {
		if (getLionMoves() % 2 == 0)
			return true;
		return false;

	}

	public void movePlant() {
		int x = getPlantMoves();
		x++;
		setPlantMoves(x);

	}

	public boolean IsPlantOnBoat() {

		if (getPlantMoves() % 2 == 0)
			return true;

		return false;

	}

	public void AddCharacterToBank(ICrosser crosser) {
		if (isBoatOnTheLeftBank())
			leftBankCrossers.add(crosser);
		else if (!isBoatOnTheLeftBank())
			rightBankCrossers.add(crosser);

	}

	public void decreaseMoves(String obj) {
		int x ;
	
		if (obj.equals("boat")) {
		x = getNumberOfSails();
		x--;
		setNumberOfSails(x);
		for (int i = 0 ; i<getBoatRiders().size() ; i++) {
			if (getBoatRiders().contains(carnivorous))
				setLionMoves(getLionMoves() -1);
			if (getBoatRiders().contains(herbivorous))
				setSheepMoves(getSheepMoves() -1);
			if (getBoatRiders().contains(plant))
				setPlantMoves(getPlantMoves()-1);
		}
		}

		if (getSheepMoves() > 0 && obj.equals("sheep")) {

			x =  getSheepMoves();
			x--;
			setSheepMoves(x);
		}

		if (getLionMoves() > 0 && obj.equals("lion")) {

			x =  getLionMoves();
			x--;
			setLionMoves(x);
		}

		if (getPlantMoves() > 0 && obj.equals("plant")) {

			x = getPlantMoves();
			x--;
			setPlantMoves(x);
		}

	}

	public void increaseMoves(String obj) {
		int x = getNumberOfSails();
		x++;
		setNumberOfSails(x);

		if (getSheepMoves() > 0) {

			int y = getSheepMoves();
			y++;
			setSheepMoves(y);
		}

		if (getLionMoves() > 0) {

			int y = getLionMoves();
			y++;
			setLionMoves(y);
		}

		if (getPlantMoves() > 0) {

			int y = getPlantMoves();
			y++;
			setPlantMoves(y);
		}

	}

}