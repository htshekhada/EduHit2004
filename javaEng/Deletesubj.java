import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;
public class Deletesubj extends HttpServlet
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



      out.println("<form method=\"get\" action=\"http://"+request.getServerName()+":8080/servlet/Deletesubjc\" target=\"middleright\">");




      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;


     
     out.println("<center><strong><font face=\"Times New Roman\" size=\"5\">Subject</font>:&nbsp;");
     out.println("</strong>");

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
   

      out.println("<input  type=\"submit\" value=\"Submit Subject\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 12pt\">");
      out.println("</center>");
      out.println("<input type=\"hidden\" name=\"quen\" value=\"0\">");
      out.println("</form>");

      





      out.println("</body>");
      out.println("</html>");

  }
}
