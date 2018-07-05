package com.cg.ma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.ma.dto.Mobiledto;
import com.cg.ma.exception.MobileException;

public class MobiledaoImpl implements Mobiledao{

	@Override
	public int insertMobile(Mobiledto mobile) throws MobileException {
		String sql="Insert into mobiles(mobileid,name,price,quantity) values( mobid_seq.nextval,"
				+ "?,?,?)";
		String sql2="select mobid_seq.currval from dual";
		int rows=0,mobileid=0;
		Connection con=DBUtil.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, mobile.getMname());
			ps.setDouble(2, mobile.getPrice());
			ps.setInt(3, mobile.getQuantity());
			rows=ps.executeUpdate();
			
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(sql2);
			while(rs.next()) {
				mobileid=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			throw new MobileException("errior occured while inserting"+e.getMessage());
			
		}
		
		return mobileid;
	}

	@Override
	public List<Mobiledto> getAllMobiles() throws MobileException {
      String sql="select * from mobiles";
      List<Mobiledto> mlist=new ArrayList<Mobiledto>();
   Connection con=DBUtil.getConnection();
      try {
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(sql);
		while(rs.next()) {
		   int MobileId=rs.getInt("mobileid");
		   String Name=rs.getString("name");
		   int Price=rs.getInt("price");
		   int Quantity=rs.getInt("quantity");
		   Mobiledto dto=new Mobiledto();
		   dto.setMobileid(MobileId);
		   dto.setMname(Name);
		   dto.setPrice(Price);
		   dto.setQuantity(Quantity);
		   mlist.add(dto);
		}
		
	} catch (SQLException e) {
		throw new MobileException("Problem in fetching mobile detils"+e.getMessage());
		
	}
		
		return mlist;
	}

	@Override
	public Mobiledto searchMobile(int mid) throws MobileException {
        String sql1="select * from mobiles where mobileid="+mid;
        Mobiledto dt=new Mobiledto();
        
        Connection con=DBUtil.getConnection();
        try {
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(sql1);
			while(rs.next()) {
				
				dt.setMobileid(rs.getInt(1));
				dt.setMname(rs.getString(2));
				dt.setPrice(rs.getInt(3));
				dt.setQuantity(rs.getInt(4));
				
				
			}
		} catch (SQLException e) {
			throw new MobileException("error Occured"+e.getMessage());
		}

        return dt;
	}

}

