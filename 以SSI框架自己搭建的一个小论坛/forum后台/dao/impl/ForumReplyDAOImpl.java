package com.nuchina.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.nuchina.common.base.BaseDaoImpl;
import com.nuchina.forum.dao.IForumReplyDAO;
import com.nuchina.forum.model.ForumReply;
import com.nuchina.forum.model.ForumReplyExample;
@Repository("forumReplyDAO")
public class ForumReplyDAOImpl extends BaseDaoImpl implements IForumReplyDAO {

    public ForumReplyDAOImpl() {
        super();
    }

    public int countByExample(ForumReplyExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_forum_reply.countByExample", example);
        return count;
    }

    public int deleteByExample(ForumReplyExample example) {
        int rows = getSqlMapClientTemplate().delete("t_forum_reply.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) {
        ForumReply _key = new ForumReply();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("t_forum_reply.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(ForumReply record) {
        getSqlMapClientTemplate().insert("t_forum_reply.insert", record);
    }

    public void insertSelective(ForumReply record) {
        getSqlMapClientTemplate().insert("t_forum_reply.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<ForumReply> selectByExample(ForumReplyExample example) {
        List<ForumReply> list = getSqlMapClientTemplate().queryForList("t_forum_reply.selectByExample", example);
        return list;
    }

    public ForumReply selectByPrimaryKey(Integer id) {
        ForumReply _key = new ForumReply();
        _key.setId(id);
        ForumReply record = (ForumReply) getSqlMapClientTemplate().queryForObject("t_forum_reply.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(ForumReply record, ForumReplyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_forum_reply.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(ForumReply record, ForumReplyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_forum_reply.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(ForumReply record) {
        int rows = getSqlMapClientTemplate().update("t_forum_reply.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(ForumReply record) {
        int rows = getSqlMapClientTemplate().update("t_forum_reply.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends ForumReplyExample {
        private Object record;

        public UpdateByExampleParms(Object record, ForumReplyExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}