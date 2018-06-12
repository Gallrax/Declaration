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
 * @since 2018-06-12
 */
public class Prize implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 排序
     */
	private Integer sort;
    /**
     * 状态
     */
	private Integer status;
    /**
     * logo
     */
	private String logo;
    /**
     * 名称
     */
	private String name;
    /**
     * 类型
     */
	private String type;
    /**
     * 简介
     */
	private String intro;
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
	private Date insertTimeMs;
    /**
     * siteId
     */
	private Integer siteId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
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

	public Date getInsertTimeMs() {
		return insertTimeMs;
	}

	public void setInsertTimeMs(Date insertTimeMs) {
		this.insertTimeMs = insertTimeMs;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Override
	public String toString() {
		return "Prize{" +
			"id=" + id +
			", sort=" + sort +
			", status=" + status +
			", logo=" + logo +
			", name=" + name +
			", type=" + type +
			", intro=" + intro +
			", updateTime=" + updateTime +
			", insertTime=" + insertTime +
			", insertTimeMs=" + insertTimeMs +
			", siteId=" + siteId +
			"}";
	}
}
