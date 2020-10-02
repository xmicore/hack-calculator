package de.pmrd.hackcalculator.repositories.workspace;

import de.pmrd.hackcalculator.service.model.Workspace;

import java.util.Optional;

public interface WorkspaceRepository {
    void create(Workspace workspace);

    Optional<Workspace> findWorkspaceByName(String name);
}
