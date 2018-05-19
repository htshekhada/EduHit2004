import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Login extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");

      out.println("<body bgcolor=\"rgb(133,213,135)\">");
//      out.println("<body background=\"c:/onlinexam/img/sup1.gif\">");

      out.println("<center><table width=750 border=0>");
      out.println("<tr><td align=\"left\" width=25><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Times New Roman\" size=\"4\">Home</font></strong>");
      out.println("</a></td>");

      out.println("<th width=700><strong><marquee behavior=\"Alternate\"><font face=\"Times New Roman\" size=\"7\">School Or College Name</marquee></font></strong></th>");

      out.println("<td align=\"right\" width=25><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Times New Roman\" size=\"4\">Home</font></strong>");
      out.println("</a></td></tr></table></center>");


      out.println("<br><br><br><br><br>");
      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Check\" enctype=\"x-www-form-urlencoded\">");


      out.println("<center>");
      out.println("<table border=5>");
      out.println(" <tr><th> <big><font face=\"Times New Roman\" size=\"6\">Name</font></big> </th>");
      out.println("<strong>");
      out.println("<td><input type=\"text\" name=\"uname\" size=\"20\" maxlength=\"20\" style=\"font-family:Times New Roman;font-size:15pt\"></strong></td></tr>");
//      out.println("</center>");
//      out.println("<center>");
      out.println("<tr><th> <big><font face=\"Times New Roman\" size=\"6\">PassWord</font></big> </th>");
      out.println("<strong>");
      out.println("<td><input type=\"password\" name=\"pwd\" size=\"20\" maxlength=\"20\" style=\"font-family:Times New Roman;font-size:15pt\"></strong></td></tr>");
      out.println("</center>");
      out.println("</table>");
      out.println("<br><center>");
      out.println("<input  type=\"submit\" value=\"Log In\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 18pt\">");
      out.println("</center>");

       out.println("<br><br>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(211,255,213)\">Developed By...</font></center>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(211,255,213)\">Hiteshkumar T. Shekhada</font></center>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(211,255,213)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-2676644</font></center>");

      out.println("</form>");
      out.println("</body>");
      out.println("</html>");


     }
}
