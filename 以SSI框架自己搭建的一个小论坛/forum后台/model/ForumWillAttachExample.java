package com.nuchina.forum.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForumWillAttachExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public ForumWillAttachExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected ForumWillAttachExample(ForumWillAttachExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setMysqlOffset(Integer mysqlOffset) {
        this.mysqlOffset = mysqlOffset;
    }

    public Integer getMysqlOffset() {
        return mysqlOffset;
    }

    public void setMysqlLength(Integer mysqlLength) {
        this.mysqlLength = mysqlLength;
    }

    public Integer getMysqlLength() {
        return mysqlLength;
    }

    protected abstract static class GeneratedCriteria {
        protected List<String> criteriaWithoutValue;

        protected List<Map<String, Object>> criteriaWithSingleValue;

        protected List<Map<String, Object>> criteriaWithListValue;

        protected List<Map<String, Object>> criteriaWithBetweenValue;

        protected GeneratedCriteria() {
            super();
            criteriaWithoutValue = new ArrayList<String>();
            criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
            criteriaWithListValue = new ArrayList<Map<String, Object>>();
            criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List<String> getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public void setCriteriaWithoutValue(List<String> criteriaWithoutValue) {
            this.criteriaWithoutValue = criteriaWithoutValue;
        }

        public List<Map<String, Object>> getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public void setCriteriaWithSingleValue(List<Map<String, Object>> criteriaWithSingleValue) {
            this.criteriaWithSingleValue = criteriaWithSingleValue;
        }

        public List<Map<String, Object>> getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public void setCriteriaWithListValue(List<Map<String, Object>> criteriaWithListValue) {
            this.criteriaWithListValue = criteriaWithListValue;
        }

        public List<Map<String, Object>> getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        public void setCriteriaWithBetweenValue(List<Map<String, Object>> criteriaWithBetweenValue) {
            this.criteriaWithBetweenValue = criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List<Object> list = new ArrayList<Object>();
            list.add(value1);
            list.add(value2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andAttachidIsNull() {
            addCriterion("ATTACHID is null");
            return (Criteria) this;
        }

        public Criteria andAttachidIsNotNull() {
            addCriterion("ATTACHID is not null");
            return (Criteria) this;
        }

        public Criteria andAttachidEqualTo(Integer value) {
            addCriterion("ATTACHID =", value, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidNotEqualTo(Integer value) {
            addCriterion("ATTACHID <>", value, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidGreaterThan(Integer value) {
            addCriterion("ATTACHID >", value, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ATTACHID >=", value, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidLessThan(Integer value) {
            addCriterion("ATTACHID <", value, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidLessThanOrEqualTo(Integer value) {
            addCriterion("ATTACHID <=", value, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidIn(List<Integer> values) {
            addCriterion("ATTACHID in", values, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidNotIn(List<Integer> values) {
            addCriterion("ATTACHID not in", values, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidBetween(Integer value1, Integer value2) {
            addCriterion("ATTACHID between", value1, value2, "attachid");
            return (Criteria) this;
        }

        public Criteria andAttachidNotBetween(Integer value1, Integer value2) {
            addCriterion("ATTACHID not between", value1, value2, "attachid");
            return (Criteria) this;
        }

        public Criteria andApplyidIsNull() {
            addCriterion("APPLYID is null");
            return (Criteria) this;
        }

        public Criteria andApplyidIsNotNull() {
            addCriterion("APPLYID is not null");
            return (Criteria) this;
        }

        public Criteria andApplyidEqualTo(Long value) {
            addCriterion("APPLYID =", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotEqualTo(Long value) {
            addCriterion("APPLYID <>", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidGreaterThan(Long value) {
            addCriterion("APPLYID >", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidGreaterThanOrEqualTo(Long value) {
            addCriterion("APPLYID >=", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLessThan(Long value) {
            addCriterion("APPLYID <", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLessThanOrEqualTo(Long value) {
            addCriterion("APPLYID <=", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidIn(List<Long> values) {
            addCriterion("APPLYID in", values, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotIn(List<Long> values) {
            addCriterion("APPLYID not in", values, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidBetween(Long value1, Long value2) {
            addCriterion("APPLYID between", value1, value2, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotBetween(Long value1, Long value2) {
            addCriterion("APPLYID not between", value1, value2, "applyid");
            return (Criteria) this;
        }

        public Criteria andAttachpathIsNull() {
            addCriterion("ATTACHPATH is null");
            return (Criteria) this;
        }

        public Criteria andAttachpathIsNotNull() {
            addCriterion("ATTACHPATH is not null");
            return (Criteria) this;
        }

        public Criteria andAttachpathEqualTo(String value) {
            addCriterion("ATTACHPATH =", value, "attachpath");
            return (Criteria) this;
        }

        public Criteria andAttachpathNotEqualTo(String value) {
            addCriterion("ATTACHPATH <>", value, "attachpath");
            return (Criteria) this;
        }

        public Criteria andAttachpathGreaterThan(String value) {
            addCriterion("ATTACHPATH >", value, "attachpath");
            return (Criteria) this;
        }

        public Criteria andAttachpathGreaterThanOrEqualTo(String value) {
            addCriterion("ATTACHPATH >=", value, "attachpath");
            return (Criteria) this;
        }

        public Criteria andAttachpathLessThan(String value) {
            addCriterion("ATTACHPATH <", value, "attachpath");
            return (Criteria) this;
        }

        public Criteria andAttachpathLessThanOrEqualTo(String value) {
            addCriterion("ATTACHPATH <=", value, "attachpath");
            return (Criteria) this;
        }

        public Criteria andAttachpathLike(String value) {
            addCriterion("ATTACHPATH like", value, "attachpath");
            return (Criteria) this;
        }

        public Criteria andAttachpathNotLike(String value) {
            addCriterion("ATTACHPATH not like", value, "attachpath");
            return (Criteria) this;
        }

        public Criteria andAttachpathIn(List<String> values) {
            addCriterion("ATTACHPATH in", values, "attachpath");
            return (Criteria) this;
        }

        public Criteria andAttachpathNotIn(List<String> values) {
            addCriterion("ATTACHPATH not in", values, "attachpath");
            return (Criteria) this;
        }

        public Criteria andAttachpathBetween(String value1, String value2) {
            addCriterion("ATTACHPATH between", value1, value2, "attachpath");
            return (Criteria) this;
        }

        public Criteria andAttachpathNotBetween(String value1, String value2) {
            addCriterion("ATTACHPATH not between", value1, value2, "attachpath");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNull() {
            addCriterion("UPTIME is null");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNotNull() {
            addCriterion("UPTIME is not null");
            return (Criteria) this;
        }

        public Criteria andUptimeEqualTo(Date value) {
            addCriterion("UPTIME =", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotEqualTo(Date value) {
            addCriterion("UPTIME <>", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThan(Date value) {
            addCriterion("UPTIME >", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPTIME >=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThan(Date value) {
            addCriterion("UPTIME <", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThanOrEqualTo(Date value) {
            addCriterion("UPTIME <=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeIn(List<Date> values) {
            addCriterion("UPTIME in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotIn(List<Date> values) {
            addCriterion("UPTIME not in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeBetween(Date value1, Date value2) {
            addCriterion("UPTIME between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotBetween(Date value1, Date value2) {
            addCriterion("UPTIME not between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andUpusernameIsNull() {
            addCriterion("UPUSERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUpusernameIsNotNull() {
            addCriterion("UPUSERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUpusernameEqualTo(String value) {
            addCriterion("UPUSERNAME =", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameNotEqualTo(String value) {
            addCriterion("UPUSERNAME <>", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameGreaterThan(String value) {
            addCriterion("UPUSERNAME >", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameGreaterThanOrEqualTo(String value) {
            addCriterion("UPUSERNAME >=", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameLessThan(String value) {
            addCriterion("UPUSERNAME <", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameLessThanOrEqualTo(String value) {
            addCriterion("UPUSERNAME <=", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameLike(String value) {
            addCriterion("UPUSERNAME like", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameNotLike(String value) {
            addCriterion("UPUSERNAME not like", value, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameIn(List<String> values) {
            addCriterion("UPUSERNAME in", values, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameNotIn(List<String> values) {
            addCriterion("UPUSERNAME not in", values, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameBetween(String value1, String value2) {
            addCriterion("UPUSERNAME between", value1, value2, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpusernameNotBetween(String value1, String value2) {
            addCriterion("UPUSERNAME not between", value1, value2, "upusername");
            return (Criteria) this;
        }

        public Criteria andUpuseridIsNull() {
            addCriterion("UPUSERID is null");
            return (Criteria) this;
        }

        public Criteria andUpuseridIsNotNull() {
            addCriterion("UPUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andUpuseridEqualTo(String value) {
            addCriterion("UPUSERID =", value, "upuserid");
            return (Criteria) this;
        }

        public Criteria andUpuseridNotEqualTo(String value) {
            addCriterion("UPUSERID <>", value, "upuserid");
            return (Criteria) this;
        }

        public Criteria andUpuseridGreaterThan(String value) {
            addCriterion("UPUSERID >", value, "upuserid");
            return (Criteria) this;
        }

        public Criteria andUpuseridGreaterThanOrEqualTo(String value) {
            addCriterion("UPUSERID >=", value, "upuserid");
            return (Criteria) this;
        }

        public Criteria andUpuseridLessThan(String value) {
            addCriterion("UPUSERID <", value, "upuserid");
            return (Criteria) this;
        }

        public Criteria andUpuseridLessThanOrEqualTo(String value) {
            addCriterion("UPUSERID <=", value, "upuserid");
            return (Criteria) this;
        }

        public Criteria andUpuseridLike(String value) {
            addCriterion("UPUSERID like", value, "upuserid");
            return (Criteria) this;
        }

        public Criteria andUpuseridNotLike(String value) {
            addCriterion("UPUSERID not like", value, "upuserid");
            return (Criteria) this;
        }

        public Criteria andUpuseridIn(List<String> values) {
            addCriterion("UPUSERID in", values, "upuserid");
            return (Criteria) this;
        }

        public Criteria andUpuseridNotIn(List<String> values) {
            addCriterion("UPUSERID not in", values, "upuserid");
            return (Criteria) this;
        }

        public Criteria andUpuseridBetween(String value1, String value2) {
            addCriterion("UPUSERID between", value1, value2, "upuserid");
            return (Criteria) this;
        }

        public Criteria andUpuseridNotBetween(String value1, String value2) {
            addCriterion("UPUSERID not between", value1, value2, "upuserid");
            return (Criteria) this;
        }

        public Criteria andAttachnameIsNull() {
            addCriterion("ATTACHNAME is null");
            return (Criteria) this;
        }

        public Criteria andAttachnameIsNotNull() {
            addCriterion("ATTACHNAME is not null");
            return (Criteria) this;
        }

        public Criteria andAttachnameEqualTo(String value) {
            addCriterion("ATTACHNAME =", value, "attachname");
            return (Criteria) this;
        }

        public Criteria andAttachnameNotEqualTo(String value) {
            addCriterion("ATTACHNAME <>", value, "attachname");
            return (Criteria) this;
        }

        public Criteria andAttachnameGreaterThan(String value) {
            addCriterion("ATTACHNAME >", value, "attachname");
            return (Criteria) this;
        }

        public Criteria andAttachnameGreaterThanOrEqualTo(String value) {
            addCriterion("ATTACHNAME >=", value, "attachname");
            return (Criteria) this;
        }

        public Criteria andAttachnameLessThan(String value) {
            addCriterion("ATTACHNAME <", value, "attachname");
            return (Criteria) this;
        }

        public Criteria andAttachnameLessThanOrEqualTo(String value) {
            addCriterion("ATTACHNAME <=", value, "attachname");
            return (Criteria) this;
        }

        public Criteria andAttachnameLike(String value) {
            addCriterion("ATTACHNAME like", value, "attachname");
            return (Criteria) this;
        }

        public Criteria andAttachnameNotLike(String value) {
            addCriterion("ATTACHNAME not like", value, "attachname");
            return (Criteria) this;
        }

        public Criteria andAttachnameIn(List<String> values) {
            addCriterion("ATTACHNAME in", values, "attachname");
            return (Criteria) this;
        }

        public Criteria andAttachnameNotIn(List<String> values) {
            addCriterion("ATTACHNAME not in", values, "attachname");
            return (Criteria) this;
        }

        public Criteria andAttachnameBetween(String value1, String value2) {
            addCriterion("ATTACHNAME between", value1, value2, "attachname");
            return (Criteria) this;
        }

        public Criteria andAttachnameNotBetween(String value1, String value2) {
            addCriterion("ATTACHNAME not between", value1, value2, "attachname");
            return (Criteria) this;
        }

        public Criteria andAttsizeIsNull() {
            addCriterion("ATTSIZE is null");
            return (Criteria) this;
        }

        public Criteria andAttsizeIsNotNull() {
            addCriterion("ATTSIZE is not null");
            return (Criteria) this;
        }

        public Criteria andAttsizeEqualTo(String value) {
            addCriterion("ATTSIZE =", value, "attsize");
            return (Criteria) this;
        }

        public Criteria andAttsizeNotEqualTo(String value) {
            addCriterion("ATTSIZE <>", value, "attsize");
            return (Criteria) this;
        }

        public Criteria andAttsizeGreaterThan(String value) {
            addCriterion("ATTSIZE >", value, "attsize");
            return (Criteria) this;
        }

        public Criteria andAttsizeGreaterThanOrEqualTo(String value) {
            addCriterion("ATTSIZE >=", value, "attsize");
            return (Criteria) this;
        }

        public Criteria andAttsizeLessThan(String value) {
            addCriterion("ATTSIZE <", value, "attsize");
            return (Criteria) this;
        }

        public Criteria andAttsizeLessThanOrEqualTo(String value) {
            addCriterion("ATTSIZE <=", value, "attsize");
            return (Criteria) this;
        }

        public Criteria andAttsizeLike(String value) {
            addCriterion("ATTSIZE like", value, "attsize");
            return (Criteria) this;
        }

        public Criteria andAttsizeNotLike(String value) {
            addCriterion("ATTSIZE not like", value, "attsize");
            return (Criteria) this;
        }

        public Criteria andAttsizeIn(List<String> values) {
            addCriterion("ATTSIZE in", values, "attsize");
            return (Criteria) this;
        }

        public Criteria andAttsizeNotIn(List<String> values) {
            addCriterion("ATTSIZE not in", values, "attsize");
            return (Criteria) this;
        }

        public Criteria andAttsizeBetween(String value1, String value2) {
            addCriterion("ATTSIZE between", value1, value2, "attsize");
            return (Criteria) this;
        }

        public Criteria andAttsizeNotBetween(String value1, String value2) {
            addCriterion("ATTSIZE not between", value1, value2, "attsize");
            return (Criteria) this;
        }

        public Criteria andAttstateIsNull() {
            addCriterion("ATTSTATE is null");
            return (Criteria) this;
        }

        public Criteria andAttstateIsNotNull() {
            addCriterion("ATTSTATE is not null");
            return (Criteria) this;
        }

        public Criteria andAttstateEqualTo(String value) {
            addCriterion("ATTSTATE =", value, "attstate");
            return (Criteria) this;
        }

        public Criteria andAttstateNotEqualTo(String value) {
            addCriterion("ATTSTATE <>", value, "attstate");
            return (Criteria) this;
        }

        public Criteria andAttstateGreaterThan(String value) {
            addCriterion("ATTSTATE >", value, "attstate");
            return (Criteria) this;
        }

        public Criteria andAttstateGreaterThanOrEqualTo(String value) {
            addCriterion("ATTSTATE >=", value, "attstate");
            return (Criteria) this;
        }

        public Criteria andAttstateLessThan(String value) {
            addCriterion("ATTSTATE <", value, "attstate");
            return (Criteria) this;
        }

        public Criteria andAttstateLessThanOrEqualTo(String value) {
            addCriterion("ATTSTATE <=", value, "attstate");
            return (Criteria) this;
        }

        public Criteria andAttstateLike(String value) {
            addCriterion("ATTSTATE like", value, "attstate");
            return (Criteria) this;
        }

        public Criteria andAttstateNotLike(String value) {
            addCriterion("ATTSTATE not like", value, "attstate");
            return (Criteria) this;
        }

        public Criteria andAttstateIn(List<String> values) {
            addCriterion("ATTSTATE in", values, "attstate");
            return (Criteria) this;
        }

        public Criteria andAttstateNotIn(List<String> values) {
            addCriterion("ATTSTATE not in", values, "attstate");
            return (Criteria) this;
        }

        public Criteria andAttstateBetween(String value1, String value2) {
            addCriterion("ATTSTATE between", value1, value2, "attstate");
            return (Criteria) this;
        }

        public Criteria andAttstateNotBetween(String value1, String value2) {
            addCriterion("ATTSTATE not between", value1, value2, "attstate");
            return (Criteria) this;
        }

        public Criteria andSeeidsIsNull() {
            addCriterion("SEEIDS is null");
            return (Criteria) this;
        }

        public Criteria andSeeidsIsNotNull() {
            addCriterion("SEEIDS is not null");
            return (Criteria) this;
        }

        public Criteria andSeeidsEqualTo(String value) {
            addCriterion("SEEIDS =", value, "seeids");
            return (Criteria) this;
        }

        public Criteria andSeeidsNotEqualTo(String value) {
            addCriterion("SEEIDS <>", value, "seeids");
            return (Criteria) this;
        }

        public Criteria andSeeidsGreaterThan(String value) {
            addCriterion("SEEIDS >", value, "seeids");
            return (Criteria) this;
        }

        public Criteria andSeeidsGreaterThanOrEqualTo(String value) {
            addCriterion("SEEIDS >=", value, "seeids");
            return (Criteria) this;
        }

        public Criteria andSeeidsLessThan(String value) {
            addCriterion("SEEIDS <", value, "seeids");
            return (Criteria) this;
        }

        public Criteria andSeeidsLessThanOrEqualTo(String value) {
            addCriterion("SEEIDS <=", value, "seeids");
            return (Criteria) this;
        }

        public Criteria andSeeidsLike(String value) {
            addCriterion("SEEIDS like", value, "seeids");
            return (Criteria) this;
        }

        public Criteria andSeeidsNotLike(String value) {
            addCriterion("SEEIDS not like", value, "seeids");
            return (Criteria) this;
        }

        public Criteria andSeeidsIn(List<String> values) {
            addCriterion("SEEIDS in", values, "seeids");
            return (Criteria) this;
        }

        public Criteria andSeeidsNotIn(List<String> values) {
            addCriterion("SEEIDS not in", values, "seeids");
            return (Criteria) this;
        }

        public Criteria andSeeidsBetween(String value1, String value2) {
            addCriterion("SEEIDS between", value1, value2, "seeids");
            return (Criteria) this;
        }

        public Criteria andSeeidsNotBetween(String value1, String value2) {
            addCriterion("SEEIDS not between", value1, value2, "seeids");
            return (Criteria) this;
        }

        public Criteria andSeenamesIsNull() {
            addCriterion("SEENAMES is null");
            return (Criteria) this;
        }

        public Criteria andSeenamesIsNotNull() {
            addCriterion("SEENAMES is not null");
            return (Criteria) this;
        }

        public Criteria andSeenamesEqualTo(String value) {
            addCriterion("SEENAMES =", value, "seenames");
            return (Criteria) this;
        }

        public Criteria andSeenamesNotEqualTo(String value) {
            addCriterion("SEENAMES <>", value, "seenames");
            return (Criteria) this;
        }

        public Criteria andSeenamesGreaterThan(String value) {
            addCriterion("SEENAMES >", value, "seenames");
            return (Criteria) this;
        }

        public Criteria andSeenamesGreaterThanOrEqualTo(String value) {
            addCriterion("SEENAMES >=", value, "seenames");
            return (Criteria) this;
        }

        public Criteria andSeenamesLessThan(String value) {
            addCriterion("SEENAMES <", value, "seenames");
            return (Criteria) this;
        }

        public Criteria andSeenamesLessThanOrEqualTo(String value) {
            addCriterion("SEENAMES <=", value, "seenames");
            return (Criteria) this;
        }

        public Criteria andSeenamesLike(String value) {
            addCriterion("SEENAMES like", value, "seenames");
            return (Criteria) this;
        }

        public Criteria andSeenamesNotLike(String value) {
            addCriterion("SEENAMES not like", value, "seenames");
            return (Criteria) this;
        }

        public Criteria andSeenamesIn(List<String> values) {
            addCriterion("SEENAMES in", values, "seenames");
            return (Criteria) this;
        }

        public Criteria andSeenamesNotIn(List<String> values) {
            addCriterion("SEENAMES not in", values, "seenames");
            return (Criteria) this;
        }

        public Criteria andSeenamesBetween(String value1, String value2) {
            addCriterion("SEENAMES between", value1, value2, "seenames");
            return (Criteria) this;
        }

        public Criteria andSeenamesNotBetween(String value1, String value2) {
            addCriterion("SEENAMES not between", value1, value2, "seenames");
            return (Criteria) this;
        }

        public Criteria andAttachtypeIsNull() {
            addCriterion("ATTACHTYPE is null");
            return (Criteria) this;
        }

        public Criteria andAttachtypeIsNotNull() {
            addCriterion("ATTACHTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAttachtypeEqualTo(String value) {
            addCriterion("ATTACHTYPE =", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeNotEqualTo(String value) {
            addCriterion("ATTACHTYPE <>", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeGreaterThan(String value) {
            addCriterion("ATTACHTYPE >", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeGreaterThanOrEqualTo(String value) {
            addCriterion("ATTACHTYPE >=", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeLessThan(String value) {
            addCriterion("ATTACHTYPE <", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeLessThanOrEqualTo(String value) {
            addCriterion("ATTACHTYPE <=", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeLike(String value) {
            addCriterion("ATTACHTYPE like", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeNotLike(String value) {
            addCriterion("ATTACHTYPE not like", value, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeIn(List<String> values) {
            addCriterion("ATTACHTYPE in", values, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeNotIn(List<String> values) {
            addCriterion("ATTACHTYPE not in", values, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeBetween(String value1, String value2) {
            addCriterion("ATTACHTYPE between", value1, value2, "attachtype");
            return (Criteria) this;
        }

        public Criteria andAttachtypeNotBetween(String value1, String value2) {
            addCriterion("ATTACHTYPE not between", value1, value2, "attachtype");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andAttachpathLikeInsensitive(String value) {
            addCriterion("upper(ATTACHPATH) like", value.toUpperCase(), "attachpath");
            return this;
        }

        public Criteria andUpusernameLikeInsensitive(String value) {
            addCriterion("upper(UPUSERNAME) like", value.toUpperCase(), "upusername");
            return this;
        }

        public Criteria andUpuseridLikeInsensitive(String value) {
            addCriterion("upper(UPUSERID) like", value.toUpperCase(), "upuserid");
            return this;
        }

        public Criteria andAttachnameLikeInsensitive(String value) {
            addCriterion("upper(ATTACHNAME) like", value.toUpperCase(), "attachname");
            return this;
        }

        public Criteria andAttsizeLikeInsensitive(String value) {
            addCriterion("upper(ATTSIZE) like", value.toUpperCase(), "attsize");
            return this;
        }

        public Criteria andAttstateLikeInsensitive(String value) {
            addCriterion("upper(ATTSTATE) like", value.toUpperCase(), "attstate");
            return this;
        }

        public Criteria andSeeidsLikeInsensitive(String value) {
            addCriterion("upper(SEEIDS) like", value.toUpperCase(), "seeids");
            return this;
        }

        public Criteria andSeenamesLikeInsensitive(String value) {
            addCriterion("upper(SEENAMES) like", value.toUpperCase(), "seenames");
            return this;
        }

        public Criteria andAttachtypeLikeInsensitive(String value) {
            addCriterion("upper(ATTACHTYPE) like", value.toUpperCase(), "attachtype");
            return this;
        }
    }
}