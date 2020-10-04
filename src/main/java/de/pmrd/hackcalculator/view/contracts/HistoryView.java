package de.pmrd.hackcalculator.view.contracts;

import de.pmrd.hackcalculator.view.model.HistoryViewItem;

import java.util.Collection;

public interface HistoryView {

    String VIEW_NAME = "history";

    void setHistoryData(Collection<HistoryViewItem> data);

}
