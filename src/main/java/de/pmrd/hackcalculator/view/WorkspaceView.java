package de.pmrd.hackcalculator.view;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Validator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import de.pmrd.hackcalculator.service.model.Workspace;
import de.pmrd.hackcalculator.view.WorkspaceContract.Presenter;
import de.pmrd.hackcalculator.view.WorkspaceContract.View;

@Route("workspace")
@RouteAlias("")
@CssImport("./styles/workspace.css")
public class WorkspaceView extends Composite<Div> implements View {

    private final Presenter presenter;
    private final Binder<Workspace> binderSelect;
    private final Binder<Workspace> binderCreate;

    private final TextField txfWorkspace;
    private final Button btnSelect;
    private final Button btnCreate;
    private final Button btnSkip;
    private final Image image;

    public WorkspaceView(Presenter presenter) {
        this.presenter = presenter;
        this.presenter.setView(this);

        Div content = getContent();
        content.add(new H1(getTranslation("view.workspace.heading")));

        image = new Image("icons/icon.png", "logo");
        image.addClassName("workspace__image");
        content.add(image);

        content.add(new Paragraph(getTranslation("view.workspace.description")));

        txfWorkspace = new TextField();
        txfWorkspace.setPlaceholder(getTranslation("view.workspace.placeholder"));
        txfWorkspace.addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
        content.add(txfWorkspace);

        btnSelect = new Button(getTranslation("view.workspace.button.select"));
        btnSelect.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        content.add(btnSelect);

        btnCreate = new Button(getTranslation("view.workspace.button.create"));
        btnCreate.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        btnSkip = new Button(getTranslation("view.workspace.button.skip"));
        btnSkip.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        Span separator = new Span(getTranslation("view.workspace.separator"));
        separator.addClassName("workspace__separator");

        Div options = new Div(btnCreate, separator, btnSkip);
        options.addClassName("workspace__options");
        content.add(options);

        binderSelect = new Binder<>(Workspace.class);
        binderSelect
                .forField(txfWorkspace)
                .withValidator(
                        validatWorkspaceLength())
                .withValidator(validatWorkspaceExists())
                .bind(Workspace::getName, Workspace::setName);
        binderCreate = new Binder<>(Workspace.class);
        binderCreate
                .forField(txfWorkspace)
                .withValidator(
                        validatWorkspaceLength())
                .withValidator(validateWorkspaceUnique())
                .bind(Workspace::getName, Workspace::setName);

        txfWorkspace.addValueChangeListener(e -> binderSelect.validate());
        btnSelect.addClickListener(
                e -> {
                    if (binderSelect.validate().isOk()) {
                        presenter.selectWorkspace(txfWorkspace.getValue());
                    }
                });
        btnCreate.addClickListener(
                e -> {
                    if (binderCreate.validate().isOk()) {
                        presenter.createWorkspace(txfWorkspace.getValue());
                    }
                });
        btnSkip.addClickListener(e -> presenter.skipWorkspace());
    }

    private Validator<? super String> validatWorkspaceExists() {
        return Validator.from(presenter::isWorkspaceExists, getTranslation("view.workspace.validation.exists"));
    }

    private Validator<? super String> validateWorkspaceUnique() {
        return Validator.from(presenter::isWorkspaceUnique, getTranslation("view.workspace.validation.unique"));
    }


    private StringLengthValidator validatWorkspaceLength() {
        return new StringLengthValidator(getTranslation("view.workspace.validation.length"), 3, 20);
    }

    @Override
    protected Div initContent() {
        Div content = new Div();
        content.setClassName("workspace");
        return content;
    }

    @Override
    public void navigateToCalculation(String workspaceId) {
        UI.getCurrent().navigate(CalculatorViewImpl.class, workspaceId);
    }

    @Override
    public void navigateToCalculation() {
        UI.getCurrent().navigate(CalculatorViewImpl.class);
    }
}
