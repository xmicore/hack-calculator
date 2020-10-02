package de.pmrd.hackcalculator.view;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.PWA;
import de.pmrd.hackcalculator.presenter.CalculatorPresenter;
import de.pmrd.hackcalculator.view.contracts.CalculatorView;
import de.pmrd.hackcalculator.view.events.CalculatorViewInitEvent;
import de.pmrd.hackcalculator.view.layout.DefaultLayout;
import de.pmrd.hackcalculator.view.model.CalculatorViewModel;
import org.springframework.context.ApplicationEventPublisher;

import java.math.BigDecimal;

@PWA(name = "Hack-Calculator", shortName = "Hacki")
@Route(value = CalculatorView.VIEW_NAME, layout = DefaultLayout.class)
@CssImport("./styles/shared.css")
public class CalculatorViewImpl extends Composite<VerticalLayout>
    implements CalculatorView, AfterNavigationObserver, HasDynamicTitle, HasUrlParameter<String> {

  private final ApplicationEventPublisher eventPublisher;

  private Binder<CalculatorViewModel> binder = new Binder<>(CalculatorViewModel.class);

  private NumberField numberOfPersons;
  private NumberField hackPerBun;
  private NumberField bunsPerPerson;
  private Button shoppingListBtn;
  private Label result;

  public CalculatorViewImpl(
      CalculatorPresenter presenter, ApplicationEventPublisher eventPublisher) {
    presenter.setView(this);
    this.eventPublisher = eventPublisher;
  }

  @Override
  public void setModel(CalculatorViewModel model) {
    binder.setBean(model);
  }

  @Override
  public void setQuantity(BigDecimal quantity) {
    result.setText(getTranslation("view.calculator.resultMessage", quantity));
  }

  @Override
  public void setCalculateListener(CalculateListener listener) {
    binder.addValueChangeListener(e -> listener.calculate());
  }

  @Override
  public void setSaveListener(SaveListener listener) {
    shoppingListBtn.addClickListener(
        e -> getUI().ifPresent(ui -> ui.navigate(ShoppingListViewImpl.class, listener.save())));
  }

  @Override
  public String getPageTitle() {
    return getTranslation("view.calculator.pageTitle");
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    eventPublisher.publishEvent(new CalculatorViewInitEvent(this));
  }

  @Override
  protected VerticalLayout initContent() {
    VerticalLayout content = new VerticalLayout();
    content.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

    initNumberOfPersons();
    initHackPerBun();
    initBunsPerPerson();
    initResult();
    initShoppingListBtn();

    content.add(numberOfPersons, hackPerBun, bunsPerPerson, result, shoppingListBtn);
    return content;
  }

  private void initShoppingListBtn() {
    shoppingListBtn = new Button(getTranslation("view.calculator.shoppingListBtnCaption"));
    shoppingListBtn.setIcon(VaadinIcon.LIST.create());
  }

  private void initResult() {
    result = new Label();
    result.setId("result");
  }

  private void initBunsPerPerson() {
    bunsPerPerson = new NumberField(getTranslation("view.calculator.bunsPerPerson"));
    bunsPerPerson.setId("bunsPerPerson");
    bunsPerPerson.setHasControls(true);
    bunsPerPerson.setMin(0.5);
    bunsPerPerson.setStep(0.5);
    bunsPerPerson.setMinWidth("15em");
    binder
        .forField(bunsPerPerson)
        .withConverter(BigDecimal::valueOf, BigDecimal::doubleValue)
        .bind(CalculatorViewModel::getNumberOfBuns, CalculatorViewModel::setNumberOfBuns);
  }

  private void initHackPerBun() {
    hackPerBun = new NumberField(getTranslation("view.calculator.hackPerBun"));
    hackPerBun.setId("hackPerBun");
    hackPerBun.setHasControls(true);
    hackPerBun.setMin(5);
    hackPerBun.setStep(5);
    hackPerBun.setMinWidth("15em");
    binder
        .forField(hackPerBun)
        .withConverter(BigDecimal::valueOf, BigDecimal::doubleValue)
        .bind(CalculatorViewModel::getHackPerBun, CalculatorViewModel::setHackPerBun);
  }

  private void initNumberOfPersons() {
    numberOfPersons = new NumberField(getTranslation("view.calculator.numberOfPersons"));
    numberOfPersons.setId("numberOfPersons");
    numberOfPersons.setHasControls(true);
    numberOfPersons.setMin(1);
    numberOfPersons.setMinWidth("15em");
    numberOfPersons.setValueChangeMode(ValueChangeMode.ON_CHANGE);
    binder
        .forField(numberOfPersons)
        .withConverter(BigDecimal::valueOf, BigDecimal::doubleValue)
        .bind(CalculatorViewModel::getNumberOfPersons, CalculatorViewModel::setNumberOfPersons);
  }

  @Override
  public void setParameter(BeforeEvent event, @OptionalParameter String workspaceId) {
    System.out.println(getClass() + ": " + workspaceId);
  }
}
