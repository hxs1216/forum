package com.nuchina.forum.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForumPersonalDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public ForumPersonalDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected ForumPersonalDetailExample(ForumPersonalDetailExample example) {
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

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andMyPostIsNull() {
            addCriterion("my_post is null");
            return (Criteria) this;
        }

        public Criteria andMyPostIsNotNull() {
            addCriterion("my_post is not null");
            return (Criteria) this;
        }

        public Criteria andMyPostEqualTo(Integer value) {
            addCriterion("my_post =", value, "myPost");
            return (Criteria) this;
        }

        public Criteria andMyPostNotEqualTo(Integer value) {
            addCriterion("my_post <>", value, "myPost");
            return (Criteria) this;
        }

        public Criteria andMyPostGreaterThan(Integer value) {
            addCriterion("my_post >", value, "myPost");
            return (Criteria) this;
        }

        public Criteria andMyPostGreaterThanOrEqualTo(Integer value) {
            addCriterion("my_post >=", value, "myPost");
            return (Criteria) this;
        }

        public Criteria andMyPostLessThan(Integer value) {
            addCriterion("my_post <", value, "myPost");
            return (Criteria) this;
        }

        public Criteria andMyPostLessThanOrEqualTo(Integer value) {
            addCriterion("my_post <=", value, "myPost");
            return (Criteria) this;
        }

        public Criteria andMyPostIn(List<Integer> values) {
            addCriterion("my_post in", values, "myPost");
            return (Criteria) this;
        }

        public Criteria andMyPostNotIn(List<Integer> values) {
            addCriterion("my_post not in", values, "myPost");
            return (Criteria) this;
        }

        public Criteria andMyPostBetween(Integer value1, Integer value2) {
            addCriterion("my_post between", value1, value2, "myPost");
            return (Criteria) this;
        }

        public Criteria andMyPostNotBetween(Integer value1, Integer value2) {
            addCriterion("my_post not between", value1, value2, "myPost");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andMyCommentIsNull() {
            addCriterion("my_comment is null");
            return (Criteria) this;
        }

        public Criteria andMyCommentIsNotNull() {
            addCriterion("my_comment is not null");
            return (Criteria) this;
        }

        public Criteria andMyCommentEqualTo(Integer value) {
            addCriterion("my_comment =", value, "myComment");
            return (Criteria) this;
        }

        public Criteria andMyCommentNotEqualTo(Integer value) {
            addCriterion("my_comment <>", value, "myComment");
            return (Criteria) this;
        }

        public Criteria andMyCommentGreaterThan(Integer value) {
            addCriterion("my_comment >", value, "myComment");
            return (Criteria) this;
        }

        public Criteria andMyCommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("my_comment >=", value, "myComment");
            return (Criteria) this;
        }

        public Criteria andMyCommentLessThan(Integer value) {
            addCriterion("my_comment <", value, "myComment");
            return (Criteria) this;
        }

        public Criteria andMyCommentLessThanOrEqualTo(Integer value) {
            addCriterion("my_comment <=", value, "myComment");
            return (Criteria) this;
        }

        public Criteria andMyCommentIn(List<Integer> values) {
            addCriterion("my_comment in", values, "myComment");
            return (Criteria) this;
        }

        public Criteria andMyCommentNotIn(List<Integer> values) {
            addCriterion("my_comment not in", values, "myComment");
            return (Criteria) this;
        }

        public Criteria andMyCommentBetween(Integer value1, Integer value2) {
            addCriterion("my_comment between", value1, value2, "myComment");
            return (Criteria) this;
        }

        public Criteria andMyCommentNotBetween(Integer value1, Integer value2) {
            addCriterion("my_comment not between", value1, value2, "myComment");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPartIdIsNull() {
            addCriterion("user_part_id is null");
            return (Criteria) this;
        }

        public Criteria andUserPartIdIsNotNull() {
            addCriterion("user_part_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserPartIdEqualTo(String value) {
            addCriterion("user_part_id =", value, "userPartId");
            return (Criteria) this;
        }

        public Criteria andUserPartIdNotEqualTo(String value) {
            addCriterion("user_part_id <>", value, "userPartId");
            return (Criteria) this;
        }

        public Criteria andUserPartIdGreaterThan(String value) {
            addCriterion("user_part_id >", value, "userPartId");
            return (Criteria) this;
        }

        public Criteria andUserPartIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_part_id >=", value, "userPartId");
            return (Criteria) this;
        }

        public Criteria andUserPartIdLessThan(String value) {
            addCriterion("user_part_id <", value, "userPartId");
            return (Criteria) this;
        }

        public Criteria andUserPartIdLessThanOrEqualTo(String value) {
            addCriterion("user_part_id <=", value, "userPartId");
            return (Criteria) this;
        }

        public Criteria andUserPartIdLike(String value) {
            addCriterion("user_part_id like", value, "userPartId");
            return (Criteria) this;
        }

        public Criteria andUserPartIdNotLike(String value) {
            addCriterion("user_part_id not like", value, "userPartId");
            return (Criteria) this;
        }

        public Criteria andUserPartIdIn(List<String> values) {
            addCriterion("user_part_id in", values, "userPartId");
            return (Criteria) this;
        }

        public Criteria andUserPartIdNotIn(List<String> values) {
            addCriterion("user_part_id not in", values, "userPartId");
            return (Criteria) this;
        }

        public Criteria andUserPartIdBetween(String value1, String value2) {
            addCriterion("user_part_id between", value1, value2, "userPartId");
            return (Criteria) this;
        }

        public Criteria andUserPartIdNotBetween(String value1, String value2) {
            addCriterion("user_part_id not between", value1, value2, "userPartId");
            return (Criteria) this;
        }

        public Criteria andUserPartNameIsNull() {
            addCriterion("user_part_name is null");
            return (Criteria) this;
        }

        public Criteria andUserPartNameIsNotNull() {
            addCriterion("user_part_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserPartNameEqualTo(String value) {
            addCriterion("user_part_name =", value, "userPartName");
            return (Criteria) this;
        }

        public Criteria andUserPartNameNotEqualTo(String value) {
            addCriterion("user_part_name <>", value, "userPartName");
            return (Criteria) this;
        }

        public Criteria andUserPartNameGreaterThan(String value) {
            addCriterion("user_part_name >", value, "userPartName");
            return (Criteria) this;
        }

        public Criteria andUserPartNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_part_name >=", value, "userPartName");
            return (Criteria) this;
        }

        public Criteria andUserPartNameLessThan(String value) {
            addCriterion("user_part_name <", value, "userPartName");
            return (Criteria) this;
        }

        public Criteria andUserPartNameLessThanOrEqualTo(String value) {
            addCriterion("user_part_name <=", value, "userPartName");
            return (Criteria) this;
        }

        public Criteria andUserPartNameLike(String value) {
            addCriterion("user_part_name like", value, "userPartName");
            return (Criteria) this;
        }

        public Criteria andUserPartNameNotLike(String value) {
            addCriterion("user_part_name not like", value, "userPartName");
            return (Criteria) this;
        }

        public Criteria andUserPartNameIn(List<String> values) {
            addCriterion("user_part_name in", values, "userPartName");
            return (Criteria) this;
        }

        public Criteria andUserPartNameNotIn(List<String> values) {
            addCriterion("user_part_name not in", values, "userPartName");
            return (Criteria) this;
        }

        public Criteria andUserPartNameBetween(String value1, String value2) {
            addCriterion("user_part_name between", value1, value2, "userPartName");
            return (Criteria) this;
        }

        public Criteria andUserPartNameNotBetween(String value1, String value2) {
            addCriterion("user_part_name not between", value1, value2, "userPartName");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdIsNull() {
            addCriterion("user_cmp_id is null");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdIsNotNull() {
            addCriterion("user_cmp_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdEqualTo(String value) {
            addCriterion("user_cmp_id =", value, "userCmpId");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdNotEqualTo(String value) {
            addCriterion("user_cmp_id <>", value, "userCmpId");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdGreaterThan(String value) {
            addCriterion("user_cmp_id >", value, "userCmpId");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_cmp_id >=", value, "userCmpId");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdLessThan(String value) {
            addCriterion("user_cmp_id <", value, "userCmpId");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdLessThanOrEqualTo(String value) {
            addCriterion("user_cmp_id <=", value, "userCmpId");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdLike(String value) {
            addCriterion("user_cmp_id like", value, "userCmpId");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdNotLike(String value) {
            addCriterion("user_cmp_id not like", value, "userCmpId");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdIn(List<String> values) {
            addCriterion("user_cmp_id in", values, "userCmpId");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdNotIn(List<String> values) {
            addCriterion("user_cmp_id not in", values, "userCmpId");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdBetween(String value1, String value2) {
            addCriterion("user_cmp_id between", value1, value2, "userCmpId");
            return (Criteria) this;
        }

        public Criteria andUserCmpIdNotBetween(String value1, String value2) {
            addCriterion("user_cmp_id not between", value1, value2, "userCmpId");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameIsNull() {
            addCriterion("user_cmp_name is null");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameIsNotNull() {
            addCriterion("user_cmp_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameEqualTo(String value) {
            addCriterion("user_cmp_name =", value, "userCmpName");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameNotEqualTo(String value) {
            addCriterion("user_cmp_name <>", value, "userCmpName");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameGreaterThan(String value) {
            addCriterion("user_cmp_name >", value, "userCmpName");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_cmp_name >=", value, "userCmpName");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameLessThan(String value) {
            addCriterion("user_cmp_name <", value, "userCmpName");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameLessThanOrEqualTo(String value) {
            addCriterion("user_cmp_name <=", value, "userCmpName");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameLike(String value) {
            addCriterion("user_cmp_name like", value, "userCmpName");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameNotLike(String value) {
            addCriterion("user_cmp_name not like", value, "userCmpName");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameIn(List<String> values) {
            addCriterion("user_cmp_name in", values, "userCmpName");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameNotIn(List<String> values) {
            addCriterion("user_cmp_name not in", values, "userCmpName");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameBetween(String value1, String value2) {
            addCriterion("user_cmp_name between", value1, value2, "userCmpName");
            return (Criteria) this;
        }

        public Criteria andUserCmpNameNotBetween(String value1, String value2) {
            addCriterion("user_cmp_name not between", value1, value2, "userCmpName");
            return (Criteria) this;
        }

        public Criteria andExtend1IsNull() {
            addCriterion("extend1 is null");
            return (Criteria) this;
        }

        public Criteria andExtend1IsNotNull() {
            addCriterion("extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend1EqualTo(String value) {
            addCriterion("extend1 =", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotEqualTo(String value) {
            addCriterion("extend1 <>", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1GreaterThan(String value) {
            addCriterion("extend1 >", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("extend1 >=", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1LessThan(String value) {
            addCriterion("extend1 <", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1LessThanOrEqualTo(String value) {
            addCriterion("extend1 <=", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1Like(String value) {
            addCriterion("extend1 like", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotLike(String value) {
            addCriterion("extend1 not like", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1In(List<String> values) {
            addCriterion("extend1 in", values, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotIn(List<String> values) {
            addCriterion("extend1 not in", values, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1Between(String value1, String value2) {
            addCriterion("extend1 between", value1, value2, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotBetween(String value1, String value2) {
            addCriterion("extend1 not between", value1, value2, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend2IsNull() {
            addCriterion("extend2 is null");
            return (Criteria) this;
        }

        public Criteria andExtend2IsNotNull() {
            addCriterion("extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend2EqualTo(String value) {
            addCriterion("extend2 =", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotEqualTo(String value) {
            addCriterion("extend2 <>", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2GreaterThan(String value) {
            addCriterion("extend2 >", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("extend2 >=", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2LessThan(String value) {
            addCriterion("extend2 <", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2LessThanOrEqualTo(String value) {
            addCriterion("extend2 <=", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2Like(String value) {
            addCriterion("extend2 like", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotLike(String value) {
            addCriterion("extend2 not like", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2In(List<String> values) {
            addCriterion("extend2 in", values, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotIn(List<String> values) {
            addCriterion("extend2 not in", values, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2Between(String value1, String value2) {
            addCriterion("extend2 between", value1, value2, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotBetween(String value1, String value2) {
            addCriterion("extend2 not between", value1, value2, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend3IsNull() {
            addCriterion("extend3 is null");
            return (Criteria) this;
        }

        public Criteria andExtend3IsNotNull() {
            addCriterion("extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend3EqualTo(String value) {
            addCriterion("extend3 =", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotEqualTo(String value) {
            addCriterion("extend3 <>", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3GreaterThan(String value) {
            addCriterion("extend3 >", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3GreaterThanOrEqualTo(String value) {
            addCriterion("extend3 >=", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3LessThan(String value) {
            addCriterion("extend3 <", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3LessThanOrEqualTo(String value) {
            addCriterion("extend3 <=", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3Like(String value) {
            addCriterion("extend3 like", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotLike(String value) {
            addCriterion("extend3 not like", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3In(List<String> values) {
            addCriterion("extend3 in", values, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotIn(List<String> values) {
            addCriterion("extend3 not in", values, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3Between(String value1, String value2) {
            addCriterion("extend3 between", value1, value2, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotBetween(String value1, String value2) {
            addCriterion("extend3 not between", value1, value2, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend4IsNull() {
            addCriterion("extend4 is null");
            return (Criteria) this;
        }

        public Criteria andExtend4IsNotNull() {
            addCriterion("extend4 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend4EqualTo(String value) {
            addCriterion("extend4 =", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotEqualTo(String value) {
            addCriterion("extend4 <>", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4GreaterThan(String value) {
            addCriterion("extend4 >", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4GreaterThanOrEqualTo(String value) {
            addCriterion("extend4 >=", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4LessThan(String value) {
            addCriterion("extend4 <", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4LessThanOrEqualTo(String value) {
            addCriterion("extend4 <=", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4Like(String value) {
            addCriterion("extend4 like", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotLike(String value) {
            addCriterion("extend4 not like", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4In(List<String> values) {
            addCriterion("extend4 in", values, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotIn(List<String> values) {
            addCriterion("extend4 not in", values, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4Between(String value1, String value2) {
            addCriterion("extend4 between", value1, value2, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotBetween(String value1, String value2) {
            addCriterion("extend4 not between", value1, value2, "extend4");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andNickNameLikeInsensitive(String value) {
            addCriterion("upper(nick_name) like", value.toUpperCase(), "nickName");
            return this;
        }

        public Criteria andPictureLikeInsensitive(String value) {
            addCriterion("upper(picture) like", value.toUpperCase(), "picture");
            return this;
        }

        public Criteria andSexLikeInsensitive(String value) {
            addCriterion("upper(sex) like", value.toUpperCase(), "sex");
            return this;
        }

        public Criteria andUserIdLikeInsensitive(String value) {
            addCriterion("upper(user_id) like", value.toUpperCase(), "userId");
            return this;
        }

        public Criteria andUserNameLikeInsensitive(String value) {
            addCriterion("upper(user_name) like", value.toUpperCase(), "userName");
            return this;
        }

        public Criteria andUserPhoneLikeInsensitive(String value) {
            addCriterion("upper(user_phone) like", value.toUpperCase(), "userPhone");
            return this;
        }

        public Criteria andUserPartIdLikeInsensitive(String value) {
            addCriterion("upper(user_part_id) like", value.toUpperCase(), "userPartId");
            return this;
        }

        public Criteria andUserPartNameLikeInsensitive(String value) {
            addCriterion("upper(user_part_name) like", value.toUpperCase(), "userPartName");
            return this;
        }

        public Criteria andUserCmpIdLikeInsensitive(String value) {
            addCriterion("upper(user_cmp_id) like", value.toUpperCase(), "userCmpId");
            return this;
        }

        public Criteria andUserCmpNameLikeInsensitive(String value) {
            addCriterion("upper(user_cmp_name) like", value.toUpperCase(), "userCmpName");
            return this;
        }

        public Criteria andExtend1LikeInsensitive(String value) {
            addCriterion("upper(extend1) like", value.toUpperCase(), "extend1");
            return this;
        }

        public Criteria andExtend2LikeInsensitive(String value) {
            addCriterion("upper(extend2) like", value.toUpperCase(), "extend2");
            return this;
        }

        public Criteria andExtend3LikeInsensitive(String value) {
            addCriterion("upper(extend3) like", value.toUpperCase(), "extend3");
            return this;
        }

        public Criteria andExtend4LikeInsensitive(String value) {
            addCriterion("upper(extend4) like", value.toUpperCase(), "extend4");
            return this;
        }
    }
}