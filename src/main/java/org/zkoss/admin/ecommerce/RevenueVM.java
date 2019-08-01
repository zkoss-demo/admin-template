package org.zkoss.admin.ecommerce;

import org.zkoss.admin.ecommerce.dao.EcommerceDao;
import org.zkoss.admin.util.*;
import org.zkoss.bind.annotation.*;
import org.zkoss.chart.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;

public class RevenueVM {

    @Wire
    Charts chart;

    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);

        chart.setModel(EcommerceDao.getRevenueModel());

        chart.getTitle().setX(-20);
        chart.getSubtitle().setX(-20);
        chart.getYAxis().setTitle("dollars");
        PlotLine plotLine = new PlotLine();
        plotLine.setValue(0);
        plotLine.setWidth(1);
        plotLine.setColor("#808080");
        chart.getPlotOptions().getAreaSpline().setFillOpacity(0.1);
        chart.getPlotOptions().getAreaSpline().getMarker().setEnabled(false);
        chart.getYAxis().addPlotLine(plotLine);
        chart.getTooltip().setValueSuffix("$");

        Legend legend = chart.getLegend();
        legend.setLayout("vertical");
        legend.setAlign("right");
        legend.setVerticalAlign("middle");
        legend.setBorderWidth(0);
        Util.setupColor(chart);
    }
}
