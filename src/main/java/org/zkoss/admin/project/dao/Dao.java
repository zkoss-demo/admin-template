package org.zkoss.admin.project.dao;

import org.zkoss.admin.util.Util;

public class Dao {
    static Integer[] issues = new Integer[Util.MONTHS.length];
    static Integer[] tasks = new Integer[Util.MONTHS.length];

    static{
        for (int i = 0 ; i < Util.MONTHS.length ; i++) {
            issues[i] = Util.nextInt(50, 0);
        }

        for (int i = 0 ; i < Util.MONTHS.length ; i++) {
            tasks[i] = Util.nextInt(50, 0);
        }
    }

    public static Integer[] queryIssues(){
        return issues;
    }

    public static Integer[] queryTasks(){
        return tasks;
    }
}
