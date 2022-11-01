package com.ch.alphaCar.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ch.alphaCar.dto.Member;

@Mapper
public interface MemberDao {

	Member select(String id);

	int insert(Member member);

}
