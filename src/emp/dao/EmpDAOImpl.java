package emp.dao;

import static fw.DBUtil.close;
import static fw.EmpQuery.EMP_INSERT;
import static fw.EmpQuery.EMP_LIST;
import static fw.EmpQuery.EMP_DELETE;
import static fw.EmpQuery.EMP_READ;
import static fw.EmpQuery.EMP_SEARCH1;
import static fw.EmpQuery.EMP_SEARCH2;
import static fw.EmpQuery.EMP_SEARCH3;
import static fw.EmpQuery.EMP_UPDATE;
import static fw.EmpQuery.EMP_LOGIN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emp.dto.EmpDTO;

public class EmpDAOImpl implements EmpDAO{
	public int insert(EmpDTO user, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(EMP_INSERT);
		ptmt.setString(1, user.getId());
		ptmt.setString(2, user.getPass());
		ptmt.setString(3, user.getName());
		ptmt.setString(4, user.getAddr());
		ptmt.setString(5, user.getGrade());
		ptmt.setInt(6, user.getPoint());
		ptmt.setString(7, user.getDeptno());
		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public ArrayList<EmpDTO> getMemberList(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		
		//user ��ü ����� ���� �ڷᱸ��
		ArrayList<EmpDTO> userlist = new ArrayList<EmpDTO>();
		System.out.println("dao��û");
		
		//�ϳ��� user�� ��� ���ؼ� ��ü ���� - ���ڵ尡 ��ȸ�Ǹ� ���ڵ� �ϳ��� ���� ������ ���̹Ƿ�
		//                       while�� �ȿ��� �����ؾ� �Ѵ�.
		EmpDTO user = null;
		PreparedStatement ptmt = 
			     con.prepareStatement(EMP_LIST);
		ResultSet rs = ptmt.executeQuery(); 
		while(rs.next()){
			//���ڵ� �ϳ��� Vector�� ��ȯ
			//���ڵ带 ���� ���͸� ���� - Vector�� �ϳ��� Ÿ�Ը� �䱸�ϹǷ� ��ü �÷��� String
			//���� ��ȯ�ؼ� Vector�� ��´�.
			/*System.out.println(rs.getString(1));*/
			
			
			//���ڵ� �ϳ��� ���� dto��ü�� ��ȭ�ϴ� �۾�
			user = new EmpDTO();
					
			user = new EmpDTO(rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getDate(5),
					rs.getString(6), rs.getInt(7), rs.getString(8));
			/*user.setId(rs.getString(1));
			user.setPass(rs.getString(2));
			user.setName(rs.getString(3));
			user.setAddr((rs.getString(4)));
			user.setHiredate(rs.getDate(5));
			user.setGrade(rs.getString(6));
			user.setPoint(rs.getInt(7));
			user.setDeptno(rs.getString(8));*/
			//���ڵ带 Vector�� ��ȯ�ϴ� �۾� ����
			//�ۼ��� ���ڵ带 Vector�� ����
			//��ȯ�� �Ϸ�Ǹ� ArrayList�߰�
			userlist.add(user);
		}
		System.out.println("ArrayList�� ����=>"+userlist.size());
		System.out.println(userlist);
		close(rs);
		close(ptmt);
		return userlist;		
	}
	public int delete(String id, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(EMP_DELETE);
		ptmt.setString(1, id);
		result = ptmt.executeUpdate();
		close(ptmt);
		
		return result;
	}

	@Override
	public EmpDTO read(String id, Connection con) throws SQLException {
		
		EmpDTO user = null;
		PreparedStatement ptmt = con.prepareStatement(EMP_READ);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()){
			System.out.println("�������ִ�.~~~~~~~~~~~");
			user = new EmpDTO(rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getDate(5),
					rs.getString(6), rs.getInt(7), rs.getString(8));
		}
		close(ptmt);
		
		return user;
	}

	@Override
	public ArrayList<EmpDTO> search(String column, String search, String pass, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		//user ��ü ����� ���� �ڷᱸ��
				System.out.println(column+","+search);
				ArrayList<EmpDTO> usersearch = new ArrayList<EmpDTO>();
				System.out.println("dao��û");
				
				//�ϳ��� user�� ��� ���ؼ� ��ü ���� - ���ڵ尡 ��ȸ�Ǹ� ���ڵ� �ϳ��� ���� ������ ���̹Ƿ�
				//                       while�� �ȿ��� �����ؾ� �Ѵ�.
				EmpDTO user = null;
				/*String sql = "select * from kitriemp where "+column+" like ?";*/
				/*String sql = "select * from kitriemp where "+column
						+"=? and pass = ?";*/
				
				/*String sql = 
						"select * from kitriemp where "+column+"='"
				        +search+"' and pass='"+pass+"'";*/
				/*Statement ptmt = 
					     con.createStatement();*/
				/*PreparedStatement ptmt = 
					     con.prepareStatement(EMP_SEARCH+column+"=?");*/
				String sql = "";
				if(column.equals("name")){
					sql = EMP_SEARCH1;
				}else if(column.equals("addr")){
					sql = EMP_SEARCH2;
				}else{
					sql = EMP_SEARCH3;
				}
				PreparedStatement ptmt = 
						con.prepareStatement(sql);
				ptmt.setString(1, "%"+search+"%");
				/*ptmt.setString(1, column);*/
				/*ptmt.setString(1, search);*/
				/*ptmt.setString(1, search);
				ptmt.setString(2, pass);*/
				ResultSet rs = ptmt.executeQuery(); 
				while(rs.next()){
					//���ڵ� �ϳ��� Vector�� ��ȯ
					//���ڵ带 ���� ���͸� ���� - Vector�� �ϳ��� Ÿ�Ը� �䱸�ϹǷ� ��ü �÷��� String
					//���� ��ȯ�ؼ� Vector�� ��´�.
					/*System.out.println(rs.getString(1));*/
					
					
					//���ڵ� �ϳ��� ���� dto��ü�� ��ȭ�ϴ� �۾�
					user = new EmpDTO();
							
					user = new EmpDTO(rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getDate(5),
							rs.getString(6), rs.getInt(7), rs.getString(8));
					usersearch.add(user);
				}
				System.out.println("ArrayList�� ����=>"+usersearch.size());
				System.out.println(usersearch);
				close(rs);
				close(ptmt);
				
				return usersearch;		
	}

	@Override
	public int update(EmpDTO user, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(EMP_UPDATE);
		ptmt.setString(1, user.getAddr());
		ptmt.setInt(2, user.getPoint());
		ptmt.setString(3, user.getGrade());
		ptmt.setString(4, user.getId());
		
		result = ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public EmpDTO login(String id, String pass, Connection con) throws SQLException {
		EmpDTO login = null;
		System.out.println("dao��û");
	
		PreparedStatement ptmt = 
			     con.prepareStatement(EMP_LOGIN);
		ptmt.setString(1, id);
		ptmt.setString(2, pass);
		ResultSet rs = ptmt.executeQuery(); 
		if(rs.next()){
			login = new EmpDTO(rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getDate(5),
					rs.getString(6), rs.getInt(7), rs.getString(8));
		}
		close(rs);
		close(ptmt);
		return login;
	}
}