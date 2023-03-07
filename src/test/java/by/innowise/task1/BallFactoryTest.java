package by.innowise.task1;

import by.innowise.task1.bean.ball.Ball;
import by.innowise.task1.bean.ball.BasketballBall;
import by.innowise.task1.bean.ball.Color;
import by.innowise.task1.bean.ball.FootballBall;
import by.innowise.task1.bean.ball.VolleyballBall;
import by.innowise.task1.bean.sorting.BallClassComparator;
import by.innowise.task1.bean.sorting.SortingType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BallFactoryTest {
    private BallFactory ballFactory;

    @BeforeEach
    void setUp() {
        List<Ball> balls = new ArrayList<>();
        balls.add(new VolleyballBall(68, Color.ORANGE, "Mikasa"));
        balls.add(new BasketballBall(70, Color.BLACK, "Wilson"));
        balls.add(new FootballBall(69, Color.BLUE, "Nike"));
        balls.add(new VolleyballBall(85, Color.YELLOW, "Mikasa"));
        balls.add(new FootballBall(63, Color.ORANGE, "Kappa"));
        balls.add(new BasketballBall(80, Color.WHITE, "Jordan Brand"));
        balls.add(new BasketballBall(69, Color.YELLOW, "Nike"));

        Collections.shuffle(balls);

        ballFactory = new BallFactory(balls);
    }

    @RepeatedTest(10)
    @DisplayName("QuickSortingBySize")
    void testQuickSortingBucketComparingBySize() {
        // Quick sorting is Unstable Sorting Algorithm.
        Comparator<Ball> comparator = Comparator.comparingInt(Ball::getSize).thenComparing(Ball::getColor)
                .thenComparing(Ball::getBrand).thenComparing(new BallClassComparator());
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        // List.sort use merge sorting (Stable Sorting Algorithm)
        expectedBucket.sort(comparator);

        ballFactory.sortBasket(SortingType.QUICK_SORTING, comparator);
        List<Ball> sortedBucket = ballFactory.getBucket();

        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

    @RepeatedTest(10)
    @DisplayName("QuickSortingByColor")
    void testQuickSortingBucketComparingByColor() {
        Comparator<Ball> comparator = Comparator.comparing(Ball::getColor).thenComparingInt(Ball::getSize)
                .thenComparing(Ball::getBrand).thenComparing(new BallClassComparator());
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        expectedBucket.sort(comparator);

        ballFactory.sortBasket(SortingType.QUICK_SORTING, comparator);
        List<Ball> sortedBucket = ballFactory.getBucket();

        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

    @RepeatedTest(10)
    @DisplayName("QuickSortingByBrand")
    void testQuickSortingBucketComparingByBrand() {
        Comparator<Ball> comparator = Comparator.comparing(Ball::getBrand).thenComparingInt(Ball::getSize)
                .thenComparing(Ball::getColor).thenComparing(new BallClassComparator());
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        expectedBucket.sort(comparator);

        ballFactory.sortBasket(SortingType.QUICK_SORTING, comparator);
        List<Ball> sortedBucket = ballFactory.getBucket();

        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

    @RepeatedTest(10)
    @DisplayName("QuickSortingByClass")
    void testQuickSortingBucketComparingByClass() {
        Comparator<Ball> comparator = new BallClassComparator().thenComparingInt(Ball::getSize)
                .thenComparing(Ball::getColor).thenComparing(Ball::getBrand);
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        expectedBucket.sort(comparator);

        ballFactory.sortBasket(SortingType.QUICK_SORTING, comparator);
        List<Ball> sortedBucket = ballFactory.getBucket();

        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

    @RepeatedTest(10)
    @DisplayName("MergeSortingBySize")
    void testMergeSortingBucketComparingBySize() {
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        expectedBucket.sort(Comparator.comparingInt(Ball::getSize));

        ballFactory.sortBasket(SortingType.MERGE_SORTING, Comparator.comparing(Ball::getSize));
        List<Ball> sortedBucket = ballFactory.getBucket();
        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

    @RepeatedTest(10)
    @DisplayName("MergeSortingByBrand")
    void testMergeSortingBucketComparingByBrand() {
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        expectedBucket.sort(Comparator.comparing(Ball::getBrand));

        ballFactory.sortBasket(SortingType.MERGE_SORTING, Comparator.comparing(Ball::getBrand));
        List<Ball> sortedBucket = ballFactory.getBucket();
        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

    @RepeatedTest(10)
    @DisplayName("MergeSortingByColor")
    void testMergeSortingBucketComparingByColor() {
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        expectedBucket.sort(Comparator.comparing(Ball::getColor));

        ballFactory.sortBasket(SortingType.MERGE_SORTING, Comparator.comparing(Ball::getColor));
        List<Ball> sortedBucket = ballFactory.getBucket();
        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

    @RepeatedTest(10)
    @DisplayName("MergeSortingByClass")
    void testMergeSortingBucketComparingByClass() {
        BallClassComparator comparator = new BallClassComparator();
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        expectedBucket.sort(comparator);

        ballFactory.sortBasket(SortingType.MERGE_SORTING, comparator);
        List<Ball> sortedBucket = ballFactory.getBucket();
        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

}
