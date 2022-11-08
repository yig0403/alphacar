package com.ch.alphaCar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.alphaCar.dto.Faq;

@Mapper
public interface FaqDao {

	List<Faq> list();

	int insert(Faq faq);

	Faq select(String faqTitle);

	int update(Faq faq);

	int delete(String faqTitle);

}
