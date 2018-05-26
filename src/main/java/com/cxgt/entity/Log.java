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
 * @since 2018-05-26
 */
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 类名
     */
	private String className;
    /**
     * 方法名
     */
	private String methodName;
    /**
     * 参数
     */
	private String param;
    /**
     * 返回值
     */
	private String result;
    /**
     * 开始时间
     */
	private Date beginTime;
    /**
     * 结束时间
     */
	private Date endTime;
    /**
     * 执行时长
     */
	private Integer excuteTime;
    /**
     * 是否为管理员
     */
	private Integer isAdmin;
    /**
     * 异常名
     */
	private String exception;
    /**
     * 异常内容
     */
	private String exceptionContent;
    /**
     * 创建时间
     */
	private Date insertTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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

	public Integer getExcuteTime() {
		return excuteTime;
	}

	public void setExcuteTime(Integer excuteTime) {
		this.excuteTime = excuteTime;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getExceptionContent() {
		return exceptionContent;
	}

	public void setExceptionContent(String exceptionContent) {
		this.exceptionContent = exceptionContent;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	@Override
	public String toString() {
		return "Log{" +
			"id=" + id +
			", className=" + className +
			", methodName=" + methodName +
			", param=" + param +
			", result=" + result +
			", beginTime=" + beginTime +
			", endTime=" + endTime +
			", excuteTime=" + excuteTime +
			", isAdmin=" + isAdmin +
			", exception=" + exception +
			", exceptionContent=" + exceptionContent +
			", insertTime=" + insertTime +
			"}";
	}
}
