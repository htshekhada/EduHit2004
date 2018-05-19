import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Updateshoq extends HttpServlet
{
 
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {  
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      
      HttpSession session = request.getSession(true);
/*      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
          response.sendRedirect("/servlet/Login");
          return;
         }
*/      

      int et=0,cc=0,ccm=0;
      String s1=null,s2=null;
      String stdsub=null,q1=null;
      

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");


      q1 = request.getParameter("quen");
      s1=request.getParameter("std");
      s2=request.getParameter("sub");
      stdsub=s2+s1;

      String lno=null;
      lno=request.getParameter("lno");


      Connection con=null;
      Statement stmt=null,stmt1=null;
      ResultSet rs=null,rs1=null;

      
      if ( session != null ) {

                         session.putValue("Stdsub", stdsub);
      
                            }



     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Updateshoq1\">");



//     out.println("<input type=\"hidden\" name=\"stds\" value=\""+s1+"\">");
//     out.println("<input type=\"hidden\" name=\"subs\" value=\""+s2+"\">");
     

     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1= con.createStatement();

                 rs = stmt.executeQuery("SELECT min(queno) as c1 FROM "+s2+s1+" where quefield='sho' and queno >= "+q1+"-5  and chap="+lno+"");
                 rs.next();
                 ccm = rs.getInt("c1");
                 
                 
                 rs = stmt.executeQuery("SELECT max(queno) as c1 FROM "+s2+s1+" where queno >= "+ccm+" and queno <= "+ccm+"+4 and quefield='sho' and chap="+lno+"");
                 rs.next();
                 cc = rs.getInt("c1");
                 

                 out.println("<strong>");
                 out.println("<center>");
                 out.println("Questions from "+ccm+" to "+cc+"");
                 out.println("</center>");
                 out.println("</strong>");
                 out.println("<br>");
                 rs = stmt.executeQuery("SELECT * FROM "+s2+s1+" where queno >= "+ccm+" and queno <= "+ccm+"+4 and quefield='sho' and chap="+lno+" order by queno ");
                 int nRows = 0;


                out.println("<center>");
                out.println("<table border=\"4\" width=\"100\">");
                out.println("<tr>");
                out.println("<th><font face=\"Times New Roman\" size=\"4\">No</font></th>");
                out.println("<th><font face=\"Times New Roman\" size=\"4\">Que Type</font></th>");
                out.println("<th><font face=\"Times New Roman\" size=\"4\">Question</font></th>");
                out.println("<th><font face=\"Times New Roman\" size=\"4\">Right Ans</font></th>");
                
                out.println("<th><font face=\"Times New Roman\" size=\"5\">Chap</font></th>");
                out.println("</tr>");



                 while(rs.next()) {
                                            

                                    String qno = rs.getString("queno");
                                    String q=rs.getString("que");
                                    String qt=rs.getString("quetype");
                                    String right=rs.getString("right1");
                                    String ww1=rs.getString("wrong1");
                                    String fname=rs.getString("fname");
                                    String wrong2=rs.getString("wrong2");
                                    String chap=rs.getString("chap");

                                    out.println("<tr>");

                                    out.println("<td>");
                                    out.println(""+qno+"");
                                    out.println("</td>");

                                    

                                    out.println("<td>");
                                    out.println("<input type=\"text\" name=\""+qno+"qt\" value=\""+qt+"\" style=\"font-family:"+fname+";font-size:14pt\">");
                                    out.println("</td>");

                                    out.println("<td>");
                                    out.println("<input type=\"text\" name=\""+qno+"q\" value=\""+q+"\" style=\"font-family:"+fname+";font-size:14pt\">");
                                    out.println("</td>");
                                    
                                    out.println("<td>");
                                    out.println("<input type=\"text\" name=\""+qno+"r\"  value=\""+right+"\" style=\"font-family:arial;font-size:14pt\">");
                                    out.println("</td>");


                                    
                                    out.println("<td>");
                                    out.println("<input type=\"text\" name=\""+qno+"c\" size = 5 value=\""+chap+"\">");
                                    out.println("</td>");


                                    out.println("</tr>");
                                   }
                 out.println("</table>");
                 out.println("</center>");

             }
     catch (Exception e)          {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                   }


     out.println("<br>");
     out.println("<center>");
     
     out.println("<input type=\"hidden\" value=\""+ccm+"\" name=\"quen\">");
     out.println("<input type=\"hidden\" value=\""+lno+"\" name=\"lno\">");
     out.println("<input  type=\"submit\" value=\"Click This For Updation\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 12pt\">");

     out.println("</center>");
     out.println("</form>");
  

     out.println("<center>");
     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Updateshoq\">");
     out.println("<input type=\"hidden\" value=\""+cc+"+6\" name=\"quen\">");
     out.println("<input type=\"hidden\" value=\""+s1+"\" name=\"std\">");
     out.println("<input type=\"hidden\" value=\""+s2+"\" name=\"sub\">");
     out.println("<input type=\"hidden\" value=\""+lno+"\" name=\"lno\">");
     out.println("<input  type=\"submit\" value=\"Next Questions\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 12pt\">");
     out.println("<center>");
     out.println("</form>");

   
   
     out.println("</body>");
     out.println("</html>");
    }

}


