package com.github.gui.crud.utils;

import com.github.gui.crud.utils.people.PersonColumn;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionUtils {

    public static List<Field> fields(Class<?> clz) {
        Field[] fields = clz.getDeclaredFields();
        return Arrays.stream(fields)
                .filter(f -> f.isAnnotationPresent(PersonColumn.class))
                .collect(Collectors.toList());
    }

    public static Object getValue(Field field, Object person) {
        field.setAccessible(Boolean.TRUE);
        try {
            return field.get(person);
        } catch (IllegalAccessException e) {
            System.out.printf("Enter: %s", e.getMessage());
        }
        return null;
    }
}
