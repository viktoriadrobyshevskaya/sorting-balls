package by.innowise.task1.sorting;

import by.innowise.task1.bean.Ball;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public enum SortingType {
    QUICK_SORTING(QuickSorting::new),
    MERGE_SORTING(MergeSorting::new);

    private Function<Comparator<Ball>, SortingAlgorithm> constructor;

    SortingType(Function<Comparator<Ball>, SortingAlgorithm> constructor) {
        this.constructor = constructor;
    }

    public void sort(List<Ball> balls, Comparator<Ball> comparator) {
        SortingAlgorithm algorithm = this.getConstructor().apply(comparator);
        algorithm.sortBalls(balls);
    }

    private Function<Comparator<Ball>, SortingAlgorithm> getConstructor() {
        return constructor;
    }
}
