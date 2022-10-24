package service;

import java.sql.SQLException;

import java.util.List;

import dto.CartDTO;
import dto.ItemDTO;

public interface CartService {
	
	
	/**
	 * ��ٱ��� ��ȸ
	 */
	List<CartDTO> select(String emailId) throws SQLException;
	
	
	
	/**
	 * ��ٱ��� �߰�
	 */
	void insert(String modelNum, String emailId) throws SQLException;
	
	
	/**
	 * ��ٱ��� ����
	 */
	void delete(String emailId, String modelNum) throws SQLException;
	
	
	
	/**
	 * ��ٱ��� ����
	 */
	void update(String cartNum, int modelCount) throws SQLException;
	
}
