import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Aboutus extends HttpServlet
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


       out.println("<center><b><strong><font face=\"Lmg-Arun Condensed\" size=5 color=\"RGB(0,0,0)\">V[HI]S[XGlC8 ;MO8J[Z</font></strong></b></center><hr>");
       out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=5 color=\"RGB(255,0,0)\">VF OST ;MO8J[ZGM GD]GF[ H K[P  VFB] ;MO8J[Z BZLNJF DF8[ GLR[GF ;ZGFD[ D/M</font></b></center>");

       out.println("<br><center><b><font face=\"Lmg-Arun Condensed\" size=5 color=\"RGB(0,0,255)\">SMd%I]8Z ;%,FI;\" V[g0 ;MO8JZ 0[J,M5;\"</font></b></center>");
       out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=5 color=\"RGB(0,0,255)\">VD]EF. AMZ;F6LIF</font></b></center>");
       out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=5 color=\"RGB(0,0,255)\">VF\\AFJF0L4 UF0\"G 5F;[4 HLP H]GFU-4 S[XF[Nv#&ZZZ_</font></b></center>");
       out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=5 color=\"RGB(0,0,255)\">OMG G\\P vs_Z(*!f Z#&$5& sDMPfv)(Z$Z #5$5(</font></b></center><hr>");

      out.println("<center>");
      out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Lmg-Arun Condensed\" size=\"4\">CMD</font></strong>");
      out.println("</a>");
      out.println("</center>");


      out.println("<br>");
      out.println("</body>");
      out.println("</html>");



}
}



