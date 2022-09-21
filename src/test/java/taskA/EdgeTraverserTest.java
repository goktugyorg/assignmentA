package taskA;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import task.EdgeTraverser;

class EdgeTraverserTest {
	
	EdgeTraverser edgeTraverser;
	
	@BeforeEach
	void setUp() {
		edgeTraverser = new EdgeTraverser();
	}
	
	@Test
	void traverse_given_squareMatrix() {
		int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		String result = edgeTraverser.traverseAndPrint(input);
		assertEquals("1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10", result);
	}
	
	@Test
	void traverse_given_rectangularMatrixWithGreaterColumns() {
		int[][] input = {{1,2,3,4},{5,6,7,8}};
		String result = edgeTraverser.traverseAndPrint(input);
		assertEquals("1,2,3,4,8,7,6,5", result);
	}
	
	@Test
	void traverse_given_rectangularMatrixWithGreaterRows() {
		int[][] input = {{1,2},{3,4},{5,6},{7,8}};
		String result = edgeTraverser.traverseAndPrint(input);
		assertEquals("1,2,4,6,8,7,5,3", result);
	}
	
	@Test
	void traverse_given_emptyMatrix() {
		int[][] input = {{}};
		String result = edgeTraverser.traverseAndPrint(input);
		assertEquals("", result);
	}
	
	@Test
	void traverse_given_singleRowMatrix() {
		int[][] input = {{1,2,3,4}};
		String result = edgeTraverser.traverseAndPrint(input);
		assertEquals("1,2,3,4", result);
	}
	
	@Test
	void traverse_given_singleColumnMatrix() {
		int[][] input = {{1},{2},{3},{4}};
		String result = edgeTraverser.traverseAndPrint(input);
		assertEquals("1,2,3,4", result);
	}
	
	@Test
	void traverse_given_nullInput() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			edgeTraverser.traverseAndPrint(null);
		});
		assertTrue(exception.getMessage().contains("Input cannot be null."));
	}
	
	@Test
	void traverse_given_matrixWithDifferentRowSizes() {
		int[][] input = {{1,2,3},{4,5,6},{7}};
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			edgeTraverser.traverseAndPrint(input);
		});
		assertTrue(exception.getMessage().contains("All rows should have same size."));
	}
}
