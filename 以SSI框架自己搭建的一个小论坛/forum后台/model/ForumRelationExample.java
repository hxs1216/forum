package com.nuchina.forum.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForumRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public ForumRelationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected ForumRelationExample(ForumRelationExample example) {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMyNickNameIsNull() {
            addCriterion("my_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andMyNickNameIsNotNull() {
            addCriterion("my_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andMyNickNameEqualTo(String value) {
            addCriterion("my_nick_name =", value, "myNickName");
            return (Criteria) this;
        }

        public Criteria andMyNickNameNotEqualTo(String value) {
            addCriterion("my_nick_name <>", value, "myNickName");
            return (Criteria) this;
        }

        public Criteria andMyNickNameGreaterThan(String value) {
            addCriterion("my_nick_name >", value, "myNickName");
            return (Criteria) this;
        }

        public Criteria andMyNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("my_nick_name >=", value, "myNickName");
            return (Criteria) this;
        }

        public Criteria andMyNickNameLessThan(String value) {
            addCriterion("my_nick_name <", value, "myNickName");
            return (Criteria) this;
        }

        public Criteria andMyNickNameLessThanOrEqualTo(String value) {
            addCriterion("my_nick_name <=", value, "myNickName");
            return (Criteria) this;
        }

        public Criteria andMyNickNameLike(String value) {
            addCriterion("my_nick_name like", value, "myNickName");
            return (Criteria) this;
        }

        public Criteria andMyNickNameNotLike(String value) {
            addCriterion("my_nick_name not like", value, "myNickName");
            return (Criteria) this;
        }

        public Criteria andMyNickNameIn(List<String> values) {
            addCriterion("my_nick_name in", values, "myNickName");
            return (Criteria) this;
        }

        public Criteria andMyNickNameNotIn(List<String> values) {
            addCriterion("my_nick_name not in", values, "myNickName");
            return (Criteria) this;
        }

        public Criteria andMyNickNameBetween(String value1, String value2) {
            addCriterion("my_nick_name between", value1, value2, "myNickName");
            return (Criteria) this;
        }

        public Criteria andMyNickNameNotBetween(String value1, String value2) {
            addCriterion("my_nick_name not between", value1, value2, "myNickName");
            return (Criteria) this;
        }

        public Criteria andHerNickNameIsNull() {
            addCriterion("her_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andHerNickNameIsNotNull() {
            addCriterion("her_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andHerNickNameEqualTo(String value) {
            addCriterion("her_nick_name =", value, "herNickName");
            return (Criteria) this;
        }

        public Criteria andHerNickNameNotEqualTo(String value) {
            addCriterion("her_nick_name <>", value, "herNickName");
            return (Criteria) this;
        }

        public Criteria andHerNickNameGreaterThan(String value) {
            addCriterion("her_nick_name >", value, "herNickName");
            return (Criteria) this;
        }

        public Criteria andHerNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("her_nick_name >=", value, "herNickName");
            return (Criteria) this;
        }

        public Criteria andHerNickNameLessThan(String value) {
            addCriterion("her_nick_name <", value, "herNickName");
            return (Criteria) this;
        }

        public Criteria andHerNickNameLessThanOrEqualTo(String value) {
            addCriterion("her_nick_name <=", value, "herNickName");
            return (Criteria) this;
        }

        public Criteria andHerNickNameLike(String value) {
            addCriterion("her_nick_name like", value, "herNickName");
            return (Criteria) this;
        }

        public Criteria andHerNickNameNotLike(String value) {
            addCriterion("her_nick_name not like", value, "herNickName");
            return (Criteria) this;
        }

        public Criteria andHerNickNameIn(List<String> values) {
            addCriterion("her_nick_name in", values, "herNickName");
            return (Criteria) this;
        }

        public Criteria andHerNickNameNotIn(List<String> values) {
            addCriterion("her_nick_name not in", values, "herNickName");
            return (Criteria) this;
        }

        public Criteria andHerNickNameBetween(String value1, String value2) {
            addCriterion("her_nick_name between", value1, value2, "herNickName");
            return (Criteria) this;
        }

        public Criteria andHerNickNameNotBetween(String value1, String value2) {
            addCriterion("her_nick_name not between", value1, value2, "herNickName");
            return (Criteria) this;
        }

        public Criteria andMyUserIdIsNull() {
            addCriterion("my_user_id is null");
            return (Criteria) this;
        }

        public Criteria andMyUserIdIsNotNull() {
            addCriterion("my_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andMyUserIdEqualTo(String value) {
            addCriterion("my_user_id =", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdNotEqualTo(String value) {
            addCriterion("my_user_id <>", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdGreaterThan(String value) {
            addCriterion("my_user_id >", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("my_user_id >=", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdLessThan(String value) {
            addCriterion("my_user_id <", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdLessThanOrEqualTo(String value) {
            addCriterion("my_user_id <=", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdLike(String value) {
            addCriterion("my_user_id like", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdNotLike(String value) {
            addCriterion("my_user_id not like", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdIn(List<String> values) {
            addCriterion("my_user_id in", values, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdNotIn(List<String> values) {
            addCriterion("my_user_id not in", values, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdBetween(String value1, String value2) {
            addCriterion("my_user_id between", value1, value2, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdNotBetween(String value1, String value2) {
            addCriterion("my_user_id not between", value1, value2, "myUserId");
            return (Criteria) this;
        }

        public Criteria andHerUserIdIsNull() {
            addCriterion("her_user_id is null");
            return (Criteria) this;
        }

        public Criteria andHerUserIdIsNotNull() {
            addCriterion("her_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andHerUserIdEqualTo(String value) {
            addCriterion("her_user_id =", value, "herUserId");
            return (Criteria) this;
        }

        public Criteria andHerUserIdNotEqualTo(String value) {
            addCriterion("her_user_id <>", value, "herUserId");
            return (Criteria) this;
        }

        public Criteria andHerUserIdGreaterThan(String value) {
            addCriterion("her_user_id >", value, "herUserId");
            return (Criteria) this;
        }

        public Criteria andHerUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("her_user_id >=", value, "herUserId");
            return (Criteria) this;
        }

        public Criteria andHerUserIdLessThan(String value) {
            addCriterion("her_user_id <", value, "herUserId");
            return (Criteria) this;
        }

        public Criteria andHerUserIdLessThanOrEqualTo(String value) {
            addCriterion("her_user_id <=", value, "herUserId");
            return (Criteria) this;
        }

        public Criteria andHerUserIdLike(String value) {
            addCriterion("her_user_id like", value, "herUserId");
            return (Criteria) this;
        }

        public Criteria andHerUserIdNotLike(String value) {
            addCriterion("her_user_id not like", value, "herUserId");
            return (Criteria) this;
        }

        public Criteria andHerUserIdIn(List<String> values) {
            addCriterion("her_user_id in", values, "herUserId");
            return (Criteria) this;
        }

        public Criteria andHerUserIdNotIn(List<String> values) {
            addCriterion("her_user_id not in", values, "herUserId");
            return (Criteria) this;
        }

        public Criteria andHerUserIdBetween(String value1, String value2) {
            addCriterion("her_user_id between", value1, value2, "herUserId");
            return (Criteria) this;
        }

        public Criteria andHerUserIdNotBetween(String value1, String value2) {
            addCriterion("her_user_id not between", value1, value2, "herUserId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPublishIdIsNull() {
            addCriterion("publish_id is null");
            return (Criteria) this;
        }

        public Criteria andPublishIdIsNotNull() {
            addCriterion("publish_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublishIdEqualTo(Integer value) {
            addCriterion("publish_id =", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotEqualTo(Integer value) {
            addCriterion("publish_id <>", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdGreaterThan(Integer value) {
            addCriterion("publish_id >", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("publish_id >=", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLessThan(Integer value) {
            addCriterion("publish_id <", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLessThanOrEqualTo(Integer value) {
            addCriterion("publish_id <=", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdIn(List<Integer> values) {
            addCriterion("publish_id in", values, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotIn(List<Integer> values) {
            addCriterion("publish_id not in", values, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdBetween(Integer value1, Integer value2) {
            addCriterion("publish_id between", value1, value2, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotBetween(Integer value1, Integer value2) {
            addCriterion("publish_id not between", value1, value2, "publishId");
            return (Criteria) this;
        }

        public Criteria andRelationTimeIsNull() {
            addCriterion("relation_time is null");
            return (Criteria) this;
        }

        public Criteria andRelationTimeIsNotNull() {
            addCriterion("relation_time is not null");
            return (Criteria) this;
        }

        public Criteria andRelationTimeEqualTo(Date value) {
            addCriterion("relation_time =", value, "relationTime");
            return (Criteria) this;
        }

        public Criteria andRelationTimeNotEqualTo(Date value) {
            addCriterion("relation_time <>", value, "relationTime");
            return (Criteria) this;
        }

        public Criteria andRelationTimeGreaterThan(Date value) {
            addCriterion("relation_time >", value, "relationTime");
            return (Criteria) this;
        }

        public Criteria andRelationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("relation_time >=", value, "relationTime");
            return (Criteria) this;
        }

        public Criteria andRelationTimeLessThan(Date value) {
            addCriterion("relation_time <", value, "relationTime");
            return (Criteria) this;
        }

        public Criteria andRelationTimeLessThanOrEqualTo(Date value) {
            addCriterion("relation_time <=", value, "relationTime");
            return (Criteria) this;
        }

        public Criteria andRelationTimeIn(List<Date> values) {
            addCriterion("relation_time in", values, "relationTime");
            return (Criteria) this;
        }

        public Criteria andRelationTimeNotIn(List<Date> values) {
            addCriterion("relation_time not in", values, "relationTime");
            return (Criteria) this;
        }

        public Criteria andRelationTimeBetween(Date value1, Date value2) {
            addCriterion("relation_time between", value1, value2, "relationTime");
            return (Criteria) this;
        }

        public Criteria andRelationTimeNotBetween(Date value1, Date value2) {
            addCriterion("relation_time not between", value1, value2, "relationTime");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeIsNull() {
            addCriterion("alrealySee is null");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeIsNotNull() {
            addCriterion("alrealySee is not null");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeEqualTo(String value) {
            addCriterion("alrealySee =", value, "alrealysee");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeNotEqualTo(String value) {
            addCriterion("alrealySee <>", value, "alrealysee");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeGreaterThan(String value) {
            addCriterion("alrealySee >", value, "alrealysee");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeGreaterThanOrEqualTo(String value) {
            addCriterion("alrealySee >=", value, "alrealysee");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeLessThan(String value) {
            addCriterion("alrealySee <", value, "alrealysee");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeLessThanOrEqualTo(String value) {
            addCriterion("alrealySee <=", value, "alrealysee");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeLike(String value) {
            addCriterion("alrealySee like", value, "alrealysee");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeNotLike(String value) {
            addCriterion("alrealySee not like", value, "alrealysee");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeIn(List<String> values) {
            addCriterion("alrealySee in", values, "alrealysee");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeNotIn(List<String> values) {
            addCriterion("alrealySee not in", values, "alrealysee");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeBetween(String value1, String value2) {
            addCriterion("alrealySee between", value1, value2, "alrealysee");
            return (Criteria) this;
        }

        public Criteria andAlrealyseeNotBetween(String value1, String value2) {
            addCriterion("alrealySee not between", value1, value2, "alrealysee");
            return (Criteria) this;
        }

        public Criteria andExtendIsNull() {
            addCriterion("extend is null");
            return (Criteria) this;
        }

        public Criteria andExtendIsNotNull() {
            addCriterion("extend is not null");
            return (Criteria) this;
        }

        public Criteria andExtendEqualTo(String value) {
            addCriterion("extend =", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotEqualTo(String value) {
            addCriterion("extend <>", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThan(String value) {
            addCriterion("extend >", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThanOrEqualTo(String value) {
            addCriterion("extend >=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThan(String value) {
            addCriterion("extend <", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThanOrEqualTo(String value) {
            addCriterion("extend <=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLike(String value) {
            addCriterion("extend like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotLike(String value) {
            addCriterion("extend not like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendIn(List<String> values) {
            addCriterion("extend in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotIn(List<String> values) {
            addCriterion("extend not in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendBetween(String value1, String value2) {
            addCriterion("extend between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotBetween(String value1, String value2) {
            addCriterion("extend not between", value1, value2, "extend");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andMyNickNameLikeInsensitive(String value) {
            addCriterion("upper(my_nick_name) like", value.toUpperCase(), "myNickName");
            return this;
        }

        public Criteria andHerNickNameLikeInsensitive(String value) {
            addCriterion("upper(her_nick_name) like", value.toUpperCase(), "herNickName");
            return this;
        }

        public Criteria andMyUserIdLikeInsensitive(String value) {
            addCriterion("upper(my_user_id) like", value.toUpperCase(), "myUserId");
            return this;
        }

        public Criteria andHerUserIdLikeInsensitive(String value) {
            addCriterion("upper(her_user_id) like", value.toUpperCase(), "herUserId");
            return this;
        }

        public Criteria andTitleLikeInsensitive(String value) {
            addCriterion("upper(title) like", value.toUpperCase(), "title");
            return this;
        }

        public Criteria andAlrealyseeLikeInsensitive(String value) {
            addCriterion("upper(alrealySee) like", value.toUpperCase(), "alrealysee");
            return this;
        }

        public Criteria andExtendLikeInsensitive(String value) {
            addCriterion("upper(extend) like", value.toUpperCase(), "extend");
            return this;
        }
    }
}