package com.bingbinlee.blade.common.pojo;

/**
 * easyUI树形控件节点格式
 * @author	libingbin2015@aliyun.com
 * @date	2016年9月15日下午11:43:51
 * @version 1.0
 */
public class EUTreeNode {

	private long id;
	private String text;
	private String state;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
