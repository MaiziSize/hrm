package com.jk.hrm.service.impl;

import com.jk.hrm.bean.Notice;
import com.jk.hrm.dao.NoticeMapper;
import com.jk.hrm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    @Override
    public void saveNotice(Notice notice) {
        noticeMapper.save(notice);
    }

    @Override
    public List<Notice> finAllNotice() {
        return noticeMapper.findByPage(null);
    }

    @Override
    public Notice getById(int id) {
        return noticeMapper.get(id);
    }

    @Override
    public void updateNotice(Notice notice) {
        noticeMapper.update(notice);
    }

    @Override
    public void deleteNotice(int id) {
        noticeMapper.delete(id);
    }

    @Override
    public Notice getId(int id) {
        return noticeMapper.get1(id);
    }

    @Override
    public List<Notice> selectNotice(Notice notice)
    {
        return noticeMapper.selectNotice(notice);
    }

}
