package PracticeSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        LinkedList <String> linkedList = new LinkedList<>();
        linkedList.add("Hammad");
        linkedList.add("Rahaman");
        linkedList.add("Shazab");


        linkedList.add("Shoukath");

       long a=  Stream.of("Hammad", "Rahaman", "Shazab", "Shoukath").filter(s -> s.toLowerCase().startsWith("s")).count();
        System.out.println("The number of strn: "+ a);
        for(String i: linkedList){
            System.out.println(i);
        }

        Practice.checkObject();
    }

    public static void checkObject(){
        List<List<Object>> twoDimensionalList = new ArrayList<>();


        twoDimensionalList.add(List.of("Apple", 10, true));
        twoDimensionalList.add(List.of("Banana", 15, false));
        twoDimensionalList.add(List.of("Cherry", 20, true));

        List<Object> oneDimensionalList = twoDimensionalList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());


        System.out.println("Flattened List: " + oneDimensionalList);
    }



    }


