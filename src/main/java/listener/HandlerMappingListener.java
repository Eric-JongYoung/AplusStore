package listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import controller.Controller;



/**
 * 
 * ������ start�ɶ� ������ Controller�� ����ü�� �̸� �����ؼ� Map���� 
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {

   
    public void contextInitialized(ServletContextEvent e)  { 
        Map<String, Controller> map = new HashMap<String, Controller>();
        Map<String, Class<?> > clzMap = new HashMap<String, Class<?>>();
        
        //~.properties���� �ε�
       ResourceBundle rb1 = ResourceBundle.getBundle("ajaxMapping"); //resources/ajaxMapping.properties
       ResourceBundle rb2 = ResourceBundle.getBundle("frontMapping"); //resources/frontMapping.properties
       
        try {
        	
	        for(String key : rb1.keySet()) {
	        	String value = rb1.getString(key);
	        	//System.out.println(key +" = " + value );
	        	
	        	//String�� ���ڿ��� Controller�� ��ü�� �����ؾ��Ѵ�!!!
	        	//Class<?>�� � ��ü�� ������ �ִ� �ʵ�, ������, �޼ҵ��� ������ �������� �����ü� �ֵ��� �����ִ� ��ü�̴� - reflection ����
	    		//reflection ������ �������� �� ���൵�߿� �ʿ��� ��ü�� �����ϰ� �����ϰ� �� ��ü�� ������ �ִ� �����ڳ� �޼ҵ带 
	    		//�������� ȣ�����ټ� �ֵ��� �ϴ� ������ reflection�̶�� �ϰ� �ڹٿ��� �� ������ ������ ���� API�� Class<?> �̴�.
	
	        	Class<?> className = Class.forName(value);
	        	Controller controller = (Controller)className.getDeclaredConstructor().newInstance();
	        	
	        	System.out.println("controller = " + controller);
	        	
	        	map.put(key, controller); 
	        	clzMap.put(key, className);
	        }
	        
	        for(String key : rb2.keySet()) {
	        	String value = rb2.getString(key);
	        	//System.out.println(key +" = " + value );
	        	
	        	//String�� ���ڿ��� Controller�� ��ü�� �����ؾ��Ѵ�!!!
	        	//Class<?>�� � ��ü�� ������ �ִ� �ʵ�, ������, �޼ҵ��� ������ �������� �����ü� �ֵ��� �����ִ� ��ü�̴� - reflection ����
	    		//reflection ������ �������� �� ���൵�߿� �ʿ��� ��ü�� �����ϰ� �����ϰ� �� ��ü�� ������ �ִ� �����ڳ� �޼ҵ带 
	    		//�������� ȣ�����ټ� �ֵ��� �ϴ� ������ reflection�̶�� �ϰ� �ڹٿ��� �� ������ ������ ���� API�� Class<?> �̴�.
	
	        	Class<?> className = Class.forName(value);
	        	Controller controller = (Controller)className.getDeclaredConstructor().newInstance();
	        	
	        	System.out.println("controller = " + controller);
	        	
	        	map.put(key, controller); 
	        	clzMap.put(key, className);
	        }
	        
        }catch (Exception ex) {
			ex.printStackTrace();
		}
        
        //��� �������� map�� ����Ҽ� �ֵ��� ServletContext������ �����Ѵ�.
        ServletContext application = e.getServletContext();
        application.setAttribute("ajaxMap", map);
        application.setAttribute("ajaxClzMap", clzMap);
        
    	application.setAttribute("map", map);
    	application.setAttribute("path", application.getContextPath() ); //${path}
       
    }//�޼ҵ峡
    
	
}//classEnd







