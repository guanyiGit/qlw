package com.soholy.dogmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSlidesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSlidesExample() {
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

        public Criteria andSlidesIdIsNull() {
            addCriterion("slides_id is null");
            return (Criteria) this;
        }

        public Criteria andSlidesIdIsNotNull() {
            addCriterion("slides_id is not null");
            return (Criteria) this;
        }

        public Criteria andSlidesIdEqualTo(Integer value) {
            addCriterion("slides_id =", value, "slidesId");
            return (Criteria) this;
        }

        public Criteria andSlidesIdNotEqualTo(Integer value) {
            addCriterion("slides_id <>", value, "slidesId");
            return (Criteria) this;
        }

        public Criteria andSlidesIdGreaterThan(Integer value) {
            addCriterion("slides_id >", value, "slidesId");
            return (Criteria) this;
        }

        public Criteria andSlidesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("slides_id >=", value, "slidesId");
            return (Criteria) this;
        }

        public Criteria andSlidesIdLessThan(Integer value) {
            addCriterion("slides_id <", value, "slidesId");
            return (Criteria) this;
        }

        public Criteria andSlidesIdLessThanOrEqualTo(Integer value) {
            addCriterion("slides_id <=", value, "slidesId");
            return (Criteria) this;
        }

        public Criteria andSlidesIdIn(List<Integer> values) {
            addCriterion("slides_id in", values, "slidesId");
            return (Criteria) this;
        }

        public Criteria andSlidesIdNotIn(List<Integer> values) {
            addCriterion("slides_id not in", values, "slidesId");
            return (Criteria) this;
        }

        public Criteria andSlidesIdBetween(Integer value1, Integer value2) {
            addCriterion("slides_id between", value1, value2, "slidesId");
            return (Criteria) this;
        }

        public Criteria andSlidesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("slides_id not between", value1, value2, "slidesId");
            return (Criteria) this;
        }

        public Criteria andSlidesTypeIsNull() {
            addCriterion("slides_type is null");
            return (Criteria) this;
        }

        public Criteria andSlidesTypeIsNotNull() {
            addCriterion("slides_type is not null");
            return (Criteria) this;
        }

        public Criteria andSlidesTypeEqualTo(Integer value) {
            addCriterion("slides_type =", value, "slidesType");
            return (Criteria) this;
        }

        public Criteria andSlidesTypeNotEqualTo(Integer value) {
            addCriterion("slides_type <>", value, "slidesType");
            return (Criteria) this;
        }

        public Criteria andSlidesTypeGreaterThan(Integer value) {
            addCriterion("slides_type >", value, "slidesType");
            return (Criteria) this;
        }

        public Criteria andSlidesTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("slides_type >=", value, "slidesType");
            return (Criteria) this;
        }

        public Criteria andSlidesTypeLessThan(Integer value) {
            addCriterion("slides_type <", value, "slidesType");
            return (Criteria) this;
        }

        public Criteria andSlidesTypeLessThanOrEqualTo(Integer value) {
            addCriterion("slides_type <=", value, "slidesType");
            return (Criteria) this;
        }

        public Criteria andSlidesTypeIn(List<Integer> values) {
            addCriterion("slides_type in", values, "slidesType");
            return (Criteria) this;
        }

        public Criteria andSlidesTypeNotIn(List<Integer> values) {
            addCriterion("slides_type not in", values, "slidesType");
            return (Criteria) this;
        }

        public Criteria andSlidesTypeBetween(Integer value1, Integer value2) {
            addCriterion("slides_type between", value1, value2, "slidesType");
            return (Criteria) this;
        }

        public Criteria andSlidesTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("slides_type not between", value1, value2, "slidesType");
            return (Criteria) this;
        }

        public Criteria andSlidesNameIsNull() {
            addCriterion("slides_name is null");
            return (Criteria) this;
        }

        public Criteria andSlidesNameIsNotNull() {
            addCriterion("slides_name is not null");
            return (Criteria) this;
        }

        public Criteria andSlidesNameEqualTo(String value) {
            addCriterion("slides_name =", value, "slidesName");
            return (Criteria) this;
        }

        public Criteria andSlidesNameNotEqualTo(String value) {
            addCriterion("slides_name <>", value, "slidesName");
            return (Criteria) this;
        }

        public Criteria andSlidesNameGreaterThan(String value) {
            addCriterion("slides_name >", value, "slidesName");
            return (Criteria) this;
        }

        public Criteria andSlidesNameGreaterThanOrEqualTo(String value) {
            addCriterion("slides_name >=", value, "slidesName");
            return (Criteria) this;
        }

        public Criteria andSlidesNameLessThan(String value) {
            addCriterion("slides_name <", value, "slidesName");
            return (Criteria) this;
        }

        public Criteria andSlidesNameLessThanOrEqualTo(String value) {
            addCriterion("slides_name <=", value, "slidesName");
            return (Criteria) this;
        }

        public Criteria andSlidesNameLike(String value) {
            addCriterion("slides_name like", value, "slidesName");
            return (Criteria) this;
        }

        public Criteria andSlidesNameNotLike(String value) {
            addCriterion("slides_name not like", value, "slidesName");
            return (Criteria) this;
        }

        public Criteria andSlidesNameIn(List<String> values) {
            addCriterion("slides_name in", values, "slidesName");
            return (Criteria) this;
        }

        public Criteria andSlidesNameNotIn(List<String> values) {
            addCriterion("slides_name not in", values, "slidesName");
            return (Criteria) this;
        }

        public Criteria andSlidesNameBetween(String value1, String value2) {
            addCriterion("slides_name between", value1, value2, "slidesName");
            return (Criteria) this;
        }

        public Criteria andSlidesNameNotBetween(String value1, String value2) {
            addCriterion("slides_name not between", value1, value2, "slidesName");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileIsNull() {
            addCriterion("slides_titile is null");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileIsNotNull() {
            addCriterion("slides_titile is not null");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileEqualTo(String value) {
            addCriterion("slides_titile =", value, "slidesTitile");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileNotEqualTo(String value) {
            addCriterion("slides_titile <>", value, "slidesTitile");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileGreaterThan(String value) {
            addCriterion("slides_titile >", value, "slidesTitile");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileGreaterThanOrEqualTo(String value) {
            addCriterion("slides_titile >=", value, "slidesTitile");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileLessThan(String value) {
            addCriterion("slides_titile <", value, "slidesTitile");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileLessThanOrEqualTo(String value) {
            addCriterion("slides_titile <=", value, "slidesTitile");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileLike(String value) {
            addCriterion("slides_titile like", value, "slidesTitile");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileNotLike(String value) {
            addCriterion("slides_titile not like", value, "slidesTitile");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileIn(List<String> values) {
            addCriterion("slides_titile in", values, "slidesTitile");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileNotIn(List<String> values) {
            addCriterion("slides_titile not in", values, "slidesTitile");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileBetween(String value1, String value2) {
            addCriterion("slides_titile between", value1, value2, "slidesTitile");
            return (Criteria) this;
        }

        public Criteria andSlidesTitileNotBetween(String value1, String value2) {
            addCriterion("slides_titile not between", value1, value2, "slidesTitile");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlIsNull() {
            addCriterion("slides_url is null");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlIsNotNull() {
            addCriterion("slides_url is not null");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlEqualTo(String value) {
            addCriterion("slides_url =", value, "slidesUrl");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlNotEqualTo(String value) {
            addCriterion("slides_url <>", value, "slidesUrl");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlGreaterThan(String value) {
            addCriterion("slides_url >", value, "slidesUrl");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlGreaterThanOrEqualTo(String value) {
            addCriterion("slides_url >=", value, "slidesUrl");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlLessThan(String value) {
            addCriterion("slides_url <", value, "slidesUrl");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlLessThanOrEqualTo(String value) {
            addCriterion("slides_url <=", value, "slidesUrl");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlLike(String value) {
            addCriterion("slides_url like", value, "slidesUrl");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlNotLike(String value) {
            addCriterion("slides_url not like", value, "slidesUrl");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlIn(List<String> values) {
            addCriterion("slides_url in", values, "slidesUrl");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlNotIn(List<String> values) {
            addCriterion("slides_url not in", values, "slidesUrl");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlBetween(String value1, String value2) {
            addCriterion("slides_url between", value1, value2, "slidesUrl");
            return (Criteria) this;
        }

        public Criteria andSlidesUrlNotBetween(String value1, String value2) {
            addCriterion("slides_url not between", value1, value2, "slidesUrl");
            return (Criteria) this;
        }

        public Criteria andSlidesSizeIsNull() {
            addCriterion("slides_size is null");
            return (Criteria) this;
        }

        public Criteria andSlidesSizeIsNotNull() {
            addCriterion("slides_size is not null");
            return (Criteria) this;
        }

        public Criteria andSlidesSizeEqualTo(Double value) {
            addCriterion("slides_size =", value, "slidesSize");
            return (Criteria) this;
        }

        public Criteria andSlidesSizeNotEqualTo(Double value) {
            addCriterion("slides_size <>", value, "slidesSize");
            return (Criteria) this;
        }

        public Criteria andSlidesSizeGreaterThan(Double value) {
            addCriterion("slides_size >", value, "slidesSize");
            return (Criteria) this;
        }

        public Criteria andSlidesSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("slides_size >=", value, "slidesSize");
            return (Criteria) this;
        }

        public Criteria andSlidesSizeLessThan(Double value) {
            addCriterion("slides_size <", value, "slidesSize");
            return (Criteria) this;
        }

        public Criteria andSlidesSizeLessThanOrEqualTo(Double value) {
            addCriterion("slides_size <=", value, "slidesSize");
            return (Criteria) this;
        }

        public Criteria andSlidesSizeIn(List<Double> values) {
            addCriterion("slides_size in", values, "slidesSize");
            return (Criteria) this;
        }

        public Criteria andSlidesSizeNotIn(List<Double> values) {
            addCriterion("slides_size not in", values, "slidesSize");
            return (Criteria) this;
        }

        public Criteria andSlidesSizeBetween(Double value1, Double value2) {
            addCriterion("slides_size between", value1, value2, "slidesSize");
            return (Criteria) this;
        }

        public Criteria andSlidesSizeNotBetween(Double value1, Double value2) {
            addCriterion("slides_size not between", value1, value2, "slidesSize");
            return (Criteria) this;
        }

        public Criteria andSlidesExtIsNull() {
            addCriterion("slides_ext is null");
            return (Criteria) this;
        }

        public Criteria andSlidesExtIsNotNull() {
            addCriterion("slides_ext is not null");
            return (Criteria) this;
        }

        public Criteria andSlidesExtEqualTo(String value) {
            addCriterion("slides_ext =", value, "slidesExt");
            return (Criteria) this;
        }

        public Criteria andSlidesExtNotEqualTo(String value) {
            addCriterion("slides_ext <>", value, "slidesExt");
            return (Criteria) this;
        }

        public Criteria andSlidesExtGreaterThan(String value) {
            addCriterion("slides_ext >", value, "slidesExt");
            return (Criteria) this;
        }

        public Criteria andSlidesExtGreaterThanOrEqualTo(String value) {
            addCriterion("slides_ext >=", value, "slidesExt");
            return (Criteria) this;
        }

        public Criteria andSlidesExtLessThan(String value) {
            addCriterion("slides_ext <", value, "slidesExt");
            return (Criteria) this;
        }

        public Criteria andSlidesExtLessThanOrEqualTo(String value) {
            addCriterion("slides_ext <=", value, "slidesExt");
            return (Criteria) this;
        }

        public Criteria andSlidesExtLike(String value) {
            addCriterion("slides_ext like", value, "slidesExt");
            return (Criteria) this;
        }

        public Criteria andSlidesExtNotLike(String value) {
            addCriterion("slides_ext not like", value, "slidesExt");
            return (Criteria) this;
        }

        public Criteria andSlidesExtIn(List<String> values) {
            addCriterion("slides_ext in", values, "slidesExt");
            return (Criteria) this;
        }

        public Criteria andSlidesExtNotIn(List<String> values) {
            addCriterion("slides_ext not in", values, "slidesExt");
            return (Criteria) this;
        }

        public Criteria andSlidesExtBetween(String value1, String value2) {
            addCriterion("slides_ext between", value1, value2, "slidesExt");
            return (Criteria) this;
        }

        public Criteria andSlidesExtNotBetween(String value1, String value2) {
            addCriterion("slides_ext not between", value1, value2, "slidesExt");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlIsNull() {
            addCriterion("thumbnail_url is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlIsNotNull() {
            addCriterion("thumbnail_url is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlEqualTo(String value) {
            addCriterion("thumbnail_url =", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlNotEqualTo(String value) {
            addCriterion("thumbnail_url <>", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlGreaterThan(String value) {
            addCriterion("thumbnail_url >", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlGreaterThanOrEqualTo(String value) {
            addCriterion("thumbnail_url >=", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlLessThan(String value) {
            addCriterion("thumbnail_url <", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlLessThanOrEqualTo(String value) {
            addCriterion("thumbnail_url <=", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlLike(String value) {
            addCriterion("thumbnail_url like", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlNotLike(String value) {
            addCriterion("thumbnail_url not like", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlIn(List<String> values) {
            addCriterion("thumbnail_url in", values, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlNotIn(List<String> values) {
            addCriterion("thumbnail_url not in", values, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlBetween(String value1, String value2) {
            addCriterion("thumbnail_url between", value1, value2, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlNotBetween(String value1, String value2) {
            addCriterion("thumbnail_url not between", value1, value2, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailSizeIsNull() {
            addCriterion("thumbnail_size is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailSizeIsNotNull() {
            addCriterion("thumbnail_size is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailSizeEqualTo(Double value) {
            addCriterion("thumbnail_size =", value, "thumbnailSize");
            return (Criteria) this;
        }

        public Criteria andThumbnailSizeNotEqualTo(Double value) {
            addCriterion("thumbnail_size <>", value, "thumbnailSize");
            return (Criteria) this;
        }

        public Criteria andThumbnailSizeGreaterThan(Double value) {
            addCriterion("thumbnail_size >", value, "thumbnailSize");
            return (Criteria) this;
        }

        public Criteria andThumbnailSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("thumbnail_size >=", value, "thumbnailSize");
            return (Criteria) this;
        }

        public Criteria andThumbnailSizeLessThan(Double value) {
            addCriterion("thumbnail_size <", value, "thumbnailSize");
            return (Criteria) this;
        }

        public Criteria andThumbnailSizeLessThanOrEqualTo(Double value) {
            addCriterion("thumbnail_size <=", value, "thumbnailSize");
            return (Criteria) this;
        }

        public Criteria andThumbnailSizeIn(List<Double> values) {
            addCriterion("thumbnail_size in", values, "thumbnailSize");
            return (Criteria) this;
        }

        public Criteria andThumbnailSizeNotIn(List<Double> values) {
            addCriterion("thumbnail_size not in", values, "thumbnailSize");
            return (Criteria) this;
        }

        public Criteria andThumbnailSizeBetween(Double value1, Double value2) {
            addCriterion("thumbnail_size between", value1, value2, "thumbnailSize");
            return (Criteria) this;
        }

        public Criteria andThumbnailSizeNotBetween(Double value1, Double value2) {
            addCriterion("thumbnail_size not between", value1, value2, "thumbnailSize");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNull() {
            addCriterion("upload_date is null");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNotNull() {
            addCriterion("upload_date is not null");
            return (Criteria) this;
        }

        public Criteria andUploadDateEqualTo(Date value) {
            addCriterion("upload_date =", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotEqualTo(Date value) {
            addCriterion("upload_date <>", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThan(Date value) {
            addCriterion("upload_date >", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThanOrEqualTo(Date value) {
            addCriterion("upload_date >=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThan(Date value) {
            addCriterion("upload_date <", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThanOrEqualTo(Date value) {
            addCriterion("upload_date <=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateIn(List<Date> values) {
            addCriterion("upload_date in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotIn(List<Date> values) {
            addCriterion("upload_date not in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateBetween(Date value1, Date value2) {
            addCriterion("upload_date between", value1, value2, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotBetween(Date value1, Date value2) {
            addCriterion("upload_date not between", value1, value2, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andSeqIsNull() {
            addCriterion("seq is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("seq is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(Integer value) {
            addCriterion("seq =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(Integer value) {
            addCriterion("seq <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(Integer value) {
            addCriterion("seq >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("seq >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(Integer value) {
            addCriterion("seq <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(Integer value) {
            addCriterion("seq <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<Integer> values) {
            addCriterion("seq in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<Integer> values) {
            addCriterion("seq not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(Integer value1, Integer value2) {
            addCriterion("seq between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("seq not between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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