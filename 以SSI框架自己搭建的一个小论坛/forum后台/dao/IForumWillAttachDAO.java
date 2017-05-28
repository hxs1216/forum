package com.nuchina.forum.dao;

import com.nuchina.forum.model.ForumWillAttach;
import com.nuchina.forum.model.ForumWillAttachExample;
import java.util.List;

public interface IForumWillAttachDAO {
    int countByExample(ForumWillAttachExample example);

    int deleteByExample(ForumWillAttachExample example);

    int deleteByPrimaryKey(Integer attachid);

    void insert(ForumWillAttach record);

    void insertSelective(ForumWillAttach record);

    List<ForumWillAttach> selectByExample(ForumWillAttachExample example);

    ForumWillAttach selectByPrimaryKey(Integer attachid);

    int updateByExampleSelective(ForumWillAttach record, ForumWillAttachExample example);

    int updateByExample(ForumWillAttach record, ForumWillAttachExample example);

    int updateByPrimaryKeySelective(ForumWillAttach record);

    int updateByPrimaryKey(ForumWillAttach record);
}