package service;

import java.sql.SQLException;
import java.util.List;
import dao.QnaDAO;
import dao.QnaDAOImpl;
import dto.QnaDTO;

public class QnaServiceImpl implements QnaService {
	private QnaDAO qnaDAO = new QnaDAOImpl();

	//�˻�
	@Override
	public List<QnaDTO> selectAll() throws SQLException {
		List<QnaDTO>  list = qnaDAO.selectAll();
		return list;
	}

	//���
	@Override
	public void insert(QnaDTO qnaDTO) throws SQLException {
		int result = qnaDAO.insert(qnaDTO);
		if(result==0)throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");

	}

	//����(������ȣ, ��������, �̸���Id)
	@Override
	public void delete(String qNum, String category, String emailId) throws SQLException {
		QnaDTO dbQna = qnaDAO.selectByqSubject(qNum);
		
		if(dbQna == null) {
			throw new SQLException("������ȣ ������ ���� �Ҽ������ϴ�.");
			
		}else if(!dbQna.getCategory().equals(category)) {
			throw new SQLException("���������� �ٽ� Ȯ�����ּ���.-��������");
			
		}else if(!dbQna.getEmailId().equals(emailId)) {
			throw new SQLException("emailId�� �ٽ� Ȯ�����ּ���.-��������");
		}
		
		 if(qnaDAO.delete(qNum, category, emailId) == 0) {
			 throw new SQLException("�������� �ʾҽ��ϴ�.");
		 }
		 
	}


	//����
	@Override
	public void update(QnaDTO qnaDTO) throws SQLException {
		//���޵� ����� DB������� ����� ��ġ�ϴ��� ���� üũ�Ѵ�.
		QnaDTO dbQna = qnaDAO.selectByqSubject(qnaDTO.getqNum());
		
		if(dbQna == null) {
			throw new SQLException("�𵨹�ȣ ������ �����Ҽ� �����ϴ�.");
			
		/*}else if(!dbElec.getPassword().equals(qnaDTO.getPassword())) {
			throw new SQLException("��й�ȣ�� �ٽ� Ȯ�����ּ���.-��������");*/
		}
		
		if(qnaDAO.update(qnaDTO) ==0) {
			throw new SQLException("���������ʾҽ��ϴ�.");
		}

	}

}
