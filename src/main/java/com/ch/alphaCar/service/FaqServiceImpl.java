package com.ch.alphaCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.dto.Faq;
import com.ch.alphaCar.mapper.FaqDao;

@Service
public class FaqServiceImpl implements FaqService {
	@Autowired
	private FaqDao fd;

	public List<Faq> list() {
		return fd.list();
	}
	public int insert(Faq faq) {
		return fd.insert(faq);
	}
	public Faq select(String faqTitle) {
		return fd.select(faqTitle);
	}
	public int update(Faq faq) {
		return fd.update(faq);
	}
	public int delete(String faqTitle) {
		return fd.delete(faqTitle);
	}
}
