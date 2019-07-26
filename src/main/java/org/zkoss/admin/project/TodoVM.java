package org.zkoss.admin.project;

import org.zkoss.admin.project.dao.ProjectDao;
import org.zkoss.zul.ListModelList;

public class TodoVM {
    private ListModelList<String> todoList;

    public TodoVM(){
        todoList = new ListModelList<>(ProjectDao.getTodoList());
        todoList.setMultiple(true);
        todoList.addToSelection(todoList.get(2));
    }

    public ListModelList<String> getTodoList() {
        return todoList;
    }
}
