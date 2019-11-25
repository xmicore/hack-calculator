package de.pmrd.hackcalculator.history;

import java.util.Set;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

public class HistoryConverter implements GenericConverter {

  @Override
  public Set<ConvertiblePair> getConvertibleTypes() {
    return Set.of(
        new ConvertiblePair(HistoryBackendModel.class, HistoryViewItem.class),
        new ConvertiblePair(HistoryViewItem.class, HistoryBackendModel.class));
  }

  @Override
  public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
    final Object converted;
    if (HistoryBackendModel.class == sourceType.getType()
        && HistoryViewItem.class == targetType.getType()
        && source instanceof HistoryBackendModel) {
      converted = convertFromBackendToView((HistoryBackendModel) source);
    } else if (HistoryViewItem.class == sourceType.getType()
        && HistoryBackendModel.class == targetType.getType()
        && source instanceof HistoryViewItem) {
      converted = convertFromViewToBackend((HistoryViewItem) source);
    } else {
      throw new ConverterNotFoundException(sourceType, targetType);
    }
    return converted;
  }

  private HistoryViewItem convertFromBackendToView(HistoryBackendModel backendModel) {
    HistoryViewItem viewModel = new HistoryViewItem();
    viewModel.setDateSavedToHistory(backendModel.getDateSavedToHistory());
    viewModel.setHackInGramsPerBuns(backendModel.getHackInGramsPerBun());
    viewModel.setHackInGramsTotal(backendModel.getHackInGramsTotal());
    viewModel.setNumberOfBuns(backendModel.getNumberOfBuns());
    return viewModel;
  }

  private HistoryBackendModel convertFromViewToBackend(HistoryViewItem viewModel) {
    HistoryBackendModel backendModel = new HistoryBackendModel();
    backendModel.setDateSavedToHistory(viewModel.getDateSavedToHistory());
    backendModel.setHackInGramsPerBun(viewModel.getHackInGramsPerBuns());
    backendModel.setHackInGramsTotal(viewModel.getHackInGramsTotal());
    backendModel.setNumberOfBuns(viewModel.getNumberOfBuns());
    return backendModel;
  }
}
