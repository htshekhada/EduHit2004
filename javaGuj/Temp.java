import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Temp extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
//      response.setContentType("bytes/raw-html");    // * (text/raw-html) for bkground
      PrintWriter out=response.getWriter();

//      out.println("<html>");
//      out.println("<head>");
//      out.println("<title>EducationHIT by H.T.Shekhada</title>");
  
//      out.println("</head>");
//      out.println("<body background=\"c:/Onlinexam/img/main.gif\">");


         //************java Script*******


out.println("<HTML><!-- tb v2.4 96.06.28 jhk --><HEAD>");
out.println("<TITLE>JavaScript Background Color Change</TITLE>");

out.println("<SCRIPT LANGUAGE=\"JavaScript\">");

out.println("locnm=location.href;");
out.println("locnm1=locnm.substring(0,(locnm.indexOf(\"http://"+request.getServerName()+":8080/servlet/Temp\")));");

out.println("function getCol() {");
out.println(" coord=locnm.substring(posx+3,locnm.length);");
out.println(" posx=coord.indexOf(\"&\")");
out.println(" xcoord=coord.substring(0,posx);");
out.println(" coord=coord.substring(posx+1,coord.length);");
out.println(" posx=coord.indexOf(\".y=\")");
out.println(" ycoord=coord.substring(posx+3,coord.length);");
out.println(" if (xcoord<8){color=\"#FFFF00\";}");
out.println(" else if (xcoord<16){color=\"#00FF00\";}");
out.println(" else if (xcoord<24){color=\"#00FFFF\";}");
out.println(" else if (xcoord<32){color=\"#FF00FF\";}");
out.println(" else if (xcoord<40){color=\"#FF0000\";}");
out.println(" else if (xcoord<48){color=\"#009FDD\";}");
out.println(" else if (xcoord<56){color=\"#B2B2B2\";}");
out.println(" else if (xcoord<64){color=\"#FFD25D\";}");
out.println(" else if (xcoord<72){color=\"#56AB6B\";}");
out.println(" else if (xcoord<80){color=\"#C70065\";}");
out.println(" else if (xcoord<88){color=\"#A25C92\";}");
out.println(" else if (xcoord<96){color=\"#E36970\";}");
out.println(" else if (xcoord<104){color=\"#C79E6B\";}");
out.println(" else if (xcoord<112){color=\"#90BE00\";}");
out.println(" else if (xcoord<120){color=\"#E16A96\";}");
out.println(" else color=\"white\";");
out.println(" }");

out.println("</SCRIPT>");
out.println("</HEAD>");
out.println("<!-- This initial script replaces the BODY call in");
out.println("     your Web Page HTML. -->");
out.println("<SCRIPT LANGUAGE=\"JavaScript\">");
out.println("<!-- Hide JavaScript from Java-Impaired Browsers");
out.println("posx=locnm.indexOf(\".x=\");");
out.println("if (posx>0) {");
out.println(" getCol();");
out.println(" }");
out.println("else {");
out.println(" color=\"white\";");
out.println(" }");
out.println("document.bgColor=color;");
out.println("// End Hiding -->");
out.println("</SCRIPT>");
out.println("<FORM NAME=\'isnform\' METHOD=GET ACTION=\'http://"+request.getServerName()+":8080/servlet/Temp\'>");


out.println("<INPUT TYPE='image' SRC='g/scb1.gif' NAME='color' BORDER=0 HEIGHT=8 WIDTH=128>");


out.println("</FORM>");

out.println("<!-- Insert Your Web Page Copy Here -->");



         //************java Script Complete*******


       out.println("<p align=\"right\">");
       out.println("<img src=\"c:/onlinexam/img/m7.gif\" >");
       out.println("</p>");




//      out.println("<body bgcolor=\"Olive\">");
      
       out.println("<br><br><br><br>");
	

  //     out.println("<br>");
       
//       out.println("<br><br><br>");
       out.println("<br><br><br>");
       out.println("<table border=0 align=right>");

   //    out.println("<center>");
//       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
//       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<tr><td><a href=\"http://"+request.getServerName()+":8080/servlet/form\">");
              out.println("<img src=\"c:/onlinexam/img/m1.gif\" border=0 align=\"right\">");
       //out.println("<font face=\"LMG-Paras\" size=\"6\" color=\"orange\" >S;M8L</font>");
                 //***********<img src=\"//"+request.getServerName()+"/"+request.getServerName()+"#c/jsdk2.0/examples/kas.gif\" width=100 height=100>");    
       out.println("</a></td></tr>");
//       out.println("<br>");
//       out.println("<br>");
//       out.println("<br>");
//       out.println("<br>");
   //    out.println("</center>");              

 //      out.println("<center>");
 //      out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
//       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<tr><td><a href=\"http://"+request.getServerName()+":8080/servlet/Revframe1\">");
       out.println("<img src=\"c:/onlinexam/img/m2.gif\" border=0 align=\"right\">");
//       out.println(" <font face=\"LMG-Paras\" size=\"6\" color=\"green\">5]GZFJT\"G</font>");
       out.println("</a></td></tr>");
  //     out.println("</center>");

//       out.println("<br>");
//       out.println("<br>");
//       out.println("<br>");
//       out.println("<br>");

 //      out.println("<center>");
//       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
//       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<tr><td><a href=\"http://"+request.getServerName()+":8080/servlet/Login\">");
       out.println("<img src=\"c:/onlinexam/img/m3.gif\" border=0 align=\"right\">");
  //     out.println("<font face=\"LMG-Paras\" size=\"6\" color=\"white\">;]5ZI]hZ</font>");
       out.println("</a></td></tr>");
   //    out.println("</center>");
        out.println("</table>");


/*       out.println("<center>");
       out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
       out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/Frameexp\">");
       out.println(" <font face=\"LMG-Paras\" size=\"6\" color=\"RED\">;{wWF\\lTS</font>");
       out.println("</a>");
       out.println("</center>");

*/
       out.println("<br><br><br><br><br><br>");

       out.println("<table border=0 align=\"left\">");

       out.println("<tr><td><a href=\"c:/onlinexam/examples/aboutus.html\">");
       out.println("<img src=\"c:/onlinexam/img/m4.gif\" border=0 >");
       out.println("</a></td>");

       out.println("<td></td><td></td><td></td><td></td>");

       out.println("<td><a href=\"c:/onlinexam/examples/help.html\">");
       out.println("<img src=\"c:/onlinexam/img/m5.gif\" border=0 >");
       out.println("</a></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
       out.println("</table>");



        out.println("</body>");
        out.println("</html>");
    }
}



