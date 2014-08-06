package ck.backup;

import java.util.Date;

public class DesTable {
    private String id;
    private String text;
    private String remark;
    private Date theTime;
    
    public String getId() {
		return id;
    }
    public String getText() {
    	return text;
    }
    public Date getTheTime() {
		return theTime;
	}
	public String getRemark() {
		return remark;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setTheTime(Date theTime) {
		this.theTime = theTime;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
		

}
