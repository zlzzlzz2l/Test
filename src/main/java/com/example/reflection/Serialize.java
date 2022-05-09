package com.example.reflection;

public interface Serialize {
    // 직렬화 메서드
    StringBuilder jsonSerialize(Person person) throws ClassNotFoundException;

    // JSON 으로 파싱하기 위한 메서드
    void jsonParser(String key, Object value, Class<?> type);
}