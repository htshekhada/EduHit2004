import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.lang.Math.*;
public class preExam3 extends HttpServlet
{  static int expcnt=0;
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
   //   response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      if(expcnt >= 4 )
        {response.sendRedirect("/servlet/Democom");
          return;}
      expcnt=expcnt+1;
      int i=0,a,p,j=0,chsrno=0,c1=0;
      int state=0,state1=0,qno=1,cc2=0,cc3=0,cc4=0,m1=0,ch=0,ce=0,ce1=0,ce2=0,ce3=0,h1=0;
      int hhtt=0,sq1=0,jj=0,x1=0;
      String sub,st=null,qn1,ans=null,chk,hv2,hv3,cl,rollno,std,fon,opt1,temp=null,bcheck1=null; 
      String no1="a";
      String[] hvv1=null;
      java.util.Date d1;
      d1=new java.util.Date();
      Random r1=new Random();
      Random r2=new Random();   
      out.println("<html>");
      out.println("<head>");
//        out.println("<body background=\"c:/onlinexam/img/3.jpg\">");
      Connection con=null,con1=null;
      Statement stmt=null,stmt1=null,stmt2=null,stmt3=null;
      ResultSet rs=null,rs1=null,rs2=null,rs3=null;
      sub=request.getParameter("subj");
      qn1=request.getParameter("qqn");
      rollno=request.getParameter("roll");      
      cl=request.getParameter("clas");
      std=request.getParameter("stad");
      no1=request.getParameter("num");
      bcheck1=request.getParameter("bcheck");
      int number1=no1.length();
      opt1=request.getParameter("opt");
      st=rollno+std+cl+sub;
//      temp=rollno+std+cl+sub+"opt";
      out.println("<title>["+rollno+"]-["+std+"]-["+cl+"]-["+sub+"]-EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");

      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();
                 stmt2 = con.createStatement();
                 stmt3 = con.createStatement();
                h1=d1.getHours();
                m1=d1.getMinutes();
                int  sec1=d1.getSeconds();
                h1=h1*3600+m1*60+sec1;
                 rs = stmt.executeQuery("SELECT endtime FROM biodata AS t1 where rollno="+rollno+" and class='"+cl+"' and  std="+std+"");
                 while(rs.next())
                       { cc4 = rs.getInt("endtime"); }
                 con.commit();
                 int distime=cc4-h1;
                 int dissec=distime%60;
                 distime=distime-dissec;
                 int dismin=(distime/60)%60;
                 int dishour=(distime-(dismin*60))/3600;
                 if(dissec<0)
                   {
                   out.println("<b><marquee behavior=\"alternate\"><font face=\"Lmg-Arun Condensed\" size=\"6\" color=\"red\" >TDFZM ;DI 5]6\" Y. UIM K[4 CJ[ GLR[G] A8G NAFJM</font></marquee></b>");
                   }
                 else
                   {
                    out.println("<p align =\"center\"><b> <font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"red\" >TDFZM AFSL ZC[,M ;DI</font><font face=\"Arial\" size=\"4\" color=\"blue\"> = "+dishour+"<font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"red\" >  S,FS </font> : "+dismin+"<font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"red\" >  DLGL8    </font>:  "+dissec+"<font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"red\" >  ;[S\\0 </font></font></b></p>");
                   }
int count9=0,quenum=0,maxst=0,flin=0;
            if(bcheck1.equals("no"))
              {
               rs=stmt.executeQuery("select * from "+st+" where type='joi' order by chap,queno;");
               while(rs.next())
                {
                 int sq=rs.getInt("queno");
                 String hita=rs.getString("ans");
                 String sa=request.getParameter(""+sq+"");
                 stmt1.executeUpdate("delete * from temp");
                 stmt1.executeUpdate("insert into temp values("+sa+")");
                 rs1=stmt1.executeQuery("select * from temp");
                 rs1.next();
                 int sai=rs1.getInt("temp");
                 if(sai !=0)
                 {
                 int lim=0,saia=0;
                 rs1=stmt1.executeQuery("select * from "+st+" where type='joi' order by chap,queno;");
                 while(rs1.next())
                  {
                   lim++;
                   if(lim==sai)
                     {
                      saia=rs1.getInt("queno");
                     }
                  }
                 String sa1=request.getParameter(""+saia+"q");
                 rs1=stmt1.executeQuery("select * from "+sub+std+" where quefield='joi' and queno="+sa1+"");
                 rs1.next();
                 String saiaa=rs1.getString("right1");
                 if(hita.equals("hitesh"))
                  {
                   stmt1.executeUpdate("update "+st+" set ans='"+saiaa+"' where queno="+sq+" and type='joi'");
                  }
                 }
                }
              }
maxst=0;
rs = stmt.executeQuery("select distinct(queno)  from "+st+" where type like '#joi' ");
while(rs.next())
{
maxst++;
}
//maxst=rs.getInt("cn");
//number1 > maxst || 
if(dissec < 0 || bcheck1.equals("no"))
{
    out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Kasoti1\">");
    out.println("<INPUT TYPE=\"hidden\" NAME= \"subj\" VALUE=\""+sub+"\">");
    out.println("<INPUT TYPE=\"hidden\" NAME= \"roll\" VALUE=\""+rollno+"\">");
    out.println("<INPUT TYPE=\"hidden\" NAME= \"stad\" VALUE=\""+std+"\">"); 
    out.println("<INPUT TYPE=\"hidden\" NAME= \"clas\" VALUE=\""+cl+"\">");
//    out.println("<b><font face=\"Arial\">");
    out.println("<br><br><br><br><center><font face=\"Lmg-Arun Condensed\" size=\"7\" color=\"blue\" >5|`Gv$ GL 5ZL1FF 5]6\" Y. U.</font></center>");
    out.println("<center><font face=\"Lmg-Arun Condensed\" size=\"7\" color=\"blue\" > CJ[ GLR[G] A8G NAFJM</font></center>");
    out.println("<br><br><center><input  type=\"submit\" value=\"5|`GMGL IFNL\" name=\"com\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\"></center><br>");
//    out.println("</font></b>");
    out.println("</form>");
    stmt.executeUpdate("UPDATE biodata SET joint1 ='B' WHERE rollno = "+rollno+" and std = "+std+" and class = '"+cl+"' and subject = '"+sub+"';");
    state=1;
    state1=1;
}
count9=0;
/*
if(state==0 && state1==0)
{
rs = stmt.executeQuery("select distinct(queno)  from "+st+" where type like '#joi'");
while(rs.next())
{
     count9++;
     if(count9 == number1)
        {
         quenum=rs.getInt("queno");
        }
}
i=quenum;
}
*/
out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/preExam3\">");
if(state==0 && state1==0){                     
            //     rs = stmt.executeQuery("select quetype as fn from "+sub+std+" where queno="+i+" and quefield='joi'");
            //     rs.next();
            //     String exmmsg=rs.getString("fn");
           //      rs = stmt.executeQuery("select fname as fn from "+sub+std+" where quefield='joi' and queno="+i+" ");
           //      rs.next();
           //      fon=rs.getString("fn");
              //   out.println("<font face=\""+fon+"\" size=\"20\">");
              String  exmmsg="HM0SF HM0MP";
                out.println("<div align=\"center\"><center>");
                out.println("<table border=\"0\" width=\"453\" height=\"\" style=\"color: rgb(255,183,111)\" bordercolor=\"blue\">");
                out.println(" <tr>");
                out.println(" <td width=\"453\" height=\"\" nowrap>");
            //    out.println("<font face = \" "+fon+" \" color=\"#0000FF\"size=\"5\">")  ;
                out.println("<center><font face=\"Arial\" SIZE=4></font><font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"blue\"> "+exmmsg+"</font></center>");
               //("+number1+")
               out.println("</font>");  
                out.println("</td>");
               out.println(" </tr></table></center></div>");
                out.println("<div align=\"center\"><center>");
                 int uu=1;
                 out.println("<table border=\"3\" bordercolor=\"rgb(133,213,135)\" width=750 >");
                 out.println("<tr><th width=350><b><font face=\"arial\" size=5 color=\"blue\">A</font></b></th><th width=16><b><font face=\"arial\" size=5 color=\"blue\">A</font></b>");
                 out.println("</th><th width=16 align=\"center\"><b><font face=\"arial\" size=5 color=\"blue\">&nbsp;B</font></b></th><th width=16><b><font face=\"arial\" size=5 color=\"blue\">B</font></b></th><th width=350><b><font face=\"arial\" size=5 color=\"blue\">B</font></b></th></tr>");
                 int maxjoi=0;
                 rs=stmt.executeQuery("select * from "+st+" where type='joi';");
                 while(rs.next())
                  {
                   maxjoi++;
                  }
                                       int number[] = new int[500];
                                       int number2[] = new int[500];
                                       int ele = 1;

                 label1:               while(ele <= maxjoi)
                                       {
                                         j = r2.nextInt(maxjoi);
                                         j=j+1;
                                         int k=(int)j;
                                         for(int ii=1;ii<=maxjoi;ii++)
                                            {
                                            if(number[ii]==k)
                                                { continue label1;}
                                           }
                                         number[ele]=k;
                                         ele++;
                                        }
                 for(h1=1;h1<=maxjoi;h1++)
                  {
                   int h2=0;
                   rs=stmt.executeQuery("select * from "+st+" where type='joi' order by chap,queno");
hitesh:            while(rs.next())
                    {
                     h2++;
                     if(h2==number[h1])
                      {
                       number[h1]=rs.getInt("queno");
                       break hitesh;
                      }
                    }
                  }
                   int h2=0;
                   rs=stmt.executeQuery("select * from "+st+" where type='joi' order by chap,queno");
                   while(rs.next())
                    {
                     h2++;
                     number2[h2]=rs.getInt("queno");
                    }
                 for(h1=1;h1<=maxjoi;h1++)
                  {
                   //  rs = stmt.executeQuery("select fname as fn from "+sub+std+" where quefield='joi' and queno="+number[h1]+" ");
                   //  rs.next();
                   //  fon=rs.getString("fn");
                     rs = stmt.executeQuery("select * from "+sub+std+" where queno="+number2[h1]+" and quefield='joi' ");
                     rs.next();
                                     // c1 = rs.getInt("queno");
                                        String lq = rs.getString("que");
                                        String la = rs.getString("right1");
                                        String lfon=rs.getString("fname");
                     rs = stmt.executeQuery("select * from "+sub+std+" where queno="+number[h1]+" and quefield='joi' ");
                     rs.next(); 
                                        // c1 = rs.getInt("queno");
                                        String rq = rs.getString("que");
                                       String ra = rs.getString("right1");
                                       String rfon=rs.getString("fname");
                                  //      out.println("<font face=\""+fon+"\" size=\"8\">");
                                        out.println("<tr>");
                                  //      out.println("<td><b><font face=\"arial\" size=5>"+uu+"</font></b></td>");
                                        out.println("<td align=\"center\"><font face=\""+lfon+"\" size=\"5\">"+lq+"</font></td>");
                                        out.println("<td><b><font face=\"arial\" size=5 color=\"blue\">"+uu+"</font></b></td>");
                                        out.println("<th><select name=\""+number2[h1]+"\" size=\"1\" style=\"font-size:15pt\"> ");
                                        for(int op=0;op<=maxjoi;op++)
                                         {
                                          out.println("<option value="+op+">"+op+"</option>");
                                         }
                                        out.println("</select></th>");
                                        out.println("<td><b><font face=\"arial\" size=5 color=\"blue\">"+uu+"</font></b></td>");
                                        out.println("<td align=\"center\"><font face=\""+rfon+"\" size=\"5\">"+ra+"</font></td>");
                                        out.println("</tr>");
                                        out.println("<INPUT TYPE=\"hidden\" NAME= \""+number2[h1]+"q\" VALUE=\""+number[h1]+"\">");
                                        uu++;
                  }
                                 out.println("</table></center>");
                                 out.println("</font>");
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"qqn\" VALUE=\""+i+"\">");
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"subj\" VALUE=\""+sub+"\">"); 
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"roll\" VALUE=\""+rollno+"\">");
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"stad\" VALUE=\""+std+"\">"); 
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"clas\" VALUE=\""+cl+"\">"); 
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\""+no1+1+"\">");
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"bcheck\" VALUE=\"no\">"); 
                                 out.println("<p align=\"center\"><input  type=\"submit\" value=\"GJM 5|`G\" name=\"next\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\"></p>");
                                 out.println("</form>");
                  }
           }
      catch (Exception e) {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Kasoti1\">");
                                      out.println("<INPUT TYPE=\"hidden\" NAME= \"subj\" VALUE=\""+sub+"\">"); 
                                      out.println("<INPUT TYPE=\"hidden\" NAME= \"roll\" VALUE=\""+rollno+"\">");
                                      out.println("<INPUT TYPE=\"hidden\" NAME= \"stad\" VALUE=\""+std+"\">"); 
                                      out.println("<INPUT TYPE=\"hidden\" NAME= \"clas\" VALUE=\""+cl+"\">");
                                      out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\""+no1+1+"\">");
                                      out.println("<br><center><input  type=\"submit\" value=\"Back\" name=\"next\"></center>");
                                      out.println("</form>");
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

