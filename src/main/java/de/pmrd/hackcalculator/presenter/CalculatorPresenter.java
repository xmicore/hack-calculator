package de.pmrd.hackcalculator.presenter;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import de.pmrd.hackcalculator.service.CalculatorService;
import de.pmrd.hackcalculator.view.CalculatorView;
import de.pmrd.hackcalculator.view.event.CalculatorViewInitEvent;
import de.pmrd.hackcalculator.view.model.CalculatorViewModel;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import de.pmrd.hackcalculator.view.CalculatorView.CalculateListener;
import de.pmrd.hackcalculator.view.CalculatorView.TransferToHistoryListener;

@Component
@VaadinSessionScope
public class CalculatorPresenter implements CalculateListener, TransferToHistoryListener {

    private final CalculatorService service;

    private CalculatorView view;

    private CalculatorViewModel model;

    public CalculatorPresenter(CalculatorService service) {
        this.service = service;
    }

    public void setView(CalculatorView view) {
        this.view = view;
    }

    @Override
    public void calculate() {
        final double hack = service.calculateHack(model.getNumberOfPersons(), model.getHackPerBun(), model.getBunsPerPerson());
        this.view.setResult("Sie benötigen " + hack + "g Hack.");
    }

    @Override
    public void transfer(CalculatorViewModel model) {
        Notification.show("Historie existiert noch nicht.");
    }

    @EventListener
    public void init(CalculatorViewInitEvent event) {
        this.view.setCalculateListener(this);
        this.view.setTransferToHistoryListener(this);
        this.model = event.getModel();
        this.view.setModel(this.model);
    }

}
