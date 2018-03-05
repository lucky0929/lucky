package org.dateplanner.interceptor;

import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class DebuggingInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		ObjectWriter writer = new ObjectMapper().writerWithDefaultPrettyPrinter();
		
		String uri = request.getRequestURL().toString(); int totalLength = 135 - uri.length(), rightLength = totalLength / 2, leftLength = totalLength - rightLength;
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < leftLength; i++) builder.append('='); builder.append(" " + uri + " "); for(int i = 0; i < rightLength; i++) builder.append('=');
		HttpSession session = request.getSession();
		Enumeration<String> sessEnum = session.getAttributeNames();
		Map<String, Object> map = new TreeMap<>(); String str;
		while(sessEnum.hasMoreElements()) map.put(str = sessEnum.nextElement(), session.getAttribute(str));
		
		System.out.print(builder.toString() + "\n|\n| parameters : ");
		try { System.out.println(writer.writeValueAsString(request.getParameterMap()).replaceAll("\\R", "\n| ")); } catch(Exception e) { System.out.println("{\n|   Exception : \"" + e.getMessage() + "\"\n| }"); }
		System.out.print("| session : ");
		try { System.out.println(writer.writeValueAsString(map).replaceAll("\\R", "\n| ")); } catch(Exception e) { System.out.println("{\n|   Exception : \"" + e.getMessage() + "\"\n| }"); }
		System.out.println("|\n===");
		
		return super.preHandle(request, response, handler);
		
	} //preHandle();
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		System.out.println(modelAndView);
		
		System.out.print("\n===\n|\n| ModelAndView : ");
		try { System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(modelAndView).replaceAll("\\R", "\n| ")); } catch(Exception e) { System.out.println("{\n|   Exception : \"" + e.getMessage() + "\"\n| }"); }
		System.out.println("|\n=========================================================================================================================================");
		
		super.postHandle(request, response, handler, modelAndView);
		
	} //postHandle();
	
} //class DebuggingInterceptor;
