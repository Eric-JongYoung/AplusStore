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
	   * QnaDAOImpl�� ������ �ش��ϴ� �Խñ� �˻��ϴ� �޼ҵ� ȣ��
	   * @param : boolean flag - ��ȸ�� ���� ���θ� �Ǻ��ϴ� �Ű�������(true�̸� ��ȸ������ / false�̸� ��ȸ�� ���� ����)
	   * */
	  QnaDTO selectByqSubject(QnaService qnaService, boolean b)
			throws SQLException;
		 
		 
	 /**
	   * QnaDAOImpl�� ������ȣ, ��������, �̸���Id�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	   * */
	  void delete(String qNum, String category, String emailId) throws SQLException;
	  
	  
	  /**
	   * QnaDAOImpl�� ���ڵ� ���� �޼ҵ� ȣ��
	   * */
	   void update(QnaDTO qnaDTO) throws SQLException;


	
}
