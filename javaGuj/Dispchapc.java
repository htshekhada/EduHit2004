import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Dispchapc extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      PrintWriter out=response.getWriter();


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");

      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Dispchap1\" target=\"parent\">");

      out.println("<body bgcolor=\"rgb(211,255,213)\">");
    //  out.println("<br>");
  //    out.println("<center>");
  //    out.println("<strong>Select Chapter<strong>");
  //    out.println("</center>");
  //    out.println("<br>");

      String std=null,sub=null;
      std=request.getParameter("standard");
      sub=request.getParameter("subject");

      
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();

                 out.println("<br><center><select  name=\"Chapter\" size=\"1\" style=\"font-size:15pt\">");

                 rs = stmt.executeQuery("SELECT DISTINCT chap FROM "+sub+std+" union SELECT DISTINCT chap FROM "+sub+std+"l union SELECT DISTINCT chap FROM "+sub+std+"v;");
                
                 while(rs.next() ) {
                                   int i=rs.getInt("chap");
                                   out.println("<option value="+i+">"+i+"</option>");
                                   }
                 out.println(" </select> </strong>");
                
      out.println("<input type=\"hidden\" name=\"subject\" value=\""+sub+"\">");                
      out.println("<input type=\"hidden\" name=\"standard\" value=\""+std+"\">");      
      out.println("<input  type=\"submit\" value=\"5F9 VF5L VF NAFJM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\"></center> ");


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
