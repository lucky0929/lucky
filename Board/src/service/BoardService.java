package service;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import dao.IBoardDao;
import dao.IMemberDao;

@Service
public class BoardService {

	@Autowired
	private IMemberDao mDao;
	@Autowired
	private IBoardDao bDao;


	//	----------------------- 밑은 멤버서비스 -------------------
	public void insertMember(HashMap<String, Object> params) {
		if (params.get("pwd").equals(params.get("pwd_CHECK"))) {
			mDao.insertMember(params);
		}
	}

	public HashMap<String, Object> selectOne(String userid){
		return mDao.selectOne(userid);
	}

	public int login(HashMap<String, Object> params) {
		return mDao.login(params);
	}


	//	---------------- 밑은 보드서비스 ---------------
	public int selectCount() {
		return bDao.selectCount();
	}
	public int searchCount(HashMap<String, Object> params) {
		return bDao.searchCount(params);
	}

	public List<HashMap<String, Object>> selectAll(int start){
		return bDao.selectAll(start);
	}

	public HashMap<String, Object> detail(int num){
		return bDao.detail(num);
	}

	public void insertBoard(HashMap<String, Object> params, HttpServletRequest request) throws Exception{

		String filePath = request.getServletContext().getRealPath("/");

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		File file = new File(filePath);

		while(iterator.hasNext()){
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false){
				originalFileName = multipartFile.getOriginalFilename();//원래 파일이름
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf(".")); // .jpg .png 같은거 확장자
				storedFileName =  UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension; //랜덤이름 + 확장자

				file = new File(filePath + storedFileName);
				multipartFile.transferTo(file);

				params.put("file", storedFileName);
				bDao.insertBoard(params);
			}else {
				bDao.insertBoard(params);
			}
		}
	}


	public void updateBoard(HashMap<String, Object> params) {
		bDao.updateBoard(params);
	}

	public void deleteBoard(HashMap<String, Object> params) {
		bDao.deleteBoard(params);
	}

	public void readCountUp(int num) {
		bDao.readCountUp(num);
	}

	public List<HashMap<String, Object>> search(HashMap<String, Object> params){
		return bDao.search(params);
	}



	//	-------------------밑엔 댓글 -------------------

	public void insertComment(HashMap<String, Object> params) {
		bDao.insertComment(params);
	}

	public List<HashMap<String, Object>> selectComment(int num){
		return bDao.selectComment(num);
	}

	public void deleteComment(int commentNum) {
		bDao.deleteComment(commentNum);
	}

	public void updateComment(HashMap<String, Object> params) {
		bDao.updateComment(params);
	}

	public HashMap<String, Object> oneComment(String commentNum){
		return bDao.oneComment(commentNum);
	}





}
