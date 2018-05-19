import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Deletejointq1 extends HttpServlet
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
                                    String wrong1=rs.getString("wrong1");
                                   
                                   
                                 Enumeration eParmNames =request.getParameterNames();
                                 while(eParmNames.hasMoreElements()) {
                                                 String name=(String) eParmNames.nextElement();
                                                 String value=request.getParameter(name);
                                                 if(name.equals(""+qno+"d"))
                                                        {
                                                      
                                                          stmt1.executeUpdate("delete * from "+stdsub+" where queno = "+qno+" and quefield='joi' and chap="+lno+";");
                                                          con1.commit();
                                                          out.println(""+qno+",");

                                                        }
                                                 } 

                                    
                                

                                   }





                        //           stmt1.executeUpdate("delete * from "+stdsub+""); // where queno="+qno+"");
                                   con1.commit();
                                   con1.commit();

                          


                 out.println("<br><br><br><br>");
                 out.println("<font face=\"Lmg-Arun Condensed\" size=\"6\">0L,L8 Y. UIF</font>");
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

