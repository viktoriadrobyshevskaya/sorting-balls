package by.innowise.task1.bean.sorting;

import by.innowise.task1.bean.ball.Ball;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSorting implements SortingAlgorithm {
    private final Comparator<Ball> comparator;

    public MergeSorting(Comparator<Ball> comparator) {
        this.comparator = comparator;
    }

    public void sortBalls(List<Ball> balls) {
        mergeSort(balls, balls.size());
    }

    private void mergeSort(List<Ball> originalArray, int length) {
        if (length < 2) {
            return;
        }

        int middle = length / 2;

        List<Ball> leftArray = new ArrayList<>(originalArray.subList(0, middle));
        List<Ball> rightArray = new ArrayList<>(originalArray.subList(middle, length));

        mergeSort(leftArray, middle);
        mergeSort(rightArray, length - middle);

        merge(originalArray, leftArray, rightArray, middle, length - middle);
    }

    private void merge(List<Ball> originalArray, List<Ball> leftArray, List<Ball> rightArray, int leftSize, int rightSize) {
        int l = 0, r = 0, o = 0;

        while (l < leftSize && r < rightSize) {
            if (comparator.compare(leftArray.get(l), rightArray.get(r)) <= 0) {
                originalArray.set(o++, leftArray.get(l++));
            } else {
                originalArray.set(o++, rightArray.get(r++));
            }
        }

        while (l < leftSize) {
            originalArray.set(o++, leftArray.get(l++));
        }

        while (r < rightSize) {
            originalArray.set(o++, rightArray.get(r++));
        }
    }
}
