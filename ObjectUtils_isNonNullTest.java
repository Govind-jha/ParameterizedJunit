package com.random.utils;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@RunWith(Parameterized.class)
public class ObjectUtils_isNonNullTest {

    private String name;
    private Object[] objArr;
    private List<Boolean> result;

    public ObjectUtils_isNonNullTest(String name, Object[] objArr, List<Boolean> result) {
        this.name = name;
        this.objArr = objArr;
        this.result = result;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<? extends Object> data() {
        return Arrays.asList(new Object[][]{
                {"input is null", null, Arrays.asList()},
                {"one null object in array", new Object[]{null}, Arrays.asList(false)},
                {"one non null in array", new Object[]{"non-null"}, Arrays.asList(true)},
                {"three null in array", new Object[]{null, null, null}, Arrays.asList(false, false, false)},
                {"three non null in array", new Object[]{"non-null", "non-null", "non-null"}, Arrays.asList(true, true, true)},
                {"both null and non null in array", new Object[]{null, "non-null", "non-null"}, Arrays.asList(false, true, true)},
                {"both non null and null in array", new Object[]{"non-null", null, null}, Arrays.asList(true, false, false)},
        });
    }

    @Test
    public void isNonNull() {
        Assert.assertNotNull(ObjectUtils.isNonNull(objArr));
    }

    @Test
    public void isList() {
        Assert.assertTrue(ObjectUtils.isNonNull(objArr) instanceof List);
    }

    @Test
    public void sizeOfResultListIsNotZero() {
            Assert.assertTrue(ObjectUtils.isNonNull(objArr).size() == result.size());
    }

    @Test
    public void isReturingExpectedResult() {
        Assert.assertTrue(ObjectUtils.isNonNull(objArr).equals(result));
    }
}

