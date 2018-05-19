import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Dispchaps extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      PrintWriter out=response.getWriter();


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");

      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Dispchapc\" target=\"bottom\">");

      out.println("<body bgcolor=\"rgb(211,255,213)\">");
   
  //    out.println("<center>");
  //    out.println("<strong>Select Subject</strong>");
  //    out.println("</center>");
      out.println("<br>");

      String std=null;
      std=request.getParameter("standard");


      
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 rs = stmt.executeQuery("SELECT DISTINCT sub_name AS c1 FROM subject where std="+std+";");

                 
                  out.println("<center>");
                 out.println("<select  name=\"subject\" size=\"1\" style=\"font-size:15pt\">");

                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong>");


      out.println("<input type=\"hidden\" name=\"standard\" value=\""+std+"\">");      
      out.println("<input  type=\"submit\" value=\"lJQFI VF5L VF NAFJM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\"></center> ");


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



        out.println("</html>");
        out.println("</form>");


        }
    }
