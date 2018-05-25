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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer status;
	private Integer sort;
	private String username;
	private String password;
	private String phone;
	private String name;
	private String updateTime;
	private String insertTime;
	private String insertTimeMs;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}

	public String getInsertTimeMs() {
		return insertTimeMs;
	}

	public void setInsertTimeMs(String insertTimeMs) {
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
		return "User{" +
			"id=" + id +
			", status=" + status +
			", sort=" + sort +
			", username=" + username +
			", password=" + password +
			", phone=" + phone +
			", name=" + name +
			", updateTime=" + updateTime +
			", insertTime=" + insertTime +
			", insertTimeMs=" + insertTimeMs +
			", siteId=" + siteId +
			"}";
	}
}
