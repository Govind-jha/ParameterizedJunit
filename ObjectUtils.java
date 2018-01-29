package com.random.utils;

import java.util.*;
import java.util.stream.Collectors;

public class ObjectUtils {

    public static List<Boolean> isNonNull(Object... objects) {
        List<Boolean> result;

        if (Objects.isNull(objects)) {
            result = new ArrayList<>();
        } else result = Arrays.asList(objects) //
                .stream()//
                .parallel()//
                .map(object -> !Objects.isNull(object)) //
                .collect(Collectors.toList());

        return result;
    }

}
