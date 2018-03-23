package org.dateplanner.vo;

import java.sql.Timestamp;

public class Comment {
	
	private int no;
	private Integer orderNo;
	private int boardNo;
	private User user;
	private String content;
	private Timestamp regdate;

	public Comment() { }

	public Comment(int boardNo, int no, int orderNo) {
		this.boardNo=boardNo;
		this.no = no;
		this.orderNo = orderNo;
	}
	
	public Comment(int boardNo, int userNo, String content) {
		
		this.boardNo = boardNo;
		this.user = new User(userNo);
		this.content = content;
		
	} //Comment();
	
	public Comment(int boardNo, int orderNo) {
		
		this.orderNo = orderNo;
		this.boardNo = boardNo;
		
	} //Comment();
	
	public Comment(int no, int boardNo, int userNo, String content) {
		
		this(boardNo, userNo, content);
		this.no = no;
		
	} //Comment();
	
	public int getNo() { return no; }
	public Integer getOrder() { return orderNo; }
	public int getBoardNo() { return boardNo; }
	public User getUser() { return user; }
	public String getContent() { return content; }
	public String getRegdate() { return new Post().getFormattedRegdate(regdate); }
	public void setNo(int no) { this.no = no; }
	public void setOrder(Integer order) { this.orderNo = order; }
	public void setBoardNo(int boardNo) { this.boardNo = boardNo; }
	public void setUser(User user) { this.user = user; }
	public void setContent(String content) { this.content = content; }
	public void setRegdate(Timestamp regdate) { this.regdate = regdate; }
	
	@Override
	public String toString() {
		return "Comment [no=" + no + ", order=" + orderNo + ", boardNo=" + boardNo + ", user=" + user + ", content="
				+ content + ", regdate=" + regdate + "]";
	} //toString();
	
} //class Comment;
/*
	  CREATE TABLE `comments` (
	  `no` int(10) NOT NULL,
	  `order` int(4) DEFAULT NULL,
	  `board_no` int(10) NOT NULL,
	  `user_no` int(10) NOT NULL,
	  `content` varchar(1500) NOT NULL,
	  `regdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
	) ENGINE=InnoDB DEFAULT CHARSET=utf8
*/