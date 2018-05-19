import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;
import java.lang.String.*;
import java.lang.*;
public class Result extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
//      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      String st=null,sub,opt1,cc=null,q1=null,r1=null,w1=null,w2=null,rollno=null,cl=null,std=null,fon=null,ccl=null;
      String ansj=null,ansj1=null,chj1=null;
      int cc1=0,cc2=0,cc4=0,count=0,cnt1=0,tans=0,i=0,total=0,joi=0,cd1=0,cd2=0,cd3=0,cd4=0,cd5=0,cd6=0,cd7=0,cd8=0,cd9=0,cd10=0;
      int eti=0,h1=0,m1=0,sec1=0,dupres=0;
      int qj=0,chj=0,qj1=0,k=0,mopt2=0,msho2=0,mlon2=0,mjoi2=0;
   //   java.util.Date d1;
   //   d2=new java.util.Date();
      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(234,233,243)\">");
      out.println("<center><table border=\"0\" width=\"500\">");
      out.println("<tr><th><strong><center><font face=\"Times New Roman\" size=\"6\" color=\"blue\">School Or College Name</font></center></font></strong></th></tr>");
      out.println("</table></center>");
      out.println("<center><table border=\"0\" width=\"500\">");
      out.println("<tr><th><strong><center><font face=\"Times New Roman\" size=\"5\" color=\"blue\">School Or College Address</font></center></font></strong></th></tr>");
      out.println("</table></center>");
      out.println("<center><table border=\"1\" width=\"500\">");
      out.println("<tr><th><strong><center><font face=\"Times New Roman\" size=\"5\" color=\"blue\">Student's Detailed Result</font></center></font></strong></th></tr>");
      out.println("</table></center>");
      Connection con=null;
      Statement stmt=null;
      Statement stmt1=null,stmt2=null,stmt3=null,stmt5=null;
      ResultSet rs=null;
      ResultSet rs1=null,rs2=null,rs3=null,rs5=null;
      out.println("<center><table border=\"1\" width=\"500\">");
      sub=request.getParameter("subj");
      rollno=request.getParameter("roll");      
      cl=request.getParameter("clas");
      std=request.getParameter("stad");
      opt1=request.getParameter("opt");
      st=rollno+std+cl+sub;
      java.util.Date d1;
      d1=new java.util.Date();
      Locale currentLocale=new Locale("fr","FR"); 
      java.util.Date today;
      String date1,month1,year1;
      SimpleDateFormat formatter;
      formatter = new SimpleDateFormat("dd", currentLocale);
      today = new java.util.Date();
      date1 = formatter.format(today);
      formatter = new SimpleDateFormat("MM", currentLocale);
      today = new java.util.Date();
      month1 = formatter.format(today);
      formatter = new SimpleDateFormat("yy", currentLocale);
    //  today = new java.util.Date();
      year1 = formatter.format(today);
     try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();
                 stmt2 = con.createStatement();
                 stmt3 = con.createStatement();
                 stmt5 = con.createStatement();
                 h1=d1.getHours();
                 m1=d1.getMinutes();
                 sec1=d1.getSeconds();
                 h1=h1*3600+m1*60+sec1;
                 rs = stmt.executeQuery("SELECT endtime FROM biodata AS t1 where rollno="+rollno+" and class='"+cl+"' and  std="+std+" and subject='"+sub+"'");
                 while(rs.next())
                       { eti = rs.getInt("endtime"); }
                 con.commit();
            //t     out.println("time::"+cc4+"");
      //t           out.println("timeh1::"+h1+"");
                 int distime=eti-h1;
                 distime=distime/60;
                 rs = stmt.executeQuery("SELECT examtime FROM superuser  where  class='"+cl+"' and  std="+std+" and subject='"+sub+"'");
                 rs.next();
                 int suptime=rs.getInt("examtime");
                 int stutime=suptime-distime;
                 rs = stmt.executeQuery("select * from biodata where rollno="+rollno+"  and std="+std+" and class='"+cl+"' and subject='"+sub+"'");
                 rs.next();
                 String name1=rs.getString("name");
                 rs = stmt.executeQuery("select * from result where roll_no="+rollno+"  and std="+std+" and class='"+cl+"' and sub='"+sub+"' and date1="+date1+" and month1="+month1+" ");
                 if(!rs.next())
                    {             
                    stmt.executeUpdate("insert into result values('"+name1+"','"+cl+"',"+rollno+","+std+",'"+sub+"',0,0,0,0,0,0,0,0,0,0,"+date1+","+month1+")");
                    dupres=1;
                    }
                 out.println("<center><table border=\"1\" width=\"500\">");
                 out.println("<tr><td width=\"150\"><strong><font face=\"Times New Roman\" size=\"5\" >Name</font></strong></td>");
                 out.println("<td><strong>"+name1+"</strong></td></tr>");
                 rs = stmt.executeQuery("select sum(maxopt) as mq from course where std="+std+" and class='"+cl+"' and sub='"+sub+"'");
                 rs.next();
                 int totalopt= rs.getInt("mq");
                 rs = stmt.executeQuery("SELECT *  FROM "+st+"");
                 rs.next();                           
                                            cc2 = rs.getInt("queno");
                                            String cc3 = rs.getString("ans");
                                            out.println("<tr><td width=\"150\"><strong><font face=\"Times New Roman\" size=\"5\" >RollNo</font></strong></td>");
                                            out.println("<td><strong>"+cc2+"</strong></td></tr>");
                                            out.println("<tr><td width=\"150\"><strong><font face=\"Times New Roman\" size=\"5\" >Std-Class</font><strong></td>");
                                            out.println("<td><strong>"+cc3+"</strong></td></tr>");
                                            out.println("<tr><td width=\"150\"><strong><font face=\"Times New Roman\" size=\"5\" >Subject</font></strong></td>");
                                            out.println("<td><strong>"+sub+"</strong></td></tr>");
                                            out.println("<tr><td width=\"150\"><strong><font face=\"Times New Roman\" size=\"5\" >Date Of Exam</font></strong></td><td><strong>"+date1+"-"+month1+"-"+year1+"</strong></td></tr>");
                                            out.println("</table></center>");
                  rs = stmt.executeQuery("select sum(maxopt) as m1,sum(maxsho) as m2,sum(maxlon) as m3,sum(maxjoi) as m4 from course where std="+std+" and sub='"+sub+"' and class='"+cl+"' ");
                  if(rs.next())
                  {
                  mopt2 =rs.getInt("m1");
                  msho2 = rs.getInt("m2");
                  mlon2 = rs.getInt("m3");
                  mjoi2 = rs.getInt("m4");
                  }
                  int mvar2=0;
                  rs = stmt.executeQuery("select sum(maxvarlon) as m1 from course1 where std="+std+" and sub='"+sub+"' and class='"+cl+"' ");
                  if(rs.next())
                  {
                  mvar2 =rs.getInt("m1");
                  }
                  rs = stmt.executeQuery("SELECT DISTINCT queno AS c2 FROM "+st+" where type='opt' GROUP BY queno ");
                  while(rs.next() ) {
                                            cc1 = rs.getInt("c2");
                                            rs1 = stmt1.executeQuery("SELECT ans AS c1 FROM "+st+" WHERE queno="+cc1+" and type='opt'");
                                            rs1.next(); 
                                            cc = rs1.getString("c1");
                                            if(cc.equals("V1"))
                                                  {
                                                   tans++;
                                                  }
                                    }
                                         if(dupres==1)
                                           {
                                            stmt.executeUpdate("update result set tot_opt="+totalopt+" where roll_no = "+rollno+" and std = "+std+" and class ='"+cl+"' and sub = '"+sub+"'  ");
                                            con.commit();
                                            stmt.executeUpdate("update result set j_opt="+tans+" where roll_no = "+rollno+" and std = "+std+" and class ='"+cl+"' and sub = '"+sub+"'  ");
                                            con.commit();
                                           }
                                  rs = stmt.executeQuery("SELECT *  FROM "+rollno+std+cl+sub+" where type = 'joi' order by chap,queno ");
                                  while(rs.next())
                                    {
                                                 qj=rs.getInt("queno");
                                                 ansj=rs.getString("ans");
                                                 chj=rs.getInt("chap");
                                                 rs1 = stmt1.executeQuery("SELECT *  FROM "+sub+std+" where queno="+qj+" and chap="+chj+" and quefield='joi' ");
                                                 rs1.next();
                                                 qj1 = rs1.getInt("queno");
                                                 ansj1 = rs1.getString("right1");
                                                 if(ansj.equals(ansj1))
                                                     {
                                                      joi++;
                                                     }
                                               }
                                         if(dupres==1)
                                           {
                                                stmt.executeUpdate("update result set j_joi="+joi+" where roll_no = "+rollno+" and std = "+std+" and class ='"+cl+"' and sub = '"+sub+"'  ");
                                           }     
                                          rs = stmt.executeQuery("SELECT sum(maxjoi) as maq FROM course where std="+std+" and class='"+cl+"' and sub='"+sub+"' ");
                                          rs.next(); 
                                                cc4 = rs.getInt("maq");
                                                cc4=cc4;
                                         if(dupres==1)
                                           {
                                               stmt.executeUpdate("update result set tot_joi="+cc4+" where roll_no = "+rollno+" and std = "+std+" and class ='"+cl+"' and sub = '"+sub+"'  ");
                                               con.commit();
                                           }
                                          int cn=0;
                                          rs = stmt.executeQuery("SELECT *  FROM "+st+" where type='sho'");
                                          while(rs.next())
                                             {
                                                int qno1=rs.getInt("queno");
                                                String an1=rs.getString("ans");
                                                rs1 = stmt1.executeQuery("select * from "+sub+std+" where queno="+qno1+" and quefield='sho'");
                                                rs1.next();
                                                q1=rs1.getString("que");
                                                r1=rs1.getString("right1");
                                               // if(r1.equalsIgnoreCase(an1))
                                                if(r1.equals(an1))
                                                             {
                                                              cn++;
                                                             }
                                               }
                                                rs = stmt.executeQuery("select sum(maxsho) as mq from course where std="+std+" and class='"+cl+"' and sub='"+sub+"'");
                                                rs.next();
                                                int totalsho= rs.getInt("mq");
                                         if(dupres==1)
                                           {
                                                stmt.executeUpdate("update result set tot_sho="+totalsho+" where roll_no = "+rollno+" and std = "+std+" and class ='"+cl+"' and sub = '"+sub+"'  ");
                                                con.commit();
                                                stmt.executeUpdate("update result set j_sho="+cn+" where roll_no = "+rollno+" and std = "+std+" and class ='"+cl+"' and sub = '"+sub+"'  ");
                                                con.commit();
                                           }
                                           int tansl=0;
                          rs = stmt.executeQuery("SELECT DISTINCT queno AS c2 FROM "+st+" where type='lon' GROUP BY queno ");
                          while(rs.next() ) {
                                            cc1 = rs.getInt("c2");
                                            rs1 = stmt1.executeQuery("SELECT ans AS c1 FROM "+st+" WHERE queno="+cc1+" and type='lon'");
                                            rs1.next(); 
                                            cc = rs1.getString("c1");
                                            if(cc.equals("V1"))
                                                  {
                                                   tansl++;
                                                  }
                                    }
                                        if(dupres==1)
                                           {
                                            rs = stmt.executeQuery("select sum(maxlon) as mq from course where std="+std+" and class='"+cl+"' and sub='"+sub+"'");
                                            rs.next();
                                            int totallon= rs.getInt("mq");
                                            stmt.executeUpdate("update result set tot_lon="+totallon+" where roll_no = "+rollno+" and std = "+std+" and class ='"+cl+"' and sub = '"+sub+"'  ");
                                            con.commit();
                                            stmt.executeUpdate("update result set j_lon="+tansl+" where roll_no = "+rollno+" and std = "+std+" and class ='"+cl+"' and sub = '"+sub+"'  ");
                                            con.commit();
                                           }
                                           int qv1=0,rn=0,wn=0,pos1=0,tvar=0,totalvar=0;
                                           String av1=null,av2=null;
                          rs = stmt.executeQuery("SELECT DISTINCTROW * FROM "+st+" where type='var' ");
                          while(rs.next() ) {
                                            qv1 = rs.getInt("queno");
                                            av1 = rs.getString("ans");
                                            rs1=stmt1.executeQuery("select * from "+sub+std+"v where queno="+qv1+";");
                                            rs1.next();
                                            rn=rs1.getInt("rightno");
                                            wn=rs1.getInt("wrongno");
                                            rn=rn*4;
                                            int anl=av1.length();
                                            if(anl < rn)
                                             {
                                              rn=anl;
                                             }
                                            av2=av1.substring(0,rn);
                                            pos1=av2.indexOf('V');
                                            while(pos1 >= 0)
                                             {
                                              tvar++;
                                              pos1=av2.indexOf('V',pos1+1);
                                             }
                                    }
                           rs = stmt.executeQuery("select sum(maxvarlon * rightno) as m1 from course1 where std="+std+" and sub='"+sub+"' and class='"+cl+"' ");
                             rs.next();
                            totalvar =rs.getInt("m1");
                if(dupres==1)
                    {
                     stmt.executeUpdate("update result set tot_var="+totalvar+" where roll_no = "+rollno+" and std = "+std+" and class ='"+cl+"' and sub = '"+sub+"' and date1="+date1+" and month1="+month1+" ");
                     con.commit();
                     stmt.executeUpdate("update result set j_var="+tvar+" where roll_no = "+rollno+" and std = "+std+" and class ='"+cl+"' and sub = '"+sub+"' and date1="+date1+" and month1="+month1+"  ");
                     con.commit();
                    }
                  rs = stmt.executeQuery("select * from result where roll_no="+rollno+"  and std="+std+" and class='"+cl+"' and sub='"+sub+"' and date1="+date1+" and month1="+month1+"");
                  rs.next();
                                            cd1 = rs.getInt("tot_opt");
                                            cd2 = rs.getInt("j_opt");
                                            cd3 = rs.getInt("tot_sho");
                                            cd4 = rs.getInt("j_sho");
                                            cd5 = rs.getInt("tot_lon");
                                            cd6 = rs.getInt("j_lon");
                                            cd7 = rs.getInt("tot_joi");
                                            cd8 = rs.getInt("j_joi");
                                            cd9 = rs.getInt("tot_var");
                                            cd10 = rs.getInt("j_var");
                                            out.println("<center><table border=\"1\" width=\"500\">");
                                            out.println("<tr><th></th><th><font face=\"Times New Roman\" size=\"4\">Q-1</font>");
                                            out.println("</th><th><font face=\"Times New Roman\" size=\"4\">Q-2</font>");
                                            out.println("</th><th><font face=\"Times New Roman\" size=\"4\">Q-3</font>");
                                            out.println("</th><th><font face=\"Times New Roman\" size=\"4\">Q-4</font>");
                                            out.println("</th><th><font face=\"Times New Roman\" size=\"4\">Q-5</font></th>");
                                            out.println("<th><font face=\"Times New Roman\" size=\"4\">Total</font></th></tr>");
                                            out.println("<tr><td><strong><font face=\"Times New Roman\" size=\"4\" >Total Marks</font></strong></td>");
                                            out.println("<th>" + cd1 + "</th>");
                                            out.println("<th>" + cd3 + "</th>");
                                            out.println("<th>" + cd5 + "</th>");
                                            out.println("<th>" + cd7 + "</th>");
                                            out.println("<th>" + cd9 + "</th>");
                                            int tt1= cd1+cd3+cd5+cd7+cd9;
                                            out.println("<th>" +tt1+ "</th></tr>");
                                            out.println("<tr><td><strong><font face=\"Times New Roman\" size=\"4\" >Obtained</font></strong></td>");
                                            out.println("<th>" + cd2 + "</th>");
                                            out.println("<th>" + cd4 + "</th>");
                                            out.println("<th>" + cd6 + "</th>");
                                            out.println("<th>" + cd8 + "</th>");
                                            out.println("<th>" + cd10 + "</th>");
                                            int tt2=cd2+cd4+cd6+cd8+cd10;
                                            out.println("<th>" +tt2+ "</th>");
                                            out.println("</tr>");
                                            float taka=tt2 * 100 /tt1;
                                            String grade1="d";
                                            if(taka < 40.0 )
                                                grade1="FAIL";
                                            if(taka >= 40.0 && taka < 60.0)
                                                grade1="SECOND-CLASS";
                                            if(taka >= 60.0 && taka < 70.0)
                                                grade1="FIRST-CLASS";
                                            if(taka >= 70.0)
                                                grade1="DISTINCTION";
                                            out.println("</table></center>");
                                            out.println("<center><table border=\"1\" width=\"500\">");
                                            out.println("<tr><td><strong><font face=\"Times New Roman\" size=\"4\" >Percentage</font></strong></td>");
                                            out.println("<th>" + taka + "%</th><th><font face=\"Times New Roman\" size=\"4\" >Grade</font></th><th>"+grade1+"</th></tr>");
                                            out.println("</table></center>");
                                            out.println("<center><table border=\"1\" width=\"500\">");
                                            if(stutime <= suptime)
                                            {
                                            out.println("<tr><th><strong><font face=\"Times New Roman\" size=\"3\" >Student Has Taken " + stutime + "</font>&nbsp;<font face=\"Times New Roman\" size=\"3\" >Minute To Complete Exam</font></strong></th>");
                                            out.println("</tr></table></center>");
                                            }
                                            else
                                            {
                                            out.println("<tr><th><strong><font face=\"Times New Roman\" size=\"4\" color=\"RED\" >Student Has Not Complete The Exam In Time</font></strong></th>");
                                            out.println("</tr></table></center>");
                                            }
                                            out.println("<hr>");
 
                           if(mopt2>0)
                                     {
                                            out.println("<b>");
                                            out.println("<center><table border=\"1\" width=\"700\">");
                                            out.println("<tr><th><center><font face=\"Times New Roman\" color=\"blue\" size=5 >Q-1: Questions,Student's Answer & It's True Answer</font></center></th></tr>");
                                            out.println("</table></center>");
                                            rs = stmt.executeQuery("SELECT queno,ans,chap,type  FROM "+st+" where type='opt'");
                                            while(rs.next())
                                               {
                                                i++;
                                                int qno1=rs.getInt("queno");
                                                String an1=rs.getString("ans");
                                                rs1 = stmt1.executeQuery("select * from "+sub+std+" where queno="+qno1+" and quefield='opt'");
                                                rs1.next();
                                                q1=rs1.getString("que");
                                                r1=rs1.getString("right1");
                                                w1=rs1.getString("wrong1");
                                                w2=rs1.getString("wrong2");
                                                rs5 = stmt5.executeQuery("select fname as fn from "+sub+std+" where quefield='opt' and queno="+qno1+" ");
                                                rs5.next();
                                                fon=rs5.getString("fn");
                                                //    out.println("<font face="+fon+" >");
                                                out.println("<center><table border=\"0\" width=\"700\">");
                                                out.println("<tr><td><font face=\"Arial\">("+i+")&nbsp;&nbsp;&nbsp;</font><font face="+fon+" >"+q1+"</font></td></tr>");
                                                out.println("</table>");
                                                out.println("<center><table border=\"0\" width=\"700\">");
                                                out.println("<tr>");
                                                if(an1.equals("V1"))
                                                             {
                                                              out.println("<td width=350><strong><i><b><font face=\"Times New Roman\">Your Answer</font><font face=\"Arial\">-&nbsp;&nbsp;</font><font face=\"Times New Roman\" color=\"green\">Is Right</font></i></b></strong></td>");
                                                              out.println("<td width=350><strong><font face=\"Times New Roman\">True Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;</font></font><font face="+fon+" >"+r1+"</font></td></tr>");
                                                             }
                                                if(an1.equals("V2"))
                                                             {
                                                              out.println("<td width=350><strong><font face=\"Times New Roman\">Your Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;</font><font face="+fon+" >"+w1+"</font></td>");
                                                              out.println("<td width=350><strong><font face=\"Times New Roman\">True Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;</font><font face="+fon+" >"+r1+"</font></td></tr>");
                                                              }
                                                if(an1.equals("V3"))
                                                             {
                                                              out.println("<td width=350><strong><font face=\"Times New Roman\">Your Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;</font><font face="+fon+" >"+w2+"</font></td>");
                                                              out.println("<td width=350><strong><font face=\"Times New Roman\">True Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;</font><font face="+fon+" >"+r1+"</font></td></tr>");
                                                              }
                                                if(an1.equals("hitesh"))
                                                             {
                                                              out.println("<td width=350><strong><font face=\"Times New Roman\"><i>Your Time Expire</i></font></strong></td>");
                                                              out.println("<td width=350><strong><font face=\"Times New Roman\">True Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;</font><font face="+fon+" >"+r1+"</font></td></tr>");
                                                             }
                                                if(an1.equals("V5"))
                                                             {
                                                              out.println("<td width=350><strong><i><b><font face=\"Times New Roman\">Your Answer</font><font face=\"Arial\">-&nbsp;&nbsp;</font><font face=\"Times New Roman\" color=\"green\">Answer Not Given</font></i></b></strong></td>");
                                                              out.println("<td width=350><strong><font face=\"Times New Roman\">True Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;</font></font><font face="+fon+" >"+r1+"</font></td></tr>");
                                                             }
                                               out.println("</b>");
                                               out.println("</table></center>");
                                               }
                                             //  out.println("</b>");
                                             //  out.println("</table></center>");
                                               out.println("<hr>");
                                    }
                                   if(msho2>0)
                                        {
                                            i=0;
                                            out.println("<center><table border=\"1\" width=\"700\">");
                                            out.println("<th><b><font face=\"Times New Roman\" color=\"blue\" size=5 >Q-2: Questions,Student's Answer & It's True Answer</b></font>");
                                            out.println("</th></tr></table></center>");
                                            out.println("<b>");
                                            rs = stmt.executeQuery("SELECT *  FROM "+st+" where type='sho'");
                                            out.println("<center><table border=\"0\" width=\"700\">");
                                            out.println("<strong><tr><td><strong><b><font face=\"Times New Roman\" >No</font></strong></b></td><td><strong><b><font face=\"Times New Roman\" >Question</font></strong></b></td><td><strong><b><font face=\"Times New Roman\" >Your Answer</font></strong></b></td><td><strong><b><font face=\"Times New Roman\" >True Answer</font></strong></b></td></tr></strong>");
                                            //out.println("<strong><tr><th><font face=\"LMG-Arun\">QueNo</font></th><th><font face=\"LMG-Arun\">Question</font></th><th><font face=\"LMG-Arun\">Your Answer</font></th><th><font face=\"LMG-Arun\">True Answer</font></th></tr></strong>");
                                            while(rs.next())
                                               {
                                                i++;
                                                int qno1=rs.getInt("queno");
                                                String an1=rs.getString("ans");
                                                rs1 = stmt1.executeQuery("select * from "+sub+std+" where queno="+qno1+" and quefield='sho'");
                                                rs1.next();
                                                q1=rs1.getString("que");
                                                r1=rs1.getString("right1");
                                                rs5 = stmt5.executeQuery("select fname as fn from "+sub+std+" where quefield='sho' and queno="+qno1+" ");
                                                rs5.next();
                                                fon=rs5.getString("fn");
                                                out.println("<tr><td><font face=\"Arial\">("+i+")</font></td><td><font face = \""+fon+"\">"+q1+"</font></td>");
                                          //      if(r1.equals(" "))
                                          //                      {
                                          //                      out.println("<td><strong><font face=\"Arial\">&nbsp;you have not given answer <font></strong></td>");
                                          //                      out.println("<td>"+r1+"</td></tr>");
                                          //                      }
                                            //    if(r1.equals(an1))
                                                if(r1.equalsIgnoreCase(an1))
                                                             {
                                                              out.println("<td><strong><i><b><font face=\"Times New Roman\" color=\"green\">Is Right</font></i></b></strong></td>");
                                                              out.println("<td><font face=\"Arial\">"+r1+"</font></td></tr>");
                                                             }
                                          //      String hit="hitesh";
                                          //      if(an1.equals(hit))
                                          //                   {
                                          //                    out.println("<td><strong><i><b><font face=\"Times New Roman\" color=\"Gray\">Your Time Expires</font></i></b></strong></td>");
                                          //                    out.println("<td><font face=\"Arial\">"+r1+"</font></td></tr>");
                                          //                   }
                                                else{
                                                      out.println("<td><font face=\"Arial\">"+an1+"</font></td>");
                                                      out.println("<td><font face=\"Arial\">"+r1+"</font></td></tr>");
                                                     }
                                               }
                                               out.println("</b>");
                                               out.println("</table></center>");
                                               out.println("<hr>");
                                                }
                                             if(mlon2 > 0)
                                                {
                                            i=0;
                                            out.println("<b>");
                                            out.println("<center><table border=\"1\" width=\"700\">");
                                            out.println("<tr><th><center><font face=\"Times New Roman\" color=\"blue\" size=5 >Q-3: Questions,Student's Answer & It's True Answer</font></center></th></tr>");
                                            out.println("</table></center>");
                                            rs = stmt.executeQuery("SELECT queno,ans,chap,type  FROM "+st+" where type='lon'");
                                            while(rs.next())
                                               {
                                                i++;
                                                int qno1=rs.getInt("queno");
                                                String an1=rs.getString("ans");
                                                rs1 = stmt1.executeQuery("select * from "+sub+std+"l where queno="+qno1+" and quefield='lon'");
                                                rs1.next();
                                                q1=rs1.getString("que");
                                                r1=rs1.getString("right1");
                                                w1=rs1.getString("wrong1");
                                                w2=rs1.getString("wrong2");
                                                rs5 = stmt5.executeQuery("select fname as fn from "+sub+std+"l where quefield='lon' and queno="+qno1+" ");
                                                rs5.next();
                                                fon=rs5.getString("fn");
                                            //    out.println("<font face="+fon+" >");
                                                out.println("<center><table border=\"0\" width=\"700\">");
                                                out.println("<tr><td><font face=\"Arial\">("+i+")&nbsp;&nbsp;&nbsp;<pre></font><font face="+fon+" >"+q1+"</font></pre></td></tr>");
                                                out.println("</table>");
                                                out.println("<center><table border=\"0\" width=\"700\">");
                                                if(an1.equals("V1"))
                                                             {
                                                              out.println("<tr><td><strong><i><b><font face=\"Times New Roman\">Your Answer</font><font face=\"Arial\">-&nbsp;&nbsp;</font><font face=\"Times New Roman\" color=\"green\">Is Right</font></i></b></strong></td></tr>");
                                                              out.println("<tr><td><strong><font face=\"Times New Roman\">True Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;<pre></font></font><font face="+fon+" >"+r1+"</font></pre></td></tr>");
                                                             }
                                                if(an1.equals("V2"))
                                                             {
                                                              out.println("<tr><td><strong><font face=\"Times New Roman\">Your Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;<pre></font><font face="+fon+" >"+w1+"</font></pre></td></tr>");
                                                              out.println("<tr><td><strong><font face=\"Times New Roman\">True Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;<pre></font><font face="+fon+" >"+r1+"</font></pre></td></tr>");
                                                              }
                                                if(an1.equals("V3"))
                                                             {
                                                              out.println("<tr><td><strong><font face=\"Times New Roman\">Your Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;<pre></font><font face="+fon+" >"+w2+"</font></pre></td></tr>");
                                                              out.println("<tr><td><strong><font face=\"Times New Roman\">True Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;<pre></font><font face="+fon+" >"+r1+"</font></pre></td></tr>");
                                                              }
                                                if(an1.equals("hitesh"))
                                                             {
                                                              out.println("<tr><td><strong><font face=\"Times New Roman\"><i>Your Time Expire</i></font></strong></td></tr>");
                                                              out.println("<tr><td><strong><font face=\"Times New Roman\">True Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;<pre></font><font face="+fon+" >"+r1+"</font></pre></td></tr>");
                                                             }
                                                if(an1.equals("V5"))
                                                             {
                                                              out.println("<tr><td><strong><i><b><font face=\"Times New Roman\">Your Answer</font><font face=\"Arial\">-&nbsp;&nbsp;</font><font face=\"Times New Roman\" color=\"green\">Not Given</font></i></b></strong></td></tr>");
                                                              out.println("<tr><td><strong><font face=\"Times New Roman\">True Answer</font></strong><font face=\"Arial\">-&nbsp;&nbsp;<pre></font><font face="+fon+" >"+r1+"</font></pre></td></tr>");
                                                             }
                                               out.println("</b>");
                                               out.println("</table></center>");
                                               }
                                               out.println("<hr>");
                                               }
                                            if(mjoi2 > 0)
                                            {
                                            String tr1=null,rr1=null,ff1=null;
                                            int noatj=0;
                                            i=0;
                                            k=1;
                                            out.println("<center><table border=\"1\" width=\"700\">");
                                            out.println("<tr><th><font face=\"Times New Roman\" color=\"blue\" size=\"5\">");
                                            out.println("<b>Q-4: Questions,Student's Answer & It's True Answer</b>");
                                            out.println("</font></th></tr>");
                                            out.println("</table></center><b>");
                                            out.println("<center><table border=\"0\" width=\"700\">");
                                            out.println("<tr><th><font face=\"arial\">(1)</th></tr></font>");
                                            out.println("</table></center>");
                                            out.println("<center><table border=\"0\" width=\"700\">");
                                            out.println("<tr><td></td><td></td><td><strong><b><font face=\"Times New Roman\" >Your Answer</font></strong></b> </td><td><strong><b> <font face=\"Times New Roman\" >True Answer</font></strong></b></td><td></td></tr>");
                                            rs = stmt.executeQuery("SELECT *  FROM "+st+" where  type = 'joi' order by chap,queno");
                                            while(rs.next())                                    
                                               {
                                                noatj=1;
                                                i++;
                                                int qno1=rs.getInt("queno");
                                                String an1=rs.getString("ans");
                                                rs2 = stmt2.executeQuery("select * from "+sub+std+" where queno="+qno1+" and quefield='joi' ");
                                                if(rs2.next())
                                                  {
                                                    q1=rs2.getString("que");
                                                    ff1=rs2.getString("right1");
                                                  }
                                                rs5 = stmt5.executeQuery("select fname as fn from "+sub+std+" where quefield='joi' and queno="+qno1+" ");
                                                if(rs5.next())
                                                fon=rs5.getString("fn");
                                                int joiflag=0;
                                                if(an1.equals("hitesh"))
                                                 {
                                                out.println("<tr><td><font face=\"arial\">("+i+")</font></td><td><font face=\""+fon+"\" >"+q1+"</font></td><td><b><i><font face=\"Times New Roman\" color=\"green\">Ans. Not Given</font></i></b></td>");
                                                out.println("<td><font face=\""+fon+"\">"+ff1+"</font></td></tr>");
                                                joiflag=1;
                                                 }
                                                if(joiflag==0)
                                                {
                                                if(ff1.equals(an1))
                                                {
                                                out.println("<tr><td><font face=\"arial\">("+i+")</font></td><td><font face=\""+fon+"\" >"+q1+"</font></td><td><i><b><font face=\"Times New Roman\" color=\"green\">Is Right</font></i></b></td>");
                                             // out.println("<td></td><td><font face=\""+fon+"\" >"+q1+"</font></td><td><font face=\""+fon+"\" >"+rr1+"</font></td></tr>");
                                                out.println("<td><font face=\""+fon+"\" >"+ff1+"</font></td></tr>");
                                                }
                                                else
                                                {
                                                out.println("<tr><td><font face=\"arial\">("+i+")</font></td><td><font face=\""+fon+"\" >"+q1+"</font></td><td><font face=\""+fon+"\" >"+an1+"</font></td>");
                                             // out.println("<td></td><td><font face=\""+fon+"\" >"+q1+"</font></td><td><font face=\""+fon+"\" >"+rr1+"</font></td></tr>");
                                                out.println("<td><font face=\""+fon+"\" >"+ff1+"</font></td></tr>");
                                                }
                                                }
                                               }
                                               out.println("</table></center>");
                                               out.println("<hr></b>");
                                               if(noatj==0)
                                               {
                                                 out.println("<font face=\"Times New Roman\" ><i><strong>This Question Is Not Attended By Student Because Time Was Expire</strong></i></font>");
                                               }
                   }
                  tvar=0;
                  int colno=0,anl=0,pos=0,varqno=1;
                  String quev=null,truean=null;
                     if(mvar2 > 0)
                       {
                  out.println("<center><table border=\"1\" width=\"700\">");
                  out.println("<tr><th><font face=\"Times New Roman\" color=\"blue\" size=\"5\">");
                  out.println("<b>Q-5: Questions,Student's Answer & It's True Answer</b>");
                  out.println("</font></th></tr>");
                  out.println("</table></center><b>");
                  out.println("<center><table border=\"1\" width=\"700\">");
                  rs = stmt.executeQuery("SELECT DISTINCTROW * FROM "+st+" where type='var' order by queno");
                  while(rs.next() ) {
                                            qv1 = rs.getInt("queno");
                                            av1 = rs.getString("ans");
                                            rs1=stmt1.executeQuery("select * from "+sub+std+"v where queno="+qv1+";");
                                            rs1.next();
                                            rn=rs1.getInt("rightno");
                                            wn=rs1.getInt("wrongno");
                                            int rnb=0;
                                            rnb=rn;
                                            fon=rs1.getString("fname");
                                            quev=rs1.getString("que");
                                                String ra1 = rs1.getString("right1");
                                                String ra2 = rs1.getString("right2");
                                                String ra3 = rs1.getString("right3");
                                                String ra4 = rs1.getString("right4");
                                                String ra5 = rs1.getString("right5");
                                                String ra6 = rs1.getString("right6");
                                                String ra7 = rs1.getString("right7");
                                                String ra8 = rs1.getString("right8");
                                                String ra9 = rs1.getString("right9");
                                                String ra10 = rs1.getString("right10");
                                                String ra11 = rs1.getString("right11");
                                                String ra12 = rs1.getString("right12");
                                                String ra13 = rs1.getString("right13");
                                                String ra14 = rs1.getString("right14");
                                                String ra15 = rs1.getString("right15");
                                                String ra16 = rs1.getString("right16");
                                                String ra17 = rs1.getString("right17");
                                                String ra18 = rs1.getString("right18");
                                                String ra19 = rs1.getString("right19");
                                                String ra20 = rs1.getString("right20");
                                                String wa1 = rs1.getString("wrong1");
                                                String wa2 = rs1.getString("wrong2");
                                                String wa3 = rs1.getString("wrong3");
                                                String wa4 = rs1.getString("wrong4");
                                                String wa5 = rs1.getString("wrong5");
                                                String wa6 = rs1.getString("wrong6");
                                                String wa7 = rs1.getString("wrong7");
                                                String wa8 = rs1.getString("wrong8");
                                                String wa9 = rs1.getString("wrong9");
                                                String wa10 = rs1.getString("wrong10");
                                                String wa11 = rs1.getString("wrong11");
                                                String wa12 = rs1.getString("wrong12");
                                                String wa13 = rs1.getString("wrong13");
                                                String wa14 = rs1.getString("wrong14");
                                                String wa15 = rs1.getString("wrong15");
                                                String wa16 = rs1.getString("wrong16");
                                                String wa17 = rs1.getString("wrong17");
                                                String wa18 = rs1.getString("wrong18");
                                                String wa19 = rs1.getString("wrong19");
                                                String wa20 = rs1.getString("wrong20");
                                                out.println("<tr><td><strong><font face=\"arial\">("+varqno+")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>");
                                                out.println("<font face = \""+fon+"\">"+quev+"</strong></font></td></tr>");
                                                out.println("<tr><td><strong><b><font face=\"Times New Roman\" >Right Answer(s) That Student Has Selected </font></b></strong></td></tr>");
                                                varqno++;
                                                rn=rn*4-1;
                                               anl=av1.length();
                                              if(anl < rn)
                                              {
                                              rn=anl;
                                             }
                                            av2=av1.substring(0,rn);
                                            pos1=av2.indexOf('V');
                                            while(pos1 >= 0)
                                             {
                                              tvar++;
                                           //   pos1=pos1+1;
                                              rs2=stmt2.executeQuery("select * from "+sub+std+"v where queno="+qv1+";");
                                              rs2.next();
                                              String rightv=null;
                                              String rano=av2.substring(pos1+1,pos1+3);
                                        //t      out.println("<tr><td>no="+rano+"</td></tr>");
                                              if(rano.equals("01")){ colno=6;rightv=rs2.getString(6);}
                                              if(rano.equals("02")){ colno=7;rightv=rs2.getString(7);}
                                              if(rano.equals("03")){ colno=8;rightv=rs2.getString(8);}
                                              if(rano.equals("04")){ colno=9;rightv=rs2.getString(9);}
                                              if(rano.equals("05")){ colno=10;rightv=rs2.getString(10);}
                                              if(rano.equals("06")){ colno=11;rightv=rs2.getString(11);}
                                              if(rano.equals("07")){ colno=12;rightv=rs2.getString(12);}
                                              if(rano.equals("08")){ colno=13;rightv=rs2.getString(13);}
                                              if(rano.equals("09")){ colno=14;rightv=rs2.getString(14);}
                                              if(rano.equals("10")){ colno=15;rightv=rs2.getString(15);}
                                              if(rano.equals("11")){ colno=16;rightv=rs2.getString(16);}
                                              if(rano.equals("12")){ colno=17;rightv=rs2.getString(17);}
                                              if(rano.equals("13")){ colno=18;rightv=rs2.getString(18);}
                                              if(rano.equals("14")){ colno=19;rightv=rs2.getString(19);}
                                              if(rano.equals("15")){ colno=20;rightv=rs2.getString(20);}
                                              if(rano.equals("16")){ colno=21;rightv=rs2.getString(21);}
                                              if(rano.equals("17")){ colno=22;rightv=rs2.getString(22);}
                                              if(rano.equals("18")){ colno=23;rightv=rs2.getString(23);}
                                              if(rano.equals("19")){ colno=24;rightv=rs2.getString(24);}
                                              if(rano.equals("20")){ colno=25;rightv=rs2.getString(25);}
                                              if(rano.equals("21")){ colno=26;rightv=rs2.getString(26);}
                                              if(rano.equals("22")){ colno=27;rightv=rs2.getString(27);}
                                              if(rano.equals("23")){ colno=28;rightv=rs2.getString(28);}
                                              if(rano.equals("24")){ colno=29;rightv=rs2.getString(29);}
                                              if(rano.equals("25")){ colno=30;rightv=rs2.getString(30);}
                                              if(rano.equals("26")){ colno=31;rightv=rs2.getString(31);}
                                              if(rano.equals("27")){ colno=32;rightv=rs2.getString(32);}
                                              if(rano.equals("28")){ colno=33;rightv=rs2.getString(33);}
                                              if(rano.equals("29")){ colno=34;rightv=rs2.getString(34);}
                                              if(rano.equals("30")){ colno=35;rightv=rs2.getString(35);}
                                              if(rano.equals("31")){ colno=36;rightv=rs2.getString(36);}
                                              if(rano.equals("32")){ colno=37;rightv=rs2.getString(37);}
                                              if(rano.equals("33")){ colno=38;rightv=rs2.getString(38);}
                                              if(rano.equals("34")){ colno=39;rightv=rs2.getString(39);}
                                              if(rano.equals("35")){ colno=40;rightv=rs2.getString(40);}
                                              if(rano.equals("36")){ colno=41;rightv=rs2.getString(41);}
                                              if(rano.equals("37")){ colno=42;rightv=rs2.getString(42);}
                                              if(rano.equals("38")){ colno=43;rightv=rs2.getString(43);}
                                              if(rano.equals("39")){ colno=45;rightv=rs2.getString(44);}
                                              if(rano.equals("40")){ colno=46;rightv=rs2.getString(45);}
                                              out.println("<tr><td><font face = \""+fon+"\">"+rightv+"</strong></font></td></tr>");
                                              pos1=av2.indexOf('V',pos1+1);
                                              }
                                             out.println("<tr><td><strong><b><font face=\"Times New Roman\" >Right Answer(s)</font></b></strong></td></tr>");
                                             for(int trl=1;trl <= rnb;trl++)
                                                {
                                                  if(trl==1){truean=ra1;}
                                                  if(trl==2){truean=ra2;}
                                                  if(trl==3){truean=ra3;}
                                                  if(trl==4){truean=ra4;}
                                                  if(trl==5){truean=ra5;}
                                                  if(trl==6){truean=ra6;}
                                                  if(trl==7){truean=ra7;}
                                                  if(trl==8){truean=ra8;}
                                                  if(trl==9){truean=ra9;}
                                                  if(trl==10){truean=ra10;}
                                                  if(trl==11){truean=ra11;}
                                                  if(trl==12){truean=ra12;}
                                                  if(trl==13){truean=ra13;}
                                                  if(trl==14){truean=ra14;}
                                                  if(trl==15){truean=ra15;}
                                                  if(trl==16){truean=ra16;}
                                                  if(trl==17){truean=ra17;}
                                                  if(trl==18){truean=ra18;}
                                                  if(trl==19){truean=ra19;}
                                                  if(trl==20){truean=ra20;}
                                                  out.println("<tr><td><font face = \""+fon+"\">"+truean+"</strong></font></td></tr>");
                                                }
                                    }
                                    out.println("</table></center>");
            } 
                                              //      stmt.executeUpdate("drop table "+st+"");
                                              //      stmt.executeUpdate("delete * from biodata where rollno="+rollno+" and std="+std+" and subject='"+sub+"' and class='"+cl+"'");
                                    
                                       if(dupres==1)
                                        {
                                       stmt.executeUpdate("insert into subresult values("+std+",'"+cl+"','"+sub+"',"+rollno+",'"+name1+"',"+tt1+","+tt2+","+stutime+","+taka+",'"+date1+"/"+month1+"/"+year1+"')");
                                       stmt.executeUpdate("insert into genresult values("+std+",'"+cl+"','"+sub+"',"+rollno+",'"+name1+"',"+tt1+","+tt2+","+stutime+","+taka+","+date1+","+month1+")");
                                        }
      out.println("<br><br>");
      out.println("<center><table border=\"0\" width=\"500\">");
      out.println("<tr><td><center><font face=\"Times New Roman\" size=\"5\" >Sign Of Parent</font></center></font></td><th width=\"200\"></th><td><font face=\"Times New Roman\" size=\"5\" >Sign Of Teacher</font></td></tr>");
      out.println("</table></center>");
//System.out.print(""+request.getRemoteHost()+"-");
//System.out.println(""+name1+",No="+rollno+",Class="+cl+",std="+std+",Total="+tt1+",Obtain="+tt2+","+taka+"%,"+grade1+",Sub="+sub+",Date="+d1+"");
System.out.println(""+std+","+cl+","+sub+","+rollno+","+name1+","+tt1+","+tt2+","+stutime+","+taka+","+date1+","+month1+"");
     }
      catch (Exception e)            {
                                      out.println("could not connect ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
                                       }
        finally {
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
       out.println("<center>");
       out.println("<a href=\"http://"+request.getServerName()+":8080/servlet/EduHit\" target =\"_parent\">");
       out.println("<strong><font face=\"Times New Roman\" size=\"4\">Home</font></strong>");
       out.println("</a>");
       out.println("</center>");
       out.println("<br>");

       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(234,233,243)\">Developed By...</font></center>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(234,233,243)\">Hiteshkumar T. Shekhada</font></center>");
       out.println("<center><font face=\"Times New Roman\" size=2 color=\"rgb(234,233,243)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-2676644</font></center>");
      out.println("</body>");
      out.println("</html>");
    }
}

