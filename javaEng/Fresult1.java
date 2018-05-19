import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Fresult1 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      String clno=null,std=null,rno=null;

      HttpSession session = request.getSession(true);      
      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
          response.sendRedirect("/servlet/Login");
          return;
         }


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
       out.println("<body bgcolor=\"rgb(211,255,213)\">");


       Connection con=null;
       Statement stmt=null,stmt1=null;
       ResultSet rs=null,rs1=null;



     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Fresult\" target=\"_parent\">");

     out.println("<br><br><p><strong><center><font face=\"Times New Roman\" size=\"5\">Yearly Result Of All Subjects Of Paticular Student</font></center></strong> </p>");
     out.println("<br> ");

  /*
     out.println("  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong>");
 
      out.println("<center>Exam Message");
      out.println("<select  name=\"subject\" size=\"1\">");


      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 rs = stmt.executeQuery("SELECT exmmsg AS c1 FROM exmmsg;");
                 int nRows = 0;
                 int i=0;
                 String[] c1=null;
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");

                                    String s2=cc.replace(' ','!');

                                    out.println("<option value="+s2+">"+cc+"</option>");
                                   }

             }
      catch (Exception e) {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                       }

   out.println(" </select> </strong></center><br><br>");

  */


      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();

                 out.println("<strong><br><center><font face=\"Times New Roman\" size=\"5\">Standard</font></strong>");
                 out.println("<strong>");
                 out.println("<select  name=\"std\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\">");
                 rs = stmt.executeQuery("SELECT distinct std AS c1 FROM genresult;");
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong>");
                 out.println("&nbsp;&nbsp;&nbsp;&nbsp;");

                 out.println("<strong><font face=\"Times New Roman\" size=\"5\">Roll No.</font></strong>");
                 out.println("<strong>");
                 out.println("<select  name=\"rollno\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\">");
                 rs = stmt.executeQuery("SELECT distinct rollno AS c1 FROM genresult;");
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong>");
                 out.println("&nbsp;&nbsp;&nbsp;&nbsp;");

                 out.println("<strong><font face=\"Times New Roman\" size=\"5\">Class</font></strong>");
                 out.println("<strong>");
                 out.println("<select  name=\"class\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\">");
                 rs = stmt.executeQuery("SELECT distinct class AS c1 FROM genresult;");
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong></center>");




             }
      catch (Exception e) {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                       }

/*

     out.println("<strong><br><center><font face=\"Lmg-Arun Condensed\">WMZ6</font></strong>");
     out.println("<strong>");
     out.println("<input type=\"text\" name=\"std\" size=\"10\" ></strong>");
     out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
   
     out.println("<strong><font face=\"Lmg-Arun Condensed\">ZM, G\\AZ</font></strong>");
     out.println("<strong>");
     out.println("<input type=\"text\" name=\"rollno\" size=\"10\" ></strong>");
     out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");

     out.println("<strong><font face=\"Lmg-Arun Condensed\">JU\"</font></strong>");
     out.println("<strong>");
     out.println("<input type=\"text\" name=\"class\" size=\"10\" ></strong></center>");

*/

     out.println("<br>");
    // out.println("<br>");

     out.println("<center>");
     out.println("<br><center><input type=\"submit\" value=\"Click This After Giving Above Information\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 16pt\" ></center>");
//     out.println("<input type=\"reset\" value=\"Reset\" name=\"reset\">");
     out.println("</center>");


     out.println("</form>");
     out.println("</body>");
     out.println("</html>");
    }
}



