package com.example.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SerializeImpl implements Serialize {

    StringBuilder jsonValue = new StringBuilder();

    @Override
    public void jsonSerialize(Person person) {

        Field[] allFields = Person.class.getDeclaredFields();

        jsonValue.append("{");
        Map<String, Object> result = new HashMap<>();
        for (Field field : allFields) {
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
            jsonValue.append(", ");
        }
        jsonValue.deleteCharAt(jsonValue.length()-1);
        jsonValue.deleteCharAt(jsonValue.length()-1);
        jsonValue.append("}");
        System.out.println(jsonValue);
    }

    @Override
    public void jsonParser(String key, Object value, Class<?> type) {
        jsonValue.append("\"");
        jsonValue.append(key);
        jsonValue.append("\"");
        jsonValue.append(": ");
        if (type.equals(Integer.TYPE)) {
            jsonValue.append(value);
        } else {
            jsonValue.append("\"");
            jsonValue.append(value);
            jsonValue.append("\"");
        }
    }
}
