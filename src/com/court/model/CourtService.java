package com.court.model;

import java.sql.Date;
import java.util.List;

public class CourtService {

	private CourtDAO_interface dao;

	public CourtService() {
		dao = new CourtDAO();
	}

	public CourtVO addCourt(String cname, String csite, String cfee, 
			String copen, String ccity, String caddr, Double clat, Double clng,
			String ctel, String ccon, byte[] cimg, String cdesc) {


		CourtVO courtVO = new CourtVO();

		courtVO.setCname(cname);
		courtVO.setCsite(csite);
		courtVO.setCfee(cfee);
		courtVO.setCopen(copen);
		courtVO.setCcity(ccity);
		courtVO.setCaddr(caddr);
		courtVO.setClat(clat);
		courtVO.setClng(clng);
		courtVO.setCtel(ctel);
		courtVO.setCcon(ccon);
		courtVO.setCimg(cimg);
		courtVO.setCdesc(cdesc);
		courtVO.setCview(new Integer(0));
		courtVO.setCstatus(new Integer(0));
		courtVO.setCnew(new java.sql.Date(new java.util.Date().getTime()));
		courtVO.setCedit(new java.sql.Date(new java.util.Date().getTime()));
		dao.insert(courtVO);

		return courtVO;
	}

	public CourtVO updateCourt(Integer cid, String cname, String csite, String cfee, 
			String copen, String ccity, String caddr, Double clat, Double clng,
			String ctel, String ccon, byte[] cimg, String cdesc){
			
		CourtVO courtVO = new CourtVO();

		courtVO.setCid(cid);
		courtVO.setCname(cname);
		courtVO.setCsite(csite);
		courtVO.setCfee(cfee);
		courtVO.setCopen(copen);
		courtVO.setCcity(ccity);
		courtVO.setCaddr(caddr);
		courtVO.setClat(clat);
		courtVO.setClng(clng);
		courtVO.setCtel(ctel);
		courtVO.setCcon(ccon);
		courtVO.setCimg(cimg);
		courtVO.setCdesc(cdesc);
		courtVO.setCedit(new java.sql.Date(new java.util.Date().getTime()));
		dao.update(courtVO);

		return courtVO;
	}

	public void deleteCourt(Integer cid) {
		dao.delete(cid);
	}

	public CourtVO getOneCourt(Integer cid) {
		return dao.findByPrimaryKey(cid);
	}

	public List<CourtVO> getAll() {
		return dao.getAll();
	}
	
	public List<CourtVO> getAllValid() {
		return dao.getAllValid();
	}
	
	public List<CourtVO> getAllDeleted() {
		return dao.getAllDeleted();
	}
	
	public List<CourtVO> getAllPending() {
		return dao.getAllPending();
	}
	
	public CourtVO updateView(Integer cid){
		
		CourtVO courtVO = dao.findByPrimaryKey(cid);
		courtVO.setCview(courtVO.getCview() + 1);
		dao.updateView(courtVO);

		return courtVO;
	}
	
	public void validate(Integer cid) {
		dao.validate(cid);
	}
}
