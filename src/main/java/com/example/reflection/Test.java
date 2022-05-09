package com.example.reflection;

import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        // 1. Object to Json
        Serialize serialize = new SerializeImpl();

        // Person 객체 생성
        Person person = new Person();
        person.setName("kim");
        person.setAge(0);

        // JSON으로 바꾸기 위해 jsonSerialize 메서드 호출
        StringBuilder resultJson = serialize.jsonSerialize(person);

        // 결과
        System.out.println(resultJson);

        // 2. Json to Object
        Deserialize deserialize = new DeserializeImpl();

        // json 생성 및 초기화
        String json = "{\"name\": \"abcd\", \"age\": 123}";

        // Object로 바꾸기 위해 mapping 메서드 호출
        Object resultObject = deserialize.mapping(json);

        // 결과
        System.out.println(resultObject);
    }
}
