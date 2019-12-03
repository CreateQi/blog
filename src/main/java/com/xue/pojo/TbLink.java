package com.xue.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TbLink {
	private Integer id;

	private String linkTitle;

	private String link;

	private String linkPwd;

	private Integer status;

	@JsonFormat(pattern="yyyy年MM月dd日")
	private Date createtime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLinkTitle() {
		return linkTitle;
	}

	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle == null ? null : linkTitle.trim();
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link == null ? null : link.trim();
	}

	public String getLinkPwd() {
		return linkPwd;
	}

	public void setLinkPwd(String linkPwd) {
		this.linkPwd = linkPwd == null ? null : linkPwd.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "TbLink [id=" + id + ", linkTitle=" + linkTitle + ", link=" + link + ", linkPwd=" + linkPwd + ", status="
				+ status + ", createtime=" + createtime + "]";
	}
	
}