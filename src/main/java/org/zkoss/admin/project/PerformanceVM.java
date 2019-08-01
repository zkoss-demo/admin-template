package org.zkoss.admin.project;

import org.zkoss.admin.project.dao.ProjectDao;
import org.zkoss.admin.util.BsColor;
import org.zkoss.bind.annotation.*;
import org.zkoss.chart.*;
import org.zkoss.zk.ui.Component;

public class PerformanceVM {

    private Charts chart;

    @Command
    public void init(@ContextParam(ContextType.COMPONENT) Component component){
        chart = (Charts)component;

        Series series1 = chart.getSeries();
        series1.setColor(BsColor.PRIMARY.getHexCode());
        series1.setName("Issues");
        chart.getPlotOptions().getAreaSpline().setFillOpacity(0.1);
        chart.getPlotOptions().getAreaSpline().getMarker().setEnabled(false);
        series1.setData(ProjectDao.queryIssues());
        Series series2 = chart.getSeries(1);
        series2.setColor(BsColor.DANGER.getHexCode());
        series2.setName("Tasks");
        series2.setData(ProjectDao.queryTasks());
    }

}
