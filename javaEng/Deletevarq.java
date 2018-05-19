import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Deletevarq extends HttpServlet
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

      int et=0,cc=0,ccm=0,qno=0;
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



     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Deletevarq1\">");



//     out.println("<input type=\"hidden\" name=\"stds\" value=\""+s1+"\">");
//     out.println("<input type=\"hidden\" name=\"subs\" value=\""+s2+"\">");
     

     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1= con.createStatement();

                 rs = stmt.executeQuery("SELECT min(queno) as c1 FROM "+s2+s1+"v where  queno > "+q1+" and chap="+lno+"");
                 rs.next();
                 ccm = rs.getInt("c1");
                 
                     

                 out.println("<strong>");
                 out.println("<center>");
                 int mmx=ccm+1;
                 out.println("Questions from "+ccm+" to "+mmx+"");
                 out.println("</center>");
                 out.println("</strong>");
                 out.println("<br>");
                
                 rs = stmt.executeQuery("SELECT * FROM "+s2+s1+"v where queno >= "+ccm+" and queno <= "+ccm+"+1  and chap="+lno+" order by queno ");
                 int nRows = 0;
              

                out.println("<center>");
                out.println("<table border=\"4\" width=\"100\">");



                 while(rs.next()) {
                                            

                                     qno = rs.getInt("queno");


                                    String q=rs.getString("que");
                                    String qt=rs.getString("quetype");
                                    String fname=rs.getString("fname");
                                    int rn = rs.getInt("rightno");
                                    int wn = rs.getInt("wrongno");




                                String ra1 = rs.getString("right1");
                                String ra2 = rs.getString("right2");
                                String ra3 = rs.getString("right3");
                                String ra4 = rs.getString("right4");
                                String ra5 = rs.getString("right5");
                                String ra6 = rs.getString("right6");
                                String ra7 = rs.getString("right7");
                                String ra8 = rs.getString("right8");
                                String ra9 = rs.getString("right9");
                                String ra10 = rs.getString("right10");
                                String ra11 = rs.getString("right11");
                                String ra12 = rs.getString("right12");
                                String ra13 = rs.getString("right13");
                                String ra14 = rs.getString("right14");
                                String ra15 = rs.getString("right15");
                                String ra16 = rs.getString("right16");
                                String ra17 = rs.getString("right17");
                                String ra18 = rs.getString("right18");
                                String ra19 = rs.getString("right19");
                                String ra20 = rs.getString("right20");



                                String wa1 = rs.getString("wrong1");
                                String wa2 = rs.getString("wrong2");
                                String wa3 = rs.getString("wrong3");
                                String wa4 = rs.getString("wrong4");
                                String wa5 = rs.getString("wrong5");
                                String wa6 = rs.getString("wrong6");
                                String wa7 = rs.getString("wrong7");
                                String wa8 = rs.getString("wrong8");
                                String wa9 = rs.getString("wrong9");
                                String wa10 = rs.getString("wrong10");
                                String wa11 = rs.getString("wrong11");
                                String wa12 = rs.getString("wrong12");
                                String wa13 = rs.getString("wrong13");
                                String wa14 = rs.getString("wrong14");
                                String wa15 = rs.getString("wrong15");
                                String wa16 = rs.getString("wrong16");
                                String wa17 = rs.getString("wrong17");
                                String wa18 = rs.getString("wrong18");
                                String wa19 = rs.getString("wrong19");
                                String wa20 = rs.getString("wrong20");
                                    


                                    String chap=rs.getString("chap");

                                 
                out.println("<tr>");

                out.println("<th>Que.No.</th>");
         
                out.println("<th>Que</th>");

                if(rn >= 1) out.println("<th>Right1</th>");
                if(rn >= 2) out.println("<th>Right2</th>");
                if(rn >= 3) out.println("<th>Right3</th>");
                if(rn >= 4) out.println("<th>Right4</th>");
                if(rn >= 5) out.println("<th>Right5</th>");
                if(rn >= 6) out.println("<th>Right6</th>");
                if(rn >= 7) out.println("<th>Right7</th>");
                if(rn >= 8) out.println("<th>Right8</th>");
                if(rn >= 9) out.println("<th>Right9</th>");
                if(rn >= 10) out.println("<th>Right10</th>");
                if(rn >= 11) out.println("<th>Right11</th>");
                if(rn >= 12) out.println("<th>Right12</th>");
                if(rn >= 13) out.println("<th>Right13</th>");
                if(rn >= 14) out.println("<th>Right14</th>");
                if(rn >= 15) out.println("<th>Right15</th>");
                if(rn >= 16) out.println("<th>Right16</th>");
                if(rn >= 17) out.println("<th>Right17</th>");
                if(rn >= 18) out.println("<th>Right18</th>");
                if(rn >= 19) out.println("<th>Right19</th>");
                if(rn >= 20) out.println("<th>Right20</th>");

                if(wn >= 1) out.println("<th>Wrong1</th>");
                if(wn >= 2) out.println("<th>Wrong2</th>");
                if(wn >= 3) out.println("<th>Wrong3</th>");
                if(wn >= 4) out.println("<th>Wrong4</th>");
                if(wn >= 5) out.println("<th>Wrong5</th>");
                if(wn >= 6) out.println("<th>Wrong6</th>");
                if(wn >= 7) out.println("<th>Wrong7</th>");
                if(wn >= 8) out.println("<th>Wrong8</th>");
                if(wn >= 9) out.println("<th>Wrong9</th>");
                if(wn >= 10) out.println("<th>Wrong10</th>");
                if(wn >= 11) out.println("<th>Wrong11</th>");
                if(wn >= 12) out.println("<th>Wrong12</th>");
                if(wn >= 13) out.println("<th>Wrong13</th>");
                if(wn >= 14) out.println("<th>Wrong14</th>");
                if(wn >= 15) out.println("<th>Wrong15</th>");
                if(wn >= 16) out.println("<th>Wrong16</th>");
                if(wn >= 17) out.println("<th>Wrong17</th>");
                if(wn >= 18) out.println("<th>Wrong18</th>");
                if(wn >= 19) out.println("<th>Wrong19</th>");
                if(wn >= 20) out.println("<th>Wrong20</th>");

                out.println("<th>Chap</th>");
                out.println("</tr>");





                                    out.println("<tr>");

                                    out.println("<td>");
                                    out.println(""+qno+"");
                                    out.println("</td>");

                                    

                                    out.println("<td>");
                                    out.println("<input type=\"text\" name=\""+qno+"q\" value=\""+q+"\" style=\"font-family:"+fname+";font-size:14pt\">");
                                    out.println("</td>");
                                    


                                    if(rn >= 1) out.println("<td><input type=\"text\" name=\""+qno+"r1\"  value=\""+ra1+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 2) out.println("<td><input type=\"text\" name=\""+qno+"r2\"  value=\""+ra2+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 3) out.println("<td><input type=\"text\" name=\""+qno+"r3\"  value=\""+ra3+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 4) out.println("<td><input type=\"text\" name=\""+qno+"r4\"  value=\""+ra4+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 5) out.println("<td><input type=\"text\" name=\""+qno+"r5\"  value=\""+ra5+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 6) out.println("<td><input type=\"text\" name=\""+qno+"r6\"  value=\""+ra6+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 7) out.println("<td><input type=\"text\" name=\""+qno+"r7\"  value=\""+ra7+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 8) out.println("<td><input type=\"text\" name=\""+qno+"r8\"  value=\""+ra8+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 9) out.println("<td><input type=\"text\" name=\""+qno+"r9\"  value=\""+ra9+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 10) out.println("<td><input type=\"text\" name=\""+qno+"r10\"  value=\""+ra10+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 11) out.println("<td><input type=\"text\" name=\""+qno+"r11\"  value=\""+ra11+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 12) out.println("<td><input type=\"text\" name=\""+qno+"r12\"  value=\""+ra12+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 13) out.println("<td><input type=\"text\" name=\""+qno+"r13\"  value=\""+ra13+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 14) out.println("<td><input type=\"text\" name=\""+qno+"r14\"  value=\""+ra14+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 15) out.println("<td><input type=\"text\" name=\""+qno+"r15\"  value=\""+ra15+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 16) out.println("<td><input type=\"text\" name=\""+qno+"r16\"  value=\""+ra16+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 17) out.println("<td><input type=\"text\" name=\""+qno+"r17\"  value=\""+ra17+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 18) out.println("<td><input type=\"text\" name=\""+qno+"r18\"  value=\""+ra18+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 19) out.println("<td><input type=\"text\" name=\""+qno+"r19\"  value=\""+ra19+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(rn >= 20) out.println("<td><input type=\"text\" name=\""+qno+"r20\"  value=\""+ra20+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    
                                                                        
                                    if(wn >= 1) out.println("<td><input type=\"text\" name=\""+qno+"w1\" value=\""+wa1+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 2) out.println("<td><input type=\"text\" name=\""+qno+"w2\" value=\""+wa2+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 3) out.println("<td><input type=\"text\" name=\""+qno+"w3\" value=\""+wa3+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 4) out.println("<td><input type=\"text\" name=\""+qno+"w4\" value=\""+wa4+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 5) out.println("<td><input type=\"text\" name=\""+qno+"w5\" value=\""+wa5+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 6) out.println("<td><input type=\"text\" name=\""+qno+"w6\" value=\""+wa6+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 7) out.println("<td><input type=\"text\" name=\""+qno+"w7\" value=\""+wa7+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 8) out.println("<td><input type=\"text\" name=\""+qno+"w8\" value=\""+wa8+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 9) out.println("<td><input type=\"text\" name=\""+qno+"w9\" value=\""+wa9+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 10) out.println("<td><input type=\"text\" name=\""+qno+"w10\" value=\""+wa10+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 11) out.println("<td><input type=\"text\" name=\""+qno+"w11\" value=\""+wa11+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 12) out.println("<td><input type=\"text\" name=\""+qno+"w12\" value=\""+wa12+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 13) out.println("<td><input type=\"text\" name=\""+qno+"w13\" value=\""+wa13+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 14) out.println("<td><input type=\"text\" name=\""+qno+"w14\" value=\""+wa14+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 15) out.println("<td><input type=\"text\" name=\""+qno+"w15\" value=\""+wa15+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 16) out.println("<td><input type=\"text\" name=\""+qno+"w16\" value=\""+wa16+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 17) out.println("<td><input type=\"text\" name=\""+qno+"w17\" value=\""+wa17+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 18) out.println("<td><input type=\"text\" name=\""+qno+"w18\" value=\""+wa18+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 19) out.println("<td><input type=\"text\" name=\""+qno+"w19\" value=\""+wa19+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");
                                    if(wn >= 20) out.println("<td><input type=\"text\" name=\""+qno+"w20\" value=\""+wa20+"\" style=\"font-family:"+fname+";font-size:14pt\"></td>");




                                    out.println("<td>");
                                    out.println("<input type=\"text\" name=\""+qno+"c\" size = 5 value=\""+chap+"\">");
                                    out.println("</td>");


                                    out.println("<td>");
                                    out.println("<input type=\"checkbox\" value=\"DD\"  name=\""+qno+"d\"> ");
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
     out.println("<input  type=\"submit\" value=\"Click This For Delete Checked Question(s)\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 12pt\">");
     out.println("</center>");
     out.println("</form>");
  

     out.println("<center>");
     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Deletevarq\">");
     out.println("<input type=\"hidden\" value=\""+qno+"\" name=\"quen\">");
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


