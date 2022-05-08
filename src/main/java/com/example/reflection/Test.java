package com.example.reflection;

public class Test {

    public static void main(String[] args) throws IllegalAccessException {

        // Object to Json
        Serialize serialize = new SerializeImpl();
        serialize.jsonSerialize(new Person());

        // Json to Object
        Deserialize deserialize = new DeserializeImpl();
        String json = "{\"name\": \"kim\", \"age\": 0}";
        deserialize.jsonDeserialize(json);
    }
}
