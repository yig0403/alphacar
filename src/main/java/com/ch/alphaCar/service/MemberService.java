package com.ch.alphaCar.service;

import com.ch.alphaCar.dto.Member;

public interface MemberService {
	Member select(String id);

	int insert(Member member);
}
