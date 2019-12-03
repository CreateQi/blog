package com.xue.pojo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TbMessage {
    private Integer id;

    private String aurthor;

    private String comments;

    private Integer status;

    private Integer aId;

    private List<TbMessage> tbMessages;
    
    private int imagesid;
    
    @JsonFormat(pattern="yyyy年MM月dd日",timezone="GMT+8")
    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAurthor() {
        return aurthor;
    }

    public void setAurthor(String aurthor) {
        this.aurthor = aurthor == null ? null : aurthor.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    

	public List<TbMessage> getTbMessages() {
		return tbMessages;
	}

	public void setTbMessages(List<TbMessage> tbMessages) {
		this.tbMessages = tbMessages;
	}

	public int getImagesId() {
		return imagesid;
	}

	public void setImagesId(int imagesid) {
		this.imagesid = imagesid;
	}

	@Override
	public String toString() {
		return "TbMessage [id=" + id + ", aurthor=" + aurthor + ", comments=" + comments + ", status=" + status
				+ ", aId=" + aId + ", tbMessages=" + tbMessages + ", imagesId=" + imagesid + ", createtime="
				+ createtime + "]";
	}
    
}