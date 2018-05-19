import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class geno1r3 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>AnamicaHIT by H.T.Shekhada</title>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");

      String memid=null;
      memid = request.getParameter("memberid");


      out.println("<strong><marquee Behavior=\"Alternate\"><font face=\"Times New Roman\" size=\"4\" color=\"RED\">ANAMICA MARKETING</font></marquee></strong>");
      out.println("<br><center><strong><font face=\"Times New Roman\" size=\"5\" color=\"RED\">Geneology For Round-[3]</font></strong></center>");

    out.println("<br>");

     out.println("<BR><BR><table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");

    out.println("<tr>");
    out.println("<th>No</th>");


    out.println("<th>ID</th>");


    out.println("<th>Name</th>");


    out.println("<th>Intro. ID</th>");


    out.println("<th>Agent ID</th></tr>");

    out.println("<tr><th>LEVEL--0::</th><th></th><th></th><th></th><th></th></tr>");

      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:hitesh");
                 stmt = con.createStatement();


                                  


   //   out.println("<form name=\"isn\" method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/geno1\">");

      
      


      rs = stmt.executeQuery("SELECT *  FROM appform where memberid='"+memid+"';");
      if(rs.next() ) {
                                            
                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");


                          out.println("<tr><th>1</th>");
                          out.println("<th>"+mid+"</th>");
                          out.println("<th>"+appname+"</th>");
                          out.println("<th>"+introid+"</th>");
                          out.println("<th>"+agentid+"</th></tr>");


                        
                        }


    

    out.println("<tr><th>LEVEL--1::</th><th></th><th></th><th></th><th></th></tr>");

    int level1i=0,level2i=0;
    String level11="aa";
    String level12="aa";
    String level13="aa";
    String level21="aa";
    String level22="aa";
    String level23="aa";
    String level24="aa";
    String level25="aa";
    String level26="aa";
    String level27="aa";
    String level28="aa";
    String level29="aa";

    String level1[]={"","",""};
    int number[] = new int[12];


    int num1=0;          
    rs = stmt.executeQuery("SELECT *  FROM round3 where memberid='"+memid+"';");
    if(rs.next())
       num1=rs.getInt("num");

    int tot=0;
    int lvlno=0;

      rs = stmt.executeQuery("SELECT *  FROM round3 where num > "+num1+";");
      while(rs.next() ) {
                                            

                          String mid = rs.getString("memberid");
                          int num2=rs.getInt("num");
                          lvlno++;
                          out.println("<tr><th>"+lvlno+"</th><th>"+mid+"</th><th></th><th></th><th></th></tr>");
                          tot++;
                          if(tot == 3)
                              {
                               out.println("<tr><th>LEVEL--2::</th><th></th><th></th><th></th><th></th></tr>");
                               lvlno=0;
                              }

                          if(tot == 12)
                              {
                               out.println("<tr><th>LEVEL--3::</th><th></th><th></th><th></th><th></th></tr>");
                               lvlno=0;
                              }

                          if(tot == 39)
                              {
                               out.println("<tr><th>SuperHIT</th><th></th><th></th><th></th><th></th></tr>");
                               lvlno=0;
                              }


                   }          




          
                 
     out.println("</table>");

      out.println("<br>");
//      out.println("<p><center><input type=\"submit\" value=\"Submit\" name=\"submit\" >");
//      out.println("&nbsp;&nbsp;&nbsp; <input type=\"reset\" value=\"Reset\" name=\"reset\"></p>");
      out.println("</form></center><br><br><br><br><br>");


       out.println("<center><a href=\"file://c:/anamica/anamica.htm\" >");
      out.println("<font face=\"Times New Roman\" size=5 color=\"RGB(0,0,255)\">Home</font>");  
       out.println("</a></center>");







       out.println("<br><br><br><br><br><center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">Developed By...</font></b></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">Hiteshkumar T. Shekhada</font></b></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-676644</font></b></center>");


      out.println("</body>");
      out.println("</html>");




             }
      catch (Exception e) {
                                      out.println("Please enter all Required Value");
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


//this.destroy();
}
}



