package de.pmrd.hackcalculator.view.events;

import org.springframework.context.ApplicationEvent;

import java.util.UUID;

public class HistoryEditViewBeforeInitEvent extends ApplicationEvent {

    private final UUID itemId;

    public HistoryEditViewBeforeInitEvent(Object source, UUID itemId) {
        super(source);
        this.itemId = itemId;
    }

    public UUID getItemId() {
        return itemId;
    }
}
