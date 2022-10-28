package controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 사용자의 모든 요청을 처리할 진입점 Controller이다(FrontController의 역할한다)
 */

@WebServlet(urlPatterns = "/ajax" , loadOnStartup = 1)
public class AjaxDispatcherServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
     Map<String, AjaxController> ajaxMap;
     Map<String, Class<?>> ajaxClzMap;
    @Override
   public void init() throws ServletException {
      //map = (Map<String, Controller>)super.getServletContext().getAttribute("map");
      
      ServletContext application = super.getServletContext();
      Object obj = application.getAttribute("ajaxMap");
      ajaxMap = (Map<String, AjaxController>)obj;
      
      ajaxClzMap = (Map<String, Class<?>>)super.getServletContext().getAttribute("ajaxClzMap");
      
   }
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String key = request.getParameter("key"); //customer
      String methodName = request.getParameter("methodName"); //idCheck , insert , selectAll
      
      System.out.println("key = " + key+", methodName = " + methodName);
      try {
         Class<?> clz = ajaxClzMap.get(key);
         Method method = clz.getMethod(methodName, HttpServletRequest.class , HttpServletResponse.class);
         
         AjaxController controller = ajaxMap.get(key);
         method.invoke(controller, request , response);
         
      }catch (Exception e) {
         e.printStackTrace();
      }

   }//service 메소드 끝

}








