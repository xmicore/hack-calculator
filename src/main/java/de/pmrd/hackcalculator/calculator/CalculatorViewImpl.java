package de.pmrd.hackcalculator.calculator;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import de.pmrd.hackcalculator.layout.DefaultLayout;
import org.springframework.context.ApplicationEventPublisher;

@Route(value = CalculatorViewImpl.VIEW_NAME, layout = DefaultLayout.class)
@RouteAlias(value = "", layout = DefaultLayout.class)
@PageTitle("Berechnung")
public class CalculatorViewImpl extends Composite<VerticalLayout>
    implements CalculatorView, AfterNavigationObserver {

  static final String VIEW_NAME = "calculator";

  private final ApplicationEventPublisher eventPublisher;

  private Binder<CalculatorViewModel> binder = new Binder<>(CalculatorViewModel.class);

  private NumberField numberOfPersons;
  private NumberField hackPerBun;
  private NumberField bunsPerPerson;
  private Button transferToHistory;
  private Label result;

  public CalculatorViewImpl(
      CalculatorPresenter presenter, ApplicationEventPublisher eventPublisher) {
    presenter.setView(this);
    this.eventPublisher = eventPublisher;
    init();
    bind();
  }

  private void init() {
    getContent().setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

    this.numberOfPersons = new NumberField("Anzahl der Personen");
    this.numberOfPersons.setHasControls(true);
    this.numberOfPersons.setMin(1);
    this.numberOfPersons.setValueChangeMode(ValueChangeMode.ON_CHANGE);
    getContent().add(this.numberOfPersons);

    this.hackPerBun = new NumberField("Hack pro Brötchen");
    this.hackPerBun.setHasControls(true);
    this.hackPerBun.setMin(1);
    getContent().add(this.hackPerBun);

    this.bunsPerPerson = new NumberField("Brötchen pro Person");
    this.bunsPerPerson.setHasControls(true);
    this.bunsPerPerson.setMin(0.5);
    this.bunsPerPerson.setStep(0.5);
    getContent().add(this.bunsPerPerson);

    this.result = new Label();
    this.result.setVisible(false);
    getContent().add(this.result);

    this.transferToHistory = new Button("übernehmen");
    this.transferToHistory.setIcon(new Icon(VaadinIcon.CHECK));
    getContent().add(this.transferToHistory);
  }

  private void bind() {
    binder.bind(
        numberOfPersons,
        CalculatorViewModel::getNumberOfPersons,
        CalculatorViewModel::setNumberOfPersons);
    binder.bind(hackPerBun, CalculatorViewModel::getHackPerBun, CalculatorViewModel::setHackPerBun);
    binder.bind(
        bunsPerPerson,
        CalculatorViewModel::getBunsPerPerson,
        CalculatorViewModel::setBunsPerPerson);
  }

  @Override
  public void setModel(CalculatorViewModel model) {
    binder.setBean(model);
  }

  @Override
  public void setResult(String text) {
    this.result.setVisible(true);
    this.result.setText(text);
  }

  @Override
  public void setCalculateListener(CalculateListener listener) {
    this.binder.addValueChangeListener(e -> listener.calculate());
  }

  @Override
  public void setTransferToHistoryListener(TransferToHistoryListener listener) {
    this.transferToHistory.addClickListener(e -> listener.transfer(binder.getBean()));
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    eventPublisher.publishEvent(new CalculatorViewInitEvent(this));
  }
}
