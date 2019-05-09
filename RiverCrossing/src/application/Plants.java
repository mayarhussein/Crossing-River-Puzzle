package application;

import java.awt.image.BufferedImage;

public class Plants implements ICrosser {

private static Plants plants= null;
	
	public Plants(){
	}

	public static Plants getPlants() {
		if (plants== null)
			return plants= new Plants();
		else
			return plants;
	}
	@Override
	public boolean canSail() {
		return false;
	}

	@Override
	public double getWeight() {
		return 0;
	}

	@Override
	public int getEatingRank() {
		
		return 0;
	}

	@Override
	public BufferedImage[] getImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICrosser makeCopy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLabelToBeShown(String label) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLabelToBeShown() {
		// TODO Auto-generated method stub
		return null;
	}

}
