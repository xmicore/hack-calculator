package de.pmrd.hackcalculator.repositories.workspace.jpa;

import de.pmrd.hackcalculator.repositories.workspace.WorkspaceRepository;
import de.pmrd.hackcalculator.repositories.workspace.jpa.model.WorkspaceJpaEntity;
import de.pmrd.hackcalculator.service.model.Workspace;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class WorkspaceJpaRepository implements WorkspaceRepository {

    private final EntityManager entityManager;

    public WorkspaceJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Workspace workspace) {
        Optional.ofNullable(workspace).stream()
                .peek(e -> e.setId(UUID.randomUUID()))
                .map(this::toEntity)
                .findFirst()
                .ifPresent(entityManager::persist);
    }

    @Override
    public Optional<Workspace> findWorkspaceByName(String name) {
        return entityManager
                .createNamedQuery(WorkspaceJpaEntity.FIND_BY_NAME, WorkspaceJpaEntity.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findFirst()
                .map(this::toDomain);
    }

    private Workspace toDomain(WorkspaceJpaEntity entity) {
        Workspace domain = new Workspace();
        domain.setId(entity.getId());
        domain.setName(entity.getWorkspace());
        return domain;
    }

    private WorkspaceJpaEntity toEntity(Workspace domain) {
        return new WorkspaceJpaEntity(domain.getId(), domain.getName());
    }
}
