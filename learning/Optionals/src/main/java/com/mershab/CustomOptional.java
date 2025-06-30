package com.mershab;


import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public final class CustomOptional<T> {

    private static final CustomOptional<?> EMPTY = new CustomOptional<>(null);
    public static <V> CustomOptional<V> of(V value) {
        return new CustomOptional<>(Objects.requireNonNull(value));

    }

    public static <V> CustomOptional<V> ofNullable(V value) {
        if (value == null) {
            return (CustomOptional<V>) EMPTY;
        } else {
            return of(value);
        }

    }

    public static <V> CustomOptional<V> empty() {

        //Return EMTPY OPTIONAL
        return (CustomOptional<V>) EMPTY;
    }

    private T value;

    public CustomOptional(T value) {
        this.value = value;
    }



    public boolean isPresent() {
        return this.value != null;
    }

    public T orElse(T other) {
        if (this.value == null)
            return other;
        else
            return this.value;
    }


    public T get() {
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    public <V> CustomOptional<V> map(Function<? super T,? extends V> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        }
        else {
            return CustomOptional.ofNullable(mapper.apply(value));
        }
    }

    public void ifPresent(Consumer<? super T> action) {
        if (value != null) {
            action.accept(value);
        }

    }
}
