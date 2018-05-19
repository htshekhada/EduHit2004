import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Revfield3 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

//      HttpSession session = request.getSession(true);      
//      String userid = (String) session.getValue("userid");
//      String password=(String) session.getValue("password");
       

//      if((userid==null) || (password==null))
//         {
//          response.sendRedirect("/servlet/Login");
//          return;
//         }


              out.println("<html>");    
              out.println("<head>");
              out.println("<title>EducationHIT by H.T.Shekhada</title>");
              out.println("</head>");
        
              


//              out.println("<body bgcolor=\"pink\">");

      out.println("<body bgcolor=\"rgb(133,213,135)\">");

             


              out.println("<center>");

          

//              out.println("</center>");
            
//              out.println("<center>");
//              out.println("<br><br><br>");
              out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");


              out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/Rev4\" target =\"topleft\">");
              out.println("<b><font face=\"Lmg-Arun Condensed\" size=6>5|`Gv$</font></b>");
//     out.println("<img src=\"c:/onlinexam/img/q-4.gif\" border=0>");
              out.println("</a>");


              out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");


              out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/Rev5\" target =\"topleft\">");
              out.println("<b><font face=\"Lmg-Arun Condensed\" size=6>5|`Gv5</font></b>");
//     out.println("<img src=\"c:/onlinexam/img/q-5.gif\" border=0>");
              out.println("</a>");




              out.println("</center>");
              out.println("</body>");
              out.println("</html>");
        } 

     }
