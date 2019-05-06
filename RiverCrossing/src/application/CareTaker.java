package application;

import java.util.ArrayList;
import java.util.Stack;

public class CareTaker {
	ArrayList<Memento> savedMementos = new ArrayList<Memento>();
	Stack<Memento> undoStack = new Stack<Memento>();
	Stack<Memento> redoStack = new Stack<Memento>();
	
	Memento popped;

	public void addMemento(Memento memento) {
		//undoStack.add(memento);
		//System.out.println(undoStack.peek());
		savedMementos.add(memento);
	}
	public int getSize () {
		return savedMementos.size();
	}
	
	
	public Memento getMemento (int index) {
		
	/*	if (!undoStack.isEmpty()) {
		redoStack.push(undoStack.pop());
		
		//redoStack.push(popped);
		return redoStack.peek();
		}
		else 
			return null;*/
		//Controller1 control = new Controller1();
		Memento m = savedMementos.get(index);
		
	return m;
	}


}
