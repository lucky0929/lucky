package org.dateplanner.vo;

import java.sql.Timestamp;

public class Comment {
	
	private int no;
	private Integer order;
	private int boardNo;
	private User user;
	private String content;
	private Timestamp regdate;
	
	public Comment(int boardNo, int no, int orderNo) {
		this.boardNo=boardNo;
		this.no = no;
		this.order = orderNo;
	}
	
	public Comment(int boardNo, int userNo, String content) {
		
		this.boardNo = boardNo;
		this.user = new User(userNo);
		this.content = content;
		
	} //Comment();
	
	public Comment(int boardNo, int orderNo) {
		
		this.order = orderNo;
		this.boardNo = boardNo;
		
	} //Comment();
	
	public Comment(int no, int boardNo, int userNo, String content) {
		
		this(boardNo, userNo, content);
		this.no = no;
		
	} //Comment();
	
	public int getNo() { return no; }
	public Integer getOrder() { return order; }
	public int getBoardNo() { return boardNo; }
	public User getUser() { return user; }
	public String getContent() { return content; }
	public Timestamp getRegdate() { return regdate; }
	public void setNo(int no) { this.no = no; }
	public void setOrder(Integer order) { this.order = order; }
	public void setBoardNo(int boardNo) { this.boardNo = boardNo; }
	public void setUser(User user) { this.user = user; }
	public void setContent(String content) { this.content = content; }
	public void setRegdate(Timestamp regdate) { this.regdate = regdate; }
	
	@Override
	public String toString() {
		return "Comment [no=" + no + ", order=" + order + ", boardNo=" + boardNo + ", user=" + user + ", content="
				+ content + ", regdate=" + regdate + "]";
	} //toString();
	
} //class Comment;
