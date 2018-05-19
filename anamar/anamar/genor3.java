import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class genor3 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>AnamicaHIT by H.T.Shekhada</title>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");


      out.println("<strong><marquee Behavior=\"Alternate\"><font face=\"Times New Roman\" size=\"4\" color=\"RED\">ANAMICA MARKETING</font></marquee></strong>");
      out.println("<br><center><strong><font face=\"Times New Roman\" size=\"5\" color=\"RED\">Geneology For Round-[3]</font></strong></center>");
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:hitesh");
                 stmt = con.createStatement();


                                  


      out.println("<form name=\"isn\" method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/geno1r3\">");

      

  out.println("<center><select  name=\"memberid\" size=\"1\" style=\"font-family:Times New Roman;font-size:\" >");
                
      rs = stmt.executeQuery("SELECT memberid AS c1 FROM round3 ;");
      while(rs.next() ) {
                                            
                          String st1 = rs.getString("c1");
                          out.println("<option value="+st1+">"+st1+"</option>");
                        }


     out.println(" </select> </strong></center>");




     

          
                 


      out.println("<br>");
      out.println("<p><center><input type=\"submit\" value=\"Submit\" name=\"submit\" >");
//      out.println("&nbsp;&nbsp;&nbsp; <input type=\"reset\" value=\"Reset\" name=\"reset\"></p>");
      out.println("</form></center><br><br><br><br><br>");


       out.println("<center><a href=\"file://c:/anamica/anamica.htm\" >");
      out.println("<font face=\"Times New Roman\" size=5 color=\"RGB(0,0,255)\">Home</font>");  
       out.println("</a></center>");







       out.println("<br><br><br><br><br><center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">Developed By...</font></b></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">Hiteshkumar T. Shekhada</font></b></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-676644</font></b></center>");


      out.println("</body>");
      out.println("</html>");




             }
      catch (Exception e) {
                                      out.println("Please enter all Required Value");
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


//this.destroy();
}
}



