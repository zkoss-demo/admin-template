package org.zkoss.admin.project;

import org.zkoss.admin.project.dao.*;
import org.zkoss.zul.ListModelList;

public class ProgressSummaryVM {
    private ListModelList<Progress> progressSummary;

    public ProgressSummaryVM(){
        progressSummary = new ListModelList<>(ProjectDao.getProgressSummary());
    }

    public ListModelList<Progress> getProgressSummary() {
        return progressSummary;
    }
}
