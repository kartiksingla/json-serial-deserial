package org.json.serial.deserial.app.utils;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowableFunction<T, R, E extends Exception> {

    R apply(T in) throws E;

    static <T, R, E extends Exception> Function<T, R> uncheckedThrow(ThrowableFunction<T, R, E> f) {
        return t -> {
            try {
                return f.apply(t);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}
