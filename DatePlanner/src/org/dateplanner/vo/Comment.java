package org.dateplanner.vo;

import java.sql.Timestamp;

public class Comment {
	private int no;
	private int boardNo;
	private int userNo;
	private String userName;
	private String content;  
	private Timestamp writeDate;
	private int seq;

	public Comment(int no, int boardNo, int userNo, String content, int seq) {
		super();
		this.no = no;
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.content = content;
		this.seq = seq;
	}
	public Comment(int no, int boardNo, String userName, String content, int seq) {
		super();
		this.no = no;
		this.boardNo = boardNo;
		this.userName = userName;
		this.content = content;
		this.seq = seq;
	}

	public int getNo() { return no; }
	public int getBoardNo() { return boardNo;}
	public int getUserNo() { return userNo; }
	public String getUserName() { return userName; }
	public String getContent() { return content; }
	public Timestamp getWriteDate() { return writeDate; }
	public int getSeq() { return seq; }
	public void setNo(int commentNo) { this.no = commentNo; }
	public void setBoardNo(int boardNo) { this.boardNo = boardNo; }
	public void setUserNo(int userNo) { this.userNo = userNo; }
	public void setUserName(String userName) { this.userName = userName; }
	public void setContent(String content) { this.content = content; }
	public void setWriteDate(Timestamp writeDate) { this.writeDate = writeDate; }
	public void setSeq(int seq) { this.seq = seq; }
	
	@Override
	public String toString() {
		return "Comment [boardNo=" + boardNo + ", commentNo=" + no + ", userNo=" + userNo + ", comment="
				+ content + ", writeDate=" + writeDate + ", seq=" + seq + "]";
	}
	
} //Comment