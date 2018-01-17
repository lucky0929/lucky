package util;

import org.springframework.beans.NotWritablePropertyException;

public class PaginateUtil {

   public static String getPaginate(int pageNo,
         int total,
         int numPage,
         int numBlock,
         String url,
         String param) {
      //현재 페이지 : pageNo
      //전체 게시물수 : total 
      //한 페이지당 게시물수 : numPage
      //한 페이지당 보여질 블록수 : numBlock
      //주소 : url
      //파라미터 : param

      //전체 페이지수
      int totalPage = (int)Math.ceil((double)total/numPage);

      //System.out.println(totalPage);

      //현재 블록
      int nowBlock = (int)Math.ceil((double)pageNo/numBlock);
      
      int divPage = ((pageNo * numPage)-1) / (numPage*numBlock);

      String paginate = 
            "<div class='paginate'>";

      if(total!=0) {
         
         if(pageNo < 6) {// 지금 6페이지보다 높을때만
            //비활성화
            paginate += "<span title=\"이전 페이지 없음\"><i class=\"fa fa-chevron-left\"></i></span>";
         }else {
            //활성화
            paginate += "<a href='"+url+"?"+param+(1)+"' title='이전 페이지로'><i class='fa fa-chevron-left'></i><span class='screen_out'> 처음으로</span></a>";
            
         }//if end

         if(totalPage > 5) {//5페이지 이상일때만
            //이전버튼
            if(pageNo < 6) {// 지금 6페이지 이상일떄만
               //비활성화
               paginate += "<span title=\"이전 페이지 없음\"><i class=\"fa fa-chevron-left\"></i></span>";
            }else {
               //활성화
               paginate += "<a href='"+url+"?"+param+((((divPage-1) *5)+1)+4)+"' title='이전 페이지로'><i class='fa fa-chevron-left'></i><span class='screen_out'> 이전 </span></a>";

            }//if end
         }

         System.out.println(totalPage);
         for(int i = 1 ; i <= numBlock ; i++) {

            //실제 출력 페이지
            int realPage = ((nowBlock-1)*numBlock)+i;

            //현재 페이지냐? 아니냐?
            if(realPage==pageNo) {
               //현재 페이지
               paginate += "<strong title='현재 "+pageNo+"페이지'>"+pageNo+"</strong>";

            }else {
               //현재 페이지가 아님
               paginate += "<a href='"+url+"?"+param+realPage+"' title='"+realPage+"'>"+realPage+"</a>";


            }//if ~ else end

            if(realPage==totalPage) {
               break;
            }//if end

         }//for end(블록 만들기)
         
        
         if(totalPage > 5) {//전체 6페이지 이상일때만
            //다음버튼
            if(totalPage < 6 || pageNo == totalPage) {
               //비활성화
               paginate+="<span title='다음 페이지 없음'><i class='fa fa-chevron-right'></i></span>";
            }else {
               //활성화
               if((((divPage+1) *5)+1) < totalPage) {
                  paginate+="<a href='"+url+"?"+param+(((divPage+1) *5)+1)+"' title='다음 페이지로'><i class='fa fa-chevron-right'></i><span class='screen_out'> 다음 </span></a>";
               }else
            	   paginate+="<span title='다음 페이지 없음'><i class='fa fa-chevron-right'></i></span>";
                  
            }//if end
         }//if tatalpage > 5 end


         if(totalPage > 5) {//5페이지 이상일때만
            //다음버튼
            if(totalPage < 6 || pageNo == totalPage || (((divPage+1) *5)+1) > totalPage) {
               //비활성화
               paginate+="<span title='다음 페이지 없음'><i class='fa fa-chevron-right'></i></span>";
            }else {
               //활성화
               paginate+="<a href='"+url+"?"+param+(totalPage)+"' title='다음 페이지로'><i class='fa fa-chevron-right'></i><span class='screen_out'> 끝으로 </span></a>";
            }//if end
         }//if tatalpage > 5 end

      }//if end

      paginate+= "</div>";

      return paginate;
   }


}