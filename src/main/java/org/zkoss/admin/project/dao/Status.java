package org.zkoss.admin.project.dao;

public enum Status {
    HOLD("On Hold"), PROGRESS("In Progress"), OUTDATED("Outdated");

    private String text;

    Status(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return this.text;
    }
}
