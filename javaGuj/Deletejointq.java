import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Deletejointq extends HttpServlet
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



     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Deletejointq1\">");



//     out.println("<input type=\"hidden\" name=\"stds\" value=\""+s1+"\">");
//     out.println("<input type=\"hidden\" name=\"subs\" value=\""+s2+"\">");
     

     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1= con.createStatement();

                 rs = stmt.executeQuery("SELECT min(queno) as c1 FROM "+s2+s1+" where quefield='joi' and queno >= "+q1+"-2  and chap="+lno+"");
                 rs.next();
                 ccm = rs.getInt("c1");
                 
                 
                 rs = stmt.executeQuery("SELECT max(queno) as c1 FROM "+s2+s1+" where queno >= "+ccm+" and queno <= "+ccm+"+1 and quefield='joi' and chap="+lno+"");
                 rs.next();
                 cc = rs.getInt("c1");
                 

                 out.println("<strong>");
                 out.println("<center>");
                 out.println("<font face=\"Lmg-Arun Condensed\" size=\"4\">5|`GM</font> "+ccm+" <font face=\"Lmg-Arun Condensed\" size=\"4\"> YL </font> "+cc+"");
                 out.println("</center>");
                 out.println("</strong>");
                 out.println("<br>");
                 rs = stmt.executeQuery("SELECT * FROM "+s2+s1+" where queno >= "+ccm+" and queno <= "+ccm+"+1 and quefield='joi' and chap="+lno+" order by queno , wrong1");
                 int nRows = 0;


                out.println("<center>");
                out.println("<table border=\"4\" width=\"100\">");
                out.println("<tr>");
                out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">G\\AZ</font></th>");
                
                out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`G</font></th>");
                out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">HJFA</font></th>");
            //    out.println("<th>JointField </th>");
            //    out.println("<th>TrueAns</th>");
                out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">5F9</font></th>");
                out.println("<th>Delete</th>");
                out.println("</tr>");



                 while(rs.next()) {
                                            

                                    String qno = rs.getString("queno");
                                    String q=rs.getString("que");
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
                                    out.println("<input type=\"text\" name=\""+qno+ww1+"q\" value=\""+q+"\" style=\"font-family:"+fname+";font-size:14pt\">");
                                    out.println("</td>");
                                    
                                    out.println("<td>");
                                    out.println("<input type=\"text\" name=\""+qno+ww1+"r\"  value=\""+right+"\" style=\"font-family:"+fname+";font-size:14pt\">");
                                    out.println("</td>");

                               //     out.println("<td>");
                                    out.println("<input type=\"hidden\" name=\""+qno+ww1+"w1\" value=\""+ww1+"\">");
                              //      out.println("</td>");

                              //      out.println("<td>");
                                    out.println("<input type=\"hidden\" name=\""+qno+ww1+"w2\" value=\""+wrong2+"\">");
                              //      out.println("</td>");

                                    
                                    out.println("<td>");
                                    out.println("<input type=\"text\" name=\""+qno+ww1+"c\" size = 5 value=\""+chap+"\">");
                                    out.println("</td>");
                            //        if(ww1.equals("1"))
                            //         {
                                         out.println("<td>");
                                         out.println("<input type=\"checkbox\" value=\"d\"  name=\""+qno+"d\"> ");
                                         out.println("</td>");
                           //          }

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
     out.println("<input  type=\"submit\" value=\"5|`GM E];JF VF A8G NAFJM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 12pt\">");
     out.println("</center>");
     out.println("</form>");
  

     out.println("<center>");
     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Deletejointq\">");
     out.println("<input type=\"hidden\" value=\""+cc+"+3\" name=\"quen\">");
     out.println("<input type=\"hidden\" value=\""+s1+"\" name=\"std\">");
     out.println("<input type=\"hidden\" value=\""+s2+"\" name=\"sub\">");
     out.println("<input type=\"hidden\" value=\""+lno+"\" name=\"lno\">");
     out.println("<input  type=\"submit\" value=\"ALHF 5|`GM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 12pt\">");
     out.println("<center>");
     out.println("</form>");

   
   
     out.println("</body>");
     out.println("</html>");
    }

}


