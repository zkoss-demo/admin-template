package org.zkoss.admin.ecommerce;

import org.zkoss.admin.ecommerce.dao.EcommerceDao;
import org.zkoss.admin.util.Util;
import org.zkoss.bind.annotation.*;
import org.zkoss.chart.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;

public class ProductImportVM {
    @Wire
    Charts chart;

    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);

        initChartModel();
    }

    private void initChartModel() {
        chart.setModel(EcommerceDao.getProductImportData());

        chart.getXAxis().setCrosshair(true);

        chart.getYAxis().setMin(0);
        chart.getYAxis().getTitle().setText("Sales ($)");

        Tooltip tooltip = chart.getTooltip();
        tooltip.setHeaderFormat("<span style=\"font-size:10px\">{point.key}</span><table>");
        tooltip.setPointFormat("<tr><td style=\"color:{series.color};padding:0\">{series.name}: </td>"
                + "<td style=\"padding:0\"><b>{point.y:.1f} $</b></td></tr>");
        tooltip.setFooterFormat("</table>");
        tooltip.setShared(true);
        tooltip.setUseHTML(true);

        chart.getPlotOptions().getColumn().setPointPadding(0.2);
        chart.getPlotOptions().getColumn().setBorderWidth(0);
        Util.setupColor(chart);
    }
}
