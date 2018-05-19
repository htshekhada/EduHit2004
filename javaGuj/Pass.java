import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Pass extends HttpServlet
{

 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      String cu=null,nu=null,cp=null,np=null;
      String ln=null,pwd=null;

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");


      
      cu=request.getParameter("currentu");
      nu=request.getParameter("newu");
      cp=request.getParameter("currentp");
      np=request.getParameter("newp");

      

      Connection con=null;
      Statement stmt=null,stmt1=null;
      ResultSet rs=null;




      out.println("<form>");
      
       

      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1=con.createStatement();
                 

                 rs = stmt.executeQuery("SELECT * FROM login;");
                 while(rs.next())
                      {
                         ln = rs.getString("lname");
                         pwd= rs.getString("pwd");
                      }
                 if(cu.equals(ln) && cp.equals(pwd))
                       {
                        stmt.executeUpdate("delete from login where lname='"+cu+"' and pwd='"+cp+"'");
                        stmt1.executeUpdate("insert into login values('"+nu+"','"+np+"')");
                        out.println("<b><center><font face=\"Lmg-Arun Condensed\" size=\"5\">I]hZGFD VG[ 5F;J0\" AN,L UIM K[P</font></center></b>");
                       }
                 else {
                        out.println("<b><center><font face=\"Lmg-Arun Condensed\" size=\"5\">I]hZGFD S[ 5F;J0\" BM8M K[P</font></center></b>");
                        }

                 
             }
     catch (Exception e)          {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                   }

     

     out.println("</form>");

/*
     out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/Menuframeset\" target=\"_parent\" >");
     out.println("<center>Back to Menu</center>");
     out.println("</a>");
*/
     out.println("</body>");
     out.println("</html>");
    }
}
