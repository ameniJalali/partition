package com.partitionlist.partitionlist;

import com.partitionlist.PartitionList;
import com.partitionlist.impl.PartitionListImpl;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PartitionListImplTest {

    private List<Integer> intList;
    private PartitionList<Integer> integerList;

    @Before
    public void setup() {
        integerList = new PartitionListImpl<>();
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowException_whenListIsNull() throws NullPointerException {

        //given
        int bucketSize = 3;

        //when
        integerList.partition(null, bucketSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_whenNegativeBucketsSize() throws IllegalArgumentException {

        //given
        int bucketSize = -3;
        intList = buildList();

        //when
        integerList.partition(intList, bucketSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_whenBucketSizeEqualZero() throws IllegalArgumentException {

        //given
        int bucketSize = 0;
        intList = buildList();

        //when
        integerList.partition(intList, bucketSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_whenListIsEmpty() throws IllegalArgumentException {

        //given
        int bucketSize = 2;
        intList = new ArrayList<>();

        //when
        integerList.partition(intList, bucketSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenBucketSizePlusListSizeIsGreaterThanOrEqualToIntegerMAX_VALUE() {

        intList = buildList();

        integerList.partition(intList, Integer.MAX_VALUE - intList.size());
    }


    @Test
    public void partitionShouldBeSuccessful_WhenBucketSizeIsSmallerThanListSize() {
        //given
        int bucketSize = 3;
        intList = buildList();

        //when
        final List<List<Integer>> subLists = integerList.partition(intList, bucketSize);
        final List<Integer> lastPartition = subLists.get(2);
        final List<Integer> expectedLastPartition = Lists.<Integer>newArrayList(7);

        //then
        assertTrue(intList.size() == 7);

        assertThat(subLists.size(), equalTo(3));
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }

    @Test
    public void partitionShouldBeSuccessful_WhenBucketSizeIsGreaterThanListSize() {
        //given
        intList = buildList();
        int bucketSize = intList.size() + 1;

        //when
        final List<List<Integer>> subLists = integerList.partition(intList, bucketSize);
        final List<Integer> lastPartition = subLists.get(0);
        final List<Integer> expectedLastPartition = Lists.<Integer>newArrayList(1, 2, 3, 4, 5, 6, 7);

        //then
        assertTrue(intList.size() == 7);
        assertThat(subLists.size(), equalTo(1));
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }

    private List<Integer> buildList() {
        intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(7);
        return intList;
    }
}
