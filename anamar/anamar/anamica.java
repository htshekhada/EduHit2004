import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class anamica extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>AnamicaHIT by H.T.Shekhada</title>");
      out.println("<body bgcolor=\"black\">");
//      out.println("<strong><marquee Behavior=\"Alternate\"><font face=\"Times New Roman\" size=\"6\" color=\"blue\">ANAMICA MARKETING</font></marquee></strong>");

       out.println("<table border=0 width=650 align=center bgcolor=\"rgb(211,255,213)\">");
       out.println("<tr><th><strong><marquee Behavior=\"alternate\" scrolldelay=\"250\"><input type=\"button\" name=\"eh\" value=\"Anamica Marketing Software\"  style=\"font-family: Times New Roman; font-size: 24pt;  background-color: rgb(133,213,135); color: rgb(0,0,0); border-style: dotted\" ></marquee></strong></th></tr>");
       out.println("<tr><th><font face=\"Times New Roman\" size=3 color=\"rgb(255,0,0)\">Solution For Multilevel Marketing Company</font></th></tr>");
       out.println("</table>");


       out.println("<br><center><a href=\"http://"+request.getServerName()+":8080/servlet/form\" >");
      out.println("<font face=\"Times New Roman\" size=5 color=\"RGB(0,0,255)\">Form Entry</font>");  
       out.println("</a></center>");

       out.println("<br><center><a href=\"http://"+request.getServerName()+":8080/servlet/geno\" >");
      out.println("<font face=\"Times New Roman\" size=5 color=\"RGB(0,0,255)\">Geniology</font>");  
       out.println("</a></center>");

       out.println("<br><center><a href=\"http://"+request.getServerName()+":8080/servlet/genor2\" >");
      out.println("<font face=\"Times New Roman\" size=5 color=\"RGB(0,0,255)\">Geno Round2</font>");  
       out.println("</a></center>");

       out.println("<br><center><a href=\"http://"+request.getServerName()+":8080/servlet/genor3\" >");
      out.println("<font face=\"Times New Roman\" size=5 color=\"RGB(0,0,255)\">Geno Round3</font>");  
       out.println("</a></center>");


       out.println("<br><center><a href=\"http://"+request.getServerName()+":8080/servlet/Bio\" >");
      out.println("<font face=\"Times New Roman\" size=5 color=\"RGB(0,0,255)\">Member Info</font>");  
       out.println("</a></center>");


       out.println("<br><br><center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">Developed By...</font></b></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">Hiteshkumar T. Shekhada</font></b></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-676644</font></b></center>");


      out.println("</body>");
      out.println("</html>");

   }
}
