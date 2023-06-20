package com.day_record.server.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author JereChen
 */
public class YearTaskBean {
    @Nullable
    private Long id;
    /**
     * 任务名称
     * 如：练习篮球。
     */
    @NotBlank(message = "taskName is not blank")
    private String taskName;
    /**
     * 打卡目标天数
     * 如：60，表示打卡目标天数为60天。
     */
    @NotNull(message = "target not null")
    private Integer target;

    /**
     * 打卡进度
     * 如：15，表示打卡了15天。
     */
    @NotNull(message = "progress not null")
    private Integer progress;
    /**
     * 创建日期
     * 如：2022-9-19
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;
    /**
     * 结束日期
     * 如：2023-9-19
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date finishDate;
    /**
     * 表示任务是否结束
     * 0 -> false
     * 1 -> true。表示打卡了60天。
     */
    private Boolean isFinish;

    public YearTaskBean(@Nullable Long id, String taskName, Integer target, int progress,
                        Date createDate, Date finishDate, Boolean isFinish) {
        this.id = id;
        this.taskName = taskName;
        this.target = target;
        this.progress = progress;
        this.createDate = createDate;
        this.finishDate = finishDate;
        this.isFinish = isFinish;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {

        this.createDate = createDate;
    }

    public void setCreateDate(String createDate) {
        Date newCreateDate = new Date();
        try {
            newCreateDate = new SimpleDateFormat("yyyy-MM-dd").parse(createDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.createDate = newCreateDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Boolean getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Boolean isFinish) {
        this.isFinish = isFinish;
    }

    @Override
    public String toString() {
        return "YearTaskBean{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", target=" + target +
                ", progress=" + progress +
                ", createDate=" + createDate +
                ", finishDate=" + finishDate +
                ", isFinish=" + isFinish +
                '}';
    }
}
