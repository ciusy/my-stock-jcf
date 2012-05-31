package org.istock.filter;

import org.apache.struts2.ServletActionContext;
import org.istock.service.base.PagerContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PagerInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 177137932162448433L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 将请求得到的分页参数设置到ThreadLocal的局部变量中
		PagerContext.setOffset(getOffset());
		PagerContext.setPagesize(getPagesize());
		try {
			return invocation.invoke();
		} finally {
			// 需要指出的是，当线程结束后，对应该线程的局部变量将自动被垃圾回收，
			// 所以显式调用该方法清除线程的局部变量并不是必须的操作，但它可以加快内存回收的速度。
			PagerContext.removeAll(); 
		}
	}

	private int getOffset() {
		int offset = 0;
		try { // 从request请求中获取当前页查询的首记录数
			offset = Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("pager.offset"));// 得到标签自己计算出的pager.offset
		} catch (Exception e) {
		}
		return offset;
	}

	private int getPagesize() {
		// 从页面中请求中，获取用户设置每页显示记录数，取得pagesize参数的值
		String ps = ServletActionContext.getRequest().getParameter("pagesize");
		if (ps != null) {
			try {
				Integer pagesize = Integer.parseInt(ps);
				ServletActionContext.getRequest().getSession().setAttribute(
						"ps", pagesize);
			} catch (Exception e) {
			}
		}
		// 从session中获取pagesize参数的值
		Integer pagesize = (Integer) ServletActionContext.getRequest()
				.getSession().getAttribute("ps");
		// 如果为空，则表示用户没有设置就则显示默认每页显示10行，并将其放入session，以便在显示页面赋值给maxPageItems使用
		if (pagesize == null) {
			ServletActionContext.getRequest().getSession().setAttribute("ps",
					10);
			return 10;
		}
		return pagesize;
	}
}