import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Course extends HttpServlet
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



      String s1=null,c1=null,s2=null;
      int coun1=0,coun2=0,coun3=0,coun4=0,Total=0,coun=0,nrows=0,m1=0,m2=0,m3=0,m4=0;
      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");


      
      s1=request.getParameter("std");
      c1=request.getParameter("class");
      s2=request.getParameter("subject");
      Connection con=null;
      Statement stmt=null,stmt1=null,stmt2=null,stmt3=null;
      ResultSet rs=null;
      ResultSet rs1=null;
      ResultSet rs2=null;
      ResultSet rs3=null;

      s1=request.getParameter("std");
      c1=request.getParameter("class");
      s2=request.getParameter("subject");




      out.println("<form>");
//      out.println(""+s1+","+c1+","+s2+"");
     out.println("<center><strong>The Final Course Setting</strong><br><br></center>");
       

      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1=con.createStatement();
                 stmt2=con.createStatement();
                 stmt3=con.createStatement();

                 stmt.executeUpdate("delete from course where std="+s1+" and class='"+c1+"' and sub='"+s2+"' ");
                 stmt.executeUpdate("delete from course1 where std="+s1+" and class='"+c1+"' and sub='"+s2+"' ");


                 rs = stmt.executeQuery("SELECT DISTINCT chap FROM "+s2+s1+" where std="+s1+" union SELECT DISTINCT chap FROM "+s2+s1+"l where std="+s1+";");
                 while(rs.next())
                 {
                  String cc = rs.getString("chap");
                  stmt1.executeUpdate("insert into course values("+s1+",'"+c1+"','"+s2+"',"+cc+","+request.getParameter(""+cc+"1")+","+request.getParameter(""+cc+"2")+","+request.getParameter(""+cc+"3")+","+request.getParameter(""+cc+"4")+")");
                 }

 //*********for varifying validity***************

                 rs = stmt.executeQuery("SELECT DISTINCT chap FROM "+s2+s1+" where std="+s1+" union SELECT DISTINCT chap FROM "+s2+s1+"l where std="+s1+";");
                 int nRows = 0;
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("chap");
                                  rs1=stmt1.executeQuery("select count(*) as coun from "+s2+s1+" where quefield='opt' and chap="+cc+" ");
                                  rs1.next();
                                  coun1=rs1.getInt("coun");
                        
                                  rs1=stmt1.executeQuery("select count(*) as coun from "+s2+s1+" where quefield='sho' and chap="+cc+" ");
                                  rs1.next();
                                  coun2=rs1.getInt("coun");
                        
                                  rs1=stmt1.executeQuery("select count(*) as coun from "+s2+s1+"l where quefield='lon' and chap="+cc+" ");
                                  rs1.next();
                                  coun3=rs1.getInt("coun");
                        
                                  rs1=stmt1.executeQuery("select count(*) as coun from "+s2+s1+" where quefield='joi' and chap="+cc+" ");
                                  rs1.next();
                                  coun4=rs1.getInt("coun");
                        


                                    
                                    rs1 = stmt1.executeQuery("SELECT maxopt AS mq1 , maxsho AS mq2 , maxlon AS mq3 , maxjoi AS mq4 FROM course where std="+s1+" and class='"+c1+"' and sub='"+s2+"' and chapno="+cc+";");
                                    if(rs1.next())
                                           {
                                             m1 = rs1.getInt("mq1");
                                             m2 = rs1.getInt("mq2");
                                             m3 = rs1.getInt("mq3");
                                             m4 = rs1.getInt("mq4");
                                             if(m1>coun1)
                                                {
                                                 m1=coun1;
                                                }
                                             if(m2>coun2)
                                                {
                                                m2=coun2;
                                                }
                                             if(m3>coun3)
                                                {
                                                m3=coun3;
                                                }
                                             if(m4>coun4)
                                                {
                                                m4=coun4;
                                                }


                                              stmt1.executeUpdate("delete from course where std="+s1+" and class='"+c1+"' and sub='"+s2+"' and chapno="+cc+"");
                                              stmt1.executeUpdate("insert into course values("+s1+",'"+c1+"','"+s2+"',"+cc+","+m1+","+m2+","+m3+","+m4+")");
                                             


                                           }

                                   }



 //*********for varifying validity complete***************

 //*********for variable long*******



                 rs = stmt.executeQuery("SELECT DISTINCT chap AS c1 FROM "+s2+s1+"v where std="+s1+";");
   
                 nRows = 0;
                 while(rs.next() )
                   {
                                            
                                  String chp = rs.getString("c1");


                                  int maxvl=0;

                                  rs1 = stmt1.executeQuery("SELECT DISTINCT rightno,wrongno FROM "+s2+s1+"v where std="+s1+" and chap="+chp+";");
                                  while(rs1.next())
                                  {
                                    int rn=rs1.getInt("rightno");
                                    int wn=rs1.getInt("wrongno");


                              //      rs3 = stmt.executeQuery("select count(*) as cou from "+s2+s1+"v where std="+s1+" and chap="+chp+" and rightno="+rn+" and wrongno="+wn+";");
                              //      rs3.next();
                              //      int rwc=rs3.getInt("cou");




                                    stmt2.executeUpdate("delete * from course1 where std="+s1+" and class='"+c1+"' and sub='"+s2+"' and chapno="+chp+" and rightno="+rn+" and wrongno="+wn+";");
                                    stmt2.executeUpdate("insert into course1 values("+s1+",'"+c1+"','"+s2+"',"+chp+","+rn+","+wn+","+request.getParameter(""+chp+rn+wn+"")+")");


                                  }

                   }

 //*********com for variable long*******



 //******checking validity for varlon****

                 int m5=0,coun5=0;

                 rs = stmt.executeQuery("SELECT DISTINCT chap,rightno,wrongno FROM "+s2+s1+"v where std="+s1+";");
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("chap");
                                    int rn1 = rs.getInt("rightno");
                                    int wn1 = rs.getInt("wrongno");

                                    rs1=stmt1.executeQuery("select count(*) as coun from "+s2+s1+"v where  chap="+cc+" and rightno="+rn1+" and wrongno="+wn1+" ");
                                    rs1.next();
                                    coun5=rs1.getInt("coun");

                                    rs1 = stmt1.executeQuery("SELECT maxvarlon AS mq5 FROM course1 where std="+s1+" and class='"+c1+"' and sub='"+s2+"' and chapno="+cc+" and rightno="+rn1+" and wrongno="+wn1+";");
                                    if(rs1.next())
                                           {
                                             m5 = rs1.getInt("mq5");
                                                                                      
                                             if(m5>coun5)
                                               {
                                                 m5=coun5;
                                               }

                                             stmt2.executeUpdate("delete * from course1 where std="+s1+" and class='"+c1+"' and sub='"+s2+"' and chapno="+cc+" and rightno="+rn1+" and wrongno="+wn1+";");
                                             stmt2.executeUpdate("insert into course1 values("+s1+",'"+c1+"','"+s2+"',"+cc+","+rn1+","+wn1+","+m5+")");

                                            
                                           }


                                   }


 //******com for varlon****







 //*******display setting**********

                 out.println("<center>");
                 out.println("<table border=1>");

                                    out.println("<tr>");
                                    out.println("<th>");
                                    out.println("Chapter");
                                    out.println("</th>");
                                    out.println("<th>");
                                    out.println("Total Marks");
                                    out.println("</th>");
                                    out.println("</tr>");


                 int m=0;
                 rs = stmt.executeQuery("SELECT DISTINCT chap FROM "+s2+s1+" where std="+s1+" union SELECT DISTINCT chap FROM "+s2+s1+"l where std="+s1+" union SELECT DISTINCT chap FROM "+s2+s1+"v where std="+s1+";");
   
                 while(rs.next() ) {
                                            
                                    String cc = rs.getString("chap");

                                    
                                    rs1 = stmt1.executeQuery("SELECT maxopt AS mq1 , maxsho AS mq2 , maxlon AS mq3 , maxjoi AS mq4 FROM course where std="+s1+" and class='"+c1+"' and sub='"+s2+"' and chapno="+cc+";");
                                    if(rs1.next())
                                           {
                                              m1 = rs1.getInt("mq1");
                                              m2 = rs1.getInt("mq2");
                                              m3 = rs1.getInt("mq3");
                                              m4 = rs1.getInt("mq4");

                                             m=m1+m2+m3+m4;

                                           }

                                           int vm1=0,vm2=0,vmt=0;
                                           rs1 = stmt1.executeQuery("select * from course1 where std="+s1+" and class='"+c1+"' and sub='"+s2+"' and chapno="+cc+";");
                                           while(rs1.next())
                                            {
                                              vm1 = rs1.getInt("rightno");
                                              vm2 = rs1.getInt("maxvarlon");
                                              vmt=vm1*vm2;
                                              m=m+vmt;
                                            }
                                           

                                    out.println("<tr>");
                                    out.println("<td>");
                                    out.println(cc);
                                    out.println("</td>");

                                    out.println("<td>");
                                    out.println(m);
                                    out.println("</td>");
                                    out.println("</tr>");

                                    nrows=nrows+m;

                                  }
                 

                 out.println("</table>");
                 out.println("</center>");

                 out.println("<center><br><br><b>Your Exam Marks Are:"+nrows+"</b></center>");
                 if(nrows==0)
                  {
                   stmt2.executeUpdate("delete * from course1 where std="+s1+" and class='"+c1+"' and sub='"+s2+"' ;");
                   stmt1.executeUpdate("delete from course where std="+s1+" and class='"+c1+"' and sub='"+s2+"' ");
                   out.println("<br><center><strong>This Class Has Been Deleted.</strong></center>");
                  }

             }
     catch (Exception e)          {
                                      out.println("<center><font face=\"Times New Roman\" size=\"6\">Value Not Accepted !</font></center>");
                                      out.println("<pre>");
                                    //  out.println(e.getMessage());
                                      out.println("</pre>");
                                     
                                   }

     

     out.println("</form>");
     out.println("</body>");
     out.println("</html>");
    }
}



