package application;

import java.io.IOException;
import java.util.List;

public class MVC2 implements IRiverCrossingController , IControlStory2{
	ControlStory2 MVCCommand = ControlStory2.getControlStory2();
	public void decreaseMoves(String obj) {
		MVCCommand.decreaseMoves(obj);
	}
	@Override
	public void setCounter(int c, ICrosser crosser) {
		MVCCommand.setCounter(c, crosser);
	}
	
	public void removeBoat(ICrosser crosser) {
		MVCCommand.removeBoat(crosser);
	}
	
	public List<ICrosser> AddBoatRiders(ICrosser crosser) {
		return MVCCommand.AddBoatRiders(crosser);
	}
	public List<ICrosser> getBoatRiders() {
		return MVCCommand.getBoatRiders();
	}
	@Override
	public void moveCrosser(ICrosser crosser) {
		MVCCommand.moveCrosser(crosser);
	}
	@Override
	public boolean isOnBoat(ICrosser crosser) {
		return MVCCommand.isOnBoat(crosser);
		
	}
	
	@Override
	public boolean isSheepOnBoat(Herbivorous crosser) {
		return MVCCommand.isSheepOnBoat(crosser);
		
	}

	@Override
	public boolean validateMove(ICrosser crosser) {
		return MVCCommand.validateMove(crosser);
	
	}

	@Override
	public boolean removeRight(ICrosser crosser) {
		return MVCCommand.removeRight(crosser);
		
	}

	@Override
	public boolean removeLeft(ICrosser crosser) {
		return MVCCommand.removeLeft(crosser);
	
	}

	@Override
	public int getcF1() {
		return MVCCommand.getcF1();
		
	}

	@Override
	public int getcF2() {
		return MVCCommand.getcF2();
		
	}

	@Override
	public int getcF3() {
	return	MVCCommand.getcF3();
	}

	@Override
	public int getcF4() {
		return MVCCommand.getcF4();
	
	}

	@Override
	public void setcF1(int cF1) {
	MVCCommand.setcF1(cF1);
		
	}

	@Override
	public void setcF2(int cF2) {
		MVCCommand.setcF2(cF2);
		
	}

	@Override
	public void setcF3(int cF3) {
		MVCCommand.setcF3(cF3);
		
	}

	@Override
	public void setcF4(int cF4) {
		MVCCommand.setcF4(cF4);
	}

	@Override
	public int getMoves(ICrosser crosser) {
		return	MVCCommand.getMoves(crosser);
		
	}

	@Override
	public void setMoves(int moves) {
		MVCCommand.setMoves(moves);
	}

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {
		MVCCommand.newGame(gameStrategy);
		
	}

	@Override
	public void resetGame() {
	MVCCommand.resetGame();
		
	}

	@Override
	public String[] getInstructions() {
	return	MVCCommand.getInstructions();
	
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return MVCCommand.getCrossersOnRightBank();
	
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		
		return MVCCommand.getCrossersOnLeftBank();
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		
		return MVCCommand.isBoatOnTheLeftBank();
	}

	@Override
	public int getNumberOfSails() {
	return MVCCommand.getNumberOfSails();
		
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		
		return MVCCommand.canMove(crossers, fromLeftToRightBank);
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		MVCCommand.doMove(crossers, fromLeftToRightBank);
		
	}

	@Override
	public boolean canUndo() {
		
		return MVCCommand.canUndo();
	}

	@Override
	public boolean canRedo() {
		
		return MVCCommand.canRedo();
	}

	@Override
	public void undo() {
		MVCCommand.undo();
		
	}

	@Override
	public void redo() {
		MVCCommand.redo();
		
	}

	@Override
	public void saveGame() throws IOException {
	MVCCommand.saveGame();	
	}

	@Override
	public void loadGame() {
		MVCCommand.loadGame();
		
	}

	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}

}
