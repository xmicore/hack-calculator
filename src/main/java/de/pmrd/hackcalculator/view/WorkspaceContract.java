package de.pmrd.hackcalculator.view;

public interface WorkspaceContract {

    interface View {

        void navigateToCalculation(String workspaceId);

        void navigateToCalculation();

    }

    interface Presenter {

        void setView(View view);

        void selectWorkspace(String workspace);

        void createWorkspace(String workspace);

        void skipWorkspace();

        boolean isWorkspaceUnique(String workspace);

        boolean isWorkspaceExists(String workspace);
    }

}
