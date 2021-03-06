package de.pmrd.hackcalculator.presenter;

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
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
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
    backend
        .getHistoryItem(event.getItemId())
        .map(e -> converter.convert(e, HistoryViewItem.class))
        .ifPresent(e -> model.setItem(e));
  }

  @EventListener
  public void init(HistoryEditViewInitEvent event) {
    view.setHistoryItem(model.getItem());
  }

  @EventListener
  public void update(HistoryUpdateEvent event) {
    final HistoryBackendItem item = converter.convert(event.getItem(), HistoryBackendItem.class);
    backend.updateHistoryItem(item);
  }
}
