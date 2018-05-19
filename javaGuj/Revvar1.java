import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.lang.Math.*;
public class Revvar1 extends HttpServlet
{  static int expcnt=0;
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
//      response.setContentType("text/raw-html");
      PrintWriter out=response.getWriter();
      if(expcnt >= 4 )
        { response.sendRedirect("/servlet/Democom");
          return; }
         expcnt=expcnt+1;
      int count3=1;
      int i=0,a,p,j=0,flag1=0,c1=0;
      int state=0,state1=0,qno=1,cc2=0,cc3=0,cc4=0,h1=0,m1=0,ch=0,ce=0,ce1=0,ce2=0,ce3=0;
      int hhtt=0,sq1=0,jj=0,x1=0;
      String sub,st=null,qn1,ans=null,chk,hv2,hv3,cl,rollno,std,fon,opt1,temp=null,bcheck1=null; 
      String no1="a",lno=null,value1="aa";
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
//      cl=request.getParameter("clas");
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
           int qv1=0,rn1=0,wn1=0,pos1=0,tvar=0,totalvar=0,rightn=0;
           String av1=null,av2=null;
          if(bcheck1.equals("no"))
            { 
              rs1=stmt1.executeQuery("select * from "+sub+std+"v where queno="+qn1+";");
              rs1.next();
              rn1=rs1.getInt("rightno");
              wn1=rs1.getInt("wrongno");
              rightn=rn1;
            }
           if(state==0 && state1==0)
             {
                  Enumeration  eParmNames =request.getParameterNames();
                  while(eParmNames.hasMoreElements())
                              {
                                String name=(String) eParmNames.nextElement();
                                String value=request.getParameter(name);
                                if(name.equals("r1"))
                                                 {
                                                   rs = stmt.executeQuery("SELECT chap AS cp FROM "+sub+std+"v where queno="+qn1+"");
                                                   rs.next();
                                                   ch=rs.getInt("cp");
                                                   if(value1.equals("aa"))
                                                     {
                                                       value1=value;
                                                     }
                                                   else{
                                                   value1=value1+value;
                                                       }
                                                //    rs1=stmt1.executeQuery("select * from "+sub+std+"v where queno="+qn1+";");
                                                //     rs1.next();
                                               //     rn1=rs1.getInt("rightno");
                                               //     wn1=rs1.getInt("wrongno");
                                               //     rightn=rn1;
                                                    rn1=rn1*4;
                                                    int anl=value1.length();
                                                    if(anl < rn1)
                                                     {
                                                      rn1=anl;
                                                     }
                                                    av2=value1.substring(0,rn1);
                                                    pos1=av2.indexOf('V');
                                                    while(pos1 >= 0)
                                                     {
                                                      tvar++;
                                                      pos1=av2.indexOf('V',pos1+1);
                                                     }
                                                 }
                              }
                              if(tvar < rightn)
                                {
                                  flag1=1;
                                }
                                  } 
out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Revvar1\">");
i=no1.length();
if(flag1==1)
{
i--;
}
     rs = stmt.executeQuery("select count(*) as totque from "+sub+std+"v where chap="+lno+" ");
     rs.next();
     int count4=rs.getInt("totque");


     rs = stmt.executeQuery("select * from "+sub+std+"v where chap="+lno+" order by queno");
     while(rs.next()) {

                                 c1 = rs.getInt("queno");
                                int rn=rs.getInt("rightno");
                                int wn=rs.getInt("wrongno");
                                String que1 = rs.getString("que");
                                String ra1 = rs.getString("right1");
                                String ra2 = rs.getString("right2");
                                String ra3 = rs.getString("right3");
                                String ra4 = rs.getString("right4");
                                String ra5 = rs.getString("right5");
                                String ra6 = rs.getString("right6");
                                String ra7 = rs.getString("right7");
                                String ra8 = rs.getString("right8");
                                String ra9 = rs.getString("right9");
                                String ra10 = rs.getString("right10");
                                String ra11 = rs.getString("right11");
                                String ra12 = rs.getString("right12");
                                String ra13 = rs.getString("right13");
                                String ra14 = rs.getString("right14");
                                String ra15 = rs.getString("right15");
                                String ra16 = rs.getString("right16");
                                String ra17 = rs.getString("right17");
                                String ra18 = rs.getString("right18");
                                String ra19 = rs.getString("right19");
                                String ra20 = rs.getString("right20");
                                String wa1 = rs.getString("wrong1");
                                String wa2 = rs.getString("wrong2");
                                String wa3 = rs.getString("wrong3");
                                String wa4 = rs.getString("wrong4");
                                String wa5 = rs.getString("wrong5");
                                String wa6 = rs.getString("wrong6");
                                String wa7 = rs.getString("wrong7");
                                String wa8 = rs.getString("wrong8");
                                String wa9 = rs.getString("wrong9");
                                String wa10 = rs.getString("wrong10");
                                String wa11 = rs.getString("wrong11");
                                String wa12 = rs.getString("wrong12");
                                String wa13 = rs.getString("wrong13");
                                String wa14 = rs.getString("wrong14");
                                String wa15 = rs.getString("wrong15");
                                String wa16 = rs.getString("wrong16");
                                String wa17 = rs.getString("wrong17");
                                String wa18 = rs.getString("wrong18");
                                String wa19 = rs.getString("wrong19");
                                String wa20 = rs.getString("wrong20");
                          if(i==count3)
                            {
                                 rs = stmt.executeQuery("select quetype as fn from "+sub+std+"v where queno="+c1+" ");
                                 rs.next();
                                 String exmmsg=rs.getString("fn");
                                 rs1 = stmt1.executeQuery("select fname as fn from "+sub+std+"v where  queno="+c1+" ");
                                 rs1.next();
                                 fon=rs1.getString("fn");
                                out.println("<div align=\"center\"><center>");
                                out.println("<table border=\"0\"   style=\"color: rgb(255,183,111)\" bordercolor=\"blue\">");
                                out.println(" <tr>");
                                if(flag1==1)
                                {
                                out.println("<th><font face=\"Lmg-Arun Condensed\" color=\"red\" size=5>BM8]</font></th>");
                                }
                                out.println(" <td width=\"453\"  nowrap>");
                                out.println("<font face = \" "+fon+" \" color=\"#0000FF\"size=\"5\">")  ;
                                out.println("<center><font face=\""+fon+"\" size=\"4\"> "+exmmsg+"</center>");
                                out.println("</font>");  
                                out.println("</td>");
                                if(flag1==1)
                                {
                                out.println("<th><font face=\"Lmg-Arun Condensed\" color=\"red\" size=5>BM8]</font></th>");
                                }
                                out.println(" </tr></table></center></div>");
                                        out.println("<table border=\"0\" bordercolor=\"blue\">");
                                        out.println(" <tr>");
                                        out.println("  <td width=\"750\" height=\"\" colspan=\"3\" bordercolor=\"blue\">");
                                       out.println("<b><center><font face=\"Arial\" size=\"5\">("+i+")&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"6\">"+que1+"</font></center>");
                                        out.println("</td> </tr> ");
                                        out.println("</table>");
                                       out.println("<font face=\""+fon+"\" size=\"8\">");
                                       int number[] = new int[50];
                                       int ele = 1;
                 label1:               while(ele <= (rn+wn))
                                        {
                                         j = r2.nextInt(rn+wn);
                                         j=j+1;
                                         int k=(int)j;
                                         for(int ii=1;ii<=(rn+wn);ii++)
                                            {
                                            if(number[ii]==k)
                                                { continue label1;}
                                            }
                                         number[ele]=k;
                                         ele++;
                                        }
                                       for(int hit=1;hit <= (rn+wn);hit++)
                                          {
                                         //t   out.println("(1)number["+hit+"]="+number[hit]+",<br>");
                                            if(number[hit] > rn)
                                                {                                            
                                                number[hit]=number[hit]+(20-rn);
                                            //t    out.println("(2)number["+hit+"]="+number[hit]+",<br>");
                                                }
                                          }
                                        //t    out.println("case:"+j+"<br>");
                                out.println("<table border=\"1\" bordercolor=\"rgb(133,213,135)\" width=750 >");
                                ele=1;
                                while(ele <= (rn+wn))
                                {
                                 switch(number[ele]) {
                                                      case 1:
                                                               out.println("<tr>"); 
                                                                if(flag1==1)
                                                                {
                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V01\"  name=\"r1\"> ");
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra1+"</font>");
                                                               out.println("</td>  ");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V01\"  name=\"r1\"> ");
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra1+"</font>");
                                                               out.println("</td>  ");
                                                                }
                                                               out.println("</tr>"); 
                                                               break;
                                                      case 2:
                                                               out.println("<tr>"); 
                                                               if(flag1==1)
                                                                {
                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V02\"   name=\"r1\"> ");
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra2+"</font>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V02\"   name=\"r1\"> ");
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra2+"</font>");
                                                               out.println("</td>");
                                                               }
                                                              out.println("</tr>"); 
                                                               break;
                                                      case 3:
                                                            //********* op3*****
                                                               out.println("<tr>");
                                                                if(flag1==1)
                                                                {
                                                                out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V03\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra3+"</font></b>");
                                                               out.println("</td>");
                                                                 }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V03\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra3+"</font></b>");
                                                               out.println("</td>");
                                                                 }
                                                                out.println("</tr>"); 
                                                                break;
                                                       case 4:
                                                               out.println("<tr>");
                                                               if(flag1==1)
                                                                {
                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V04\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra4+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V04\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra4+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               out.println("</tr>"); 
                                                               break;
                                                      case 5:
                                                               out.println("<tr>"); 
                                                               if(flag1==1)
                                                                {
                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V05\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra5+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V05\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra5+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                              out.println("</tr>"); 
                                                               break;
                                                      case 6:
                                                               out.println("<tr>"); 
                                                               if(flag1==1)
                                                                {
                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V06\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra6+"</font></b>");
                                                               out.println("</td>");
                                                               out.println("</tr>"); 
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V06\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra6+"</font></b>");
                                                               out.println("</td>");
                                                               out.println("</tr>"); 
                                                                }
                                                               break;
                                                     case 7:
                                                               out.println("<tr>"); 
                                                               if(flag1==1)
                                                                {
                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V07\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra7+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V07\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra7+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               out.println("</tr>"); 
                                                               break;
                                                      case 8:
                                                               out.println("<tr>"); 
                                                               if(flag1==1)
                                                                {
                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V08\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra8+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V08\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra8+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               out.println("</tr>"); 
                                                               break;
                                                      case 9:
                                                              out.println("<tr>"); 
                                                               if(flag1==1)
                                                                {
                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V09\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra9+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V09\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra9+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                              out.println("</tr>"); 
                                                               break;
                                                      case 10:
                                                               out.println("<tr>"); 
                                                               if(flag1==1)
                                                                {
                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V10\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra10+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V10\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra10+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                              out.println("</tr>"); 
                                                               break;
                                                      case 11:
                                                               out.println("<tr>"); 
                                                               if(flag1==1)
                                                                {
                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V11\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra11+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V11\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra11+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               out.println("</tr>"); 
                                                               break;
                                                      case 12:
                                                               out.println("<tr>"); 
                                                               if(flag1==1)
                                                                {
                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V12\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra12+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V12\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra12+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               out.println("</tr>"); 
                                                               break;
                                                      case 13:
                                                               out.println("<tr>"); 
                                                               if(flag1==1)
                                                                {
                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V13\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra13+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V13\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra13+"</font></b>");
                                                               out.println("</td>");
                                                                 }
                                                                out.println("</tr>"); 
                                                                break;
                                                       case 14:
                                                                out.println("<tr>"); 
                                                                if(flag1==1)
                                                                {

                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V14\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra14+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V14\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra14+"</font></b>");
                                                               out.println("</td>");

                                                                }
                                                               
                                                               out.println("</tr>"); 



                                                               break;

                                                      case 15:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 

                                                               if(flag1==1)
                                                                {

                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V15\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra15+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V15\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra15+"</font></b>");
                                                               out.println("</td>");

                                                                }
                                                               
                                                               out.println("</tr>"); 



                                                               break;


                                                      case 16:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 

                                                               if(flag1==1)
                                                                {

                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V16\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra16+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V16\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra16+"</font></b>");
                                                               out.println("</td>");

                                                                }
                                                               
                                                               out.println("</tr>"); 



                                                               break;

                                                      case 17:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 

                                                               if(flag1==1)
                                                                {

                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V17\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra17+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V17\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra17+"</font></b>");
                                                               out.println("</td>");

                                                                }
                                                               
                                                               out.println("</tr>"); 



                                                               break;

                                                      case 18:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 

                                                               if(flag1==1)
                                                                {

                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V18\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra18+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V18\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra18+"</font></b>");
                                                               out.println("</td>");

                                                                }
                                                               
                                                               out.println("</tr>"); 



                                                               break;

                                                      case 19:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 

                                                               if(flag1==1)
                                                                {

                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V19\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra19+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V19\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra19+"</font></b>");
                                                               out.println("</td>");

                                                                }
                                                               
                                                               out.println("</tr>"); 



                                                               break;

                                                      case 20:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 

                                                               if(flag1==1)
                                                                {

                                                               out.println("<td bgcolor=\"rgb(133,213,135)\">");
                                                               out.println("<input type=\"checkbox\" value=\"V20\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra20+"</font></b>");
                                                               out.println("</td>");
                                                                }
                                                               else
                                                                {
                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"V20\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+ra20+"</font></b>");
                                                               out.println("</td>");

                                                                }
                                                               
                                                               out.println("</tr>"); 



                                                               break;

                                                      case 21:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H01\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa1+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;


                                                      case 22:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H02\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa2+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;



                                                      case 23:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H03\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa3+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;



                                                      case 24:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H04\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa4+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;



                                                      case 25:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H05\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa5+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;



                                                      case 26:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H06\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa6+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;



                                                      case 27:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H07\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa7+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;


                                                      case 28:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H08\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa8+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;


                                                      case 29:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H09\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa9+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;



                                                      case 30:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H10\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa10+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;



                                                      case 31:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H11\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa11+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;


                                                      case 32:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H12\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa12+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;


                                                      case 33:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H13\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa13+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;


                                                      case 34:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H14\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa14+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;


                                                      case 35:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H15\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa15+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;



                                                      case 36:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H16\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa16+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;



                                                      case 37:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H17\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa17+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;




                                                      case 38:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H18\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa18+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;


                                                      case 39:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H19\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa19+"</font></b>");
                                                               out.println("</td>");

                                                               
                                                               out.println("</tr>"); 



                                                               break;



                                                      case 40:

                                                               //********* op10*****
                                                               
                                                               out.println("<tr>"); 


                                                               out.println("<td>");
                                                               out.println("<input type=\"checkbox\" value=\"H20\"    name=\"r1\"> "); 
                                                               out.println("<font face=\"arial\">&nbsp;&nbsp;&nbsp;</font><font face=\""+fon+"\" size=\"5\">"+wa20+"</font></b>");
                                                               out.println("</td>");
                                                               out.println("</tr>"); 
                                                               break;
                                                               }
                                                                ele++;

                                                                } 
                                out.println("</table></center></div>");
                                out.println("</font>");
                                out.println("<INPUT TYPE=\"hidden\" NAME= \"qqn\" VALUE=\""+c1+"\">");
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"subject\" VALUE=\""+sub+"\">"); 
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"std\" VALUE=\""+std+"\">"); 
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"lno\" VALUE=\""+lno+"\">");
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"bcheck\" VALUE=\"no\">"); 
                                 if(flag1==0)
                                  {
                                  out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\""+no1+1+"\">");
                                  }
                                 else{
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\""+no1+"\">");
                                     }
                            //     out.println("<div align=\"center\"><center><table border=\"5\" width=\"244\" height=\"30\"   bordercolor=\"blue\">");
                             //    out.println("<tr> <td width=\"244\" height=\"30\" valign=\"middle\">");
                                 out.println("<br><center><input  type=\"submit\" value=\"GJM 5|`G\" name=\"next\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\"></center>");
                                 out.println("</form>");
                           //      out.println("</td> </tr></table></center></div>");
                    }
                                         count3++;
       }                                              
                    if(i>count4)
                      {
                      out.println("<br><br><br><br><center><font face=\"Lmg-Arun Condensed\" size=5 color=\"blue\">5|`Gv5 GF 5F9</font><font face=\"Times New Roman\" size=5>&nbsp;"+lno+"&nbsp;</font><font face=\"Lmg-Arun Condensed\" size=5 color=\"blue\">G] 5]GZFJT\"G 5]6\" Y. UI]</font></center>");
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
