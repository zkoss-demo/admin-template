package org.zkoss.admin.ecommerce;

import org.zkoss.chart.model.*;

import java.text.DateFormatSymbols;
import java.util.*;

/**
 * Data access object
 */
public class Dao {
    public static Random random = new Random();
    private static final CategoryModel revenueModel;
    static public String[] PRODUCT_NAMES = {"Charts", "Framework", "Theme Pack", "Spreadsheet", "Calendar", "Pivot Table"};
    static private List<Product> productList = new LinkedList<>();
    private static final CategoryModel productImportModel;
    static String[] MONTHS = new DateFormatSymbols().getMonths();

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
    }

    static public CategoryModel getRevenueModel() {
        return revenueModel;
    }

    static public List<Product> queryProduct(){
        if (productList.size() == 0) {
            for (String name : PRODUCT_NAMES) {
                Product product = new Product(name);
                product.setQuantity(random.nextInt(100));
                product.setPrice(random.nextInt(1000) / 10);
                productList.add(product);
            }
        }
        return productList;
    }

    public static ChartsModel getProductImportData() {
        return productImportModel;
    }
}
