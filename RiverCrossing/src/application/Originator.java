package application;

import java.util.ArrayList;
import java.util.List;

public class Originator {
	// private String article;
	private List<ICrosser> rightBankCrossers = new ArrayList<>();
	private List<ICrosser> leftBankCrossers = new ArrayList<>();
	private List<ICrosser> boatRiders = new ArrayList<>();
	
	public Originator(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
		super();
		this.rightBankCrossers = rightBankCrossers;
		this.leftBankCrossers = leftBankCrossers;
		this.boatRiders = boatRiders;
	}
	
	public List<ICrosser> getRightBankCrossers() {
		return rightBankCrossers;
	}

	public List<ICrosser> getLeftBankCrossers() {
		return leftBankCrossers;
	}

	public List<ICrosser> getBoatRiders() {
		return boatRiders;
	}

	public Memento storeInMemento() {
		Memento memento = new Memento(rightBankCrossers, leftBankCrossers, boatRiders);
		return memento;
	}

	public void restoreFromMemento(Memento memento) {
		this.rightBankCrossers = memento.getRightBankCrossers();
		this.leftBankCrossers = memento.getLeftBankCrossers();
		this.boatRiders = memento.getBoatRiders();
	}
}
