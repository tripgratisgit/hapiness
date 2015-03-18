package com.court.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CourtDAO implements CourtDAO_interface {
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
		private static DataSource ds = null;
		static {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
			private static final String INSERT_STMT = 
				"INSERT INTO COURT (cId, cName, cSite, cFee, cOpen, cCity, cAddr, cLat, cLng, cTel, cCon, cImg, cDesc, cView, cStatus, cNew, cEdit) VALUES (COURT_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			private static final String GET_ALL_STMT = 
				"SELECT cId, cName, cSite, cFee, cOpen, cCity, cAddr, cLat, cLng, cTel, cCon, cImg, cDesc, cView, cStatus, to_char(cNew,'yyyy-mm-dd') cNew, to_char(cEdit,'yyyy-mm-dd') cEdit FROM COURT order by cId";
			private static final String GET_ALL_VALID_STMT = 
					"SELECT cId, cName, cSite, cFee, cOpen, cCity, cAddr, cLat, cLng, cTel, cCon, cImg, cDesc, cView, cStatus, to_char(cNew,'yyyy-mm-dd') cNew, to_char(cEdit,'yyyy-mm-dd') cEdit FROM COURT where cStatus = 1 order by cId";
			private static final String GET_ALL_DELETED_STMT = 
					"SELECT cId, cName, cSite, cFee, cOpen, cCity, cAddr, cLat, cLng, cTel, cCon, cImg, cDesc, cView, cStatus, to_char(cNew,'yyyy-mm-dd') cNew, to_char(cEdit,'yyyy-mm-dd') cEdit FROM COURT where cStatus = 2 order by cId";
			private static final String GET_ALL_PENDING_STMT = 
					"SELECT cId, cName, cSite, cFee, cOpen, cCity, cAddr, cLat, cLng, cTel, cCon, cImg, cDesc, cView, cStatus, to_char(cNew,'yyyy-mm-dd') cNew, to_char(cEdit,'yyyy-mm-dd') cEdit FROM COURT where cStatus = 0 order by cId";
			private static final String GET_ONE_STMT = 
				"SELECT cId, cName, cSite, cFee, cOpen, cCity, cAddr, cLat, cLng, cTel, cCon, cImg, cDesc, cView, cStatus, to_char(cNew,'yyyy-mm-dd') cNew, to_char(cEdit,'yyyy-mm-dd') cEdit FROM COURT where cId = ?";
			private static final String UPDATE_DELETE = 
				"UPDATE COURT set cStatus=?, cEdit=? where cId = ?";
			private static final String UPDATE_VALIDATE = 
					"UPDATE COURT set cStatus=?, cEdit=? where cId = ?";
			private static final String UPDATE_VIEW = 
				"UPDATE COURT set cView=? where cId = ?";
			private static final String UPDATE = 
				"UPDATE COURT set cName=?, cSite=?, cFee=?, cOpen=?, cCity=?, cAddr=?, cLat=?, cLng=?, cTel=?, cCon=?, cImg=?, cDesc=?, cEdit=? where cId = ?";


			
			@Override
			public void insert(CourtVO courtVO) {

				Connection con = null;
				PreparedStatement pstmt = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(INSERT_STMT);

					pstmt.setString(1, courtVO.getCname());
					pstmt.setString(2, courtVO.getCsite());
					pstmt.setString(3, courtVO.getCfee());
					pstmt.setString(4, courtVO.getCopen());
					pstmt.setString(5, courtVO.getCcity());
					pstmt.setString(6, courtVO.getCaddr());
					pstmt.setDouble(7, courtVO.getClat());
					pstmt.setDouble(8, courtVO.getClng());
					pstmt.setString(9, courtVO.getCtel());
					pstmt.setString(10, courtVO.getCcon());
					pstmt.setBytes(11, courtVO.getCimg()); 
					pstmt.setString(12, courtVO.getCdesc());
					pstmt.setInt(13, courtVO.getCview());
					pstmt.setInt(14, courtVO.getCstatus());
					pstmt.setDate(15, courtVO.getCnew());
					pstmt.setDate(16, courtVO.getCedit());
					pstmt.executeUpdate();

				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
				} finally {
					if (pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (con != null) {
						try {
							con.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}

			}

			@Override
			public void update(CourtVO courtVO) {

				Connection con = null;
				PreparedStatement pstmt = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(UPDATE);
					
					pstmt.setString(1, courtVO.getCname());
					pstmt.setString(2, courtVO.getCsite());
					pstmt.setString(3, courtVO.getCfee());
					pstmt.setString(4, courtVO.getCopen());
					pstmt.setString(5, courtVO.getCcity());
					pstmt.setString(6, courtVO.getCaddr());
					pstmt.setDouble(7, courtVO.getClat());
					pstmt.setDouble(8, courtVO.getClng());
					pstmt.setString(9, courtVO.getCtel());
					pstmt.setString(10, courtVO.getCcon());
					pstmt.setBytes(11, courtVO.getCimg()); 
					pstmt.setString(12, courtVO.getCdesc());
					pstmt.setDate(13, courtVO.getCedit());
					pstmt.setInt(14, courtVO.getCid());
					pstmt.executeUpdate();

				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
				} finally {
					if (pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (con != null) {
						try {
							con.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}

			}

			@Override
			public void delete(Integer cid) {

				Connection con = null;
				PreparedStatement pstmt = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(UPDATE_DELETE);
					
					pstmt.setInt(1, 2);
					pstmt.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
					pstmt.setInt(3, cid);
					
					pstmt.executeUpdate();

				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
				} finally {
					if (pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (con != null) {
						try {
							con.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}

			}

			@Override
			public CourtVO findByPrimaryKey(Integer cid) {

				CourtVO courtVO = null;
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(GET_ONE_STMT);

					pstmt.setInt(1, cid);

					rs = pstmt.executeQuery();

					while (rs.next()) {
						courtVO = new CourtVO();
						
						courtVO.setCid(rs.getInt("cid"));
						courtVO.setCname(rs.getString("cname"));
						courtVO.setCsite(rs.getString("csite"));
						courtVO.setCfee(rs.getString("cfee"));
						courtVO.setCopen(rs.getString("copen"));
						courtVO.setCcity(rs.getString("ccity"));
						courtVO.setCaddr(rs.getString("caddr"));
						courtVO.setClat(rs.getDouble("clat"));
						courtVO.setClng(rs.getDouble("clng"));
						courtVO.setCtel(rs.getString("ctel"));
						courtVO.setCcon(rs.getString("ccon"));
//						courtVO.setCOURT_PIC(rs.getBytes("COURT_PIC"));
						courtVO.setCdesc(rs.getString("cdesc"));
						courtVO.setCview(rs.getInt("cview"));
						courtVO.setCstatus(rs.getInt("cstatus"));
						courtVO.setCnew(rs.getDate("cnew"));
						courtVO.setCedit(rs.getDate("cedit"));
					}

				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
				} finally {
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (con != null) {
						try {
							con.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}
				return courtVO;
			}

			@Override
			public List<CourtVO> getAll() {
				List<CourtVO> list = new ArrayList<CourtVO>();
				CourtVO courtVO = null;

				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(GET_ALL_STMT);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						courtVO = new CourtVO();
						courtVO.setCid(rs.getInt("cId"));
						courtVO.setCname(rs.getString("cName"));
						courtVO.setCsite(rs.getString("cSite"));
						courtVO.setCfee(rs.getString("cFee"));
						courtVO.setCopen(rs.getString("cOpen"));
						courtVO.setCcity(rs.getString("cCity"));
						courtVO.setCaddr(rs.getString("cAddr"));
						courtVO.setClat(rs.getDouble("cLat"));
						courtVO.setClng(rs.getDouble("cLng"));
						courtVO.setCtel(rs.getString("cTel"));
						courtVO.setCcon(rs.getString("cCon"));
						courtVO.setCimg(rs.getBytes("cImg"));
						courtVO.setCdesc(rs.getString("cDesc"));
						courtVO.setCview(rs.getInt("cView"));
						courtVO.setCstatus(rs.getInt("cStatus"));
						courtVO.setCnew(rs.getDate("cNew"));
						courtVO.setCedit(rs.getDate("cEdit"));
						list.add(courtVO); // Store the row in the list
						
					}

				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
				} finally {
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (con != null) {
						try {
							con.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}
				return list;
			}

			//update view
			@Override
			public void updateView(CourtVO courtVO) {

				Connection con = null;
				PreparedStatement pstmt = null;

				try {
					con = ds.getConnection();
					pstmt = con.prepareStatement(UPDATE_VIEW);
					
					pstmt.setInt(1, courtVO.getCview());
					pstmt.setInt(2, courtVO.getCid());
					pstmt.executeUpdate();

				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
				} finally {
					if (pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (con != null) {
						try {
							con.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}

			}
			
			//validate
			@Override
			public void validate(Integer cid) {

				Connection con = null;
				PreparedStatement pstmt = null;

				try {
					con = ds.getConnection();
					pstmt = con.prepareStatement(UPDATE_VALIDATE);

					pstmt.setInt(1, 1);
					pstmt.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
					pstmt.setInt(3, cid);
					
					pstmt.executeUpdate();

				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
				} finally {
					if (pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (con != null) {
						try {
							con.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}

			}
			
			//public List<CourtVO> getAllValid();
			@Override
			public List<CourtVO> getAllValid() {
				List<CourtVO> list = new ArrayList<CourtVO>();
				CourtVO courtVO = null;

				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					con = ds.getConnection();
					pstmt = con.prepareStatement(GET_ALL_VALID_STMT);
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						courtVO = new CourtVO();
						courtVO.setCid(rs.getInt("cId"));
						courtVO.setCname(rs.getString("cName"));
						courtVO.setCsite(rs.getString("cSite"));
						courtVO.setCfee(rs.getString("cFee"));
						courtVO.setCopen(rs.getString("cOpen"));
						courtVO.setCcity(rs.getString("cCity"));
						courtVO.setCaddr(rs.getString("cAddr"));
						courtVO.setClat(rs.getDouble("cLat"));
						courtVO.setClng(rs.getDouble("cLng"));
						courtVO.setCtel(rs.getString("cTel"));
						courtVO.setCcon(rs.getString("cCon"));
						courtVO.setCimg(rs.getBytes("cImg"));
						courtVO.setCdesc(rs.getString("cDesc"));
						courtVO.setCview(rs.getInt("cView"));
						courtVO.setCstatus(rs.getInt("cStatus"));
						courtVO.setCnew(rs.getDate("cNew"));
						courtVO.setCedit(rs.getDate("cEdit"));
						list.add(courtVO); // Store the row in the list
						
					}

				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
				} finally {
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (con != null) {
						try {
							con.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}
				return list;
			}
			
			//getAllDeleted
			@Override
			public List<CourtVO> getAllDeleted() {
				List<CourtVO> list = new ArrayList<CourtVO>();
				CourtVO courtVO = null;

				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					con = ds.getConnection();
					pstmt = con.prepareStatement(GET_ALL_DELETED_STMT);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						courtVO = new CourtVO();
						courtVO.setCid(rs.getInt("cId"));
						courtVO.setCname(rs.getString("cName"));
						courtVO.setCsite(rs.getString("cSite"));
						courtVO.setCfee(rs.getString("cFee"));
						courtVO.setCopen(rs.getString("cOpen"));
						courtVO.setCcity(rs.getString("cCity"));
						courtVO.setCaddr(rs.getString("cAddr"));
						courtVO.setClat(rs.getDouble("cLat"));
						courtVO.setClng(rs.getDouble("cLng"));
						courtVO.setCtel(rs.getString("cTel"));
						courtVO.setCcon(rs.getString("cCon"));
						courtVO.setCimg(rs.getBytes("cImg"));
						courtVO.setCdesc(rs.getString("cDesc"));
						courtVO.setCview(rs.getInt("cView"));
						courtVO.setCstatus(rs.getInt("cStatus"));
						courtVO.setCnew(rs.getDate("cNew"));
						courtVO.setCedit(rs.getDate("cEdit"));
						list.add(courtVO); // Store the row in the list
						
					}

				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
				} finally {
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (con != null) {
						try {
							con.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}
				return list;
			}
			
			//getAllPending
			@Override
			public List<CourtVO> getAllPending() {
				List<CourtVO> list = new ArrayList<CourtVO>();
				CourtVO courtVO = null;

				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					con = ds.getConnection();
					pstmt = con.prepareStatement(GET_ALL_PENDING_STMT);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						courtVO = new CourtVO();
						courtVO.setCid(rs.getInt("cId"));
						courtVO.setCname(rs.getString("cName"));
						courtVO.setCsite(rs.getString("cSite"));
						courtVO.setCfee(rs.getString("cFee"));
						courtVO.setCopen(rs.getString("cOpen"));
						courtVO.setCcity(rs.getString("cCity"));
						courtVO.setCaddr(rs.getString("cAddr"));
						courtVO.setClat(rs.getDouble("cLat"));
						courtVO.setClng(rs.getDouble("cLng"));
						courtVO.setCtel(rs.getString("cTel"));
						courtVO.setCcon(rs.getString("cCon"));
						courtVO.setCimg(rs.getBytes("cImg"));
						courtVO.setCdesc(rs.getString("cDesc"));
						courtVO.setCview(rs.getInt("cView"));
						courtVO.setCstatus(rs.getInt("cStatus"));
						courtVO.setCnew(rs.getDate("cNew"));
						courtVO.setCedit(rs.getDate("cEdit"));
						list.add(courtVO); // Store the row in the list
						
					}

				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
				} finally {
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (con != null) {
						try {
							con.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}
				return list;
			}
		
}