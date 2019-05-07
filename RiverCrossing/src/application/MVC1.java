package application;

import java.io.IOException;
import java.util.List;

public class MVC1 implements IRiverCrossingController, IControlStory1{
	
	ControlStory1 MVCController = ControlStory1.getControl();
	ButtonCommand command = new ButtonCommand();
	
	@Override
	public void AddCharacterToBank(ICrosser crosser) {
	MVCController.AddCharacterToBank(crosser);
		
	}

	@Override
	public int getMoves(ICrosser crosser) {
		return MVCController.getMoves(crosser);
		
	}

	@Override
	public void setMoves(int moves, ICrosser crosser) {
	MVCController.setMoves(moves , crosser);
		
	}

	@Override
	public ICrossingStrategy getStory() {
		
		return MVCController.getStory();
	}

	@Override
	public void setStory(ICrossingStrategy story) {
		MVCController.setStory(story);
		
	}

	@Override
	public void setRightBankCrossers(List<ICrosser> rightBankCrossers) {
		MVCController.setRightBankCrossers(rightBankCrossers);
		
	}

	@Override
	public Story1 getStory1() {
	
		return MVCController.getStory1();
	}

	@Override
	public void setStory1(Story1 story1) {
	MVCController.setStory1(story1);
		
	}

	@Override
	public void AddBoatRiders(ICrosser crosser) {
		MVCController.AddBoatRiders(crosser);
		
	}

	@Override
	public void RemoveBoatRiders(ICrosser crosser) {
		MVCController.RemoveBoatRiders(crosser);
	}

	@Override
	public List<ICrosser> getBoatRiders() {
		return MVCController.getBoatRiders();
		
	}

	@Override
	public void setLeftBankCrossers(List<ICrosser> leftBankCrossers) {
		MVCController.setLeftBankCrossers(leftBankCrossers);
	}

	@Override
	public void setBoatRiders(List<ICrosser> boatRiders) {
		MVCController.setBoatRiders(boatRiders);
		
	}

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {
		MVCController.newGame(gameStrategy);
	}

	@Override
	public void resetGame() {
		MVCController.resetGame();
		
	}

	@Override
	public String[] getInstructions() {
		
		return MVCController.getInstructions();
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		
		return MVCController.getCrossersOnRightBank();
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		
		return MVCController.getCrossersOnLeftBank();
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		
		return MVCController.isBoatOnTheLeftBank();
	}

	@Override
	public int getNumberOfSails() {
		
		return MVCController.getNumberOfSails();
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		
		return MVCController.canMove(crossers, fromLeftToRightBank);
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
	MVCController.doMove(crossers, fromLeftToRightBank);
		
	}

	@Override
	public boolean canUndo() {
		return MVCController.canUndo();
	}

	@Override
	public boolean canRedo() {
		
		return MVCController.canRedo();
	}

	@Override
	public void undo() {
		MVCController.undo();
		
	}

	@Override
	public void redo() {
		MVCController.redo();
	}

	@Override
	public void saveGame() throws IOException {
	command.saveGame();
		
	}

	@Override
	public void loadGame() {
		MVCController.loadGame();
		
	}

	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(ICrosser crosser) {
		MVCController.move(crosser);
		
	}

	public boolean IsOnBoat(ICrosser crosser) {
		
		return MVCController.IsOnBoat(crosser);
	}

	public void decreaseMoves(String obj) {
		 MVCController.decreaseMoves(obj);
		
	}

	public void increaseMoves(String obj) {
		 MVCController.increaseMoves(obj);
		
	}

	

	/*@Override
	public void move(ICrosser crosser) {
		// TODO Auto-generated method stub
		
	}
*/
}
