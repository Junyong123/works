package model;

import java.util.Date;

public class BoardConVO {
	private int board_connum;
	private int board_connumf;
	private int board_num;
	private String board_title;
	private String board_con;
	private String board_user;
	private Date board_day;
	private String board_del;
	
	public int getBoard_connum() {
		return board_connum;
	}
	public void setBoard_connum(int board_connum) {
		this.board_connum = board_connum;
	}
	public int getBoard_connumf() {
		return board_connumf;
	}
	public void setBoard_connumf(int board_connumf) {
		this.board_connumf = board_connumf;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_con() {
		return board_con;
	}
	public void setBoard_con(String board_con) {
		this.board_con = board_con;
	}
	public String getBoard_user() {
		return board_user;
	}
	public void setBoard_user(String board_user) {
		this.board_user = board_user;
	}
	public Date getBoard_day() {
		return board_day;
	}
	public void setBoard_day(Date board_day) {
		this.board_day = board_day;
	}
	public String getBoard_del() {
		return board_del;
	}
	public void setBoard_del(String board_del) {
		this.board_del = board_del;
	}
	
}
