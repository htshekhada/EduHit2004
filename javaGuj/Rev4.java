import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.*;


public class Rev4 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      String subject=null,std=null,lno=null;

      HttpSession session = request.getSession(true);      
      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
//          response.sendRedirect("/servlet/Login");
//          return;
         }


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      



      out.println("<body bgcolor=\"rgb(133,213,135)\">");

////**********************Inserting into subject table**********
       String  l1,q1,s1,w1,w2,r1,s2;


//             GraphicsEnvironment gEnv =GraphicsEnvironment.getLocalGraphicsEnvironment();
//             String envf[] =gEnv.getAvailableFontFamilyNames();


       ResultSet rs=null;
       Connection con=null;
       Statement stmt=null,stmt1=null;
       out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Rev4s\" target=\"topmiddle\">");

     out.println("<strong><center><font face=\"Lmg-Arun Condensed\">5|`Gv$</font></center></strong> ");
     out.println("</center><strong>");     // Select One Option Out Of Three.

     out.println("<center><strong><font face=\"Lmg-Arun Condensed\">WMZ6</font></strong>");
     out.println(" <strong>");

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

/*             }
      catch (Exception e) {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                       }
  */

   out.println(" </select> </strong>");





     
  //   out.println("<input type=\"text\" name=\"std\" size=\"10\" ></strong>");
    

             }
      catch (Exception e) {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                       }


   

      out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\"1\">");
      out.println("<INPUT TYPE=\"hidden\" NAME= \"bcheck\" VALUE=\"yes\">");


     out.println("<input  type=\"submit\" value=\"VMS[\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 1em\">&nbsp;&nbsp; ");



//      out.println("<br><center>");

/*
       out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/Revfield\" target =\"top\">");
       out.println("Back");
       out.println("</a>");
       out.println("</center>");
*/
   
//     out.println("</form>");

//      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Revfield\" target=\"top\">");
//      out.println("<input type=\"submit\" value=\"Back\">");

      out.println("</form>");
     out.println("</center>");
     out.println("</body>");
     out.println("</html>");
    }
}



