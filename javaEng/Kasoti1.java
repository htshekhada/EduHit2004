import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;
public class Kasoti1 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
//      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      HttpSession session = request.getSession(true);      
      String  r1,n1,s1,c1,sub,nn1,rad1=null,rad2=null,opttype=null,shorttype=null,longtype=null,jointtype=null,varlontype=null;
      int  a=0,h1=0,m1=0,h2=0,tt1=0,qq1=0,qq2=0,i=0,sec1=0,j=0,bv1=0,tot=0;
      int mopt2=0,msho2=0,mjoi2=0,mlon2=0,mvarlon2=0,extime=0;
      String numopt="1",numsho="1",numlon="1",numjoi="1",numvar="1";
      r1=request.getParameter("roll");
      s1=request.getParameter("stad");
      c1=request.getParameter("clas");
      sub=request.getParameter("subj");
      java.util.Date d1;
      out.println("<html>");
      out.println("<head>");
      out.println("<title>["+r1+"]-["+s1+"]-["+c1+"]-["+sub+"]-EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(133,213,135)\">");
//      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Exam\">");
      Connection con=null;
      Statement stmt=null,stmt1=null;
      ResultSet rs=null,rs1=null;
       nn1=r1+s1+c1+sub;
       d1=new java.util.Date();
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 //       con.setAutoCommit(true); 
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();
                 rs = stmt.executeQuery("select sum(maxvarlon * rightno) as m1 from course1 where std="+s1+" and sub='"+sub+"' and class='"+c1+"' ");
                  rs.next();
                  mvarlon2 =rs.getInt("m1");
                  rs = stmt.executeQuery("select sum(maxopt) as m1,sum(maxsho) as m2,sum(maxlon) as m3,sum(maxjoi) as m4 from course where std="+s1+" and sub='"+sub+"' and class='"+c1+"' ");
                  rs.next();
                  mopt2 =rs.getInt("m1");
                  msho2 = rs.getInt("m2");
                  mlon2 = rs.getInt("m3");
                  mjoi2 = rs.getInt("m4");
                 tot = mopt2 + msho2 + mlon2 + mjoi2  + mvarlon2;
                  if(mvarlon2<=0)
                  {
                  stmt.executeUpdate("UPDATE biodata SET varlon1 ='B' WHERE rollno = "+r1+" and std = "+s1+" and class = '"+c1+"' and subject = '"+sub+"';");
                  }
                  if(mopt2<=0)
                  {
                  stmt.executeUpdate("UPDATE biodata SET optional1 ='B' WHERE rollno = "+r1+" and std = "+s1+" and class = '"+c1+"' and subject = '"+sub+"';");
                  }
                  if(msho2<=0)
                  {
                  stmt.executeUpdate("UPDATE biodata SET short1 ='B' WHERE rollno = "+r1+" and std = "+s1+" and class = '"+c1+"' and subject = '"+sub+"';");
                  }
                  if(mlon2<=0)
                  {
                  stmt.executeUpdate("UPDATE biodata SET long1 ='B' WHERE rollno = "+r1+" and std = "+s1+" and class = '"+c1+"' and subject = '"+sub+"';");
                  }
                 if(mjoi2<=0)
                  {
                  stmt.executeUpdate("UPDATE biodata SET joint1 ='B' WHERE rollno = "+r1+" and std = "+s1+" and class = '"+c1+"' and subject = '"+sub+"';");
                  }
                  rs = stmt.executeQuery("select * from biodata where rollno="+r1+" and std="+s1+" and subject='"+sub+"' and class='"+c1+"' ");
                  rs.next();
                  opttype=rs.getString("optional1");
                  shorttype=rs.getString("short1");
                  longtype=rs.getString("long1");
                  jointtype=rs.getString("joint1");
                  varlontype=rs.getString("varlon1");
                  if(opttype.equals("a") || shorttype.equals("a") || longtype.equals("a") || jointtype.equals("a") || varlontype.equals("a"))
                   {
                      out.println("<center>");
                      out.println("<table border=\"0\" width=\"650\">");
                      out.println("<tr><th><center><font face=\"Times New Roman\" size=\"6\" color=\"rgb(0,0,255)\">Click On The Following Button To Start Respective Exam</font></center></th></tr>");
                      out.println("</table>");
                      out.println("<table border=\"3\" width=\"650\" bordercolor=\"rgb(0,0,255)\">");
                      out.println("<tr><td align=center><font face=\"Times New Roman\" size=\"5\" color=\"red\">Questions</font></td><td align=center><font face=\"Times New Roman\" size=\"5\" color=\"red\">Marks</font></td></tr>");
                   }
                  rs = stmt.executeQuery("select examtime as exm1 from superuser where std="+s1+" and subject='"+sub+"' and class='"+c1+"' ");
                  rs.next();
                  extime=rs.getInt("exm1");
                  rs = stmt.executeQuery("select *  from "+r1+s1+c1+sub+" where type='opt' and ans <> 'hitesh' ");
                  while(rs.next())
                   {
                    numopt=numopt+1;
                   }
                  rs = stmt.executeQuery("select *  from "+r1+s1+c1+sub+" where type='sho' and ans <> 'hitesh' ");
                  while(rs.next())
                   {
                    numsho=numsho+1;
                   }
                  rs = stmt.executeQuery("select *  from "+r1+s1+c1+sub+" where type='lon' and ans <> 'hitesh' ");
                  while(rs.next())
                   {
                    numlon=numlon+1;
                   }
                  rs = stmt.executeQuery("select *  from "+r1+s1+c1+sub+" where type='var' and ans <> 'hitesh' ");
                  while(rs.next())
                   {
                    numvar=numvar+1;
                   }
             }
      catch (Exception e) {
                                      out.println("could not connect : The values you have entered is already exist ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                     }
                   finally       {
                      if(rs != null) {
                                            try { rs.close(); }
                                             catch (SQLException ignore)  { }
                                            }
                   if(stmt != null) {
                                            try { stmt.close(); }
                                            catch (SQLException ignore) { }
                                            }
                   if(con != null)   {
                                             try { con.close(); }
                                             catch (SQLException ignore) { }
                                            }
                  }
              if(opttype.equals("a"))
              {
              out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/preExam\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"subj\" VALUE=\""+sub+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"roll\" VALUE=\""+r1+"\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"stad\" VALUE=\""+s1+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"clas\" VALUE=\""+c1+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"bcheck\" VALUE=\"yes\">");
              out.println("<tr><td><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type=\"submit\" value=\"Q-1: Select One True Answer     \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\"></td> <td align=center><font face=\"Arial\" size=\"4\"> "+mopt2+"</font></td> </tr>");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\""+numopt+"\">");
              out.println("</form>");
              }
              if(shorttype.equals("a"))
              {
              out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/preExam1\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"subj\" VALUE=\""+sub+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"roll\" VALUE=\""+r1+"\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"stad\" VALUE=\""+s1+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"clas\" VALUE=\""+c1+"\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"bcheck\" VALUE=\"yes\">");
              out.println("<tr><td><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type=\"submit\" value=\"Q-2: Write Answer                      \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\"></td><td align=center><font face=\"Arial\" size=\"4\"> "+msho2+"</font></td></tr>");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\""+numsho+"\">");
              out.println("</form>");
              }
              if(longtype.equals("a"))
              {
              out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/preExam2\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"subj\" VALUE=\""+sub+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"roll\" VALUE=\""+r1+"\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"stad\" VALUE=\""+s1+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"clas\" VALUE=\""+c1+"\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"bcheck\" VALUE=\"yes\">");
              out.println("<tr><td><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type=\"submit\" value=\"Q-3: Select One True Answer     \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\"></td><td align=center><font face=\"Arial\" size=\"4\">  "+mlon2+"</font></td></tr>");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\""+numlon+"\">");
              out.println("</form>");
              }
              if(jointtype.equals("a"))
              {
              out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/preExam3\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"subj\" VALUE=\""+sub+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"roll\" VALUE=\""+r1+"\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"stad\" VALUE=\""+s1+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"clas\" VALUE=\""+c1+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"bcheck\" VALUE=\"yes\">");
              out.println("<tr><td><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type=\"submit\" value=\"Q-4: Join The Matches                \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\"></td><td align=center><font face=\"Arial\" size=\"4\"> "+mjoi2+"</font></td></tr>");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\"1\">");
              out.println("</form>");
              }
              if(varlontype.equals("a"))
              {
              out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/preExam4\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"subj\" VALUE=\""+sub+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"roll\" VALUE=\""+r1+"\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"stad\" VALUE=\""+s1+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"clas\" VALUE=\""+c1+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"bcheck\" VALUE=\"yes\">");
              out.println("<tr><td><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type=\"submit\" value=\"Q-5: Select True Answer(s)         \" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\"></td><td align=center><font face=\"Arial\" size=\"4\"> "+mvarlon2+"</font></td></tr>");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\""+numvar+"\">");
              out.println("</form>");
              }
              if(opttype.equals("B") && shorttype.equals("B") && longtype.equals("B") && jointtype.equals("B") && varlontype.equals("B"))
              {
              out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Result\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"subj\" VALUE=\""+sub+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"roll\" VALUE=\""+r1+"\">");
              out.println("<INPUT TYPE=\"hidden\" NAME= \"stad\" VALUE=\""+s1+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"clas\" VALUE=\""+c1+"\">"); 
              out.println("<INPUT TYPE=\"hidden\" NAME= \"bcheck\" VALUE=\"yes\">");
              out.println("<br><br><center><font face=\"Times New Roman\" size=\"7\" color=\"blue\" >Your Exam Has Been Complete</font></center>");
              out.println("<center><font face=\"Times New Roman\" size=\"7\" color=\"blue\" > Click On The Following Button</font></center>");
              out.println("<br><center><table border=\"3\" width=\"\" bordercolor=\"rgb(0,0,255)\">");
              out.println("<tr><td><input  type=\"submit\" value=\"Push This Button To See Your Detail Result\" name=\"start\" style=\"font-family: Times New Roman; font-size: 18pt\"></td></tr>");
              out.println("</form>");
              }
              out.println("<table border=\"0\" width=\"650\"><tr><td><b><font face=\"Times New Roman\" size=\"5\" color = \"red\">Total Marks</font> <font face=\"Arial\" size=\"4\">&nbsp;&nbsp;=&nbsp;&nbsp;"+tot+"</font></td><td align=\"right\"><b><font face=\"Times New Roman\" size=\"5\" color = \"red\">Exam Time</font>&nbsp;&nbsp;=&nbsp;&nbsp;<font face=\"Arial\" size=\"4\">"+extime+"&nbsp;&nbsp;</font><font face=\"Times New Roman\" size=\"5\" >   Minute       </font></b></td> </tr></table>");
      out.println("</table></center>");
      out.println("</body>");
      out.println("</html>");
    }
}



