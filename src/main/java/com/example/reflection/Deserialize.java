package com.example.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface Deserialize {
    Object mapping(String json) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
    Object objectDeserialize(Map<String, String> jsonMap) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
