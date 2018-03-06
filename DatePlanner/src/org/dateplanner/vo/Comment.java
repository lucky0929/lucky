package org.dateplanner.vo;

import java.sql.Timestamp;

public class Comment {
	private int no;
	private int boardNo;
	private int userNo;
	private String comment;  
	private Timestamp writeDate;
	private int seq;
	
	public int getCommentNo() { return no; }
	public int getBoardNo() { return boardNo;}
	public int getUserNo() { return userNo; }
	public String getComment() { return comment; }
	public Timestamp getWriteDate() { return writeDate; }
	public int getSeq() { return seq; }
	public void setCommentNo(int commentNo) { this.no = commentNo; }
	public void setBoardNo(int boardNo) { this.boardNo = boardNo; }
	public void setUserNo(int userNo) { this.userNo = userNo; }
	public void setComment(String comment) { this.comment = comment; }
	public void setWriteDate(Timestamp writeDate) { this.writeDate = writeDate; }
	public void setSeq(int seq) { this.seq = seq; }
	
	@Override
	public String toString() {
		return "Comment [boardNo=" + boardNo + ", commentNo=" + no + ", userNo=" + userNo + ", comment="
				+ comment + ", writeDate=" + writeDate + ", seq=" + seq + "]";
	}
	
} //Comment
