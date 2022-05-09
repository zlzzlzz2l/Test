package com.example.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface Deserialize {
    // JSON을 Object로 매핑하기 위한 메서드
    Object mapping(String json) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    // 역직렬화 메서드
    Object objectDeserialize(Map<String, String> jsonMap) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
