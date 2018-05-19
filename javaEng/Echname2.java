import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Echname2 extends HttpServlet
{

 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      String s1=null,s2=null;


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");


      
    //  s1=request.getParameter("std");

      

      Connection con=null;
      Statement stmt=null,stmt1=null,stmt2=null;
      ResultSet rs=null,rs1=null,rs2=null;

      s1=request.getParameter("standard");
      s2=request.getParameter("subject");



      out.println("<form>");
      
       

      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1=con.createStatement();
                 stmt2=con.createStatement();

                 rs = stmt.executeQuery("SELECT DISTINCTROW(chap) as c1 FROM chapname where std="+s1+" and subject='"+s2+"' order by chap;");
                 while(rs.next())
                 {
             //     String std1 = rs.getString("s1");
                  int cno=rs.getInt("c1");
             //     String sub1=rs.getString("s2");

               //t   out.println(cno);
               //t   out.println(request.getParameter(""+cno+""));
             
                  
                  stmt1.executeUpdate("delete * from chapname where std="+s1+" and chap="+cno+" and subject='"+s2+"'; ");
                  con.commit();
                  stmt2.executeUpdate("insert into chapname values("+s1+",'"+s2+"',"+cno+",'"+request.getParameter(""+cno+"")+"')");
                  con.commit();

         
                  rs1 = stmt2.executeQuery("SELECT * FROM "+s2+s1+" where chap="+cno+";");
                  if(!rs1.next())
                            {

                                 Enumeration eParmNames =request.getParameterNames();
                                 while(eParmNames.hasMoreElements()) {
                                                 String name=(String) eParmNames.nextElement();
                                                 String value=request.getParameter(name);
                                      
                                                 if(name.equals(""+cno+"d"))
                                                        {
                                                          out.println(""+cno+",");
                                                          stmt1.executeUpdate("delete * from chapname where std="+s1+" and chap="+cno+" and subject='"+s2+"';");
                                                          con.commit();


                                                        }
                                                 } 


                            }
        

        //           stmt1.executeUpdate("UPDATE chapname SET chname = '"+request.getParameter(""+cno+"")+"' where std="+s1+" and chap="+cno+" and subject='"+s2+"';");
                 }
                 out.println("<br><br><br><br><center><b><font face=\"Times New Roman\" size=5>Your Chapter Name Has Been Inserted, To See It Click Above Ok Button</font></b></center>");
             }
     catch (Exception e)          {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                   }

     

     out.println("</form>");

//     out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/Supmain\" target=\"_parent\">");
//     out.println("<center>Back Home</center>");
//     out.println("</a>");

     out.println("</body>");
     out.println("</html>");
    }
}
