import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;
public class Deletestdv extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
      HttpSession session = request.getSession(true);
/*      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
          response.sendRedirect("/servlet/Login");
          return;
         }
*/      



      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(133,213,135)\">");

              out.println("<center><strong><font face=\"Lmg-Arun Condensed\" size=\"5\" color=red>5|`Gv5 GF 5|`GM E];JFGM lJEFU</font></strong></center>");
              out.println("<br>");


      out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Deletesubv\" target=\"middleleft\">");




      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;


     out.println("<center>");
     out.println("<strong><font face=\"Lmg-Arun Condensed\" size=\"5\">WMZ6</font>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      ");
     out.println("&nbsp; </strong>");

     out.println("<select  name=\"std\" size=\"1\">");
     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 rs = stmt.executeQuery("SELECT DISTINCT std AS c1 FROM subject;");
                 int nRows = 0;
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }

             }
     catch (Exception e)          {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                   }

     out.println(" </select> </strong>");







      out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      out.println("<input  type=\"submit\" value=\"WMZ6 VF5L VF NAFJM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 12pt\">");
      out.println("</center>");
      out.println("</form>");

      





      out.println("</body>");
      out.println("</html>");

  }
}
