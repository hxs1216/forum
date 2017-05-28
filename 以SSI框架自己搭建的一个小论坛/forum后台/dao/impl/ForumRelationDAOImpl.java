package com.nuchina.forum.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nuchina.common.base.BaseDaoImpl;
import com.nuchina.forum.dao.IForumRelationDAO;
import com.nuchina.forum.model.ForumRelation;
import com.nuchina.forum.model.ForumRelationExample;
@Repository("forumRelationDAO")
public class ForumRelationDAOImpl extends BaseDaoImpl implements IForumRelationDAO {

    public ForumRelationDAOImpl() {
        super();
    }

    public int countByExample(ForumRelationExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_forum_relation.countByExample", example);
        return count;
    }

    public int deleteByExample(ForumRelationExample example) {
        int rows = getSqlMapClientTemplate().delete("t_forum_relation.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) {
        ForumRelation _key = new ForumRelation();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("t_forum_relation.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(ForumRelation record) {
        getSqlMapClientTemplate().insert("t_forum_relation.insert", record);
    }

    public void insertSelective(ForumRelation record) {
        getSqlMapClientTemplate().insert("t_forum_relation.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<ForumRelation> selectByExample(ForumRelationExample example) {
        List<ForumRelation> list = getSqlMapClientTemplate().queryForList("t_forum_relation.selectByExample", example);
        return list;
    }

    public ForumRelation selectByPrimaryKey(Integer id) {
        ForumRelation _key = new ForumRelation();
        _key.setId(id);
        ForumRelation record = (ForumRelation) getSqlMapClientTemplate().queryForObject("t_forum_relation.selectByPrimaryKey", _key);
        return record;
    }
    
    @SuppressWarnings("unchecked")
	public List<ForumRelation> selectByUserId(Map<String , Object> map) {
		List<ForumRelation> aa = getSqlMapClientTemplate().queryForList("t_forum_relation.relations", map);
        return aa;
	}

    public int updateByExampleSelective(ForumRelation record, ForumRelationExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_forum_relation.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(ForumRelation record, ForumRelationExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_forum_relation.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(ForumRelation record) {
        int rows = getSqlMapClientTemplate().update("t_forum_relation.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(ForumRelation record) {
        int rows = getSqlMapClientTemplate().update("t_forum_relation.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends ForumRelationExample {
        private Object record;

        public UpdateByExampleParms(Object record, ForumRelationExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	
}