package com.partitionlist;

import com.partitionlist.factory.PartitionListFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PartitionListApplication {

    public static void main(String[] args) {

        SpringApplication.run(PartitionListApplication.class, args);


        PartitionList<Integer> partitionList = PartitionListFactory.getInstance().createPartitionList();

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        //Output
        System.out.println(partitionList.partition(list, 1));
        System.out.println(partitionList.partition(list, 2));
        System.out.println(partitionList.partition(list, 3));
        System.out.println(partitionList.partition(list, 4));
        System.out.println(partitionList.partition(list, 5));
        System.out.println(partitionList.partition(list, 6));
        System.out.println(partitionList.partition(list, 7));
        System.out.println(partitionList.partition(list, 8));
        //System.out.println(partitionList.partition(list, 0));
        //System.out.println(partitionList.partition(list, -3));


    }

}
