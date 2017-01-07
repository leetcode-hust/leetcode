package com.ziling.www.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvertisementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvertisementExample() {
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

        public Criteria andAdIdIsNull() {
            addCriterion("ad_id is null");
            return (Criteria) this;
        }

        public Criteria andAdIdIsNotNull() {
            addCriterion("ad_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdIdEqualTo(String value) {
            addCriterion("ad_id =", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotEqualTo(String value) {
            addCriterion("ad_id <>", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThan(String value) {
            addCriterion("ad_id >", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThanOrEqualTo(String value) {
            addCriterion("ad_id >=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThan(String value) {
            addCriterion("ad_id <", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThanOrEqualTo(String value) {
            addCriterion("ad_id <=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLike(String value) {
            addCriterion("ad_id like", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotLike(String value) {
            addCriterion("ad_id not like", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdIn(List<String> values) {
            addCriterion("ad_id in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotIn(List<String> values) {
            addCriterion("ad_id not in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdBetween(String value1, String value2) {
            addCriterion("ad_id between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotBetween(String value1, String value2) {
            addCriterion("ad_id not between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdIsNull() {
            addCriterion("related_project_id is null");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdIsNotNull() {
            addCriterion("related_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdEqualTo(String value) {
            addCriterion("related_project_id =", value, "relatedProjectId");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdNotEqualTo(String value) {
            addCriterion("related_project_id <>", value, "relatedProjectId");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdGreaterThan(String value) {
            addCriterion("related_project_id >", value, "relatedProjectId");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("related_project_id >=", value, "relatedProjectId");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdLessThan(String value) {
            addCriterion("related_project_id <", value, "relatedProjectId");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdLessThanOrEqualTo(String value) {
            addCriterion("related_project_id <=", value, "relatedProjectId");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdLike(String value) {
            addCriterion("related_project_id like", value, "relatedProjectId");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdNotLike(String value) {
            addCriterion("related_project_id not like", value, "relatedProjectId");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdIn(List<String> values) {
            addCriterion("related_project_id in", values, "relatedProjectId");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdNotIn(List<String> values) {
            addCriterion("related_project_id not in", values, "relatedProjectId");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdBetween(String value1, String value2) {
            addCriterion("related_project_id between", value1, value2, "relatedProjectId");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectIdNotBetween(String value1, String value2) {
            addCriterion("related_project_id not between", value1, value2, "relatedProjectId");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameIsNull() {
            addCriterion("related_project_name is null");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameIsNotNull() {
            addCriterion("related_project_name is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameEqualTo(String value) {
            addCriterion("related_project_name =", value, "relatedProjectName");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameNotEqualTo(String value) {
            addCriterion("related_project_name <>", value, "relatedProjectName");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameGreaterThan(String value) {
            addCriterion("related_project_name >", value, "relatedProjectName");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("related_project_name >=", value, "relatedProjectName");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameLessThan(String value) {
            addCriterion("related_project_name <", value, "relatedProjectName");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameLessThanOrEqualTo(String value) {
            addCriterion("related_project_name <=", value, "relatedProjectName");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameLike(String value) {
            addCriterion("related_project_name like", value, "relatedProjectName");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameNotLike(String value) {
            addCriterion("related_project_name not like", value, "relatedProjectName");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameIn(List<String> values) {
            addCriterion("related_project_name in", values, "relatedProjectName");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameNotIn(List<String> values) {
            addCriterion("related_project_name not in", values, "relatedProjectName");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameBetween(String value1, String value2) {
            addCriterion("related_project_name between", value1, value2, "relatedProjectName");
            return (Criteria) this;
        }

        public Criteria andRelatedProjectNameNotBetween(String value1, String value2) {
            addCriterion("related_project_name not between", value1, value2, "relatedProjectName");
            return (Criteria) this;
        }

        public Criteria andAdNumberIsNull() {
            addCriterion("ad_number is null");
            return (Criteria) this;
        }

        public Criteria andAdNumberIsNotNull() {
            addCriterion("ad_number is not null");
            return (Criteria) this;
        }

        public Criteria andAdNumberEqualTo(Integer value) {
            addCriterion("ad_number =", value, "adNumber");
            return (Criteria) this;
        }

        public Criteria andAdNumberNotEqualTo(Integer value) {
            addCriterion("ad_number <>", value, "adNumber");
            return (Criteria) this;
        }

        public Criteria andAdNumberGreaterThan(Integer value) {
            addCriterion("ad_number >", value, "adNumber");
            return (Criteria) this;
        }

        public Criteria andAdNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_number >=", value, "adNumber");
            return (Criteria) this;
        }

        public Criteria andAdNumberLessThan(Integer value) {
            addCriterion("ad_number <", value, "adNumber");
            return (Criteria) this;
        }

        public Criteria andAdNumberLessThanOrEqualTo(Integer value) {
            addCriterion("ad_number <=", value, "adNumber");
            return (Criteria) this;
        }

        public Criteria andAdNumberIn(List<Integer> values) {
            addCriterion("ad_number in", values, "adNumber");
            return (Criteria) this;
        }

        public Criteria andAdNumberNotIn(List<Integer> values) {
            addCriterion("ad_number not in", values, "adNumber");
            return (Criteria) this;
        }

        public Criteria andAdNumberBetween(Integer value1, Integer value2) {
            addCriterion("ad_number between", value1, value2, "adNumber");
            return (Criteria) this;
        }

        public Criteria andAdNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_number not between", value1, value2, "adNumber");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andVaildTimeIsNull() {
            addCriterion("vaild_time is null");
            return (Criteria) this;
        }

        public Criteria andVaildTimeIsNotNull() {
            addCriterion("vaild_time is not null");
            return (Criteria) this;
        }

        public Criteria andVaildTimeEqualTo(Integer value) {
            addCriterion("vaild_time =", value, "vaildTime");
            return (Criteria) this;
        }

        public Criteria andVaildTimeNotEqualTo(Integer value) {
            addCriterion("vaild_time <>", value, "vaildTime");
            return (Criteria) this;
        }

        public Criteria andVaildTimeGreaterThan(Integer value) {
            addCriterion("vaild_time >", value, "vaildTime");
            return (Criteria) this;
        }

        public Criteria andVaildTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("vaild_time >=", value, "vaildTime");
            return (Criteria) this;
        }

        public Criteria andVaildTimeLessThan(Integer value) {
            addCriterion("vaild_time <", value, "vaildTime");
            return (Criteria) this;
        }

        public Criteria andVaildTimeLessThanOrEqualTo(Integer value) {
            addCriterion("vaild_time <=", value, "vaildTime");
            return (Criteria) this;
        }

        public Criteria andVaildTimeIn(List<Integer> values) {
            addCriterion("vaild_time in", values, "vaildTime");
            return (Criteria) this;
        }

        public Criteria andVaildTimeNotIn(List<Integer> values) {
            addCriterion("vaild_time not in", values, "vaildTime");
            return (Criteria) this;
        }

        public Criteria andVaildTimeBetween(Integer value1, Integer value2) {
            addCriterion("vaild_time between", value1, value2, "vaildTime");
            return (Criteria) this;
        }

        public Criteria andVaildTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("vaild_time not between", value1, value2, "vaildTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Date value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andIsAdIsNull() {
            addCriterion("is_ad is null");
            return (Criteria) this;
        }

        public Criteria andIsAdIsNotNull() {
            addCriterion("is_ad is not null");
            return (Criteria) this;
        }

        public Criteria andIsAdEqualTo(Integer value) {
            addCriterion("is_ad =", value, "isAd");
            return (Criteria) this;
        }

        public Criteria andIsAdNotEqualTo(Integer value) {
            addCriterion("is_ad <>", value, "isAd");
            return (Criteria) this;
        }

        public Criteria andIsAdGreaterThan(Integer value) {
            addCriterion("is_ad >", value, "isAd");
            return (Criteria) this;
        }

        public Criteria andIsAdGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_ad >=", value, "isAd");
            return (Criteria) this;
        }

        public Criteria andIsAdLessThan(Integer value) {
            addCriterion("is_ad <", value, "isAd");
            return (Criteria) this;
        }

        public Criteria andIsAdLessThanOrEqualTo(Integer value) {
            addCriterion("is_ad <=", value, "isAd");
            return (Criteria) this;
        }

        public Criteria andIsAdIn(List<Integer> values) {
            addCriterion("is_ad in", values, "isAd");
            return (Criteria) this;
        }

        public Criteria andIsAdNotIn(List<Integer> values) {
            addCriterion("is_ad not in", values, "isAd");
            return (Criteria) this;
        }

        public Criteria andIsAdBetween(Integer value1, Integer value2) {
            addCriterion("is_ad between", value1, value2, "isAd");
            return (Criteria) this;
        }

        public Criteria andIsAdNotBetween(Integer value1, Integer value2) {
            addCriterion("is_ad not between", value1, value2, "isAd");
            return (Criteria) this;
        }

        public Criteria andAdStatusIsNull() {
            addCriterion("ad_status is null");
            return (Criteria) this;
        }

        public Criteria andAdStatusIsNotNull() {
            addCriterion("ad_status is not null");
            return (Criteria) this;
        }

        public Criteria andAdStatusEqualTo(Integer value) {
            addCriterion("ad_status =", value, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusNotEqualTo(Integer value) {
            addCriterion("ad_status <>", value, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusGreaterThan(Integer value) {
            addCriterion("ad_status >", value, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_status >=", value, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusLessThan(Integer value) {
            addCriterion("ad_status <", value, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ad_status <=", value, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusIn(List<Integer> values) {
            addCriterion("ad_status in", values, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusNotIn(List<Integer> values) {
            addCriterion("ad_status not in", values, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusBetween(Integer value1, Integer value2) {
            addCriterion("ad_status between", value1, value2, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_status not between", value1, value2, "adStatus");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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