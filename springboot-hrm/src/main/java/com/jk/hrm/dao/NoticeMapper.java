package com.jk.hrm.dao;

import com.jk.hrm.base.BaseMapper;
import com.jk.hrm.bean.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;

/**
 * NoticeMapper 数据访问类
 * @author qxy
 * @email 1766181826@qq.com
 * @date 2019-07-29 13:40:41
 * @version 1.0
 */
@Mapper
public interface NoticeMapper extends BaseMapper {
    /**
     * 根据主键获取实体
     * @param id 主键ID
     * @return 实体
     */
    public <T> T get1(Serializable id);
    List<Notice> selectNotice(Notice notice);

}