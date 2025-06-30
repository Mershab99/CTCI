package com.mershab;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomOptionalTest {

    // Helper method for comparing behavior
    private <T> void compareOptionals(Optional<T> jdkOpt, CustomOptional<T> myOpt) {
        assertEquals(jdkOpt.isPresent(), myOpt.isPresent());
        assertEquals(jdkOpt.orElse(null), myOpt.orElse(null));
        jdkOpt.ifPresent(t -> assertEquals(t, myOpt.get()));
    }

    @Test
    void testEmpty() {
        Optional<String> jdkOpt = Optional.empty();
        CustomOptional<String> myOpt = CustomOptional.empty();
        compareOptionals(jdkOpt, myOpt);
    }

    @Test
    void testOf() {
        Optional<String> jdkOpt = Optional.of("Hello");
        CustomOptional<String> myOpt = CustomOptional.of("Hello");
        compareOptionals(jdkOpt, myOpt);
    }

    @Test
    void testOfNullableWithNonNull() {
        Optional<Integer> jdkOpt = Optional.ofNullable(42);
        CustomOptional<Integer> myOpt = CustomOptional.ofNullable(42);
        compareOptionals(jdkOpt, myOpt);
    }

    @Test
    void testOfNullableWithNull() {
        Optional<Object> jdkOpt = Optional.ofNullable(null);
        CustomOptional<Object> myOpt = CustomOptional.ofNullable(null);
        compareOptionals(jdkOpt, myOpt);
    }

    @Test
    void testGetWhenPresent() {
        CustomOptional<String> myOpt = CustomOptional.of("Test");
        assertEquals("Test", myOpt.get());
    }

    @Test
    void testGetWhenEmptyThrows() {
        CustomOptional<String> myOpt = CustomOptional.empty();
        assertThrows(NoSuchElementException.class, myOpt::get);
    }

    @Test
    void testOrElse() {
        assertEquals("default", CustomOptional.<String>empty().orElse("default"));
        assertEquals("value", CustomOptional.of("value").orElse("default"));
    }

    @Test
    void testIsPresent() {
        assertTrue(CustomOptional.of("X").isPresent());
        assertFalse(CustomOptional.empty().isPresent());
    }

    @Test
    void testIfPresent() {
        StringBuilder sb = new StringBuilder();

        CustomOptional<String> opt = CustomOptional.of("callback");
        opt.ifPresent(val -> sb.append(val));

        assertEquals("callback", sb.toString());
    }

    @Test
    void testMapWhenPresent() {
        CustomOptional<String> opt = CustomOptional.of("abc");
        CustomOptional<Integer> mapped = opt.map(String::length);

        assertTrue(mapped.isPresent());
        assertEquals(3, mapped.get());
    }

    @Test
    void testMapWhenEmpty() {
        CustomOptional<String> opt = CustomOptional.empty();
        CustomOptional<Integer> mapped = opt.map(String::length);

        assertFalse(mapped.isPresent());
    }

    @Test
    void testIfPresentRunsConsumerWhenPresent() {
        StringBuilder result = new StringBuilder();

        CustomOptional<String> opt = CustomOptional.of("Hello");

        opt.ifPresent(value -> result.append(value).append(" World"));

        assertEquals("Hello World", result.toString());
    }

    @Test
    void testIfPresentDoesNothingWhenEmpty() {
        StringBuilder result = new StringBuilder();

        CustomOptional<String> opt = CustomOptional.empty();

        opt.ifPresent(value -> result.append(value).append(" World"));

        assertEquals("", result.toString());
    }}
