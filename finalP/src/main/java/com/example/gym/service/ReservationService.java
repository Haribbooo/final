package com.example.gym.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gym.mapper.ReservationMapper;
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
		int totalRow = reservationMapper.reservationCount();
		resultMap.put("reservationList", reservationList);
		resultMap.put("totalRow", totalRow);

		return resultMap;
	}

	// 예약 추가
	public int insertReservation(ProgramReservation reservation) {
		int row = reservationMapper.insertReservation(reservation);
		return row;
	}

	// 프로그램 목록조회
	public List<Map<String, Object>> selectProgram(ProgramDate programDate) {
		List<Map<String, Object>> resultMap = reservationMapper.selectProgram(programDate);
		return resultMap;

	}

	// 예약 삭제
	public int deleteReservation(ProgramReservation reservation) {
		int row = reservationMapper.deleteReservation(reservation);
		return row;
	}

}