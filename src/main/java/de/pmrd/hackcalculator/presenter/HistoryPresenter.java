package de.pmrd.hackcalculator.presenter;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import de.pmrd.hackcalculator.view.model.HistoryViewItem;
import de.pmrd.hackcalculator.service.HistoryService;
import de.pmrd.hackcalculator.view.contracts.HistoryView;
import de.pmrd.hackcalculator.view.events.HistoryViewInitEvent;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.context.event.EventListener;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class HistoryPresenter {

  private final ConversionService converter;
  private final HistoryService backend;
  private HistoryView view;

  public HistoryPresenter(ConversionService converter, HistoryService backend) {
    this.converter = converter;
    this.backend = backend;
  }

  public void setView(HistoryView view) {
    this.view = view;
  }

  @EventListener
  public void init(HistoryViewInitEvent event) {
    view.setHistoryData(getHistoryData());
  }

  private Collection<HistoryViewItem> getHistoryData() {
    return backend.getHistoryItems().stream()
        .map(e -> converter.convert(e, HistoryViewItem.class))
        .collect(Collectors.toList());
  }
}
