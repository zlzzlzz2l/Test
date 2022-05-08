package com.example.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        HashSet<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);

        Iterator<Integer> iterator = a.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }

        Set<Integer> b = new TreeSet<>();
    }
}
