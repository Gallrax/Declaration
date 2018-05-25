package com.cxgt.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
public class SeriesUid implements Serializable {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 系列id
     */
	private Integer seriesId;
    /**
     * uid
     */
	private Integer uid;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "SeriesUid{" +
			"id=" + id +
			", seriesId=" + seriesId +
			", uid=" + uid +
			"}";
	}
}
