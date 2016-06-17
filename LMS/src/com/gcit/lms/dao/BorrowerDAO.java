package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Borrower;

public class BorrowerDAO extends BaseDAO {
	
	public void insertBorrower(Borrower bor) throws ClassNotFoundException, SQLException{
		save("insert into tbl_borrower (name, address, phone) values (?,?,?)", new Object[] {bor.getName(), bor.getAddress(), bor.getPhone()});
	}
	
	public void updateBorrower(Borrower bor) throws ClassNotFoundException, SQLException{
		save("update tbl_borrower set name = ?, address = ?, phone = ? where cardNo = ?", new Object[] {bor.getName(), bor.getAddress(), bor.getPhone(), bor.getCardNo()});
	}
	
	public void deleteBorrower(Borrower bor) throws ClassNotFoundException, SQLException{
		save("delete from tbl_borrower where cardNo = ?", new Object[] {bor.getCardNo()});
	}
	
	@Override
	public List<Borrower> extractData(ResultSet rs) throws SQLException {
		List<Borrower> bors = new ArrayList<Borrower>();
		while(rs.next()){
			Borrower b = new Borrower();
			b.setCardNo(rs.getInt("cardNo"));
			b.setName(rs.getString("name"));
			bors.add(b);
		}
		return bors;
	}
}
