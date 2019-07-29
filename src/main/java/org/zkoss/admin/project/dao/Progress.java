package org.zkoss.admin.project.dao;

public class Progress {
    private String title;
    private String topic;
    private int incompleted;
    private int completed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getIncompleted() {
        return incompleted;
    }

    public void setIncompleted(int incompleted) {
        this.incompleted = incompleted;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }
}
