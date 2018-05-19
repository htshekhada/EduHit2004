import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.lang.Math.*;

public class Refreshst1 extends HttpServlet
{  static int totalque=0;
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
   //   response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      String temp=null;

       String r1=null,s1=null,c1=null,sub=null,nn1=null,date1=null,month1=null;

       r1=request.getParameter("rollno");
       s1=request.getParameter("std");
       c1=request.getParameter("class");
       sub=request.getParameter("subject");
       date1=request.getParameter("date");
       month1=request.getParameter("month");

       nn1=r1+s1+c1+sub;



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
         

               stmt1.executeUpdate(" drop table "+r1+s1+c1+sub+"  ");
               rs=stmt.executeQuery("select * from biodata where rollno="+r1+" and std="+s1+" and class='"+c1+"' and subject='"+sub+"'");
               if(rs.next())
               {
               stmt1.executeUpdate("delete * from biodata where rollno="+r1+" and std="+s1+" and class='"+c1+"' and subject='"+sub+"' ");
               }

               rs=stmt.executeQuery("select * from result where roll_no="+r1+" and std="+s1+" and class='"+c1+"' and sub='"+sub+"' and date1="+date1+" and month1="+month1+" ");
               if(rs.next())
               {

               stmt1.executeUpdate("delete * from result where roll_no="+r1+" and std="+s1+" and class='"+c1+"' and sub='"+sub+"' and date1="+date1+" and month1="+month1+" ");
               }

               rs=stmt.executeQuery("select * from subresult where rollno="+r1+" and std="+s1+" and class='"+c1+"' and subject='"+sub+"' ");
               if(rs.next())
               {

               stmt1.executeUpdate("delete * from subresult where rollno="+r1+" and std="+s1+" and class='"+c1+"' and subject='"+sub+"' ");
               }

               rs=stmt.executeQuery("select * from genresult where rollno="+r1+" and std="+s1+" and class='"+c1+"' and subject='"+sub+"' and date1="+date1+" and month1="+month1+"");
               if(rs.next())
               {

               stmt1.executeUpdate("delete * from genresult where rollno="+r1+" and std="+s1+" and class='"+c1+"' and subject='"+sub+"' and date1="+date1+" and month1="+month1+" ");
               }
               con.commit();
                            
       

           out.println("<br><br><br><center><font face=\"Lmg-Arun Condensed\" size=5>lJnFYL\" ZLO|[X</font></center>");
           }//end of try
          

      catch (Exception e) {
                                      out.println("<center><font face=\"Lmg-Arun Condensed\" size=\"6\">:JLSFZ[, GYLP</font></center>");

                                      out.println("<pre>");
                                    //  out.println(e.getMessage());
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

