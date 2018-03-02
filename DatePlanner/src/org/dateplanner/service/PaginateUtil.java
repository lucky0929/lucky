package org.dateplanner.service;

public class PaginateUtil {
	public static String getPaginate(int pageNo, int total) {

		int numBlock = 5, numPage = 5;
		String url = "/", param = "page=";

		int totalPage = (int)Math.ceil((double)total/numPage);
		int nowBlock = (int)Math.ceil((double)pageNo/numBlock);

		String paginate ="<div class='paginate'>";

		if(total != 0) {
			if(pageNo<=1) {}
			else {
				paginate += "<a href='" + url+"?" + param + (((((pageNo-1)/5)*5)-5)+1) + "' title='이전 블록 페이지로'><i class='fa fa-angle-double-left'></i></a>";
				paginate += "<a href='" + url+"?" + param + (pageNo-1)+"' title='이전 페이지로'><i class='fa fa-chevron-left'></i></a>";
			}//if end

			for(int i = 1 ; i <= numBlock ; i++) {
				int realPage = ((nowBlock-1) * numBlock) + i;
				if(realPage==pageNo) { paginate += "<strong title='현재 "+pageNo+"페이지'>"+pageNo+"</strong>";  }
				else { paginate += "<a href='"+url+"?"+param+realPage+"' title='"+realPage+"'>"+realPage+"</a>"; }
				if(realPage==totalPage) {break;}
			} //for end
			if(pageNo >= totalPage) {
				/*paginate += "<span title='다음 페이지 없음'><i class='fa fa-chevron-right'></i></span>";*/
			} else {
				paginate += "<a href='" + url+"?" + param + (pageNo+1) + "'title='다음 페이지로'><i class='fa fa-chevron-right'></i></a>";
				paginate += "<a href='" + url+"?" + param + (((((pageNo-1)/5)*5)+5)+1) + "'title='다음 블록 페이지로'><i class='fa fa-angle-double-right'></i></a>";
			} //if~else
		} //if end
		paginate += "</div>";
		return paginate;
	}
}