package com.nuchina.forum.dao;

import com.nuchina.forum.model.ForumPraise;
import com.nuchina.forum.model.ForumPraiseExample;
import java.util.List;

public interface IForumPraiseDAO {
    int countByExample(ForumPraiseExample example);

    int deleteByExample(ForumPraiseExample example);

    int deleteByPrimaryKey(Integer id);

    void insert(ForumPraise record);

    void insertSelective(ForumPraise record);

    List<ForumPraise> selectByExample(ForumPraiseExample example);

    ForumPraise selectByPrimaryKey(Integer id);

    int updateByExampleSelective(ForumPraise record, ForumPraiseExample example);

    int updateByExample(ForumPraise record, ForumPraiseExample example);

    int updateByPrimaryKeySelective(ForumPraise record);

    int updateByPrimaryKey(ForumPraise record);
}