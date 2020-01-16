package de.pmrd.hackcalculator.view;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import de.pmrd.hackcalculator.presenter.HistoryEditPresenter;
import de.pmrd.hackcalculator.view.contracts.HistoryEditView;
import de.pmrd.hackcalculator.view.contracts.HistoryView;
import de.pmrd.hackcalculator.view.events.HistoryEditViewBeforeInitEvent;
import de.pmrd.hackcalculator.view.events.HistoryEditViewInitEvent;
import de.pmrd.hackcalculator.view.events.HistoryUpdateEvent;
import de.pmrd.hackcalculator.view.layout.DefaultLayout;
import de.pmrd.hackcalculator.view.model.HistoryViewItem;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.context.ApplicationEventPublisher;

@Route(value = HistoryEditView.VIEW_NAME, layout = DefaultLayout.class)
public class HistoryEditViewImpl extends Composite<VerticalLayout>
    implements HistoryEditView, HasDynamicTitle, HasUrlParameter<String>, AfterNavigationObserver {

  private final ApplicationEventPublisher eventPublisher;

  private Binder<HistoryViewItem> binder = new Binder<>(HistoryViewItem.class);

  private NumberField numberOfBuns;
  private NumberField numberOfPersons;
  private NumberField hackTotal;
  private Button saveBtn;
  private Button cancelBtn;

  public HistoryEditViewImpl(
      HistoryEditPresenter presenter, ApplicationEventPublisher eventPublisher) {
    this.eventPublisher = eventPublisher;
    presenter.setView(this);
  }

  @Override
  public String getPageTitle() {
    return getTranslation("view.historyEditItem.pageTitle");
  }

  @Override
  public void setHistoryItem(HistoryViewItem item) {
    binder.setBean(item);
  }

  @Override
  public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String uuid) {
    eventPublisher.publishEvent(new HistoryEditViewBeforeInitEvent(this, UUID.fromString(uuid)));
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    eventPublisher.publishEvent(new HistoryEditViewInitEvent(this));
  }

  @Override
  protected VerticalLayout initContent() {
    VerticalLayout content = new VerticalLayout();
    content.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

    initBuns();
    initNumberOfPersons();
    initHackTotal();
    initSaveBtn();
    initCancelBtn();

    content.add(numberOfBuns, numberOfPersons, hackTotal, getControls());
    return content;
  }

  private void initBuns() {
    numberOfBuns = new NumberField(getTranslation("view.history.numberOfBuns"));
    numberOfBuns.setHasControls(true);
    numberOfBuns.setMin(5);
    numberOfBuns.setStep(5);
    numberOfBuns.setMinWidth("15em");
    binder
        .forField(numberOfBuns)
        .withConverter(BigDecimal::valueOf, BigDecimal::doubleValue)
        .bind(HistoryViewItem::getNumberOfBuns, HistoryViewItem::setNumberOfBuns);
  }

  private void initNumberOfPersons() {
    numberOfPersons = new NumberField(getTranslation("view.history.numberOfPersons"));
    numberOfPersons.setHasControls(true);
    numberOfPersons.setMin(0.5);
    numberOfPersons.setStep(0.5);
    numberOfPersons.setMinWidth("15em");
    binder
        .forField(numberOfPersons)
        .withConverter(BigDecimal::valueOf, BigDecimal::doubleValue)
        .bind(HistoryViewItem::getNumberOfPersons, HistoryViewItem::setNumberOfPersons);
  }

  private void initHackTotal() {
    hackTotal = new NumberField(getTranslation("view.history.hackTotal"));
    hackTotal.setHasControls(true);
    hackTotal.setMin(1);
    hackTotal.setMinWidth("15em");
    binder
        .forField(hackTotal)
        .withConverter(BigDecimal::valueOf, BigDecimal::doubleValue)
        .bind(HistoryViewItem::getHackTotal, HistoryViewItem::setHackTotal);
  }

  private void initSaveBtn() {
    saveBtn = new Button(VaadinIcon.CHECK.create());
    saveBtn.addClickListener(
        e -> {
          eventPublisher.publishEvent(new HistoryUpdateEvent(this, binder.getBean()));
          navigateToHistoryView();
        });
  }


  private void initCancelBtn() {
    cancelBtn = new Button(VaadinIcon.CLOSE_CIRCLE_O.create());
    cancelBtn.addClickListener(e -> navigateToHistoryView());
  }

  private void navigateToHistoryView() {
    getUI().ifPresent(ui -> ui.navigate(HistoryView.VIEW_NAME));
  }

  private HorizontalLayout getControls() {
    HorizontalLayout controls = new HorizontalLayout(saveBtn, cancelBtn);
    controls.setAlignItems(FlexComponent.Alignment.CENTER);
    return controls;
  }
}
