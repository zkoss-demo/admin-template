package org.zkoss.admin.ecommerce;

import org.zkoss.admin.ecommerce.dao.*;
import org.zkoss.bind.annotation.Init;
import java.util.List;

public class ProductVM {
    private List<Product> productList;

    @Init
    public void init(){
        productList = EcommerceDao.queryProduct();
    }

    public List<Product> getProductList() {
        return productList;
    }
}
