package Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;

import exceptions.ExceptionForArrayListUnordered;
public class Collection <T extends  Comparable<? super T>,V extends Comparable<? super T>>{

    public static <T extends Comparable<T>> void Sort(ArrayList<T> list, Comparator<T> comparator) {
        int n = list.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                T a = list.get(i - 1);
                T b = list.get(i);
                if (comparator.compare(a, b) > 0) {
                    // Swap a and b
                    list.set(i - 1, b);
                    list.set(i, a);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public  <T extends Comparable<T>> void binaryInsert(ArrayList<T> list, Comparator<T> comparator, T elementToInsert) {
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

}
