package customArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	@Test
	void addOneInteger() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		assertTrue(array.add(5));

	}

	@Test
	void addOneNullToIntegers() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		assertTrue(array.add(null));
	}

	@Test
	void addOneDouble() {
		CustomArrayList<Double> array = new CustomArrayList<>();
		assertTrue(array.add(5.0));
	}

	@Test
	void addOneNullToDoubles() {
		CustomArrayList<Double> array = new CustomArrayList<>();
		assertTrue(array.add(null));
	}

	@Test
	void addOneBoolean() {
		CustomArrayList<Boolean> array = new CustomArrayList<>();
		assertTrue(array.add(true));
	}

	@Test
	void addOneNullToBooleans() {
		CustomArrayList<Boolean> array = new CustomArrayList<>();
		assertTrue(array.add(null));
	}

	@Test
	void addOneString() {
		CustomArrayList<String> array = new CustomArrayList<>();
		assertTrue(array.add("Test1"));
	}

	@Test
	void addOneNullToStrings() {
		CustomArrayList<String> array = new CustomArrayList<>();
		assertTrue(array.add(null));
	}

	@Test
	void addOneIntegerAndNull() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		assertTrue(array.add(5));
		assertTrue(array.add(null));
	}

	@Test
	void addOneNullAndInteger() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		assertTrue(array.add(null));
		assertTrue(array.add(5));
	}

	@Test
	void addTwoIntegers() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		assertTrue(array.add(5));
		assertTrue(array.add(15));
	}

	@Test
	void addTwoIntegersAndNullInside() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(5);
		array.add(null);
		assertTrue(array.add(15));
	}

	@Test
	void addTwoNullsAndIntegerInside() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(5);
		assertTrue(array.add(null));
	}

	@Test
	void addTwoNullsToIntegers() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		assertTrue(array.add(null));
	}

	@Test
	void addTwoDoublesAndNullInside() {
		CustomArrayList<Double> array = new CustomArrayList<>();
		array.add(5.0);
		array.add(null);
		assertTrue(array.add(12.3));
	}

	@Test
	void addTwoNullsToDoubles() {
		CustomArrayList<Double> array = new CustomArrayList<>();
		array.add(null);
		assertTrue(array.add(null));
	}

	@Test
	void addTwoBooleans() {
		CustomArrayList<Boolean> array = new CustomArrayList<>();
		array.add(true);
		assertTrue(array.add(false));
	}

	@Test
	void addThreeNullsToBooleans() {
		CustomArrayList<Boolean> array = new CustomArrayList<>();
		array.add(null);
		array.add(null);
		assertTrue(array.add(null));
	}

	@Test
	void addFiveStringsAndNulls() {
		CustomArrayList<String> array = new CustomArrayList<>();
		array.add("Test1");
		array.add("Test2");
		array.add(null);
		array.add("Test3");
		array.add(null);
		array.add(null);
		array.add("Test4");
		array.add("Test5");
		array.add(null);
		assertTrue(array.add(null));

	}

	@Test
	void checkSizeOfEmptyArray() {
		CustomArrayList<String> array = new CustomArrayList<>();
		assertEquals(0, array.size());
	}

	@Test
	void checkSizeOfArray() {
		CustomArrayList<String> array = new CustomArrayList<>();
		array.add("Test1");
		array.add("Test2");
		array.add(null);
		array.add("Test3");
		array.add(null);
		array.add(null);
		assertEquals(6, array.size());
	}

	@Test
	void clearArraywithElements() {
		CustomArrayList<String> array = new CustomArrayList<>();
		array.add("Test1");
		array.add("Test2");
		array.add(null);
		array.add("Test3");
		array.add(null);
		array.add(null);
		array.add("Test4");
		array.add("Test5");
		array.add(null);
		array.add(null);
		array.clear();
	}

	@Test
	void checkSizeOfClearedArray() {
		CustomArrayList<String> array = new CustomArrayList<>();
		array.add("Test1");
		array.add("Test2");
		array.add(null);
		array.add("Test3");
		array.add(null);
		array.add(null);
		array.add("Test4");
		array.add("Test5");
		array.add(null);
		array.add(null);
		array.clear();
		assertEquals(0, array.size());
	}

	@Test
	void clearArrayWithoutElements() {
		CustomArrayList<String> array = new CustomArrayList<>();
		array.clear();
	}

	@Test
	void checkIfEmptyWithoutElements() {
		CustomArrayList<String> array = new CustomArrayList<>();
		assertTrue(array.isEmpty());
	}

	@Test
	void checkIfEmptyWithElements() {
		CustomArrayList<String> array = new CustomArrayList<>();
		array.add("Test");
		assertFalse(array.isEmpty());
	}

	@Test
	void ExceptionRemoveElementFromEmptyList() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			CustomArrayList<Integer> array = new CustomArrayList<>();
			array.remove(0);
		});
	}

	@Test
	void removeElementFromList() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(5);
		array.add(7);
		array.add(null);
		array.add(5);
		assertEquals(5, array.remove(3));
	}

	@Test
	void removeNullFromList() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(5);
		array.add(7);
		array.add(null);
		array.add(5);
		assertEquals(null, array.remove(2));
	}

	@Test
	void ExceptionRemoveElementOutOfRange() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			CustomArrayList<Integer> array = new CustomArrayList<>();
			array.add(5);
			array.add(7);
			array.add(null);
			array.add(5);
			array.remove(4);
		});
	}

	@Test
	void checkIfListContainsAndTrue() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(5);
		assertTrue(array.contains(5));
	}

	@Test
	void checkIfListContainsAndFalse() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(5);
		assertFalse(array.contains(4));
	}

	@Test
	void checkIfListContainsAndTrueWithNull() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		assertTrue(array.contains(null));
	}

	@Test
	void checkIfListContainsAndFalseWithNull() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(5);
		assertFalse(array.contains(null));
	}

	@Test
	void checkIfEmptyListContains() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		assertFalse(array.contains(null));
	}

	@Test
	void setValue() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		assertEquals(null, array.set(1, 2));
	}

	@Test
	void setNull() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		assertEquals(5, array.set(2, null));
	}

	@Test
	void ExceptionSetOutOfBounds() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			CustomArrayList<Integer> array = new CustomArrayList<>();
			array.set(0, null);
		});
	}

	@Test
	void checkIndexOfIfTrue() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		assertEquals(2, array.indexOf(5));
	}

	@Test
	void checkIndexOfIfFalse() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		assertEquals(-1, array.indexOf(12));
	}

	@Test
	void chceckIndexOfNull() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		assertEquals(1, array.indexOf(null));
	}

	@Test
	void removeNull() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		assertTrue(array.remove(null));
		assertEquals(5, array.get(1));
	}

	@Test
	void removeElement() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		assertTrue(array.remove((Object) 3));
		assertEquals(null, array.get(0));
	}

	@Test
	void removeFromEmptyList() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		assertEquals(false, array.remove((Object) 3));
	}

	@Test
	void removeWhenNoSpecifiedElement() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		assertEquals(false, array.remove((Object) 9));
	}

	@Test
	void lastIndexOfNull() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(3);
		array.add(5);
		array.add(3);
		assertEquals(4, array.lastIndexOf(5));
	}

	@Test
	void lastIndexOfElement() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(3);
		array.add(null);
		array.add(3);
		assertEquals(4, array.lastIndexOf(null));
	}

	@Test
	void lastIndexOfNotExistingElement() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(3);
		array.add(null);
		array.add(3);
		assertEquals(-1, array.lastIndexOf(12));
	}

	@Test
	void addNull() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(1, null);
		assertEquals(null, array.get(1));
	}

	@Test
	void addElement() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(1, 2);
		assertEquals(2, array.get(1));
	}

	@Test
	void ExceptionAddElementOutOfBound() {

		assertThrows(IndexOutOfBoundsException.class, () -> {
			CustomArrayList<Integer> array = new CustomArrayList<>();
			array.add(3);
			array.add(null);
			array.add(5);
			array.add(8, 2);
		});

	}

//toarray testy
	@Test
	void toArrayWithoutGivenArray() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);
		Object newArray[] = array.toArray();
		assertTrue(((Integer) newArray[0]).equals(3));
		assertTrue(((Integer) newArray[1]) == (null));
		assertTrue(((Integer) newArray[2]).equals(5));
	}

	@Test
	void toArrayWithGivenSmallerArray() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);

		Integer givenArray[] = new Integer[2];
		Integer newArray[] = array.toArray(givenArray);
		assertTrue((newArray[0]).equals(3));
		assertTrue((newArray[1]) == (null));
		assertTrue((newArray[2]).equals(5));
	}

	@Test
	void toArrayWithGivenBiggerArray() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);

		Integer givenArray[] = new Integer[] { 9, 9, 9, 9, 9 };

		Integer newArray[] = array.toArray(givenArray);
		assertTrue((newArray[0]).equals(3));
		assertTrue((newArray[1]) == (null));
		assertTrue((newArray[2]).equals(5));
		assertTrue((newArray[3]) == (null));
		assertTrue((newArray[4]).equals(9));
	}

	@Test
	void containsAllWhenTrueArrayList() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);

		ArrayList<Integer> givenArray = new ArrayList<>();
		givenArray.add(3);
		givenArray.add(null);
		givenArray.add(5);

		assertTrue(array.containsAll(givenArray));
	}

	@Test
	void containsAllWhenFalseArrayList() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);

		ArrayList<Integer> givenArray = new ArrayList<>();
		givenArray.add(3);
		givenArray.add(null);
		givenArray.add(5);
		givenArray.add(7);

		assertFalse(array.containsAll(givenArray));
	}

	@Test
	void containsAllWhenTrueLinkedList() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);

		LinkedList<Integer> givenList = new LinkedList<>();
		givenList.add(3);
		givenList.add(null);
		givenList.add(5);

		assertTrue(array.containsAll(givenList));
	}

	@Test
	void containsAllWhenFalseLinkedList() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);

		LinkedList<Integer> givenList = new LinkedList<>();
		givenList.add(3);
		givenList.add(null);
		givenList.add(5);
		givenList.add(7);

		assertFalse(array.containsAll(givenList));
	}

	@Test
	void containsAllWhenTrueTreeSet() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);

		TreeSet<Integer> givenTree = new TreeSet<>();
		givenTree.add(3);
		givenTree.add(5);

		assertTrue(array.containsAll(givenTree));
	}

	@Test
	void containsAllWhenFalseTreeSet() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);

		TreeSet<Integer> givenTree = new TreeSet<>();
		givenTree.add(3);
		givenTree.add(5);
		givenTree.add(7);

		assertFalse(array.containsAll(givenTree));
	}

	@Test
	void addAll() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);

		CustomArrayList<Integer> givenArray = new CustomArrayList<>();
		givenArray.add(null);// gdzie to jest
		givenArray.add(null);
		givenArray.add(5);
		givenArray.add(5);
		givenArray.add(null);

		assertTrue(array.addAll(givenArray));

	}

	@Test
	void addAllWithNulls() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(null);

		CustomArrayList<Integer> givenArray = new CustomArrayList<>();
		givenArray.add(3);
		givenArray.add(null);
		givenArray.add(5);
		givenArray.add(7);
		givenArray.add(null);

		assertTrue(array.addAll(givenArray));
	}

	@Test
	void addAllInBounds() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(null);
		array.add(5);

		ArrayList<Integer> givenArray = new ArrayList<>();
		givenArray.add(3);
		givenArray.add(null);
		givenArray.add(5);
		givenArray.add(7);

		assertTrue(array.addAll(1, givenArray));

	}

	@Test
	void ExceptionAddAllOutOfTheBounds() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			CustomArrayList<Integer> array = new CustomArrayList<>();
			array.add(3);
			array.add(null);
			array.add(5);

			CustomArrayList<Integer> givenArray = new CustomArrayList<>();
			givenArray.add(3);
			givenArray.add(null);
			givenArray.add(5);
			givenArray.add(7);

			assertFalse(array.addAll(8, givenArray));
		});
	}

	@Test
	void addAllWithNullsInBounds() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(null);

		CustomArrayList<Integer> givenArray = new CustomArrayList<>();
		givenArray.add(null);
		givenArray.add(3);
		givenArray.add(null);
		givenArray.add(5);
		givenArray.add(7);
		givenArray.add(null);

		assertTrue(array.addAll(0, givenArray));
	}

	@Test
	void addAllWithNullsOnRange() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(null);

		CustomArrayList<Integer> givenArray = new CustomArrayList<>();
		givenArray.add(null);
		givenArray.add(3);
		givenArray.add(null);
		givenArray.add(5);
		givenArray.add(7);
		givenArray.add(null);

		assertTrue(array.addAll(5, givenArray));
	}

	@Test
	void removeAll() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(null);
		array.add(5);
		array.add(8);
		array.add(-2);
		array.add(15);

		CustomArrayList<Integer> givenArray = new CustomArrayList<>();
		givenArray.add(3);
		givenArray.add(5);
		givenArray.add(7);
		givenArray.add(-2);

		assertTrue(array.removeAll(givenArray));
	}

	@Test
	void removeAllWithNulls() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(null);
		array.add(12);

		CustomArrayList<Integer> givenArray = new CustomArrayList<>();
		givenArray.add(null);
		givenArray.add(3);
		givenArray.add(null);
		givenArray.add(5);
		givenArray.add(7);

		assertTrue(array.removeAll(givenArray));
	}

	@Test
	void removeAllWithNoElementsToRemove() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(null);

		CustomArrayList<Integer> givenArray = new CustomArrayList<>();
		givenArray.add(2);
		givenArray.add(123);

		assertTrue(array.removeAll(givenArray));
	}

	@Test
	void removeAllWhole() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(5);
		array.add(null);

		CustomArrayList<Integer> givenArray = new CustomArrayList<>();
		givenArray.add(null);
		givenArray.add(3);
		givenArray.add(null);
		givenArray.add(5);
		givenArray.add(7);
		givenArray.add(null);

		assertTrue(array.removeAll(givenArray));
	}

	@Test
	void retainAll() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(5);
		array.add(5);
		array.add(8);
		array.add(-2);
		array.add(15);

		CustomArrayList<Integer> givenArray = new CustomArrayList<>();
		givenArray.add(3);
		givenArray.add(5);
		givenArray.add(7);

		assertTrue(array.retainAll(givenArray));
	}

	@Test
	void retainAllWithNulls() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(12);

		CustomArrayList<Integer> givenArray = new CustomArrayList<>();
		givenArray.add(null);
		givenArray.add(3);
		givenArray.add(null);
		givenArray.add(5);
		givenArray.add(7);

		assertTrue(array.retainAll(givenArray));
	}

	@Test
	void retainAllWithNoElementsToRemove() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(null);

		CustomArrayList<Integer> givenArray = new CustomArrayList<>();
		givenArray.add(null);
		givenArray.add(3);
		givenArray.add(5);

		assertTrue(array.retainAll(givenArray));
	}

	@Test
	void retainAllWithNoElementsToLeave() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(null);

		CustomArrayList<Integer> givenArray = new CustomArrayList<>();
		givenArray.add(12);

		assertTrue(array.retainAll(givenArray));
	}

	@Test
	void subListWithoutNullsSize() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(7);
		array.add(2);
		array.add(5);
		array.add(8);
		array.add(3);

		assertEquals(3, array.subList(1, 4).size());
	}

	@Test
	void subListWithNullsSize() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(null);

		assertEquals(3, array.subList(1, 4).size());
	}

	@Test
	void subListWithoutNullsGet() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(3);
		array.add(7);
		array.add(2);
		array.add(5);
		array.add(8);
		array.add(3);

		assertEquals(2, array.subList(1, 4).get(1));
	}

	@Test
	void subListWithNullsGet() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(null);

		assertEquals(null, array.subList(1, 4).get(1));
	}

	@Test
	void listIteratorNext() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(null);

		assertEquals(5, array.listIterator(2).next());
	}

	@Test
	void listIteratorPrevious() {
		CustomArrayList<Integer> array = new CustomArrayList<>();
		array.add(null);
		array.add(3);
		array.add(null);
		array.add(5);
		array.add(null);

		assertEquals(null, array.listIterator(3).previous());
	}

}