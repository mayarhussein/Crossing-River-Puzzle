package application;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Story2 implements ICrossingStrategy {

	private Farmer farmer1 = new Farmer();
	private Farmer farmer2 = new Farmer();
	private Farmer farmer3 = new Farmer();
	private Farmer farmer4 = new Farmer();

	List<Farmer> farmers = new ArrayList<>();

	/*
	 * private Carnivorous fox = new Carnivorous(); private Carnivorous lion = new
	 * Carnivorous();
	 */

	private Herbivorous animal = new Herbivorous();
	// private Herbivorous goat = new Herbivorous();

	public void setFarmers() {

		farmer1.setWeight(40);
		farmer2.setWeight(60);
		farmer3.setWeight(80);
		farmer4.setWeight(90);

		farmers.add(farmer1);
		farmers.add(farmer2);
		farmers.add(farmer3);
		farmers.add(farmer4);
	}

	public List<Farmer> getFarmers() {
		return farmers;
	}

	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders) {
		
		int sum = 0;
		for (int i = 0; i < boatRiders.size(); i++)
			sum += boatRiders.get(i).getWeight();

		if (sum > 100 || sum == 20 || sum == 0)
			return false;
		else
			return true;
	}

	@Override
	public List<ICrosser> getInitialCrossers() {

		List<ICrosser> initialCrossers = new ArrayList<>();

		initialCrossers.addAll(farmers);
		initialCrossers.add(animal);

		return initialCrossers;
	}

	@Override
	public String[] getInstructions() {
		
		String[] instructions = new String[6];
		
		instructions[0] = "Four farmers and their animal need to cross a river in a small boat.";
		instructions[1] = " The weights of the farmers are 90 kg, 80 kg,60 kg and 40 kg respectively,";
		instructions[2] = " and the weight of the animal is 20 kg.";
		instructions[3] = " find a way to get them all on the other side of the river";
		instructions[4] = " knowing that only the farmers can raft while the animals cannot";
		instructions[5] = " and it cannot bear a load heavier than 100 kg";
		return instructions;
	}

	public static Story2 getStory2() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getFarmer1() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getFarmer2() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getFarmer3() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getFarmer4() {
		// TODO Auto-generated method stub
		return null;
	}

}
