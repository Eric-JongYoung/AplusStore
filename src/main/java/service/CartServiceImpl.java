package service;

import java.sql.SQLException;
import java.util.List;

import dao.CartDAO;
import dao.CartDAOImpl;
import dto.CartDTO;
import dto.ItemDTO;

public class CartServiceImpl implements CartService {
	CartDAO dao = new CartDAOImpl();
	
	@Override
	public void insert(String modelNum, String emailId) throws SQLException {
		int result = dao.selectToInsert(modelNum, emailId);
		
		if(result <= 0) {
			throw new SQLException("��ٱ��� �߰��� �����߽��ϴ�");
		}
	}

	@Override
	public void delete(String emailId, String modelNum) throws SQLException {
		int result = dao.delete(emailId, modelNum);

		if(result<=0) {
			throw new SQLException("��ٱ��� ������ �����߽��ϴ�");
		}
	}

	@Override
	public void update(String cartNum, int modelCount) throws SQLException {
		int result = dao.update(cartNum, modelCount);

		if(result<=0) {
			throw new SQLException("��ٱ��� ������ �����߽��ϴ�");
		}
	}

	@Override
	public List<CartDTO> select(String emailId) throws SQLException {
		List<CartDTO> list = dao.select(emailId);
		
		if(list == null) {
			throw new SQLException("��ٱ��� �˻��� �����߽��ϴ�");
		}
		
		
		return list;
	}

}
