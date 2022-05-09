package com.example.reflection;

public interface Serialize {
    StringBuilder jsonSerialize(Person person) throws ClassNotFoundException;

    void jsonParser(String key, Object value, Class<?> type);
}
