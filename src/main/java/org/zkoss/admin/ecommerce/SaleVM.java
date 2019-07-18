package org.zkoss.admin.ecommerce;

import org.zkoss.bind.annotation.*;
import org.zkoss.chart.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;

import java.util.List;

public class SaleVM {

    private List<Product> productList;

    @Init
    public void init(){
        productList = Dao.queryProduct();
    }

    public List<Product> getProductList() {
        return productList;
    }
}
