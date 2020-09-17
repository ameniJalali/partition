package com.partitionlist;

import java.util.List;

public interface PartitionList<T> {

    /**
     * @param list       the list to return consecutive subLists
     * @param bucketSize the desired size of each sublist (the last may be
     *                   smaller)
     * @return a list of consecutive subLists
     */

    List<List<T>> partition(List<T> list, int bucketSize);
}
