import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Coursesub extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      String s1=null,c1=null;

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(133,213,135)\">");


      
      s1=request.getParameter("std");
      c1=request.getParameter("class");

      


      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;




     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Coursechmax\" target=\"bottom\">");
     out.println("<input type=\"hidden\" name=\"std\" value=\""+s1+"\">");
     out.println("<input type=\"hidden\" name=\"class\" value=\""+c1+"\">");
     out.println("<center>");
     out.println("<center><strong><font face=\"Lmg-Arun Condensed\" size=\"6\">lJQFI</font>:&nbsp;");

     
     out.println("&nbsp; </strong>");

     out.println("<select  name=\"subject\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\">");
     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 rs = stmt.executeQuery("SELECT sub_name AS c1 FROM subject where std="+s1+";");
                 int nRows = 0;
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }

             }
     catch (Exception e)          {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                   }
     out.println("</center>");
     out.println(" </select> </strong>");


     out.println("&nbsp;&nbsp;");
     out.println("<input  type=\"submit\" value=\"VMS[\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 1em\">&nbsp;&nbsp; ");


     out.println("</form>");
     out.println("</body>");
     out.println("</html>");
    }
}



