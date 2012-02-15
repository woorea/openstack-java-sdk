package com.fathomdb;

public class Casts {
    /**
     * Performs a checked cast to the specified type. Useful with generics, and avoids spreading warnings throughout the code.
     * 
     * @param <T>
     * @param o
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T checkedCast(Object o, Class<T> clazz) {
        if (o == null)
            return null;
        if (!clazz.isAssignableFrom(o.getClass()))
            throw new IllegalStateException("Object was not of expected type.  Expected=" + clazz + " actual=" + o.getClass());
        return (T) o;
    }

    /**
     * Attempts to cast to the specified type, returns null if not castable. Useful with generics, and avoids spreading warnings throughout the code.
     * 
     * @param <T>
     * @param o
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T as(Object o, Class<T> clazz) {
        if (o == null)
            return null;
        if (!clazz.isAssignableFrom(o.getClass()))
            return null;
        return (T) o;
    }

}
