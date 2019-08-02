package com.jk.hrm.service;

import com.jk.hrm.bean.Job;

import java.util.List;

public interface JobService {

    void addJob(Job job);

    List<Job> selectJobList();

    void deleteJob(int id);

    Job get(int id);

    void upDateJob(Job job);

    String loadJobAjax();
}
