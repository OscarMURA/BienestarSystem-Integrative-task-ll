package Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import exceptions.ExceptionForArrayListUnordered;

/**
 * The Collection class is a generic class that takes two type parameters, T and
 * V, both of which must
 * implement the Comparable interface.
 */
public class Collection<T extends Comparable<? super T>, V extends Comparable<? super T>> {

    /**
     * The function sorts an ArrayList using the insertion sort algorithm and a
     * custom comparator.
     * 
     * @param list       The list parameter is an ArrayList of type T. It represents
     *                   the list of elements
     *                   that needs to be sorted.
     * @param comparator The "comparator" parameter is a Comparator object that is
     *                   used to compare
     *                   elements in the list. It provides a way to define the
     *                   ordering of the elements. The compare()
     *                   method of the Comparator interface is used to compare two
     *                   elements and determine their relative
     *                   order.
     */
    public <T> void Sort(ArrayList<T> list, Comparator<T> comparator) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            T current = list.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(current, list.get(j)) < 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, current);
        }
    }

    /**
     * The binaryInsert function inserts an element into a sorted ArrayList using
     * binary search.
     * 
     * @param list            An ArrayList of elements that are comparable.
     * @param comparator      The `comparator` parameter is a `Comparator` object
     *                        that is used to compare
     *                        elements in the `list`. It is used to determine the
     *                        order of the elements in the list.
     * @param elementToInsert The element that you want to insert into the sorted
     *                        list.
     */
    public static <T extends Comparable<T>> void binaryInsert(ArrayList<T> list, Comparator<T> comparator,
            T elementToInsert) throws ExceptionForArrayListUnordered {
        if (!isListSorted(list, comparator)) {
            throw new ExceptionForArrayListUnordered();
        }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            T midElement = list.get(mid);

            if (comparator.compare(elementToInsert, midElement) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        list.add(left, elementToInsert);
    }

    /**
     * The function checks if an ArrayList is sorted in ascending order based on a
     * given comparator.
     * 
     * @param list       An ArrayList of elements that you want to check if it is
     *                   sorted.
     * @param comparator The `comparator` parameter is a `Comparator` object that is
     *                   used to compare
     *                   elements in the `list`. It provides a way to define the
     *                   ordering of the elements in the list.
     * @return The method isListSorted is returning a boolean value. It returns true
     *         if the elements in
     *         the given ArrayList are sorted in ascending order according to the
     *         provided Comparator, and
     *         false otherwise.
     */
    public static <T> boolean isListSorted(ArrayList<T> list, Comparator<T> comparator) {
        for (int i = 1; i < list.size(); i++) {
            if (comparator.compare(list.get(i - 1), list.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

}
