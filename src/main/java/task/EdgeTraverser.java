package task;

import java.util.StringJoiner;

/**
 * <h1> Edge Traverser </h1>
 * Traverses a matrix on its edges starting from upper left corner without repeating the same nodes.
 * 
 * <h1> Logic </h1>
 * Each completion of a row decreases the amount of iteration on a column whereas each completion of a column decreases the amount of iteration on a row. 	
 * 
 * @author Goktug Yorgancilar
 */
public class EdgeTraverser {
	private int[][] inputMatrix;
	
	private int horizontalIterationAmount;
	private int verticalIterationAmount;

	private int horizontalPosition;
	private int verticalPosition;
	
	private StringJoiner result;
	
	/**
	 * Traverses a matrix on its edges starting from upper left corner without repeating the same nodes and prints the result.
	 * @param input A double int array with equal number of elements on each row.
	 * @return String result of traversal.
	 */
	public String traverseAndPrint(int[][] input) {
		initialize(input);
		
		while(isIterationPossible()) {
			goRight(); 
			goDown(); 
			goLeft(); 
			goUp();
		}
		System.out.println(result.toString());
		return result.toString();
	}

	private void initialize(int[][] input) {
		checkInput(input);

		inputMatrix = input;
		
		horizontalIterationAmount = inputMatrix[0].length;
		verticalIterationAmount = inputMatrix.length;
		
		horizontalPosition = 0;
		verticalPosition = 0;
		
		result = new StringJoiner(",");
	}
	
	private void checkInput(int[][] input) {
		if(input == null)
			throw new IllegalArgumentException("Input cannot be null.");
		
		int firstRowSize = input[0].length;
		for (int[] row : input) {
			if(row.length != firstRowSize)
				throw new IllegalArgumentException("All rows should have same size.");
		}
	}

	private void goRight() {
		if(!isIterationPossible())
			return;
		
		for (int i = 0; i < horizontalIterationAmount; i++) {
			saveCurrentPosition();
			horizontalPosition++;
		}
		horizontalPosition--;
		
		verticalPosition++;
		verticalIterationAmount--;
	}

	private void goDown() {
		if(!isIterationPossible())
			return;
		
		for (int i = 0; i < verticalIterationAmount; i++) {
			saveCurrentPosition();
			verticalPosition++;
		}
		verticalPosition--;
		
		horizontalPosition--;
		horizontalIterationAmount--;
	}

	private void goLeft() {
		if(!isIterationPossible())
			return;
		
		for (int i = 0; i < horizontalIterationAmount; i++) {
			saveCurrentPosition();
			horizontalPosition--;
		}
		horizontalPosition++;
		
		verticalPosition--;
		verticalIterationAmount--;
	}

	private void goUp() {
		if(!isIterationPossible())
			return;
		
		for (int i = 0; i < verticalIterationAmount; i++) {
			saveCurrentPosition();
			verticalPosition--;
		}
		verticalPosition++;
		
		horizontalPosition++;
		horizontalIterationAmount--;
	}
	
	private boolean isIterationPossible() {
		return horizontalIterationAmount > 0 && verticalIterationAmount > 0;
	}
	
	private void saveCurrentPosition() {
		result.add(inputMatrix[verticalPosition][horizontalPosition] + "");
	}
}
