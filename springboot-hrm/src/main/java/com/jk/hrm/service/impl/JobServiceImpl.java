package com.jk.hrm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jk.hrm.bean.Job;
import com.jk.hrm.dao.JobMapper;
import com.jk.hrm.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobMapper jobMapper;

    @Override
    public void addJob(Job job) {
        jobMapper.save(job);
    }
    @Override
    public List<Job> selectJobList() {
        return jobMapper.find(null);
    }
    @Override
    public void deleteJob(int id) {
        jobMapper.delete(id);
    }
    @Override
    public Job get(int id) {
        return jobMapper.get(id);
    }
    @Override
    public void upDateJob(Job job) {
        jobMapper.update(job);
    }
    @Override
    public String loadJobAjax() {
        List<Job> jobs = jobMapper.findByPage(null);
        JSONArray jsonArray = new JSONArray();
        for(Job job:jobs){
            JSONObject jsonObject =new JSONObject();
            jsonObject.put("id",job.getId());
            jsonObject.put("name",job.getName());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }

}
