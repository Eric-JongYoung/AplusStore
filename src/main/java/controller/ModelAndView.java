package controller;

<<<<<<< HEAD
=======
/**
 * 각 Controller의 구현체들이 실행된 후 이동해야하는 페이지 정보와 
 * 이동방식에 대한 속성을 관리하는 객체
 **/
>>>>>>> hyogyeong_main

public class ModelAndView {
	private String viewName;//酉� �씠由�
	private boolean isRedirect;// �씠�룞諛⑹떇(true �씠硫� redirect, false �씠硫� forward 諛⑹떇)
	
	public ModelAndView() {}
	
	public ModelAndView(String viewName) {
		this.viewName = viewName;
	}

	public ModelAndView(String viewName, boolean isRedirect) {
		this(viewName);
		this.isRedirect = isRedirect;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
	
	

}
