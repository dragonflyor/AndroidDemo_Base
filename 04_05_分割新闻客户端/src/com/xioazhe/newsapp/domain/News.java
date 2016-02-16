package com.xioazhe.newsapp.domain;

public class News {
	
	/**
	 * <title>黑马52期就业快报</title>
	 * <detail>热烈祝贺黑马52期平均薪水突破13k</detail>
	 * <comment>15687</comment>
	 * <image>http://192.168.1.100:8080/images/6.jpg</image>
	 */
	
	String title;
	String detail;
	String comment;
	String image;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "News [title=" + title + ", detail=" + detail + ", comment="
				+ comment + ", image=" + image + "]";
	}
	
	
}
