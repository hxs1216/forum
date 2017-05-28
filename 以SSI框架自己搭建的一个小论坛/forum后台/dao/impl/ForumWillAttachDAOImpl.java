package com.nuchina.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nuchina.common.base.BaseDaoImpl;
import com.nuchina.forum.dao.IForumWillAttachDAO;
import com.nuchina.forum.model.ForumWillAttach;
import com.nuchina.forum.model.ForumWillAttachExample;
@Repository("forumWillAttachDAO")
public class ForumWillAttachDAOImpl extends BaseDaoImpl implements IForumWillAttachDAO {

    public ForumWillAttachDAOImpl() {
        super();
    }

    public int countByExample(ForumWillAttachExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_forum_will_attach.countByExample", example);
        return count;
    }

    public int deleteByExample(ForumWillAttachExample example) {
        int rows = getSqlMapClientTemplate().delete("t_forum_will_attach.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer attachid) {
        ForumWillAttach _key = new ForumWillAttach();
        _key.setAttachid(attachid);
        int rows = getSqlMapClientTemplate().delete("t_forum_will_attach.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(ForumWillAttach record) {
        getSqlMapClientTemplate().insert("t_forum_will_attach.insert", record);
    }

    public void insertSelective(ForumWillAttach record) {
        getSqlMapClientTemplate().insert("t_forum_will_attach.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<ForumWillAttach> selectByExample(ForumWillAttachExample example) {
        List<ForumWillAttach> list = getSqlMapClientTemplate().queryForList("t_forum_will_attach.selectByExample", example);
        return list;
    }

    public ForumWillAttach selectByPrimaryKey(Integer attachid) {
        ForumWillAttach _key = new ForumWillAttach();
        _key.setAttachid(attachid);
        ForumWillAttach record = (ForumWillAttach) getSqlMapClientTemplate().queryForObject("t_forum_will_attach.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(ForumWillAttach record, ForumWillAttachExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_forum_will_attach.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(ForumWillAttach record, ForumWillAttachExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_forum_will_attach.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(ForumWillAttach record) {
        int rows = getSqlMapClientTemplate().update("t_forum_will_attach.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(ForumWillAttach record) {
        int rows = getSqlMapClientTemplate().update("t_forum_will_attach.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends ForumWillAttachExample {
        private Object record;

        public UpdateByExampleParms(Object record, ForumWillAttachExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}