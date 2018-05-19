import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;
public class Fdelete4 extends HttpServlet
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
      out.println("<body bgcolor=\"rgb(211,255,213)\">");


      out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Fdelete5\" target=\"Bottom\">");




      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;


     
     out.println("<center><strong><font face=\"Lmg-Arun Condensed\" size=\"6\">lJQFI</font>:&nbsp;");

     out.println("&nbsp; </strong>");

     out.println("<select  name=\"sub\" size=\"1\">");
     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 rs = stmt.executeQuery("SELECT sub_name AS c1 FROM subject where std="+request.getParameter("std")+";");
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



      out.println("<input type=\"hidden\" name=\"std\" value=\""+request.getParameter("std")+"\">");
      out.println("&nbsp;");
      out.println("<input  type=\"submit\" value=\"AFH]DF\\ VF5[, lJQFI VG[ T[GF 5|`GM E];L GFBM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 12pt\">");

      
      out.println("</center>");
      out.println("<input type=\"hidden\" name=\"quen\" value=\"0\">");
      out.println("</form>");


         out.println("<br><center><form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Deletegenr\">");
out.println("<input  type=\"submit\" value=\"VtIFZ ;]WLDF\\ ,[JFDF\\ VFJ[,L AWL H 5ZL1FFGF 5ZL6FD E];JF VF A8G NAFJM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">");
         out.println("</center></form>");   


      out.println("</body>");
      out.println("</html>");

  }
}
