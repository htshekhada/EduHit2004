import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Entry extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/raw-html");
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");

      out.println("<body background=\"c:/jsdk2.0/examples/image4.gif\">");

     
     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Kasoti\">");

     out.println("<p><strong><center>Entry mode:</center></strong> </p>");
     out.println(" ");
     out.println("  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong>");
     out.println("  &nbsp;&nbsp;");
     out.println("<p><strong>Subject:      ");
     out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong>");
     out.println("&nbsp;&nbsp;");
    out.println("<select  name=\"subject\" size=\"1\">");
//     out.println("<select  name=\"subject\" size=\"1\"> <option value=\"computer\">computer</option> <option //value=\"maths\">maths</option> <option value=\"science\">science</option> </select> </strong></p>");
    
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 rs = stmt.executeQuery("SELECT DISTINCT sub AS c1 FROM course;");
                 int nRows = 0;
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }

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
out.println(" </select> </strong></p>");
   out.println("");
   out.println("");
     out.println("<p><strong>Lesson No:     </strong>");
     out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong>");
     out.println("&nbsp;&nbsp;");
     out.println("<input type=\"text\" name=\"lno\" size=\"30\" ></strong></p>");
    
     out.println("<p><strong>Question:      </strong>");
     out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong>");
     out.println("&nbsp;&nbsp;");
     out.println("<input type=\"text\" name=\"question\" size=\"50\" ></strong></p>");
     out.println("<p><strong>Right Answer:  </strong>");
     out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
     out.println("&nbsp;&nbsp; ");
     out.println("<input  type=\"text\" name=\"rightans\" size=\"50\" ></strong></p>");
     out.println("<p><strong>Wrong ans-1:   </strong> ");
     out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
     out.println("&nbsp;&nbsp; ");
     out.println(" <input type=\"text\" name=\"wrong1\"  size=\"50\" ></strong></p>");
     out.println("<p><strong>Wrong ans-2:   </strong>");
     out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
     out.println("&nbsp;&nbsp; ");
     out.println("<input  type=\"text\" name=\"wrong2\" size=\"50\" ></strong></p>");
     out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
     out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
     out.println("&nbsp;&nbsp;&nbsp;&nbsp; ");

     out.println("<input  type=\"submit\" value=\"Submit\" name=\"submit\">&nbsp;&nbsp; ");

     out.println("<input type=\"reset\" value=\"Reset\" name=\"reset\"></p>");

     out.println("</form>");
     out.println("</body>");
     out.println("</html>");
    }
}



