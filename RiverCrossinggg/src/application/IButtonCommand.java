package application;

import java.util.List;

public interface IButtonCommand {
	/*
	 * public ICrossingStrategy startGame (ICrossingStrategy gameStrategy);
	 * 
	 * public void stopGame (ICrossingStrategy gameStrategy);
	 * 
	 * public ICrossingStrategy restartGame (ICrossingStrategy gameStrategy);
	 * 
	 * public void newGame ();
	 * 
	 * public String[] help (ICrossingStrategy gameStrategy);
	 */
	public void movements(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders,
			boolean isBoatOntheLeftBank, int numberOfSails); // need an attribute

	public void undo();

	public void redo();

	public void saveGame();

	public void loadGame();

	public void solveGame(ICrossingStrategy gameStrategy);

}
