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
public class Series implements Serializable {

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
     * 联系方式
     */
	private String phone;
    /**
     * 单位
     */
	private String company;
    /**
     * 作者
     */
	private String author;
    /**
     * 作者简介
     */
	private String authorIntro;
    /**
     * 封面图
     */
	private String coverImg;
    /**
     * 文件类型
     */
	private String fileType;
    /**
     * 附件
     */
	private String enclosure;
    /**
     * 点赞数
     */
	private Integer likeCount;
    /**
     * 点击量
     */
	private Integer clickCount;
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
     * 上传人id
     */
	private Integer uid;
    /**
     * 活动id
     */
	private Integer activityId;
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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorIntro() {
		return authorIntro;
	}

	public void setAuthorIntro(String authorIntro) {
		this.authorIntro = authorIntro;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getClickCount() {
		return clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
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

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Override
	public String toString() {
		return "Series{" +
			"id=" + id +
			", status=" + status +
			", sort=" + sort +
			", logo=" + logo +
			", name=" + name +
			", intro=" + intro +
			", phone=" + phone +
			", company=" + company +
			", author=" + author +
			", authorIntro=" + authorIntro +
			", coverImg=" + coverImg +
			", fileType=" + fileType +
			", enclosure=" + enclosure +
			", likeCount=" + likeCount +
			", clickCount=" + clickCount +
			", updateTime=" + updateTime +
			", insertTime=" + insertTime +
			", insertTimeMs=" + insertTimeMs +
			", uid=" + uid +
			", activityId=" + activityId +
			", siteId=" + siteId +
			"}";
	}
}
