import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.*;


public class Rev3s extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      String subject=null,lno=null;

      HttpSession session = request.getSession(true);      
      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
//          response.sendRedirect("/servlet/Login");
//          return;
         }


      out.println("<html>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");

      String std=null;
      std=request.getParameter("std");



      out.println("<body bgcolor=\"rgb(133,213,135)\">");

////**********************Inserting into subject table**********
       String  l1,q1,s1,w1,w2,r1,s2;


//             GraphicsEnvironment gEnv =GraphicsEnvironment.getLocalGraphicsEnvironment();
//             String envf[] =gEnv.getAvailableFontFamilyNames();


       ResultSet rs=null;
       Connection con=null;
       Statement stmt=null,stmt1=null;
       out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Rev3c\" target=\"topright\">");

     out.println("<strong><center><font face=\"Times New Roman\">Que-3</font></center></strong> ");
     out.println("</center><strong>");     // Select One Option Out Of Three.


      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();


     

    
     out.println("<center><strong><font face=\"Times New Roman\">Sub</font>");
     out.println(" <strong>");
     

      out.println("<select  name=\"subject\" size=\"1\">");



                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();

                 rs = stmt.executeQuery("SELECT DISTINCT sub_name AS c1 FROM subject where std="+std+";");
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }

             }
      catch (Exception e) {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                       }


   out.println(" </select> </strong>");
   out.println("&nbsp;");


/*
     out.println("<strong>Lesson No:  </strong>");
     out.println(" <strong>");
     
     out.println("<input type=\"text\" name=\"lno\" size=\"5\" ></strong>");
*/

//     out.println(" </center>");

  //   out.println("<input type=\"radio\" value=\"V1\" checked name=\"r1\">Optional<br> ");
 //    out.println("<input type=\"radio\" value=\"V2\"  name=\"r1\">Short<br> ");
 //    out.println("<input type=\"radio\" value=\"V3\"  name=\"r1\">Long<br> ");
 //    out.println("<input type=\"radio\" value=\"V4\"  name=\"r1\">Joint<br> ");

      out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\"1\">");
      out.println("<INPUT TYPE=\"hidden\" NAME= \"std\" VALUE=\""+std+"\">");


     out.println("<input  type=\"submit\" value=\"Ok\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 1em\">&nbsp;&nbsp; ");


/*
      out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/Revframe1\" target =\"_parent\">");
      out.println("Back");
      out.println("</a>");
      out.println("</center>");
*/
   
//     out.println("</form>");

//      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Revfield\" target=\"top\">");
//      out.println("<input type=\"submit\" value=\"Back\">");

      out.println("</form>");
     out.println("</center>");
     out.println("</body>");
     out.println("</html>");
    }
}




