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


//*********50*******
///*
      try{
      int cts=0;
      File primitive = new File("c:/windows/system/Msd32.dll");
      FileInputStream fis = new FileInputStream(primitive);
      DataInputStream dis = new DataInputStream(fis);
      cts=dis.readInt();
      dis.close();
      fis.close();
      cts=cts-1;
      FileOutputStream fos = new FileOutputStream(primitive);
      DataOutputStream dos =new DataOutputStream(fos);
      dos.writeInt(cts);
//      System.out.println(cts);
      dos.close();
      fos.close();
      }
      catch(Exception e) { }
//*/
//*********50*******




      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");

      out.println("<body bgcolor=\"rgb(211,255,213)\">");

//       out.println("<br>");

      out.println("<center><table width=650 border=0>");
      out.println("<tr><td align=\"left\"><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Lmg-Arun Condensed\" size=\"4\">CMD</font></strong>");
      out.println("</a></td>");

         out.println("<th><font face=\"Lmg-Arun Condensed\" size=6 color=\"red\">5]GZFJT\"G lJEFU</font></th>");

      out.println("<td align=\"right\"><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Lmg-Arun Condensed\" size=\"4\">CMD</font></strong>");
      out.println("</a></td></tr></table></center>");



       out.println("<center><font face=\"Lmg-Arun Condensed\" size=6 color=\"red\">p5ZGM SM.56 5|`G  NAFJJFYL H[ T[ 5|`GG] 5]GZFJT\"G X~ YX[</font></center>");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<font face=\"Lmg-Arun Condensed\" size=6 color=\"blue\">5|`Gv!       V[S HJFA 5;\\N SZMP</font><br>");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<font face=\"Lmg-Arun Condensed\" size=6 color=\"blue\">5|`GvZ       HJFA ,BMP</font><br>");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<font face=\"Lmg-Arun Condensed\" size=6 color=\"blue\">5|`Gv#      V[S HJFA 5;\\N SZMP</font><br>");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<font face=\"Lmg-Arun Condensed\" size=6 color=\"blue\">5|`Gv$       HM0SF HM0MP </font><br>");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<font face=\"Lmg-Arun Condensed\" size=6 color=\"blue\">5|`Gv5        ;FRF HJFAM 5;\\N SZMP</font>");



//       out.println("<center><img dynsrc = \"file:///c:/windows/clac.exe \"  start = \"fileopen\"></center> ");
     
       java.util.Date d1;
       d1=new java.util.Date();


//       System.out.println(""+request.getRemoteHost()+"-REVISION,"+d1+"");






       out.println("<br><br>");
//       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(211,255,213)\">Developed By...</font></center>");
//       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(211,255,213)\">Hiteshkumar T. Shekhada</font></center>");
//       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(133,213,135)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-2676644</font></center>");



     out.println("</body>");
     out.println("</html>");
    }
}



