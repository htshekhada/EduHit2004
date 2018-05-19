import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Dispscs extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      PrintWriter out=response.getWriter();


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");

      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Dispscs1\" target=\"_parent\">");

      out.println("<body bgcolor=\"rgb(211,255,213)\">");
      out.println("<br>");
      out.println("<center>");
      out.println("<font face=\"Times New Roman\" size=\"5\">Result Of Entire Class For Particular Subject</font>");
      out.println("</center>");
      out.println("<br>");
    //********************** <option value=\"computer\">computer</option>
      
      Connection con=null;
      Statement stmt=null,stmt1=null,stmt2=null,stmt3=null;
      ResultSet rs=null,rs1=null,rs2=null,rs3=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();
                 stmt2 = con.createStatement();
                 stmt3 = con.createStatement();
                 

                 out.println("<center><table border=\"0\">");
                 out.println("<tr><th><font face=\"Times New Roman\" size=\"5\">Standard</font></th><td><select  name=\"standard\" size=\"1\" style=\"font-size:15pt\">");

                 rs = stmt.executeQuery("SELECT DISTINCT std AS c1 FROM subresult;");
                
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong></td></tr>");


      out.println("<tr><th><font face=\"Times New Roman\" size=\"5\">Class</font></th>"); //<td><input type=\"text\" name=\"class\" style=\"font-family:Times New Roman;font-size:15pt\">
                 out.println("<td><select  name=\"class\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\">");
                 rs = stmt.executeQuery("SELECT distinct class AS c1 FROM subresult;");
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong></td></tr>");




      out.println("<tr><th><font face=\"Times New Roman\" size=\"5\">Subject</font></th>");


      out.println("<td><select  name=\"sub\" size=\"1\" style=\"font-size:15pt\">");

//********************** <option value=\"computer\">computer</option>
      
                 rs = stmt.executeQuery("SELECT DISTINCT subject AS c1 FROM subresult;");
                 int nRows = 0;
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }

                    out.println("</select>");
                    out.println("</td></tr></table></center>");


       

      out.println("<input type=\"hidden\" value=\"1\" name=\"quen\">");
      out.println("<br><center><input type=\"submit\" value=\"Push This After Giving Above Information\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 18pt\" ></center>");
//      out.println("&nbsp;&nbsp;");
//      out.println("<input type=\"reset\" name=\"reset\" value=\"Reset\"></center>");

      out.println("<br><br><br><br>");

/*

       rs = stmt.executeQuery("SELECT distinct month1 from result order by month1;");
                
       while(rs.next() ) {
                           int mm1 = rs.getInt("month1");

                           out.println("<table border=1>");
                           out.println("<tr>");
                           out.println("<th>");
                           out.println(mm1);
                           out.println("</th>");
                          

                           int f1=0;

                           rs1 = stmt1.executeQuery("SELECT distinct date1 from result where month1="+mm1+" order by date1;");
                           while(rs1.next())
                             {
                               int dd1 = rs1.getInt("date1");

                               if(f1 != 0)
                                 {
                                 out.println("<th>");
                                 out.println("&nbsp;&nbsp;");
                                 out.println("</th>");
                                 }
                               f1++;

                               out.println("<td>");
                               out.println(dd1);
                               out.println("</td>");

                               

                               rs2 = stmt2.executeQuery("SELECT distinct std,class from result where month1="+mm1+" and date1="+dd1+" order by std,class;");
                               while(rs2.next())
                                 {
                                 int std1 = rs2.getInt("std");
                                 String cl1 = rs2.getString("class");
                                 
                                 rs3 = stmt3.executeQuery("SELECT count(*) as cn from result where month1="+mm1+" and date1="+dd1+" and std="+std1+" and class='"+cl1+"' ");
                                 rs3.next();
                                 int count3 = rs3.getInt("cn");


                                 out.println("<td>");
                                 out.println(""+std1+"-"+cl1+"="+count3+"");
                                 out.println("</td>");

                                 }
                               out.println("</tr>");


                             }
                           out.println("</tr>");
                           out.println("<tr><br></tr>");



                         }
                         out.println("</table>");
      */

                         
             }
      catch (Exception e) {
                                      out.println("could not connect ");
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



        out.println("</html>");
        out.println("</form>");


        }
    }
