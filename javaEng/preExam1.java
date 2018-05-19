import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.lang.Math.*;
public class preExam1 extends HttpServlet
{  static int expcnt=0;
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
   //   response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      if(expcnt >= 4 )
        { response.sendRedirect("/servlet/Democom");
          return; }
      expcnt=expcnt+1;
      int i=0,a,p,j=0,chsrno=0,c1=0;
      int state=0,state1=0,qno=1,cc2=0,cc3=0,cc4=0,h1=0,m1=0,ch=0,ce=0,ce1=0,ce2=0,ce3=0;
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
      out.println("<title>["+rollno+"]-["+std+"]-["+cl+"]-["+sub+"]-EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");    
      out.println("<body bgcolor=\"rgb(211,255,213)\">");
      st=rollno+std+cl+sub;
      temp=rollno+std+cl+sub+"opt";
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
                   //t     out.println("time::"+cc4+"");
                       //t           out.println("timeh1::"+h1+"");
                 int distime=cc4-h1;
                 int dissec=distime%60;
                 distime=distime-dissec;
                 int dismin=(distime/60)%60;
                 int dishour=(distime-(dismin*60))/3600;
                 if(dissec<0)
                   {
                   out.println("<b><marquee behavior=\"alternate\"><font face=\"Times New Roman\" size=\"6\" color=\"red\" >Your Time Is Finished,Push Following Button...</font></marquee></b>");
                   }
                 else
                   {
                    out.println("<p align =\"center\"><b> <font face=\"Times New Roman\" size=\"5\" color=\"red\" >Your Remaining Time</font><font face=\"Arial\" size=\"4\" color=\"blue\"> = "+dishour+"<font face=\"Times New Roman\" size=\"5\" color=\"red\" >  Hour </font> : "+dismin+"<font face=\"Times New Roman\" size=\"5\" color=\"red\" >  Minute    </font>:  "+dissec+"<font face=\"Times New Roman\" size=\"5\" color=\"red\" >  Second </font></font></b></p>");
                   }
int count9=0,quenum=0,maxst=0;
rs = stmt.executeQuery("select *  from "+st+" where type='sho'");
while(rs.next())
{
     count9++;
     if(count9 == (number1-1))
        {
         quenum=rs.getInt("queno");
        }
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
                                               //    rs = stmt.executeQuery("SELECT chap AS cp FROM "+sub+std+" where queno="+qn1+"");
                                               //    rs.next();
                                               //    ch=rs.getInt("cp");
                                          //t         out.println(value);
                                                        rs1 = stmt1.executeQuery("select ans from "+st+" where queno="+quenum+" and type='sho'");
                                                        rs1.next(); 
                                                        String def1 = rs1.getString("ans");
                                            //         out.println(1);
                                                         if(def1.equals("hitesh"))
                                                         {
                                                   stmt = con.createStatement();
                                                   stmt.executeUpdate("update "+st+" set ans='"+value+"' where queno="+quenum+" and type='sho'"); 
                                                          }
                                           //        out.println(2);
                                                   con.commit();
                                                   con.commit();
                                                  }
                              }
              }
rs = stmt.executeQuery("select count(*) as cn from "+st+" where type='sho' ");
rs.next();
maxst=rs.getInt("cn");
if(number1 > maxst || dissec < 0 || number1 > 3)
{
    out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Kasoti1\">");
    out.println("<INPUT TYPE=\"hidden\" NAME= \"subj\" VALUE=\""+sub+"\">");
    out.println("<INPUT TYPE=\"hidden\" NAME= \"roll\" VALUE=\""+rollno+"\">");
    out.println("<INPUT TYPE=\"hidden\" NAME= \"stad\" VALUE=\""+std+"\">"); 
    out.println("<INPUT TYPE=\"hidden\" NAME= \"clas\" VALUE=\""+cl+"\">");
//    out.println("<b><font face=\"Arial\">");
    out.println("<br><br><br><br><center><font face=\"Times New Roman\" size=\"7\" color=\"blue\" >Exam Of Question-2 Complete.</font></center>");
    out.println("<center><font face=\"Times New Roman\" size=\"7\" color=\"blue\" > Now Push Following Button</font></center>");
    out.println("<br><br><center><input  type=\"submit\" value=\"Question's List\" name=\"com\" style=\"font-family: Times New Roman; font-size: 18pt\"></center><br>");
//    out.println("</font></b>");
    out.println("</form>");
    stmt.executeUpdate("UPDATE biodata SET short1 ='B' WHERE rollno = "+rollno+" and std = "+std+" and class = '"+cl+"' and subject = '"+sub+"';");
    state=1;
    state1=1;
}
count9=0;
if(state==0 && state1==0)
{
rs = stmt.executeQuery("select *  from "+st+" where type='sho'");
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
out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/preExam1\">");
if(state==0 && state1==0){                     
                 rs = stmt.executeQuery("select quetype as fn from "+sub+std+" where queno="+i+" and quefield='sho'");
                 rs.next();
                 String exmmsg=rs.getString("fn");
                 rs1 = stmt1.executeQuery("select fname as fn from "+sub+std+" where quefield='sho' and queno="+i+" ");
                 rs1.next();
                 fon=rs1.getString("fn");
              //   out.println("<font face=\""+fon+"\" size=\"20\">");
                out.println("<div align=\"center\"><center>");
                 rs = stmt.executeQuery("select * from "+sub+std+" where quefield='sho' and queno="+i+" ");
                 rs.next();
                                c1 = rs.getInt("queno");
                                String c2 = rs.getString("que");
                                        out.println("<table border=\"0\" width=\"300\" height=\"40\" style=bordercolor=\"rgb(0,173,105)\">");
                                        out.println(" <tr>");
                                        out.println(" <th width=\"\" height=\"40\" nowrap>");
                                        out.println("<font color=\"blue\"size=\"5\">")  ;
                                        out.println("<font face=\""+fon+"\"> "+exmmsg+"</font>");
                                        out.println("</font>");  
                                        out.println("</th>");
                                        out.println(" </tr></table></center></div>");
                                        out.println("<center><table border=\"0\" bordercolor=\"blue\">");
                                        out.println(" <tr>");
                                        out.println("  <td width=\"750\" height=\"40\" >");                      // colspan=\"2\" >");
                                        out.println("<b><center><font face=\"Arial\" size=\"5\">("+number1+")</font><font face=\""+fon+"\" size=\"6\">"+c2+"</font></center>");
                                        out.println("</td> </tr> <tr>");
                                        out.println("</tr>");
                                        out.println(" <tr> <td>");
                                       // out.println("<br>");
                                        out.println("<center><input type=\"text\" name=\"r1\" size=\"30\" maxlength=\"255\" style=\"font-family:Times New Roman;font-size:15pt\"></center>");
                                        out.println("</td></tr>");
                                        out.println("</td>  </tr></table></center></div>");
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"qqn\" VALUE=\""+c1+"\">");
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"subj\" VALUE=\""+sub+"\">"); 
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"roll\" VALUE=\""+rollno+"\">");
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"stad\" VALUE=\""+std+"\">"); 
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"clas\" VALUE=\""+cl+"\">"); 
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"num\" VALUE=\""+no1+1+"\">");
                                 out.println("<INPUT TYPE=\"hidden\" NAME= \"bcheck\" VALUE=\"no\">"); 
                                 out.println("<br><center><input  type=\"submit\" value=\"Next Question\" name=\"next\" style=\"font-family: Times New Roman; font-size: 18pt\"></center>");
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

