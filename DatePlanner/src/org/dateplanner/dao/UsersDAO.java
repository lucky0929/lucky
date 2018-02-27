package org.dateplanner.dao;

import org.dateplanner.vo.User;

public interface UsersDAO {
	/*
	회원가입
	회원수정
	로그인
	회원탈퇴
	사용자 검색
	프로필 페이지 [board JOIN WITH users]
	 */
	public void insertDateplanner(User user);
	public int idCheck(String id);
	public void update(User user);
	public void delete(String id);
	public User login(String id, String pw);
	
} //interface UsersDAO;
