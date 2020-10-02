package de.pmrd.hackcalculator.view;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
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
  private final Binder<Workspace> binder;

  private final TextField txfWorkspace;
  private final Button btnSelect;
  private final Button btnCreate;
  private final Image image;

  public WorkspaceView(Presenter presenter) {
    this.presenter = presenter;
    this.presenter.setView(this);

    Div content = getContent();
    content.add(new H1(getTranslation("view.workspace.heading")));

    image = new Image("icons/icon.png", "logo");
    content.add(image);

    content.add(new Paragraph(getTranslation("view.workspace.description")));

    txfWorkspace = new TextField();
    txfWorkspace.setPlaceholder(getTranslation("view.workspace.placeholder"));
    txfWorkspace.addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
    txfWorkspace.setValueChangeMode(ValueChangeMode.TIMEOUT);
    content.add(txfWorkspace);

    btnSelect = new Button(getTranslation("view.workspace.button.select"));
    btnSelect.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    content.add(btnSelect);

    btnCreate = new Button(getTranslation("view.workspace.button.create"));
    btnCreate.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    content.add(btnCreate);

    binder = new Binder<>(Workspace.class);
    binder
        .forField(txfWorkspace)
        .withValidator(
            new StringLengthValidator(getTranslation("view.workspace.validation.length"), 3, 20))
        .bind(Workspace::getName, Workspace::setName);

    txfWorkspace.addValueChangeListener(e -> binder.validate());
    btnSelect.addClickListener(
        e -> {
          if (binder.validate().isOk()) {
            presenter.selectWorkspace(txfWorkspace.getValue());
          }
        });
    btnCreate.addClickListener(
        e -> {
          if (binder.validate().isOk()) {
            presenter.createWorkspace(txfWorkspace.getValue());
          }
        });
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
}
