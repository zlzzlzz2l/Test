package com.example.reflection;

import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        // Object to Json
        Serialize serialize = new SerializeImpl();
        Person person = new Person();
        person.setName("kim");
        person.setAge(0);
        StringBuilder resultJson = serialize.jsonSerialize(person);
        System.out.println("resultJson = " + resultJson);

        // Json to Object
        Deserialize deserialize = new DeserializeImpl();
        String json = "{\"name\": \"abcd\", \"age\": 123}";
        Object resultObject = deserialize.mapping(json);
        System.out.println("resultObject = " + resultObject);
    }
}
