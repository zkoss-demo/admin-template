package org.zkoss.admin;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.*;

import static org.zkoss.admin.MainVM.NAVIGATION;

public class SidebarVM {
    private NavigationMdel navigationModel;

    @Init
    public void init(@ScopeParam(NAVIGATION)NavigationMdel navModel){
        navigationModel = navModel;
    }

    @Command
    public void navigate(@BindingParam("page")String page){
        navigationModel.setContentUrl(page);
        BindUtils.postNotifyChange(null, null, navigationModel, "contentUrl");
    }
}
