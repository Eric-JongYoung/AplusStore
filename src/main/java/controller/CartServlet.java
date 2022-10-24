package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;

import dto.CartDTO;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String,CartDTO> cartList = new HashMap<String, CartDTO>();
    HttpSession session;
    
    @Override
    public void init() throws ServletException {
    	//HttpSession session = super.getSession();
    	super.init();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		session = request.getSession();
		CartController controller = new CartController();
		
		String methodName = request.getParameter("methodName");//delete = ����, addCart = ��ٱ��� �߰�
		String modelNum = request.getParameter("modelNum");
		String modelName = request.getParameter("modelName");
		String modelCount = request.getParameter("modelCount");
		String emailId = (String)session.getAttribute("emailId");
		
		
		//��ٱ��Ͽ��� ����
		if(methodName.equals("delete")) {
			cartList.remove(modelNum);
			
			try {
				controller.delete(request, response);
			} catch (Exception e) {
				//error
				System.out.println(e.getMessage());
			}
			
		} else if(methodName.equals("select")) { //��ٱ��� ����
			if(emailId == null) {
				for(String key : cartList.keySet()) {
					CartDTO cart = cartList.get(key);
					System.out.println(cart);
					
				}
			}
			
			try {
				controller.select(request, response);
				
			} catch (Exception e) {
				//error
				System.out.println(e.getMessage());
			}
			
		} else if(methodName.equals("update")) { //��ٱ��� ����
			
			
			try {
				controller.update(request, response);
			} catch (Exception e) {
				//error
				System.out.println(e.getMessage());
			}

		} else if(methodName.equals("addCart")){ //��ٱ��Ͽ� �߰�
			cartList.put(modelNum, new CartDTO(null, modelNum, modelName, emailId, Integer.parseInt(modelCount))); //īƮ��ȣ(null), �𵨹�ȣ, �𵨸�, �̸���(null), ����
			session.setAttribute("cartList", cartList);
			
			try {
				controller.select(request, response);
			} catch (Exception e) {
				//error
				System.out.println(e.getMessage());
				out.print(e.getMessage());
			}
		}
		
	}

}
