import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Fresult extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      PrintWriter out=response.getWriter();

      String  std1=null,e1=null,r1=null,c1=null,grade=null,n1=null;
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
      ResultSet rs=null;
      ResultSet rs1=null;

      String img1="a";
      std1=request.getParameter("std");
      r1=request.getParameter("rollno");
      c1=request.getParameter("class");
      img1=request.getParameter("image");
      if(img1.equals(null))
        {
        out.println("no Image");
        }

//      e1=request.getParameter("subject");
//      String s2=e1.replace('!',' ');

        String s2="Result Of Every Exam Given By The Student";
        

        out.println("<center>");
        out.println(" <table border=1 width=700>");
        out.println("<tr>");
        out.println("<th  colspan=4 bgcolor=\"rgb(133,213,135)\"><p align=\"center\"><font face=\"Times New Roman\" size=5> <strong>School Or College Name</strong></font></th>");
        out.println("<th  colspan=4 rowspan=4><img src=\""+img1+"\" width=100 height=80></td>");
        out.println("</tr>");

                          //\"rgb(133,213,135)\"

        try
           {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con = DriverManager.getConnection("jdbc:odbc:usda");
           stmt = con.createStatement();



        rs=stmt.executeQuery("select name as nam from genresult where rollno="+r1+" and std="+std1+" and class='"+c1+"'");
        rs.next(); 
        n1 = rs.getString("nam");


        out.println("  <tr> ");
        out.println("<th  colspan=4 bgcolor=\"rgb(211,255,213)\"><strong><font face=\"Times New Roman\" size=4><span style=\"text-transform: capitalize\"><p align=\"center\">"+s2+"</span></font></strong></th>");
        out.println(" </tr>");

        out.println("  <tr> ");
        out.println("<td  colspan=4 bgcolor=\"rgb(211,255,213)\"><font face=\"Times New Roman\" size=2><strong><em><p align=\"left\">");
        out.println(" </em><font face=\"Times New Roman\" size=2>Name :&nbsp;&nbsp;&nbsp;&nbsp;</font><span style=\"text-transform: capitalize\">"+n1+"</span></strong></font></td>");
        out.println("</tr>");
//t        out.println("</table>");


 //t       out.println(" <table border=1 width=700>");
        out.println("<tr>");
        out.println("<th bgcolor=\"rgb(211,255,213)\"><p align=\"center\"><b><font face=\"Arial\" size=2><strong>Standard :&nbsp;&nbsp;&nbsp;&nbsp;</b></font><font face=\"Times New Roman\" size=2> "+std1+"</strong></font></th>");
        out.println("<th bgcolor=\"rgb(211,255,213)\"><p align=\"center\"><b><font face=\"Arial\" size=2><strong>Class :&nbsp;&nbsp;&nbsp;&nbsp;</b></font><font face=\"Times New Roman\" size=2>  "+c1+"</strong></font></th>");
        out.println("<th bgcolor=\"rgb(211,255,213)\"><p align=\"center\"><b><font face=\"Arial\" size=2><strong>Roll No :&nbsp;&nbsp;&nbsp;&nbsp;</b></font><font face=\"Times New Roman\" size=2>  "+r1+"</strong></font></th>");
        out.println("</tr>");
 //t       out.println("</table>");


//t        out.println(" <table border=1 width=700>");
        out.println("<tr height=25>");
        out.println("<th  bgcolor=\"rgb(211,255,213)\"><b><font face=\"Arial\" size=2><strong><p align=\"center\">Date</strong></font></th></b>");  //width=80
        out.println("<th bgcolor=\"rgb(211,255,213)\"><b><font face=\"Arial\" size=2><strong><p align=\"center\">Subject</strong></font></th></b>");
        out.println("<th  bgcolor=\"rgb(211,255,213)\"><b><font face=\"Arial\" size=2><strong><p align=\"center\">Total Marks</strong></font></th></b>");
        out.println("<th  bgcolor=\"rgb(211,255,213)\"><b><font face=\"Arial\" size=2><strong><p align=\"center\">Obtain Marks</strong></font></th></b>");
        out.println("<th  bgcolor=\"rgb(211,255,213)\"><b><font face=\"Arial\" size=2><strong><p align=\"center\">Time(Min.)</strong></font></th></b>");
        out.println("<th  bgcolor=\"rgb(211,255,213)\"><b><font face=\"Arial\" size=2><strong><p align=\"center\">%</strong></font></th></b>");
        out.println("</tr>");
        




        rs=stmt.executeQuery("select * from genresult where rollno="+r1+" and std="+std1+" and class='"+c1+"'");
     
     
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
                out.println("<th bgcolor=\"rgb(133,213,135)\"><font face=\"Arial\" size=2><strong>Total</strong></font></th>");
                out.println("<th bgcolor=\"rgb(133,213,135)\"><font face=\"Arial\" size=2><strong>"+total+"</strong></font></th>");
                out.println("<th bgcolor=\"rgb(133,213,135)\"><font face=\"Arial\" size=2><strong>"+got+"</strong></font></th>");
                out.println("</tr>");

    //t            out.println("</table>");


                got = (got*100)/total;

                 if(got>=70)
                  {
                  grade = "DISTINCTION";
                   }
                 else if(got>=60 && got<70)
                   {
                   grade = "FIRST-CLASS";
                   }
                 else if(got>=40 && got<60)
                   {
                   grade = "SECOND-CLASS";
                   }
                else 
                   {
                   grade = "FAIL";
                   }


    //t            out.println(" <table border=1 width=700>");
                out.println("<tr>");
                out.println("<th colspan=2 bgcolor=\"rgb(133,213,135)\"><font face=\"Arial\" size=2><strong>Date :&nbsp;&nbsp;&nbsp;&nbsp;"+result+"</strong></font></th>");
                out.println("<th colspan=2 bgcolor=\"rgb(133,213,135)\"><font face=\"Arial\" size=2><strong>Percentage :&nbsp;&nbsp;&nbsp;&nbsp;"+got+"%</strong></font></th>");
                out.println("<th colspan=2 bgcolor=\"rgb(133,213,135)\"><font face=\"Arial\" size=2><strong>Grade :&nbsp;&nbsp;&nbsp;&nbsp;"+grade+"</strong></font></th>");
                out.println("</tr>");



   //t             out.println("</table>");
   //t             out.println(" <table border=1 width=700>  ");
                     


                  int rank1=0;

      
                 rs = stmt.executeQuery("SELECT * FROM genrank where  std="+std1+" and class='"+c1+"' and  rollno="+r1+" ");
                 if(rs.next())
                 {
                 rank1=rs.getInt("rank");
                 }

                  if(rank1==0)
                  {
                     out.println("<td colspan=3 align=\"left\"><font face=\"Times New Roman\" size=2><strong>Signature Of  Principal: </strong></font></td> <th  colspan=3  bgcolor=\"rgb(133,213,135)\"><strong><font face=\"Times New Roman\" size=2>Rank: Fail</font></strong></th>");
                  }
                  else
                  {
                     out.println("<td colspan=3  align=\"left\"><font face=\"Times New Roman\" size=2><strong>Signature Of  Principal: </strong></font></td><th  colspan=3  bgcolor=\"rgb(133,213,135)\"><strong><font face=\"Times New Roman\" size=2>Rank: "+rank1+"</font></strong></th>");
                  }


              



    //t                out.println("</table>");
         }
           catch(Exception e)
              {
                 out.println("<center><font face=\"Lmg-Arun Condensed\" size=\"6\">:JLSFZ[, GYLP</font></center>");
              }


        out.println("</table>");
        out.println("</center>");
//        out.println("</center></div>");
        out.println("</body>");
        out.println("</html>");

        }
    }
