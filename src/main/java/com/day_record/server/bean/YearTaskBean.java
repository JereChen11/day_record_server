package com.day_record.server.bean;

public class YearTaskBean {
    private int id;
    private String taskName;
    private int target;
    private int progress;
    private String createDate;
    private String finishDate;
    private int isFinish;

    public YearTaskBean(int id, String taskName, int target, int progress, String createDate, String finishDate, int isFinish) {
        this.id = id;
        this.taskName = taskName;
        this.target = target;
        this.progress = progress;
        this.createDate = createDate;
        this.finishDate = finishDate;
        this.isFinish = isFinish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public int getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(int isFinish) {
        this.isFinish = isFinish;
    }

}
