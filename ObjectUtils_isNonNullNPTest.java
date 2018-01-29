package com.random.utils;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class ObjectUtils_isNonNullNPTest {
    @Test
    public void testWithSingleInput() {
        Object object = new Object();
        List<Boolean> actualResult = ObjectUtils.isNonNull(object);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actualResult).as("return is not null").isNotNull();
        softly.assertThat(actualResult).as("return is a List").isInstanceOf(List.class);
        softly.assertThat(actualResult.size()).as("size of list is not 0").isEqualTo(1);
        softly.assertThat(actualResult).as("result list is same as expected").isEqualTo(Arrays.asList(true));
        softly.assertAll();
    }
}