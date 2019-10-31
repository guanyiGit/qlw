package com.soholy.dogmanager.service.slides.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TSlides;
import com.soholy.dogmanager.mapper.TSlidesMapper;
import com.soholy.dogmanager.service.slides.SlidesService;

@Service
public class SlidesServiceImpl implements SlidesService{
	
	private static Logger logger = LoggerFactory.getLogger(SlidesServiceImpl.class);
	
	
	@Autowired
	private TSlidesMapper slidesMapper;

	@Override
	public DogResult addSlides(TSlides slides) {
		
		try {
			slides.setUploadDate(new Date());
			slides.setCreateTime(new Date());
			int count = slidesMapper.addSlides(slides);
			return DogResult.ok(count);
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return DogResult.build(400, "服务器异常，请稍后再试！！！");
		}
	}

	@Override
	public DogResult deleteSlides(Integer slidesId) {
		try {
			int count = slidesMapper.deleteSlides(slidesId);
			return DogResult.ok(count);
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return DogResult.build(400, "服务器异常，请稍后再试！！！");
		}
	}
	
	@Override
	public DogResult updateSlidesStatusForYes(Integer slidesId) {
		return this.updateSlidesStatusForYes(slidesId,null);
	}
	
	@Override
	public DogResult updateSlidesStatusForYes(Integer slidesId, Integer seq) {
		try {
			int count = slidesMapper.updateSlidesStatusForYes(slidesId, seq,new Date());
			return DogResult.ok(count);
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return DogResult.build(400, "服务器异常，请稍后再试！！！");
		}
	}

	@Override
	public DogResult updateSlidesStatusForNo(Integer slidesId) {
		try {
			int count = slidesMapper.updateSlidesStatusForNo(slidesId,new Date());
			return DogResult.ok(count);
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return DogResult.build(400, "服务器异常，请稍后再试！！！");
		}
	}
	
	@Override
	public List<TSlides> selectSlides() {
		return this.selectSlides(null);
	}
	
	@Override
	public List<TSlides> selectSlides(Integer status) {
		try {
			List<TSlides> list = slidesMapper.selectSlides(status);
			return list;
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return null;
		}
	}
	
	
	
}
