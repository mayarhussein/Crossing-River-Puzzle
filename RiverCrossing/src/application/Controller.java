package application;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.FileWriter;

public class Controller implements IRiverCrossingController {

	private int numberOfSails = 0, undoCount = 0, redoCount = 0;
	private int sheepMoves = 1;
	private int lionMoves = 1;
	private int PlantMoves = 1;

	static Stack<ButtonCommand> undoStack = new Stack<>();
	static Stack<ButtonCommand> redoStack = new Stack<>();

	private Herbivorous herbivorous = Herbivorous.getHerbivorous();
	private Carnivorous carnivorous = Carnivorous.getCarnivorous();
	private Plants plant = Plants.getPlants();
	
	public  List<ICrosser> Right = new ArrayList<>();
	public List<ICrosser> Left = new ArrayList<>();
	public List<ICrosser> boat = new ArrayList<>();

	
	
	private List<ICrosser> rightBankCrossers = new ArrayList<>();
	private List<ICrosser> leftBankCrossers = new ArrayList<>();
	private List<ICrosser> boatRiders = new ArrayList<>();

	private static Controller control = null;
	private ButtonCommand currentCommand;
	private ICrossingStrategy story;
	private Controller1 controller1;

	private Controller() {
	}

	public static Controller getControl() {
		if (control == null)
			return control = new Controller();
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
		System.out.println("BEFORE RETURN: "+leftBankCrossers);
		return this.leftBankCrossers;
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
		if (canUndo()) {
			numberOfSails--;
			undoCount++;
		//	ButtonCommand currentCommand = new ButtonCommand(undoStack.pop());
			redoStack.push(currentCommand);
		}

	}

	@Override
	public void redo() {
		if (canRedo()) {
		//	ButtonCommand currentCommand = new ButtonCommand(redoStack.pop());
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

		
		try {
			FileOutputStream fos4 = new FileOutputStream(new File("./Sales.xml"));
			XMLEncoder encoder4 = new XMLEncoder(fos4);
			encoder4.writeObject(numberOfSails);
			encoder4.close();
			fos4.close();
		} catch (IOException ex) {
		}
		;
		
		
	}

	@Override
	public void loadGame() {
		try {
			System.out.println("3amor");
			FileInputStream fis = new FileInputStream(new File("./Saveleft.xml"));
			XMLDecoder decoder = new XMLDecoder(fis);
			Left = (List<ICrosser>) decoder.readObject();
			System.out.println("LEFT::: "+Left+"SIZE:: "+Left.size());
			System.out.println(leftBankCrossers.size());
			leftBankCrossers.clear();
			setLeftBankCrossers(Left);
			//leftBankCrossers.addAll(Left);
			System.out.println("BLAAA"+leftBankCrossers);
//			if(Left.contains())
//				System.out.println("HIIIII");
		//	setLeftBankCrossers(Left);
			System.out.println(leftBankCrossers);
			decoder.close();
			fis.close();
			if (leftBankCrossers.contains(herbivorous)) {
				System.out.println("HATNF3");
			}
			System.out.println("3amor2");
			FileInputStream fis2 = new FileInputStream(new File("./Saveright.xml"));
			XMLDecoder decoder2 = new XMLDecoder(fis2);
			Right = (List<ICrosser>) decoder2.readObject();
			System.out.println(rightBankCrossers.size());
			
			setRightBankCrossers(Right);
			System.out.println(rightBankCrossers.size());
			
			decoder2.close();
			fis2.close();
			
			System.out.println("3amor3");
			FileInputStream fis3 = new FileInputStream(new File("./Boat.xml"));
			XMLDecoder decoder3 = new XMLDecoder(fis3);
			boat = (List<ICrosser>) decoder3.readObject();
			setBoatRiders(boat);
			decoder3.close();
			fis3.close();
			
			System.out.println("3amor4");
			FileInputStream fis4 = new FileInputStream(new File("./Sales.xml"));
			XMLDecoder decoder4 = new XMLDecoder(fis4);
		     numberOfSails= (int) decoder4.readObject();
			setNumberOfSails(numberOfSails);
			decoder4.close();
			fis4.close();
			
			controller1 = new Controller1();
			System.out.println("HERE? "+leftBankCrossers);
			try{controller1.Sort();}
			catch(Exception e ) {
				System.out.println("ABU ALI");
			}
			
		} catch (IOException ex2) {
		}
		;

//		try {
//			FileInputStream fis2 = new FileInputStream(new File("./Saveright.xml"));
//			XMLDecoder decoder2 = new XMLDecoder(fis2);
//			rightBankCrossers = (List<ICrosser>) decoder2.readObject();
//			setRightBankCrossers(rightBankCrossers);
//			decoder2.close();
//			fis2.close();
//		} catch (IOException ex2) {
//		}
//		;
//
//		try {
//			FileInputStream fis3 = new FileInputStream(new File("./Boat.xml"));
//			XMLDecoder decoder3 = new XMLDecoder(fis3);
//			boatRiders = (List<ICrosser>) decoder3.readObject();
//			setBoatRiders(boatRiders);
//			decoder3.close();
//			fis3.close();
//		} catch (IOException ex2) {
//		}
//		;
//		
//		
//		try {
//			FileInputStream fis4 = new FileInputStream(new File("./Sales.xml"));
//			XMLDecoder decoder4 = new XMLDecoder(fis4);
//			numberOfSails = (int) decoder4.readObject();
//			setNumberOfSails(numberOfSails);
//			//setBoatRiders(boatRiders);
//			decoder4.close();
//			fis4.close();
//		} catch (IOException ex2) {
//		}
//		;
		
		
	//	controller1.Loadinitialize();

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

}