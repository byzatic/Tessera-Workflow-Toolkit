package io.github.byzatic.tessera.storageapi.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StorageItemTest {
    @Test
    public void validScopeBuildsItem() {
        StorageItem item = StorageItem.newBuilder()
                .setScope(StorageItem.ScopeType.LOCAL)
                .setStorageId("storage")
                .setDataId("data")
                .build();

        assertEquals(StorageItem.ScopeType.LOCAL, item.getScope());
        assertEquals("storage", item.getStorageId());
        assertEquals("data", item.getDataId());
    }

    @Test
    public void nullScopePreservesExceptionContract() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> StorageItem.newBuilder().build()
        );

        assertEquals("scope should be NotNull", exception.getMessage());
    }
}
