package cc.cail.bugms.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BugExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BugExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
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

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Integer value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Integer value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Integer value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Integer value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Integer> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Integer> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Integer value1, Integer value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_id not between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNull() {
            addCriterion("update_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNotNull() {
            addCriterion("update_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdEqualTo(Integer value) {
            addCriterion("update_id =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(Integer value) {
            addCriterion("update_id <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(Integer value) {
            addCriterion("update_id >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_id >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(Integer value) {
            addCriterion("update_id <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_id <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<Integer> values) {
            addCriterion("update_id in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<Integer> values) {
            addCriterion("update_id not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(Integer value1, Integer value2) {
            addCriterion("update_id between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_id not between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andBugTitleIsNull() {
            addCriterion("bug_title is null");
            return (Criteria) this;
        }

        public Criteria andBugTitleIsNotNull() {
            addCriterion("bug_title is not null");
            return (Criteria) this;
        }

        public Criteria andBugTitleEqualTo(String value) {
            addCriterion("bug_title =", value, "bugTitle");
            return (Criteria) this;
        }

        public Criteria andBugTitleNotEqualTo(String value) {
            addCriterion("bug_title <>", value, "bugTitle");
            return (Criteria) this;
        }

        public Criteria andBugTitleGreaterThan(String value) {
            addCriterion("bug_title >", value, "bugTitle");
            return (Criteria) this;
        }

        public Criteria andBugTitleGreaterThanOrEqualTo(String value) {
            addCriterion("bug_title >=", value, "bugTitle");
            return (Criteria) this;
        }

        public Criteria andBugTitleLessThan(String value) {
            addCriterion("bug_title <", value, "bugTitle");
            return (Criteria) this;
        }

        public Criteria andBugTitleLessThanOrEqualTo(String value) {
            addCriterion("bug_title <=", value, "bugTitle");
            return (Criteria) this;
        }

        public Criteria andBugTitleLike(String value) {
            addCriterion("bug_title like", value, "bugTitle");
            return (Criteria) this;
        }

        public Criteria andBugTitleNotLike(String value) {
            addCriterion("bug_title not like", value, "bugTitle");
            return (Criteria) this;
        }

        public Criteria andBugTitleIn(List<String> values) {
            addCriterion("bug_title in", values, "bugTitle");
            return (Criteria) this;
        }

        public Criteria andBugTitleNotIn(List<String> values) {
            addCriterion("bug_title not in", values, "bugTitle");
            return (Criteria) this;
        }

        public Criteria andBugTitleBetween(String value1, String value2) {
            addCriterion("bug_title between", value1, value2, "bugTitle");
            return (Criteria) this;
        }

        public Criteria andBugTitleNotBetween(String value1, String value2) {
            addCriterion("bug_title not between", value1, value2, "bugTitle");
            return (Criteria) this;
        }

        public Criteria andBugDescIsNull() {
            addCriterion("bug_desc is null");
            return (Criteria) this;
        }

        public Criteria andBugDescIsNotNull() {
            addCriterion("bug_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBugDescEqualTo(String value) {
            addCriterion("bug_desc =", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescNotEqualTo(String value) {
            addCriterion("bug_desc <>", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescGreaterThan(String value) {
            addCriterion("bug_desc >", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescGreaterThanOrEqualTo(String value) {
            addCriterion("bug_desc >=", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescLessThan(String value) {
            addCriterion("bug_desc <", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescLessThanOrEqualTo(String value) {
            addCriterion("bug_desc <=", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescLike(String value) {
            addCriterion("bug_desc like", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescNotLike(String value) {
            addCriterion("bug_desc not like", value, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescIn(List<String> values) {
            addCriterion("bug_desc in", values, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescNotIn(List<String> values) {
            addCriterion("bug_desc not in", values, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescBetween(String value1, String value2) {
            addCriterion("bug_desc between", value1, value2, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugDescNotBetween(String value1, String value2) {
            addCriterion("bug_desc not between", value1, value2, "bugDesc");
            return (Criteria) this;
        }

        public Criteria andBugLevelIsNull() {
            addCriterion("bug_level is null");
            return (Criteria) this;
        }

        public Criteria andBugLevelIsNotNull() {
            addCriterion("bug_level is not null");
            return (Criteria) this;
        }

        public Criteria andBugLevelEqualTo(Integer value) {
            addCriterion("bug_level =", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelNotEqualTo(Integer value) {
            addCriterion("bug_level <>", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelGreaterThan(Integer value) {
            addCriterion("bug_level >", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("bug_level >=", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelLessThan(Integer value) {
            addCriterion("bug_level <", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelLessThanOrEqualTo(Integer value) {
            addCriterion("bug_level <=", value, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelIn(List<Integer> values) {
            addCriterion("bug_level in", values, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelNotIn(List<Integer> values) {
            addCriterion("bug_level not in", values, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelBetween(Integer value1, Integer value2) {
            addCriterion("bug_level between", value1, value2, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andBugLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("bug_level not between", value1, value2, "bugLevel");
            return (Criteria) this;
        }

        public Criteria andAssignIdIsNull() {
            addCriterion("assign_id is null");
            return (Criteria) this;
        }

        public Criteria andAssignIdIsNotNull() {
            addCriterion("assign_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssignIdEqualTo(Integer value) {
            addCriterion("assign_id =", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdNotEqualTo(Integer value) {
            addCriterion("assign_id <>", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdGreaterThan(Integer value) {
            addCriterion("assign_id >", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("assign_id >=", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdLessThan(Integer value) {
            addCriterion("assign_id <", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdLessThanOrEqualTo(Integer value) {
            addCriterion("assign_id <=", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdIn(List<Integer> values) {
            addCriterion("assign_id in", values, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdNotIn(List<Integer> values) {
            addCriterion("assign_id not in", values, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdBetween(Integer value1, Integer value2) {
            addCriterion("assign_id between", value1, value2, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdNotBetween(Integer value1, Integer value2) {
            addCriterion("assign_id not between", value1, value2, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignTimeIsNull() {
            addCriterion("assign_time is null");
            return (Criteria) this;
        }

        public Criteria andAssignTimeIsNotNull() {
            addCriterion("assign_time is not null");
            return (Criteria) this;
        }

        public Criteria andAssignTimeEqualTo(Date value) {
            addCriterion("assign_time =", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeNotEqualTo(Date value) {
            addCriterion("assign_time <>", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeGreaterThan(Date value) {
            addCriterion("assign_time >", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("assign_time >=", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeLessThan(Date value) {
            addCriterion("assign_time <", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeLessThanOrEqualTo(Date value) {
            addCriterion("assign_time <=", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeIn(List<Date> values) {
            addCriterion("assign_time in", values, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeNotIn(List<Date> values) {
            addCriterion("assign_time not in", values, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeBetween(Date value1, Date value2) {
            addCriterion("assign_time between", value1, value2, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeNotBetween(Date value1, Date value2) {
            addCriterion("assign_time not between", value1, value2, "assignTime");
            return (Criteria) this;
        }

        public Criteria andBugStatusIsNull() {
            addCriterion("bug_status is null");
            return (Criteria) this;
        }

        public Criteria andBugStatusIsNotNull() {
            addCriterion("bug_status is not null");
            return (Criteria) this;
        }

        public Criteria andBugStatusEqualTo(Integer value) {
            addCriterion("bug_status =", value, "bugStatus");
            return (Criteria) this;
        }

        public Criteria andBugStatusNotEqualTo(Integer value) {
            addCriterion("bug_status <>", value, "bugStatus");
            return (Criteria) this;
        }

        public Criteria andBugStatusGreaterThan(Integer value) {
            addCriterion("bug_status >", value, "bugStatus");
            return (Criteria) this;
        }

        public Criteria andBugStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("bug_status >=", value, "bugStatus");
            return (Criteria) this;
        }

        public Criteria andBugStatusLessThan(Integer value) {
            addCriterion("bug_status <", value, "bugStatus");
            return (Criteria) this;
        }

        public Criteria andBugStatusLessThanOrEqualTo(Integer value) {
            addCriterion("bug_status <=", value, "bugStatus");
            return (Criteria) this;
        }

        public Criteria andBugStatusIn(List<Integer> values) {
            addCriterion("bug_status in", values, "bugStatus");
            return (Criteria) this;
        }

        public Criteria andBugStatusNotIn(List<Integer> values) {
            addCriterion("bug_status not in", values, "bugStatus");
            return (Criteria) this;
        }

        public Criteria andBugStatusBetween(Integer value1, Integer value2) {
            addCriterion("bug_status between", value1, value2, "bugStatus");
            return (Criteria) this;
        }

        public Criteria andBugStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("bug_status not between", value1, value2, "bugStatus");
            return (Criteria) this;
        }

        public Criteria andBak1IsNull() {
            addCriterion("bak1 is null");
            return (Criteria) this;
        }

        public Criteria andBak1IsNotNull() {
            addCriterion("bak1 is not null");
            return (Criteria) this;
        }

        public Criteria andBak1EqualTo(String value) {
            addCriterion("bak1 =", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotEqualTo(String value) {
            addCriterion("bak1 <>", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThan(String value) {
            addCriterion("bak1 >", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThanOrEqualTo(String value) {
            addCriterion("bak1 >=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThan(String value) {
            addCriterion("bak1 <", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThanOrEqualTo(String value) {
            addCriterion("bak1 <=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Like(String value) {
            addCriterion("bak1 like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotLike(String value) {
            addCriterion("bak1 not like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1In(List<String> values) {
            addCriterion("bak1 in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotIn(List<String> values) {
            addCriterion("bak1 not in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Between(String value1, String value2) {
            addCriterion("bak1 between", value1, value2, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotBetween(String value1, String value2) {
            addCriterion("bak1 not between", value1, value2, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak2IsNull() {
            addCriterion("bak2 is null");
            return (Criteria) this;
        }

        public Criteria andBak2IsNotNull() {
            addCriterion("bak2 is not null");
            return (Criteria) this;
        }

        public Criteria andBak2EqualTo(String value) {
            addCriterion("bak2 =", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotEqualTo(String value) {
            addCriterion("bak2 <>", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThan(String value) {
            addCriterion("bak2 >", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThanOrEqualTo(String value) {
            addCriterion("bak2 >=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThan(String value) {
            addCriterion("bak2 <", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThanOrEqualTo(String value) {
            addCriterion("bak2 <=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Like(String value) {
            addCriterion("bak2 like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotLike(String value) {
            addCriterion("bak2 not like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2In(List<String> values) {
            addCriterion("bak2 in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotIn(List<String> values) {
            addCriterion("bak2 not in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Between(String value1, String value2) {
            addCriterion("bak2 between", value1, value2, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotBetween(String value1, String value2) {
            addCriterion("bak2 not between", value1, value2, "bak2");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}