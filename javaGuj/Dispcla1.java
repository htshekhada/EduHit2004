import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Dispcla1 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      PrintWriter out=response.getWriter();


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");

      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Dispcla\" target=\"_parent\">");

      out.println("<body bgcolor=\"rgb(211,255,213)\">");
      out.println("<br>");
      out.println("<center>");
      out.println("<strong><font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"\">SM. 56 WMZ6GF SM. 56 lJQFIGM  lJnFYL\"GM 5|MU|[; ZL5M8\"</font></strong>");
      out.println("</center>");
      out.println("<br><br><br>");
    //********************** <option value=\"computer\">computer</option>
      
      Connection con=null;
      Statement stmt=null,stmt1=null,stmt2=null,stmt3=null;
      ResultSet rs=null,rs1=null,rs2=null,rs3=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();
                 stmt2 = con.createStatement();
                 stmt3 = con.createStatement();
                 


                 out.println("<center><strong><font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"\">WMZ6</font></strong>&nbsp;<select  name=\"std\" size=\"1\" style=\"font-size:15pt\">");

                 rs = stmt.executeQuery("SELECT DISTINCT std AS c1 FROM genresult;");
                
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong>");
                 out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"\">JU\"</font></strong>&nbsp;");  //<input type=\"text\" name=\"class\">
                 out.println("<select  name=\"class\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\">");
                 rs = stmt.executeQuery("SELECT distinct class AS c1 FROM genresult;");
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong>");



                 out.println("<strong>&nbsp;&nbsp;&nbsp;<font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"\">lJQFI</font>");
                 out.println("<select  name=\"subject\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\" >");


                 rs = stmt.executeQuery("SELECT DISTINCT subject AS c1 FROM genresult ;");
                
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }


                 out.println(" </select> </strong>");


      out.println("<br><br><br><br><center><input type=\"submit\" value=\"p5ZGL DFCLTL VF5L VF A8G NAFJM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\" ></center>");
      out.println("&nbsp;&nbsp;");
//      out.println("<input type=\"reset\" name=\"reset\" value=\"Reset\"></center>");



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


        out.println("</form>");
        out.println("</html>");
      


        }
    }
