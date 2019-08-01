package org.zkoss.admin.ecommerce.dao;

import org.zkoss.admin.navigation.NavigationMdel;
import org.zkoss.admin.navigation.Menu;
import org.zkoss.admin.util.Util;
import org.zkoss.chart.model.*;

import java.util.*;

/**
 * Data access object
 */
public class EcommerceDao {
    private static CategoryModel revenueModel;
    private static CategoryModel productImportModel;
    private static List<Product> productList = new LinkedList<>();

    public static String[] PRODUCT_NAMES = {"Charts", "Framework", "Theme Pack", "Spreadsheet", "Calendar", "Pivot Table"};

    static {
        revenueModel = new DefaultCategoryModel();
        for (String month : Util.MONTHS) {
            revenueModel.setValue(PRODUCT_NAMES[1], month, Util.random.nextInt(10000));
            revenueModel.setValue(PRODUCT_NAMES[3], month, Util.random.nextInt(10000));
        }

        productImportModel = new DefaultCategoryModel();
        for (String month : Util.MONTHS) {
            productImportModel.setValue(PRODUCT_NAMES[3], month, Util.random.nextInt(10000));
            productImportModel.setValue(PRODUCT_NAMES[4], month, Util.random.nextInt(10000));
        }

        for (String name : PRODUCT_NAMES) {
            Product product = new Product(name);
            product.setQuantity(Util.nextInt(20, 100));
            product.setPrice(Util.nextInt(100,1000) / 10);
            productList.add(product);
        }
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
}
