import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Supmain extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      
      String  r1,n1,s1,c1,sub=null,nn1=null;
      int  a=0,h1=0,m1=0,h2=0;

       HttpSession session = request.getSession(true);

      if(session == null)
          {
          response.sendRedirect("/servlet/Login");
          return;
          }

       
/*      HttpSession session = request.getSession(true);      
      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
          response.sendRedirect("/servlet/Login");
          return;
         }
*/          
      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(133,213,135)\">");

  
      out.println("<center><table width=750 border=0>");
      out.println("<tr><td align=\"left\"><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Lmg-Arun Condensed\" size=\"4\">CMD</font></strong>");
      out.println("</a></td>");

         out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"7\" color=\"red\">D]bI lJS<5MGL IFNL </font></th>");

      out.println("<td align=\"right\"><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Lmg-Arun Condensed\" size=\"4\">CMD</font></strong>");
      out.println("</a></td></tr></table></center>");


//         out.println("<center><font face=\"Lmg-Arun Condensed\" size=\"7\" color=\"red\">D]bI lJS<5MGL IFNL </font></center><br>");


         out.println("<center><form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Menuframe1\"> ");
         out.println("<input  type=\"submit\" value=\"5|`GM4 lJQFI VG[ 5F9G] GFD NFB, SZJF VF A8G NAFJM\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");

         out.println("</form></center>");

         


         out.println("<center><form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Menuframe2\" >");
         out.println("<input  type=\"submit\" value=\"    NFB, SZ[, 5|`GMDF\\ ;]WFZM SZJF VF A8G NAFJM    \" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");
         
         out.println("</form></center>");

         
         
         out.println("<center><form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Menuframe3\" >");
         out.println("<input  type=\"submit\" value=\"  NFB, SZ[, 5|`GM  VG[ lJQFI E];JF VF A8G NAFJM  \" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");
         
         out.println("</form></center>");

         
         
         out.println("<center><form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Menuframe4\" >");
         out.println("<input  type=\"submit\" value=\"VeIF;S|D  VG[ 5lZ1FF ;DI GSSL SZJF VF A8G NAFJM\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");
       
         out.println("</form></center>");

         

         out.println("<center><form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Menuframe5\" >");
         out.println("<input  type=\"submit\" value=\"   5|`GM VG[ 5lZ6FDGM VC[JF, HMJF VF A8G NAFJM   \" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");

         out.println("</form></center>");

         
         
         out.println("<center><form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Menuframe6\" >");
         out.println("<input  type=\"submit\" value=\"      8[d5 VG[ 5lZ6FD lZO|[X SZJF VF A8G NAFJM      \" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");

         out.println("</form></center>");

 
   
         out.println("</body>");
         out.println("</html>");
       } 
 }

