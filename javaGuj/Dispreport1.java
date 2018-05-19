import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Dispreport1 extends HttpServlet
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
              out.println("<center><font face=\"Lmg-Arun Condensed\" size=7 >lJQFIGF 5|`GM HMJF DF8[GM lJEFU</font></center>");
              out.println("<br><br>");
              out.println("<center>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/DispbookF\" >");                                     
              out.println("<input  type=\"submit\" value=\"VFBL RM50L HMJF VF A8G NAFJM\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");

              out.println("</form>");

                out.println("</center>");
            
              out.println("<center>");
              out.println("<br><br>");

              out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/DispchapF\">");
              out.println("<input  type=\"submit\" value=\"RM50LGM SM> V[S 5F9 HMJF VF A8G NAFJM\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");

              out.println("</form>");
              out.println("</center>");
            
              out.println("</body>");
              out.println("</html>");
        } 

     }
