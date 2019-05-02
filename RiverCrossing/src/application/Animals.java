package application;

public abstract class Animals implements ICrosser {
	
	 private int eatingRank;
	 private double weight;
	 
	public int getEatingRank() {
		return eatingRank;
	}
	public void setEatingRank(int eatingRank) {
		this.eatingRank = eatingRank;
	}
	public double getWeight() {
		return weight;
	}
	/*public void setWeight(double weight) {
		this.weight = weight;
	}
	 */
}

