import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.lang.Math.*;
public class Revsho1 extends HttpServlet
{  static int expcnt=0;
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
//      response.setContentType("text/raw-html");
      PrintWriter out=response.getWriter();
//      if(expcnt >= 4 )
//        { response.sendRedirect("/servlet/Democom");
//          return; }
      expcnt=expcnt+1;
      int i=0,a,p,j=0,flag1=0;
      int state=0,state1=0,qno=1,cc2=0,cc3=0,cc4=0,h1=0,m1=0,ch=0,ce=0,ce1=0,ce2=0,ce3=0;
      int hhtt=0,sq1=0,jj=0,x1=0;
      String sub,st=null,qn1,ans=null,chk,hv2,hv3,cl,rollno,std,fon,opt1,temp=null,bcheck1=null; 
      String no1="a",lno=null,ans1=null;
      String[] hvv1=null;
      java.util.Date d1;
      d1=new java.util.Date();
      Random r1=new Random();
      Random r2=new Random();   
      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");
//      out.println("<body background=\"c:/onlinexam/img/3.jpg\">");
      Connection con=null,con1=null;
      Statement stmt=null,stmt1=null,stmt2=null,stmt3=null;
      ResultSet rs=null,rs1=null,rs2=null,rs3=null;
      sub=request.getParameter("subject");
      qn1=request.getParameter("qqn");
      lno=request.getParameter("lno");      
//      cl=request.getParameter("clas");
      std=request.getParameter("std");
      no1=request.getParameter("num");
//      opt1=request.getParameter("opt");
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();
                 stmt2 = con.createStatement();
                 stmt3 = con.createStatement();
                 String fname=null;
                 rs2 = stmt2.executeQuery("select fontname as fn from subject where std="+std+" and sub_name='"+sub+"';");
                 rs2.next();
                 fname=rs2.getString("fn");
                 String cname=null;
                 rs = stmt.executeQuery("select chname from chapname where chap="+lno+" and std="+std+" and subject='"+sub+"'and chap="+lno+"");
                     while(rs.next()) {
                                       cname = rs.getString("chname");
                                       out.println("<center><b>( <font face=\"Times New Roman\">Chap</font><font face=\"arial\">:-"+lno+")&nbsp</font><font face=\""+fname+"\">"+cname+"</font></b></center>");
                                      }
                h1=d1.getHours();
                m1=d1.getMinutes();
                int  sec1=d1.getSeconds();
                h1=h1*3600+m1*60+sec1;
                if(state==0 && state1==0)
                  {
                  Enumeration  eParmNames =request.getParameterNames();
                  while(eParmNames.hasMoreElements())
                              {
                                String name=(String) eParmNames.nextElement();
                                String value=request.getParameter(name);

                                if(name.equals("r1"))
                                                 {
                                                    rs = stmt.executeQuery("SELECT * FROM "+sub+std+" where queno="+qn1+" and quefield='sho'");
                                                    rs.next();
                                                    ch = rs.getInt("chap");
                                                    ans1=rs.getString("right1");
                                                 //    if(!value.equalsIgnoreCase(ans1))
                                                    if(!value.equals(ans1))
                                                      {
                                                       flag1=1;
                                                      }
                                                  }
                              }
              }
out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Revsho1\">");
int count3=1;
i=no1.length();
if(flag1==1)
{
i--;
}
//out.println(i);
//out.println(count3);
//out.println(sub+std);
//out.println(lno);
     rs = stmt.executeQuery("select count(*) as totque from "+sub+std+" where chap="+lno+" and quefield='sho'");
     rs.next();
     int count4=rs.getInt("totque");
     rs = stmt.executeQuery("select * from "+sub+std+" where chap="+lno+" and quefield='sho' order by queno");
     while(rs.next()) {
                                int c1 = rs.getInt("queno");
                                String c2 = rs.getString("que");
                                String c3 = rs.getString("right1");
                                if(i==count3)
                                  {
                                         rs = stmt.executeQuery("select quetype as fn from "+sub+std+" where queno="+c1+" ");
                                         rs.next();
                                         String exmmsg=rs.getString("fn");
                                         rs1 = stmt1.executeQuery("select fname as fn from "+sub+std+" where quefield='sho' and queno="+c1+" ");
                                         rs1.next();
                                         fon=rs1.getString("fn");
                                        out.println("<div align=\"center\"><center>");                            //rgb(255,183,111)     cmyk(0,0,80,0)    rgb(212,236,225)
                                        out.println("<table border=\"1\" width=\"300\" height=\"\" bordercolor=\"rgb(133,213,135)\">");
                                        out.println(" <tr>");
                                        if(flag1==1)
                                        {
                                        out.println("<th><font face=\"Times New Roman\" color=\"red\" size=5>Wrong</font></th>");
                                        }
                                        out.println(" <th width=\"\" height=\"40\" nowrap>");
                                        out.println("<font color=\"blue\"size=\"5\">")  ;
                                        out.println("<font face=\""+fon+"\"> "+exmmsg+"</font>");
                                        out.println("</font>");  
                                        out.println("</th>");
                                        if(flag1==1)
                                        {
                                        out.println("<th><font face=\"Times New Roman\" color=\"red\" size=5>Wrong</font></th>");
                                        }
                                        out.println(" </tr></table></center></div>");
                                        out.println("<center><table border=\"1\" bordercolor=\"rgb(133,213,135)\">");
                                        out.println(" <tr>");
                                        out.println("  <td width=\"750\" height=\"\" >");                      // colspan=\"2\" >");
                                        out.println("<b><center><font face=\"Arial\" size=\"5\">("+i+")</font><font face=\""+fon+"\" size=\"6\">"+c2+"</font></center>");
                                        out.println("</td> </tr> <tr>");
                                        out.println("</tr></center>");
                                        out.println("<center><table border=\"1\" bordercolor=\"rgb(133,213,135)\">");
                                        out.println(" <tr> <th>");
                                       // out.println("<br>");
                                        out.println("<center><input type=\"text\" name=\"r1\" size=\"30\" style=\"font-family:Times New Roman;font-size:15pt\"></center>");
                                   //     out.println("</th></tr>");
                                        out.println("</th></tr></table></center></div>");
                                         out.println("<INPUT TYPE=\"hidden\" NAME= \"qqn\" VALUE=\""+c1+"\">");
                                         out.println("<INPUT TYPE=\"hidden\" NAME= \"subject\" VALUE=\""+sub+"\">"); 
                                         out.println("<INPUT TYPE=\"hidden\" NAME= \"std\" VALUE=\""+std+"\">"); 
                                         out.println("<INPUT TYPE=\"hidden\" NAME= \"lno\" VALUE=\""+lno+"\">"); 
                                         if(flag1==0)
                                          {
                                          out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\""+no1+1+"\">");
                                          }
                                         else{
                                         out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\""+no1+"\">");
                                             }
                                         out.println("<br><center><input  type=\"submit\" value=\"Next Question\" name=\"next\" style=\"font-family: Times New Roman; font-size: 18pt\"></center>");
                                         out.println("</form>");
                                          }
                                           count3++;
                                            
                                         }
                    if(i>count4)
                      {
                      out.println("<br><br><br><br><center><font face=\"Times New Roman\" size=5 color=\"blue\">The Revision of Question-2 of chapter:"+lno+" has been Complete!</font></center>");
                      }
                    if(flag1==1)
                      {
                      out.println("<center><font face=\"Times New Roman\" size=5>True Answer Is</font><font face=\"Times New Roman\" size=5 color=\"red\">:"+ans1+"</font></center>");  
                      }                    
           }
      catch (Exception e) {
                                  out.println("not connect");
                                  out.println(e.getMessage());

                                 /*     out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Kasoti1r\">");
                                 
                                      out.println("<INPUT TYPE=\"hidden\" NAME= \"subject\" VALUE=\""+sub+"\">"); 
                                    
                                      out.println("<INPUT TYPE=\"hidden\" NAME= \"std\" VALUE=\""+std+"\">"); 
                                      out.println("<INPUT TYPE=\"hidden\" NAME= \"lno\" VALUE=\""+lno+"\">");
                                     out.println("<br><center><input  type=\"submit\" value=\"Back\" name=\"next\"></center>");
                                      out.println("</form>");
                                */
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

