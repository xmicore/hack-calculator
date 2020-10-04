package de.pmrd.hackcalculator.view.layout.components;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;


public class Header extends Composite<FlexLayout> {

    @Override
    protected FlexLayout initContent() {
        FlexLayout content = new FlexLayout();
        content.setClassName("branding");
        content.add(getLogo(), getLabel());
        content.setAlignSelf(Alignment.CENTER);
        return content;
    }

    private Span getLogo() {
        Image logo = new Image("icons/icon.png", "logo");
        Span span = new Span(logo);
        span.setClassName("branding__logo");
        return span;
    }

    private Label getLabel() {
        Label label = new Label("Hack-Calculator");
        label.addClassName("branding_label");
        return label;
    }
}
