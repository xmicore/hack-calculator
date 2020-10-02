package de.pmrd.hackcalculator.service.model;

import java.util.UUID;

public class Workspace {

    private UUID id;
    private String name;

    public Workspace() {
    }

    public Workspace(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
