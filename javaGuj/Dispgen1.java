import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Dispgen1 extends HttpServlet
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
      String s1=null,s2=null,cl2=null,name2=null,e1=null;
      String stdsub=null,q1=null,std=null,cl=null,d1=null,m1=null;
      

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title><CENTER><B>EducationHit : Result Of Whole Class</B></CENTER>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");



      std=request.getParameter("standard");
      cl=request.getParameter("class");
//      sub=request.getParameter("sub");
  





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



                 //****rank



                 stmt1.executeUpdate("delete * from genrank");
               
                 int obtime=0,rn1=0,first1=0;
                 double tsub=0.0,totper=0.0;
        

          
                 rs = stmt.executeQuery("SELECT distinct(rollno) FROM genresult where  std="+std+" and class='"+cl+"'");
                 int nRows = 0;

                while(rs.next()) {
                                 

                                    int rn=rs.getInt("rollno");

                                    tsub=0.0;
                                    rs1 = stmt1.executeQuery("SELECT * FROM genresult where  std="+std+" and class='"+cl+"' and rollno="+rn+" ");
                                    while(rs1.next())
                                      {
                                      tsub=tsub+1.0;
                                      }
                                    


                                    rs1 = stmt1.executeQuery("SELECT sum(obtainmarks) as om,sum(totalmarks) as tm,sum(obtaintime) as otime FROM genresult where  std="+std+" and class='"+cl+"' and rollno="+rn+" ");
                                    rs1.next();
                                    double om2=rs1.getDouble("om");
                                    double tm2=rs1.getDouble("tm");
                                    int totot=rs1.getInt("otime");

                                    totper=(om2*100)/tm2;
                                  

                                    stmt1.executeUpdate("insert into genrank values("+std+",'"+cl+"',"+rn+","+totot+","+totper+",0) ");


                                   
                                    
                               
                                   }

                                   

                 int rnk=0;
                 int ot3=0;
                 double per3=0.0;
                 

                 rs = stmt.executeQuery("SELECT * FROM genrank where  std="+std+" and class='"+cl+"' order by percentage desc,obtaintime asc");
                 while(rs.next()) {
                                 

                                    int rn=rs.getInt("rollno");
                                    double per1=rs.getDouble("percentage");
                                    int ot1=rs.getInt("obtaintime");


                                    


                                    if(per1!=per3 || ot1!=ot3 && per1 !=0.0 && ot3 !=0)
                                    {
                                          rnk=rnk+1;
                                    }
                                    if(per1 < 40)
                                    {
                                    stmt1.executeUpdate("update genrank set rank=0 where std="+std+" and class='"+cl+"' and rollno="+rn+" ");
                                    }
                                    else
                                    {
                                    stmt1.executeUpdate("update genrank set rank="+rnk+" where std="+std+" and class='"+cl+"' and rollno="+rn+" ");
                                    }
                                    per3=per1;
                                    ot3=ot1;
                                    

                                 }







                 //****rank com***


                 out.println("<center>");
             //  out.println("<table border=1>");
                 out.println("<B>STANDARD -&nbsp;&nbsp;&nbsp;&nbsp;"+std+cl+"</B>");
             //  out.println("<tr><td>"+std+"</td><td>"+cl+"</td><td>"+sub+"</td></tr>");
             //  out.println("</table>");
                 out.println("<center>");
             //  out.println("<br>");


                // int number[] = new int[5000];
             
       
       

               

                 out.println("<center>");                    
                 out.println("<table border=1 width=700 bordercolor=blue>");
                 out.println("<tr><th>R.No</th><th>Name</th><th>Date</th><th>Sub</th><th>Total</th><th>Obtain</th><th>Time</th><th>%</th></tr>");

                 int totmarks=0,obtmarks=0;
                 rn1=0;
                 rs = stmt.executeQuery("SELECT * FROM genresult where  std="+std+" and class='"+cl+"' order by rollno,subject");
               

                while(rs.next()) {
                                 

                                    int rn=rs.getInt("rollno");
                                    String nm=rs.getString("name");
                                    String sub=rs.getString("subject");
                                    int tm=rs.getInt("totalmarks");
                                    int om=rs.getInt("obtainmarks");
                                    int ot=rs.getInt("obtaintime");
                                    int per=rs.getInt("percentage");
                                    String dt=rs.getString("date1");
                                    String mn=rs.getString("month1");





                                    out.println("<tr>");




                                    if(rn == rn1 || rn1==0)
                                    {
                                     totmarks=totmarks+tm;
                                     obtmarks=obtmarks+om;
                                    }
                                    else
                                    {

                                    rs1 = stmt1.executeQuery("SELECT * FROM genrank where  std="+std+" and class='"+cl+"' and  rollno="+rn1+"");
                                    rs1.next();
                                    double per1=rs1.getDouble("percentage");
                                    int ot1=rs1.getInt("obtaintime");
                                    int rank1=rs1.getInt("rank");

                                    out.println("<td align=center>");
                                    
                                    out.println("</td>");

                                    out.println("<td>");
                            //        out.println("Rank :-"+rank1+""); 
                                    out.println("</td>");

                                    out.println("<td align=center>");
                                   
                                    out.println("</td>");


                                    out.println("<td align=right><strong>");
                                    out.println("Total:");
                                    out.println("</strong></td>");

                                    out.println("<td align=center><strong>");
                                    out.println(totmarks);
                                    out.println("</strong></td>");


                                    out.println("<td align=center><strong>");
                                    out.println(obtmarks);
                                    out.println("</strong></td>");



                                    out.println("<td align=center><strong>");
                                    out.println(ot1);
                                    out.println("</strong></td>");

                                    out.println("<td align=center><strong>");
                                    out.println(per1);
                                    out.println("</strong></td>");

                                    
                                    totmarks=0;
                                    obtmarks=0;

                                    out.println("</tr>");
                           //         out.println("<tr>");
                          //          out.println("<td></td><td></td><td></td><td></td><td></td><td></td><td><strong>Rank:</strong></td><td align=center><strong>"+rank1+"</strong></td>");
                          //          out.println("</tr>");
                                    if(per1 < 40)
                                     {
                                    out.println("<tr>");
                                    out.println("<td></td><td></td><td></td><td></td><td></td><td></td><td><strong>Rank:</strong></td><td align=center><strong>Fail</strong></td>");
                                    out.println("</tr>");
                                     }
                                     else
                                     {
                                    out.println("<tr>");
                                    out.println("<td></td><td></td><td></td><td></td><td></td><td></td><td><strong>Rank:</strong></td><td align=center><strong>"+rank1+"</strong></td>");
                                    out.println("</tr>");

                                     }

                                    out.println("<tr>");

                                    }


                                    if(rn != rn1)
                                    {
                                    out.println("<td align=center>");
                                    out.println(rn);
                                    out.println("</td>");

                                    out.println("<td>");
                                    out.println(nm);
                                    out.println("</td>");

                                    if(rn1 != 0)
                                     {
                                    totmarks=totmarks+tm;
                                    obtmarks=obtmarks+om;
                                     }

                                    }
                                    else
                                    {
                                    out.println("<td align=center>");
                                    
                                    out.println("</td>");

                                    out.println("<td>");
                                    
                                    out.println("</td>");

                                    }



                                    rn1=rn;

                                    out.println("<td align=center>");
                                    out.println(""+dt+"/"+mn+"");
                                    out.println("</td>");


                                    out.println("<td align=center>");
                                    out.println(sub);
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
                                    

                                    out.println("</tr>");



                                   
                                    
                               
                                   }

                                    out.println("<tr>");
                                    rs1 = stmt1.executeQuery("SELECT * FROM genrank where  std="+std+" and class='"+cl+"' and  rollno="+rn1+"");
                                    rs1.next();
                                    double per1=rs1.getDouble("percentage");
                                    int ot1=rs1.getInt("obtaintime");
                                    int rank1=rs1.getInt("rank");


                                    out.println("<td align=center>");
                                    
                                    out.println("</td>");

                                    out.println("<td>");
                           
                                    out.println("</td>");

                                    out.println("<td align=center>");
                                   
                                    out.println("</td>");


                                    out.println("<td align=right><strong>");
                                    out.println("Total:");
                                    out.println("</strong></td>");

                                    out.println("<td align=center><strong>");
                                    out.println(totmarks);
                                    out.println("</strong></td>");


                                    out.println("<td align=center><strong>");
                                    out.println(obtmarks);
                                    out.println("</strong></td>");



                                    out.println("<td align=center><strong>");
                                    out.println(ot1);
                                    out.println("</strong></td>");

                                    out.println("<td align=center><strong>");
                                    out.println(per1);
                                    out.println("</strong></td>");


                                    out.println("</tr>");

                                    if(per1 < 40)
                                     {
                                    out.println("<tr>");
                                    out.println("<td></td><td></td><td></td><td></td><td></td><td></td><td><strong>Rank:</strong></td><td align=center><strong>Fail</strong></td>");
                                    out.println("</tr>");
                                     }
                                     else
                                     {
                                    out.println("<tr>");
                                    out.println("<td></td><td></td><td></td><td></td><td></td><td></td><td><strong>Rank:</strong></td><td align=center><strong>"+rank1+"</strong></td>");
                                    out.println("</tr>");

                                     }

                                   


    out.println("</table>");




                 
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


