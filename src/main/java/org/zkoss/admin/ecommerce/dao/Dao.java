package org.zkoss.admin.ecommerce.dao;

import org.zkoss.chart.model.*;

import java.text.DateFormatSymbols;
import java.util.*;

/**
 * Data access object
 */
public class Dao {
    public static Random random = new Random();
    private static CategoryModel revenueModel;
    private static CategoryModel productImportModel;
    private static List<Product> productList = new LinkedList<>();
    private static List<Menu> menuList = new LinkedList<>();

    static String[] MONTHS = new DateFormatSymbols().getMonths();
    public static String[] PRODUCT_NAMES = {"Charts", "Framework", "Theme Pack", "Spreadsheet", "Calendar", "Pivot Table"};

    static {
        revenueModel = new DefaultCategoryModel();
        for (String month : MONTHS) {
            revenueModel.setValue(PRODUCT_NAMES[1], month, random.nextInt(10000));
            revenueModel.setValue(PRODUCT_NAMES[3], month, random.nextInt(10000));
        }

        productImportModel = new DefaultCategoryModel();
        for (String month : MONTHS) {
            productImportModel.setValue(PRODUCT_NAMES[3], month, random.nextInt(10000));
            productImportModel.setValue(PRODUCT_NAMES[4], month, random.nextInt(10000));
        }

        for (String name : PRODUCT_NAMES) {
            Product product = new Product(name);
            product.setQuantity(nextInt(100, 20));
            product.setPrice(random.nextInt(1000) / 10);
            productList.add(product);
        }

        initMenus();
    }

    static public CategoryModel getRevenueModel() {
        return revenueModel;
    }

    static public List<Product> queryProduct(){
        return productList;
    }

    public static ChartsModel getProductImportData() {
        return productImportModel;
    }

    static int nextInt(int high, int low){
        return random.nextInt(high-low) + low;
    }

    static public List<Menu> queryMenu(){
        return menuList;
    }

    static public void initMenus(){
        Menu menuD = new Menu("Dashboard", "z-icon-home");
        Menu menuE = new Menu("Ecommerce");
        menuE.setPath("/ecommerce/ecommerce.zul");
        Menu menuP = new Menu("Project");
        menuP.setPath("/project/project.zul");
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
        menuList.add(menuC);
        Menu menuF = new Menu("Freeze", "z-icon-snowflake-o");
        menuList.add(menuF);
        Menu menuL = new Menu("Logout", "z-icon-power-off");
        menuList.add(menuL);
    }
}
