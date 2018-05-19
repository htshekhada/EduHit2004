import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Time extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      int et=0;

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");


      

      Connection con=null;
      Statement stmt=null,stmt1=null;
      ResultSet rs=null,rs1=null;




     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Time1\">");
     out.println("<br><center><b><font face=\"Times New Roman\" size=\"4\">Give Exam Time Below...</font></b> </center><br>");


     
     out.println("<center>");
     out.println("<table border=\"4\" width=\"100\">");
     out.println("<tr>");
     out.println("<th><font face=\"Times New Roman\" size=\"4\">Std</font></th>");
     out.println("<th><font face=\"Times New Roman\" size=\"4\">Class</font></th>");
     out.println("<th><font face=\"Times New Roman\" size=\"4\">Subject</font></th>");
     out.println("<th><font face=\"Times New Roman\" size=\"4\">Exam Time In Minute</font></th>");
     out.println("</tr>");

     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1= con.createStatement();
                 rs = stmt.executeQuery("SELECT DISTINCT std,class,sub FROM course union SELECT DISTINCT std,class,sub FROM course1;");
                 int nRows = 0;
                 while(rs.next()) {
                                            
                                    String std1 = rs.getString("std");
                                    String class1=rs.getString("class");
                                    String sub1=rs.getString("sub");

                                    et=0;
                                    rs1 = stmt1.executeQuery("SELECT examtime as etime FROM superuser where std="+std1+" and subject='"+sub1+"' and class='"+class1+"';");
                                    if(rs1.next()){
                                                   et = rs1.getInt("etime");
                                                   }
                                    out.println("<tr>");
                                    out.println("<td>");
                                    out.println(""+std1+"");
                                    out.println("</td>");
                                    out.println("<td>");
                                    out.println(""+class1+"");
                                    out.println("</td>");
                                    out.println("<td>");
                                    out.println(""+sub1+"");
                                    out.println("</td>");
                                    out.println("<td>");
                                    out.println("<input type=\"text\" name=\""+std1+class1+sub1+"\" value=\""+et+"\">");
                                    out.println("</td>");
                                    out.println("</tr>");
                                   }
                 out.println("</table>");
                 out.println("</center>");

             }
     catch (Exception e)          {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                   }


     out.println("<br>");
     out.println("<center>");
     out.println("<input  type=\"submit\" value=\"Ok\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 18pt\">");
     out.println("</center>");
     out.println("</form>");

  //   out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/Supmain\">");
  //   out.println("<center>Back Home</center>");
  //   out.println("</a>");


     out.println("</body>");
     out.println("</html>");
    }

}














