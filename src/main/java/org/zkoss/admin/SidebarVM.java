package org.zkoss.admin;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.*;

import static org.zkoss.admin.MainVM.NAVIGATION;

public class SidebarVM {
    private NavigationMdel navigationModel;
    private int counter[] = {2, 5};
    private String userName = "Admin";
    private String sidebarTemplate = "sidebar-md";

    @Init
    public void init(@ScopeParam(NAVIGATION)NavigationMdel navModel){
        navigationModel = navModel;
    }

    @Command
    public void navigate(@BindingParam("page")String page){
        navigationModel.setContentUrl(page);
        BindUtils.postNotifyChange(null, null, navigationModel, "contentUrl");
    }

    @MatchMedia("all and (min-width: 768px)")
    @NotifyChange("sidebarTemplate")
    public void beWide(){
        sidebarTemplate = "sidebar-md";
    }

    @MatchMedia("all and (max-width: 767px)")
    @NotifyChange("sidebarTemplate")
    public void beNarrow(){
        sidebarTemplate = "sidebar";
    }

    public int[] getCounter() {
        return counter;
    }

    public String getUserName() {
        return userName;
    }

    public String getSidebarTemplate() {
        return sidebarTemplate;
    }
}
