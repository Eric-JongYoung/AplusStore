package dto;

public class AnserDTO {
	private String aNum; //�亯��ȣ
	private String qNum; //������ȣ
	private String aContent; //�亯����
	private int aDate; //�亯��¥
	
	
	public AnserDTO() {}

	public AnserDTO(String aNum, String qNum, String aContent, int aDate) {
		super();
		this.aNum = aNum;
		this.qNum = qNum;
		this.aContent = aContent;
		this.aDate = aDate;
	}

	public String getaNum() {
		return aNum;
	}

	public void setaNum(String aNum) {
		this.aNum = aNum;
	}

	public String getqNum() {
		return qNum;
	}

	public void setqNum(String qNum) {
		this.qNum = qNum;
	}

	public String getaContent() {
		return aContent;
	}

	public void setaContent(String aContent) {
		this.aContent = aContent;
	}

	public int getaDate() {
		return aDate;
	}

	public void setaDate(int aDate) {
		this.aDate = aDate;
	}


}
