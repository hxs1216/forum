package com.nuchina.forum.dao;

import com.nuchina.forum.model.ForumRelation;
import com.nuchina.forum.model.ForumRelationExample;
import java.util.List;
import java.util.Map;

public interface IForumRelationDAO {
    int countByExample(ForumRelationExample example);

    int deleteByExample(ForumRelationExample example);

    int deleteByPrimaryKey(Integer id);

    void insert(ForumRelation record);

    void insertSelective(ForumRelation record);

    List<ForumRelation> selectByExample(ForumRelationExample example);

    ForumRelation selectByPrimaryKey(Integer id);
    
    List<ForumRelation> selectByUserId(Map<String , Object> map);

    int updateByExampleSelective(ForumRelation record, ForumRelationExample example);

    int updateByExample(ForumRelation record, ForumRelationExample example);

    int updateByPrimaryKeySelective(ForumRelation record);

    int updateByPrimaryKey(ForumRelation record);
    
}