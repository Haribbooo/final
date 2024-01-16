package com.example.gym.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gym.mapper.ReservationMapper;
import com.example.gym.vo.CustomerAttendance;
import com.example.gym.vo.Program;
import com.example.gym.vo.ProgramDate;
import com.example.gym.vo.ProgramReservation;

@Service
@Transactional

public class ReservationService {
	@Autowired
	private ReservationMapper reservationMapper;
	// 예약 리스트
	public Map<String, Object> selectReservationList(Map<String, Object> paramMap) {
		Map<String, Object> resultMap = new HashMap<>();
		List<Map<String, Object>> reservationList = reservationMapper.selectReservationList(paramMap);	
		resultMap.put("reservationList", reservationList);
		return resultMap;
	}

	// 예약 추가
	public int insertReservation(ProgramReservation reservation) {	
		return reservationMapper.insertReservation(reservation);
	
	}
	
	
	// 프로그램 예약 가능 정보 조회
	public List<ProgramDate> selectProgramDates(int program_no) {
		return reservationMapper.selectProgramDates(program_no);
	}

	// 예약 삭제
	public int deleteReservation(ProgramReservation reservation) {
		int row = reservationMapper.deleteReservation(reservation);
		return row;
	}
	
	
	// 해당날짜에 진행 예정 프로그램 추가
	public int insertProgramDate(ProgramDate programDate) {
		return reservationMapper.insertProgramDate(programDate);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}