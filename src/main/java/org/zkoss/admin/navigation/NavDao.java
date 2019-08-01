package org.zkoss.admin.navigation;

import org.zkoss.admin.util.Util;

import java.util.*;

public class NavDao {
    private static List<Menu> menuList = new LinkedList<>();

    static{
        initMenus();
    }

    static public void initMenus(){
        Menu menuD = new Menu("Dashboard", "z-icon-home");
        menuD.setCounter(Util.nextInt(1, 10));
        Menu menuE = new Menu("Ecommerce");
        menuE.setPath(NavigationMdel.DASHBOARD_ECOMMERCE_ZUL);
        Menu menuP = new Menu("Project");
        menuP.setPath(NavigationMdel.DASHBOARD_PROJECT_ZUL);
        List<Menu> subMenus = new ArrayList<>();
        subMenus.add(menuE);
        subMenus.add(menuP);
        menuD.setSubMenus(subMenus);
        menuList.add(menuD);

        Menu menuT = new Menu("Typography", "z-icon-flag-o");
        menuList.add(menuT);
        Menu menuUI = new Menu("UI Elements", "z-icon-flag-o");
        menuList.add(menuUI);
        Menu menuTable = new Menu("Tables", "z-icon-flag-o");
        menuList.add(menuTable);

        Menu menuC = new Menu("Contact", "z-icon-envelope-o");
        menuC.setCounter(Util.nextInt(1, 10));
        menuList.add(menuC);
        Menu menuF = new Menu("Freeze", "z-icon-snowflake-o");
        menuList.add(menuF);
        Menu menuL = new Menu("Logout", "z-icon-power-off");
        menuList.add(menuL);
    }

    static public List<Menu> queryMenu(){
        return menuList;
    }
}
