package de.pmrd.hackcalculator.presenter.converter;

import de.pmrd.hackcalculator.service.model.HistoryBackendItem;
import de.pmrd.hackcalculator.view.model.HistoryViewItem;
import java.math.RoundingMode;
import java.util.Set;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

public class HistoryConverter implements GenericConverter {

  @Override
  public Set<ConvertiblePair> getConvertibleTypes() {
    return Set.of(
        new ConvertiblePair(HistoryBackendItem.class, HistoryViewItem.class),
        new ConvertiblePair(HistoryViewItem.class, HistoryBackendItem.class));
  }

  @Override
  public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
    final Object converted;
    if (HistoryBackendItem.class == sourceType.getType()
        && HistoryViewItem.class == targetType.getType()
        && source instanceof HistoryBackendItem) {
      converted = convertFromBackendToView((HistoryBackendItem) source);
    } else if (HistoryViewItem.class == sourceType.getType()
        && HistoryBackendItem.class == targetType.getType()
        && source instanceof HistoryViewItem) {
      converted = convertFromViewToBackend((HistoryViewItem) source);
    } else {
      throw new ConverterNotFoundException(sourceType, targetType);
    }
    return converted;
  }

  private HistoryViewItem convertFromBackendToView(HistoryBackendItem backendModel) {
    HistoryViewItem viewModel = new HistoryViewItem();
    viewModel.setId(backendModel.getId());
    viewModel.setSavedToHistory(backendModel.getSavedToHistory());
    viewModel.setModified(backendModel.getModified());
    if (backendModel.getHackPerBun() != null) {
      viewModel.setHackPerBun(backendModel.getHackPerBun().setScale(2, RoundingMode.HALF_UP));
    }
    if (backendModel.getHackTotal() != null) {
      viewModel.setHackTotal(backendModel.getHackTotal().setScale(2, RoundingMode.HALF_UP));
    }
    if (backendModel.getNumberOfBuns() != null) {
      viewModel.setNumberOfBuns(backendModel.getNumberOfBuns().setScale(1, RoundingMode.HALF_UP));
    }
    if (backendModel.getNumberOfPersons() != null) {
      viewModel.setNumberOfPersons(
          backendModel.getNumberOfPersons().setScale(1, RoundingMode.HALF_UP));
    }
    return viewModel;
  }

  private HistoryBackendItem convertFromViewToBackend(HistoryViewItem viewModel) {
    HistoryBackendItem backendModel = new HistoryBackendItem();
    backendModel.setId(viewModel.getId());
    backendModel.setSavedToHistory(viewModel.getSavedToHistory());
    backendModel.setModified(viewModel.getModified());
    backendModel.setHackPerBun(viewModel.getHackPerBun());
    backendModel.setHackTotal(viewModel.getHackTotal());
    backendModel.setNumberOfBuns(viewModel.getNumberOfBuns());
    backendModel.setNumberOfPersons(viewModel.getNumberOfPersons());
    return backendModel;
  }
}
