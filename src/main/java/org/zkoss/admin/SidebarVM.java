package org.zkoss.admin;

import org.zkoss.admin.ecommerce.dao.*;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.*;

import java.util.List;

import static org.zkoss.admin.MainVM.NAVIGATION;

public class SidebarVM {
    private NavigationMdel navigationModel;
    private int counter[] = {2, 5};
    private String userName = "Admin";
    private List<Menu> menuList;
    private boolean collapsed = false; //sidebar is collapsed for narrow screen

    @Init
    public void init(@ScopeParam(NAVIGATION)NavigationMdel navModel){
        navigationModel = navModel;
        menuList = Dao.queryMenu();
    }

    @Command
    public void navigate(@BindingParam("menu")Menu menu){
        navigationModel.setContentUrl(menu.getPath());
        BindUtils.postNotifyChange(null, null, navigationModel, "contentUrl");
    }

    @MatchMedia("all and (min-width: 768px)")
    @NotifyChange("collapsed")
    public void beWide(){
        collapsed = false;
    }

    @MatchMedia("all and (max-width: 767px)")
    @NotifyChange("collapsed")
    public void beNarrow(){
        collapsed = true;
    }

    public int[] getCounter() {
        return counter;
    }

    public String getUserName() {
        return userName;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public boolean isCollapsed() {
        return collapsed;
    }

    public void setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
    }
}
