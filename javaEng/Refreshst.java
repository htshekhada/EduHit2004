import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Refreshst extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");

    //  out.println("<body background=\"c:/jsdk2.0/examples/image4.gif\">");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");
     

//      out.println("<strong><marquee behaviour=\"Alternate\"><font face=\"Latest-Atithi\" size=\"10\">V1FZ .gOM8[S 5|F.J[8 l,lD8[0</marquee></font></strong>");

   out.println("<br><center><strong><font face=\"Times New Roman\" size=5>Section For Rejecting Exam Of One Student</font></strong></center><br>");

      out.println("<br><center>");
      out.println("<table border=\"8\" width=\"450\" >");



                                    




      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Refreshst1\">");

//      out.println("<tr><th width=400 height=50 colspan=2><strong><font face=\"Latest-Atithi\" size=\"6\" color=\"blue\">GLR[ DFU[, DFlCTL VF5MP </strong></font> </th></tr>");
//      out.println("<tr><th> <p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"LMG-Arun\" size=\"4\" color=\"green\">GFD </font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"name\" size=\"30\" style=\"font-size:15pt\"></strong></th></tr>");

      out.println("<tr><th><p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Times New Roman\" size=\"4\" color=\"green\">Roll No.</font></p></th> ");
      out.println("<th><p align=\"left\"><input  type=\"text\" name=\"rollno\" size=\"20\" style=\"font-size:15pt\" color=\"green\"></strong></p></th></tr>");

      out.println("<tr><th><p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Times New Roman\" size=\"4\" color=\"green\">Standard</font></p></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"std\"  size=\"20\" style=\"font-size:15pt\" ></strong></p></th></tr>");
 
      out.println("<tr><th><p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Times New Roman\" size=\"4\" color=\"green\">Class</font></p></th>");
      out.println("<th><p align=\"left\"><input  type=\"text\" name=\"class\" size=\"20\" style=\"font-size:15pt\" ></strong></p></th></tr>");

      out.println("<tr><th><p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Times New Roman\" size=\"4\" color=\"green\">Subject</font></p></th>");
      out.println("<th><p align=\"left\"><select  name=\"subject\" size=\"1\" style=\"font-size:15pt\" >");

//********************** <option value=\"computer\">computer</option>
      
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 rs = stmt.executeQuery("SELECT DISTINCT subject AS c1 FROM biodata;");
                 int nRows = 0;
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }

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


      out.println(" </select> </strong></p></th></tr>");

      

      out.println("</table>");
      out.println("<br>");
                    out.println("<center><b><font face=\"Times New Roman\" size=5>Date</font></b>&nbsp;&nbsp;&nbsp;<select  name=\"date\" size=\"1\" style=\"font-size:15pt\">");

                    for(int ii=0;ii<=31;ii++)
                    {
                    out.println("<option value="+ii+">"+ii+"</option>");
                    }
                    out.println("</select>");
                  //  out.println("</center>");

                    out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");

                    out.println("<b><font face=\"Times New Roman\" size=5>Month</font></b>&nbsp;&nbsp;&nbsp;<select  name=\"month\" size=\"1\" style=\"font-size:15pt\">");

                    for(int j=0;j<=12;j++)
                    {
                    out.println("<option value="+j+">"+j+"</option>");
                    }
                    out.println("</select>");
                    out.println("</center>");


      out.println("<br>");
      out.println("<center><input  type=\"submit\" value=\"Reject The Exam Of Above Given Student\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 1em\"></center> ");

      out.println("</form>");
      out.println("</body>");
      out.println("</html>");
    }
}



