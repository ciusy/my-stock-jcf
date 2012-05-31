<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<?xml version="1.0" encoding="UTF-8"?>   
<chart>
	<series>
		<s:iterator value="#session.chartDataList" status="st">
		<s:if test="#st.index==0">
			<s:iterator value="dataMap">
				<value xid="<s:property value="key"/>"><s:property value="key"/>时</value>
			</s:iterator>
		</s:if>
		</s:iterator>
	</series>
	<graphs>
		<s:iterator value="#session.chartDataList" status="st">
		<graph gid="<s:property value="#st.index"/>">
			<s:iterator value="dataMap">
				<value xid="<s:property value="key"/>"><s:property value="value"/></value>
			</s:iterator>
		</graph>
		</s:iterator>
	</graphs>
</chart>