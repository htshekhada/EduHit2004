import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.lang.Math.*;
public class Disppaper extends HttpServlet
{  
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
   //   response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      Random r1=new Random();
      Random r2=new Random();   
      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");
      Connection con=null,con1=null;
      Statement stmt=null,stmt1=null,stmt2=null,stmt3=null;
      ResultSet rs=null,rs1=null,rs2=null,rs3=null;
      String std=null,cl=null,sub=null,fon4=null;
      sub=request.getParameter("sub");
      cl=request.getParameter("class");
      std=request.getParameter("std");
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();
                 stmt2 = con.createStatement();
                 stmt3 = con.createStatement();
                 rs = stmt.executeQuery("select sum(maxopt) as sumopt,sum(maxsho) as sumsho,sum(maxlon) as sumlon,sum(maxjoi) as sumjoi from course where std="+std+" and class='"+cl+"' and sub='"+sub+"'");
                 rs.next();
                 int totalopt = rs.getInt("sumopt");
                 int totalsho = rs.getInt("sumsho");
                 int totallon = rs.getInt("sumlon");
                 int totaljoi = rs.getInt("sumjoi");
                 int total1=totalopt+totalsho+totallon+totaljoi;
      out.println("<center><font face=\"Times New Roman\" size=\"4\">Examination Paper Generated By EducationHIT Software</font></center>");
      out.println("<font face=\"Lmg-Arun Condensed\" size=\"5\"><center>WMZ6</font><font face=\"arial\">:-"+std+"</font>");
      out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>");
      out.println("<font face=\"Lmg-Arun Condensed\" size=\"5\">JU\"</font><font face=\"arial\">:-"+cl+"</font>");
      out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>");
      out.println("<font face=\"Lmg-Arun Condensed\" size=\"5\">lJQFI</font><font face=\"arial\">:-"+sub+"</font>");
      out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>");
      out.println("<font face=\"Lmg-Arun Condensed\" size=\"5\">S], U]6</font><font face=\"arial\">:-"+total1+"</font>");
      out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>");
      out.println("<font face=\"Lmg-Arun Condensed\" size=\"5\">5ZL1FF ;DI</font><font face=\"arial\">:-</center></font>");
                  int mopt2=0,msho2=0,mlon2=0,mjoi2=0;
                  rs = stmt.executeQuery("select sum(maxopt) as m1,sum(maxsho) as m2,sum(maxlon) as m3,sum(maxjoi) as m4 from course where std="+std+" and sub='"+sub+"' and class='"+cl+"' ");
                  if(rs.next())
                  {
                  mopt2 =rs.getInt("m1");
                  msho2 = rs.getInt("m2");
                  mlon2 = rs.getInt("m3");
                  mjoi2 = rs.getInt("m4");
                  }
    int opt[] = new int[500];
    int sho[] = new int[500];
    int lon[] = new int[500];
    int joi[] = new int[500];
    int i=0,q1=0,y1=0,ce=0,ce1=0,i3=0,l1=0;
    String fon1=null;
         if(mopt2 > 0)
               {
          rs = stmt.executeQuery("select chapno as cpn,maxopt as mq from course where std="+std+" and class='"+cl+"' and sub='"+sub+"'");
          while(rs.next())
             {
             ce = rs.getInt("cpn");
             ce1= rs.getInt("mq");
             l1=l1+ce1;
hitesh:
        for(i3=1;i3<=ce1;i3++)
             {
             rs1 = stmt1.executeQuery("select count(*) as n1 from "+sub+std+" where quefield='opt' and chap="+ce+" ");
             rs1.next();
             int n=rs1.getInt("n1");
             i = r1.nextInt(n);
             i=i+1;
                   int sqn1=0;
          rs1 = stmt1.executeQuery("select *  from "+sub+std+" where quefield='opt' and chap="+ce+" ");
                 while(rs1.next())
                         {
                          sqn1++;
                          if(sqn1==i)
                          {
                          q1=rs1.getInt("queno");
                          
                          }
                       }
          for(int i1=1;i1<=y1;i1++)
                     {
                        sqn1=0;
                    rs1 = stmt1.executeQuery("select *  from "+sub+std+" where quefield='opt' and chap="+ce+" ");
                             while(rs1.next())
                                 {
                                 sqn1++;
                                 if(sqn1==i)
                                 {
                                 q1=rs1.getInt("queno");
                                 
                                 }
                                }
                               if(opt[i1]==q1)
                               {
                               i = r1.nextInt(n);
                               i=i+1;
                               i3=i3-1;
                               continue hitesh;
                               }
                               }
                           y1++;  
                           opt[y1]=q1;
                         }        
             }
 out.println("<strong>");
//out.println("<strong><font face=\"Lmg-Arun\" size=\"4\">5|`G v ! <font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>  VF5[, lJS<5DF\\YL ;FRM HJFA 5;\\N SZMP  s;FRF lJS<5GL ;FD[ BZFG]\\ lGXFG SZMPf</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+l1+"</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;Marks</strong><hr></font>");
out.println("<hr><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`Gv!   V[S HJFA 5;\\N SZMP   </font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+mopt2+"</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;Marks</strong><hr></font>");
int j=0;
for(int i2=1;i2<=y1%4;i2++)  //y1
   {
    rs = stmt.executeQuery("select * from "+sub+std+" where queno="+opt[i2]+" and quefield='opt' ");
    rs.next();
     int    c1 = rs.getInt("queno");
     String c2 = rs.getString("que");
     String co1 = rs.getString("right1");
     String co2 = rs.getString("wrong1");
     String co3 = rs.getString("wrong2");
     String fon18=rs.getString("fname");
     int    c6 = rs.getInt("chap");
     out.println("<font face=\"arial\">("+i2+")</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+c2+"</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br></font>");
     j = r2.nextInt(6);
     j=j+1;
     switch(j)                          
              {
           case 1:
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(1)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co1+"</font><br>");
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(2)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co2+"</font><br>");
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(3)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co3+"</font><font face=\"arial\"><br><br></font>");
                break;
           case 2:
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(1)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co2+"</font><br>");
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(2)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co3+"</font><br>");
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(3)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co1+"</font><font face=\"arial\"><br><br></font>");
                break;
           case 3:
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(1)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co3+"</font><br>");
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(2)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co1+"</font><br>");
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(3)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co2+"</font><font face=\"arial\"><br><br></font>");
                break;
           case 4:
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(1)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co1+"</font><br>");
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(2)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co3+"</font><br>");
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(3)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co2+"</font><font face=\"arial\"><br><br></font>");
                break;
           case 5:
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(1)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co3+"</font><br>");
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(2)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co2+"</font><br>");
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(3)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co1+"</font><font face=\"arial\"><br><br></font>");
                break;
           case 6:
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(1)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co2+"</font><br>");
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(2)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co1+"</font><br>");
                out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(3)</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\""+fon18+"\">"+co3+"</font><font face=\"arial\"><br><br></font>");
                break;
              }
                }
                 }
                     int p3=0,k2=0;
             if(msho2 > 0)
                   {
                rs = stmt.executeQuery("select chapno as cpn,maxsho as mq from course where std="+std+" and class='"+cl+"' and sub='"+sub+"'");
                        while(rs.next())
                          {
     ce = rs.getInt("cpn");
     ce1= rs.getInt("mq");
      k2=k2+ce1;
     for(i3=1;i3<=ce1;i3++)
     {
     rs1 = stmt1.executeQuery("select count(*) as n1 from "+sub+std+" where quefield='sho' and chap="+ce+" ");
     rs1.next();
     int n=rs1.getInt("n1");
     i = r1.nextInt(n);
     i=i+1;
     int sqn1=0;
    rs1 = stmt1.executeQuery("select *  from "+sub+std+" where quefield='sho' and chap="+ce+" ");
           while(rs1.next())
            {
            sqn1++;
                       if(sqn1==i)
                        {
                   q1=rs1.getInt("queno");
                        }
               }
hitesh:
         for(int i1=1;i1<=p3;i1++)
               {
                  sqn1=0;
                  rs1 = stmt1.executeQuery("select *  from "+sub+std+" where quefield='sho' and chap="+ce+" ");
                  while(rs1.next())
                 {
                sqn1++;
                    if(sqn1==i)
                        {
                      q1=rs1.getInt("queno");
                        }
                                      }
              if(sho[i1]==q1)
             {
                i = r1.nextInt(n);
                i=i+1;
                i1=1;
                continue hitesh;
                }
                }
          p3++;
         sho[p3]=q1;
                }        
                }
//out.println("<font face=\"arial\"><hr></font><font face=\"Lmg-Arun\" size=\"4\"><strong>5|`G v Z <font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>  VF5[, 5|`GMGF HJFA V\\U|[HLDF\\ ,BMP</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+k2+"</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;Marks</strong><hr></font>");
out.println("<font face=\"arial\"><hr></font><font face=\"Lmg-Arun Condensed\" size=\"5\"><strong>5|`GvZ    HJFA ,BMP                  </font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+msho2+"</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;Marks</strong><hr></font>");
for(int i2=1;i2<=p3%4;i2++)  //p3
   {
     rs = stmt.executeQuery("select * from "+sub+std+" where queno="+sho[i2]+" and quefield='sho' ");
     rs.next();
     int    c1 = rs.getInt("queno");
     String c2 = rs.getString("que");
     String fon2=rs.getString("fname");
     int    c6 = rs.getInt("chap");
     out.println("<font face=\"arial\">("+i2+")&nbsp;&nbsp;&nbsp;</font><font face=\""+fon2+"\">"+c2+"</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]&nbsp;<br><br></font>");
   }
}
int y2=0;
  l1=0;
if(mlon2 > 0)
{
   rs = stmt.executeQuery("select chapno as cpn,maxlon as mq from course where std="+std+" and class='"+cl+"' and sub='"+sub+"'");
          while(rs.next())
             {
             ce = rs.getInt("cpn");
             ce1= rs.getInt("mq");
             l1=l1+ce1;
hitesh:
         for(i3=1;i3<=ce1;i3++)
             {
             rs1 = stmt1.executeQuery("select count(*) as n1 from "+sub+std+"l where quefield='lon' and chap="+ce+" ");
             rs1.next();
             int n=rs1.getInt("n1");
             i = r1.nextInt(n);
                           i=i+1;
                           int sqn1=0;
          rs1 = stmt1.executeQuery("select *  from "+sub+std+"l where quefield='lon' and chap="+ce+" ");
                 while(rs1.next())
                         {
                          sqn1++;
                          if(sqn1==i)
                          {
                          q1=rs1.getInt("queno");
                          }
                       }
         for(int i1=1;i1<=y2;i1++)
                     {
                       sqn1=0;
                    rs1 = stmt1.executeQuery("select *  from "+sub+std+"l where quefield='lon' and chap="+ce+" ");
                             while(rs1.next())
                                 {
                                 sqn1++;
                                 if(sqn1==i)
                                 {
                                 q1=rs1.getInt("queno");
                                 }
                                }
                               if(lon[i1]==q1)
                               {
                               i = r1.nextInt(n);
                               i=i+1;
                               i3=i3-1;
                               continue hitesh;
                               }
                               }
                           y2++;  
                           lon[y2]=q1;
                         }        
             }
 out.println("<strong>");
//out.println("<strong><font face=\"Lmg-Arun\" size=\"4\">5|`G v ! <font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>  VF5[, lJS<5DF\\YL ;FRM HJFA 5;\\N SZMP  s;FRF lJS<5GL ;FD[ BZFG]\\ lGXFG SZMPf</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+l1+"</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;Marks</strong><hr></font>");
out.println("<hr><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`Gv#    V[S HJFA 5;\\N SZMP  </font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+mlon2+"</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;Marks</strong><hr></font>");
int j=0;
for(int i2=1;i2<=y2%4;i2++)  //y2
   {
    rs = stmt.executeQuery("select * from "+sub+std+"l where queno="+lon[i2]+" and quefield='lon' ");
    rs.next();
     int    c1 = rs.getInt("queno");
     String c2 = rs.getString("que");
     String co1 = rs.getString("right1");
     String co2 = rs.getString("wrong1");
     String co3 = rs.getString("wrong2");
     String fon18=rs.getString("fname");
     int    c6 = rs.getInt("chap");
     out.println("<font face=\"arial\">("+i2+")</font><pre><font face=\""+fon18+"\">"+c2+"</font></pre>");
     j = r2.nextInt(6);
     j=j+1;
     switch(j)                          
              {
           case 1:
                out.println("<pre><font face=\""+fon18+"\">"+co1+"</font></pre>");
                out.println("<pre><font face=\""+fon18+"\">"+co2+"</font></pre>");
                out.println("<pre><font face=\""+fon18+"\">"+co3+"</font></pre>");
                break;
           case 2:
                out.println("<pre><font face=\""+fon18+"\">"+co2+"</font></pre>");
                out.println("<pre><font face=\""+fon18+"\">"+co3+"</font></pre>");
                out.println("<pre><font face=\""+fon18+"\">"+co1+"</font></pre>");
                break;
           case 3:
                out.println("<pre><font face=\""+fon18+"\">"+co3+"</font></pre>");
                out.println("<pre><font face=\""+fon18+"\">"+co1+"</font></pre>");
                out.println("<pre><font face=\""+fon18+"\">"+co2+"</font></pre>");
                break;
           case 4:
                out.println("<pre><font face=\""+fon18+"\">"+co1+"</font></pre>");
                out.println("<pre><font face=\""+fon18+"\">"+co3+"</font></pre>");
                out.println("<pre><font face=\""+fon18+"\">"+co2+"</font></pre>");
                break;
           case 5:                                                                                                                                                                                                                                                                     
                out.println("<pre><font face=\""+fon18+"\">"+co3+"</font></pre>");
                out.println("<pre><font face=\""+fon18+"\">"+co2+"</font></pre>");
                out.println("<pre><font face=\""+fon18+"\">"+co1+"</font></pre>");
                break;
           case 6:
                out.println("<pre><font face=\""+fon18+"\">"+co2+"</font></pre>");
                out.println("<pre><font face=\""+fon18+"\">"+co1+"</font></pre>");
                out.println("<pre><font face=\""+fon18+"\">"+co3+"</font></pre>");
                break;
              }
     }
}
 int q4=0,k1=0;
if(mjoi2 > 0)
{
  rs = stmt.executeQuery("select chapno as cpn,maxjoi as mq from course where std="+std+" and class='"+cl+"' and sub='"+sub+"'");
 while(rs.next())
   {
     ce = rs.getInt("cpn");
    ce1= rs.getInt("mq");
       k1=k1+ce1;
         for(i3=1;i3<=ce1;i3++)
        {
        rs1 = stmt1.executeQuery("select count(*) as n1 from "+sub+std+" where quefield='joi' and chap="+ce+" ");
        rs1.next();
        int n=rs1.getInt("n1");
        i = r1.nextInt(n);
       i=i+1;
       int sqn1=0;
        rs1 = stmt1.executeQuery("select *  from "+sub+std+" where quefield='joi' and chap="+ce+" ");
         while(rs1.next())
           {
             sqn1++;
             if(sqn1==i)
                {
                   q1=rs1.getInt("queno");
               }
               }
hitesh:  for(int i1=1;i1<=q4;i1++)
           {
           sqn1=0;
           rs1 = stmt1.executeQuery("select *  from "+sub+std+" where quefield='joi' and chap="+ce+" ");
           while(rs1.next())
               {
               sqn1++;
             if(sqn1==i)
                 {
             q1=rs1.getInt("queno");
                 }
                 }
          if(joi[i1]==q1)
                  {
                 i = r1.nextInt(n);
                 i=i+1;
                 i1=0;
                 continue hitesh;
                 }
                 }
            q4++;
           joi[q4]=q1;
             }        
             }
//out.println("<strong><font face=\"Lmg-Arun\" size=\"4\">5|`G v $ <font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>  HM0SF\\ HM0MP </font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+k1*5+"&nbsp;&nbsp;&nbsp;Marks</strong></font>");
out.println("<hr><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`Gv$    HM0SF HM0MP                  </font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+mjoi2+"&nbsp;&nbsp;&nbsp;Marks</strong></font><hr>");
int number[] = new int[500];
      int ele = 1,j=0;
  label1:               while(ele <= q4)
                                        {
                                         j = r2.nextInt(q4);
                                         j=j+1;
                                         int k=(int)j;
                                         for(int ii=1;ii<=q4;ii++)
                                            {
                                            if(number[ii]==k)
                                                { continue label1;}
                                           }
                                         number[ele]=k;
                                         ele++;
                                        }
                 for(int h1=1;h1<=q4;h1++)
                  {
                   number[h1]=joi[number[h1]];
    }
 out.println("<center><table border=0>");
for(int i2=1;i2<=q4%6;i2++)  //q4
   {
  rs = stmt.executeQuery("select * from "+sub+std+" where queno="+number[i2]+" and quefield='joi' ");
  rs.next();
  String c3 = rs.getString("right1");
  rs = stmt.executeQuery("select * from "+sub+std+" where queno="+joi[i2]+" and quefield='joi' ");
  rs.next();
  String c2 = rs.getString("que");
  String fon13 = rs.getString("fname");
  out.println("<b><tr><td><font face=\"arial\">("+i2+")</font></td><td><font face=\""+fon13+"\">"+c2+"</font></td><td><font face=\"arial\">("+i2+")</font></td><td><font face=\""+fon13+"\">"+c3+"</font></td><th><font face=\"arial\">("+i2+")</font></th><th><font face=\"arial\">[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]</font></th></b></tr>");
  }
  out.println("</table></center>");
}
out.println("<br><br><br><hr><center><font face=\"Times New Roman\">Obtained Marks:-</font><font face=\"arial\"></center><center></font><font face=\"Times New Roman\">Que-1</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"Times New Roman\">Que-2</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"Times New Roman\">Que-3</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"Times New Roman\">Que-4</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"Times New Roman\">Total Obtain Marks</font>");
out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<hr><br><br><br><br><br></font></center>");
out.println("<center><font face=\"arial\" size=\"8\">Answer Sheet </center></font>");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
if(mopt2 > 0)
{
out.println("<hr><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`Gv!   V[S HJFA 5;\\N SZMP   </font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+mopt2+"</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;Marks</strong><hr></font>");
//out.println("<strong><font face=\"arial\" size=\"4\">Draw Right Mark At Appropriat Option Of the following Optional Type Question.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+l1+"&nbsp;&nbsp;&nbsp;Marks</strong><hr></font>");
  rs=stmt.executeQuery("select fontname as fon from subject where std="+std+" and sub_name='"+sub+"' ");
      while(rs.next())
          {
           fon1=rs.getString("fon");
             }
for(int i2=1;i2<=y1%4;i2++)   //y1
   {
     rs = stmt.executeQuery("select * from "+sub+std+" where queno="+opt[i2]+" and quefield='opt' ");
     rs.next();
     int    c1 = rs.getInt("queno");
     String c2 = rs.getString("que");
     String fon3 = rs.getString("fname");
     String c3 = rs.getString("right1");
     String c4 = rs.getString("wrong1");
     String c5 = rs.getString("wrong2");
     int    c6 = rs.getInt("chap");
     out.println("<font face=\"arial\">("+i2+")&nbsp;&nbsp;&nbsp;</font><font face=\""+fon3+"\">"+c2+"</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br></font>");
     out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font face=\"arial\">(Answer)</font><font face=\""+fon3+"\">"+c3+"</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><br>");
   }
}
if(msho2 > 0)
{

out.println("<font face=\"arial\"><hr></font><font face=\"Lmg-Arun Condensed\" size=\"5\"><strong>5|`GvZ    HJFA ,BMP                  </font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+msho2+"</font><font face=\"arial\">&nbsp;&nbsp;&nbsp;Marks</strong><hr></font>");
//out.println("<strong><font face=\"arial\" size=\"4\">Fill The Blanks.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+k2+"&nbsp;&nbsp;&nbsp;Marks</font></strong><hr>");
for(int i2=1;i2<=p3%4;i2++)  //p3
   {
     rs = stmt.executeQuery("select * from "+sub+std+" where queno="+sho[i2]+" and quefield='sho' ");
     rs.next();
     int    c1 = rs.getInt("queno");
     String c2 = rs.getString("que");
     String ans1=rs.getString("right1");
      fon4=rs.getString("fname");
 //    String c3 = rs.getString("right1");
     int    c6 = rs.getInt("chap");
     out.println("<font face=\"arial\">("+i2+")&nbsp;&nbsp;&nbsp;</font><font face=\""+fon4+"\">"+c2+"</font><font face=\"arial\">&nbsp;"+ans1+"<br><br></font>");
   }
}
if(mlon2 > 0)
{
out.println("<font face=\"arial\"><hr></font><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`Gv#    V[S HJFA 5;\\N SZMP  </font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+mlon2+"&nbsp;&nbsp;&nbsp;Marks</strong><hr></font>");
//out.println("<strong><font face=\"arial\" size=\"4\">Mark The True Answers &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+j1+"&nbsp;&nbsp;&nbsp;Marks</strong><hr></font>");
for(int i2=1;i2<=y2%4;i2++)  //y2
   {
     rs = stmt.executeQuery("select * from "+sub+std+"l where queno="+lon[i2]+" and quefield='lon' ");
     rs.next();
     int    c1 = rs.getInt("queno");
     String c2 = rs.getString("que");
     String c3 = rs.getString("right1");
     String fon15 = rs.getString("fname");
     String c8 = rs.getString("wrong1");
     String c9 = rs.getString("wrong2");
     int    c13 = rs.getInt("chap");
     out.println("<font face=\"arial\">("+i2+")</font><pre><font face=\""+fon15+"\">"+c2+"</font></pre>");
     out.println("(True Answer)<pre><font face=\""+fon15+"\">"+c3+"</font></pre>");
   }
}
if(mjoi2 > 0)
{
out.println("<hr><strong><font face=\"Lmg-Arun Condensed\" size=\"5\">5|`Gv$    HM0SF HM0MP                  </font><font face=\"arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+mjoi2+"&nbsp;&nbsp;&nbsp;Marks</strong></font><hr>");
//out.println("<strong><font face=\"arial\" size=\"4\">Jodka Jodo. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+k1*5+"&nbsp;&nbsp;&nbsp;Marks</strong><hr></font>");
out.println("<center><table border=0>");
for(int i2=1;i2<=q4%6;i2++)   //q4
   {
       rs = stmt.executeQuery("select * from "+sub+std+" where queno="+joi[i2]+" and quefield='joi' ");
       rs.next();
       String c2 = rs.getString("que");
       String c3 = rs.getString("right1");
       String fon16 = rs.getString("fname");
       out.println("<tr><td><font face=\"arial\">("+i2+")</font></td><td><font face=\""+fon16+"\">"+c2+"</font></td><td>---------</td><td><font face=\""+fon16+"\">"+c3+"</font></td></tr>");
   }
   out.println("</table></center>");
}
 out.println("<hr>");
//       out.println("<hr><br><center><font face=\"Times New Roman\" size=2 color=\"rgb(255,0,0)\">Developed By...</font></center>");
//       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(255,0,0)\">Hiteshkumar T. Shekhada</font></center>");
//       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(255,0,0)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-2676644</font></center>");
            }
      catch (Exception e) {
                                      out.println("could not connect : You have to fill the form first");
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
                   if(con != null)   {
                                             try { con.close(); }
                                             catch (SQLException ignore) { }
                                     }
                  }
      out.println("</strong>");
      out.println("</form>");
      out.println("</body>");
      out.println("</html>");
    }
}

