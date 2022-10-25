package dao;

import java.sql.SQLException;
import java.util.List;

import dto.QnaDTO;


public interface QnaDAO {
	/**
	  * ���ڵ� ��ü �˻�
	  * */
	  List<QnaDTO> selectAll() throws SQLException;
	  
	  /**
		  * ���ڵ� ��ü �˻�(������ó��)
	  * */
	   List<QnaDTO> getBoardList(int pageNo) throws SQLException;
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
	   * */
	   QnaDTO selectByModelNum(String qNum) throws SQLException;
	  
	  /**
	   * ��ȸ���� �����ϴ� ���
	   * update QnaDTO set q_hits = q_hits + 1 where q_num=?
	   * */
	  int increamentByReadnum(String qHits) throws SQLException;
	  
	  
	 /**
	 * ���ڵ� ����
	 * @return : 1-���Լ��� , 0 - ���Խ���
	  * */
	  int insert(QnaDTO qna) throws SQLException;
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * @return : 1-�������� , 0 - ��������
	   * */
	  int delete(String qNum, String password) throws SQLException;
	  
	   /**
	    * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	    * @return : 1-�������� , 0 - ��������
	    * */
	  int update(QnaDTO qna) throws SQLException;

}