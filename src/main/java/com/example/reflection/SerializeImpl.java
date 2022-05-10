package com.example.reflection;

import java.lang.reflect.Field;

public class SerializeImpl implements Serialize {

    StringBuilder json = new StringBuilder();

    @Override
    public StringBuilder jsonSerialize(Object person) throws ClassNotFoundException {

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
                // 객체의 이름과 값을 JSON으로 변경하기 위해 jsonParser 메서드 호출
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
        // 객체 타입별로 조건 생성
        // 들어올 수 있는 데이터 타입을 String과 int로 제한했기 때문에 조건은 아래와 같다.
        if (type.equals(Integer.TYPE)) {
            json.append(value);
        } else {
            json.append("\"");
            json.append(value);
            json.append("\"");
        }
    }
}
