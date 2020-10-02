package de.pmrd.hackcalculator.view;

public interface WorkspaceContract {

    interface View {

        void navigateToCalculation(String workspaceId);

    }

    interface Presenter {

        void setView(View view);

        void selectWorkspace(String workspace);

        void createWorkspace(String workspace);
    }

}
