import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.math.*;


public class form extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>AnamicaHIT by H.T.Shekhada</title>");

      String f1="0",f2="0",f3="0",f4="0",f5="0",f6="0",f7="0",f8="0",f9="0",f10="0",f11="0",f12="0",f13="0",f14="0",f15="0",f16="0",f17="0",f18="0",f19="0",f20="0",f21="0",f22="0",f23="0",f24="0",f25="0",f26="0",f27="0";

      f1 = request.getParameter("nn1");
      f2 = request.getParameter("nn2");
      f3 = request.getParameter("nn3");
      f4 = request.getParameter("nn4");
      f5 = request.getParameter("nn5");
      f6 = request.getParameter("n1");
//      f7 = request.getParameter("n2");
      f8 = request.getParameter("n3");
//      f9 = request.getParameter("n4");
//      f10 = request.getParameter("n5");
//      f11 = request.getParameter("n6");
//      f12 = request.getParameter("n7");
//      f13 = request.getParameter("n8");
//      f14 = request.getParameter("n9");
//      f15 = request.getParameter("n10");
//      f16 = request.getParameter("n11");
//      f17 = request.getParameter("n12");
//      f18 = request.getParameter("n13");
//      f19 = request.getParameter("n14");
//      f20 = request.getParameter("n15");
//      f21 = request.getParameter("n16");
//      f22 = request.getParameter("n17");
//      f23 = request.getParameter("n18");
//      f24 = request.getParameter("n19");
      f25 = request.getParameter("n20");
//      f26 = request.getParameter("n21");
      f27 = request.getParameter("n22");



      int m1=0;
      java.util.Date d1;
      d1=new java.util.Date();
      m1=d1.getMonth();




out.println("</head>");



    //  out.println("<body background=\"c:/jsdk2.0/examples/image4.gif\">");
    //  out.println("<body bgcolor=\"rgb(254,255,225)\">");
      out.println("<body bgcolor=\"rgb(133,213,135)\">");



      out.println("<strong><marquee Behavior=\"Alternate\"><font face=\"Times New Roman\" size=\"4\" color=\"RED\">ANAMICA MARKETING</font></marquee></strong>");

      Connection con=null;
      Statement stmt=null,stmt1=null,stmt2=null;
      ResultSet rs=null,rs1=null,rs2=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:hitesh");
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();
                 stmt2 = con.createStatement();

                 if(f1!=null && f2!=null && f6!=null && f24!=null)
                   {

                    String memid=f25;
                  
                                       
                    f25 = introidserch(memid,0);

                    rs=stmt.executeQuery("select min(lvl) as cc1 from leveltemp ;");
                    rs.next();
                    int minlvl = rs.getInt("cc1");

                   

                    rs=stmt.executeQuery("select min(num) as cc2 from leveltemp where lvl = "+minlvl+";");
                    rs.next();
                    int minno = rs.getInt("cc2");

                  
                   
                    rs=stmt.executeQuery("select memid as cc3 from leveltemp where num="+minno+";");
                    rs.next();
                    String finalmid=rs.getString("cc3");

                    out.println(finalmid);

                    f25 = finalmid;
                    stmt.executeUpdate("insert into appform values("+f1+",'"+f2+"',"+f3+","+f4+","+f5+",'"+f6+"','"+f7+"','"+f8+"','"+f9+"',"+f10+",'"+f11+"',"+f12+","+f13+","+f14+",'"+f15+"','"+f16+"',"+f17+",'"+f18+"','"+f19+"','"+f20+"','"+f21+"',"+f22+",'"+f23+"','"+f24+"','"+f25+"','"+f26+"','"+f27+"')");
                    con.commit();

                    int coun=0;
                    rs=stmt.executeQuery("select * from leveltemp where lvl <= 1;");
                    if(!rs.next())
                    {
                     rs1=stmt1.executeQuery("select count(*) as cc3 from round2;");
                     if(rs1.next())
                         {
                          coun=rs1.getInt("cc3");
                         }
                     coun++;

                     
                     rs1=stmt1.executeQuery("select * from round2 where memberid='"+memid+"';");
                     if(!rs1.next())
                        stmt2.executeUpdate("insert into round2 values("+coun+",'"+memid+"')");
                     else
                        {
                         rs1=stmt1.executeQuery("select * from round2 where memberid='"+memid+"';");
                         rs1.next();
                         int num1=rs1.getInt("num");

                         rs1=stmt1.executeQuery("select count(*) as cont from round2 where num > "+num1+";");
                         rs1.next();
                         int finalcount=rs1.getInt("cont");
                         if(finalcount >= 39)
                           {
                            rs1=stmt1.executeQuery("select count(*) as cc3 from round3;");
                            if(rs1.next())
                              {
                               coun=rs1.getInt("cc3");
                              }
                            coun++;

                            rs1=stmt1.executeQuery("select * from round3 where memberid='"+memid+"';");
                            if(!rs1.next())
                               stmt2.executeUpdate("insert into round3 values("+coun+",'"+memid+"')");

                           }
                        }
                    }

                    stmt.executeUpdate("delete * from leveltemp;");
                    con.commit();



                   }


      out.println("<center>");
                                  

//      out.println("</table>");
      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");
      

      out.println("<form name=\"isn\" method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/form\">");

      
      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");

      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Receipt No.</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"nn1\" size=\"15\" style=\"font-family:Times New Roman;font-size:20\"></strong></th>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Member ID.No</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"nn2\" size=\"15\" style=\"font-family:Times New Roman;font-size:20\"></strong></th>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Date</font></strong></th>");
      out.println("<th><p align=\"left\"><select  name=\"nn3\" size=\"1\" style=\"font-family:Times New Roman;font-size:\" >");
      for(int i=1;i<=31;i++)
       {
         out.println("<option value="+i+">"+i+"</option>");
       }
      out.println("</select>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Month</font></strong></th>");
      out.println("<th><p align=\"left\"><select  name=\"nn4\" size=\"1\" style=\"font-family:Times New Roman;font-size:\" >");
      m1++;
      if(m1==13)
               m1=1;

      out.println("<option value="+m1+">"+m1+"</option>");
      for(int i=1;i<=12;i++)
       {
         out.println("<option value="+i+">"+i+"</option>");
       }
      out.println("</select>");

      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Year</font></strong></th>");
      out.println("<th><p align=\"left\"><select  name=\"nn5\" size=\"1\" style=\"font-family:Times New Roman;font-size:\" >");
      for(int i=2002;i<=2099;i++)
       {
         out.println("<option value="+i+">"+i+"</option>");
       }
      out.println("</select></tr>");






      out.println("</table>");

      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");

      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Name Of Applicant</font></strong></th>");
      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n1\" size=\"30\" style=\"font-family:Times New Roman;font-size:20\"></strong></th>");

//      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Address</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n2\" size=\"30\" style=\"font-family:Times New Roman;font-size:\"></strong></th></tr>");

//      out.println("</tr></table>");
//      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");


      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Place</font></strong></th>");
      out.println("<th><p align=\"left\"><select  name=\"n3\" size=\"1\" style=\"font-family:Times New Roman;font-size:15\" >");
                
      rs = stmt.executeQuery("SELECT cityname AS c1 FROM city ;");
      while(rs.next() ) {
                                            
                          String st1 = rs.getString("c1");
                          out.println("<option value="+st1+">"+st1+"</option>");
                        }


     out.println(" </select> </strong></p></th>");
      

//      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">State</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n4\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

//      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Pin No</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n5\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

//      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">E-mail</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n6\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th></tr>");

      out.println("</tr></table>");
//      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");



//      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Cont.No(O)</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n7\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

//      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Cont.No(R)</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n8\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

//      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Mobile</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n9\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th></TR>");


//      out.println("</table>");
//      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");


//      out.println("<TR><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Contact Person</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n10\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

//      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Designation</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n11\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th></tr>");

//      out.println("</table>");
//      out.println("<table border=\"2\" width=\"750\" bordercolor=\"rgb(0,0,255)\">");



//      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Age</font></strong></th>");
//      out.println("<th><p align=\"left\"><input  name=\"n12\" size=\"1\" style=\"font-family:Times New Roman;font-size:\" >");

//      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Sex</font></strong></th>");
//      out.println("<th><p align=\"left\"><SELECT name=\"n13\" size=\"1\" style=\"font-family:Times New Roman;font-size:\">");
//      out.println("<option value=MALE>MALE</option>");
//      out.println("<option value=FEMALE>FEMALE</option></select>");


//      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">BirthDate</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n14\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th></tr>");


//      out.println("</table>");
      out.println("<br>");
//      out.println("<table border=\"1\" width=\"450\" bordercolor=\"rgb(0,0,255)\">");



//      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Nominee Name</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n15\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

//      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Relation</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n16\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th></tr>");

//      out.println("</table>");
//      out.println("<table border=\"1\" width=\"450\" bordercolor=\"rgb(0,0,255)\">");



//      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Age</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n17\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

//      out.println("<th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">BirthDate</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n18\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th></tr>");


//      out.println("</table>");
      out.println("<br>");
      out.println("<table border=\"1\" width=\"450\" bordercolor=\"rgb(0,0,255)\">");
      

  



//      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Introducer Name</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n19\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");

      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Int. ID</font></strong></th>");
      out.println("<th><p align=\"left\"><select  name=\"n20\" size=\"1\" style=\"font-family:Times New Roman;font-size:20\" >");

      out.println("<option value=am11>am11</option>"); //**by default
      rs = stmt.executeQuery("SELECT memberid AS c1 FROM appform ;");
      while(rs.next() ) {
                                            
                          String st1 = rs.getString("c1");
                          out.println("<option value="+st1+">"+st1+"</option>");
                        }


     out.println(" </select> </strong></p></th>");



//      out.println("</table>");
//      out.println("<table border=\"1\" width=\"450\" bordercolor=\"rgb(0,0,255)\">");


//      out.println("<tr><th> <p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Agent Name</font></strong></th>");
//      out.println("<th><p align=\"left\"><input type=\"text\" name=\"n21\" size=\"\" style=\"font-family:Times New Roman;font-size:\"></strong></th>");



//********************** <option value=\"computer\">computer</option>
      


     

                 out.println("<th><p align=\"left\"><strong><font face=\"Times New Roman\" size=\"\" color=\"\">Agent ID</font></p></th>");
                 out.println("<th><p align=\"left\"><select  name=\"n22\" size=\"1\" style=\"font-family:Times New Roman;font-size:20\" >");
                 
                 rs = stmt.executeQuery("SELECT agentid AS c1 FROM agent ;");
                 int nRows = 0;
                 while(rs.next() ) {
                                            
                                    String st1 = rs.getString("c1");
                                    out.println("<option value="+st1+">"+st1+"</option>");
                                   }


                 out.println(" </select> </strong></p></th></tr>");

     



      

      out.println("</table>");
      out.println("<br>");


      out.println("<br>");
      out.println("<p><input type=\"submit\" value=\"Submit\" name=\"submit\" >");
      out.println("&nbsp;&nbsp;&nbsp; <input type=\"reset\" value=\"Reset\" name=\"reset\"></p>");
      out.println("</form><br>");


       out.println("<center><a href=\"file://c:/anamica/anamica.htm\" >");
      out.println("<font face=\"Times New Roman\" size=5 color=\"RGB(0,0,255)\">Home</font>");  
       out.println("</a></center>");







       out.println("<br><br><br><br><br><center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">Developed By...</font></b></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">Hiteshkumar T. Shekhada</font></b></center>");
       out.println("<center><b><font face=\"Times New Roman\" size=2 color=\"RGB(255,0,0)\">18,Kailash Nagar,Timbavadi,Junagadh,Ph(R):091-0285-676644</font></b></center>");


      out.println("</body>");
      out.println("</html>");




             }
      catch (Exception e) {
                                      out.println("Please Enter valid Value");
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


this.destroy();
}





public String introidserch(String intid,int lvl)
  {
      Connection con=null;
      Statement stmt=null,stmt1=null;
      ResultSet rs=null,rs1=null;

      int flag=0,flag1=0;
      String memid=intid;
      String levelids[] = new String[2000];

      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:hitesh");
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();

                 rs = stmt.executeQuery("SELECT count(*) as cn  FROM appform where introid='"+intid+"' and memberid <> '"+intid+"';");
                 rs.next(); 
                 int dm = rs.getInt("cn");
                 if(dm < 3)
                   {
                     System.out.println(""+intid+"---"+lvl+"");
                     rs1=stmt1.executeQuery("select count(*) as cc from leveltemp;");
                     rs1.next();
                     int no1= rs1.getInt("cc");
                  //   no1++;
                     stmt1.executeUpdate("insert into leveltemp values("+no1+",'"+intid+"',"+lvl+")");
                     memid=intid;
                     flag=1;
                   }
             
                  rs = stmt.executeQuery("SELECT *  FROM appform where introid='"+intid+"' and memberid <> '"+intid+"';");
                  while(rs.next())
                     {
                                            

                          String mid = rs.getString("memberid");
                          String appname = rs.getString("appname");
                          String introid = rs.getString("introid");
                          String agentid = rs.getString("agentid");

                         /*
                          memid=search3id(mid);
                          if(!memid.equals("aa"))
                               {
                          //       continue hit;
                          //     }
                        //  else {
                          //      System.out.println("memid="+memid+"**level="+lvl+"<br>");
                                // flag1=1;
                                // break hit;
                               }
                          */

                          memid=introidserch(mid,lvl+1);


                     }

                        //        if((Math.pow(3,level)) < contlim)
                        //            memid=introidserch(memid,0,contlim,level);   
             
        }
      catch (Exception e) {
                                      System.out.println("Please enter all Required Value");
                                      System.out.println("<pre>");
                                      System.out.println(e.getMessage());
                                      System.out.println("</pre>");
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


    return memid;
  }





//************for counting 3 direct mem**********
/*

public String search3id(String intid)
  {
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;

      String memid="aa";


      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:hitesh");
                 stmt = con.createStatement();

                     
                 rs = stmt.executeQuery("SELECT count(*) as cn  FROM appform where introid='"+intid+"' and memberid <> '"+intid+"';");
                 rs.next(); 
                 int dm = rs.getInt("cn");

                 if(dm < 3)
                 {
             //      System.out.println(intid);
                   memid=intid;
                   
                 } 

                 
        }
      catch (Exception e) {
                                      System.out.println("Please enter all Required Value");
                                      System.out.println("<pre>");
                                      System.out.println(e.getMessage());
                                      System.out.println("</pre>");
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


    return memid;
  }

*/



}



