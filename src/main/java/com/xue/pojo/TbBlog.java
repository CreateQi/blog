package com.xue.pojo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TbBlog {
    private Integer id;

    private String title;

    private Integer visits;

    private Integer status;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createtime;

    private String context;

   private List<TbReviews> reviews;
    
    private Integer commentNums;
    
    private String imgurl;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

	public List<TbReviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<TbReviews> reviews) {
		this.reviews = reviews;
	}

	public Integer getCommentNums() {
		return commentNums;
	}

	public void setCommentNums(Integer commentNums) {
		this.commentNums = commentNums;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Override
	public String toString() {
		return "TbBlog [id=" + id + ", title=" + title + ", visits=" + visits + ", status=" + status + ", createtime="
				+ createtime + ", context=" + context + ", reviews=" + reviews + ", commentNums=" + commentNums
				+ ", imgurl=" + imgurl + "]";
	}
    
}