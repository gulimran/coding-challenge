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
        if (Objects.isNull(array1) && Objects.isNull(array2))
            return null;

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
}
