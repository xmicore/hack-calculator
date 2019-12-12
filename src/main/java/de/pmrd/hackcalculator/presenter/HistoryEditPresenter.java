package de.pmrd.hackcalculator.presenter;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import de.pmrd.hackcalculator.service.HistoryService;
import de.pmrd.hackcalculator.service.model.HistoryBackendItem;
import de.pmrd.hackcalculator.view.contracts.HistoryEditView;
import de.pmrd.hackcalculator.view.events.HistoryEditViewBeforeInitEvent;
import de.pmrd.hackcalculator.view.events.HistoryEditViewInitEvent;
import de.pmrd.hackcalculator.view.events.HistoryUpdateEvent;
import de.pmrd.hackcalculator.view.model.HistoryEditViewModel;
import de.pmrd.hackcalculator.view.model.HistoryViewItem;
import org.springframework.context.event.EventListener;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class HistoryEditPresenter {

  private final ConversionService converter;
  private final HistoryService backend;
  private HistoryEditView view;
  private HistoryEditViewModel model;

  public HistoryEditPresenter(ConversionService converter, HistoryService backend) {
    this.converter = converter;
    this.backend = backend;
    this.model = new HistoryEditViewModel();
  }

  public void setView(HistoryEditView view) {
    this.view = view;
  }

  @EventListener
  public void beforeInit(HistoryEditViewBeforeInitEvent event) {
    final HistoryBackendItem backendItem = backend.getHistoryItem(event.getItemId());
    final HistoryViewItem viewItem = converter.convert(backendItem, HistoryViewItem.class);
    model.setItem(viewItem);
  }

  @EventListener
  public void init(HistoryEditViewInitEvent event) {
    view.setHistoryItem(model.getItem());
  }

  @EventListener
  public void save(HistoryUpdateEvent event) {
    final HistoryBackendItem item = converter.convert(event.getItem(), HistoryBackendItem.class);
    backend.saveHistoryItem(item);
  }
}
