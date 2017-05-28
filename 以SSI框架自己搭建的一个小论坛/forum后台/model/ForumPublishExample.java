package com.nuchina.forum.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForumPublishExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public ForumPublishExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected ForumPublishExample(ForumPublishExample example) {
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andDraftTimeIsNull() {
            addCriterion("draft_time is null");
            return (Criteria) this;
        }

        public Criteria andDraftTimeIsNotNull() {
            addCriterion("draft_time is not null");
            return (Criteria) this;
        }

        public Criteria andDraftTimeEqualTo(Date value) {
            addCriterion("draft_time =", value, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeNotEqualTo(Date value) {
            addCriterion("draft_time <>", value, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeGreaterThan(Date value) {
            addCriterion("draft_time >", value, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("draft_time >=", value, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeLessThan(Date value) {
            addCriterion("draft_time <", value, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeLessThanOrEqualTo(Date value) {
            addCriterion("draft_time <=", value, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeIn(List<Date> values) {
            addCriterion("draft_time in", values, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeNotIn(List<Date> values) {
            addCriterion("draft_time not in", values, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeBetween(Date value1, Date value2) {
            addCriterion("draft_time between", value1, value2, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDraftTimeNotBetween(Date value1, Date value2) {
            addCriterion("draft_time not between", value1, value2, "draftTime");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneIsNull() {
            addCriterion("drafter_phone is null");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneIsNotNull() {
            addCriterion("drafter_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneEqualTo(String value) {
            addCriterion("drafter_phone =", value, "drafterPhone");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneNotEqualTo(String value) {
            addCriterion("drafter_phone <>", value, "drafterPhone");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneGreaterThan(String value) {
            addCriterion("drafter_phone >", value, "drafterPhone");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("drafter_phone >=", value, "drafterPhone");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneLessThan(String value) {
            addCriterion("drafter_phone <", value, "drafterPhone");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneLessThanOrEqualTo(String value) {
            addCriterion("drafter_phone <=", value, "drafterPhone");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneLike(String value) {
            addCriterion("drafter_phone like", value, "drafterPhone");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneNotLike(String value) {
            addCriterion("drafter_phone not like", value, "drafterPhone");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneIn(List<String> values) {
            addCriterion("drafter_phone in", values, "drafterPhone");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneNotIn(List<String> values) {
            addCriterion("drafter_phone not in", values, "drafterPhone");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneBetween(String value1, String value2) {
            addCriterion("drafter_phone between", value1, value2, "drafterPhone");
            return (Criteria) this;
        }

        public Criteria andDrafterPhoneNotBetween(String value1, String value2) {
            addCriterion("drafter_phone not between", value1, value2, "drafterPhone");
            return (Criteria) this;
        }

        public Criteria andPostSortIsNull() {
            addCriterion("post_sort is null");
            return (Criteria) this;
        }

        public Criteria andPostSortIsNotNull() {
            addCriterion("post_sort is not null");
            return (Criteria) this;
        }

        public Criteria andPostSortEqualTo(String value) {
            addCriterion("post_sort =", value, "postSort");
            return (Criteria) this;
        }

        public Criteria andPostSortNotEqualTo(String value) {
            addCriterion("post_sort <>", value, "postSort");
            return (Criteria) this;
        }

        public Criteria andPostSortGreaterThan(String value) {
            addCriterion("post_sort >", value, "postSort");
            return (Criteria) this;
        }

        public Criteria andPostSortGreaterThanOrEqualTo(String value) {
            addCriterion("post_sort >=", value, "postSort");
            return (Criteria) this;
        }

        public Criteria andPostSortLessThan(String value) {
            addCriterion("post_sort <", value, "postSort");
            return (Criteria) this;
        }

        public Criteria andPostSortLessThanOrEqualTo(String value) {
            addCriterion("post_sort <=", value, "postSort");
            return (Criteria) this;
        }

        public Criteria andPostSortLike(String value) {
            addCriterion("post_sort like", value, "postSort");
            return (Criteria) this;
        }

        public Criteria andPostSortNotLike(String value) {
            addCriterion("post_sort not like", value, "postSort");
            return (Criteria) this;
        }

        public Criteria andPostSortIn(List<String> values) {
            addCriterion("post_sort in", values, "postSort");
            return (Criteria) this;
        }

        public Criteria andPostSortNotIn(List<String> values) {
            addCriterion("post_sort not in", values, "postSort");
            return (Criteria) this;
        }

        public Criteria andPostSortBetween(String value1, String value2) {
            addCriterion("post_sort between", value1, value2, "postSort");
            return (Criteria) this;
        }

        public Criteria andPostSortNotBetween(String value1, String value2) {
            addCriterion("post_sort not between", value1, value2, "postSort");
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

        public Criteria andViewNumIsNull() {
            addCriterion("view_num is null");
            return (Criteria) this;
        }

        public Criteria andViewNumIsNotNull() {
            addCriterion("view_num is not null");
            return (Criteria) this;
        }

        public Criteria andViewNumEqualTo(Long value) {
            addCriterion("view_num =", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumNotEqualTo(Long value) {
            addCriterion("view_num <>", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumGreaterThan(Long value) {
            addCriterion("view_num >", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumGreaterThanOrEqualTo(Long value) {
            addCriterion("view_num >=", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumLessThan(Long value) {
            addCriterion("view_num <", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumLessThanOrEqualTo(Long value) {
            addCriterion("view_num <=", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumIn(List<Long> values) {
            addCriterion("view_num in", values, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumNotIn(List<Long> values) {
            addCriterion("view_num not in", values, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumBetween(Long value1, Long value2) {
            addCriterion("view_num between", value1, value2, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumNotBetween(Long value1, Long value2) {
            addCriterion("view_num not between", value1, value2, "viewNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumIsNull() {
            addCriterion("praise_num is null");
            return (Criteria) this;
        }

        public Criteria andPraiseNumIsNotNull() {
            addCriterion("praise_num is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseNumEqualTo(Long value) {
            addCriterion("praise_num =", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumNotEqualTo(Long value) {
            addCriterion("praise_num <>", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumGreaterThan(Long value) {
            addCriterion("praise_num >", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumGreaterThanOrEqualTo(Long value) {
            addCriterion("praise_num >=", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumLessThan(Long value) {
            addCriterion("praise_num <", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumLessThanOrEqualTo(Long value) {
            addCriterion("praise_num <=", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumIn(List<Long> values) {
            addCriterion("praise_num in", values, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumNotIn(List<Long> values) {
            addCriterion("praise_num not in", values, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumBetween(Long value1, Long value2) {
            addCriterion("praise_num between", value1, value2, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumNotBetween(Long value1, Long value2) {
            addCriterion("praise_num not between", value1, value2, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumIsNull() {
            addCriterion("reply_num is null");
            return (Criteria) this;
        }

        public Criteria andReplyNumIsNotNull() {
            addCriterion("reply_num is not null");
            return (Criteria) this;
        }

        public Criteria andReplyNumEqualTo(Long value) {
            addCriterion("reply_num =", value, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumNotEqualTo(Long value) {
            addCriterion("reply_num <>", value, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumGreaterThan(Long value) {
            addCriterion("reply_num >", value, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumGreaterThanOrEqualTo(Long value) {
            addCriterion("reply_num >=", value, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumLessThan(Long value) {
            addCriterion("reply_num <", value, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumLessThanOrEqualTo(Long value) {
            addCriterion("reply_num <=", value, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumIn(List<Long> values) {
            addCriterion("reply_num in", values, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumNotIn(List<Long> values) {
            addCriterion("reply_num not in", values, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumBetween(Long value1, Long value2) {
            addCriterion("reply_num between", value1, value2, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumNotBetween(Long value1, Long value2) {
            addCriterion("reply_num not between", value1, value2, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIsNull() {
            addCriterion("reply_status is null");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIsNotNull() {
            addCriterion("reply_status is not null");
            return (Criteria) this;
        }

        public Criteria andReplyStatusEqualTo(Long value) {
            addCriterion("reply_status =", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotEqualTo(Long value) {
            addCriterion("reply_status <>", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusGreaterThan(Long value) {
            addCriterion("reply_status >", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("reply_status >=", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLessThan(Long value) {
            addCriterion("reply_status <", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLessThanOrEqualTo(Long value) {
            addCriterion("reply_status <=", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIn(List<Long> values) {
            addCriterion("reply_status in", values, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotIn(List<Long> values) {
            addCriterion("reply_status not in", values, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusBetween(Long value1, Long value2) {
            addCriterion("reply_status between", value1, value2, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotBetween(Long value1, Long value2) {
            addCriterion("reply_status not between", value1, value2, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andIsPublicityIsNull() {
            addCriterion("is_publicity is null");
            return (Criteria) this;
        }

        public Criteria andIsPublicityIsNotNull() {
            addCriterion("is_publicity is not null");
            return (Criteria) this;
        }

        public Criteria andIsPublicityEqualTo(Long value) {
            addCriterion("is_publicity =", value, "isPublicity");
            return (Criteria) this;
        }

        public Criteria andIsPublicityNotEqualTo(Long value) {
            addCriterion("is_publicity <>", value, "isPublicity");
            return (Criteria) this;
        }

        public Criteria andIsPublicityGreaterThan(Long value) {
            addCriterion("is_publicity >", value, "isPublicity");
            return (Criteria) this;
        }

        public Criteria andIsPublicityGreaterThanOrEqualTo(Long value) {
            addCriterion("is_publicity >=", value, "isPublicity");
            return (Criteria) this;
        }

        public Criteria andIsPublicityLessThan(Long value) {
            addCriterion("is_publicity <", value, "isPublicity");
            return (Criteria) this;
        }

        public Criteria andIsPublicityLessThanOrEqualTo(Long value) {
            addCriterion("is_publicity <=", value, "isPublicity");
            return (Criteria) this;
        }

        public Criteria andIsPublicityIn(List<Long> values) {
            addCriterion("is_publicity in", values, "isPublicity");
            return (Criteria) this;
        }

        public Criteria andIsPublicityNotIn(List<Long> values) {
            addCriterion("is_publicity not in", values, "isPublicity");
            return (Criteria) this;
        }

        public Criteria andIsPublicityBetween(Long value1, Long value2) {
            addCriterion("is_publicity between", value1, value2, "isPublicity");
            return (Criteria) this;
        }

        public Criteria andIsPublicityNotBetween(Long value1, Long value2) {
            addCriterion("is_publicity not between", value1, value2, "isPublicity");
            return (Criteria) this;
        }

        public Criteria andIsStickIsNull() {
            addCriterion("is_stick is null");
            return (Criteria) this;
        }

        public Criteria andIsStickIsNotNull() {
            addCriterion("is_stick is not null");
            return (Criteria) this;
        }

        public Criteria andIsStickEqualTo(Long value) {
            addCriterion("is_stick =", value, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickNotEqualTo(Long value) {
            addCriterion("is_stick <>", value, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickGreaterThan(Long value) {
            addCriterion("is_stick >", value, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickGreaterThanOrEqualTo(Long value) {
            addCriterion("is_stick >=", value, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickLessThan(Long value) {
            addCriterion("is_stick <", value, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickLessThanOrEqualTo(Long value) {
            addCriterion("is_stick <=", value, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickIn(List<Long> values) {
            addCriterion("is_stick in", values, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickNotIn(List<Long> values) {
            addCriterion("is_stick not in", values, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickBetween(Long value1, Long value2) {
            addCriterion("is_stick between", value1, value2, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickNotBetween(Long value1, Long value2) {
            addCriterion("is_stick not between", value1, value2, "isStick");
            return (Criteria) this;
        }

        public Criteria andBestTopicIsNull() {
            addCriterion("best_topic is null");
            return (Criteria) this;
        }

        public Criteria andBestTopicIsNotNull() {
            addCriterion("best_topic is not null");
            return (Criteria) this;
        }

        public Criteria andBestTopicEqualTo(String value) {
            addCriterion("best_topic =", value, "bestTopic");
            return (Criteria) this;
        }

        public Criteria andBestTopicNotEqualTo(String value) {
            addCriterion("best_topic <>", value, "bestTopic");
            return (Criteria) this;
        }

        public Criteria andBestTopicGreaterThan(String value) {
            addCriterion("best_topic >", value, "bestTopic");
            return (Criteria) this;
        }

        public Criteria andBestTopicGreaterThanOrEqualTo(String value) {
            addCriterion("best_topic >=", value, "bestTopic");
            return (Criteria) this;
        }

        public Criteria andBestTopicLessThan(String value) {
            addCriterion("best_topic <", value, "bestTopic");
            return (Criteria) this;
        }

        public Criteria andBestTopicLessThanOrEqualTo(String value) {
            addCriterion("best_topic <=", value, "bestTopic");
            return (Criteria) this;
        }

        public Criteria andBestTopicLike(String value) {
            addCriterion("best_topic like", value, "bestTopic");
            return (Criteria) this;
        }

        public Criteria andBestTopicNotLike(String value) {
            addCriterion("best_topic not like", value, "bestTopic");
            return (Criteria) this;
        }

        public Criteria andBestTopicIn(List<String> values) {
            addCriterion("best_topic in", values, "bestTopic");
            return (Criteria) this;
        }

        public Criteria andBestTopicNotIn(List<String> values) {
            addCriterion("best_topic not in", values, "bestTopic");
            return (Criteria) this;
        }

        public Criteria andBestTopicBetween(String value1, String value2) {
            addCriterion("best_topic between", value1, value2, "bestTopic");
            return (Criteria) this;
        }

        public Criteria andBestTopicNotBetween(String value1, String value2) {
            addCriterion("best_topic not between", value1, value2, "bestTopic");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andStickTimeIsNull() {
            addCriterion("stick_time is null");
            return (Criteria) this;
        }

        public Criteria andStickTimeIsNotNull() {
            addCriterion("stick_time is not null");
            return (Criteria) this;
        }

        public Criteria andStickTimeEqualTo(Date value) {
            addCriterion("stick_time =", value, "stickTime");
            return (Criteria) this;
        }

        public Criteria andStickTimeNotEqualTo(Date value) {
            addCriterion("stick_time <>", value, "stickTime");
            return (Criteria) this;
        }

        public Criteria andStickTimeGreaterThan(Date value) {
            addCriterion("stick_time >", value, "stickTime");
            return (Criteria) this;
        }

        public Criteria andStickTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stick_time >=", value, "stickTime");
            return (Criteria) this;
        }

        public Criteria andStickTimeLessThan(Date value) {
            addCriterion("stick_time <", value, "stickTime");
            return (Criteria) this;
        }

        public Criteria andStickTimeLessThanOrEqualTo(Date value) {
            addCriterion("stick_time <=", value, "stickTime");
            return (Criteria) this;
        }

        public Criteria andStickTimeIn(List<Date> values) {
            addCriterion("stick_time in", values, "stickTime");
            return (Criteria) this;
        }

        public Criteria andStickTimeNotIn(List<Date> values) {
            addCriterion("stick_time not in", values, "stickTime");
            return (Criteria) this;
        }

        public Criteria andStickTimeBetween(Date value1, Date value2) {
            addCriterion("stick_time between", value1, value2, "stickTime");
            return (Criteria) this;
        }

        public Criteria andStickTimeNotBetween(Date value1, Date value2) {
            addCriterion("stick_time not between", value1, value2, "stickTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeIsNull() {
            addCriterion("best_time is null");
            return (Criteria) this;
        }

        public Criteria andBestTimeIsNotNull() {
            addCriterion("best_time is not null");
            return (Criteria) this;
        }

        public Criteria andBestTimeEqualTo(Date value) {
            addCriterion("best_time =", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeNotEqualTo(Date value) {
            addCriterion("best_time <>", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeGreaterThan(Date value) {
            addCriterion("best_time >", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("best_time >=", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeLessThan(Date value) {
            addCriterion("best_time <", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeLessThanOrEqualTo(Date value) {
            addCriterion("best_time <=", value, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeIn(List<Date> values) {
            addCriterion("best_time in", values, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeNotIn(List<Date> values) {
            addCriterion("best_time not in", values, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeBetween(Date value1, Date value2) {
            addCriterion("best_time between", value1, value2, "bestTime");
            return (Criteria) this;
        }

        public Criteria andBestTimeNotBetween(Date value1, Date value2) {
            addCriterion("best_time not between", value1, value2, "bestTime");
            return (Criteria) this;
        }

        public Criteria andSortDetailIsNull() {
            addCriterion("sort_detail is null");
            return (Criteria) this;
        }

        public Criteria andSortDetailIsNotNull() {
            addCriterion("sort_detail is not null");
            return (Criteria) this;
        }

        public Criteria andSortDetailEqualTo(String value) {
            addCriterion("sort_detail =", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailNotEqualTo(String value) {
            addCriterion("sort_detail <>", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailGreaterThan(String value) {
            addCriterion("sort_detail >", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailGreaterThanOrEqualTo(String value) {
            addCriterion("sort_detail >=", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailLessThan(String value) {
            addCriterion("sort_detail <", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailLessThanOrEqualTo(String value) {
            addCriterion("sort_detail <=", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailLike(String value) {
            addCriterion("sort_detail like", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailNotLike(String value) {
            addCriterion("sort_detail not like", value, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailIn(List<String> values) {
            addCriterion("sort_detail in", values, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailNotIn(List<String> values) {
            addCriterion("sort_detail not in", values, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailBetween(String value1, String value2) {
            addCriterion("sort_detail between", value1, value2, "sortDetail");
            return (Criteria) this;
        }

        public Criteria andSortDetailNotBetween(String value1, String value2) {
            addCriterion("sort_detail not between", value1, value2, "sortDetail");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andTitleLikeInsensitive(String value) {
            addCriterion("upper(title) like", value.toUpperCase(), "title");
            return this;
        }

        public Criteria andContentLikeInsensitive(String value) {
            addCriterion("upper(content) like", value.toUpperCase(), "content");
            return this;
        }

        public Criteria andPictureLikeInsensitive(String value) {
            addCriterion("upper(picture) like", value.toUpperCase(), "picture");
            return this;
        }

        public Criteria andNickNameLikeInsensitive(String value) {
            addCriterion("upper(nick_name) like", value.toUpperCase(), "nickName");
            return this;
        }

        public Criteria andDrafterPhoneLikeInsensitive(String value) {
            addCriterion("upper(drafter_phone) like", value.toUpperCase(), "drafterPhone");
            return this;
        }

        public Criteria andPostSortLikeInsensitive(String value) {
            addCriterion("upper(post_sort) like", value.toUpperCase(), "postSort");
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

        public Criteria andBestTopicLikeInsensitive(String value) {
            addCriterion("upper(best_topic) like", value.toUpperCase(), "bestTopic");
            return this;
        }

        public Criteria andColorLikeInsensitive(String value) {
            addCriterion("upper(color) like", value.toUpperCase(), "color");
            return this;
        }

        public Criteria andSortDetailLikeInsensitive(String value) {
            addCriterion("upper(sort_detail) like", value.toUpperCase(), "sortDetail");
            return this;
        }
    }
}