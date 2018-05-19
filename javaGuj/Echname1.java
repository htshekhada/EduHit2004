import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Echname1 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      int et=0;
      String s1=null,s2=null;

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");

      s1=request.getParameter("standard");
      s2=request.getParameter("subject");


      

      Connection con=null;
      Statement stmt=null,stmt1=null,stmt2=null;
      ResultSet rs=null,rs1=null,rs2=null;




     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Echname2\">");
     out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=5>GLR[ VF5[, 5F9 G\\AZ DF8[ 5F9G] GFD ,BMP</font></b> </center>");


     
     out.println("<center>");
     out.println("<table border=\"4\" width=\"150\">");
     out.println("<tr>");
     out.println("<th><font face=\"Lmg-Arun Condensed\" size=6>5F9 G\\AZ</font></th>");
     out.println("<th><font face=\"Lmg-Arun Condensed\" size=6>5F9G] GFD</font></th>");
     out.println("<th><font face=\"Lmg-Arun Condensed\" size=5>5F9 E];JF</font></th>");
     out.println("</tr>");

     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1= con.createStatement();
                 stmt2= con.createStatement();
           
          //       rs = stmt.executeQuery("SELECT DISTINCT std AS s1,DISTINCT chap as c1,subject as s2 FROM chapname;");
           
                 rs = stmt.executeQuery("SELECT DISTINCTROW(chap) as c1 FROM chapname where std="+s1+" and subject='"+s2+"' order by chap;");
           
                 int nRows = 0;
                 while(rs.next()) {
                                            
                                //    String std1 = rs.getString("std");
                                    int cno=rs.getInt("c1");
                                //    String sub1=rs.getString("subject");

                                       

                                    String chname=null;
                                    rs1 = stmt1.executeQuery("SELECT chname as cname FROM chapname where std="+s1+" and subject='"+s2+"' and chap="+cno+";");
                                    if(rs1.next()){
                                                   chname = rs1.getString("cname");
                                                   }

                                

                                    String fname=null;
                                    rs2 = stmt2.executeQuery("select fontname as fn from subject where std="+s1+" and sub_name='"+s2+"';");
                                    rs2.next();
                                    fname=rs2.getString("fn");

                                

                                    out.println("<tr>");
                                    out.println("<td>");
                                    out.println(""+cno+"");
                                    out.println("</td>");
                                    out.println("<td>");
                                    out.println("<input type=\"text\" name=\""+cno+"\" value=\""+chname+"\" maxlength=\"100\" size=\"50\" style=\"font-family:"+fname+";font-size:14pt\">");
                                    out.println("</td>");
                                    out.println("<td>");
                                    out.println("<input type=\"checkbox\" value=\"d\"  name=\""+cno+"d\"> ");
                                    out.println("</td>");

                                    out.println("</tr>");
                                   }
                 out.println("</table>");
                 out.println("</center>");

             }
     catch (Exception e)          {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                   }



     out.println("<INPUT TYPE=\"hidden\" NAME= \"subject\" VALUE=\""+s2+"\">"); 
     out.println("<INPUT TYPE=\"hidden\" NAME= \"standard\" VALUE=\""+s1+"\">");

     out.println("<br>");
     out.println("<center>");
     out.println("<input  type=\"submit\" value=\"VMS[\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 12pt\">");
     out.println("</center>");
     out.println("</form>");

  //   out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/Supmain\">");
  //   out.println("<center>Back Home</center>");
  //   out.println("</a>");


     out.println("</body>");
     out.println("</html>");
    }

}














