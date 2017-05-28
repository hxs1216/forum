package com.nuchina.forum.dao;

import com.nuchina.forum.model.ForumPublish;
import com.nuchina.forum.model.ForumPublishExample;
import java.util.List;
import java.util.Map;

public interface IForumPublishDAO {
    int countByExample(ForumPublishExample example);
    
    int countByCondition(String condition);
    
    int deleteByExample(ForumPublishExample example);

    int deleteByPrimaryKey(Integer id);

    void insert(ForumPublish record);

    void insertSelective(ForumPublish record);

    List<ForumPublish> selectByExample(ForumPublishExample example);

    ForumPublish selectByPrimaryKey(Integer id);
    
    List<ForumPublish> selectByCondition(Map<String,Object> map);

    int updateByExampleSelective(ForumPublish record, ForumPublishExample example);

    int updateByExample(ForumPublish record, ForumPublishExample example);

    int updateByPrimaryKeySelective(ForumPublish record);

    int updateByPrimaryKey(ForumPublish record);
    
    List<Map<String,Object>> orderReplyTime(Map<String,Object> map);
    
    int orderReplyTimeCount(Map<String,Object> map);
    
}