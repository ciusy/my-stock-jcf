package org.istock.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.istock.service.base.PagerContext;

public class PagerFilter implements Filter {
	
	protected Log logger = LogFactory.getLog(PagerFilter.class);
	
	public static final String PAGE_SIZE_NAME = "ps";
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		PagerContext.setOffset(getOffset(httpRequest));
		PagerContext.setPagesize(getPagesize(httpRequest));
		try{
			chain.doFilter(request, response);
		}finally{
			PagerContext.removeOffset();
			PagerContext.removePagesize();
		}
	}
	
	private int getOffset(HttpServletRequest request){
		int offset = 0;
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (Exception ignore) {
		}
		return offset;
	}
	
	private int getPagesize(HttpServletRequest httpRequest){
		
		//首先判断request中是否有pagesize参数，如果有这个参数，证明客户端正在请求改变每页显示的行数
		String psvalue = httpRequest.getParameter("pagesize");
		if(psvalue != null && !psvalue.trim().equals("")){
			Integer ps = 0;
			try {
				ps = Integer.parseInt(psvalue);
			} catch (Exception e) {
			}
			if(ps != 0){
				httpRequest.getSession().setAttribute(PAGE_SIZE_NAME, ps);
			}
		}
		
		//判断当前session中是否有pagesize的值
		Integer pagesize = (Integer)httpRequest.getSession().getAttribute(PAGE_SIZE_NAME);
		if(pagesize == null){
			httpRequest.getSession().setAttribute(PAGE_SIZE_NAME, 10);
			return 10;
		}
		logger.debug("pagesize"+pagesize);
		return pagesize;
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
