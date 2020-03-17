package com.yz.sophia.insight.model.po;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RestaurantRankExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryIsNull() {
            addCriterion("restaurant_category is null");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryIsNotNull() {
            addCriterion("restaurant_category is not null");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryEqualTo(String value) {
            addCriterion("restaurant_category =", value, "restaurantCategory");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryNotEqualTo(String value) {
            addCriterion("restaurant_category <>", value, "restaurantCategory");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryGreaterThan(String value) {
            addCriterion("restaurant_category >", value, "restaurantCategory");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("restaurant_category >=", value, "restaurantCategory");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryLessThan(String value) {
            addCriterion("restaurant_category <", value, "restaurantCategory");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryLessThanOrEqualTo(String value) {
            addCriterion("restaurant_category <=", value, "restaurantCategory");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryLike(String value) {
            addCriterion("restaurant_category like", value, "restaurantCategory");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryNotLike(String value) {
            addCriterion("restaurant_category not like", value, "restaurantCategory");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryIn(List<String> values) {
            addCriterion("restaurant_category in", values, "restaurantCategory");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryNotIn(List<String> values) {
            addCriterion("restaurant_category not in", values, "restaurantCategory");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryBetween(String value1, String value2) {
            addCriterion("restaurant_category between", value1, value2, "restaurantCategory");
            return (Criteria) this;
        }

        public Criteria andRestaurantCategoryNotBetween(String value1, String value2) {
            addCriterion("restaurant_category not between", value1, value2, "restaurantCategory");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyIsNull() {
            addCriterion("restaurant_classify is null");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyIsNotNull() {
            addCriterion("restaurant_classify is not null");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyEqualTo(String value) {
            addCriterion("restaurant_classify =", value, "restaurantClassify");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyNotEqualTo(String value) {
            addCriterion("restaurant_classify <>", value, "restaurantClassify");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyGreaterThan(String value) {
            addCriterion("restaurant_classify >", value, "restaurantClassify");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyGreaterThanOrEqualTo(String value) {
            addCriterion("restaurant_classify >=", value, "restaurantClassify");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyLessThan(String value) {
            addCriterion("restaurant_classify <", value, "restaurantClassify");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyLessThanOrEqualTo(String value) {
            addCriterion("restaurant_classify <=", value, "restaurantClassify");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyLike(String value) {
            addCriterion("restaurant_classify like", value, "restaurantClassify");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyNotLike(String value) {
            addCriterion("restaurant_classify not like", value, "restaurantClassify");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyIn(List<String> values) {
            addCriterion("restaurant_classify in", values, "restaurantClassify");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyNotIn(List<String> values) {
            addCriterion("restaurant_classify not in", values, "restaurantClassify");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyBetween(String value1, String value2) {
            addCriterion("restaurant_classify between", value1, value2, "restaurantClassify");
            return (Criteria) this;
        }

        public Criteria andRestaurantClassifyNotBetween(String value1, String value2) {
            addCriterion("restaurant_classify not between", value1, value2, "restaurantClassify");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandIsNull() {
            addCriterion("restaurant_brand is null");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandIsNotNull() {
            addCriterion("restaurant_brand is not null");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandEqualTo(String value) {
            addCriterion("restaurant_brand =", value, "restaurantBrand");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandNotEqualTo(String value) {
            addCriterion("restaurant_brand <>", value, "restaurantBrand");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandGreaterThan(String value) {
            addCriterion("restaurant_brand >", value, "restaurantBrand");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandGreaterThanOrEqualTo(String value) {
            addCriterion("restaurant_brand >=", value, "restaurantBrand");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandLessThan(String value) {
            addCriterion("restaurant_brand <", value, "restaurantBrand");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandLessThanOrEqualTo(String value) {
            addCriterion("restaurant_brand <=", value, "restaurantBrand");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandLike(String value) {
            addCriterion("restaurant_brand like", value, "restaurantBrand");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandNotLike(String value) {
            addCriterion("restaurant_brand not like", value, "restaurantBrand");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandIn(List<String> values) {
            addCriterion("restaurant_brand in", values, "restaurantBrand");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandNotIn(List<String> values) {
            addCriterion("restaurant_brand not in", values, "restaurantBrand");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandBetween(String value1, String value2) {
            addCriterion("restaurant_brand between", value1, value2, "restaurantBrand");
            return (Criteria) this;
        }

        public Criteria andRestaurantBrandNotBetween(String value1, String value2) {
            addCriterion("restaurant_brand not between", value1, value2, "restaurantBrand");
            return (Criteria) this;
        }

        public Criteria andRankCountIsNull() {
            addCriterion("rank_count is null");
            return (Criteria) this;
        }

        public Criteria andRankCountIsNotNull() {
            addCriterion("rank_count is not null");
            return (Criteria) this;
        }

        public Criteria andRankCountEqualTo(Integer value) {
            addCriterion("rank_count =", value, "rankCount");
            return (Criteria) this;
        }

        public Criteria andRankCountNotEqualTo(Integer value) {
            addCriterion("rank_count <>", value, "rankCount");
            return (Criteria) this;
        }

        public Criteria andRankCountGreaterThan(Integer value) {
            addCriterion("rank_count >", value, "rankCount");
            return (Criteria) this;
        }

        public Criteria andRankCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank_count >=", value, "rankCount");
            return (Criteria) this;
        }

        public Criteria andRankCountLessThan(Integer value) {
            addCriterion("rank_count <", value, "rankCount");
            return (Criteria) this;
        }

        public Criteria andRankCountLessThanOrEqualTo(Integer value) {
            addCriterion("rank_count <=", value, "rankCount");
            return (Criteria) this;
        }

        public Criteria andRankCountIn(List<Integer> values) {
            addCriterion("rank_count in", values, "rankCount");
            return (Criteria) this;
        }

        public Criteria andRankCountNotIn(List<Integer> values) {
            addCriterion("rank_count not in", values, "rankCount");
            return (Criteria) this;
        }

        public Criteria andRankCountBetween(Integer value1, Integer value2) {
            addCriterion("rank_count between", value1, value2, "rankCount");
            return (Criteria) this;
        }

        public Criteria andRankCountNotBetween(Integer value1, Integer value2) {
            addCriterion("rank_count not between", value1, value2, "rankCount");
            return (Criteria) this;
        }

        public Criteria andRedListIndexIsNull() {
            addCriterion("red_list_index is null");
            return (Criteria) this;
        }

        public Criteria andRedListIndexIsNotNull() {
            addCriterion("red_list_index is not null");
            return (Criteria) this;
        }

        public Criteria andRedListIndexEqualTo(Integer value) {
            addCriterion("red_list_index =", value, "redListIndex");
            return (Criteria) this;
        }

        public Criteria andRedListIndexNotEqualTo(Integer value) {
            addCriterion("red_list_index <>", value, "redListIndex");
            return (Criteria) this;
        }

        public Criteria andRedListIndexGreaterThan(Integer value) {
            addCriterion("red_list_index >", value, "redListIndex");
            return (Criteria) this;
        }

        public Criteria andRedListIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("red_list_index >=", value, "redListIndex");
            return (Criteria) this;
        }

        public Criteria andRedListIndexLessThan(Integer value) {
            addCriterion("red_list_index <", value, "redListIndex");
            return (Criteria) this;
        }

        public Criteria andRedListIndexLessThanOrEqualTo(Integer value) {
            addCriterion("red_list_index <=", value, "redListIndex");
            return (Criteria) this;
        }

        public Criteria andRedListIndexIn(List<Integer> values) {
            addCriterion("red_list_index in", values, "redListIndex");
            return (Criteria) this;
        }

        public Criteria andRedListIndexNotIn(List<Integer> values) {
            addCriterion("red_list_index not in", values, "redListIndex");
            return (Criteria) this;
        }

        public Criteria andRedListIndexBetween(Integer value1, Integer value2) {
            addCriterion("red_list_index between", value1, value2, "redListIndex");
            return (Criteria) this;
        }

        public Criteria andRedListIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("red_list_index not between", value1, value2, "redListIndex");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileIsNull() {
            addCriterion("company_profile is null");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileIsNotNull() {
            addCriterion("company_profile is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileEqualTo(String value) {
            addCriterion("company_profile =", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileNotEqualTo(String value) {
            addCriterion("company_profile <>", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileGreaterThan(String value) {
            addCriterion("company_profile >", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileGreaterThanOrEqualTo(String value) {
            addCriterion("company_profile >=", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileLessThan(String value) {
            addCriterion("company_profile <", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileLessThanOrEqualTo(String value) {
            addCriterion("company_profile <=", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileLike(String value) {
            addCriterion("company_profile like", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileNotLike(String value) {
            addCriterion("company_profile not like", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileIn(List<String> values) {
            addCriterion("company_profile in", values, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileNotIn(List<String> values) {
            addCriterion("company_profile not in", values, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileBetween(String value1, String value2) {
            addCriterion("company_profile between", value1, value2, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileNotBetween(String value1, String value2) {
            addCriterion("company_profile not between", value1, value2, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("website is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("website is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("website =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("website <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("website >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("website >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("website <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("website <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("website like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("website not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("website in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("website not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("website between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("website not between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("business_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("business_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("business_scope =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("business_scope <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("business_scope >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("business_scope >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("business_scope <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("business_scope <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("business_scope like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("business_scope not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("business_scope in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("business_scope not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("business_scope between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("business_scope not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeIsNull() {
            addCriterion("restaurant_type is null");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeIsNotNull() {
            addCriterion("restaurant_type is not null");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeEqualTo(String value) {
            addCriterion("restaurant_type =", value, "restaurantType");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeNotEqualTo(String value) {
            addCriterion("restaurant_type <>", value, "restaurantType");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeGreaterThan(String value) {
            addCriterion("restaurant_type >", value, "restaurantType");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeGreaterThanOrEqualTo(String value) {
            addCriterion("restaurant_type >=", value, "restaurantType");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeLessThan(String value) {
            addCriterion("restaurant_type <", value, "restaurantType");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeLessThanOrEqualTo(String value) {
            addCriterion("restaurant_type <=", value, "restaurantType");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeLike(String value) {
            addCriterion("restaurant_type like", value, "restaurantType");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeNotLike(String value) {
            addCriterion("restaurant_type not like", value, "restaurantType");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeIn(List<String> values) {
            addCriterion("restaurant_type in", values, "restaurantType");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeNotIn(List<String> values) {
            addCriterion("restaurant_type not in", values, "restaurantType");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeBetween(String value1, String value2) {
            addCriterion("restaurant_type between", value1, value2, "restaurantType");
            return (Criteria) this;
        }

        public Criteria andRestaurantTypeNotBetween(String value1, String value2) {
            addCriterion("restaurant_type not between", value1, value2, "restaurantType");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIn(List<String> values) {
            addCriterion("logo_url in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotIn(List<String> values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
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