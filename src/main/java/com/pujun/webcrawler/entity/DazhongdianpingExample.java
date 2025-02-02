package com.pujun.webcrawler.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DazhongdianpingExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    public DazhongdianpingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
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

        public Criteria andShopidIsNull() {
            addCriterion("shopId is null");
            return (Criteria) this;
        }

        public Criteria andShopidIsNotNull() {
            addCriterion("shopId is not null");
            return (Criteria) this;
        }

        public Criteria andShopidEqualTo(String value) {
            addCriterion("shopId =", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotEqualTo(String value) {
            addCriterion("shopId <>", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidGreaterThan(String value) {
            addCriterion("shopId >", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidGreaterThanOrEqualTo(String value) {
            addCriterion("shopId >=", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLessThan(String value) {
            addCriterion("shopId <", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLessThanOrEqualTo(String value) {
            addCriterion("shopId <=", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLike(String value) {
            addCriterion("shopId like", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotLike(String value) {
            addCriterion("shopId not like", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidIn(List<String> values) {
            addCriterion("shopId in", values, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotIn(List<String> values) {
            addCriterion("shopId not in", values, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidBetween(String value1, String value2) {
            addCriterion("shopId between", value1, value2, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotBetween(String value1, String value2) {
            addCriterion("shopId not between", value1, value2, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopnameIsNull() {
            addCriterion("shopName is null");
            return (Criteria) this;
        }

        public Criteria andShopnameIsNotNull() {
            addCriterion("shopName is not null");
            return (Criteria) this;
        }

        public Criteria andShopnameEqualTo(String value) {
            addCriterion("shopName =", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameNotEqualTo(String value) {
            addCriterion("shopName <>", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameGreaterThan(String value) {
            addCriterion("shopName >", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameGreaterThanOrEqualTo(String value) {
            addCriterion("shopName >=", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameLessThan(String value) {
            addCriterion("shopName <", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameLessThanOrEqualTo(String value) {
            addCriterion("shopName <=", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameLike(String value) {
            addCriterion("shopName like", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameNotLike(String value) {
            addCriterion("shopName not like", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameIn(List<String> values) {
            addCriterion("shopName in", values, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameNotIn(List<String> values) {
            addCriterion("shopName not in", values, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameBetween(String value1, String value2) {
            addCriterion("shopName between", value1, value2, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameNotBetween(String value1, String value2) {
            addCriterion("shopName not between", value1, value2, "shopname");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIsNull() {
            addCriterion("addr_province is null");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIsNotNull() {
            addCriterion("addr_province is not null");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceEqualTo(String value) {
            addCriterion("addr_province =", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNotEqualTo(String value) {
            addCriterion("addr_province <>", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceGreaterThan(String value) {
            addCriterion("addr_province >", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("addr_province >=", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceLessThan(String value) {
            addCriterion("addr_province <", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceLessThanOrEqualTo(String value) {
            addCriterion("addr_province <=", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceLike(String value) {
            addCriterion("addr_province like", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNotLike(String value) {
            addCriterion("addr_province not like", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIn(List<String> values) {
            addCriterion("addr_province in", values, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNotIn(List<String> values) {
            addCriterion("addr_province not in", values, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceBetween(String value1, String value2) {
            addCriterion("addr_province between", value1, value2, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNotBetween(String value1, String value2) {
            addCriterion("addr_province not between", value1, value2, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrCityIsNull() {
            addCriterion("addr_city is null");
            return (Criteria) this;
        }

        public Criteria andAddrCityIsNotNull() {
            addCriterion("addr_city is not null");
            return (Criteria) this;
        }

        public Criteria andAddrCityEqualTo(String value) {
            addCriterion("addr_city =", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityNotEqualTo(String value) {
            addCriterion("addr_city <>", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityGreaterThan(String value) {
            addCriterion("addr_city >", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityGreaterThanOrEqualTo(String value) {
            addCriterion("addr_city >=", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityLessThan(String value) {
            addCriterion("addr_city <", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityLessThanOrEqualTo(String value) {
            addCriterion("addr_city <=", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityLike(String value) {
            addCriterion("addr_city like", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityNotLike(String value) {
            addCriterion("addr_city not like", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityIn(List<String> values) {
            addCriterion("addr_city in", values, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityNotIn(List<String> values) {
            addCriterion("addr_city not in", values, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityBetween(String value1, String value2) {
            addCriterion("addr_city between", value1, value2, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityNotBetween(String value1, String value2) {
            addCriterion("addr_city not between", value1, value2, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIsNull() {
            addCriterion("addr_district is null");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIsNotNull() {
            addCriterion("addr_district is not null");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictEqualTo(String value) {
            addCriterion("addr_district =", value, "addrDistrict");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNotEqualTo(String value) {
            addCriterion("addr_district <>", value, "addrDistrict");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictGreaterThan(String value) {
            addCriterion("addr_district >", value, "addrDistrict");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("addr_district >=", value, "addrDistrict");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictLessThan(String value) {
            addCriterion("addr_district <", value, "addrDistrict");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictLessThanOrEqualTo(String value) {
            addCriterion("addr_district <=", value, "addrDistrict");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictLike(String value) {
            addCriterion("addr_district like", value, "addrDistrict");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNotLike(String value) {
            addCriterion("addr_district not like", value, "addrDistrict");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictIn(List<String> values) {
            addCriterion("addr_district in", values, "addrDistrict");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNotIn(List<String> values) {
            addCriterion("addr_district not in", values, "addrDistrict");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictBetween(String value1, String value2) {
            addCriterion("addr_district between", value1, value2, "addrDistrict");
            return (Criteria) this;
        }

        public Criteria andAddrDistrictNotBetween(String value1, String value2) {
            addCriterion("addr_district not between", value1, value2, "addrDistrict");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andPhonenoIsNull() {
            addCriterion("phoneNo is null");
            return (Criteria) this;
        }

        public Criteria andPhonenoIsNotNull() {
            addCriterion("phoneNo is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenoEqualTo(String value) {
            addCriterion("phoneNo =", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoNotEqualTo(String value) {
            addCriterion("phoneNo <>", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoGreaterThan(String value) {
            addCriterion("phoneNo >", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNo >=", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoLessThan(String value) {
            addCriterion("phoneNo <", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoLessThanOrEqualTo(String value) {
            addCriterion("phoneNo <=", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoLike(String value) {
            addCriterion("phoneNo like", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoNotLike(String value) {
            addCriterion("phoneNo not like", value, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoIn(List<String> values) {
            addCriterion("phoneNo in", values, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoNotIn(List<String> values) {
            addCriterion("phoneNo not in", values, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoBetween(String value1, String value2) {
            addCriterion("phoneNo between", value1, value2, "phoneno");
            return (Criteria) this;
        }

        public Criteria andPhonenoNotBetween(String value1, String value2) {
            addCriterion("phoneNo not between", value1, value2, "phoneno");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIsNull() {
            addCriterion("mobilePhone is null");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIsNotNull() {
            addCriterion("mobilePhone is not null");
            return (Criteria) this;
        }

        public Criteria andMobilephoneEqualTo(String value) {
            addCriterion("mobilePhone =", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotEqualTo(String value) {
            addCriterion("mobilePhone <>", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneGreaterThan(String value) {
            addCriterion("mobilePhone >", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneGreaterThanOrEqualTo(String value) {
            addCriterion("mobilePhone >=", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLessThan(String value) {
            addCriterion("mobilePhone <", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLessThanOrEqualTo(String value) {
            addCriterion("mobilePhone <=", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLike(String value) {
            addCriterion("mobilePhone like", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotLike(String value) {
            addCriterion("mobilePhone not like", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIn(List<String> values) {
            addCriterion("mobilePhone in", values, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotIn(List<String> values) {
            addCriterion("mobilePhone not in", values, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneBetween(String value1, String value2) {
            addCriterion("mobilePhone between", value1, value2, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotBetween(String value1, String value2) {
            addCriterion("mobilePhone not between", value1, value2, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andShoptypeIsNull() {
            addCriterion("shopType is null");
            return (Criteria) this;
        }

        public Criteria andShoptypeIsNotNull() {
            addCriterion("shopType is not null");
            return (Criteria) this;
        }

        public Criteria andShoptypeEqualTo(String value) {
            addCriterion("shopType =", value, "shoptype");
            return (Criteria) this;
        }

        public Criteria andShoptypeNotEqualTo(String value) {
            addCriterion("shopType <>", value, "shoptype");
            return (Criteria) this;
        }

        public Criteria andShoptypeGreaterThan(String value) {
            addCriterion("shopType >", value, "shoptype");
            return (Criteria) this;
        }

        public Criteria andShoptypeGreaterThanOrEqualTo(String value) {
            addCriterion("shopType >=", value, "shoptype");
            return (Criteria) this;
        }

        public Criteria andShoptypeLessThan(String value) {
            addCriterion("shopType <", value, "shoptype");
            return (Criteria) this;
        }

        public Criteria andShoptypeLessThanOrEqualTo(String value) {
            addCriterion("shopType <=", value, "shoptype");
            return (Criteria) this;
        }

        public Criteria andShoptypeLike(String value) {
            addCriterion("shopType like", value, "shoptype");
            return (Criteria) this;
        }

        public Criteria andShoptypeNotLike(String value) {
            addCriterion("shopType not like", value, "shoptype");
            return (Criteria) this;
        }

        public Criteria andShoptypeIn(List<String> values) {
            addCriterion("shopType in", values, "shoptype");
            return (Criteria) this;
        }

        public Criteria andShoptypeNotIn(List<String> values) {
            addCriterion("shopType not in", values, "shoptype");
            return (Criteria) this;
        }

        public Criteria andShoptypeBetween(String value1, String value2) {
            addCriterion("shopType between", value1, value2, "shoptype");
            return (Criteria) this;
        }

        public Criteria andShoptypeNotBetween(String value1, String value2) {
            addCriterion("shopType not between", value1, value2, "shoptype");
            return (Criteria) this;
        }

        public Criteria andComperpersonIsNull() {
            addCriterion("comPerPerson is null");
            return (Criteria) this;
        }

        public Criteria andComperpersonIsNotNull() {
            addCriterion("comPerPerson is not null");
            return (Criteria) this;
        }

        public Criteria andComperpersonEqualTo(String value) {
            addCriterion("comPerPerson =", value, "comperperson");
            return (Criteria) this;
        }

        public Criteria andComperpersonNotEqualTo(String value) {
            addCriterion("comPerPerson <>", value, "comperperson");
            return (Criteria) this;
        }

        public Criteria andComperpersonGreaterThan(String value) {
            addCriterion("comPerPerson >", value, "comperperson");
            return (Criteria) this;
        }

        public Criteria andComperpersonGreaterThanOrEqualTo(String value) {
            addCriterion("comPerPerson >=", value, "comperperson");
            return (Criteria) this;
        }

        public Criteria andComperpersonLessThan(String value) {
            addCriterion("comPerPerson <", value, "comperperson");
            return (Criteria) this;
        }

        public Criteria andComperpersonLessThanOrEqualTo(String value) {
            addCriterion("comPerPerson <=", value, "comperperson");
            return (Criteria) this;
        }

        public Criteria andComperpersonLike(String value) {
            addCriterion("comPerPerson like", value, "comperperson");
            return (Criteria) this;
        }

        public Criteria andComperpersonNotLike(String value) {
            addCriterion("comPerPerson not like", value, "comperperson");
            return (Criteria) this;
        }

        public Criteria andComperpersonIn(List<String> values) {
            addCriterion("comPerPerson in", values, "comperperson");
            return (Criteria) this;
        }

        public Criteria andComperpersonNotIn(List<String> values) {
            addCriterion("comPerPerson not in", values, "comperperson");
            return (Criteria) this;
        }

        public Criteria andComperpersonBetween(String value1, String value2) {
            addCriterion("comPerPerson between", value1, value2, "comperperson");
            return (Criteria) this;
        }

        public Criteria andComperpersonNotBetween(String value1, String value2) {
            addCriterion("comPerPerson not between", value1, value2, "comperperson");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andWorktimeIsNull() {
            addCriterion("workTime is null");
            return (Criteria) this;
        }

        public Criteria andWorktimeIsNotNull() {
            addCriterion("workTime is not null");
            return (Criteria) this;
        }

        public Criteria andWorktimeEqualTo(String value) {
            addCriterion("workTime =", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotEqualTo(String value) {
            addCriterion("workTime <>", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeGreaterThan(String value) {
            addCriterion("workTime >", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeGreaterThanOrEqualTo(String value) {
            addCriterion("workTime >=", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeLessThan(String value) {
            addCriterion("workTime <", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeLessThanOrEqualTo(String value) {
            addCriterion("workTime <=", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeLike(String value) {
            addCriterion("workTime like", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotLike(String value) {
            addCriterion("workTime not like", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeIn(List<String> values) {
            addCriterion("workTime in", values, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotIn(List<String> values) {
            addCriterion("workTime not in", values, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeBetween(String value1, String value2) {
            addCriterion("workTime between", value1, value2, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotBetween(String value1, String value2) {
            addCriterion("workTime not between", value1, value2, "worktime");
            return (Criteria) this;
        }

        public Criteria andFetchtimeIsNull() {
            addCriterion("fetchtime is null");
            return (Criteria) this;
        }

        public Criteria andFetchtimeIsNotNull() {
            addCriterion("fetchtime is not null");
            return (Criteria) this;
        }

        public Criteria andFetchtimeEqualTo(Date value) {
            addCriterion("fetchtime =", value, "fetchtime");
            return (Criteria) this;
        }

        public Criteria andFetchtimeNotEqualTo(Date value) {
            addCriterion("fetchtime <>", value, "fetchtime");
            return (Criteria) this;
        }

        public Criteria andFetchtimeGreaterThan(Date value) {
            addCriterion("fetchtime >", value, "fetchtime");
            return (Criteria) this;
        }

        public Criteria andFetchtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fetchtime >=", value, "fetchtime");
            return (Criteria) this;
        }

        public Criteria andFetchtimeLessThan(Date value) {
            addCriterion("fetchtime <", value, "fetchtime");
            return (Criteria) this;
        }

        public Criteria andFetchtimeLessThanOrEqualTo(Date value) {
            addCriterion("fetchtime <=", value, "fetchtime");
            return (Criteria) this;
        }

        public Criteria andFetchtimeIn(List<Date> values) {
            addCriterion("fetchtime in", values, "fetchtime");
            return (Criteria) this;
        }

        public Criteria andFetchtimeNotIn(List<Date> values) {
            addCriterion("fetchtime not in", values, "fetchtime");
            return (Criteria) this;
        }

        public Criteria andFetchtimeBetween(Date value1, Date value2) {
            addCriterion("fetchtime between", value1, value2, "fetchtime");
            return (Criteria) this;
        }

        public Criteria andFetchtimeNotBetween(Date value1, Date value2) {
            addCriterion("fetchtime not between", value1, value2, "fetchtime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dazhongdianping
     *
     * @mbggenerated do_not_delete_during_merge Mon Oct 19 15:21:59 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dazhongdianping
     *
     * @mbggenerated Mon Oct 19 15:21:59 CST 2015
     */
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