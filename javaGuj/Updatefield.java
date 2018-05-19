import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Updatefield extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      HttpSession session = request.getSession(true);
      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
          response.sendRedirect("/servlet/Login");
          return;
         }
      
          
      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(133,213,135)\">");

              out.println("<br>");
              out.println("<center><strong><font face=\"Lmg-Arun Condensed\"  size=\"5\">V50[8</font></strong></center>");
              out.println("<br>");


         out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Fupdateopt target=\"_parent\">");
         out.println("<input  type=\"submit\" value=\"5|`Gv!\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");
         out.println("</center></form>");   

         out.println("<br>");

         out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Fupdatesho target=\"_parent\">");
         out.println("<input  type=\"submit\" value=\"5|`GvZ\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");

         out.println("</center></form>");   

         
         out.println("<br>");

         out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Fupdatelong target=\"_parent\">");
         out.println("<input  type=\"submit\" value=\"5|`Gv#\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");

         out.println("</center></form>");   



         out.println("<br>");

         out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Fupdatejoint target=\"_parent\">");
         out.println("<input  type=\"submit\" value=\"5|`Gv$\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");

         out.println("</center></form>");   


         out.println("<br>");

         out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Fupdatevar target=\"_parent\">");
         out.println("<input  type=\"submit\" value=\"5|`Gv5\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");

         out.println("</center></form>");   

   
         out.println("</body>");
         out.println("</html>");
       } 
 }

