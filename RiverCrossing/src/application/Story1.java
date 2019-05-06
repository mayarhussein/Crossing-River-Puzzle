package application;

import java.util.ArrayList;
import java.util.List;

public class Story1 implements ICrossingStrategy {

	private Farmer farmer = new Farmer();
	private Herbivorous herbivorous = Herbivorous.getHerbivorous();
	private Carnivorous carnivorous = Carnivorous.getCarnivorous();
	private Plants plant = Plants.getPlants();

	private static Story1 story1 = null;

	private Story1() {
	}

	public static Story1 getStory1() {
		if (story1 == null)
			return story1 = new Story1();
		else
			return story1;
	}

	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders) {

		if ((leftBankCrossers.contains(carnivorous)) && (leftBankCrossers.contains(herbivorous))
				&& (!leftBankCrossers.contains(plant))) // )
			return false;

		else if ((leftBankCrossers.contains(plant)) && (leftBankCrossers.contains(herbivorous))
				&& (!leftBankCrossers.contains(carnivorous)))
			return false;

		else if ((rightBankCrossers.contains(carnivorous) && (rightBankCrossers.contains(herbivorous)))
				&& (!rightBankCrossers.contains(plant)))
			return false;
		else if ((rightBankCrossers.contains(plant)) && (rightBankCrossers.contains(herbivorous))
				&& (!rightBankCrossers.contains(carnivorous)))
			return false;
		else
			return true;

	}

	@Override
	public List<ICrosser> getInitialCrossers() {
		List<ICrosser> crossers = new ArrayList<>();
		crossers.add(farmer);
		/*
		 * crossers.add(herbivorous); crossers.add(carnivorous); crossers.add(plant);
		 */

		return crossers;
	}

	@Override
	public String[] getInstructions() {

		String[] instructions = new String[5];

		instructions[0] = "A farmer wants to cross a river and take with him a carnivorous, a herbivorous and plant.";
		// instructions[1] = " find a way to get them all on the other side of the
		// river";
		instructions[1] = " only the farmers can raft while the animals cannot";
		instructions[2] = " the farmer can take only one passenger with him on the boat";
		instructions[3] = " You can not leave any two crossers on the same bank if they can harm(eat) each other";
		instructions[4] = "How can the farmer get across the river with the 2 animals and the plant without any losses?";
		return instructions;

	}
	
	public boolean gameCompleted (List<ICrosser> leftBankCrossers)
	{
		if (leftBankCrossers.contains(carnivorous) && leftBankCrossers.contains(herbivorous) && leftBankCrossers.contains(plant))
			return true ;
		else 
			return false;
			
	}

}
