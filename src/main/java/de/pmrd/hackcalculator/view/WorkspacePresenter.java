package de.pmrd.hackcalculator.view;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import de.pmrd.hackcalculator.service.WorkspaceService;
import de.pmrd.hackcalculator.service.model.Workspace;
import de.pmrd.hackcalculator.view.WorkspaceContract.Presenter;
import de.pmrd.hackcalculator.view.WorkspaceContract.View;

import java.util.UUID;

@SpringComponent
@VaadinSessionScope
public class WorkspacePresenter implements Presenter {

    private final WorkspaceService workspaceService;
    private View view;

    public WorkspacePresenter(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void selectWorkspace(String name) {
        workspaceService
                .getWorkspace(name)
                .map(Workspace::getId)
                .map(UUID::toString)
                .ifPresent(view::navigateToCalculation);
    }

    @Override
    public void createWorkspace(String name) {
        workspaceService
                .createWorkspace(name)
                .map(Workspace::getId)
                .map(UUID::toString)
                .ifPresent(view::navigateToCalculation);
    }

    @Override
    public void skipWorkspace() {
        view.navigateToCalculation();
    }

    @Override
    public boolean isWorkspaceUnique(String workspace) {
        return workspaceService.getWorkspace(workspace).isEmpty();
    }

    @Override
    public boolean isWorkspaceExists(String workspace) {
        return workspaceService.getWorkspace(workspace).isPresent();
    }
}
