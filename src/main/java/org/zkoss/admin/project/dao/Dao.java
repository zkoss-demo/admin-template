package org.zkoss.admin.project.dao;

import org.zkoss.admin.util.Util;

import java.time.*;
import java.util.*;

public class Dao {
    static Integer[] issues = new Integer[Util.MONTHS.length];
    static Integer[] tasks = new Integer[Util.MONTHS.length];
    static String line = "Send payment today,Post Banner on official website, Meeting with BD team, Setting Github repository, Calling manager, Book flight for business trip";
    static String[] todoList = line.split(", ");
    static List<Activity> activityList = new LinkedList<>();

    static String[] NAMES = {"Matthew", "Lucas", "John", "Peter"};
    static String[] TASKS = {"draft design", "study GDPR", "release product", "layout pages"};
    static String[] PROJECTS = {"MedicalPro", "Real Home", "Digital Agency", "Elite Force"};

    static{
        for (int i = 0 ; i < Util.MONTHS.length ; i++) {
            issues[i] = Util.nextInt(50, 0);
        }

        for (int i = 0 ; i < Util.MONTHS.length ; i++) {
            tasks[i] = Util.nextInt(50, 0);
        }

        for (int i = 0 ; i < NAMES.length ; i++) {
            Activity activity = new Activity();
            activity.setOwner(NAMES[i]);
            activity.setTask(TASKS[i]);
            activity.setProject(PROJECTS[i]);
            activity.setCompletedTime(toDate(LocalDateTime.now().minusDays(Util.nextInt(10, 1))));
            activityList.add(activity);
        }
    }

    public static Date toDate(LocalDateTime dateTime){
        return java.sql.Timestamp.valueOf(dateTime);
    }

    public static Integer[] queryIssues(){
        return issues;
    }

    public static Integer[] queryTasks(){
        return tasks;
    }

    public static String[] getTodoList() {
        return todoList;
    }

    public static List<Activity> getActivityList() {
        return activityList;
    }
}
