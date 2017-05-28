package com.nuchina.forum.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nuchina.common.base.BaseDaoImpl;
import com.nuchina.forum.dao.IForumPublishDAO;
import com.nuchina.forum.model.ForumPublish;
import com.nuchina.forum.model.ForumPublishExample;
@Repository("forumPublishDAO")
public class ForumPublishDAOImpl extends BaseDaoImpl implements IForumPublishDAO {

    public ForumPublishDAOImpl() {
        super();
    }

    public int countByExample(ForumPublishExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_forum_publish.countByExample", example);
        return count;
    }
    
    @Override
	public int countByCondition(String condition) {
    	Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_forum_publish.countByCondition", condition);
		return count;
	}
    
    public int deleteByExample(ForumPublishExample example) {
        int rows = getSqlMapClientTemplate().delete("t_forum_publish.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) {
        ForumPublish _key = new ForumPublish();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("t_forum_publish.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(ForumPublish record) {
        getSqlMapClientTemplate().insert("t_forum_publish.insert", record);
    }

    public void insertSelective(ForumPublish record) {
        getSqlMapClientTemplate().insert("t_forum_publish.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<ForumPublish> selectByExample(ForumPublishExample example) {
        List<ForumPublish> list = getSqlMapClientTemplate().queryForList("t_forum_publish.selectByExample", example);
        return list;
    }
    
    @SuppressWarnings("unchecked")
	@Override
	public List<ForumPublish> selectByCondition(Map<String,Object> map) {
		List<ForumPublish> list = getSqlMapClientTemplate().queryForList("t_forum_publish.selectByCondition", map);
		return list;
	}
    
    public ForumPublish selectByPrimaryKey(Integer id) {
        ForumPublish _key = new ForumPublish();
        _key.setId(id);
        ForumPublish record = (ForumPublish) getSqlMapClientTemplate().queryForObject("t_forum_publish.selectByPrimaryKey", _key);
        return record;
    }
    
    public int updateByExampleSelective(ForumPublish record, ForumPublishExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_forum_publish.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(ForumPublish record, ForumPublishExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_forum_publish.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(ForumPublish record) {
        int rows = getSqlMapClientTemplate().update("t_forum_publish.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(ForumPublish record) {
        int rows = getSqlMapClientTemplate().update("t_forum_publish.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends ForumPublishExample {
        private Object record;

        public UpdateByExampleParms(Object record, ForumPublishExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	public List<Map<String,Object>> orderReplyTime(Map<String, Object> map) {
		List<Map<String,Object>> list = getSqlMapClientTemplate().queryForList("t_forum_publish.orderReplyTime", map);
		return list;
		
	}
	
	public int orderReplyTimeCount(Map<String, Object> map) {
		int count = (Integer)getSqlMapClientTemplate().queryForObject("t_forum_publish.orderReplyTimeCount", map);
		return count;
		
	}

	


}