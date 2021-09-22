package de.pmrd.hackcalculator.service;

import de.pmrd.hackcalculator.repositories.workspace.WorkspaceRepository;
import de.pmrd.hackcalculator.service.model.Workspace;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkspaceService {

//    private final WorkspaceRepository repository;

    public WorkspaceService() {
//        this.repository = repository;
    }

    public Optional<Workspace> createWorkspace(String name) {
        Workspace workspace = new Workspace(name);
//        repository.create(workspace);
        return Optional.of(workspace);
    }

    public Optional<Workspace> getWorkspace(String name) {
        return Optional.empty();
//        return repository.findWorkspaceByName(name);
    }
}
