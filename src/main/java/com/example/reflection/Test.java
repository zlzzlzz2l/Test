package com.example.reflection;

import org.json.simple.JSONObject;

import java.lang.reflect.Field;

import static com.example.reflection.Gender.*;

public class Test {
    public static void main(String[] args) throws Exception {

        Person person1 = new Person();
        person1.setName("ahyun");
        person1.setAge(26);
        person1.setGender(FEMALE);
        person1.setPhoneNumber("010-xxxx-xxxx");

        System.out.println("person1 = " + person1);

        Person person2 = new Person();

        Field[] allFields = Person.class.getDeclaredFields();
        JSONObject jsonObject = new JSONObject();

        for (Field field : allFields) {
            Object value = null;
            field.setAccessible(true);
            try {
                value = field.get(person1);
                jsonObject.put(field.getName(), value);
            } catch (IllegalAccessException e) {
                System.out.println("e = " + e);
            }
        }

        System.out.println("serialize = " + jsonObject.toJSONString());

        JSONObject object = new JSONObject(jsonObject);
        String name = (String) object.get("name");
        int age = (int) object.get("age");
        Gender gender = (Gender) object.get("gender");
        String phoneNumber = (String) object.get("phoneNumber");

        System.out.println("age = " + age);
        System.out.println("name = " + name);
        System.out.println("phoneNumber = " + phoneNumber);
        System.out.println("gender = " + gender);

        Field nameField = Person.class.getDeclaredField("name");
        Field ageField = Person.class.getDeclaredField("age");
        Field genderField = Person.class.getDeclaredField("gender");
        Field phoneNumField = Person.class.getDeclaredField("phoneNumber");

        nameField.setAccessible(true);
        ageField.setAccessible(true);
        genderField.setAccessible(true);
        phoneNumField.setAccessible(true);

        nameField.set(person2, name);
        ageField.set(person2, age);
        genderField.set(person2, gender);
        phoneNumField.set(person2, phoneNumber);

        System.out.println("person2 = " + person2);
    }
}
