import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Disppaper0 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");

    //  out.println("<body background=\"c:/jsdk2.0/examples/image4.gif\">");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");
     

      out.println("<strong><font face=\"arial\" size=\"5\"><marquee behavior=\"Alternate\">EducationHit Paper Generating Module</marquee></font></strong>");

      out.println("<br><br><br><center>");
      out.println("<center><font face=\"Times New Roman\" size=4 >Select Appropriat Standard,Class & Subject For Generating Question Paper & It's AnswerSheet As Per Course Setting</font></center><br><br>");
      out.println("<table border=\"4\" width=\"350\" >");



                                    




      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Disppaper\" target=\"_parent\">");




//********************** <option value=\"computer\">computer</option>
      
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();


                 out.println("<tr><th><p align=\"left\"><strong>Standard:</p></th>");
                 out.println("<th><p align=\"left\"><select  name=\"std\" size=\"1\" style=\"font-size:15pt\">");
               
                 rs = stmt.executeQuery("SELECT DISTINCT std AS c1 FROM course;");
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong></p></th></tr>");





                 out.println("<tr><th><p align=\"left\"><strong>Class:</p></th>");
                 out.println("<th><p align=\"left\"><select  name=\"class\" size=\"1\" style=\"font-size:15pt\">");
               
                 rs = stmt.executeQuery("SELECT DISTINCT class AS c1 FROM course;");
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong></p></th></tr>");



                 out.println("<tr><th><p align=\"left\"><strong>Subject:</p></th>");
                 out.println("<th><p align=\"left\"><select  name=\"sub\" size=\"1\" style=\"font-size:15pt\">");
               
                 rs = stmt.executeQuery("SELECT DISTINCT sub AS c1 FROM course;");
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong></p></th></tr>");

             }
      catch (Exception e) {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                       }
        finally {
                      if(rs != null) {
                                            try { rs.close(); }
                                             catch (SQLException ignore)  { }
                                            }
                   if(stmt != null) {
                                            try { stmt.close(); }
                                            catch (SQLException ignore) { }
                                            }
                   if(con != null)   {
                                             try { con.close(); }
                                             catch (SQLException ignore) { }
                                            }
                  }


  

      

      out.println("</table>");
      out.println("<br>");


      out.println("<br>");
      out.println("<p><input type=\"submit\" value=\"Submit\" name=\"submit\">&nbsp;&nbsp;&nbsp; <input type=\"reset\" value=\"Reset\" name=\"reset\"></p>");
      out.println("</form>");
      out.println("</body>");
      out.println("</html>");
    }
}



