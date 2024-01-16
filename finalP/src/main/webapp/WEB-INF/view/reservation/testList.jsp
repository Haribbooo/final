<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="지점 리스트" />
<c:set var="description" value="헬스 관련 업무들을 할 수 있는 사이트" />
<c:set var="keywords" value="운동,헬스,헬스장,예약" />
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<c:set var="body">

	<h1>프로그램 목록</h1>
		<li v-for="(program, p) in programList" :key="p">
			<h3>{{program.programName}}</h3>

		</li>
</c:set>
<c:set var="script">
		data() {
			return {
				programList: JSON.parse('${programList}'),
			}
		},
		
		methods: {
		
		},
	
</c:set>
<%@ include file="/inc/admin_layout.jsp"%>