import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Echnames extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      PrintWriter out=response.getWriter();


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");

      String std=null;
      std=request.getParameter("standard");

      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Echname1\" target=\"bottom\">");

      out.println("<body bgcolor=\"rgb(211,255,213)\">");
  //    out.println("<br><br><br><br>");
      out.println("<center>");
      out.println("<strong><font face=\"Lmg-Arun Condensed\" size=5>5F9G] GFD NFB, SZJF</font></strong>");
      out.println("</center>");
//      out.println("<br>");
    //********************** <option value=\"computer\">computer</option>
      
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 rs = stmt.executeQuery("SELECT DISTINCT sub_name AS c1 FROM subject where std="+std+";");

                 out.println("&nbsp;&nbsp;&nbsp;<center><strong><font face=\"Lmg-Arun Condensed\" size=5>lJQFIv</font></strong>&nbsp;<select  name=\"subject\" size=\"1\" style=\"font-size:15pt\">");

                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong>");


           //      out.println("<br><br>");

      out.println("<input type=\"hidden\" name=\"standard\" value=\""+std+"\">");
      out.println("<input  type=\"submit\" value=\"VMS[\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 12pt\">");
      
      out.println("</center>");

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
