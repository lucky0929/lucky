package org.dateplanner.vo;

import java.sql.Timestamp;

public class CommentResult {
	private int no;
	private int boardNo;
	private int userNo;
	private String content;  
	private Timestamp writeDate;
	private int parentNo;
	private int seq;
	private String userName;
	private String profile;
	
	
	@Override
	public String toString() {
		return "CommentResult [no=" + no + ", boardNo=" + boardNo + ", userNo=" + userNo + ", content=" + content
				+ ", writeDate=" + writeDate + ", parentNo=" + parentNo + ", seq=" + seq + ", userName=" + userName
				+ ", profile=" + profile + "]";
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}
	public int getParentNo() {
		return parentNo;
	}
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
//	                   no,     boardNo,     userNo,        content,           writeDate,     parentNo,     seq,        userName
	
}
