import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Dispscs1 extends HttpServlet
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

      int et=0,cc=0,ccm=0,roll2=0,std2=0;
      String s1=null,s2=null,cl2=null,name2=null,e1=null,sub=null;
      String stdsub=null,q1=null,std=null,cl=null,d1=null,m1=null;
      

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title><CENTER><B>EducationHit : Result Of Whole Class Of Particular Subject</B></CENTER>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");


      std=request.getParameter("standard");
      cl=request.getParameter("class");
      sub=request.getParameter("sub");
  





      Connection con=null;
      Statement stmt=null,stmt1=null,stmt2=null,stmt3=null;
      ResultSet rs=null,rs1=null,rs2=null,rs3=null;

      







     

     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1= con.createStatement();
                 stmt2= con.createStatement();
                 stmt3= con.createStatement();

                 out.println("<center>");                    
             //  out.println("<table border=1>");
                 out.println("<B>STANDARD -&nbsp;&nbsp;&nbsp;&nbsp;"+std+cl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SUBJECT -&nbsp;&nbsp;&nbsp;&nbsp;"+sub+"</B>");
             //  out.println("<tr><td>"+std+"</td><td>"+cl+"</td><td>"+sub+"</td></tr>");
             //  out.println("</table>");
                 out.println("<center>");
             //  out.println("<br>");


                // int number[] = new int[5000];
             
                 int per1=0,ot1=0;
                 int rank=0;
                 int flag=0;

          //       System.out.print("hitesh");

                 out.println("<center>");                    
                 out.println("<table border=1 width=700 bordercolor=blue>");
                 out.println("<tr><th>R.No</th><th>Name</th><th>Total</th><th>Obtain</th><th>Time</th><th>%</th><th>Date</th><th>Rank</th></tr>");
                              
          
                 rs = stmt.executeQuery("SELECT * FROM subresult where  std="+std+" and class='"+cl+"' and subject='"+sub+"'  order by percentage DESC,obtaintime ASC");
                 int nRows = 0;
                 
                 while(rs.next()) {
                                 

                                    int rn=rs.getInt("rollno");
                                    String nm=rs.getString("name");
                                    int tm=rs.getInt("totalmarks");
                                    int om=rs.getInt("obtainmarks");
                                    int ot=rs.getInt("obtaintime");
                                    int per=rs.getInt("percentage");
                                    String dt=rs.getString("date1");

                                 

                                    out.println("<tr>");

                                    out.println("<td align=center>");
                                    out.println(rn);
                                    out.println("</td>");

                                    out.println("<td>");
                                    out.println(nm);
                                    out.println("</td>");

                                    out.println("<td align=center>");
                                    out.println(tm);
                                    out.println("</td>");

                                    out.println("<td align=center>");
                                    out.println(om);
                                    out.println("</td>");

                                    out.println("<td align=center>");
                                    out.println(ot);
                                    out.println("</td>");

                                    out.println("<td align=center>");
                                    out.println(per);
                                    out.println("</td>");

                                    out.println("<td align=center>");
                                    out.println(dt);
                                    out.println("</td>");

                                  
                                    if(rank != 0)
                                    {
                                   //  rs.previous();

                                      if(per == per1 && ot == ot1)
                                        {
                                        flag=0;
                                 //      rs.next();
                        
                                        }
                                      else{
                                          flag=1;
                                          }

                                    }
                                    if(flag == 1)
                                     {
                                     rank++;
                                     }

                                    if(rank == 0)
                                      {
                                       rank++;
                                       }

                                    if(per < 40.0)
                                      {
                                      out.println("<td align=center>");
                                      out.println("Fail");
                                      out.println("</td>");
                                      }
                                    else
                                      {
                                      out.println("<td align=center>");
                                      out.println(rank);
                                      out.println("</td>");
                                      }

                                    out.println("</tr>");

                                   per1=per;
                                  
                                   ot1=ot;
                               

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


  


   
   
     out.println("</body>");
     out.println("</html>");
    }

}


