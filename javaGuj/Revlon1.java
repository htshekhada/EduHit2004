import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.lang.Math.*;
public class Revlon1 extends HttpServlet
{  static int expcnt=0;
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
//      response.setContentType("text/raw-html");
      PrintWriter out=response.getWriter();
      if(expcnt >= 4 )
        { response.sendRedirect("/servlet/Democom");
          return; }
      expcnt=expcnt+1;
      int i=0,a,p,j=0,flag1=0;
      int state=0,state1=0,qno=1,cc2=0,cc3=0,cc4=0,h1=0,m1=0,ch=0,ce=0,ce1=0,ce2=0,ce3=0;
      int hhtt=0,sq1=0,jj=0,x1=0;
      String sub,st=null,qn1,ans=null,chk,hv2,hv3,cl,rollno,std,fon,opt1,temp=null,bcheck1=null; 
      String no1="a",lno=null;
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
           if(state==0 && state1==0)
             {
                  Enumeration  eParmNames =request.getParameterNames();
                  while(eParmNames.hasMoreElements())
                              {
                                String name=(String) eParmNames.nextElement();
                                String value=request.getParameter(name);
                                if(name.equals("r1"))
                                                 {
                                                   rs = stmt.executeQuery("SELECT chap AS cp FROM "+sub+std+"l where queno="+qn1+"");
                                                   rs.next();
                                                   ch=rs.getInt("cp");
                                                   if(!value.equals("V1"))
                                                   {
                                                     flag1=1;
                                                   }
                                   /*                if(value.equals("V1"))
                                                   {
                                                   stmt = con.createStatement();
                                                   stmt.executeUpdate("insert into "+st+" values ("+qn1+",'"+value+"',"+ch+",'opt') " ); 
                                                   con.commit();
                                                   con.commit();
                                                   }
                                   */
                                                  }
                              }
              }
out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Revlon1\">");
int count3=1;
/*
char ch1[]=no1.toCharArray();
char ch2[]=null;
if(flag1!=1)
{
for(int j1=0;j1<i;j1++)
{
ch2[j1]=ch1[j1];
}
no1=new String(ch2);
}
*/
i=no1.length();
if(flag1==1)
{
i--;
}
     rs = stmt.executeQuery("select count(*) as totque from "+sub+std+"l where chap="+lno+" and quefield='lon'");
     rs.next();
     int count4=rs.getInt("totque");
     rs = stmt.executeQuery("select * from "+sub+std+"l where chap="+lno+" and quefield='lon' order by queno");
     while(rs.next()) {
                                int c1 = rs.getInt("queno");
                                String c2 = rs.getString("que");
                                String c3 = rs.getString("right1");
                                String c4 = rs.getString("wrong1");
                                String c5 = rs.getString("wrong2");
                                if(i==count3)
                                  {
                                 rs = stmt.executeQuery("select quetype as fn from "+sub+std+"l where queno="+c1+" and quefield='lon'");
                                 rs.next();
                                 String exmmsg=rs.getString("fn");
                                 rs1 = stmt1.executeQuery("select fname as fn from "+sub+std+"l where quefield='lon' and queno="+c1+" ");
                                 rs1.next();
                                 fon=rs1.getString("fn");
                                out.println("<div align=\"center\"><center>");                            //rgb(255,183,111)     cmyk(0,0,80,0)    rgb(212,236,225)
                                out.println("<table border=\"1\" width=\"550\" bordercolor=\"rgb(0,173,105)\">");
                                out.println(" <tr>");
                                if(flag1==1)
                                {
                                out.println("<th><font face=\"Lmg-Arun Condensed\" color=\"red\" size=5>BM8]</font></th>");
                                }
                                out.println(" <th width=\"\" height=\"\" nowrap>");
                                out.println("<font color=\"#0000FF\"size=\"4\">")  ;
                                out.println("<font face=\""+fon+"\"> "+exmmsg+"</font>");
                                out.println("</font>");  
                                out.println("</th>");
                                if(flag1==1)
                                {
                                out.println("<th><font face=\"Lmg-Arun Condensed\" color=\"red\" size=5>BM8]</font></th>");
                                }
                                out.println(" </tr></table></center></div>");
                                         j = r2.nextInt(6);
                                         j=j+1;
                                         int k=(int)j;
                                         rs1 = stmt1.executeQuery("select fname as fn from "+sub+std+"l where quefield='lon' and queno="+c1+" ");
                                         rs1.next();
                                        fon=rs1.getString("fn");
                                        out.println("<center>");
                                        out.println("<table border=\"1\" bordercolor=\"rgb(0,173,105)\">");
                                        out.println(" <tr>");
                                    //    out.println("  <td width=\"750\">");
                                 //       out.println("<th><b><font face=\"Arial\" size=\"4\">("+i+")</th></tr><tr><td><pre></font><font face=\""+fon+"\" size=\"5\">"+c2+"</font></pre>");
                                        out.println("<th><b><font face=\"Arial\" size=\"4\">("+i+")</th></tr><tr><td></font><textarea rows=\"5\" name=\"question\" cols=\"65\" style=\"font-family : "+fon+";font-size:15pt\" >"+c2+"</textarea>");
                                        out.println("</td> </tr>");
                                        out.println("</table></center>");                       
                                        out.println("<center>");
                                        out.println("<table border=\"1\" bordercolor=\"rgb(0,173,105)\">");  
                                      // out.println("<font face=\""+fon+"\" size=\"8\">");
                                switch(k) {
                                      case 1:  
                                               if(flag1==1)
                                                 {
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(133,213,135)\" bordercolor=\"red\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V1\" checked   name=\"r1\"> ");
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c3+"</font></pre>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c3+"</textarea>");
                                               out.println("</td>  </tr>");
                                                 }
                                               else
                                                {
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V1\" checked   name=\"r1\"> ");
                                             //  out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c3+"</font></pre>");
                                                out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c3+"</textarea>");
                                               out.println("</td>  </tr>");
                                                }
                                              // out.println(" <tr><td width=\"750\" height=\"\"></td> </tr>");
                                               out.println("<tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V2\"   name=\"r1\"> ");
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c4+"</font></pre>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c4+"</textarea>");
                                               out.println("</td>  </tr>");
                                            // out.println("<tr> <td width=\"600\" height=\"22\"></td> </tr>");
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V3\"    name=\"r1\"> "); 
                                           //    out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c5+"</font></pre></b>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c5+"</textarea>");
                                               out.println("</td> ");
                                          //   out.println(" <tr><td width=\"600\" height=\"19\"></td> </tr>");
                                               out.println("</table></center></div>");
                                               out.println("<br><center><input type=\"radio\" value=\"V5\" checked   name=\"r1\"></center> ");
                                               break;
                                      case 2:
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V3\" checked   name=\"r1\"> ");
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c5+"</font></pre>");            
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c5+"</textarea>");
                                               out.println("</td>  </tr>");
                                              // out.println(" <tr><td width=\"750\" height=\"\"></td> </tr>");
                                               out.println("<tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V2\"   name=\"r1\"> ");
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c4+"</font></pre>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c4+"</textarea>");
                                               out.println("</td>  </tr>");
                                              // out.println("<tr> <td width=\"600\" height=\"22\"></td> </tr>");
                                               if(flag1==1)
                                               {
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(133,213,135)\" bordercolor=\"red\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V1\"    name=\"r1\"> ");
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c3+"</font></pre></b>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c3+"</textarea>");
                                               out.println("</td> ");
                                               }
                                               else
                                               {
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V1\"    name=\"r1\"> ");
                                           //    out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c3+"</font></pre></b>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c3+"</textarea>");
                                               out.println("</td> ");
                                               }
                                           //    out.println(" <tr><td width=\"600\" height=\"19\"></td> </tr>");
                                               out.println("</table></center></div>");
                                               out.println("<br><center><input type=\"radio\" value=\"V5\" checked   name=\"r1\"></center> ");
                                               break;
                                      case 3:
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V2\" checked   name=\"r1\"> ");
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c4+"</font></pre>");            
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c4+"</textarea>");
                                               out.println("</td>  </tr>");
                                              // out.println(" <tr><td width=\"600\" height=\"19\"></td> </tr>");
                                               out.println("<tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V3\"   name=\"r1\"> ");
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c5+"</font></pre>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c5+"</textarea>");
                                               out.println("</td>  </tr>");
                                             //  out.println("<tr> <td width=\"600\" height=\"22\"></td> </tr>");
                                               if(flag1==1)
                                               {
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(133,213,135)\" bordercolor=\"red\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V1\"    name=\"r1\"> "); 
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c3+"</font></pre></b>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c3+"</textarea>");
                                               out.println("</td> ");
                                               }
                                               else
                                               {
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V1\"    name=\"r1\"> "); 
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c3+"</font></pre></b>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c3+"</textarea>");
                                               out.println("</td> ");
                                               }
                                             //  out.println(" <tr><td width=\"600\" height=\"19\"></td> </tr>");
                                               out.println("</table></center></div>");
                                               out.println("<br><center><input type=\"radio\" value=\"V5\" checked   name=\"r1\"></center> ");
                                               break;
                                      case 4:  
                                               if(flag1==1)
                                               {
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(133,213,135)\" bordercolor=\"red\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V1\" checked   name=\"r1\"> ");
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c3+"</font></pre>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c3+"</textarea>");
                                               out.println("</td>  </tr>");
                                               }
                                               else
                                               {
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V1\" checked   name=\"r1\"> ");
                                           //    out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c3+"</font></pre>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c3+"</textarea>");
                                               out.println("</td>  </tr>");
                                               }
                                             //  out.println(" <tr><td width=\"600\" height=\"19\"></td> </tr>");
                                               out.println("<tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V3\"   name=\"r1\"> ");
                                             //  out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c5+"</font></pre>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c5+"</textarea>");
                                               out.println("</td>  </tr>");
                                              // out.println("<tr> <td width=\"600\" height=\"22\"></td> </tr>");
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V2\"    name=\"r1\"> "); 
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c4+"</font></pre></b>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c4+"</textarea>");
                                               out.println("</td> ");
                                            //   out.println(" <tr><td width=\"600\" height=\"19\"></td> </tr>");
                                               out.println("</table></center></div>");
                                               out.println("<br><center><input type=\"radio\" value=\"V5\" checked   name=\"r1\"></center> ");
                                               break;
                                      case 5:  
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V2\" checked   name=\"r1\"> ");
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c4+"</font></pre>");            
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c4+"</textarea>");
                                               out.println("</td>  </tr>");
                                             // out.println(" <tr><td width=\"600\" height=\"19\"></td> </tr>");
                                               if(flag1==1)
                                               {
                                               out.println("<tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(133,213,135)\" bordercolor=\"red\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V1\"   name=\"r1\"> ");
                                           //    out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c3+"</font></pre>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c3+"</textarea>");
                                               out.println("</td>  </tr>");
                                               }
                                               else
                                               {
                                               out.println("<tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V1\"   name=\"r1\"> ");
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c3+"</font></pre>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c3+"</textarea>");
                                               out.println("</td>  </tr>");
                                               }
                                            //   out.println("<tr> <td width=\"600\" height=\"22\"></td> </tr>");
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V3\"    name=\"r1\"> "); 
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c5+"</font></pre></b>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c5+"</textarea>");
                                               out.println("</td> ");
                                            //   out.println(" <tr><td width=\"600\" height=\"19\"></td> </tr>");
                                               out.println("</table></center></div>");
                                               out.println("<br><center><input type=\"radio\" value=\"V5\" checked   name=\"r1\"></center> ");
                                               break;
                                      case 6:  
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V3\" checked   name=\"r1\"> ");
                                           //    out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c5+"</font></pre>");            
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c5+"</textarea>");
                                               out.println("</td>  </tr>");
                                             //  out.println(" <tr><td width=\"600\" height=\"19\"></td> </tr>");
                                               out.println("<tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V2\"   name=\"r1\"> ");
                                          //     out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c4+"</font></pre>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c4+"</textarea>");
                                               out.println("</td>  </tr>");
                                             //  out.println("<tr> <td width=\"600\" height=\"22\"></td> </tr>");
                                               if(flag1==1)
                                               {
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(133,213,135)\" bordercolor=\"red\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V1\"    name=\"r1\"> "); 
                                           //    out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c3+"</font></pre></b>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c3+"</textarea>");
                                               out.println("</td> ");
                                               }
                                               else
                                               {
                                               out.println(" <tr> <td width=\"750\" height=\"\" style=\"background-color:rgb(211,255,213)\" bordercolor=\"rgb(133,213,135)\" align=\"center\">");
                                               out.println("<input type=\"radio\" value=\"V1\"    name=\"r1\"> "); 
                                            //   out.println("<pre><font face=\""+fon+"\" size=\"5\">"+c3+"</font></pre></b>");
                                               out.println("<textarea rows=\"5\" name=\"question\" cols=\"50\" style=\"font-family : "+fon+";font-size:15pt\" >"+c3+"</textarea>");
                                               out.println("</td>  ");
                                               }
                                           //    out.println(" <tr><td width=\"600\" height=\"19\"></td> </tr>");
                                               out.println("</table></center></div>");
                                               out.println("<br><center><input type=\"radio\" value=\"V5\" checked   name=\"r1\"></center> ");
                                               break;
                                               } 
                                 out.println("</font>");
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
                                 out.println("<center><input  type=\"submit\" value=\"GJM 5|`G\" name=\"next\" style=\"font-family: LMG-Arun Condensed; font-size: 18pt\"></center>");
                                 out.println("</form>");
                                  }
                                 count3++;
                                } 
                    if(i>count4)
                      {
                      out.println("<br><br><br><br><center><font face=\"Lmg-Arun Condensed\" size=5 color=\"blue\">5|`Gv# GF 5F9</font><font face=\"Times New Roman\" size=5>&nbsp;"+lno+"&nbsp;</font><font face=\"Lmg-Arun Condensed\" size=5 color=\"blue\">G] 5]GZFJT\"G 5]6\" Y. UI]</font></center>");
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

