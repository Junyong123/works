package model;

import java.util.Date;

public class CommentsVO {
	private int com_num;
	private int board_num;
	private String com_con;
	private String com_del;
	private String userid;
	private String userid2;
	private Date com_day;
	
	public int getCom_num() {
		return com_num;
	}
	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getCom_con() {
		return com_con;
	}
	public void setCom_con(String com_con) {
		this.com_con = com_con;
	}
	public String getCom_del() {
		return com_del;
	}
	public void setCom_del(String com_del) {
		this.com_del = com_del;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserid2() {
		return userid2;
	}
	public void setUserid2(String userid2) {
		this.userid2 = userid2;
	}
	public Date getCom_day() {
		return com_day;
	}
	public void setCom_day(Date com_day) {
		this.com_day = com_day;
	}
}
