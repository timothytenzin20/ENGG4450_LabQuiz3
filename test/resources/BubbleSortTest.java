import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sort() {
        // Test case 1: Sorting integers
        Integer[] unsorted = {5, 3, 8, 4, 2};
        Integer[] sorted = {2, 3, 4, 5, 8};
        assertArrayEquals(sorted, BubbleSort.sort(unsorted));

        // Test case 2: Sorting strings
        String[] unsortedStrings = {"banana", "apple", "cherry", "date"};
        String[] sortedStrings = {"apple", "banana", "cherry", "date"};
        assertArrayEquals(sortedStrings, BubbleSort.sort(unsortedStrings));

        // Test case 3: Already sorted array
        Integer[] alreadySorted = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, BubbleSort.sort(alreadySorted));

        // Test case 4: Array with duplicates
        Integer[] duplicates = {3, 1, 2, 3, 1};
        Integer[] sortedDuplicates = {1, 1, 2, 3, 3};
        assertArrayEquals(sortedDuplicates, BubbleSort.sort(duplicates));

        // Test case 5: Empty array
        Integer[] empty = {};
        Integer[] sortedEmpty = {};
        assertArrayEquals(sortedEmpty, BubbleSort.sort(empty));
    }
}
