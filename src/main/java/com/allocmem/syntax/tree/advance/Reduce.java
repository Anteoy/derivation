package com.allocmem.syntax.tree.advance;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reduce {
    public static void main(String[] args) {

        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers = stream.reduce(
                Lists.newArrayList(9),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    System.out.println("s");
                    System.out.println(l);
                    return l;
                }, (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    System.out.println("txxxx");
                    System.out.println(l1);
                    return l1;
                });
        System.out.println(numbers);

        Stream<Integer> stream1 = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers1 = stream1.collect(Collectors.reducing(

                Lists.newArrayList(9),
                (Integer e) -> {
                    System.out.println("s2");
                    System.out.println(e);
                    return Lists.newArrayList(e);
                }, (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    System.out.println("t2");
                    System.out.println(l1);
                    return l1;
                }
        ));
        System.out.println(numbers1);


        Arrays.asList("1","2","3").parallelStream().collect(
                StringBuilder::new,
                (result, element) ->
                        result = result.append(element)
                , (u, t) -> u.append(t));
    }
}
