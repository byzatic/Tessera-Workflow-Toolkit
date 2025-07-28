package io.github.byzatic.tessera.workflowroutine.workflowroutines.health;

import java.util.Objects;

public class HealthFlagProxy {
    private HealthFlagState healthFlagState = null;

    private HealthFlagProxy() {
    }

    private HealthFlagProxy(Builder builder) {
        healthFlagState = builder.healthFlagState;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(HealthFlagProxy copy) {
        Builder builder = new Builder();
        builder.healthFlagState = copy.getHealthFlagState();
        return builder;
    }

    public synchronized HealthFlagState getHealthFlagState() {
        return healthFlagState;
    }

    public synchronized void setHealthFlagState(HealthFlagState healthFlagState) {
        this.healthFlagState = healthFlagState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthFlagProxy that = (HealthFlagProxy) o;
        return healthFlagState == that.healthFlagState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthFlagState);
    }

    @Override
    public String toString() {
        return "HealthFlag{" +
                "healthFlagState=" + healthFlagState +
                '}';
    }

    /**
     * {@code HealthFlag} builder static inner class.
     */
    public static final class Builder {
        private HealthFlagState healthFlagState;

        private Builder() {
        }

        /**
         * Sets the {@code healthFlagState} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code healthFlagState} to set
         * @return a reference to this Builder
         */
        public Builder healthFlagState(HealthFlagState val) {
            healthFlagState = val;
            return this;
        }

        /**
         * Returns a {@code HealthFlag} built from the parameters previously set.
         *
         * @return a {@code HealthFlag} built with parameters of this {@code HealthFlag.Builder}
         */
        public HealthFlagProxy build() {
            return new HealthFlagProxy(this);
        }
    }
}
