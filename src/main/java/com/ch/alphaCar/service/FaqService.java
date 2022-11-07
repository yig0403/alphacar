package com.ch.alphaCar.service;

import java.util.List;

import com.ch.alphaCar.dto.Faq;

public interface FaqService {

	List<Faq> list();

	int insert(Faq faq);

	Faq select(String faqTitle);

	int update(Faq faq);

	int delete(String faqTitle);

}
