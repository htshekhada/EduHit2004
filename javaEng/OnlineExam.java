import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class OnlineExam extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
//      response.setContentType("bytes/raw-html");    // * (text/raw-html) for bkground
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
  
      out.println("</head>");
//      out.println("<body background=\"c:/EduHit/bg2.gif\">");
      out.println("<body bgcolor=\"rgb(133,213,135)\"> ");


//     out.println("<marquee Behavior=\"alternate\" ><p dynamicanimation=\"fpAnimformatRolloverFP1\" fprolloverstyle=\"background-color: #008000; color: #FF0000; border-style: dotted; border-color: #FF0000\" onmouseover=\"rollIn(this)\" onmouseout=\"rollOut(this)\" language=\"Javascript1.2\"><input type=\"button\" value=\"V[HI]S[XGlC8 ;MO8J[Z\" name=\"B3\" style=\"font-family: LMG-Arun Condensed; font-size: 24pt; background-color: #008080; color: #000000; border-style: dotted\"></p></marquee>");
     

       



       out.println("<table border=0 width=450 align=center bgcolor=\"rgb(211,255,213)\">");
//       out.println("<tr><th><strong><marquee Behavior=\"alternate\" ><font face=\"Lmg-Arun Condensed\" size=5 color=\"rgb(255,0,0)\">E6TZ </font></marquee></strong></th></tr>");
       out.println("<tr><th><strong><marquee Behavior=\"alternate\" scrolldelay=\"250\"><input type=\"button\" name=\"eh\" value=\"EducationHIT Software\"  style=\"font-family: Times New Roman; font-size: 24pt;  background-color: rgb(133,213,135); color: rgb(0,0,0); border-style: dotted\" ></marquee></strong></th></tr>");
       out.println("<tr><th><font face=\"Times New Roman\" size=3 color=\"rgb(255,0,0)\">Complete Solution For Schools,Colleges & Classes</font></th></tr>");
       out.println("</table>");

       out.println("<br><br>");
	

       
   
       out.println("<table border=0 align=center bgcolor=\"rgb(211,255,213)\">");

       out.println("<tr><th><a href=\"http://"+request.getServerName()+":8080/servlet/form\" target=\"_parent\">");
       out.println("<font face=\"Times New Roman\" size=7 color=\"RGB(0,0,255)\">Exam</font>");     //  out.println("<img src=\"c:/onlinexam/img/m1.gif\" border=0 align=\"right\">");
   //    out.println("<input type=\"submit\" name=\"eh\" value=\"5ZL1FF\"  style=\"font-family: LMG-Arun Condensed; font-size: 24pt;  background-color: #008080; color: #000000 \">"); 
                 //***********<img src=\"//"+request.getServerName()+"/"+request.getServerName()+"#c/jsdk2.0/examples/kas.gif\" width=100 height=100>");    
       out.println("</a></th></tr>");

       out.println("<tr><th><a href=\"http://"+request.getServerName()+":8080/servlet/Revframe1\" target=\"_parent\">");
       out.println("<font face=\"Times New Roman\" size=7 color=\"RGB(0,0,255)\">Revision</font>");   //    out.println("<img src=\"c:/onlinexam/img/m2.gif\" border=0 align=\"right\">");
   //    out.println("<input type=\"submit\" name=\"eh\" value=\"5]GZFJT\"G\"  style=\"font-family: LMG-Arun Condensed; font-size: 24pt;  background-color: #008080; color: #000000 \">");
       out.println("</a></th></tr>");


       out.println("<tr><th><a href=\"http://"+request.getServerName()+":8080/servlet/Login\" target=\"_parent\">");
       out.println("<font face=\"Times New Roman\" size=7 color=\"RGB(0,0,255)\">SuperUser</font>");     //   out.println("<img src=\"c:/onlinexam/img/m3.gif\" border=0 align=\"right\">");
   //    out.println("<input type=\"submit\" name=\"eh\" value=\"lGIFDS\"  style=\"font-family: LMG-Arun Condensed; font-size: 24pt;  background-color: #008080; color: #000000 \">");
       out.println("</a></th></tr>");

        out.println("</table>");


/*       out.println("<center>");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/Frameexp\">");
       out.println(" <font face=\"LMG-Paras\" size=\"6\" color=\"RED\">;{wWF\\lTS</font>");
       out.println("</a>");
       out.println("</center>");

*/
       out.println("<br>");

       out.println("<table border=0 align=\"center\">");

       out.println("<tr><td><a href=\"http://"+request.getServerName()+":8080/servlet/Aboutus\">");
       out.println("<font face=\"Times New Roman\" size=4 color=\"RGB(0,0,255)\">AboutMe</font>");    //   out.println("<img src=\"c:/onlinexam/img/m4.gif\" border=0 >");
       out.println("</a></td>");

       out.println("<td>");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("</td>");

       out.println("<td><a href=\"http://"+request.getServerName()+":8080/servlet/Help\">");
       out.println("<font face=\"Times New Roman\" size=4 color=\"RGB(0,0,255)\">Help</font>");   // out.println("<img src=\"c:/onlinexam/img/m5.gif\" border=0 >");
       out.println("</a></td></tr>");
       out.println("</table>");
   //    out.println("<br><br>");
       out.println("<center><b><font face=\"Times New Roman\" size=2 color=\"rgb(0,0,0)\">Developed By...</font></b></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=2 color=\"rgb(0,0,0)\">Hiteshkumar T. Shekhada</font></b></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=2 color=\"rgb(0,0,0)\">18,Kailash Nagar,Timbavadi,Junagadh(Gujarat),Ph(R):091-0285-2676644</font></b></center>");
//       System.out.print(""+request.getRemoteHost()+"-");

        out.println("</body>");
        out.println("</html>");
    }
}



