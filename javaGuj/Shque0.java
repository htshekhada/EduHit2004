import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Shque0 extends HttpServlet
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
          response.sendRedirect("/servlet/Login");
          return;
         }


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      



      out.println("<body bgcolor=\"rgb(133,213,135)\">");

////**********************Inserting into subject table**********
       String  l1,q1,s1,w1,w2,r1,s2,fo2=null,fname=null;



       Connection con=null;
       Statement stmt=null,stmt1=null;
       ResultSet rs=null,rs1=null;


       s2=request.getParameter("subject");
       s1=request.getParameter("std");
       l1=request.getParameter("lno");
       fname=request.getParameter("F_name");
       String fon2=fname.replace('!',' ');

     
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 con.setAutoCommit(true); 
                 stmt = con.createStatement();
                 stmt1= con.createStatement();
                
                        rs=stmt.executeQuery("select fontname as f2 from subject where std="+s1+" and sub_name='"+s2+"'");        
                        rs.next();
                        fo2=rs.getString("f2");

       //***for chapter name***************
                        rs=stmt.executeQuery("select *  from chapname where std="+s1+" and subject='"+s2+"' and chap="+l1+" ");        
                        if(!rs.next()){
                                      stmt1.executeUpdate("insert into chapname values("+s1+",'"+s2+"',"+l1+",'')");
                                      }
      //***for chapter name complete ******


     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Shque1\" target=\"bottom\">");
    
     
     out.println("<center>");
     out.println("<strong><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`GGM 5|SFZ   </font></strong>");
     out.println("&nbsp;&nbsp;&nbsp; <strong>");

     out.println("<font face=\""+fon2+"\" size=\"5\">");
     out.println("<input type=\"text\" name=\"Qtype\" size=\"35\" maxlength=\"100\" style=\"font-family:"+fon2+"\">&nbsp;&nbsp;</strong>");
     out.println("</font>");


     out.println("<input  type=\"radio\" value=\"hit\" checked name=\"hts\"><strong>No Tag</strong>&nbsp;&nbsp;&nbsp;");
     out.println("<input  type=\"radio\" value=\"esh\" name=\"hts\"><strong>HTML Tag</strong>&nbsp;&nbsp;");
     

     
     out.println("<input  type=\"submit\" value=\"VMS[\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 12pt\">");
     out.println("</center>");


      out.println("<INPUT TYPE=\"hidden\" NAME= \"std\" VALUE=\""+s1+"\">");
      out.println("<INPUT TYPE=\"hidden\" NAME= \"F_name\" VALUE=\""+fname+"\">"); 
      out.println("<INPUT TYPE=\"hidden\" NAME= \"lno\" VALUE=\""+l1+"\">");
      out.println("<INPUT TYPE=\"hidden\" NAME= \"subject\" VALUE=\""+s2+"\">");


            } 
        catch(Exception e)
            {
            out.println(e.getMessage());
            }


     out.println("</form>");
     out.println("</body>");
     out.println("</html>");
    }
}



