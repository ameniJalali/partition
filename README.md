# partition
A java library allow partition a list to sublists of n size 

## How to install
Build the project with maven
```
mvn package
```
Jar file generated
```
target/partition-list-0.0.1-SNAPSHOT.jar
```

## How to use

```java
import com.partitionlist.factory.PartitionListFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@SpringBootApplication
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
        
    }

}
```
#### Inputs
 
```
([1,2,3,4,5,6,7], 1)
([1,2,3,4,5,6,7], 2)
([1,2,3,4,5,6,7], 3)
([1,2,3,4,5,6,7], 4)
([1,2,3,4,5,6,7], 5)
([1,2,3,4,5,6,7], 6)
([1,2,3,4,5,6,7], 7)
([1,2,3,4,5,6,7], 8)

 ```
#### Output
 
```
[[1], [2], [3], [4], [5], [6], [7]]
[[1, 2], [3, 4], [5, 6], [7]]
[[1, 2, 3], [4, 5, 6], [7]]
[[1, 2, 3, 4], [5, 6, 7]]
[[1, 2, 3, 4, 5], [6, 7]]
[[1, 2, 3, 4, 5, 6], [7]]
[[1, 2, 3, 4, 5, 6, 7]]
[[1, 2, 3, 4, 5, 6, 7]]