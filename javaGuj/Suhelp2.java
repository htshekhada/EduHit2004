import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Suhelp2 extends HttpServlet
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


      out.println("<center><b><strong><font face=\"Lmg-Arun Condensed\" size=5 color=\"RGB(0,0,255)\">V[HI]S[XGlC8 ;MO8J[Z</font></strong></b></center>");
      out.println("<br>");

      out.println("<center><b><strong><font face=\"Lmg-Arun Condensed\" size=5 color=\"RGB(0,0,255)\">vAFH]DF\\ NXF\"J[, A8GMGL DNNYL TD[ H[ T[ NFB, SZ[, 5|`G ;]WFZL XSFI K[P</font></strong></b></center>");



      out.println("<br>");
      out.println("</body>");
      out.println("</html>");



}
}



