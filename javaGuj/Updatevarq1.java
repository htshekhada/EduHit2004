import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Updatevarq1 extends HttpServlet
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


      int et=0,std=0;
      String s1=null,s2=null;
      String stdsub=null,ccm=null;
   

      ccm=request.getParameter("quen");

      String lno=null;
      lno=request.getParameter("lno");


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");
     
    

      if ( session != null ) {
                              stdsub = (String) session.getValue("Stdsub");
                              }
   //t   out.println(stdsub + "<BR>");
    

 /*     s1=request.getParameter("stds");
      s2=request.getParameter("subs");
*/



      Connection con=null,con1=null,con2=null;
      Statement stmt=null,stmt1=null,stmt2=null;
      ResultSet rs=null,rs1=null;




     out.println("<form>");


     
     out.println("<center>");

     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 con1 = DriverManager.getConnection("jdbc:odbc:usda");
                 con2 = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1= con1.createStatement();
                 stmt2= con2.createStatement();
               //  rs = stmt.executeQuery("SELECT * FROM "+stdsub+"v where queno >= "+ccm+" and queno <= "+ccm+"+4 and quefield='lon' order by queno ");
                rs = stmt.executeQuery("SELECT * FROM "+stdsub+"v where queno >= "+ccm+" and queno <= "+ccm+"+1 and chap="+lno+" order by queno ");
                
                 while(rs.next()) {
                                    


                                    int qno = rs.getInt("queno");
                                    String q=rs.getString("que");
                                    int rn=rs.getInt("rightno");
                                    int wn=rs.getInt("wrongno");

                                    


                                    std=rs.getInt("std");
                                    int chap=rs.getInt("chap");

                                   

                                    stmt1.executeUpdate("UPDATE "+stdsub+"v SET quetype = '"+request.getParameter(""+qno+"qt")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    stmt1.executeUpdate("UPDATE "+stdsub+"v SET que = '"+request.getParameter(""+qno+"q")+"' WHERE queno = "+qno+" and chap="+lno+";");


                                    if(rn >=1) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right1 = '"+request.getParameter(""+qno+"r1")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=2) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right2 = '"+request.getParameter(""+qno+"r2")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=3) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right3 = '"+request.getParameter(""+qno+"r3")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=4) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right4 = '"+request.getParameter(""+qno+"r4")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=5) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right5 = '"+request.getParameter(""+qno+"r5")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=6) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right6 = '"+request.getParameter(""+qno+"r6")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=7) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right7 = '"+request.getParameter(""+qno+"r7")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=8) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right8 = '"+request.getParameter(""+qno+"r8")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=9) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right9 = '"+request.getParameter(""+qno+"r9")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=10) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right10 = '"+request.getParameter(""+qno+"r10")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=11) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right11 = '"+request.getParameter(""+qno+"r11")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=12) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right12 = '"+request.getParameter(""+qno+"r12")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=13) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right13 = '"+request.getParameter(""+qno+"r13")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=14) if(rn >=1) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right14 = '"+request.getParameter(""+qno+"r14")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=15) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right15 = '"+request.getParameter(""+qno+"r15")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=16) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right16 = '"+request.getParameter(""+qno+"r16")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=17) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right17 = '"+request.getParameter(""+qno+"r17")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=18) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right18 = '"+request.getParameter(""+qno+"r18")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=19) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right19 = '"+request.getParameter(""+qno+"r19")+"' WHERE queno = "+qno+" and chap="+lno+";");
                                    if(rn >=20) stmt1.executeUpdate("UPDATE "+stdsub+"v SET right20 = '"+request.getParameter(""+qno+"r20")+"' WHERE queno = "+qno+" and chap="+lno+";");



                                    if(wn >= 1) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong1 = '"+request.getParameter(""+qno+"w1")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 2) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong2 = '"+request.getParameter(""+qno+"w2")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 3) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong3 = '"+request.getParameter(""+qno+"w3")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 4) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong4 = '"+request.getParameter(""+qno+"w4")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 5) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong5 = '"+request.getParameter(""+qno+"w5")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 6) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong6 = '"+request.getParameter(""+qno+"w6")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 7) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong7 = '"+request.getParameter(""+qno+"w7")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 8) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong8 = '"+request.getParameter(""+qno+"w8")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 9) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong9 = '"+request.getParameter(""+qno+"w9")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 10) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong10 = '"+request.getParameter(""+qno+"w10")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 11) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong11 = '"+request.getParameter(""+qno+"w11")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 12) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong12 = '"+request.getParameter(""+qno+"w12")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 13) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong13 = '"+request.getParameter(""+qno+"w13")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 14) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong14 = '"+request.getParameter(""+qno+"w14")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 15) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong15 = '"+request.getParameter(""+qno+"w15")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 16) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong16 = '"+request.getParameter(""+qno+"w16")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 17) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong17 = '"+request.getParameter(""+qno+"w17")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 18) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong18 = '"+request.getParameter(""+qno+"w18")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 19) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong19 = '"+request.getParameter(""+qno+"w19")+"' WHERE queno = "+qno+" ;");
                                    if(wn >= 20) stmt1.executeUpdate("UPDATE "+stdsub+"v SET wrong20 = '"+request.getParameter(""+qno+"w20")+"' WHERE queno = "+qno+" ;");
                                    

                                    stmt1.executeUpdate("UPDATE "+stdsub+"l SET chap = "+request.getParameter(""+qno+"c")+" WHERE queno = "+qno+" ;");

                                    con1.commit();
                             
                                    
                                

                                   }






                      
                                   con1.commit();
                                   con1.commit();

                          


                 out.println("<br><br><br>");
                 out.println("<font face=\"Lmg-Arun Condensed\" size=\"6\">V50[8 Y. UIF</font>");
                 out.println("</center>");

             }
     catch (Exception e)          {
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
                   if(stmt != null)  {
                                            try { stmt.close(); }
                                            catch (SQLException ignore) { }
                                     }
                   if(stmt1 != null)  {
                                            try { stmt1.close(); }
                                            catch (SQLException ignore) { }
                                     }
                   if(stmt2 != null)  {
                                            try { stmt2.close(); }
                                            catch (SQLException ignore) { }
                                     }

                   if(con != null)   {
                                             try { con.close(); }
                                             catch (SQLException ignore) { }
                                     }
                  }

  

     out.println("</form>");



     out.println("</body>");
     out.println("</html>");
    }

}

