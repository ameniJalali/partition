package com.partitionlist.impl;

import com.partitionlist.PartitionList;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Ameni jelali
 */
public class PartitionListImpl<T> implements PartitionList<T> {

    /**
     * @param list       the list to return consecutive subLists
     * @param bucketSize the desired size of each sublist (the last may be
     *                   smaller)
     * @return a list of consecutive subLists
     */

    @Override
    public List<List<T>> partition(List<T> list, int bucketSize) {

        if (list.isEmpty()) {
            throw new IllegalArgumentException("list must not be empty");
        }

        if (list == null) {
            throw new NullPointerException("list must not be NULL");
        }

        if (bucketSize <= 0) {
            throw new IllegalArgumentException("BucketSize must be greater than 0 ");
        }

        if (bucketSize + list.size() >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("BucketSize plus list size must be less than " + Integer.MAX_VALUE);
        }

        List<List<T>> subLists = new ArrayList<>();

        for (int i = 0; i < list.size(); i += bucketSize) {

            // Math.min() is used for the case when the number of
            // last elements of list was smaller then bucketSize
            subLists.add(list.subList(i, Math.min(i + bucketSize, list.size())));
        }
        return subLists;
    }
}
