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


      out.println("<table border=\"0\" width=\"650\" align=\"center\">");
      out.println("<tr><td><strong><font face=\"Lmg-Arun Condensed\" size=\"6\" color=\"blue\">TDFZ[ SIF WMZ6GL m  SIF lJQFIGL 5ZL1FF VF5JL K[ m T[ GLR[ H6FJMP</font></strong></td></tr>");
      out.println("</table>");

      out.println("<br><br><center>");
      out.println("<table border=\"3\" width=\"450\" bordercolor=\"rgb(0,0,255)\">");



                                    




      out.println("<form name=\"isn\" method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/preKasoti\">");

      out.println("<tr><th width=400 height=50 colspan=2><strong><font face=\"Lmg-Arun Condensed\" size=\"6\" color=\"red\">TDFZL DFCLTL VF5M </strong></font> </th></tr>");
      out.println("<tr><th> <p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"\">GFD o </font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"name\" size=\"30\" style=\"font-family:Times New Roman;font-size:15pt\"></strong></th></tr>");

      out.println("<tr><th><p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"\">ZM, G\\AZ</font></p></th> ");
      out.println("<th><p align=\"left\"><input  type=\"text\" name=\"rollno\" size=\"20\" style=\"font-family:Times New Roman;font-size:15pt\" color=\"green\" value=\"\" onKeyUp=\"numericCheck()\"></strong></p></th></tr>");


//********************** <option value=\"computer\">computer</option>
      
      Connection con=null;
      Statement stmt=null,stmt1=null;
      ResultSet rs=null,rs1=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda","jdbcodbc","jdbcodbc");
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();




                 out.println("<tr><th><p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"\">WMZ6 </font></p></th>");
                 out.println("<th><p align=\"left\"><select  name=\"std\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\" >");
                 
                 rs = stmt.executeQuery("SELECT DISTINCT std AS c1 FROM superuser where examtime > 0;");
                 int nRows = 0;
                 while(rs.next() ) {
                                            
                                    int st1 = rs.getInt("c1");
                                    out.println("<option value="+st1+">"+st1+"</option>");
                                   }


                 out.println(" </select> </strong></p></th></tr>");







                 out.println("<tr><th><p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"\">JU\"</font></p></th>");
                 out.println("<th><p align=\"left\"><select  name=\"class\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\" >");
                
                 rs = stmt.executeQuery("SELECT DISTINCT class AS c1 FROM superuser where examtime > 0;");
                 nRows = 0;
                 while(rs.next() ) {
                                            
                                    String cla1 = rs.getString("c1");
                                    out.println("<option value="+cla1+">"+cla1+"</option>");
                                   }


                 out.println(" </select> </strong></p></th></tr>");









                 out.println("<tr><th><p align=\"left\"><strong>&nbsp;&nbsp;&nbsp;<font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"\">lJQFI</font></p></th>");
                 out.println("<th><p align=\"left\"><select  name=\"subject\" size=\"1\" style=\"font-family:Times New Roman;font-size:24pt\" >");
                
                 rs = stmt.executeQuery("SELECT DISTINCT subject AS c1 FROM superuser where examtime > 0;");
                 nRows = 0;
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("c1");
                                    String ccg=cc;
                             //       rs1=stmt1.executeQuery("select subguj as sg from gujsub where subeng='"+cc+"' ;");
                             //       if(rs1.next())
                             //         {
                             //          ccg=rs1.getString("sg");
                             //         }
                                    out.println("<option value="+cc+">"+ccg+"</option>");
                                   }


                 out.println(" </select> </strong></p></th></tr>");

                
      

      out.println("</table>");
      out.println("<br>");


      out.println("<br>");


      out.println("<center><table width=650 border=0>");
      out.println("<tr><td align=\"left\"><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Lmg-Arun Condensed\" size=\"4\">CMD</font></strong>");
      out.println("</a></td>");

         out.println("<th><input type=\"submit\" value=\"5ZL1FF X~ SZJF VF  A8G NAFJM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\" ></th>");

      out.println("<td align=\"right\"><a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
      out.println("<strong><font face=\"Lmg-Arun Condensed\" size=\"4\">CMD</font></strong>");
      out.println("</a></td></tr></table></center>");



//      out.println("<center><input type=\"submit\" value=\"5ZL1FF X~ SZJF VF  A8G NAFJM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\" ></center>");


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



