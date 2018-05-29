package com.cxgt.entity;

import com.baomidou.mybatisplus.annotations.TableId;
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
public class SeriesUser implements Serializable {

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
	 * 奖项名
	 */
	private String name;
	/**
	 * 奖项类型
	 */
	private Integer type;
	/**
	 * 系列id
	 */
	private Integer seriesId;
	/**
	 * 用户id
	 */
	private Integer userId;


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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SeriesUser{" +
				"id=" + id +
				", status=" + status +
				", sort=" + sort +
				", name=" + name +
				", type=" + type +
				", seriesId=" + seriesId +
				", userId=" + userId +
				"}";
	}
}
