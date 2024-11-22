import java.util.Random;

public class QuickSort<T extends Comparable<T>> {

    private static final Random RAND = new Random();

    public static enum PIVOT_TYPE {
        FIRST, MIDDLE, RANDOM
    }

    public static PIVOT_TYPE type = PIVOT_TYPE.RANDOM;

    private QuickSort() { }

    public static <T extends Comparable<T>> T[] sort(PIVOT_TYPE pivotType, T[] unsorted) {
        if (unsorted == null || unsorted.length <= 1) {
            return unsorted; // No need to sort if the array is already sorted or empty
        }
        int pivot = 0;
        if (pivotType == PIVOT_TYPE.MIDDLE) {
            pivot = unsorted.length / 2;
        } else if (pivotType == PIVOT_TYPE.RANDOM) {
            pivot = getRandom(unsorted.length);
        }
        sort(pivot, 0, unsorted.length - 1, unsorted);
        return unsorted;
    }

    private static <T extends Comparable<T>> void sort(int index, int start, int finish, T[] unsorted) {
        if (start >= finish) return; // Base case for recursion

        int pivotIndex = start + index;
        T pivot = unsorted[pivotIndex];
        int s = start;
        int f = finish;

        // Partition the array around the pivot
        while (s <= f) {
            while (unsorted[s].compareTo(pivot) < 0) { s++; } // Find element greater than pivot
            while (unsorted[f].compareTo(pivot) > 0) { f--; } // Find element smaller than pivot

            if (s <= f) {
                swap(s, f, unsorted); // Swap elements
                s++;
                f--;
            }
        }

        // Recursively sort the partitions
        if (start < f) {
            sort(getRandom(f - start + 1), start, f, unsorted);
        }
        if (s < finish) {
            sort(getRandom(finish - s + 1), s, finish, unsorted);
        }
    }

    private static int getRandom(int length) {
        if (length <= 0) return 0;
        if (type == PIVOT_TYPE.RANDOM) {
            return RAND.nextInt(length);
        } else if (type == PIVOT_TYPE.FIRST) {
            return 0;
        }
        return length / 2; // Default to middle pivot
    }

    private static <T extends Comparable<T>> void swap(int index1, int index2, T[] unsorted) {
        T temp = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = temp;
    }
}
