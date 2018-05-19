import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.math.*;


public class Bioentry1 extends HttpServlet
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
      f7 = request.getParameter("n2");
      f8 = request.getParameter("n3");
      f9 = request.getParameter("n4");
      f10 = request.getParameter("n5");
      f11 = request.getParameter("n6");
      f12 = request.getParameter("n7");
      f13 = request.getParameter("n8");
      f14 = request.getParameter("n9");
      f15 = request.getParameter("n10");
      f16 = request.getParameter("n11");
      f17 = request.getParameter("n12");
      f18 = request.getParameter("n13");
      f19 = request.getParameter("n14");
      f20 = request.getParameter("n15");
      f21 = request.getParameter("n16");
      f22 = request.getParameter("n17");
      f23 = request.getParameter("n18");
      f24 = request.getParameter("n19");
      f25 = request.getParameter("n20");
      f26 = request.getParameter("n21");
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
      Statement stmt=null;
      ResultSet rs=null;
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:hitesh");
                 stmt = con.createStatement();

               //  if(f1!=null && f2!=null && f6!=null && f24!=null)
              //     {

                    String memid=f25;

                
                //    out.println(f2);
               
                 //   stmt.executeUpdate("update appform set   receiptno= "+f1+"    where  memberid='"+f2+"';");
               
                 //   stmt.executeUpdate("update appform set   memberid ='"+f2+"'  where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    appdtd="+f3+"    where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set   appdtm ="+f4+"    where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    appdty="+f5+"    where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set   appname ='"+f6+"'  where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set   address ='"+f7+"'  where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set   place ='"+f8+"'  where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set   state ='"+f9+"'  where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set   pinno ="+f10+"   where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set   email ='"+f11+"' where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set   pho ="+f12+"   where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    phr="+f13+"   where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    mobile="+f14+"   where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    contper='"+f15+"' where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    designation='"+f16+"' where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    appage="+f17+"   where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    sex='"+f18+"' where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    appbod='"+f19+"' where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    nominame='"+f20+"' where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    relation='"+f21+"' where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    nomiage="+f22+"   where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    nomibod='"+f23+"' where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    introname='"+f24+"' where  memberid='"+f2+"';");
                   // stmt.executeUpdate("update appform set    introid='"+f25+"' where  memberid='"+f2+"';");
                    stmt.executeUpdate("update appform set    agentname='"+f26+"' where  memberid='"+f2+"';");
                   // stmt.executeUpdate("update appform set    agentid='"+f27+"' where  memberid='"+f2+"';");

                    
                    con.commit();
        
                    
              //     }


       out.println("<center><font face=\"Times New Roman\" size=5 color=\"RGB(255,0,0)\">Your Information Is Inserted...</font></center>");  

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



