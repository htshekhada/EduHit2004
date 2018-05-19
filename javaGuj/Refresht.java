import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.lang.Math.*;

public class Refresht extends HttpServlet
{  static int totalque=0;
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
   //   response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      String temp=null;




      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");
    

      Connection con=null,con1=null;
      Statement stmt=null,stmt1=null,stmt2=null,stmt3=null;
      ResultSet rs=null,rs1=null,rs2=null,rs3=null;

      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();
                 stmt2 = con.createStatement();
                 stmt3 = con.createStatement();




//****************** Drop table

                  rs = stmt.executeQuery("select *  from biodata");

                  while(rs.next())
                    {
                                  int r1=rs.getInt("rollno");
                                  int s1=rs.getInt("std");
                                  String c1=rs.getString("class");
                                  String sub=rs.getString("subject");
                                  String opt=rs.getString("optional1");
                                  String sho=rs.getString("short1");
                                  String lon=rs.getString("long1");
                                  String joi=rs.getString("joint1");
                  
         

                        stmt1.executeUpdate(" drop table "+r1+s1+c1+sub+"  ");
          
                        stmt1.executeUpdate("delete * from biodata where rollno="+r1+" and std="+s1+" and class='"+c1+"' and subject='"+sub+"' ");
                        con.commit();
                            
                    }//****while(rs.next()) 
           stmt1.executeUpdate("delete * from result");
           out.println("<br><br><br><br><center><font face=\"Lmg-Arun Condensed\" size=\"5\">CJ[ TD[ GJL 5ZL1FF ,. XSM KM</font></center>");
           }//end of try
          

      catch (Exception e) {
                                      out.println("could not connect : You have to fill the form first");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                          }
        finally {
                      if(rs != null) {
                                            try { rs.close(); }
                                             catch (SQLException ignore)  { }
                                     }
                   if(stmt != null)  {
                                            try { stmt.close(); }
                                            catch (SQLException ignore) { }
                                     }
                   if(con != null)   {
                                             try { con.close(); }
                                             catch (SQLException ignore) { }
                                     }
                  
      
                 
             }
      out.println("</form>");
      out.println("</body>");
      out.println("</html>");
    }
}

