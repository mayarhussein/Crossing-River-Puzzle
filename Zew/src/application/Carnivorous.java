package application;



import java.awt.image.BufferedImage;

public class Carnivorous extends Animals{

	@Override
	public boolean canSail() {
		return false;
	}

	@Override
	public double getWeight() {
		return 20;
	}

	@Override
	public int getEatingRank() {
		return 2;
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

	public static Carnivorous getCarnivorous() {
		// TODO Auto-generated method stub
		return null;
	}

}
