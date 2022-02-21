

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SaveServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        String empid=request.getParameter("empid");
        
        int empid1=Integer.parseInt(empid);
        
        String empname=request.getParameter("empname");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
     
        Emp e=new Emp();  
        e.setId(empid1);
        e.setName(empname);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country); 

        int status=EmpDao.save(e);  
        if(status>0)
        {  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else
        {  
            out.println("Sorry! unable to save record");  
        }  
         out.close();  
    }  
 

}

