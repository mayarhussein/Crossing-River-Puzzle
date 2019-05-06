package application;

import java.awt.Button;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ButtonCommand implements IButtonCommand {

	private ControlStory1 storyController = ControlStory1.getControl();
	private List<ICrosser> rightBankCrossers = new ArrayList<>();
	private List<ICrosser> boatRiders = new ArrayList<>();
	private List<ICrosser> leftBankCrossers = new ArrayList<>();
	private boolean isBoatOntheLeftBank;
	private int numberOfSails;

	/*public ButtonCommand(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders,
			boolean isBoatOntheLeftBank, int numberOfSails) {
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
*/
	@Override
	public void saveGame() {
		System.out.println("button");

		storyController.saveGame();
		
	}

	@Override
	public void solveGame(ICrossingStrategy gameStrategy) {

	}

	@Override
	public void loadGame() {
		storyController.loadGame();

	}

}
