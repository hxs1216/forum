package com.nuchina.forum.dao;

import com.nuchina.forum.model.ForumReply;
import com.nuchina.forum.model.ForumReplyExample;
import java.util.List;

public interface IForumReplyDAO {
    int countByExample(ForumReplyExample example);

    int deleteByExample(ForumReplyExample example);

    int deleteByPrimaryKey(Integer id);

    void insert(ForumReply record);

    void insertSelective(ForumReply record);

    List<ForumReply> selectByExample(ForumReplyExample example);

    ForumReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(ForumReply record, ForumReplyExample example);

    int updateByExample(ForumReply record, ForumReplyExample example);

    int updateByPrimaryKeySelective(ForumReply record);

    int updateByPrimaryKey(ForumReply record);
}