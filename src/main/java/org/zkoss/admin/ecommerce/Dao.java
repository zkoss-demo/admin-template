package org.zkoss.admin.ecommerce;

import org.zkoss.chart.model.*;

import java.text.DateFormatSymbols;
import java.util.Random;

/**
 * Data access object
 */
public class Dao {
    public static Random random = new Random();
    private static final CategoryModel revenueModel;
    static {
        revenueModel = new DefaultCategoryModel();
        String[] months = new DateFormatSymbols().getMonths();
        for (String month : months) {
            revenueModel.setValue("Framework", month, random.nextInt(10000));
            revenueModel.setValue("Spreadsheet", month, random.nextInt(10000));
        }
    }

    public static CategoryModel getRevenueModel() {
        return revenueModel;
    }
}
