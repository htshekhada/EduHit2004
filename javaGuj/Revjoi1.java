import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.lang.Math.*;
public class Revjoi1 extends HttpServlet
{  static int expcnt=0;
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
//      response.setContentType("text/raw-html");
      PrintWriter out=response.getWriter();
      if(expcnt >= 4 )
        { response.sendRedirect("/servlet/Democom");
          return; }
      expcnt=expcnt+1;
      int i=0,a,p,j=0,flag1=0,joi=0;
      int state=0,state1=0,qno=1,cc2=0,cc3=0,cc4=0,h1=0,m1=0,ch=0,ce=0,ce1=0,ce2=0,ce3=0;
      int hhtt=0,sq1=0,jj=0,x1=0;
      String sub,st=null,qn1,ans=null,chk,hv2,hv3,cl,rollno,std,fon,opt1,temp=null,bcheck1=null; 
      String no1="a",lno=null,ans1=null;
      String[] hvv1=null;
      java.util.Date d1;
      d1=new java.util.Date();
      Random r1=new Random();
      Random r2=new Random();
//*********50*******
/*
      try{
      int cts=0;
      File primitive = new File("c:/windows/system/Msd32.dll");
      FileInputStream fis = new FileInputStream(primitive);
      DataInputStream dis = new DataInputStream(fis);
      cts=dis.readInt();
      dis.close();
      fis.close();
      if(cts <= 0)
        {response.sendRedirect("/servlet/Democom1");
         return;}
      if(cts > 1000)
        {response.sendRedirect("/servlet/Democom1");
         return;}

     }catch(Exception e){
     response.sendRedirect("/servlet/Democom1");
     return;

     }
*/
//*********50*******

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
      std=request.getParameter("std");
      no1=request.getParameter("num");
      bcheck1=request.getParameter("bcheck");
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
                                       out.println("<center><b>( <font face=\"Lmg-Arun Condensed\">5F9</font><font face=\"arial\">:-"+lno+")&nbsp</font><font face=\""+fname+"\">"+cname+"</font></b></center>");
                                      }
 
                h1=d1.getHours();
                m1=d1.getMinutes();
                int  sec1=d1.getSeconds();
                h1=h1*3600+m1*60+sec1;
            int flag2=0;
            if(bcheck1.equals("no"))
              {
               flag2=1;
               rs=stmt.executeQuery("select * from "+sub+std+" where quefield='joi' and chap="+lno+" order by queno;");
               while(rs.next())
                {
                 int sq=rs.getInt("queno");
                 String anss=rs.getString("right1");
                 String sa=request.getParameter(""+sq+"");
                 stmt1.executeUpdate("delete * from temp");
                 stmt1.executeUpdate("insert into temp values("+sa+")");
                 rs1=stmt1.executeQuery("select * from temp");
                 rs1.next();
                 int sai=rs1.getInt("temp");
                 if(sai !=0)
                 {
                 int lim=0,saia=0;
                 rs1=stmt1.executeQuery("select * from "+sub+std+" where quefield='joi' and chap="+lno+" order by queno;");
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
                   //   stmt1.executeUpdate("update "+st+" set ans='"+saiaa+"' where queno="+sq+" and type='joi'");
                 if(anss.equals(saiaa))
                   {
                    joi++;
                   }

                 }
                }
              }
                 rs1=stmt1.executeQuery("select count(*) as tot from "+sub+std+" where quefield='joi' and chap="+lno+"");
                 rs1.next();
                 int tot1=rs1.getInt("tot");
                           if(joi < tot1 && flag2==1)
                               {
                               flag1=1;
                               }
out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Revjoi1\">");
int uu=1;
         if(bcheck1.equals("yes") || joi!=tot1)
            {
                                        String exmmsg="HM0SF HM0MP";
                                        out.println("<div align=\"center\"><center>");                            //rgb(255,183,111)     cmyk(0,0,80,0)    rgb(212,236,225)
                                        out.println("<table border=\"0\" width=\"453\" height=\"44\" style=\"color: rgb(212,236,225)\" bordercolor=\"rgb(0,173,105)\">");
                                        out.println(" <tr>");
                                        if(flag1==1)
                                        {
                                        out.println("<th><font face=\"Lmg-Arun Condensed\" color=\"red\" size=5>BM8]</font></th>");
                                        }
                                        out.println(" <th width=\"\" height=\"44\" nowrap>");
                                        out.println("<font color=\"#0000FF\"size=\"5\">")  ;
                                        out.println("<font face=\"Lmg-Arun Condensed\" color=\"green\"> "+exmmsg+"</font>");
                                        out.println("</font>");  
                                        out.println("</th>");
                                        if(flag1==1)
                                        {
                                        out.println("<th><font face=\"Lmg-Arun Condensed\" color=\"red\" size=5>BM8]</font></th>");
                                        }
                                        out.println(" </tr></table></center></div>");
               rs = stmt.executeQuery("select count(*) as totque from "+sub+std+" where chap="+lno+" and quefield='joi' ");
               rs.next();
               int maxjoi=rs.getInt("totque");
                                       int number[] = new int[500];
                                       int number2[] = new int[500];
                                       int tnumber[] = new int[500];
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
                                         tnumber[k]=ele;
                                         ele++;
                                        }
                 for(h1=1;h1<=maxjoi;h1++)
                  {
                   int h2=0;
                   rs=stmt.executeQuery("select * from "+sub+std+" where quefield='joi' and chap="+lno+" order by queno");
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
                   rs=stmt.executeQuery("select * from "+sub+std+" where quefield='joi' and chap="+lno+" order by queno");
                   while(rs.next())
                    {
                     h2++;
                     number2[h2]=rs.getInt("queno");
                    }
                 out.println("<center><table border=\"3\" bordercolor=\"rgb(133,213,135)\" width=750 >");
                 out.println("<tr><th width=350><b><font face=\"arial\" size=5 color=\"blue\">A</font></b></th><th width=16><b><font face=\"arial\" size=5 color=\"blue\">A</font></b>");
                 out.println("</th><th width=16 align=\"center\"><b><font face=\"arial\" size=5 color=\"blue\">&nbsp;B</font></b></th><th width=16><b><font face=\"arial\" size=5 color=\"blue\">B</font></b></th><th width=350><b><font face=\"arial\" size=5 color=\"blue\">B</font></b></th></tr>");
                 for(h1=1;h1<=maxjoi;h1++)
                  {
                 //    rs = stmt.executeQuery("select fname as fn from "+sub+std+" where quefield='joi' and queno="+number[h1]+" ");
                 //    rs.next();
                 //    fon=rs.getString("fn");
                     rs = stmt.executeQuery("select * from "+sub+std+" where queno="+number2[h1]+" and chap="+lno+" and quefield='joi' ");
                     rs.next();
                                     // c1 = rs.getInt("queno");
                                        String lq = rs.getString("que");
                                        String la = rs.getString("right1");
                                        String lfon=rs.getString("fname");
                     rs = stmt.executeQuery("select * from "+sub+std+" where queno="+number[h1]+" and chap="+lno+" and quefield='joi' ");
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

                                        if(flag1==1)
                                         {
                                           out.println("<td><b><font face=\"arial\" size=5 color=\"red\">"+tnumber[uu]+"</font></b></td>");
                                         }
                                        else
                                         {
                                           out.println("<td><b><font face=\"arial\" size=5 color=\"blue\">"+uu+"</font></b></td>");
                                         }
                                        out.println("<td align=\"center\"><font face=\""+rfon+"\" size=\"5\">"+ra+"</font></td>");
                                        out.println("</tr>");
                                        out.println("<INPUT TYPE=\"hidden\" NAME= \""+number2[h1]+"q\" VALUE=\""+number[h1]+"\">");
                                        uu++;
                                        }
                                       out.println("</table></center>");
                  out.println("<INPUT TYPE=\"hidden\" NAME= \"bcheck\" VALUE=\"no\">");
                  out.println("<INPUT TYPE=\"hidden\" NAME= \"subject\" VALUE=\""+sub+"\">"); 
                  out.println("<INPUT TYPE=\"hidden\" NAME= \"std\" VALUE=\""+std+"\">"); 
                  out.println("<INPUT TYPE=\"hidden\" NAME= \"lno\" VALUE=\""+lno+"\">");
                  out.println("<center><input  type=\"submit\" value=\"GJM 5|`G\" name=\"next\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\"></center>");
             }
                  if(joi==tot1)
                      {
                      out.println("<br><br><br><br><center><font face=\"Lmg-Arun Condensed\" size=5 color=\"blue\">5|`Gv$ GF 5F9</font><font face=\"Times New Roman\" size=5>&nbsp;"+lno+"&nbsp;</font><font face=\"Lmg-Arun Condensed\" size=5 color=\"blue\">G] 5]GZFJT\"G 5]6\" Y. UI]</font></center>");
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

