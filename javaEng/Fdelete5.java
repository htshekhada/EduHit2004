import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;

public class Fdelete5 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
      HttpSession session = request.getSession(true);
      String s1;
/*      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
          response.sendRedirect("/servlet/Login");
          return;
         }
*/      
         

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");


      out.println("<form>");




      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      String fn=null,fn1=null;

      fn1=request.getParameter("sub");
      String ss=request.getParameter("std");
      
     
     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt.executeUpdate("Delete * from subject where sub_name='"+fn1+"' and std="+ss+" ");
                 con.commit();
                 stmt.executeUpdate("Drop table "+fn1+ss+"");
                 stmt.executeUpdate("Drop table "+fn1+ss+"l");
                 stmt.executeUpdate("Drop table "+fn1+ss+"v");


                 stmt.executeUpdate("Delete * from superuser where subject='"+fn1+"' and std="+ss+" ");
                 stmt.executeUpdate("Delete * from course where sub='"+fn1+"' and std="+ss+" ");
                 stmt.executeUpdate("Delete * from course1 where sub='"+fn1+"' and std="+ss+" ");
                 stmt.executeUpdate("Delete * from chapname where subject='"+fn1+"' and std="+ss+" ");
                 out.println("<center><font face=\"Times New Roman\" size=5 color=red>Subject-</font>"+fn1+"<font face=\"Times New Roman\" size=5 color=red>Of Standard-</font>"+ss+"<font face=\"Times New Roman\" size=5 color=red>Is Successfully Deleted...</font></center>");

          }
     catch (Exception e)          {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                   }

      




      out.println("</form>");

      





      out.println("</body>");
      out.println("</html>");

  }
}
