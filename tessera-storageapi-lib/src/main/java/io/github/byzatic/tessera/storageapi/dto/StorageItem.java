package io.github.byzatic.tessera.storageapi.dto;

import io.github.byzatic.commons.ObjectsUtils;

import java.util.Objects;

public class StorageItem {
    private ScopeType scope = null;
    private String downstreamName = null;
    private String storageId = null;
    private String dataId = null;
    private DataValueInterface dataValue = null;

    // Вложенные enum-типы по умолчанию static
    public enum ScopeType {
        LOCAL,
        GLOBAL,
        DOWNSTREAM
    }

    public StorageItem() {
    }

    private StorageItem(Builder builder) {
        ObjectsUtils.requireNonNull(builder.scope, new IllegalArgumentException("scope should be NotNull"));
        scope = builder.scope;
        downstreamName = builder.downstreamName;
        storageId = builder.storageId;
        dataId = builder.dataId;
        dataValue = builder.dataValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(StorageItem copy) {
        Builder builder = new Builder();
        builder.scope = copy.getScope();
        builder.downstreamName = copy.getDownstreamName();
        builder.storageId = copy.getStorageId();
        builder.dataId = copy.getDataId();
        builder.dataValue = copy.getDataValue();
        return builder;
    }

    public String getStorageId() {
        return storageId;
    }

    public String getDataId() {
        return dataId;
    }

    public DataValueInterface getDataValue() {
        return dataValue;
    }

    public ScopeType getScope() {
        return scope;
    }

    public String getDownstreamName() {
        return downstreamName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageItem that = (StorageItem) o;
        return scope == that.scope && Objects.equals(downstreamName, that.downstreamName) && Objects.equals(storageId, that.storageId) && Objects.equals(dataId, that.dataId) && Objects.equals(dataValue, that.dataValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scope, downstreamName, storageId, dataId, dataValue);
    }

    @Override
    public String toString() {
        return "StorageItem{" +
                "scope=" + scope +
                ", downstreamName='" + downstreamName + '\'' +
                ", storageId='" + storageId + '\'' +
                ", dataId='" + dataId + '\'' +
                ", dataValue=" + dataValue +
                '}';
    }

    /**
     * {@code StorageItem} builder static inner class.
     */
    public static final class Builder {
        private ScopeType scope;
        private String downstreamName;
        private String storageId;
        private String dataId;
        private DataValueInterface dataValue;

        private Builder() {
        }

        /**
         * Sets the {@code scope} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param scope the {@code scope} to set
         * @return a reference to this Builder
         */
        public Builder setScope(ScopeType scope) {
            this.scope = scope;
            return this;
        }

        /**
         * Sets the {@code downstreamName} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param downstreamName the {@code downstreamName} to set
         * @return a reference to this Builder
         */
        public Builder setDownstreamName(String downstreamName) {
            this.downstreamName = downstreamName;
            return this;
        }

        /**
         * Sets the {@code storageId} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param storageId the {@code storageId} to set
         * @return a reference to this Builder
         */
        public Builder setStorageId(String storageId) {
            this.storageId = storageId;
            return this;
        }

        /**
         * Sets the {@code dataId} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param dataId the {@code dataId} to set
         * @return a reference to this Builder
         */
        public Builder setDataId(String dataId) {
            this.dataId = dataId;
            return this;
        }

        /**
         * Sets the {@code dataValue} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param dataValue the {@code dataValue} to set
         * @return a reference to this Builder
         */
        public Builder setDataValue(DataValueInterface dataValue) {
            this.dataValue = dataValue;
            return this;
        }

        /**
         * Returns a {@code StorageItem} built from the parameters previously set.
         *
         * @return a {@code StorageItem} built with parameters of this {@code StorageItem.Builder}
         */
        public StorageItem build() {
            return new StorageItem(this);
        }
    }
}

