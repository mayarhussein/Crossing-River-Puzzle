package application;

import java.io.IOException;
import java.util.List;

public class MVC1 implements IRiverCrossingController, IControlStory1{
	
	ControlStory1 MVCController = ControlStory1.getControl();
	@Override
	public void moveSheep() {
	MVCController.moveSheep();
		
	}

	@Override
	public void moveLion() {
		MVCController.moveLion();
		
	}

	@Override
	public boolean IsSheepOnBoat() {
		return MVCController.IsSheepOnBoat();
		
	}

	@Override
	public boolean IsLionOnBoat() {
		return MVCController.IsLionOnBoat();
	}

	@Override
	public void AddCharacterToBank(ICrosser crosser) {
	MVCController.AddCharacterToBank(crosser);
		
	}

	@Override
	public int getPlantMoves() {
		return MVCController.getPlantMoves();
	}

	@Override
	public void setPlantMoves(int plantMoves) {
	MVCController.setPlantMoves(plantMoves);
	}

	@Override
	public int getLionMoves() {
		
		return MVCController.getLionMoves();
	}

	@Override
	public void setLionMoves(int lionMoves) {
		MVCController.setLionMoves(lionMoves);
		
	}

	@Override
	public int getSheepMoves() {
		return MVCController.getSheepMoves();
		
	}

	@Override
	public void setSheepMoves(int sheepMoves) {
	MVCController.setSheepMoves(sheepMoves);
		
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
	MVCController.saveGame();
		
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
	public void movePlant() {
		MVCController.movePlant();
		
	}

	public boolean IsPlantOnBoat() {
		
		return MVCController.IsPlantOnBoat();
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
