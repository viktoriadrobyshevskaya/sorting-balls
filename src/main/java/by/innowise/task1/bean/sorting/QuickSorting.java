package by.innowise.task1.bean.sorting;

import by.innowise.task1.bean.ball.Ball;

import java.util.Comparator;
import java.util.List;

public class QuickSorting implements SortingAlgorithm {
    private final Comparator<Ball> comparator;

    public QuickSorting(Comparator<Ball> comparator) {
        this.comparator = comparator;
    }

    public void sortBalls(List<Ball> balls) {
        quickSort(balls, 0, balls.size() - 1);
    }

    private void quickSort(List<Ball> arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(List<Ball> arr, int begin, int end) {
        Ball pivot = arr.get(end);
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (comparator.compare(arr.get(j), pivot) <= 0) {
                i++;
                arr.set(i, arr.set(j, arr.get(i)));
            }
        }

        arr.set(i + 1, arr.set(end, arr.get(i + 1)));
        return i + 1;
    }

}
