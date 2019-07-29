package org.zkoss.admin.project;

import org.zkoss.admin.project.dao.*;
import org.zkoss.zul.ListModelList;

public class ProgressVM {
    private ListModelList<Activity> progressList;
    private ListModelList<Status> statusModel = new ListModelList<>(Status.values());

    public ProgressVM(){
        progressList = new ListModelList<>(ProjectDao.getActivityList());
    }

    public ListModelList<Activity> getProgressList() {
        return progressList;
    }

    public ListModelList<Status> getStatusModel() {
        return statusModel;
    }
}
