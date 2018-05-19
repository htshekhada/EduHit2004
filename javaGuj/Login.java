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

      out.println("<center><table width=750 border=0>");
      out.println("<tr><td align=\"left\" width=25><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Lmg-Arun Condensed\" size=\"4\">CMD</font></strong>");
      out.println("</a></td>");

      out.println("<th width=700><strong><marquee behavior=\"Alternate\"><font face=\"Lmg-Arun Condensed\" size=\"7\">:S], VYJF SM,[HG] GFD</marquee></font></strong></th>");

      out.println("<td align=\"right\" width=25><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Lmg-Arun Condensed\" size=\"4\">CMD</font></strong>");
      out.println("</a></td></tr></table></center>");


      out.println("<br><br><br><br>");
      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Check\" enctype=\"x-www-form-urlencoded\">");


      out.println("<center>");
      out.println("<table border=5>");
      out.println(" <tr><th> <big><font face=\"Lmg-Arun Condensed\" size=\"6\">GFD</font></big> </th>");
      out.println("<strong>");
      out.println("<td><input type=\"text\" name=\"uname\" size=\"20\" maxlength=\"20\" style=\"font-family:Times New Roman;font-size:15pt\"></strong></td></tr>");
      out.println("<tr><th> <big><font face=\"Lmg-Arun Condensed\" size=\"6\">5F;J0\"</font></big> </th>");
      out.println("<strong>");
      out.println("<td><input type=\"password\" name=\"pwd\" size=\"20\" maxlength=\"20\" style=\"font-family:Times New Roman;font-size:15pt\"></strong></td></tr>");
      out.println("</center>");
      out.println("</table>");
      out.println("<br><center>");
      out.println("<input  type=\"submit\" value=\"  5|J[X\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");
      out.println("</center>");

      out.println("<br>");

//      out.println("<br>");
//      out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=3 color=\"RGB(0,0,0)\">AGFJGFZ o </font></b></center>");
//      out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=3 color=\"RGB(0,0,0)\"> lCT[XS]DFZ 8LP X[B0F   </font></b></center>");
//      out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=3 color=\"RGB(0,0,0)\">!(4S{,FX GUZ ;M;FI8L4  8L\\AFJF0L4  HF]GFU-4 OMGs3Zfv_)!v_Z(5vZ&*&&$$P</font></b></center>");

      out.println("</form>");
      out.println("</body>");
      out.println("</html>");


     }
}
