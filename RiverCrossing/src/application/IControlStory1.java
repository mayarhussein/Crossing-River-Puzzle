package application;

import java.util.List;

public interface IControlStory1 {

	public void moveSheep();
	
	public void moveLion();

	public void movePlant();

	//public void move(ICrosser crosser);

	public boolean IsSheepOnBoat();

	public boolean IsLionOnBoat();

	public void AddCharacterToBank(ICrosser crosser);

	public int getPlantMoves();

	public void setPlantMoves(int plantMoves);

	public int getLionMoves();

	public void setLionMoves(int lionMoves);

	public int getSheepMoves();

	public void setSheepMoves(int sheepMoves);

	// private Stack<Command> undo = new Stack<>();
	public ICrossingStrategy getStory();

	public void setStory(ICrossingStrategy story);

	public void setRightBankCrossers(List<ICrosser> rightBankCrossers);

	public Story1 getStory1();

	public void setStory1(Story1 story1);

	public void AddBoatRiders(ICrosser crosser);

	public void RemoveBoatRiders(ICrosser crosser);

	public List<ICrosser> getBoatRiders();

	public void setLeftBankCrossers(List<ICrosser> leftBankCrossers);

	public void setBoatRiders(List<ICrosser> boatRiders);

}
