package com.rwea;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TestFlattenNestedListTest {

    FlattenNestedList fnl = new FlattenNestedList();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testFlatten() {
        List<Object> input = new ArrayList(Arrays.asList(3,Arrays.asList(4,5)));
        List<Integer> expectedOutput = new ArrayList(Arrays.asList(3,4,5));
        List<Integer> actualOutput = fnl.flattenList(input);
        assertArrayEquals(actualOutput.toArray(),expectedOutput.toArray());
    }

    @Test
    public void testFlattenEmptyList() {
        List<Object> input = new ArrayList();
        List<Integer> expectedOutput = new ArrayList();
        List<Integer> actualOutput = fnl.flattenList(input);
        assertArrayEquals(actualOutput.toArray(),expectedOutput.toArray());
    }

    @Test
    public void testFlattenEmptyNestedList() {
        List<Object> input = new ArrayList(Arrays.asList(3,Arrays.asList()));
        List<Integer> expectedOutput = new ArrayList(Arrays.asList(3));
        List<Integer> actualOutput = fnl.flattenList(input);
        assertArrayEquals(actualOutput.toArray(),expectedOutput.toArray());
    }

    @Test
    public void testFlattenNull() {
        List<Object> input = null;
        List<Integer> expectedOutput = new ArrayList();
        List<Integer> actualOutput = fnl.flattenList(input);
        assertArrayEquals(actualOutput.toArray(),expectedOutput.toArray());
    }


    @Test(expected = ClassCastException.class)
    public void testFlattenWithStringInNestedList() {
        List<Object> input = new ArrayList(Arrays.asList(3,Arrays.asList("Test",5)));
        List<Integer> actualOutput = fnl.flattenList(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFlattenWithStringInMainList() {
        List<Object> input = new ArrayList(Arrays.asList("5",Arrays.asList(4,5)));
        List<Integer> actualOutput = fnl.flattenList(input);
    }
}