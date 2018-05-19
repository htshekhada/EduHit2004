import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Setting extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      
      String  r1,n1,s1,c1,sub=null,nn1=null;
      int  a=0,h1=0,m1=0,h2=0;
          
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
              out.println("<center><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">;[8L\\U</font></strong></center>");
              out.println("<br><br>");
       
         out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Fcourse target=\"_parent\">");
         out.println("<input  type=\"submit\" value=\"VeIF;S|D\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 28pt\">");
 
         out.println("</center></form>");   

         out.println("<br><br>");
         out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Time target=\"bottom1\">");
         out.println("<input  type=\"submit\" value=\"5ZL1FF ;DI\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 28pt\">");
 
         out.println("</center></form>");   

         out.println("<br><br>");
         out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Changepass target=\"bottom1\">");
         out.println("<input  type=\"submit\" value=\"    5F;J0    \" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 28pt\">");

         out.println("</center></form>");   

   
         out.println("</body>");
         out.println("</html>");
       } 
 }

