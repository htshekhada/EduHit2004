import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Refresh extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      
      String  r1,n1,s1,c1,sub=null,nn1=null;
      int  a=0,h1=0,m1=0,h2=0;

/*      if(session == null)
          {
          response.sendRedirect("/servlet/Login");
          return;
          }
*/
       
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
              out.println("<center><strong><font face=\"Times New Roman\" color=\"red\"  size=\"4\">Refresh</font></strong></center>");
              out.println("<br>");


         out.println("<center>");
         out.println("<form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Refresht target=\"bottom1\">");
         out.println("<input  type=\"submit\" value=\"    Temp     \" name=\"start\" style=\"font-family: Times New Roman; font-size: 14pt\">");

         out.println("</form>");
         out.println("</center>");

  /*
         out.println("<br>");

         
         out.println("<center>");
         out.println("<form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Refreshr target=\"bottom1\">");
         out.println("<input  type=\"submit\" value=\"    5ZL6FD    \" name=\"start\" style=\"font-family: Times New Roman; font-size: 14pt\">");

         out.println("</form>");
         out.println("</center>");
 */      

         out.println("<br>");

         
         out.println("<center>");
         out.println("<form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Refreshst target=\"bottom1\">");
         out.println("<input  type=\"submit\" value=\"One Student\" name=\"start\" style=\"font-family: Times New Roman; font-size: 14pt\">");

         out.println("</form>");
         out.println("</center>");

         out.println("<br>");

         
         out.println("<center>");
         out.println("<form method=\"get\" action=http://"+request.getServerName()+":8080/servlet/Refreshsubr target=\"bottom1\">");
         out.println("<input  type=\"submit\" value=\" Sub Result \" name=\"start\" style=\"font-family: Times New Roman; font-size: 14pt\">");

         out.println("</form>");
         out.println("</center>");


         out.println("</table></center>");

         

   
         out.println("</body>");
         out.println("</html>");
       } 
 }

