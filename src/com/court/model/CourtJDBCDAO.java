package com.court.model;

import java.util.*;
import java.io.*;
import java.sql.*;
//import org.apache.commons.io.*;
import java.sql.Date;

public class CourtJDBCDAO implements CourtDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "scott";
	String passwd = "tiger";

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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_DELETE);

			pstmt.setInt(1, 2);
			pstmt.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
			pstmt.setInt(3, cid);
			
			pstmt.executeUpdate();
			System.out.println("刪除cId: " + cid);
			System.out.println("++++++++++++++++++");

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, cid);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// courtVO 也稱為 Domain objects
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
//				courtVO.setCOURT_PIC(rs.getBytes("COURT_PIC"));
				courtVO.setCdesc(rs.getString("cdesc"));
				courtVO.setCview(rs.getInt("cview"));
				courtVO.setCstatus(rs.getInt("cstatus"));
				courtVO.setCnew(rs.getDate("cnew"));
				courtVO.setCedit(rs.getDate("cedit"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// courtVO 也稱為 Domain objects
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

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_VIEW);

			pstmt.setInt(1, courtVO.getCview());
			pstmt.setInt(2, courtVO.getCid());
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	
	//
	@Override
	public void validate(Integer cid) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_VALIDATE);

			pstmt.setInt(1, 1);
			pstmt.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
			pstmt.setInt(3, cid);
			
			pstmt.executeUpdate();
			System.out.println("審核通過cId: " + cid);
			System.out.println("++++++++++++++++++");

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_VALID_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// courtVO 也稱為 Domain objects
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

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_DELETED_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// courtVO 也稱為 Domain objects
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

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_PENDING_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// courtVO 也稱為 Domain objects
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

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	
	public static void main(String[] args) {

		CourtJDBCDAO dao = new CourtJDBCDAO();

		// 新增
		CourtVO courtVO1 = new CourtVO();
		courtVO1.setCname("乒乓島菁英桌球館");
		courtVO1.setCsite("http://www.pingpongisland.com.tw/");
		courtVO1.setCfee("免費");
		courtVO1.setCopen("每天09:00–21:00");
		courtVO1.setCcity("台北市");
		courtVO1.setCaddr("大安區安和路一段137號");
		courtVO1.setClat(new Double(25.034110));
		courtVO1.setClng(new Double(121.552735));
		courtVO1.setCtel("02-27090107");
		courtVO1.setCcon("陳先生");
		//setCimg
		try {
			
			InputStream in = new FileInputStream("C:/image/Logo.jpg");
			byte[] cPic = new byte[in.available()];
			in.read(cPic);
			in.close();
			courtVO1.setCimg(cPic);
//			byte[] bytes = IOUtils.toByteArray(new FileInputStream("C:/image/Logo.jpg"));
//			courtVO1.setCOURT_PIC(bytes);
		} catch (FileNotFoundException e) {
			// in = new FileInputStream("C:/image/logon.png");
			e.printStackTrace();
		} catch (IOException e) {
			// byte[] cPic = new byte[in.available()];
			e.printStackTrace();
		} finally{
			
		}
		courtVO1.setCdesc("乒乓島夏令營熱烈招生中");
		courtVO1.setCview(new Integer(0));
		courtVO1.setCstatus(new Integer(0));
		courtVO1.setCnew(new java.sql.Date(new java.util.Date().getTime()));
		courtVO1.setCedit(java.sql.Date.valueOf("2015-05-05"));
	
		dao.insert(courtVO1);
		
		

		// 修改
		CourtVO courtVO2 = new CourtVO();
		courtVO2.setCid(1002);
		courtVO2.setCname("吳永志2");
		courtVO2.setCsite("MANAGER2");
		courtVO2.setCfee("MANAGER2");
		courtVO2.setCopen("MANAGER2");
		courtVO2.setCcity("MANAGER2");
		courtVO2.setCaddr("MANAGER2");
		courtVO2.setClat(new Double(33.33));
		courtVO2.setClng(new Double(22.22));
		courtVO2.setCtel("MANAGER2");
		courtVO2.setCcon("MANAGER2");
//		courtVO2.getCOURT_PIC("MANAGER2");
		courtVO2.setCdesc("MANAGER2");
		courtVO2.setCstatus(new Integer(1));
		courtVO2.setCedit(new java.sql.Date(new java.util.Date().getTime()));
		
		dao.update(courtVO2);
		
		// 刪除
		dao.delete(1002); //OK 執行成功

		// 查詢
		CourtVO courtVO3 = dao.findByPrimaryKey(1001);

		System.out.print(courtVO3.getCid() + ",");
		System.out.print(courtVO3.getCname() + ",");
		System.out.print(courtVO3.getCsite() + ",");
		System.out.print(courtVO3.getCfee() + ",");
		System.out.print(courtVO3.getCopen() + ",");
		System.out.print(courtVO3.getCcity() + ",");
		System.out.print(courtVO3.getCaddr() + ",");
		System.out.print(courtVO3.getClat() + ",");
		System.out.print(courtVO3.getClng() + ",");
		System.out.print(courtVO3.getCtel() + ",");
		System.out.print(courtVO3.getCcon() + ",");
		System.out.print(courtVO3.getCdesc() + ",");
		System.out.print(courtVO3.getCstatus() + ",");
		System.out.print(courtVO3.getCnew() + ",");
		System.out.print(courtVO3.getCedit());
		System.out.println("");
		System.out.println("Find by PK結束");
		System.out.println("------------------------------------");

		// 查詢
		List<CourtVO> list = dao.getAll();
		for (CourtVO aCourt : list) {
			System.out.print(aCourt.getCid() + ",");
			System.out.print(aCourt.getCname() + ",");
			System.out.print(aCourt.getCsite() + ",");
			System.out.print(aCourt.getCfee() + ",");
			System.out.print(aCourt.getCopen() + ",");
			System.out.print(aCourt.getCcity() + ",");
			System.out.print(aCourt.getCaddr() + ",");
			System.out.print(aCourt.getClat() + ",");
			System.out.print(aCourt.getClng() + ",");
			System.out.print(aCourt.getCtel() + ",");
			System.out.print(aCourt.getCcon() + ",");
			System.out.print(aCourt.getCdesc() + ",");
			System.out.print(aCourt.getCstatus() + ",");
			System.out.print(aCourt.getCnew() + ",");
			System.out.print(aCourt.getCedit() + ",");
			System.out.println();
			System.out.println("**************************");
			System.out.println();			
			
			
		}
	}
}