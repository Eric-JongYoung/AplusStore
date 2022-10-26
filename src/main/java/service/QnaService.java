package service;

import java.sql.SQLException;
import java.util.List;

import dto.QnaDTO;

public interface QnaService {
	
	/**
	 * QnaDAOImpl�� ��� �Խñ� �˻��ϴ� �޼ҵ� ȣ��
	 * */
    List<QnaDTO> selectAll() throws SQLException;
	  
    
	  /**
	   * QnaDAOImpl�� ���ڵ� ���� �޼ҵ� ȣ��
	   * */
	  void insert(QnaDTO qnaDTO) throws SQLException;
		 
		 
	 /**
	   * QnaDAOImpl�� ������ȣ, ��������, �̸���Id�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	   * */
	  void delete(String qNum, String category, String emailId) throws SQLException;
	  
	  
	  /**
	   * QnaDAOImpl�� ���ڵ� ���� �޼ҵ� ȣ��
	   * */
	   void update(QnaDTO qnaDTO) throws SQLException;

	
}
