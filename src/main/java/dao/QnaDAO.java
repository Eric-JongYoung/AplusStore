package dao;

import java.sql.SQLException;
import java.util.List;

import dto.QnaDTO;


public interface QnaDAO {
	
	  /**
	  * �Խñ� ��ü �˻�
	  * */
	  List<QnaDTO> selectAll() throws SQLException;
	  
	  /**
	   * qSubject(������)�� �ش��ϴ� �Խñ� �˻�
	   * */
	   QnaDTO selectByqSubject(String qSubject) throws SQLException;
	  
	  /**
	   * ��ȸ �� ����
	   * update QnaDTO set q_hits = q_hits + 1 where q_num=?
	   * */
	  int increamentByReadnum(String qHits) throws SQLException;
	  
	 /**
	 * �Խñ� ���
	 * @return : 1-���Լ��� , 0 - ���Խ���
	  * */
	  int insert(QnaDTO qnaDTO) throws SQLException;
	  
	  /**
	   * qNum(�۹�ȣ), category(��������), emailId(������)�� �ش��ϴ� �Խñ� ����
	   * @return : 1-�������� , 0 - ��������
	   * */
	  int delete(String qNum, String category, String emailId) throws SQLException;
	  
	  /**
	  * �Խñ� ����
	 * @throws SQLException 
	  * */
	  int update(QnaDTO qnaDTO) throws SQLException;

}