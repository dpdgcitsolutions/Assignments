package com.gcit.lms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.LibraryBranch;

public class LibraryBranchDAO extends BaseDAO {

	public void insertLibraryBranch(LibraryBranch lib) throws ClassNotFoundException, SQLException{
		save("insert into tbl_library_branch (branchName) values (?)", new Object[] {lib.getBranchName()});
	}
	
	public void updateLibraryBranch(LibraryBranch lib) throws ClassNotFoundException, SQLException{
		save("update tbl_library_branch set branchName = ?, branchAddress = ? where branchId = ?", new Object[] {lib.getBranchName(), lib.getBranchAddress(), lib.getBranchId()});
	}
	
	public void deleteLibraryBranch(LibraryBranch lib) throws ClassNotFoundException, SQLException{
		save("delete from tbl_publisher where publisherId=?", new Object[] {lib.getBranchId()});
	}
	
	public List<LibraryBranch> readAll() throws ClassNotFoundException, SQLException{
		PreparedStatement pstmt = getConnection().prepareStatement("select * from tbl_library_branch");
		List<LibraryBranch> libs = new ArrayList<LibraryBranch>();
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			LibraryBranch l = new LibraryBranch();
			l.setBranchId(rs.getInt("branchId"));
			l.setBranchName(rs.getString("branchName"));
			l.setBranchAddress(rs.getString("branchAddress"));
			libs.add(l);
		}
		return libs;
	}
	
	@Override
	public List<LibraryBranch> extractData(ResultSet rs) throws SQLException {
		List<LibraryBranch> libs = new ArrayList<LibraryBranch>();
		while(rs.next()){
			LibraryBranch l = new LibraryBranch();
			l.setBranchId(rs.getInt("branchId"));
			l.setBranchName(rs.getString("branchName"));
			l.setBranchAddress(rs.getString("branchAddress"));
			libs.add(l);
		}
		return libs;
	}

}
