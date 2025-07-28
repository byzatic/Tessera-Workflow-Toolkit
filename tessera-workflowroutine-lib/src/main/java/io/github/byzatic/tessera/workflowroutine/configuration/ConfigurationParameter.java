package io.github.byzatic.tessera.workflowroutine.configuration;

import java.util.Objects;

public class ConfigurationParameter {
    private String parameterKey = null;
    private String parameterValue = null;

    public ConfigurationParameter() {
    }

    private ConfigurationParameter(Builder builder) {
        parameterKey = builder.parameterKey;
        parameterValue = builder.parameterValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ConfigurationParameter copy) {
        Builder builder = new Builder();
        builder.parameterKey = copy.getParameterKey();
        builder.parameterValue = copy.getParameterValue();
        return builder;
    }

    public String getParameterKey() {
        return parameterKey;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigurationParameter that = (ConfigurationParameter) o;
        return Objects.equals(parameterKey, that.parameterKey) && Objects.equals(parameterValue, that.parameterValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameterKey, parameterValue);
    }

    @Override
    public String toString() {
        return "ServiceConfigurationParameters{" +
                "parameterKey='" + parameterKey + '\'' +
                ", parameterValue='" + parameterValue + '\'' +
                '}';
    }

    /**
     * {@code ServiceConfigurationParameters} builder static inner class.
     */
    public static final class Builder {
        private String parameterKey;
        private String parameterValue;

        private Builder() {
        }

        /**
         * Sets the {@code parameterKey} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code parameterKey} to set
         * @return a reference to this Builder
         */
        public Builder parameterKey(String val) {
            parameterKey = val;
            return this;
        }

        /**
         * Sets the {@code parameterValue} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code parameterValue} to set
         * @return a reference to this Builder
         */
        public Builder parameterValue(String val) {
            parameterValue = val;
            return this;
        }

        /**
         * Returns a {@code ServiceConfigurationParameters} built from the parameters previously set.
         *
         * @return a {@code ServiceConfigurationParameters} built with parameters of this {@code ServiceConfigurationParameters.Builder}
         */
        public ConfigurationParameter build() {
            return new ConfigurationParameter(this);
        }
    }
}
