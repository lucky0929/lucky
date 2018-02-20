package org.dateplanner.service;

import java.util.HashMap;
import java.util.List;

import org.dateplanner.dao.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	public List<HashMap<String, Object>> selectBoard(){
		return boardDAO.selectBoard();
	}
	
}
