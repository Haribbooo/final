<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="예약 페이지" />
<c:set var="description" value="예약 페이지입니다." />
<c:set var="keywords" value="예약, 날짜, 헬스장" />
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<c:set var="body">
  <el-form id="reservationForm">
    <el-form-item label="지점선택">
      <el-select v-model="selectBranch" clearable placeholder="선택">
        <el-option label="서울" value="seoul"></el-option>
        <el-option label="대전" value="daejeon"></el-option>
        <el-option label="부산" value="busan"></el-option>
      </el-select>
      <span v-if="showError" style="color: red;">지점을 선택하세요.</span>
    </el-form-item>
    <el-form-item label="날짜선택">
      <el-date-picker
        v-model="selectedDate"
        type="date"
        placeholder="날짜 선택">
      </el-date-picker>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit(form)">확인</el-button>
    </el-form-item>
  </el-form>
</c:set>

<c:set var="script">
	data() {
	  return {
	    selectBranch: '',
	    selectedDate: '',
	    showError: false
	  }
	},
	watch: {
	},
	methods: {
	  onSubmit() {
	    if (!this.selectBranch || !this.selectedDate) {
	      this.showError = true;
	    } else {
	      this.showError = false;
	      const actionURL = 'reservationConfirm.jsp?branch=' + encodeURIComponent(this.selectBranch) + '&date=' + encodeURIComponent(this.selectedDate);
	      document.getElementById('reservationForm').action = actionURL;
	      document.getElementById('reservationForm').submit();
	      window.close();
	    }
	  }
	}
</c:set>
<%@ include file="/inc/user_layout.jsp" %>