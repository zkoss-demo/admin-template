package org.zkoss.admin;

import org.zkoss.admin.navigation.NavigationMdel;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Desktop;

public class MainVM {

    public static final String NAVIGATION = "navigation";
    private NavigationMdel navigationModel;

    @Init
    public void init(@ContextParam(ContextType.DESKTOP) Desktop desktop){
        navigationModel = new NavigationMdel();
        desktop.setAttribute(NAVIGATION, navigationModel);
    }

    public String getContentUrl() {
        return navigationModel.getContentUrl();
    }

    public NavigationMdel getNavigationModel() {
        return navigationModel;
    }
}
