import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Dispreport extends HttpServlet
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
              out.println("<center><strong><font face=\"Lmg-Arun Condensed\"  size=\"5\">ZL5M8\"</font></strong></center>");
              out.println("<br>");

         
              out.println("<center>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Dispreport1\" target=\"bottom1\">");
              out.println("<input  type=\"submit\" value=\"    5|`GM    \" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 24pt\">");

              out.println("</form>");

                out.println("</center>");
            
              out.println("<center>");
              out.println("<br>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Dispresult\" target=\"bottom1\">");
              out.println("<input  type=\"submit\" value=\"   5ZL6FD   \" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 24pt\">");

              out.println("</form>");
              out.println("</center>");

            
              out.println("<center>");
              out.println("<br>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Disppaper0\" target=\"bottom1\">");
              out.println("<input  type=\"submit\" value=\"5|`G5[5Z\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 24pt\">");

              out.println("</form>");
              out.println("</center>");


              out.println("</body>");
              out.println("</html>");
        } 

     }
