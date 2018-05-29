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
 * @since 2018-05-29
 */
public class ActivityUid implements Serializable {

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
     * uid
     */
	private Integer uid;
    /**
     * 活动id
     */
	private Integer activityId;
    /**
     * 创建时间
     */
	private Date insertTime;
    /**
     * 创建时ms值
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

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
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
		return "ActivityUid{" +
			"id=" + id +
			", status=" + status +
			", sort=" + sort +
			", uid=" + uid +
			", activityId=" + activityId +
			", insertTime=" + insertTime +
			", insertTimeMs=" + insertTimeMs +
			"}";
	}
}
