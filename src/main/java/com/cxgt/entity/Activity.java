package com.cxgt.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 状态
     */
	private Integer status;
    /**
     * 排序
     */
	private Integer sort;
    /**
     * logo
     */
	private String logo;
    /**
     * 名称
     */
	private String name;
    /**
     * 内容
     */
	private String content;
    /**
     * 地点
     */
	private String place;
    /**
     * 发起者
     */
	private String hoster;
    /**
     * 总人数
     */
	private Integer peopleCount;
    /**
     * 是否免审核
     */
	private Integer isVerify;
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
	private Date beginTime;
    /**
     * 结束时间
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
	private Date endTime;
    /**
     * 点击量
     */
	private Integer clickCount;
    /**
     * 发布活动者id
     */
	private Integer userId;
    /**
     * 更新时间
     */
	private Date updateTime;
    /**
     * 创建时间
     */
	private Date insertTime;
    /**
     * 创建时间ms值
     */
	private Long insertTimeMs;
    /**
     * 分类id
     */
	private Integer categoryId;
    /**
     * 站点id
     */
	private Integer siteId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getHoster() {
		return hoster;
	}

	public void setHoster(String hoster) {
		this.hoster = hoster;
	}

	public Integer getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(Integer peopleCount) {
		this.peopleCount = peopleCount;
	}

	public Integer getIsVerify() {
		return isVerify;
	}

	public void setIsVerify(Integer isVerify) {
		this.isVerify = isVerify;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getClickCount() {
		return clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Long getInsertTimeMs() {
		return insertTimeMs;
	}

	public void setInsertTimeMs(Long insertTimeMs) {
		this.insertTimeMs = insertTimeMs;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Override
	public String toString() {
		return "Activity{" +
			"id=" + id +
			", status=" + status +
			", sort=" + sort +
			", logo=" + logo +
			", name=" + name +
			", content=" + content +
			", place=" + place +
			", hoster=" + hoster +
			", peopleCount=" + peopleCount +
			", isVerify=" + isVerify +
			", beginTime=" + beginTime +
			", endTime=" + endTime +
			", clickCount=" + clickCount +
			", userId=" + userId +
			", updateTime=" + updateTime +
			", insertTime=" + insertTime +
			", insertTimeMs=" + insertTimeMs +
			", categoryId=" + categoryId +
			", siteId=" + siteId +
			"}";
	}
}
