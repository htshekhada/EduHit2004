import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Dispres extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      PrintWriter out=response.getWriter();


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");

      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Dispres1\" target=\"_parent\">");

      out.println("<body bgcolor=\"rgb(211,255,213)\">");
      out.println("<br>");
      out.println("<center>");
      out.println("<strong><font face=\"Times New Roman\" size=\"4\">Result Of Particular Exam Taken Between Paticular Dates.</font></strong>");
      out.println("</center>");
      out.println("<br>");

                              //From:=
      out.println("<center><b></b>");
      
      out.println("<b><font face=\"Times New Roman\" size=\"5\">Date</font></b><select  name=\"fdate\" size=\"1\" style=\"font-size:15pt\">");
      for(int ii=0;ii<=31;ii++)
         {
           out.println("<option value="+ii+">"+ii+"</option>");
         }
      out.println("</select>");



      out.println("<b><font face=\"Times New Roman\" size=\"5\">Month</font></b><select  name=\"fmonth\" size=\"1\" style=\"font-size:15pt\">");
      for(int j=0;j<=12;j++)
         {
           out.println("<option value="+j+">"+j+"</option>");
         }
      out.println("</select>");

      out.println("&nbsp;&nbsp;&nbsp;&nbsp;<b><big><font face=\"Times New Roman\" size=\"5\">To</font></big></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      out.println("<b></b>");
                      //To:=
      out.println("<b><font face=\"Times New Roman\" size=\"5\">Date</font></b><select  name=\"tdate\" size=\"1\" style=\"font-size:15pt\">");
      for(int ii=0;ii<=31;ii++)
         {
           out.println("<option value="+ii+">"+ii+"</option>");
         }
      out.println("</select>");


   
      out.println("<b><font face=\"Times New Roman\" size=\"5\">Month</font></b><select  name=\"tmonth\" size=\"1\" style=\"font-size:15pt\">");
      for(int j=0;j<=12;j++)
         {
           out.println("<option value="+j+">"+j+"</option>");
         }
      out.println("</select>");
      out.println("</center>");


    
      
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
                                              //<b>Exam Message</b>
                 out.println("<br><br><center>");
                 out.println("<select  name=\"exmsg\" size=\"1\" style=\"font-family:Times New Roman;font-size:18pt\">");
                 
                 rs = stmt.executeQuery("SELECT exmmsg AS c1 FROM exmmsg;");
                 int i=0;
                 String[] c1=null;
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");

                                    String s2=cc.replace(' ','!');

                                    out.println("<option value="+s2+">"+cc+"</option>");
                                   }

                 out.println(" </select> </strong></center><br><br>");
                 out.println("<center><strong><font face=\"Times New Roman\" size=\"5\">Standard</font></strong>&nbsp;&nbsp;&nbsp;<select  name=\"std\" size=\"1\" style=\"font-size:15pt\">");

                 rs = stmt.executeQuery("SELECT DISTINCT std AS c1 FROM genresult;");
                
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong>");
                 out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><font face=\"Times New Roman\" size=\"5\">Class</font></strong>&nbsp;&nbsp;&nbsp;"); //<input type=\"text\" name=\"class\">
                 out.println("<select  name=\"class\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\">");
                 rs = stmt.executeQuery("SELECT distinct class AS c1 FROM genresult;");
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }
                 out.println(" </select> </strong></center>");




      out.println("<br><br><center><input type=\"submit\" value=\"Click This After Giving Above Information\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 16pt\" ></center>");
     
//      out.println("<input type=\"reset\" name=\"reset\" value=\"Reset\"></center>");



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


        out.println("</form>");
        out.println("</html>");
      


        }
    }
