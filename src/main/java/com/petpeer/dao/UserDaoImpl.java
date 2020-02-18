package com.petpeer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.petperr.model.Pet;
import com.petperr.model.User;

public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveUser(User u) {
		String query = "insert into uses.user(username,password) values('"+u.getUsername()+"','"+u.getPassword()+"')";
		return jdbcTemplate.update(query);
	}

	public boolean loginUser(final User u, final HttpSession session, final HttpServletResponse resp) {

		String sql = "select * from uses.user where username=? and password=?";
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, u.getUsername());
				ps.setString(2, u.getPassword());
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {

					session.setAttribute("id", rs.getInt("id"));
					return true;
				} else
					return false;
			}
		});

	}
	public List<Pet> getAllPets(){  
		 return jdbcTemplate.query("select * from uses.pets",new ResultSetExtractor<List<Pet>>(){  
		    public List<Pet> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Pet> list=new ArrayList<Pet>();  
		        while(rs.next()){  
		        Pet p=new Pet(); 
		        p.setId(rs.getInt("id"));  
		        p.setPetname(rs.getString("petname"));  
		        p.setPetage(rs.getInt("petage"));
		        p.setPetplace(rs.getString("petplace")); 
		        p.setPetownerid(rs.getInt("petownerid"));
		        list.add(p);  
		        }  
		        return list;  
		        }  
		    });  
		  }
	

	public int addPet(Pet p) {
		String query = "insert into uses.pets(petname,petage,petplace) values('"+p.getPetname()+"','"+p.getPetage()+"','"+p.getPetplace()+"')";
		return jdbcTemplate.update(query);
	}  
	public int buyPet(HttpSession session,int petid,HttpServletRequest req) {
		// TODO Auto-generated method stub

		String qr="update uses.pets set petownerid="+(Integer)session.getAttribute("id")+" where id='"+petid+"'";

		return jdbcTemplate.update(qr);
		}
	
	
	public List<Pet> getuserpets(HttpSession session, HttpServletRequest req){  
		 return jdbcTemplate.query("select * from uses.pets where petownerid="+(Integer) session.getAttribute("id"),new ResultSetExtractor<List<Pet>>(){  
		    public List<Pet> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Pet> list=new ArrayList<Pet>();  
		        while(rs.next()){  
		        Pet p=new Pet(); 
		        p.setId(rs.getInt("id"));  
		        p.setPetname(rs.getString("petname"));  
		        p.setPetage(rs.getInt("petage"));
		        p.setPetplace(rs.getString("petplace")); 
		        p.setPetownerid(rs.getInt("petownerid"));
		        list.add(p);  
		        }  
		        return list;  
		        }  
		    });  
		  }
		

}
