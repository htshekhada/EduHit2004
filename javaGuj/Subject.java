import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.*;


public class Subject extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       
      HttpSession session = request.getSession(true);      
      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
          response.sendRedirect("/servlet/Login");
          return;
         }
       


       out.println("<html>");
       out.println("<head>");
       out.println("<title>EducationHIT by H.T.Shekhada</title>");



out.println("<SCRIPT LANGUAGE=\"JavaScript\">");

out.println(" var nr=0;");
out.println(" function numericCheck(){");
out.println("  nr1=document.isn.std.value;");
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

out.println("alert(nr1+\"\\r\"+arw+\"\\r  Standard must be NUMARIC. I found \"+flg+\" IS NOT VALID: \"+str+\".\");");

out.println("  }");
out.println(" }");

out.println("</SCRIPT>");







       out.println("</head>");
       out.println("<body bgcolor=\"rgb(211,255,213)\">");
//////*******************font Aray*******************************8


             GraphicsEnvironment gEnv =GraphicsEnvironment.getLocalGraphicsEnvironment();
             String envf[] =gEnv.getAvailableFontFamilyNames();

            


////**********************Inserting into font table**********
       String  f1,fo,s1,d1;

       Connection con=null;
       Statement stmt=null,stmt1=null;
       ResultSet rs=null,rs1=null;
      

       fo=request.getParameter("std");
//       d1=request.getParameter("sub_no");
       f1=request.getParameter("sub_name");
       s1=request.getParameter("F_name");


      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 con.setAutoCommit(true); 
                 stmt = con.createStatement();
            //     stmt1 = con.createStatement();

        if(fo!=null && f1!=null && s1!=null)
           {
          
            String st2=s1.replace('!',' ');
            stmt.executeUpdate("INSERT INTO subject values('"+fo+"','"+f1+"','"+st2+"')");

            stmt.executeUpdate("CREATE TABLE "+f1+fo+" (queno INTEGER,quefield VARCHAR(5),quetype VARCHAR(100),que VARCHAR(255),right1 VARCHAR(255),wrong1 VARCHAR(255),wrong2 VARCHAR(255),std INTEGER,chap INTEGER,fname VARCHAR(50))");
            con.commit();
            stmt.executeUpdate("CREATE TABLE "+f1+fo+"l (queno INTEGER,quefield VARCHAR(5),quetype VARCHAR(100),que VARCHAR(255),right1 VARCHAR(255),wrong1 VARCHAR(255),wrong2 VARCHAR(255),std INTEGER,chap INTEGER,fname VARCHAR(50))");

        //  stmt.executeUpdate("CREATE TABLE "+f1+fo+"l (queno INTEGER,quefield VARCHAR(5),quetype VARCHAR(100),que VARCHAR(100),right1 VARCHAR(100),right2 VARCHAR(100),right3 VARCHAR(100),right4 VARCHAR(100),right5 VARCHAR(100),wrong1 VARCHAR(100),wrong2 VARCHAR(100),wrong3 VARCHAR(100),wrong4 VARCHAR(100),wrong5 VARCHAR(100),std INTEGER,chap INTEGER,fname VARCHAR(50))");
            con.commit();

stmt.executeUpdate("CREATE TABLE "+f1+fo+"v (queno INTEGER,rightno integer,wrongno integer,quetype VARCHAR(100),que VARCHAR(255),right1 VARCHAR(255),right2 VARCHAR(255),right3 VARCHAR(255),right4 VARCHAR(255),right5 VARCHAR(255),right6 VARCHAR(255),right7 VARCHAR(255),right8 VARCHAR(255),right9 VARCHAR(255),right10 VARCHAR(255),right11 VARCHAR(255),right12 VARCHAR(255),right13 VARCHAR(255),right14 VARCHAR(255),right15 VARCHAR(255),right16 VARCHAR(255),right17 VARCHAR(255),right18 VARCHAR(255),right19 VARCHAR(255),right20 VARCHAR(255),wrong1 VARCHAR(255),wrong2 VARCHAR(255),wrong3 VARCHAR(255),wrong4 VARCHAR(255),wrong5 VARCHAR(255),wrong6 VARCHAR(255),wrong7 VARCHAR(255),wrong8 VARCHAR(255),wrong9 VARCHAR(255),wrong10 VARCHAR(255),wrong11 VARCHAR(255),wrong12 VARCHAR(255),wrong13 VARCHAR(255),wrong14 VARCHAR(255),wrong15 VARCHAR(255),wrong16 VARCHAR(255),wrong17 VARCHAR(255),wrong18 VARCHAR(255),wrong19 VARCHAR(255),wrong20 VARCHAR(255),std INTEGER,chap INTEGER,fname VARCHAR(50))");
            con.commit();

            out.println("<center><strong><font face=\"Times New Roman\" size=3 color=\"blue\">Your Subject Successfully Created... </font></strong></center>  ");
            
           }

       }

      catch (Exception e) {
                                      out.println("<center><strong><font face=\"Lmg-Arun Condensed\" size=5 color=\"red\">TDFZM lJQFI NFB, YIM GYL SFIN[;Z lJQFI VG[ WMZ6 VF5M</font></strong></center>  ");
                                      out.println("<pre>");
                                  //    out.println(e.getMessage());
                                      out.println("</pre>");
                                     }
                   finally       {
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
      
        out.println("<form name=\"isn\"  method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Subject\">");
        out.println("<br><br><center><strong>");
        out.println("<font face=\"Lmg-Arun Condensed\" size=7 >GJM lJQFI NFB, SZJF</font>");
        out.println("<br>");
        out.println("</center></strong>");
        out.println("<br>");
        out.println("<center><table border=\"0\">");
        out.println("<tr><td><strong><font face=\"Lmg-Arun Condensed\" size=5 >WMZ6</font></td>");
        out.println("<td><input type=\"text\" name=\"std\" size=\"20\" maxlength=\"5\" onKeyUp=\"numericCheck()\" style=\"font-family:Times New Roman;font-size:15pt\"></strong></td></tr>");
   


        out.println("<tr><td><strong><font face=\"Lmg-Arun Condensed\" size=5 >lJQFIG] GFD</font></td>");
        out.println("<td><input  type=\"text\" name=\"sub_name\" size=\"20\" maxlength=\"50\" style=\"font-family:Times New Roman;font-size:15pt\"></strong></td></tr>");

        out.println("<tr><td><strong><font face=\"Lmg-Arun Condensed\" size=5 >5F9 GFD OMg8</font></td>");

        out.println("<td><select  name=\"F_name\" size=\"1\" style=\"font-family:Times New Roman;font-size:15pt\"></strong>");
        
        for(int i=0;i<envf.length;i++)
        {
        String st1=envf[i].replace(' ','!');
        out.println("<option value="+st1+">"+envf[i]+"</option>");
        }
        out.println("</select></td></tr>");
        out.println("</table></center><br>");


        out.println("<center>");
        out.println("<input type=\"submit\" value=\" lJQFI NFB,\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">&nbsp;&nbsp;&nbsp; ");
  

//        out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/Supmain\">");
//        out.println("Back Home");
//        out.println("</a>");
          out.println("</form>");
          out.println("</center>");
      
        out.println("</body>");
        out.println("</html>");
    }
}

