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
    static public String[] productNames = {"Charts", "Framework", "Theme Pack", "Spreadsheet", "Calendar", "Pivot Table"};
    static private List<Product> productList = new LinkedList<>();

    static {
        revenueModel = new DefaultCategoryModel();
        String[] months = new DateFormatSymbols().getMonths();
        for (String month : months) {
            revenueModel.setValue("Framework", month, random.nextInt(10000));
            revenueModel.setValue("Spreadsheet", month, random.nextInt(10000));
        }
    }

    static public CategoryModel getRevenueModel() {
        return revenueModel;
    }

    static public List<Product> queryProduct(){
        if (productList.size() == 0) {
            for (String name : productNames) {
                Product product = new Product(name);
                product.setQuantity(random.nextInt(100));
                product.setPrice(random.nextInt(1000) / 10);
                productList.add(product);
            }
        }
        return productList;
    }
}
