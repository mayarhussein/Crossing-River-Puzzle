package application;

import java.util.List;

public interface IButtonCommand {
	
	public void saveGame();

	public void loadGame();

	public void solveGame(ICrossingStrategy gameStrategy);

}
