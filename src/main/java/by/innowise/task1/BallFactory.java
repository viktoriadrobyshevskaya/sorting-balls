package by.innowise.task1;

import by.innowise.task1.bean.Ball;
import by.innowise.task1.sorting.SortingType;

import java.util.Comparator;
import java.util.List;

public class BallFactory {
    private List<Ball> bucket;

    public BallFactory(List<Ball> bucket) {
        this.bucket = bucket;
    }

    public void sortBasket(SortingType sortingType, Comparator<Ball> comparator) {
            sortingType.sort(bucket, comparator);
    }

    public List<Ball> getBucket() {
        return bucket;
    }

    public void setBucket(List<Ball> bucket) {
        this.bucket = bucket;
    }
}
