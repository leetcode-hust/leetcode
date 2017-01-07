package com.ziling.www.po;

import java.util.Date;

public class Advertisement {
    private String adId;

    private String relatedProjectId;

    private String relatedProjectName;

    private Integer adNumber;

    private String imgUrl;

    private Date createdTime;

    private Integer vaildTime;

    private Date expireTime;

    private Integer isAd;

    private Integer adStatus;

    private String remark;

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId == null ? null : adId.trim();
    }

    public String getRelatedProjectId() {
        return relatedProjectId;
    }

    public void setRelatedProjectId(String relatedProjectId) {
        this.relatedProjectId = relatedProjectId == null ? null : relatedProjectId.trim();
    }

    public String getRelatedProjectName() {
        return relatedProjectName;
    }

    public void setRelatedProjectName(String relatedProjectName) {
        this.relatedProjectName = relatedProjectName == null ? null : relatedProjectName.trim();
    }

    public Integer getAdNumber() {
        return adNumber;
    }

    public void setAdNumber(Integer adNumber) {
        this.adNumber = adNumber;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getVaildTime() {
        return vaildTime;
    }

    public void setVaildTime(Integer vaildTime) {
        this.vaildTime = vaildTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getIsAd() {
        return isAd;
    }

    public void setIsAd(Integer isAd) {
        this.isAd = isAd;
    }

    public Integer getAdStatus() {
        return adStatus;
    }

    public void setAdStatus(Integer adStatus) {
        this.adStatus = adStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}