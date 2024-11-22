import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testSortWithIntegersUsingRandomPivot() {
        Integer[] input = {10, 3, 2, 7, 5};
        Integer[] expected = {2, 3, 5, 7, 10};
        assertArrayEquals(expected, QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input));
    }

    @Test
    void testSortWithStringsUsingMiddlePivot() {
        String[] input = {"zebra", "apple", "mango"};
        String[] expected = {"apple", "mango", "zebra"};
        assertArrayEquals(expected, QuickSort.sort(QuickSort.PIVOT_TYPE.MIDDLE, input));
    }

    @Test
    void testSortWithNegativeNumbersUsingFirstPivot() {
        Integer[] input = {-5, -1, -10, 2, 0};
        Integer[] expected = {-10, -5, -1, 0, 2};
        assertArrayEquals(expected, QuickSort.sort(QuickSort.PIVOT_TYPE.FIRST, input));
    }

    @Test
    void testSortEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};
        assertArrayEquals(expected, QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input));
    }

    @Test
    void testSortSingleElementArray() {
        Integer[] input = {99};
        Integer[] expected = {99};
        assertArrayEquals(expected, QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input));
    }

    @Test
    void testSortArrayWithDuplicateElements() {
        Integer[] input = {4, 2, 4, 1, 2};
        Integer[] expected = {1, 2, 2, 4, 4};
        assertArrayEquals(expected, QuickSort.sort(QuickSort.PIVOT_TYPE.MIDDLE, input));
    }

    @Test
    void testSortArrayWithLargeNumbers() {
        Integer[] input = {100000, 999999, 500000};
        Integer[] expected = {500000, 999999, 1000000};
        assertArrayEquals(expected, QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input));
    }
}