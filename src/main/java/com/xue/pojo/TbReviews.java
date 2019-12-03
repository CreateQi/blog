package com.xue.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TbReviews {
    private Integer id;

    private String annoyname;

    private String context;
    
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createtime;

    private Integer bId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnnoyname() {
        return annoyname;
    }

    public void setAnnoyname(String annoyname) {
        this.annoyname = annoyname == null ? null : annoyname.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

	@Override
	public String toString() {
		return "TbReviews [id=" + id + ", annoyname=" + annoyname + ", context=" + context + ", createtime="
				+ createtime + ", bId=" + bId + "]";
	}
    
}