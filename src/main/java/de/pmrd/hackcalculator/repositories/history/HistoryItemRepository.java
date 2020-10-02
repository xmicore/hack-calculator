package de.pmrd.hackcalculator.repositories.history;

import de.pmrd.hackcalculator.service.model.HistoryBackendItem;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface HistoryItemRepository {
    Collection<HistoryBackendItem> findAll();

    Optional<HistoryBackendItem> findById(String id);

    Optional<HistoryBackendItem> findById(UUID id);

    void create(HistoryBackendItem item);

    void update(HistoryBackendItem item);
}
