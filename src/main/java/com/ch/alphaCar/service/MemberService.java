package com.ch.alphaCar.service;

import com.ch.alphaCar.dto.Member;

public interface MemberService {
	Member select(String id);

	int insert(Member member);

	Member selectEmail(String email);

	int delete(String id);

	int update(Member member);
	
	int updatePassword(Member member);
}
