import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Updatejointq1 extends HttpServlet
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
                 rs = stmt.executeQuery("SELECT * FROM "+stdsub+" where queno >= "+ccm+" and queno <= "+ccm+"+1 and quefield='joi' and chap="+lno+" order by queno , wrong1");
                
                
                 while(rs.next()) {
                                    


                                    int qno = rs.getInt("queno");
                                    String q=rs.getString("que");
                                    String right=rs.getString("right1");
                                    String ww1=rs.getString("wrong1");
                                    String wrong2=rs.getString("wrong2");
                                    std=rs.getInt("std");
                                    int chap=rs.getInt("chap");

                                   

                                    String qu1=request.getParameter(""+qno+ww1+"q");
                                    stmt1.executeUpdate("UPDATE "+stdsub+" SET que = '"+request.getParameter(""+qno+ww1+"q")+"' WHERE queno = "+qno+" and wrong1='"+ww1+"' and chap="+lno+";");


                                    stmt1.executeUpdate("UPDATE "+stdsub+" SET quetype = '"+request.getParameter(""+qno+ww1+"qt")+"' WHERE queno = "+qno+" and wrong1='"+ww1+"' and chap="+lno+";");

                                    String ri1=request.getParameter(""+qno+ww1+"r");
                                   // out.println(request.getParameter(""+qno+ww1+"q"));
                                    stmt1.executeUpdate("UPDATE "+stdsub+" SET right1 = '"+request.getParameter(""+qno+ww1+"r")+"' WHERE queno = "+qno+" and wrong1='"+ww1+"' and chap="+lno+";");

                                    String wr1= request.getParameter(""+qno+ww1+"w1");
                                  //  out.println(request.getParameter(""+qno+ww1+"r"));
                                    stmt1.executeUpdate("UPDATE "+stdsub+" SET wrong1 = '"+request.getParameter(""+qno+ww1+"w1")+"' WHERE queno = "+qno+" and wrong1='"+ww1+"' and chap="+lno+";");

                                    String wr2=request.getParameter(""+qno+ww1+"w2");
                                  //  out.println(request.getParameter(""+qno+ww1+"w1"));
                                    stmt1.executeUpdate("UPDATE "+stdsub+" SET wrong2 = '"+request.getParameter(""+qno+ww1+"w2")+"' WHERE queno = "+qno+" and wrong1='"+ww1+"' and chap="+lno+";");


                                    String ch1= request.getParameter(""+qno+ww1+"c");
                                  //  out.println(request.getParameter(""+qno+ww1+"w2"));
                                    stmt1.executeUpdate("UPDATE "+stdsub+" SET chap = "+request.getParameter(""+qno+ww1+"c")+" WHERE queno = "+qno+" and wrong1='"+ww1+"' and chap="+lno+";");

                                  //  out.println(""+request.getParameter(""+qno+ww1+"c")+"<br>");
                                    con1.commit();
                             
                                    
                                

                                   }


           /*      rs = stmt.executeQuery("SELECT * FROM "+stdsub+" where queno >= "+ccm+" and queno <= "+ccm+"+1 and quefield='joi' order by queno , wrong1");
               
                
                 while(rs.next()) {
                                    


                                    int qno = rs.getInt("queno");
                                    String q=rs.getString("que");
                                    String right=rs.getString("right1");
                                    String ww1=rs.getString("wrong1");
                                    String wrong2=rs.getString("wrong2");
                                           std=rs.getInt("std");
                                    int chap=rs.getInt("chap");

                                    out.println(qno);
                                   
                                    
                                 //   stmt1.executeUpdate("UPDATE "+stdsub+" SET right1 = '"+request.getParameter(""+qno+ww1+"r")+"' WHERE queno = "+qno+";");
                                    con1.commit();
                             
                                    temp1[i]=qno;
                                    i++;
                                    
                                

                                   }


                 rs = stmt.executeQuery("SELECT * FROM "+stdsub+" where queno >= "+ccm+" and queno <= "+ccm+"+1 and quefield='joi' order by queno , wrong1");
               
                
                 while(rs.next()) {
                                    


                                    int qno = rs.getInt("queno");
                                    String q=rs.getString("que");
                                    String right=rs.getString("right1");
                                    String ww1=rs.getString("wrong1");
                                    String wrong2=rs.getString("wrong2");
                                           std=rs.getInt("std");
                                    int chap=rs.getInt("chap");

                                    out.println(qno);
                                    //UPDATE english1 SET que = 'hitesh'   WHERE queno=9;
                                    
                                //    stmt1.executeUpdate("UPDATE "+stdsub+" SET wrong1 = '"+request.getParameter(""+qno+ww1+"w1")+"' WHERE queno = "+qno+";");
                                    con1.commit();
                             
                                    temp1[i]=qno;
                                    i++;
                                    
                                

                                   }

                 rs = stmt.executeQuery("SELECT * FROM "+stdsub+" where queno >= "+ccm+" and queno <= "+ccm+"+1 and quefield='joi' order by queno , wrong1");


                 while(rs.next()) {
                                    


                                    int qno = rs.getInt("queno");
                                    String q=rs.getString("que");
                                    String right=rs.getString("right1");
                                    String ww1=rs.getString("wrong1");
                                    String wrong2=rs.getString("wrong2");
                                           std=rs.getInt("std");
                                    int chap=rs.getInt("chap");

                                    out.println(qno);
                                    //UPDATE english1 SET que = 'hitesh'   WHERE queno=9;
                                    
                                //    stmt1.executeUpdate("UPDATE "+stdsub+" SET wrong2 = '"+request.getParameter(""+qno+ww1+"w2")+"' WHERE queno = "+qno+";");
                                    con1.commit();
                             
                                    temp1[i]=qno;
                                    i++;
                                    
                                

                                   }



                 rs = stmt.executeQuery("SELECT * FROM "+stdsub+" where queno >= "+ccm+" and queno <= "+ccm+"+1 and quefield='joi' order by queno , wrong1");
               
                
                 while(rs.next()) {
                                    


                                    int qno = rs.getInt("queno");
                                    String q=rs.getString("que");
                                    String right=rs.getString("right1");
                                    String ww1=rs.getString("wrong1");
                                    String wrong2=rs.getString("wrong2");
                                           std=rs.getInt("std");
                                    int chap=rs.getInt("chap");

                                    out.println(qno);
                                   
                                    
                               //     stmt1.executeUpdate("UPDATE "+stdsub+" SET chap = "+request.getParameter(""+qno+ww1+"c")+" WHERE queno = "+qno+";");        
                                    con1.commit();
                             
                                    temp1[i]=qno;
                                    i++;
                                    
                                

                                   }
                    */




                        //           stmt1.executeUpdate("delete * from "+stdsub+""); // where queno="+qno+"");
                                   con1.commit();
                                   con1.commit();

                          


                 out.println("<br><br><br><br>");
                 out.println("Updation complete !");
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

