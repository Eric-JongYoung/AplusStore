package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.QnaDTO;
import util.DbUtil;

public class QnaDAOImpl implements QnaDAO {
	private Properties proFile = new Properties();
	
	public QnaDAOImpl() {
		try {
			//dbQuery�� �غ��� ~.properties������ �ε��ؼ� Properties �ڷᱸ���� �����Ѵ�.
			//���� ������Ʈ�� ��Ÿ��(����)�� ��, �� ������ ����ɶ� classes������ ��ġ��, �������� �����ͼ� ��θ� �����ؾ��Ѵ�.
			InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			proFile.load(is);
			
			System.out.println("QNA.select = " +proFile.getProperty("QNA.select"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//�Խñ� ��ü �˻�
	@Override
	public List<QnaDTO> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<QnaDTO> list = new ArrayList<QnaDTO>();
		
		//select * from QnaDTO(�ʵ��) order by question(���̺��) desc -��ü��ȸ
		String sql= "select * from QnaDTO order by question desc";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				QnaDTO qnaDTO = 
				new QnaDTO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				
			   list.add(qnaDTO);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	

	//��ȸ �� ���� ???
	@Override
	public int increamentByReadnum(String qNum) throws SQLException {
		Connection con=null;
	      PreparedStatement ps=null;
	      int result=0;
	      
	      //update QNA set readnum=readnum+1 where qNum=?
	      String sql= "update QNA set readnum=readnum+1 where qNum=?";
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement("update question set readnum=readnum+1 where question=?"); //question:���̺��
	         ps.setString(1, qNum);
	         result = ps.executeUpdate();
	      }finally {
	         DbUtil.dbClose(con, ps);
	      }
	      return result;
	}
	

	//�Խñ� �Է�
	@Override
	public int insert(QnaDTO qnaDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		//insert into QnaDTO values(?,?,?,?,?,sysdate,0,?,?);
		String sql= "insert into QnaDTO values(?,?,?,?,?,sysdate,0,?,?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, qnaDTO.getqNum());
			ps.setString(2, qnaDTO.getCategory());
			ps.setString(3, qnaDTO.getEmailId());
			ps.setString(4, qnaDTO.getqSubject());
			ps.setString(5, qnaDTO.getqContent());
			ps.setString(6, qnaDTO.getqDate());
			ps.setInt(7, qnaDTO.getqHits());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	

	//qNum, emailId�� �ش��ϴ� �Խñ� ����
	@Override
	public int delete(String qNum, String category, String emailId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		//delete from question(���̺��) where qNum=? and emailId=?;
		String sql= "delete from question where qNum=? and emailId=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, qNum);
			ps.setString(2, category);
			ps.setString(3, emailId);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	

	//�Խñ� ����(������ȣ, ��������, �������� ����)
	@Override
	public int update(QnaDTO qnaDTO) throws SQLException{
		  PreparedStatement ps = null;
		  Connection con = null;
		  int result=0;
		  String sql= proFile.getProperty("QNA.update");
		  try {
		   con = DbUtil.getConnection();
		   //QNA.update= update QnaDTO set qNum=?, qSubject=?, qContent=?;
		   ps = con.prepareStatement("update QnaDTO set qNum=?, qSubject=?, qContent=?");
		   
		   ps = con.prepareStatement(sql);
		   ps.setString(1, qnaDTO.getqNum());
			ps.setString(2, qnaDTO.getCategory());
			ps.setString(3, qnaDTO.getEmailId());
			ps.setString(4, qnaDTO.getqSubject());
			ps.setString(5, qnaDTO.getqContent());
			ps.setString(6, qnaDTO.getqDate());
			ps.setInt(7, qnaDTO.getqHits());
		   
			result = ps.executeUpdate();
			}finally {
				DbUtil.dbClose(con, ps);
			}
			return result;
	}
	

	//�� ���� �ش��ϴ� �Խñ� �˻�
	@Override
	public QnaDTO selectByqSubject(String qSubject) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		QnaDTO qnaDTO = null;
		
		String sql= proFile.getProperty("select * from QnaDTO where qSubject=?");
		//select * from QnaDTO where qSubject=?
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(4, qSubject);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				qnaDTO = new QnaDTO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return qnaDTO;
	}


}//class��
