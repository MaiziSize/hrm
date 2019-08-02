package com.jk.hrm.service;

import com.jk.hrm.bean.Notice;

import java.util.List;

public interface NoticeService {
    void saveNotice(Notice notice);
    List<Notice> finAllNotice();
    Notice getById(int id);
    void updateNotice(Notice notice);
    void deleteNotice(int id);
    Notice getId(int id);

    List<Notice> selectNotice(Notice notice);
}
