import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Quetype extends HttpServlet
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
        
              


      out.println("<body bgcolor=\"rgb(211,255,213)\">");
             
              out.println("<br>");
              out.println("<center><strong><font face=\"Times New Roman\" size=5 >Click On The Respective Button For Entry</font></strong></center>");
              out.println("<br>");
 

         out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Frame  target=\"_parent\">");
         out.println("<input  type=\"submit\" value=\"Q-1: Select One True Answer     \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");
         out.println("</form></center>");   

    //     out.println("<br><br>");

         out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Frame1 target=\"_parent\">");
         out.println("<input  type=\"submit\" value=\"Q-2: Write Answer                      \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");
         out.println("</form></center>");   

         
   //      out.println("<br><br>");

         out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Frame2 target=\"_parent\">");
         out.println("<input  type=\"submit\" value=\"Q-3: Select One True Answer     \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");
         out.println("</form></center>");   



  //       out.println("<br><br>");

         out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Frame3 target=\"_parent\">");
         out.println("<input  type=\"submit\" value=\"Q-4: Join The Matches                \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");
         out.println("</form></center>");

   //      out.println("<br><br>");

         out.println("<center><form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Frame4 target=\"_parent\">");
         out.println("<input  type=\"submit\" value=\"Q-5: Select True Answer(s)         \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");
         out.println("</form></center>");   


              out.println("</body>");
              out.println("</html>");
        } 

     }
