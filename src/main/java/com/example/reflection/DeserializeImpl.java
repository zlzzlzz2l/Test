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
        // 매핑한 값을 역직렬화를 하기 위해 objectDeserialize 메서드 호출
        return objectDeserialize(map);
    }

    @Override
    public Object objectDeserialize(Map<String, String> jsonMap) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> pClass = Class.forName("com.example.reflection.Person");
        Field[] allFields = pClass.getDeclaredFields();
        Constructor<?> pConstructor = pClass.getConstructor();
        Object person = null;
        person = pConstructor.newInstance();

        for (Field field : allFields) {
            field.setAccessible(true);
            String key = field.getName();
            Class<?> type = field.getType();
            // 타입 검증 후 객체 변환
            // 들어올 수 있는 데이터 타입을 String과 int로 제한했기 때문에 조건은 아래와 같다.
            if (type.equals(Integer.TYPE)) {
                field.setInt(person, Integer.parseInt(jsonMap.get(key)));
            }
            else {
                field.set(person, jsonMap.get(key));
            }
        }
        return person;
    }
}
