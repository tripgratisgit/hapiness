package com.court.model;

import java.sql.Date;
import java.util.*;

public interface CourtDAO_interface {
          public void insert(CourtVO courtVO);
          public void update(CourtVO courtVO);
          public void updateView(CourtVO courtVO);
          public void delete(Integer cid);
          public void validate(Integer cid);
          public CourtVO findByPrimaryKey(Integer cid);
          public List<CourtVO> getAll();
          public List<CourtVO> getAllValid();
          public List<CourtVO> getAllDeleted();
          public List<CourtVO> getAllPending();
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
