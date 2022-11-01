package com.ch.alphaCar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.dto.Member;
import com.ch.alphaCar.mapper.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao md;

	@Override
	public Member select(String id) {
		return md.select(id);
	}

	public int insert(Member member) {
		return md.insert(member);
	}
}
