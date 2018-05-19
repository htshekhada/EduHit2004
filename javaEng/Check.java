import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Check extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      HttpSession session = request.getSession(true);      
      String  r1,n1,sub=null,nn1=null;
     
          
      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(133,213,135)\">");
//      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Menuframe\">");
      out.println("<center></center>");            

      int m1=0;
      java.util.Date d1;
      d1=new java.util.Date();
      m1=d1.getMinutes();


      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;

      r1=request.getParameter("uname");
      n1=request.getParameter("pwd");

      if ( session != null ) {

                             session.putValue("userid", r1);
                             session.putValue("password", n1);
      
                             }
              if(r1.equals("htshekhada") && n1.equals("premjibapa"))
               {
              out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Cretab\">");
           //   out.println("<center><big><big><font face=\"Lmg-Arun Condensed\" size=\"7\"> CJ[ TD[ lGIFDS lJEFUDF\\ H. XSM KM</font></center></big></big>");
              out.println("<br><br> <br>");
              out.println("<center><big><big>Developed By<br>Shekhada HiteshKumar Trikambhai<br>18,Kailash Nagar Soc.<br>To-Timbavadi,Ta&Dist-Junagadh,Pin-362015<br>Ph(home)-(0285)676644 </center></big></big>");
              out.println("<br><br><br><br> <br>");
              out.println("<center><input  type=\"submit\" value=\"Create Table\"size=\"20\" name=\"OK\"></center><br>");

              out.println("</form>");
              
              }


      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();

                 rs = stmt.executeQuery(""
                                            + " select * from login "
                                                 );
                 while(rs.next())
                  {
                   nn1=rs.getString("lname");
                   sub=rs.getString("pwd");
                   }
                                                
          if((r1.equals(nn1) && n1.equals(sub)) || (r1.equals("htshekhada") && n1.equals("premjibapa")))
              {
             
             
              out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Supmain\">");
              out.println("<center><big><Strong><font color=blue><font face=\"Times New Roman\" size=\"6\">Now You Can Enter Into SuperUser Module</font></font></center></strong></big>");
              out.println("<br><br> <br>");
              out.println("<center><big><big><font color=blue><font face=\"Times New Roman\" size=\"6\">Click Super User Button...</font></center></big></big>");
              out.println("<br><br> <br><br><br><br>");
              out.println("<center><input  type=\"submit\" value=\"Super User\"size=\"20\" name=\"OK\" style=\"font-family: Times New Roman; font-size: 18pt\"></center><br>");

              out.println("</form>");
              

               }

            else
               {
              out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Login\">");
              out.println("<center><big><big><font face=\"Times New Roman\" size=\"7\" color=\"red\">Name Or PassWord Is Incorrect</font> </center></big></big>");
              out.println("<br><br><br> <br>");
              out.println("<center><big><big><font face=\"Times New Roman\" size=\"7\">Click Button To Try Again</font></center></big></big>");
              out.println("<br><br><br> <br>");
              out.println("<center><input  type=\"submit\" value=\"Try Again\"size=\"20\" name=\"OK\" style=\"font-family: Times New Roman; font-size: 18pt\"></center>");
              
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

       out.println("<br><br>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(211,255,213)\">Developed By...</font></center>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(211,255,213)\">Hiteshkumar T. Shekhada</font></center>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(211,255,213)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-2676644</font></center>");


        out.println("</body>");
        out.println("</html>");
   }
}
