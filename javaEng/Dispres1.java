import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Dispres1 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      PrintWriter out=response.getWriter();

      String  std1=null,r1=null,c1=null,grade=null,n1=null;
      int total=0,got=0;
      int  sumtot=0,sumj=0;      

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
//      out.println("<body background=\"c:/EduHit/bg3.jpg\">");
      out.println("<body bgcolor=\"rgb(211,255,213)\">");
      out.println("<br><br>");
     

  
      Locale currentLocale=new Locale("fr","FR"); 
      java.util.Date today;
      String result;
      SimpleDateFormat formatter;

      formatter = new SimpleDateFormat("dd-MM-yy", currentLocale);
      today = new java.util.Date();
      result = formatter.format(today);


      Connection con=null;
      Statement stmt=null;
      Statement stmt1=null;
      Statement stmt2=null;
      ResultSet rs=null;
      ResultSet rs1=null;
      ResultSet rs2=null;

      String std2=null,c2=null,fd1=null,fm1=null,td1=null,tm1=null;
      std1=request.getParameter("std");
      c1=request.getParameter("class");
      fd1=request.getParameter("fdate");
      fm1=request.getParameter("fmonth");
      td1=request.getParameter("tdate");
      tm1=request.getParameter("tmonth");
      String e1="Exam";
      e1=request.getParameter("exmsg");
      String em=e1.replace('!',' ');

   //   String s2="Complete Result Upto This Day";



                          //\"rgb(133,213,135)\"

        try
           {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con = DriverManager.getConnection("jdbc:odbc:usda");
           stmt = con.createStatement();
           stmt2 = con.createStatement();

     /*
           int fd1=0,fm1=0,td1=0,tm1=0;
           rs.executeUpdate("delete * from temp;");
           rs.executeUpdate("insert into temp values("+fd+");");
           rs.next();
           fd1=rs.getInt
    */

  rs2=stmt2.executeQuery("select distinct rollno from genresult where  std="+std1+" and class='"+c1+"' and date1 >= "+fd1+" and month1 >= "+fm1+" and date1 <= "+td1+" and month1 <= "+tm1+"  order by rollno");
  while(rs2.next())
    {
       r1   = rs2.getString("rollno");



        rs=stmt.executeQuery("select name as nam from genresult where rollno="+r1+" and std="+std1+" and class='"+c1+"'");
        rs.next(); 
        n1 = rs.getString("nam");


        out.println("<center>");
        out.println(" <table border=1 width=700>");
        out.println("<tr>");
        out.println("<th bgcolor=\"rgb(211,255,213)\"><p align=\"center\"><font face=\"Times New Roman\" size=5> <strong>School Or College Name</strong></font></th>");
        out.println("</tr>");


        out.println("  <tr> ");
        out.println("<th bgcolor=\"rgb(211,255,213)\"><strong><font face=\"Lmg-Arun Condensed\" size=5><span style=\"text-transform: capitalize\"><p align=\"center\">"+em+"</span></font></strong></th>");
        out.println(" </tr>");

        out.println("  <tr> ");
        out.println("<td bgcolor=\"rgb(211,255,213)\"><font face=\"Times New Roman\" size=2><strong><em><p align=\"left\">");
        out.println(" </em><font face=\"Times New Roman\" size=2>Name :&nbsp;&nbsp;&nbsp;&nbsp;</font><span style=\"text-transform: capitalize\">"+n1+"</span></strong></font></td>");
        out.println("</tr>");
        out.println("</table>");


        out.println(" <table border=1 width=700>");
        out.println("<tr>");
        out.println("<th bgcolor=\"rgb(211,255,213)\"><p align=\"center\"><b><font face=\"Arial\" size=2><strong>Standard :&nbsp;&nbsp;&nbsp;&nbsp;</b></font><font face=\"Times New Roman\" size=2> "+std1+"</strong></font></th>");
        out.println("<th bgcolor=\"rgb(211,255,213)\"><p align=\"center\"><b><font face=\"Arial\" size=2><strong>Class :&nbsp;&nbsp;&nbsp;&nbsp;</b></font><font face=\"Times New Roman\" size=2>  "+c1+"</strong></font></th>");
        out.println("<th bgcolor=\"rgb(211,255,213)\"><p align=\"center\"><b><font face=\"Arial\" size=2><strong>Roll No :&nbsp;&nbsp;&nbsp;&nbsp;</b></font><font face=\"Times New Roman\" size=2>  "+r1+"</strong></font></th>");
        out.println("</tr>");
        out.println("</table>");


        out.println(" <table border=1 width=700>");
        out.println("<tr height=25>");
        out.println("<th width=80 bgcolor=\"rgb(211,255,213)\"><b><font face=\"Arial\" size=2><strong><p align=\"center\">Date</strong></font></th></b>");
        out.println("<th bgcolor=\"rgb(211,255,213)\"><b><font face=\"Arial\" size=2><strong><p align=\"center\">Subject</strong></font></th></b>");
        out.println("<th width=80 bgcolor=\"rgb(211,255,213)\"><b><font face=\"Arial\" size=2><strong><p align=\"center\">Total Marks</strong></font></th></b>");
        out.println("<th width=80 bgcolor=\"rgb(211,255,213)\"><b><font face=\"Arial\" size=2><strong><p align=\"center\">Obtain Marks</strong></font></th></b>");
        out.println("<th width=80 bgcolor=\"rgb(211,255,213)\"><b><font face=\"Arial\" size=2><strong><p align=\"center\">Obtain Time(Min.)</strong></font></th></b>");
        out.println("<th width=80 bgcolor=\"rgb(211,255,213)\"><b><font face=\"Arial\" size=2><strong><p align=\"center\">%</strong></font></th></b>");
        out.println("</tr>");
        




        rs=stmt.executeQuery("select * from genresult where rollno="+r1+" and std="+std1+" and class='"+c1+"'  and date1 >= "+fd1+" and month1 >= "+fm1+" and date1 <= "+td1+" and month1 <= "+tm1+" ");
     
     
        while(rs.next())
               {




                                    int rn=rs.getInt("rollno");
                                    String nm=rs.getString("name");
                                    String sub=rs.getString("subject");
                                    int tm=rs.getInt("totalmarks");
                                    int om=rs.getInt("obtainmarks");
                                    int ot=rs.getInt("obtaintime");
                                    int per=rs.getInt("percentage");
                                    String dt=rs.getString("date1");
                                    String mn=rs.getString("month1");


           //    sumtot=tot1+tot2+tot3+tot4;
           //    sumj=j1+j2+j3+j4;


                out.println("<tr>");

                out.println("<th bgcolor=\"rgb(211,255,213)\"><strong> <p align=\"center\" ><font face=\"Arial\" size=2>"+dt+"/"+mn+"</font></p></th>");
                out.println("</strong>");

                out.println("<td bgcolor=\"rgb(211,255,213)\"><strong> <p align=\"left\" ><font face=\"Arial\" size=2><span style=\"text-transform: capitalize\">&nbsp;&nbsp;&nbsp;&nbsp;"+sub+"</span></font></p></td>");
                out.println("</strong>");

                out.println("<th bgcolor=\"rgb(211,255,213)\"><strong> <p align=\"center\" ><font face=\"Arial\" size=2>"+tm+"</font></p></th>");
                out.println("</strong>");

                out.println("<th bgcolor=\"rgb(211,255,213)\"><strong> <p align=\"center\"> <font face=\"Arial\" size=2>"+om+"</font></p></th>");
                out.println("</strong>");

                out.println("<th bgcolor=\"rgb(211,255,213)\"><strong> <p align=\"center\"> <font face=\"Arial\" size=2>"+ot+"</font></p></th>");
                out.println("</strong>");

                out.println("<th bgcolor=\"rgb(211,255,213)\"><strong> <p align=\"center\"> <font face=\"Arial\" size=2>"+per+"%</font></p></th>");
                out.println("</strong>");

                out.println("</tr>");


               total=total+tm;
               got=got+om;

               }



      /*          rs=stmt.executeQuery("select sum(tot_mark) as t2 from result where roll_no="+r1+" and std="+std1+" and class='"+c1+"'");
                rs.next();
                int t3 = rs.getInt("t2");


                rs=stmt.executeQuery("select sum(j_mark) as j2 from result where roll_no="+r1+" and std="+std1+" and class='"+c1+"'");
                rs.next();
                int j3 = rs.getInt("j2");
                                         */
                

                out.println("<tr>");
                out.println("<th></th>");
                out.println("<th bgcolor=\"rgb(211,255,213)\"><font face=\"Arial\" size=2><strong>Total</strong></font></th>");
                out.println("<th bgcolor=\"rgb(211,255,213)\"><font face=\"Arial\" size=2><strong>"+total+"</strong></font></th>");
                out.println("<th bgcolor=\"rgb(211,255,213)\"><font face=\"Arial\" size=2><strong>"+got+"</strong></font></th>");
                out.println("</tr>");

                out.println("</table>");


                got = (got*100)/total;
                 if(got>=90)
                  {
                  grade = "A";
                   }
                 else if(got>=70 && got<90)
                   {
                   grade = "B";
                   }
                 else if(got>=50 && got<70)
                   {
                   grade = "C";
                   }
                else 
                   {
                   grade = "D";
                   }


                out.println(" <table border=1 width=700>");
                out.println("<tr>");
                out.println("<th bgcolor=\"rgb(211,255,213)\"><font face=\"Arial\" size=2><strong>Date :&nbsp;&nbsp;&nbsp;&nbsp;"+result+"</strong></font></th>");
                out.println("<th bgcolor=\"rgb(211,255,213)\"><font face=\"Arial\" size=2><strong>Percentage :&nbsp;&nbsp;&nbsp;&nbsp;"+got+"%</strong></font></th>");
                out.println("<th bgcolor=\"rgb(211,255,213)\"><font face=\"Arial\" size=2><strong>Grade :&nbsp;&nbsp;&nbsp;&nbsp;"+grade+"</strong></font></th>");
                out.println("</tr>");


    
                out.println("</table>");
                out.println(" <table border=1 width=700>");
                out.println("<td align=right><p align=\"left\"><font face=\"Arial\" size=2><strong>Sign: </strong></font></td>");
                

                 int rank1=0;

      
                 rs = stmt.executeQuery("SELECT * FROM genrank where  std="+std1+" and class='"+c1+"' and  rollno="+r1+" ");
                 if(rs.next())
                 {
                 rank1=rs.getInt("rank");
                 }

                  if(rank1==0)
                  {
                     out.println("<td align=right><p align=\"left\"><font face=\"Arial\" size=2><strong>Sign: </strong></font></td><td align=center><strong>Rank: Fail</strong></td>");
                  }
                  else
                  {
                     out.println("<td align=right><p align=\"left\"><font face=\"Arial\" size=2><strong>Sign: </strong></font></td><td align=center><strong>Rank: "+rank1+"</strong></td>");
                  }
  


                out.println("</table>");
                out.println("<hr>");


                

    }




         }
           catch(Exception e)
              {
                 out.println("Student had not given the Exam");
                 out.println(e.getMessage());
              }


        out.println("</table>");
        out.println("</center>");
//        out.println("</center></div>");
        out.println("</body>");
        out.println("</html>");

        }
    }
