package application;



import java.awt.image.BufferedImage;

public class Herbivorous extends Animals {
	private static Herbivorous herbivorous = null;
	
	public Herbivorous(){
	}

	public static Herbivorous getHerbivorous() {
		if (herbivorous == null)
			return herbivorous = new Herbivorous();
		else
			return herbivorous;
	}

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
		return 1;
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