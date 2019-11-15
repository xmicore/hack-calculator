package de.pmrd.hackcalculator.view.event;

import de.pmrd.hackcalculator.view.model.CalculatorViewModel;
import org.springframework.context.ApplicationEvent;

public class CalculatorViewInitEvent extends ApplicationEvent {

    private CalculatorViewModel model;

    public CalculatorViewInitEvent(Object source) {
        this(source, new CalculatorViewModel());
    }

    public CalculatorViewInitEvent(Object source, CalculatorViewModel model) {
        super(source);
        this.model = model;
    }

    public CalculatorViewModel getModel() {
        return model;
    }
}
