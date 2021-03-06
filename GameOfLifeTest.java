
// Omar R. Gebril,	CSC 210,	netid: omarraef1

import static org.junit.Assert.*;
import org.junit.Test;

public class GameOfLifeTest {
	@Test
	public void testConstructorAndGetters() {
		GameOfLife society = new GameOfLife(5, 8);
		assertEquals(5, society.numberOfRows());
		assertEquals(8, society.numberOfColumns());
		for (int r = 0; r < society.numberOfRows(); r++)
			for (int c = 0; c < society.numberOfColumns(); c++)
				assertFalse(society.cellAt(r, c));
	}

	@Test
	public void testGrowCellAtAndCellAt() {
		GameOfLife society = new GameOfLife(4, 4);
		society.growCellAt(1, 1);
		society.growCellAt(2, 2);
		society.growCellAt(3, 3);
		assertTrue(society.cellAt(1, 1));
		assertTrue(society.cellAt(2, 2));
		assertTrue(society.cellAt(3, 3));
	}

	@Test
	public void testNeighborsNoWrapping() {
		GameOfLife society = new GameOfLife(10, 16);
		society.growCellAt(3, 3);
		society.growCellAt(3, 4);
		society.growCellAt(3, 5);
		// society.toString();
		assertEquals(10, society.numberOfRows());
		assertEquals(16, society.numberOfColumns());
		assertEquals(0, society.neighborCount(2, 1));
		assertEquals(1, society.neighborCount(2, 2));
		assertEquals(2, society.neighborCount(2, 3));
		assertEquals(3, society.neighborCount(2, 4));
		society.update();
	}

	@Test
	public void testNeighborsNoWrapping2() {
		GameOfLife society = new GameOfLife(10, 16);
		society.growCellAt(3, 3);
		society.growCellAt(3, 4);
		// society.toString();
		assertEquals(10, society.numberOfRows());
		assertEquals(16, society.numberOfColumns());
		assertEquals(0, society.neighborCount(2, 1));
		assertEquals(1, society.neighborCount(2, 2));
		assertEquals(2, society.neighborCount(2, 3));
		society.update();
		assertEquals(0, society.neighborCount(3, 3));
		assertEquals(0, society.neighborCount(2, 2));
		assertEquals(0, society.neighborCount(2, 3));
	}

	@Test
	public void testNeighborsNoWrapping3() {
		GameOfLife society = new GameOfLife(7, 7);
		society.growCellAt(1, 2);
		society.growCellAt(1, 4);
		society.growCellAt(2, 2);
		society.growCellAt(2, 3);
		society.growCellAt(2, 4);
		society.toString();
		society.update();
		society.toString();
		assertTrue(society.cellAt(1, 2));
		assertTrue(society.cellAt(2, 2));
		assertTrue(society.cellAt(3, 3));
		assertTrue(society.cellAt(2, 4));
		assertFalse(society.cellAt(2, 3));
		assertTrue(society.cellAt(1, 4));
		society.update();
		assertTrue(society.cellAt(2, 4));
		assertFalse(society.cellAt(2, 3));
		assertTrue(society.cellAt(3, 3));
		society.update();
		assertTrue(society.cellAt(3, 3));
		assertTrue(society.cellAt(2, 3));
		assertFalse(society.cellAt(2, 4));
	}

}
