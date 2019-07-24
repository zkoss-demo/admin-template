package org.zkoss.admin.project;

import org.zkoss.admin.project.dao.Dao;
import org.zkoss.bind.annotation.*;
import org.zkoss.chart.*;
import org.zkoss.zk.ui.Component;

public class PerformanceVM {

    private Charts chart;

    @Command
    public void init(@ContextParam(ContextType.COMPONENT) Component component){
        chart = (Charts)component;

        Series series1 = chart.getSeries();
        series1.setColor("#dc3545");
        series1.setName("Issues");
        chart.getPlotOptions().getAreaSpline().setFillOpacity(0.1);
        series1.setData(Dao.queryIssues());
        Series series2 = chart.getSeries(1);
        series2.setColor("#007bff");
        series2.setName("Tasks");
        series2.setData(Dao.queryTasks());
    }

}
