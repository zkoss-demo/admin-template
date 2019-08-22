package org.zkoss.admin.ecommerce;

import org.zkoss.admin.ecommerce.dao.*;
import org.zkoss.admin.util.*;
import org.zkoss.bind.annotation.*;
import org.zkoss.chart.*;
import org.zkoss.chart.plotOptions.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;

import java.util.*;

public class MarketshareVM {
    private List<Product> productList;
    @Wire
    Charts chart;


    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);

        productList = EcommerceDao.queryProduct();
        chart.getPlotOptions().getPie().setShadow(false);
        chart.getPlotOptions().getPie().setCenter("50%", "50%");
        chart.getPlotOptions().getPie().setInnerSize("50%"); //make center hollow
        initSeries();
    }

    private void initSeries() {
        Series marketShare = chart.getSeries();
        marketShare.setName("Products");
        List<Color> colors = chart.getColors();
        int i = 0;
        for (Product product: productList) {
            String name = product.getName();
            double amount = product.getAmount();
            Point productMarketShare = new Point(name, amount);
            productMarketShare.setColor(colors.get(i));
            productMarketShare.getDataLabels().setEnabled(false);
            marketShare.addPoint(productMarketShare);
            i += 1;
            productMarketShare.setColor(BsColor.getColor(i).getHexCode());
        }
        PiePlotOptions plotOptions = new PiePlotOptions();
        plotOptions.setShowInLegend(true);
        marketShare.setPlotOptions(plotOptions);
    }

    public List<Product> getProductList() {
        return productList;
    }
}
