package com.cxgt.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
public class Resource implements Serializable {

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
     * 简介
     */
	private String intro;
    /**
     * objectid
     */
	private String objectid;
    /**
     * 文件路径
     */
	private String fileRoute;
    /**
     * 时长
     */
	private Integer duration;
    /**
     * 文件大小Byte
     */
	private Long fileSize;
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
     * 系列id
     */
	private Integer seriesId;
    /**
     * 站点id
     */
	private Integer siteId;
    /**
     * 点击量
     */
	private Integer clickCount;


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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getObjectid() {
		return objectid;
	}

	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}

	public String getFileRoute() {
		return fileRoute;
	}

	public void setFileRoute(String fileRoute) {
		this.fileRoute = fileRoute;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
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

	public Integer getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Integer getClickCount() {
		return clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	@Override
	public String toString() {
		return "Resource{" +
			"id=" + id +
			", status=" + status +
			", sort=" + sort +
			", logo=" + logo +
			", name=" + name +
			", intro=" + intro +
			", objectid=" + objectid +
			", fileRoute=" + fileRoute +
			", duration=" + duration +
			", fileSize=" + fileSize +
			", updateTime=" + updateTime +
			", insertTime=" + insertTime +
			", insertTimeMs=" + insertTimeMs +
			", seriesId=" + seriesId +
			", siteId=" + siteId +
			", clickCount=" + clickCount +
			"}";
	}
}
