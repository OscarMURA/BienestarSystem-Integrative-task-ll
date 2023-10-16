package test.SortingTest;

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
        list.add(5);
        list.add(4);
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


    @Test
    public void selecctionSortTestCorrectlyInBestCase(){
        ArrayList<Integer> list = setUpScenary1();
    }

    @Test
    public void selecctionSortTestCorrectlyInWorstCase(){
        ArrayList<Integer> list = setUpScenary2();
    }

    @Test
    public void binaryInsertTestCorrectly(){
        ArrayList<Integer> list = setUpScenary1();
    }

    @Test
    public void binaryInsertTestWithListUnordered(){
        ArrayList<Integer> list = setUpScenary2();
    }

    @Test
    public void binarySearchTestCorrectly(){
        ArrayList<Integer> list = setUpScenary1();
    }

    @Test
    public void binarySearchTestWithListUnordered(){
        ArrayList<Integer> list = setUpScenary2();
    }

}
