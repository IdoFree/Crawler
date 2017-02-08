package com.rainful.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PageInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2085401409878261142L;
	private String oriUrl;//the original url
	private String url;//
	private Date downloadDate;
	private String description;
	private String abtractText;
	private String content;
	private int statusCode;
	private String charSet;
	private List<String> urlReferrence;
	private String contentType;
	private int layer;
	public String getOriUrl() {
		return oriUrl;
	}
	public void setOriUrl(String oriUrl) {
		this.oriUrl = oriUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getDownloadDate() {
		return downloadDate;
	}
	public void setDownloadDate(Date downloadDate) {
		this.downloadDate = downloadDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAbtractText() {
		return abtractText;
	}
	public void setAbtractText(String abtractText) {
		this.abtractText = abtractText;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getCharSet() {
		return charSet;
	}
	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public List<String> getUrlReferrence() {
		return urlReferrence;
	}
	public void setUrlReferrence(List<String> urlReferrence) {
		this.urlReferrence = urlReferrence;
	}
	
	
	
	
}
