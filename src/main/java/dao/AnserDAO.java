package dao;

import java.sql.SQLException;

import dto.AnserDTO;

public interface AnserDAO {
	
	 	 /**
		 * �亯 ���
		 * @return : 1-��ϼ��� , 0 - ��Ͻ���
		  * */
		  int insert(AnserDTO anserDTO) throws SQLException;
		  
		  /**
		   * �亯��ȣ�� �ش��ϴ� �亯 ����
		   * @return : 1-�������� , 0 - ��������
		   * */
		  int delete(String aNum) throws SQLException;
		  
		  /**
		  * �亯��ȣ�� �ش��ϴ� �亯 ����
		  * */
		  int update(AnserDTO anserDTO)throws SQLException;
		  
		  /**
		   * ������ȣ�� �ش��ϴ� �亯 �˻�
		   * */
		  AnserDTO selectByqNum(String qNum) throws SQLException;

}
