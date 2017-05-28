package com.nuchina.forum.dao;

import com.nuchina.forum.model.ForumPersonalDetail;
import com.nuchina.forum.model.ForumPersonalDetailExample;
import java.util.List;

public interface IForumPersonalDetailDAO {
    int countByExample(ForumPersonalDetailExample example);

    int deleteByExample(ForumPersonalDetailExample example);

    int deleteByPrimaryKey(Integer id);

    void insert(ForumPersonalDetail record);

    void insertSelective(ForumPersonalDetail record);

    List<ForumPersonalDetail> selectByExample(ForumPersonalDetailExample example);

    ForumPersonalDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(ForumPersonalDetail record, ForumPersonalDetailExample example);

    int updateByExample(ForumPersonalDetail record, ForumPersonalDetailExample example);

    int updateByPrimaryKeySelective(ForumPersonalDetail record);

    int updateByPrimaryKey(ForumPersonalDetail record);
}