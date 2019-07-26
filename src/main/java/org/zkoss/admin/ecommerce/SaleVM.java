package org.zkoss.admin.ecommerce;

import org.zkoss.admin.ecommerce.dao.*;
import org.zkoss.bind.annotation.*;

import java.util.List;

public class SaleVM {

    private List<Product> productList;

    @Init
    public void init(){
        productList = EcommerceDao.queryProduct();
    }

    public List<Product> getProductList() {
        return productList;
    }
}
