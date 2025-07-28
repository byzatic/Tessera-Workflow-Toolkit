package io.github.byzatic.tessera.enginecommon.logging;

public interface MdcContextInterface {
    void apply();

    void clear();

    AutoCloseable use();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    @Override
    String toString();
}
