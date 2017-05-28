package com.nuchina.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nuchina.common.base.BaseDaoImpl;
import com.nuchina.forum.dao.IForumPersonalDetailDAO;
import com.nuchina.forum.model.ForumPersonalDetail;
import com.nuchina.forum.model.ForumPersonalDetailExample;
@Repository("forumPersonalDetailDAO")
public class ForumPersonalDetailDAOImpl extends BaseDaoImpl implements IForumPersonalDetailDAO {

    public ForumPersonalDetailDAOImpl() {
        super();
    }

    public int countByExample(ForumPersonalDetailExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_forum_personaldetail.countByExample", example);
        return count;
    }

    public int deleteByExample(ForumPersonalDetailExample example) {
        int rows = getSqlMapClientTemplate().delete("t_forum_personaldetail.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) {
        ForumPersonalDetail _key = new ForumPersonalDetail();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("t_forum_personaldetail.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(ForumPersonalDetail record) {
        getSqlMapClientTemplate().insert("t_forum_personaldetail.insert", record);
    }

    public void insertSelective(ForumPersonalDetail record) {
        getSqlMapClientTemplate().insert("t_forum_personaldetail.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<ForumPersonalDetail> selectByExample(ForumPersonalDetailExample example) {
        List<ForumPersonalDetail> list = getSqlMapClientTemplate().queryForList("t_forum_personaldetail.selectByExample", example);
        return list;
    }

    public ForumPersonalDetail selectByPrimaryKey(Integer id) {
        ForumPersonalDetail _key = new ForumPersonalDetail();
        _key.setId(id);
        ForumPersonalDetail record = (ForumPersonalDetail) getSqlMapClientTemplate().queryForObject("t_forum_personaldetail.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(ForumPersonalDetail record, ForumPersonalDetailExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_forum_personaldetail.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(ForumPersonalDetail record, ForumPersonalDetailExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_forum_personaldetail.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(ForumPersonalDetail record) {
        int rows = getSqlMapClientTemplate().update("t_forum_personaldetail.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(ForumPersonalDetail record) {
        int rows = getSqlMapClientTemplate().update("t_forum_personaldetail.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends ForumPersonalDetailExample {
        private Object record;

        public UpdateByExampleParms(Object record, ForumPersonalDetailExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}