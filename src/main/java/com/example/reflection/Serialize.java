package com.example.reflection;

import java.lang.reflect.Field;

public interface Serialize {
    void jsonSerialize(Person person) throws IllegalAccessException;

    void jsonParser(String key, Object value, Class<?> type);
}
