package com.partitionlist.factory;

import com.partitionlist.PartitionList;
import com.partitionlist.impl.PartitionListImpl;

public class PartitionListFactory {
    private static PartitionListFactory instance;

    private PartitionListFactory() {
    }

    public static PartitionListFactory getInstance() {
        if (instance == null) {
            instance = new PartitionListFactory();
        }

        return instance;
    }

    public <T> PartitionList<T> createPartitionList() {
        return createPartitionList("default");
    }

    /**
     * Create PartitionList object.
     *
     * @param <T>               the  type of the list
     * @param partitionListType the PartitionList type
     * @return the <b>PartitionList</b>
     */

    public <T> PartitionList<T> createPartitionList(String partitionListType) {
        if (partitionListType == null) {
            throw new IllegalArgumentException("The value of partitionListType is not exist. Use \"default\" value for using the default implementation");
        }

        if (partitionListType.matches("default")) {
            return new PartitionListImpl<T>();
        } else {
            throw new IllegalArgumentException("The value of partitionListType is not exist. Use \"default\" value for using the default implementation");
        }
    }
}
