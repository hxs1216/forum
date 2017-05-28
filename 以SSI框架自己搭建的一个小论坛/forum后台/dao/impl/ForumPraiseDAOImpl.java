package com.nuchina.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nuchina.common.base.BaseDaoImpl;
import com.nuchina.forum.dao.IForumPraiseDAO;
import com.nuchina.forum.model.ForumPraise;
import com.nuchina.forum.model.ForumPraiseExample;
@Repository("forumPraiseDAO")
public class ForumPraiseDAOImpl extends BaseDaoImpl implements IForumPraiseDAO {

    public ForumPraiseDAOImpl() {
        super();
    }

    public int countByExample(ForumPraiseExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_forum_praise.countByExample", example);
        return count;
    }

    public int deleteByExample(ForumPraiseExample example) {
        int rows = getSqlMapClientTemplate().delete("t_forum_praise.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) {
        ForumPraise _key = new ForumPraise();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("t_forum_praise.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(ForumPraise record) {
        getSqlMapClientTemplate().insert("t_forum_praise.insert", record);
    }

    public void insertSelective(ForumPraise record) {
        getSqlMapClientTemplate().insert("t_forum_praise.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<ForumPraise> selectByExample(ForumPraiseExample example) {
        List<ForumPraise> list = getSqlMapClientTemplate().queryForList("t_forum_praise.selectByExample", example);
        return list;
    }

    public ForumPraise selectByPrimaryKey(Integer id) {
        ForumPraise _key = new ForumPraise();
        _key.setId(id);
        ForumPraise record = (ForumPraise) getSqlMapClientTemplate().queryForObject("t_forum_praise.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(ForumPraise record, ForumPraiseExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_forum_praise.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(ForumPraise record, ForumPraiseExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_forum_praise.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(ForumPraise record) {
        int rows = getSqlMapClientTemplate().update("t_forum_praise.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(ForumPraise record) {
        int rows = getSqlMapClientTemplate().update("t_forum_praise.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends ForumPraiseExample {
        private Object record;

        public UpdateByExampleParms(Object record, ForumPraiseExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}