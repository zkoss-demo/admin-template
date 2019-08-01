package org.zkoss.admin.navigation;

import java.util.*;

public class Menu {
    private String label;
    private List<Menu> subMenus = new ArrayList<>();
    private String icon;
    private String path = NavigationMdel.BLANK_ZUL;
    private int counter;

    public Menu() {
    }

    public Menu(String label) {
        this.label = label;
    }

    public Menu(String label, String icon) {
        this.label = label;
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
