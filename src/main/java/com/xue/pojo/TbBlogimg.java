package com.xue.pojo;

public class TbBlogimg {
    private Integer id;

    private String imgurl;

    private Integer bId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

	@Override
	public String toString() {
		return "TbBlogimg [id=" + id + ", imgurl=" + imgurl + ", bId=" + bId + "]";
	}
    
}