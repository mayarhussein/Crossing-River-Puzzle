package application;

import java.util.ArrayList;
import java.util.List;

public class Memento {

	//private String article;
	// private String crosser;
	private List<ICrosser> rightBankCrossers = new ArrayList<>();
	private List<ICrosser> leftBankCrossers = new ArrayList<>();
	private List<ICrosser> boatRiders = new ArrayList<>();

	public List<ICrosser> getRightBankCrossers() {
		return rightBankCrossers;
	}

	public List<ICrosser> getLeftBankCrossers() {
		return leftBankCrossers;
	}

	public List<ICrosser> getBoatRiders() {
		return boatRiders;
	}

	public Memento(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
		this.rightBankCrossers = rightBankCrossers;
		this.leftBankCrossers = leftBankCrossers;
		this.boatRiders = boatRiders;
	}

	
	
}
