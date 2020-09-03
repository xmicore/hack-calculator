package de.pmrd.hackcalculator.history.jpa;

import de.pmrd.hackcalculator.history.HistoryItemRepository;
import de.pmrd.hackcalculator.history.jpa.model.HistoryItemJpaEntity;
import de.pmrd.hackcalculator.service.model.HistoryBackendItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Transactional
public class HistoryItemJpaRepository implements HistoryItemRepository {

  private final EntityManager entityManager;

  public HistoryItemJpaRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Collection<HistoryBackendItem> findAll() {
    return entityManager
        .createNamedQuery(HistoryItemJpaEntity.FIND_ALL, HistoryItemJpaEntity.class)
        .getResultList()
        .stream()
        .map(this::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<HistoryBackendItem> findById(String id) {
    return findById(UUID.fromString(id));
  }

  @Override
  public Optional<HistoryBackendItem> findById(UUID id) {
    return Optional.ofNullable(entityManager.find(HistoryItemJpaEntity.class, id))
        .map(this::toDomain);
  }

  @Override
  public void create(HistoryBackendItem item) {
    Optional.ofNullable(item).stream()
        .peek(e -> e.setId(UUID.randomUUID()))
        .map(this::toEntity)
        .findFirst()
        .ifPresent(entityManager::persist);
  }

  @Override
  public void update(HistoryBackendItem item) {
      Optional.ofNullable(entityManager.find(HistoryItemJpaEntity.class, item.getId()))
        .ifPresent(
            entity -> {
              entity.setHackTotal(item.getHackTotal());
              entity.setHackPerBun(item.getHackPerBun());
              entity.setModified(item.getModified());
              entity.setNumberOfBuns(item.getNumberOfBuns());
              entity.setNumberOfPersons(item.getNumberOfPersons());
              entity.setSavedToHistory(item.getSavedToHistory());
              entity.setUser(item.getUser());
            });
  }

  private HistoryBackendItem toDomain(HistoryItemJpaEntity entity) {
    return new HistoryBackendItem(
        entity.getId(),
        entity.getNumberOfBuns(),
        entity.getHackPerBun(),
        entity.getHackTotal(),
        entity.getNumberOfPersons(),
        entity.getSavedToHistory(),
        entity.getModified(),
        entity.getUser());
  }

  private HistoryItemJpaEntity toEntity(HistoryBackendItem domain) {
    return new HistoryItemJpaEntity(
        domain.getId(),
        domain.getNumberOfBuns(),
        domain.getHackPerBun(),
        domain.getHackTotal(),
        domain.getNumberOfPersons(),
        domain.getSavedToHistory(),
        domain.getModified(),
        domain.getUser());
  }
}
