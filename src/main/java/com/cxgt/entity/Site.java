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
public class Site implements Serializable {

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
     * 名称
     */
	private String name;
    /**
     * 域名
     */
	private String domain;
    /**
     * 模板
     */
	private String template;
    /**
     * 主题
     */
	private String theme;
    /**
     * 核心json
     */
	private String coreJson;
    /**
     * fid
     */
	private Integer fid;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getCoreJson() {
		return coreJson;
	}

	public void setCoreJson(String coreJson) {
		this.coreJson = coreJson;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
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

	@Override
	public String toString() {
		return "Site{" +
			"id=" + id +
			", status=" + status +
			", sort=" + sort +
			", name=" + name +
			", domain=" + domain +
			", template=" + template +
			", theme=" + theme +
			", coreJson=" + coreJson +
			", fid=" + fid +
			", updateTime=" + updateTime +
			", insertTime=" + insertTime +
			", insertTimeMs=" + insertTimeMs +
			"}";
	}
}
