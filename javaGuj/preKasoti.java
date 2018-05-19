import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;
public class preKasoti extends HttpServlet
{  static int expcnt=0;
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
//      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      HttpSession session = request.getSession(true);      
      String  r1,n1,s1,c1,sub,nn1,rad1=null,std=null,cl=null;
      int  a=0,h1=0,m1=0,h2=0,tt1=0,qq1=0,qq2=0,sec1=0,j=0;
      int i=0,p,chsrno=0,submax=0,noss=0,rolval=0;
      int state=0,state1=0,qno=1,cc2=0,cc3=0,cc4=0,ch=0,ce=0,ce1=0,ce2=0,ce3=0;
      int hhtt=0,sq1=0,jj=0,x1=0;//y1k2j1k1aa
      String st=null,qn1,ans=null,chk,hv2,hv3,rollno,fon,opt1,temp=null,bcheck1=null; 
      int opt[] = new int[500];
      int sho[] = new int[500];
      int lon[] = new int[500];
      int joi[] = new int[500];
      int varlon[] = new int[500];
      int q1=0,y1=0,i3=0,l1=0;
      i=0;
      ce=0;
      ce1=0;
      String fon1=null;

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
     noss=1;
     System.out.println("EducationHIT Msg:Contact Your Vendor");
     }
*/
//*********50*******
      Random r4=new Random();
      if(expcnt >= 1 )   //5 //******for demo******
        {response.sendRedirect("/servlet/Democom");
         return;}
      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(133,213,135)\">");
//      out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Exam\">");
//      out.println("<strong><marquee Behaviour=\"Alternate\"><font face=\"Lmg-Arun\" size=\"10\" color=\"white\">V1FZ Sd%I}8Z ;[g8Z v OMG o *$$(Z)*</font></marquee></strong>");
      out.println("<br><br><br><center>");
//      out.println("<table border=\"8\" width=\"515\">");
//      out.println("<strong><marquee Behaviour=\"Alternate\"><font face=\"Lmg-Arun\" size=\"10\" color=\"green\">V1FZ Sd%I}8Z ;[g8Z v OMG o *$$(Z)*</font></marquee></strong>");
      Connection con=null,con1=null;
      Statement stmt=null,stmt1=null,stmt2=null,stmt3=null,stmt4=null,stmt5=null,stmt6=null;
      ResultSet rs=null,rs1=null,rs2=null,rs3=null,rs4=null,rs5=null,rs6=null;
       r1=request.getParameter("rollno");
       n1=request.getParameter("name");
       s1=request.getParameter("std");
       c1=request.getParameter("class");
       sub=request.getParameter("subject");
       nn1=r1+s1+c1+sub;
       java.util.Date d1;
       d1=new java.util.Date();
       rollno=r1;
       std=s1;
       cl=c1;
       std=s1;
       cl=c1;
      st=rollno+std+cl+sub;
      temp=rollno+std+cl+sub+"opt";
//       System.out.print(""+request.getRemoteHost()+"-");
//       System.out.println(""+r1+"-"+n1+"-"+s1+"-"+c1+"-"+sub+","+d1+"");
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 //       con.setAutoCommit(true); 
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();
                 stmt2 = con.createStatement();
                 stmt3 = con.createStatement();
                 stmt4 = con.createStatement();
                 stmt5 = con.createStatement();
                 stmt6 = con.createStatement();
                 h1=d1.getHours();
                 m1=d1.getMinutes();
                 sec1=d1.getSeconds();
         //       out.println("<tr><th><font face=\"Times New Roman\" size=\"6\" color=\"Green\">Your Time Starts Now !</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face=\"Arial\" size=\"5\">"+h1+":"+m1+":"+sec1+"</font></th></tr>");
                 rs = stmt.executeQuery("SELECT examtime as et FROM superuser where std="+s1+" and class='"+c1+"' and subject='"+sub+"'");
                 if(rs.next()) {
                                    tt1 = rs.getInt("et");
                                  }                 
                 else{ noss=1; }
                 if(tt1 <= 0)
                     { noss = 1; }

                 con.commit();
                 h2=h1*3600;
                 h2=h2+(tt1*60)+(m1*60)+sec1;
 rs5 = stmt5.executeQuery("select * from biodata where rollno="+ r1+ " and std="+s1+" and class='"+c1+"' and subject='"+sub+"'  " );
 if(!rs5.next())
   {  rs6 = stmt6.executeQuery("select chapno from course where  std="+s1+" and class='"+c1+"' and sub='"+sub+"' union select chapno from course1 where  std="+s1+" and class='"+c1+"' and sub='"+sub+"' " );
                if(rs6.next())
                    { stmt.executeUpdate(""
                                        + " insert into biodata values ("+ r1+ ",'"+ n1+"',"+s1+",'"+c1+"','"+sub+"',"+h2+",'a','a','a','a','a') " );
                      stmt.executeUpdate("CREATE TABLE "+nn1+" (queno INTEGER,ans VARCHAR(255),chap INTEGER,type VARCHAR(4))");      
                         con.commit();
                         stmt.executeUpdate("insert into "+nn1+" values("+r1+",'"+(s1+c1)+"',0,'')");
                         con.commit();
                     }
                else {
                       noss=1;
                     }
                 rs = stmt.executeQuery("select sum(maxopt) as sumopt,sum(maxsho) as sumsho,sum(maxlon) as sumlon,sum(maxjoi) as sumjoi from course where std="+std+" and class='"+cl+"' and sub='"+sub+"'");
                 rs.next();
                 int totalopt = rs.getInt("sumopt");
                 int totalsho = rs.getInt("sumsho");
                 int totallon = rs.getInt("sumlon");
                 int totaljoi = rs.getInt("sumjoi");
                 int total1=totalopt+totalsho+totallon*5+totaljoi*5;
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
                        i = r4.nextInt(n);
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
                                i = r4.nextInt(n);
                                i=i+1;
                                i3=i3-1;
                                continue hitesh;
                               }
                           }
                           y1++;  
                           opt[y1]=q1;
                           if(y1 <=3)
                           stmt2.executeUpdate("insert into "+st+" values ("+opt[y1]+",'hitesh',"+ce+",'opt') " ); 
                      }        
      }
    int p3=0,k2=0;
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
             i = r4.nextInt(n);
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
hitesh1:
               for(int i1=1;i1<=k2;i1++)
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
                             i = r4.nextInt(n);
                             i=i+1;
                             i1=0;
                             continue hitesh1;
           
                             }

                       }
                  p3++;
                 sho[p3]=q1;
                 if(p3 <=3)
                 stmt2.executeUpdate("insert into "+st+" values ("+sho[p3]+",'hitesh',"+ce+",'sho') " );
           }        
    }
int aa=0,j1=0;
rs = stmt.executeQuery("select chapno as cpn,maxlon as mq from course where std="+std+" and class='"+cl+"' and sub='"+sub+"'");
     while(rs.next())
             {
             ce = rs.getInt("cpn");
             ce1= rs.getInt("mq");
             j1=j1+ce1;
       for(i3=1;i3<=ce1;i3++)
            {
        rs1 = stmt1.executeQuery("select count(*) as n1 from "+sub+std+"l where quefield='lon' and chap="+ce+" ");
          rs1.next();
           int n=rs1.getInt("n1");
            i = r4.nextInt(n);
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
hitesh2:
             for(int i1=1;i1<=j1;i1++)
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
                i = r4.nextInt(n);
                i=i+1;
                i1=0;
                continue hitesh2;
                    }
                    }
                aa++;
                lon[aa]=q1;
                if(aa <=3)
                stmt2.executeUpdate("insert into "+st+" values ("+lon[aa]+",'hitesh',"+ce+",'lon') " );
                }        
             }
          int q4=0,k1=0;
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
        i = r4.nextInt(n);
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
hitesh3:
           for(int i1=1;i1<=k1;i1++)
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
                 i = r4.nextInt(n);
                 i=i+1;
                 i1=0;
                 continue hitesh3;
                 }
                 }
            q4++;
           joi[q4]=q1;
           if(q4 <=5)
           stmt2.executeUpdate("insert into "+st+" values ("+joi[q4]+",'hitesh',"+ce+",'joi') " );
          }        
       }
 aa=1;j1=0;q1=0;
rs = stmt.executeQuery("select distinct chapno as cpn from course1 where std="+std+" and class='"+cl+"' and sub='"+sub+"'");
     while(rs.next())
      {
             ce = rs.getInt("cpn");
        //     ce1= rs.getInt("mq");
             rs3 = stmt3.executeQuery("select * from course1 where std="+std+" and class='"+cl+"' and sub='"+sub+"' and chapno="+ce+" and rightno > 0 and wrongno > 0;");
             while(rs3.next())
             {
                 int rn=rs3.getInt("rightno");
                 int wn=rs3.getInt("wrongno");
                 rs4 = stmt4.executeQuery("select maxvarlon from course1 where std="+std+" and class='"+cl+"' and sub='"+sub+"' and chapno="+ce+" and rightno="+rn+" and wrongno="+wn+";");
                 while(rs4.next())
                 {
                   ce1 = rs4.getInt("maxvarlon");
                   j1=j1+ce1;
                   for(i3=1;i3<=ce1;i3++)
                    {
                        rs1 = stmt1.executeQuery("select count(*) as n1 from "+sub+std+"v where rightno="+rn+" and wrongno="+wn+" and chap="+ce+" ");
                        rs1.next();
                        int n=rs1.getInt("n1");
                        i = r4.nextInt(n);
                        i=i+1;
                        int sqn1=0;
                        rs1 = stmt1.executeQuery("select *  from "+sub+std+"v where rightno="+rn+" and wrongno="+wn+" and chap="+ce+" ");
                        while(rs1.next())
                           {
                             sqn1++;
                             if(sqn1==i)
                               {
                                 q1=rs1.getInt("queno");
                               }
                           }
                          varlon[aa]=q1;
                   
hitesh4:
                        for(int i1=1;i1 < aa;i1++)
                           {
                             if(varlon[i1]==varlon[aa])
                               {
                                 i = r4.nextInt(n);
                                 i=i+1;
                                 sqn1=0;
                                 sqn1=0;
                                 rs1 = stmt1.executeQuery("select *  from "+sub+std+"v where rightno="+rn+" and wrongno="+wn+" and chap="+ce+" ");
                                 while(rs1.next())
                                   {
                                    sqn1++;
                                    if(sqn1==i)
                                      {
                                       q1=rs1.getInt("queno");
                                      }
                                   }
                                 varlon[aa]=q1;
                                 i1=0;
                                 continue hitesh4;
                               }
                           }
                           if(y1 <=4)
                           stmt2.executeUpdate("insert into "+st+" values ("+varlon[aa]+",'hitesh',"+ce+",'var') " );
                           aa++;
                    }

                 }

             } 
      } 
}
else{
     stmt.executeUpdate("update biodata set endtime="+h2+" where rollno="+ r1+ " and std="+s1+" and class='"+c1+"' and subject='"+sub+"' " );
    }
         }
      catch (Exception e) {
                                    out.println("<strong><font face=\"Lmg-Arun Condensed\" size=\"7\" color=\"blue\">ZM, G\\AZ VG[ GFD ,BJF H~ZL K[ VG[ ZM, G\\AZ VF\\S0FDF\\ H CMJM HM.V[</font></strong>");
                                    rolval=1;
                               //       out.println("<pre>");
                              //        out.println(e.getMessage());
                              //        out.println("</pre>");
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
if(noss==0 && rolval==0)
      {
       expcnt=expcnt+1;
       out.println("<table border=\"8\" width=\"515\">");
       out.println("<tr><th><font face=\"Lmg-Arun Condensed\" size=\"7\" color=\"blue\">TDFZM ;DI VtIFZ[ X~ YFI K[P  </font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face=\"Arial\" size=\"5\">   "+h1+":"+m1+":"+sec1+"</font></th></tr>");
       out.println("<tr><th><font face=\"Lmg-Arun Condensed\" size=\"7\" color=\"red\">5ZL1FF X~ SZJF GLR[G] A8G NAFJM</font></th></tr>");
       out.println("</table>");
       out.println("</center>");
       out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Kasoti1\">");
       out.println("<INPUT TYPE=\"hidden\" NAME= \"subj\" VALUE=\""+sub+"\">"); 
       out.println("<INPUT TYPE=\"hidden\" NAME= \"roll\" VALUE=\""+r1+"\">");
       out.println("<INPUT TYPE=\"hidden\" NAME= \"stad\" VALUE=\""+s1+"\">"); 
       out.println("<INPUT TYPE=\"hidden\" NAME= \"clas\" VALUE=\""+c1+"\">");
       out.println("<center>");
       out.println("<p><input  type=\"submit\" value=\"zL U6[XFI GDo\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\"></p>");
       out.println("</center>");
      }
else  {
    if(rolval==0)
       {
       out.println("<table border=\"8\" width=\"515\">");
       out.println("<tr><th><font face=\"Lmg-Arun Condensed\" size=\"6\" color=\"blue\">H[ T[ WMZ6DF\\ VFJTM lJQFI H 5;\\N SZM</font></th></tr>");
       out.println("<tr><th><font face=\"Lmg-Arun Condensed\" size=\"5\" color=\"red\">5FKF HJF DF8[ GLR[G] A8G NAFJM</font></th></tr>");
       out.println("</table>");
       out.println("</center>");
       out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/form\">");
       out.println("<center>");
       out.println("<p><input  type=\"submit\" value=\"5FKF J/M\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\"></p>");
       out.println("</center>");
       }
      }
if(rolval==1)
 {
       out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/form\">");
       out.println("<center>");
       out.println("<p><input  type=\"submit\" value=\"5FKF J/M\" name=\"start\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\"></p>");
       out.println("</center>");

 }                                                                      
//       out.println("<br><br><br>");
//       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(211,255,213)\">Developed By...</font></center>");
//       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(211,255,213)\">Hiteshkumar T. Shekhada</font></center>");
//       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(211,255,213)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-676644</font></center>");
      out.println("</form>");  
      out.println("</body>");
      out.println("</html>");

    }
}

