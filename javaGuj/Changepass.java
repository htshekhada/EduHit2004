import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Changepass extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
          
      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");

/*      int m1=0;
      java.util.Date d1;
      d1=new java.util.Date();
      m1=d1.getMinutes();
*/








      out.println("<br><br><br><center><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">I]hZGFD VG[ 5F;J0\" AN,JF DF8[GM lJEFU</font></strong></center><br><br>");

      out.println("<center><table border=10>");
      out.println("<tr>");

      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Pass\">");
      out.println("<td><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">CF,G] I]hZGFD</font></strong></td>");
      out.println("<td><input type=\"text\" name=\"currentu\" size=20 maxlength=20 style=\"font-family:Times New Roman;font-size:15pt\"></td></tr>");
      out.println("<tr><td><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">GJ] I]hZGFD</font></strong></td>");
      out.println("<td><input type=\"text\" name=\"newu\" size=20 maxlength=20 style=\"font-family:Times New Roman;font-size:15pt\"></td></tr>");

      out.println("<tr><td><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">CF,GM 5F;J0\"</font></strong></td>");
      out.println("<td><input type=\"password\" name=\"currentp\" size=20 maxlength=20 style=\"font-family:Times New Roman;font-size:15pt\"></td></tr>");
      out.println("<tr><td><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">GJM 5F;J0\"</font></strong></td>");
      out.println("<td><input type=\"password\" name=\"newp\" size=20 maxlength=20 style=\"font-family:Times New Roman;font-size:15pt\"></td></tr>");

      out.println("</table><br>");

      out.println("<input  type=\"submit\" value=\"I]hZGFD VG[ 5F;J0 AN,L VF A8G NAFJM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 15pt\"></center> ");
 //     out.println("<input type=\"reset\" name=\"reset\" value=\"Reset\"></center>");
      out.println("</form>");


      out.println("</body>");
      out.println("</html>");
       }
 }
