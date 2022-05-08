package com.example.collection;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        String[] arrayObj = new String[2];
        arrayObj[0] = "1";
        arrayObj[1] = "2";
        // arrayObj[2] = "3"; // 오류 발생, 크기가 2이기 때문에
        for (int i = 0; i < arrayObj.length; i++) {
            System.out.println("arrayObj = " + arrayObj[i]);
        }

        ArrayList al = new ArrayList();
        al.add("1");
        al.add("2");
        al.add("3");
        for (int i = 0; i < al.size(); i++) {
            Object o = al.get(i);
            System.out.println("al = " + o);
        }

        ArrayList<String> al2 = new ArrayList<>();
        al2.add("1");
        al2.add("2");
        al2.add("3");
        for (int i = 0; i < al.size(); i++) {
            String s = al2.get(i);
            System.out.println("s = " + s);
        }
    }
}
