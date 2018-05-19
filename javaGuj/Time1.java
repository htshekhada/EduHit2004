import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Time1 extends HttpServlet
{

 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");


      
    //  s1=request.getParameter("std");

      

      Connection con=null;
      Statement stmt=null,stmt1=null,stmt2=null;
      ResultSet rs=null;




      out.println("<form>");
      
       

      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1=con.createStatement();
                 stmt2=con.createStatement();

                 stmt1.executeUpdate("delete * from superuser ");
              //   rs = stmt.executeQuery("SELECT DISTINCT std AS s1,class as c1,sub as s2 FROM course;");
                 rs = stmt.executeQuery("SELECT DISTINCT std as s1,class as c1,sub as s2 FROM course union SELECT DISTINCT std as s1,class as c1,sub as s2 FROM course1;");
                 while(rs.next())
                 {
                  String std1 = rs.getString("s1");
                  String class1=rs.getString("c1");
                  String sub1=rs.getString("s2");
                  
                //  stmt1.executeUpdate("delete from superuser where std="+std1+" and class='"+class1+"' and subject='"+sub1+"' ");
                 
                  stmt2.executeUpdate("insert into superuser values("+std1+",'"+class1+"','"+sub1+"',"+request.getParameter(""+std1+class1+sub1+"")+")");
                 }
                 out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=\"6\">5ZL1FFGM ;DI NFB, Y. UIM4  T[ HMJF DF8[ VF5[, 5ZL1FF ;DI A8GG[ NAFJM </font></b></center>");
             }
     catch (Exception e)          {
                                      out.println("<center><font face=\"Lmg-Arun Condensed\" size=\"6\">:JLSFZ[, GYLP</font></center>");
                                      out.println("<pre>");
                                  //    out.println(e.getMessage());
                                      out.println("</pre>");
                                   }

     

     out.println("</form>");


     out.println("</body>");
     out.println("</html>");
    }
}
