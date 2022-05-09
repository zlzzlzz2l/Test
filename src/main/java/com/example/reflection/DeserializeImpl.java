package com.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class DeserializeImpl implements Deserialize{
    @Override
    public Object mapping(String json) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        StringTokenizer stringTokenizer = new StringTokenizer(json, "{}:, \"");
        Map<String, String> map = new HashMap<>();
        while (stringTokenizer.hasMoreTokens()) {
            String key = stringTokenizer.nextToken();
            String value = stringTokenizer.nextToken();
            map.put(key, value);
        }
        return objectDeserialize(map);
    }

    @Override
    public Object objectDeserialize(Map<String, String> jsonMap) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> pClass = Class.forName("com.example.reflection.Person");
        Field[] allFields = pClass.getDeclaredFields();
        Constructor<?> pConstructor = pClass.getConstructor();
        Object person = null;
        person = pConstructor.newInstance();
        for (Field field : allFields) {
            field.setAccessible(true);
            String name = field.getName();
            Class<?> type = field.getType();
            if (type.equals(Integer.TYPE)) {
                field.setInt(person, Integer.parseInt(jsonMap.get(name)));
            }
            else {
                field.set(person, jsonMap.get(name));
            }
        }
        return person;
    }
}
