import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class form extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");





out.println("<SCRIPT LANGUAGE=\"JavaScript\">");

out.println(" var nr=0;");
out.println(" function numericCheck(){");
out.println("  nr1=document.isn.rollno.value;");
out.println("  flg=0;");
out.println("  str=\"\";");
out.println("  spc=\"\"");
out.println("  arw=\"\";");
out.println("  for (var i=0;i<nr1.length;i++){");
out.println("   cmp=\"0123456789\"");
out.println("   tst=nr1.substring(i,i+1)");
out.println("   if (cmp.indexOf(tst)<0){");
out.println("    flg++;");
out.println("    str+=\" \"+tst;");
out.println("    spc+=tst;");
out.println("    arw+=\"^\";");
out.println("   }");
out.println("   else{arw+=\"_\";}");
out.println("  }");
out.println("  if (flg!=0){");
out.println("   if (spc.indexOf(\" \")>-1) {");
out.println("    str+=\" and a space\";");
out.println("    }");

out.println("alert(nr1+\"\\r\"+arw+\"\\r  ROLL NO. must be NUMARIC. I found \"+flg+\" IS NOT VALID: \"+str+\".\");");

out.println("  }");
out.println(" }");

out.println("</SCRIPT>");


out.println("</head>");



    //  out.println("<body background=\"c:/jsdk2.0/examples/image4.gif\">");
    //  out.println("<body bgcolor=\"rgb(254,255,225)\">");
      out.println("<body bgcolor=\"rgb(133,213,135)\">");


      out.println("<center><table border=\"0\" width=\"\" >");
      out.println("<tr><th><strong><font face=\"Times New Roman\" size=\"6\" color=\"blue\">Type Your Information Below.</font></strong></th></tr>");
      out.println("</table></center>");

      out.println("<br><br><center>");
      out.println("<table border=\"3\" width=\"\" bordercolor=\"rgb(0,0,255)\">");



                                    




      out.println("<form name=\"isn\" method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/preKasoti\">");

      out.println("<tr><th width=400 height=50 colspan=2><strong><font face=\"Times New Roman\" size=\"6\" color=\"red\">Give Your Details...</strong></font> </th></tr>");
      out.println("<tr><th> <p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Times New Roman\" size=\"5\" color=\"\">Name</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"name\" size=\"30\" style=\"font-family:Times New Roman;font-size:15pt\"></strong></th></tr>");

      out.println("<tr><th><p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Times New Roman\" size=\"5\" color=\"\">Roll Number</font></p></th> ");
      out.println("<th><p align=\"left\"><input  type=\"text\" name=\"rollno\" size=\"20\" style=\"font-family:Times New Roman;font-size:15pt\" color=\"green\" value=\"\" onKeyUp=\"numericCheck()\"></strong></p></th></tr>");


//********************** <option value=\"computer\">computer</option>
      
      Connection con=null;
      Statement stmt=null,stmt1=null;
      ResultSet rs=null,rs1=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();




                 out.println("<tr><th><p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Times New Roman\" size=\"5\" color=\"\">Standard</font></p></th>");
                 out.println("<th><p align=\"left\"><select  name=\"std\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\" >");
                 
                 rs = stmt.executeQuery("SELECT DISTINCT std AS c1 FROM superuser where examtime > 0;");
                 int nRows = 0;
                 while(rs.next() ) {
                                            
                                    int st1 = rs.getInt("c1");
                                    out.println("<option value="+st1+">"+st1+"</option>");
                                   }


                 out.println(" </select> </strong></p></th></tr>");







                 out.println("<tr><th><p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Times New Roman\" size=\"5\" color=\"\">Class</font></p></th>");
                 out.println("<th><p align=\"left\"><select  name=\"class\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\" >");
                
                 rs = stmt.executeQuery("SELECT DISTINCT class AS c1 FROM superuser where examtime > 0;");
                 nRows = 0;
                 while(rs.next() ) {
                                            
                                    String cla1 = rs.getString("c1");
                                    out.println("<option value="+cla1+">"+cla1+"</option>");
                                   }


                 out.println(" </select> </strong></p></th></tr>");









                 out.println("<tr><th><p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Times New Roman\" size=\"5\" color=\"\">Subject</font></p></th>");
                 out.println("<th><p align=\"left\"><select  name=\"subject\" size=\"1\" style=\"font-family:Times New Roman;font-size:18pt\" >");




                 rs = stmt.executeQuery("SELECT DISTINCT subject AS c1 FROM superuser where examtime > 0;");
                 nRows = 0;
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    out.println("<option value="+cc+">"+cc+"</option>");
                                   }


                 out.println(" </select> </strong></p></th></tr>");

                
      

      out.println("</table>");
      out.println("<br>");


      out.println("<br>");

      out.println("<center><table width=650 border=0>");
      out.println("<tr><td align=\"left\"><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Times New Roman\" size=\"4\">Home</font></strong>");
      out.println("</a></td>");

      out.println("<th><input type=\"submit\" value=\"Click This Button To Start Exam\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 18pt\" ></th>");

      out.println("<td align=\"right\"><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Times New Roman\" size=\"4\">Home</font></strong>");
      out.println("</a></td></tr></table></center>");


//      out.println("&nbsp;&nbsp;&nbsp; <input type=\"reset\" value=\"Reset\" name=\"reset\"></p>");
      out.println("</form>");
      out.println("</body>");
      out.println("</html>");




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

/*

      out.println(" </select> </strong></p></th></tr>");

      

      out.println("</table>");
      out.println("<br>");


      out.println("<br>");
      out.println("<p><input type=\"submit\" value=\"Submit\" name=\"submit\">&nbsp;&nbsp;&nbsp; <input type=\"reset\" value=\"Reset\" name=\"reset\"></p>");
      out.println("</form>");
      out.println("</body>");
      out.println("</html>");
*/

//this.destroy();
}
}



