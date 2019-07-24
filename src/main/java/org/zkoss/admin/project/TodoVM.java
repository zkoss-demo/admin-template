package org.zkoss.admin.project;

import org.zkoss.admin.project.dao.Dao;
import org.zkoss.zul.ListModelList;

public class TodoVM {
    private ListModelList<String> todoList;

    public TodoVM(){
        todoList = new ListModelList<>(Dao.getTodoList());
        todoList.setMultiple(true);
        todoList.addToSelection(todoList.get(2));
    }

    public ListModelList<String> getTodoList() {
        return todoList;
    }
}
