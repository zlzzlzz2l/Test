package com.example.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SerializeImpl implements Serialize {

    StringBuilder json = new StringBuilder();

    @Override
    public StringBuilder jsonSerialize(Person person) throws ClassNotFoundException {

        Class<?> pClass = Class.forName("com.example.reflection.Person");
        Field[] allPersonFields = pClass.getDeclaredFields();

        json.append("{");

        for (Field field : allPersonFields) {
            String key = field.getName();
            Object value = null;
            field.setAccessible(true);
            try {
                value = field.get(person);
                Class<?> type = field.getType();
                jsonParser(key, value, type);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            json.append(", ");
        }
        json.deleteCharAt(json.length()-1);
        json.deleteCharAt(json.length()-1);
        json.append("}");
        return json;
    }

    @Override
    public void jsonParser(String key, Object value, Class<?> type) {
        json.append("\"");
        json.append(key);
        json.append("\"");
        json.append(": ");
        if (type.equals(Integer.TYPE)) {
            json.append(value);
        } else {
            json.append("\"");
            json.append(value);
            json.append("\"");
        }
    }
}
