package io.github.byzatic.tessera.storageapi.storageapi;

import io.github.byzatic.tessera.storageapi.dto.StorageItem;
import io.github.byzatic.tessera.storageapi.exceptions.MCg3ApiOperationIncompleteException;

import java.util.List;

public interface StorageApiInterface {
    StorageItem getStorageObject(StorageItem storageItem) throws MCg3ApiOperationIncompleteException;
    void putStorageObject(StorageItem storageItem) throws MCg3ApiOperationIncompleteException;
    Boolean isDataByIdExists(StorageItem storageItem) throws MCg3ApiOperationIncompleteException;
    List<StorageItem> listStorageObjects(StorageItem storageItem) throws MCg3ApiOperationIncompleteException;
}
