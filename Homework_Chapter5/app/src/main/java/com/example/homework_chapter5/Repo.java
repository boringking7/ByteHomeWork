package com.example.homework_chapter5;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Repo {
    @SerializedName("feeds")
    List<Repo> feeds;
    // 用户名
    @SerializedName("user_name")
    private String name;

    // student_id
    @SerializedName("student_id")
    private String studentId;

    // 其他信息
    @SerializedName("extra_value")
    private long extraValue;

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public long getExtraValue() {
        return extraValue;
    }

}
