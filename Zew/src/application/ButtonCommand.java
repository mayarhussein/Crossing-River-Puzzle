package application;


import java.awt.Button;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ButtonCommand implements IButtonCommand {

	// kol button lih concrete command lowa7do mostakel b zato w 7ada5al fihhom el
	// redo wel undo
	private Controller storyController = Controller.getControl();
	private List<ICrosser> rightBankCrossers = new ArrayList<>();
	private List<ICrosser> boatRiders = new ArrayList<>();
	private List<ICrosser> leftBankCrossers = new ArrayList<>();
	private boolean isBoatOntheLeftBank;
	private int numberOfSails;
	
	
	
	public ButtonCommand(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders, boolean isBoatOntheLeftBank, int numberOfSails) {
		this.rightBankCrossers = rightBankCrossers;
		this.leftBankCrossers = leftBankCrossers;
		this.boatRiders = boatRiders;
		this.isBoatOntheLeftBank = isBoatOntheLeftBank;
		this.numberOfSails = numberOfSails;
		
	}
	
	public ButtonCommand(ButtonCommand currentCommand) {
		storyController.setBoatRiders(boatRiders);
		storyController.setLeftBankCrossers(leftBankCrossers);
		storyController.setRightBankCrossers(rightBankCrossers);
		storyController.setNumberOfSails(numberOfSails);
	}
	
	/*@Override
	public ICrossingStrategy startGame(ICrossingStrategy gameStrategy) {

		storyController.setStory(gameStrategy);
		storyController.setRightBankCrossers(gameStrategy.getInitialCrossers());
		storyController.setLeftBankCrossers(null);
		storyController.setBoatRiders(null);

		return storyController.getStory();
	}

	@Override
	public void stopGame(ICrossingStrategy gameStrategy) {
		
	}

	@Override
	public ICrossingStrategy restartGame(ICrossingStrategy gameStrategy) {
		return startGame(gameStrategy);
	}

	@Override
	public void newGame() {
		storyController.setStory(null);
	}

	@Override
	public String[] help(ICrossingStrategy gameStrategy) {
		return storyController.getInstructions();
	}
*/
	@Override
	public void movements(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders, boolean isBoatOntheLeftBank, int numberOfSails) {
		ButtonCommand command = new ButtonCommand(rightBankCrossers, leftBankCrossers, boatRiders, isBoatOntheLeftBank, numberOfSails);
		Controller.undoStack.push(command);
		
	}

	@Override
	public void undo() {
		storyController.undo();
		
	}

	@Override
	public void redo() {
		storyController.redo();
	}

	@Override
	public void saveGame() {
		storyController.saveGame();
		// TODO Auto-generated method stub

	}

	@Override
	public void solveGame(ICrossingStrategy gameStrategy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadGame() {
		storyController.loadGame();
		
	}

}

