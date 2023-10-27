package test.SortingTest;

import exceptions.ExceptionForArrayListUnordered;
import org.junit.Test;
import static org.junit.Assert.*;
import Sorting.Collection;
import exceptions.ExceptionFormatOfValueNotAllowed;

import java.util.ArrayList;

public class CollectionTest {

    private Collection<Integer, Integer> collection;

    private ArrayList<Integer> setUpScenary1() {
        collection = new Collection<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        return list;

    }

    private ArrayList<Integer> setUpScenary2() {
        collection = new Collection<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        return list;
    }

    /**
     * This method evaluates that the Sort method correctly sorts an ordered list.
     */
    @Test
    public void selecctionSortTestCorrectlyInBestCase(){
        ArrayList<Integer> list = setUpScenary1();
        collection= new Collection<>();
        collection.Sort(list, (a, b) -> a - b);
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
        assertEquals(6, (int) list.get(5));
        assertEquals(7, (int) list.get(6));
        assertEquals(8, (int) list.get(7));
        assertEquals(9, (int) list.get(8));
        assertEquals(10, (int) list.get(9));
    }

    /**
     * This method evaluates that the Sort method correctly sorts an unordered list.
     */
    @Test
    public void selecctionSortTestCorrectlyInWorstCase(){
        ArrayList<Integer> list = setUpScenary2();
        collection.Sort(list, (a, b) -> a - b);
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
        assertEquals(6, (int) list.get(5));
        assertEquals(7, (int) list.get(6));
        assertEquals(8, (int) list.get(7));
        assertEquals(9, (int) list.get(8));
        assertEquals(10, (int) list.get(9));
    }

    /**
     * This method verifies that the binary insertion correctly adds an array element.
     */
    @Test
    public void binaryInsertTestCorrectly(){
        ArrayList<Integer> list = setUpScenary1();

        try {
            Collection.binaryInsert(list, (a, b) -> a - b, 11);
        } catch (ExceptionForArrayListUnordered e) {
            fail();
        }
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
        assertEquals(6, (int) list.get(5));
        assertEquals(7, (int) list.get(6));
        assertEquals(8, (int) list.get(7));
        assertEquals(9, (int) list.get(8));
        assertEquals(10, (int) list.get(9));
        assertEquals(11, (int) list.get(10));
    }

    /**
     * This test method verifies that it throws the ExceptionForArrayListUnordered exception when trying to insert an item in an ordered list.
     * when trying to insert an element in an ordered list.
     */

    @Test
    public void binaryInsertTestWithListUnordered(){
        ArrayList<Integer> list = setUpScenary2();
        try {
            Collection.binaryInsert(list, (a, b) -> a - b, 11);
            System.out.println(list);
            fail();
        }  catch (ExceptionForArrayListUnordered e) {
            assertEquals("The ArrayList is not ordered", e.getMessage());
        }
    }

    /**
     * This test method checks if a list is sorted.
     */
    @Test
    public void isListSorted(){
        ArrayList<Integer> list = setUpScenary1();
        assertTrue(Collection.isListSorted(list, (a, b) -> a - b));
    }

    /**
     * This test method checks if a list is not out of order.
     */
    @Test
    public void isListSortedWithListUnordered() {
        ArrayList<Integer> list = setUpScenary2();
        assertFalse(Collection.isListSorted(list, (a, b) -> a - b));
    }



}
