package com.bdi.sp.vo;

public class Login {

	private Integer linum;
	private String liid;
	private String liname;
	private String lipwd1;
	private String lipwd2;
	private String liemail;
	private String liaddress;
	private String lisex;
	private Integer libirth;
	private String lire;
	
	
	public String getLiid() {
		return liid;
	}
	public void setLiid(String liid) {
		this.liid = liid;
	}
	
	public Integer getLinum() {
		return linum;
	}
	public void setLinum(Integer linum) {
		this.linum = linum;
	}
	public String getLiname() {
		return liname;
	}
	public void setLiname(String liname) {
		this.liname = liname;
	}
	public String getLipwd1() {
		return lipwd1;
	}
	public void setLipwd1(String lipwd1) {
		this.lipwd1 = lipwd1;
	}
	public String getLipwd2() {
		return lipwd2;
	}
	public void setLipwd2(String lipwd2) {
		this.lipwd2 = lipwd2;
	}
	public String getLiemail() {
		return liemail;
	}
	public void setLiemail(String liemail) {
		this.liemail = liemail;
	}
	public String getLiaddress() {
		return liaddress;
	}
	public void setLiaddress(String liaddress) {
		this.liaddress = liaddress;
	}
	public String getLisex() {
		return lisex;
	}
	public void setLisex(String lisex) {
		this.lisex = lisex;
	}
	public Integer getLibirth() {
		return libirth;
	}
	public void setLibirth(Integer libirth) {
		this.libirth = libirth;
	}
	public String getLire() {
		return lire;
	}
	public void setLire(String lire) {
		this.lire = lire;
	}
	@Override
	public String toString() {
		return "Login [linum=" + linum + ", liid=" + liid + ", liname=" + liname + ", lipwd1=" + lipwd1 + ", lipwd2="
				+ lipwd2 + ", liemail=" + liemail + ", liaddress=" + liaddress + ", lisex=" + lisex + ", libirth="
				+ libirth + ", lire=" + lire + "]";
	}
	
	
	
}
