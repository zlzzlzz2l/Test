package com.example.reflection;

import java.util.*;

public class DeserializeImpl implements Deserialize{
    @Override
    public void jsonDeserialize(String json) {
        StringTokenizer stringTokenizer = new StringTokenizer(json, "{}:, \"");
        Map<Object, String> map = new HashMap<>();
        while (stringTokenizer.hasMoreTokens()) {
            Object key = stringTokenizer.nextToken();
            String value = stringTokenizer.nextToken();
            map.put(key, value);
        }
        System.out.println(map);
    }
}
