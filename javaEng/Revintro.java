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


public class Revintro extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
//      response.setContentType("application/vnd.ms-excel");
      PrintWriter out=response.getWriter();
      String subject=null,std=null,lno=null;

      HttpSession session = request.getSession(true);      
      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
//          response.sendRedirect("/servlet/Login");
//          return;
         }


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      



//      out.println("<body bgcolor=\"red\">");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");
//       out.println("<body background=\"c:/Onlinexam/img/3.jpg\">");





//       out.println("<br>");

      out.println("<center><table width=650 border=0>");
      out.println("<tr><td align=\"left\"><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Times New Roman\" size=\"4\">Home</font></strong>");
      out.println("</a></td>");

       out.println("<th><strong><font face=\"Times New Roman\" size=4 color=\"red\">Revision Module</font></strong></th>");

      out.println("<td align=\"right\"><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Times New Roman\" size=\"4\">Home</font></strong>");
      out.println("</a></td></tr></table></center>");


       out.println("<center><strong><font face=\"Times New Roman\" size=4 color=\"red\">By Clicking Any Of Above Question You Can Start Revision Of Respective Question</font></strong></center>");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<font face=\"Times New Roman\" size=6 color=\"blue\">Que-1: Select One Answer</font><br>");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<font face=\"Times New Roman\" size=6 color=\"blue\">Que-2: Write Answer</font><br>");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<font face=\"Times New Roman\" size=6 color=\"blue\">Que-3: Select One Answer</font><br>");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<font face=\"Times New Roman\" size=6 color=\"blue\">Que-4: Join The Matches </font><br>");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<font face=\"Times New Roman\" size=6 color=\"blue\">Que-5: Select True Answer(s)</font>");



//       out.println("<center><img dynsrc = \"file:///c:/windows/clac.exe \"  start = \"fileopen\"></center> ");
     
       java.util.Date d1;
       d1=new java.util.Date();


//       System.out.println(""+request.getRemoteHost()+"-REVISION,"+d1+"");


       out.println("<br><br><br>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(133,213,135)\">Developed By...</font></center>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(133,213,135)\">Hiteshkumar T. Shekhada</font></center>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(133,213,135)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-2676644</font></center>");



     out.println("</body>");
     out.println("</html>");
    }
}



