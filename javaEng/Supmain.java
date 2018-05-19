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
      out.println("<strong><font face=\"Times New Roman\" size=\"4\">Home</font></strong>");
      out.println("</a></td>");
  
         out.println("<th><strong><font face=\"Times New Roman\" size=\"6\" color=\"red\">List Of Main Options</font></strong></th>");

      out.println("<td align=\"right\"><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Times New Roman\" size=\"4\">Home</font></strong>");
      out.println("</a></td></tr></table></center>");


         out.println("<center><form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Menuframe1\"> ");
         out.println("<input  type=\"submit\" value=\" To Enter Questions,Subjects,Chapter Names \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");

         out.println("</form></center>");

         


         out.println("<center><form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Menuframe2\" >");
         out.println("<input  type=\"submit\" value=\"             To Update Entered Questions             \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");
         
         out.println("</form></center>");

         
         
         out.println("<center><form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Menuframe3\" >");
         out.println("<input  type=\"submit\" value=\"    To Delete Entered Questions Or Subjects    \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");
         
         out.println("</form></center>");

         
         
         out.println("<center><form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Menuframe4\" >");
         out.println("<input  type=\"submit\" value=\"To Set The Syllabus,Exam Time Or Password \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");
       
         out.println("</form></center>");

         

         out.println("<center><form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Menuframe5\" >");
         out.println("<input  type=\"submit\" value=\"To View The Reports Of Questions Or Results\" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");

         out.println("</form></center>");

         
         
         out.println("<center><form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Menuframe6\" >");
         out.println("<input  type=\"submit\" value=\"         To Refresh The Temp And Results         \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\">");

         out.println("</form></center>");

 
   
         out.println("</body>");
         out.println("</html>");
       } 
 }

