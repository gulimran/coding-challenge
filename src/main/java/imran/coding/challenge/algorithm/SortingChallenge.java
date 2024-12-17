package imran.coding.challenge.algorithm;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class SortingChallenge {

    /**
     * A function to merge two arrays of integers into a single sorted array.
     * @param array1 - An array of integer numbers
     * @param array2 - Another array of integer numbers
     * @return A single sorted array of the two arrays merged
     */
    public int[] mergeSortedArrays(int[] array1, int[] array2) {
        if (Objects.isNull(array1) && Objects.isNull(array2)) return null;

        List<Integer> list = toList(array1);
        list.addAll(toList(array2));

        Collections.sort(list);
        return toArray(list);
    }

    private List<Integer> toList(int[] array) {
        return Objects.isNull(array) ?
            new ArrayList<>() :
            new ArrayList<>(Arrays.stream(array).boxed().toList());
    }

    private int[] toArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++) array[i] = list.get(i);
        return array;
    }

    /**
     * A function to merge two arrays of integers into a single sorted array,
     * using a non-collection based algorithm.
     * @param array1 - An array of integer numbers
     * @param array2 - Another array of integer numbers
     * @return A single sorted array of the two arrays merged
     */
    public int[] mergeSortedArraysQuickSort(int[] array1, int[] array2) {
        if (Objects.isNull(array1) && Objects.isNull(array2)) return null;

        int[] result = merge(array1, array2);

        quickSort(result, 0, result.length-1);
        return result;
    }

    private void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int index = split(array, begin, end);
            quickSort(array, begin, index-1);
            quickSort(array, index+1, end);
        }
    }

    private int split(int[] array, int begin, int end) {
        int pivot = array[end];
        int index = begin - 1;

        for (int i=begin; i<end; i++) {
            if (array[i] <= pivot) {
                index++;

                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }

        int temp = array[index+1];
        array[index+1] = array[end];
        array[end] = temp;

        return index+1;
    }

    private int[] merge(int[] array1, int[] array2) {
        int array1Size = array1 == null ? 0 : array1.length;
        int array2Size = array2 == null ? 0 : array2.length;
        int totalSize = array1Size + array2Size;
        int[] result = new int[totalSize];

        int k = 0;

        if (array1 != null) {
            for (int j : array1) {
                result[k++] = j;
            }
        }

        if (array2 != null) {
            for (int j : array2) {
                result[k++] = j;
            }
        }

        return result;
    }
}
