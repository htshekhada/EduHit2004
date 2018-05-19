import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Coursechmax extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      String s1=null,c1=null,s2=null;
      int totalopt=0,totalsho=0,totallon=0,totaljoi=0,setopt=0,setsho=0,setlon=0,setjoi=0;
      int totalchm=0,totalallchm=0;
 //     int m1,m2,m3,m4;
      
      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");


      
      s1=request.getParameter("std");
      c1=request.getParameter("class");
      s2=request.getParameter("subject");

      out.println("<center><table border=\"2\" width=\"40\">");
      out.println("<tr><th><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">WMZ6v</font></strong><strong>"+s1+"</strong></th><th><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">JU\"v</font></strong><strong>"+c1+"</strong></th><th><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">lJQFIv</font></strong><strong>"+s2+"</strong></th></tr>");
      out.println("</table></center>");

      Connection con=null;
      Statement stmt=null,stmt1=null,stmt2=null,stmt3=null;
      ResultSet rs=null,rs1=null,rs3=null;




     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Course\" target=\"bottom\">");

     out.println("<input type=\"hidden\" name=\"std\" value=\""+s1+"\">");
     out.println("<input type=\"hidden\" name=\"class\" value=\""+c1+"\">");
     out.println("<input type=\"hidden\" name=\"subject\" value=\""+s2+"\">");

     
     out.println("<center>");
     out.println("<table border=\"2\" width=\"\">");
     out.println("<tr>");
     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">5F9 G\\AZ</font></th>");
     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">S], 5|`Gv!</font></th>");
     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`Gv!</font></th>");
     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">S], 5|`GvZ</font></th>");
     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`GvZ</font></th>");
     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">S], 5|`Gv#</font></th>");
     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\"> 5|`Gv#</font></th>");
     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">S], 5|`Gv$</font></th>");
     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`Gv$</font></th>");
     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">S], U]6</font></th>");

     out.println("</tr>");

     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1= con.createStatement();
                 stmt2= con.createStatement();
                 stmt3= con.createStatement();

                 rs = stmt.executeQuery("SELECT DISTINCT chap  FROM "+s2+s1+" where std="+s1+" union SELECT DISTINCT chap  FROM "+s2+s1+"l where std="+s1+";");

                 int nRows = 0;
                 while(rs.next() ) {
                                            
                                  String cc = rs.getString("chap");

                                  rs1=stmt1.executeQuery("select count(*) as coun from "+s2+s1+" where quefield='opt' and chap="+cc+" ");
                                  rs1.next();
                                  int coun1=rs1.getInt("coun");

                                  rs1=stmt1.executeQuery("select count(*) as coun from "+s2+s1+" where quefield='sho' and chap="+cc+" ");
                                  rs1.next();
                                  int coun2=rs1.getInt("coun");

                                  rs1=stmt1.executeQuery("select count(*) as coun from "+s2+s1+"l where quefield='lon' and chap="+cc+" ");
                                  rs1.next();
                                  int coun3=rs1.getInt("coun");
                        
                                  rs1=stmt1.executeQuery("select count(*) as coun from "+s2+s1+" where quefield='joi' and chap="+cc+" ");
                                  rs1.next();
                                  int coun4=rs1.getInt("coun");
                        
                                  int m1=0,m2=0,m3=0,m4=0;       


                                    rs1 = stmt1.executeQuery("SELECT maxopt AS mq1 , maxsho AS mq2 , maxlon AS mq3 , maxjoi AS mq4 FROM course where std="+s1+" and class='"+c1+"' and sub='"+s2+"' and chapno="+cc+";");
                                    if(rs1.next())
                                           {
                                             m1 = rs1.getInt("mq1");
                                             m2 = rs1.getInt("mq2");
                                             m3 = rs1.getInt("mq3");
                                             m4 = rs1.getInt("mq4");
                                           }

                                    totalopt=totalopt+coun1;
                                    totalsho=totalsho+coun2;
                                    totallon=totallon+coun3;
                                    totaljoi=totaljoi+coun4;

                                    setopt=setopt+m1;
                                    setsho=setsho+m2;
                                    setlon=setlon+m3;
                                    setjoi=setjoi+m4;



                                    out.println("<tr>");
                                    out.println("<td>");
                                    out.println(""+cc+"");
                                    out.println("</td>");
                                    out.println("<td>");
                                    out.println(coun1);
                                    out.println("</td>");
                                    out.println("<td width=\"50\">");
                                    out.println("<input type=\"text\" size=\"5\" name=\""+cc+"1\" value=\""+m1+"\">");
                                    out.println("</td>");


                                    out.println("<td>");
                                    out.println(coun2);
                                    out.println("</td>");
                                    out.println("<td width=\"50\">");
                                    out.println("<input type=\"text\" size=\"5\" name=\""+cc+"2\" value=\""+m2+"\">");
                                    out.println("</td>");


                                    out.println("<td>");
                                    out.println(coun3);
                                    out.println("</td>");
                                    out.println("<td width=\"50\">");
                                    out.println("<input type=\"text\" size=\"5\" name=\""+cc+"3\" value=\""+m3+"\">");
                                    out.println("</td>");


                                    out.println("<td>");
                                    out.println(coun4);
                                    out.println("</td>");
                                    out.println("<td width=\"50\">");
                                    out.println("<input type=\"text\" size=\"5\" name=\""+cc+"4\" value=\""+m4+"\">");
                                    out.println("</td>");

                                    totalchm=m1+m2+m3+m4;

                                    out.println("<td>");
                                    out.println(""+totalchm+"");
                                    out.println("</td>");

                                    totalallchm=totalallchm+totalchm;

                                    out.println("</tr>");
                                   }


                  out.println("<tr>");

                  out.println("<th>");
                  out.println("<font face=\"Lmg-Arun Condensed\" size=\"5\">S],</font>");
                  out.println("</th>");

                  out.println("<td>");
                  out.println(""+totalopt+"");
                  out.println("</td>");

                  out.println("<td>");
                  out.println(""+setopt+"");
                  out.println("</td>");

                  out.println("<td>");
                  out.println(""+totalsho+"");
                  out.println("</td>");

                  out.println("<td>");
                  out.println(""+setsho+"");
                  out.println("</td>");

                  out.println("<td>");
                  out.println(""+totallon+"");
                  out.println("</td>");

                  out.println("<td>");
                  out.println(""+setlon+"");
                  out.println("</td>");

                  out.println("<td>");
                  out.println(""+totaljoi+"");
                  out.println("</td>");

                  out.println("<td>");
                  out.println(""+setjoi+"");
                  out.println("</td>");

                  out.println("<td>");
                  out.println(""+totalallchm+"");
                  out.println("</td>");


                  out.println("</tr>");


                 out.println("</table>");
                 out.println("</center>");


      //****FOR variable Long que************

                     out.println("<br><br><center>");
                     out.println("<font face=\"Lmg-Arun Condensed\" size=\"5\"><strong>5|`Gv5  ;FRF HJFAM 5;\\N SZM GM VeIF;S|D</strong>");
                     out.println("</font></center>");


                     out.println("<center>");
                     out.println("<table border=\"2\" width=\"\">");
                     out.println("<tr>");
                     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">5F9 G\\AZ</font></th>");
                     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">;FRF HJFA</font></th>");
                     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">BM8F HJFA</font></th>");
                     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">S], 5|`Gv$</font></th>");
                     out.println("<th><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`Gv$</font></th>");
                     out.println("</tr>");



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



                                    out.println("<tr>");
                                    out.println("<td>");
                                    out.println(chp);
                                    out.println("</td>");

                                  

                                    out.println("<td>"+rn+"</td>");
                                    out.println("<td>"+wn+"</td>");

                                    int rwc=0;
                                    rs3 = stmt3.executeQuery("select count(*) as cou from "+s2+s1+"v where std="+s1+" and chap="+chp+" and rightno="+rn+" and wrongno="+wn+";");
                                    if(rs3.next())
                                    {
                                     rwc=rs3.getInt("cou");
                                    }
                                    out.println("<td>"+rwc+"</td>");

                                    rs3 = stmt3.executeQuery("select * from course1 where std="+s1+" and class='"+c1+"' and sub='"+s2+"' and chapno="+chp+" and rightno="+rn+" and wrongno="+wn+";");
                                    if(rs3.next())
                                    {
                                    maxvl=rs3.getInt("maxvarlon");
                                    }

                                    out.println("<td width=\"50\">");
                                    out.println("<input type=\"text\" size=\"5\" name=\""+chp+rn+wn+"\" value=\""+maxvl+"\">");
                                    out.println("</td>");


                                  }





                   }

               out.println("</table>");
               //*******end of variable Long*****



             }
             
     catch (Exception e)          {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                   }

     
     out.println("<center>");
     out.println("<input  type=\"submit\" value=\"VeIF;S|D GSSL SZL VF A8G NAFJM\" name=\"submit\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\">&nbsp;&nbsp; ");

     out.println("</center>");

     out.println("</form>");
     out.println("</body>");
     out.println("</html>");
    }
}



