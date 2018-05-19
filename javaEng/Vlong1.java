import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;


public class Vlong1 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();


      HttpSession session = request.getSession(true);      
      String userid = (String) session.getValue("userid");
      String password=(String) session.getValue("password");
       

      if((userid==null) || (password==null))
         {
//          response.sendRedirect("/servlet/Login");
//          return;
         }


      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      
      out.println("<body bgcolor=\"rgb(211,255,213)\">");

////**********************Inserting into subject table**********
       String  l1,s1,s2,q1=null,qfield=null;
       int q2=0;

       Connection con=null;
       Statement stmt=null,stmt1=null;
       ResultSet rs=null,rs1=null;
       String subject=null,lno=null,std=null,qt=null,qto=null,fname=null,rn=null,wn=null;
       int rn1=0,wn1=0;
       String r1="aa",r2="aa",r3="aa",r4="aa",r5="aa",r6="aa",r7="aa",r8="aa",r9="aa",r10="aa",r11="aa",r12="aa",r13="aa",r14="aa",r15="aa",r16="aa",r17="aa",r18="aa",r19="aa",r20="aa";
       String w1="aa",w2="aa",w3="aa",w4="aa",w5="aa",w6="aa",w7="aa",w8="aa",w9="aa",w10="aa",w11="aa",w12="aa",w13="aa",w14="aa",w15="aa",w16="aa",w17="aa",w18="aa",w19="aa",w20="aa";
       String htm1=null;



       s2=request.getParameter("subject");
       s1=request.getParameter("std");
       l1=request.getParameter("lno");
       q1=request.getParameter("question");
       htm1=request.getParameter("hts");

    //   System.out.println(htm1);


       




       qt=request.getParameter("Qtype");
       qto=request.getParameter("Qtype");

       rn=request.getParameter("rightno");
       wn=request.getParameter("wrongno");

       if(rn.equals("1")) { rn1=1; }       
       if(rn.equals("2")) { rn1=2; }
       if(rn.equals("3")) { rn1=3; }
       if(rn.equals("4")) { rn1=4; }
       if(rn.equals("5")) { rn1=5; }
       if(rn.equals("6")) { rn1=6; }
       if(rn.equals("7")) { rn1=7; }
       if(rn.equals("8")) { rn1=8; }
       if(rn.equals("9")) { rn1=9; }
       if(rn.equals("10")) { rn1=10; }
       if(rn.equals("11")) { rn1=11; }
       if(rn.equals("12")) { rn1=12; }
       if(rn.equals("13")) { rn1=13; }
       if(rn.equals("14")) { rn1=14; }
       if(rn.equals("15")) { rn1=15; }
       if(rn.equals("16")) { rn1=16; }
       if(rn.equals("17")) { rn1=17; }
       if(rn.equals("18")) { rn1=18; }
       if(rn.equals("19")) { rn1=19; }
       if(rn.equals("20")) { rn1=20; }

       if(wn.equals("1")) { wn1=1; }
       if(wn.equals("2")) { wn1=2; }
       if(wn.equals("3")) { wn1=3; }
       if(wn.equals("4")) { wn1=4; }
       if(wn.equals("5")) { wn1=5; }
       if(wn.equals("6")) { wn1=6; }
       if(wn.equals("7")) { wn1=7; }
       if(wn.equals("8")) { wn1=8; }
       if(wn.equals("9")) { wn1=9; }
       if(wn.equals("10")) { wn1=10; }
       if(wn.equals("11")) { wn1=11; }
       if(wn.equals("12")) { wn1=12; }
       if(wn.equals("13")) { wn1=13; }
       if(wn.equals("14")) { wn1=14; }
       if(wn.equals("15")) { wn1=15; }
       if(wn.equals("16")) { wn1=16; }
       if(wn.equals("17")) { wn1=17; }
       if(wn.equals("18")) { wn1=18; }
       if(wn.equals("19")) { wn1=19; }
       if(wn.equals("20")) { wn1=20; }


 if( q1!=null )
    {

       if(rn1 >= 1) { r1=request.getParameter("1r"); }  
       if(rn1 >= 2) { r2=request.getParameter("2r"); }
       if(rn1 >= 3) { r3=request.getParameter("3r"); }
       if(rn1 >= 4) { r4=request.getParameter("4r"); }
       if(rn1 >= 5) { r5=request.getParameter("5r"); }
       if(rn1 >= 6) { r6=request.getParameter("6r"); }
       if(rn1 >= 7) { r7=request.getParameter("7r"); }
       if(rn1 >= 8) { r8=request.getParameter("8r"); }
       if(rn1 >= 9) { r9=request.getParameter("9r"); }   
       if(rn1 >= 10) { r10=request.getParameter("10r"); }
       if(rn1 >= 11) { r11=request.getParameter("11r"); }
       if(rn1 >= 12) { r12=request.getParameter("12r"); }
       if(rn1 >= 13) { r13=request.getParameter("13r"); }
       if(rn1 >= 14) { r14=request.getParameter("14r"); }
       if(rn1 >= 15) { r15=request.getParameter("15r"); }
       if(rn1 >= 16) { r16=request.getParameter("16r"); }
       if(rn1 >= 17) { r17=request.getParameter("17r"); }
       if(rn1 >= 18) { r18=request.getParameter("18r"); }
       if(rn1 >= 19) { r19=request.getParameter("19r"); }
       if(rn1 >= 20) { r20=request.getParameter("20r"); }
       
                                                         
       if(wn1 >= 1) { w1=request.getParameter("1w"); }
       if(wn1 >= 2) { w2=request.getParameter("2w"); }
       if(wn1 >= 3) { w3=request.getParameter("3w"); }
       if(wn1 >= 4) { w4=request.getParameter("4w"); }
       if(wn1 >= 5) { w5=request.getParameter("5w"); }
       if(wn1 >= 6) { w6=request.getParameter("6w"); }
       if(wn1 >= 7) { w7=request.getParameter("7w"); }   
       if(wn1 >= 8) { w8=request.getParameter("8w"); }
       if(wn1 >= 9) { w9=request.getParameter("9w"); }
       if(wn1 >= 10) { w10=request.getParameter("10w"); }
       if(wn1 >= 11) { w11=request.getParameter("11w"); }
       if(wn1 >= 12) { w12=request.getParameter("12w"); }
       if(wn1 >= 13) { w13=request.getParameter("13w"); }
       if(wn1 >= 14) { w14=request.getParameter("14w"); }
       if(wn1 >= 15) { w15=request.getParameter("15w"); }
       if(wn1 >= 16) { w16=request.getParameter("16w"); }
       if(wn1 >= 17) { w17=request.getParameter("17w"); }
       if(wn1 >= 18) { w18=request.getParameter("18w"); }
       if(wn1 >= 19) { w19=request.getParameter("19w"); }
       if(wn1 >= 20) { w20=request.getParameter("20w"); }


    }

     

       fname=request.getParameter("F_name");
       String fon2=fname.replace('!',' ');

       qfield="opt";

       
      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 con.setAutoCommit(true); 
                 stmt = con.createStatement();

                
                     //   rs=stmt.executeQuery("select fontname as f2 from subject where std="+s1+" and sub_name='"+s2+"'");        
                     //   rs.next();
                     //   String fo2=rs.getString("f2");
                     //   out.println(""+fo2+"");


                         rs=stmt.executeQuery("select max(queno) as qn from "+s2+s1+"v " );
                         rs.next();
                         q2=rs.getInt("qn");
                         q2++;

                      if(r1!=null && w1!=null && q1!=null )
                          {
                            String str1=null,str2=null,str3=null,str4=null,les="&lt;";
                            int ind1=0,ind2=0;

            
                            
                            if(htm1.equals("hit"))
                             {

                            
                            for(int str=0;str<q1.length();str++)
                               {
                                 ind1=q1.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=q1.substring(ind1+1);
                                   str2=q1.substring(0,ind1);
                                   str2=str2.concat(les);
                                   q1=str2.concat(str1);
                                  }
                               }
                          //t   System.out.println(q1);


                            for(int str=0;str<r1.length();str++)
                               {
                                 ind1=r1.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r1.substring(ind1+1);
                                   str2=r1.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r1=str2.concat(str1);
                                  }
                               }
                          //t   System.out.println(1);
                     
                            for(int str=0;str<r2.length();str++)
                               {
                                 ind1=r2.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r2.substring(ind1+1);
                                   str2=r2.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r2=str2.concat(str1);
                                  }
                               }
                           //t  System.out.println(2);
                    

                            for(int str=0;str<r3.length();str++)
                               {
                                 ind1=r3.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r3.substring(ind1+1);
                                   str2=r3.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r3=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r3);

                            for(int str=0;str<r4.length();str++)
                               {
                                 ind1=r4.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r4.substring(ind1+1);
                                   str2=r4.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r4=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r4);

                            for(int str=0;str<r5.length();str++)
                               {
                                 ind1=r5.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r5.substring(ind1+1);
                                   str2=r5.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r5=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(5);

                            for(int str=0;str<r6.length();str++)
                               {
                                 ind1=r6.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r6.substring(ind1+1);
                                   str2=r6.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r6=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r6);


                            for(int str=0;str<r7.length();str++)
                               {
                                 ind1=r7.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r7.substring(ind1+1);
                                   str2=r7.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r7=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r7);

                            for(int str=0;str<r8.length();str++)
                               {
                                 ind1=r8.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r8.substring(ind1+1);
                                   str2=r8.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r8=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r5);

                            for(int str=0;str<r9.length();str++)
                               {
                                 ind1=r9.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r9.substring(ind1+1);
                                   str2=r9.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r9=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r5);

                            for(int str=0;str<r10.length();str++)
                               {
                                 ind1=r10.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r10.substring(ind1+1);
                                   str2=r10.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r10=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(5);


                            for(int str=0;str<r11.length();str++)
                               {
                                 ind1=r11.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r11.substring(ind1+1);
                                   str2=r11.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r11=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r5);

                            for(int str=0;str<r12.length();str++)
                               {
                                 ind1=r12.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r12.substring(ind1+1);
                                   str2=r12.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r12=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r5);

                            for(int str=0;str<r13.length();str++)
                               {
                                 ind1=r13.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r13.substring(ind1+1);
                                   str2=r13.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r13=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r5);

                            for(int str=0;str<r14.length();str++)
                               {
                                 ind1=r14.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r14.substring(ind1+1);
                                   str2=r14.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r14=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r5);

                            for(int str=0;str<r15.length();str++)
                               {
                                 ind1=r15.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r15.substring(ind1+1);
                                   str2=r15.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r15=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r5);


                            for(int str=0;str<r16.length();str++)
                               {
                                 ind1=r16.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r16.substring(ind1+1);
                                   str2=r16.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r16=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r5);

                            for(int str=0;str<r17.length();str++)
                               {
                                 ind1=r17.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r17.substring(ind1+1);
                                   str2=r17.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r17=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r5);

                            for(int str=0;str<r18.length();str++)
                               {
                                 ind1=r18.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r18.substring(ind1+1);
                                   str2=r18.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r18=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r5);

                            for(int str=0;str<r19.length();str++)
                               {
                                 ind1=r19.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r19.substring(ind1+1);
                                   str2=r19.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r19=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(r5);

                            for(int str=0;str<r20.length();str++)
                               {
                                 ind1=r20.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=r20.substring(ind1+1);
                                   str2=r20.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r20=str2.concat(str1);
                                  }
                               }

                           //t  System.out.println(1);



                            for(int str=0;str<w1.length();str++)
                               {
                                 ind1=w1.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w1.substring(ind1+1);
                                   str2=w1.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w1=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w1);


                            for(int str=0;str<w2.length();str++)
                               {
                                 ind1=w2.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w2.substring(ind1+1);
                                   str2=w2.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w2=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w2);

                            for(int str=0;str<w3.length();str++)
                               {
                                 ind1=w3.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w3.substring(ind1+1);
                                   str2=w3.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w3=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w3);

                            for(int str=0;str<w4.length();str++)
                               {
                                 ind1=w4.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w4.substring(ind1+1);
                                   str2=w4.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w4=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w4);

                            for(int str=0;str<w5.length();str++)
                               {
                                 ind1=w5.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w5.substring(ind1+1);
                                   str2=w5.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w5=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);
                            
                            for(int str=0;str<w6.length();str++)
                               {
                                 ind1=w6.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w6.substring(ind1+1);
                                   str2=w6.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w6=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            for(int str=0;str<w7.length();str++)
                               {
                                 ind1=w7.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w7.substring(ind1+1);
                                   str2=w7.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w7=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            for(int str=0;str<w8.length();str++)
                               {
                                 ind1=w8.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w8.substring(ind1+1);
                                   str2=w8.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w8=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            for(int str=0;str<w9.length();str++)
                               {
                                 ind1=w9.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w9.substring(ind1+1);
                                   str2=w9.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w9=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            for(int str=0;str<w10.length();str++)
                               {
                                 ind1=w10.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w10.substring(ind1+1);
                                   str2=w10.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w10=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            for(int str=0;str<w11.length();str++)
                               {
                                 ind1=w11.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w11.substring(ind1+1);
                                   str2=w11.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w11=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            for(int str=0;str<w12.length();str++)
                               {
                                 ind1=w12.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w12.substring(ind1+1);
                                   str2=w12.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w12=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            for(int str=0;str<w13.length();str++)
                               {
                                 ind1=w13.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w13.substring(ind1+1);
                                   str2=w13.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w13=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            for(int str=0;str<w14.length();str++)
                               {
                                 ind1=w14.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w14.substring(ind1+1);
                                   str2=w14.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w14=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            for(int str=0;str<w15.length();str++)
                               {
                                 ind1=w15.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w15.substring(ind1+1);
                                   str2=w15.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w15=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            for(int str=0;str<w16.length();str++)
                               {
                                 ind1=w16.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w16.substring(ind1+1);
                                   str2=w16.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w16=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            for(int str=0;str<w17.length();str++)
                               {
                                 ind1=w17.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w17.substring(ind1+1);
                                   str2=w17.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w17=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            for(int str=0;str<w18.length();str++)
                               {
                                 ind1=w18.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w18.substring(ind1+1);
                                   str2=w18.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w18=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);


                            for(int str=0;str<w19.length();str++)
                               {
                                 ind1=w19.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w19.substring(ind1+1);
                                   str2=w19.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w19=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            for(int str=0;str<w20.length();str++)
                               {
                                 ind1=w20.indexOf("<");

                                 if(ind1 >= 0)
                                  {
                                   str1=w20.substring(ind1+1);
                                   str2=w20.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w20=str2.concat(str1);
                                  }
                               }
                            //t System.out.println(w5);

                            }

                            les="''";

                            ind1=q1.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=q1.substring(ind1+1);
                                   str2=q1.substring(0,ind1);
                                   str2=str2.concat(les);
                                   q1=str2.concat(str1);
                                  }
                                 ind1=q1.indexOf("'",ind1+2);
                               }
                            //t System.out.println(q1);

                            ind1=r1.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r1.substring(ind1+1);
                                   str2=r1.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r1=str2.concat(str1);
                                  }
                                 ind1=r1.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r2.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r2.substring(ind1+1);
                                   str2=r2.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r2=str2.concat(str1);
                                  }
                                 ind1=r2.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);


                            ind1=r3.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r3.substring(ind1+1);
                                   str2=r3.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r3=str2.concat(str1);
                                  }
                                 ind1=r3.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r4.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r4.substring(ind1+1);
                                   str2=r4.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r4=str2.concat(str1);
                                  }
                                 ind1=r4.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r5.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r5.substring(ind1+1);
                                   str2=r5.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r5=str2.concat(str1);
                                  }
                                 ind1=r5.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r6.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r6.substring(ind1+1);
                                   str2=r6.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r6=str2.concat(str1);
                                  }
                                 ind1=r16.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r7.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r7.substring(ind1+1);
                                   str2=r7.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r7=str2.concat(str1);
                                  }
                                 ind1=r7.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r8.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r8.substring(ind1+1);
                                   str2=r8.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r8=str2.concat(str1);
                                  }
                                 ind1=r8.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r9.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r9.substring(ind1+1);
                                   str2=r9.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r9=str2.concat(str1);
                                  }
                                 ind1=r1.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

            
                            ind1=r10.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r10.substring(ind1+1);
                                   str2=r10.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r10=str2.concat(str1);
                                  }
                                 ind1=r10.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r11.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r11.substring(ind1+1);
                                   str2=r11.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r11=str2.concat(str1);
                                  }
                                 ind1=r11.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r12.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r12.substring(ind1+1);
                                   str2=r12.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r12=str2.concat(str1);
                                  }
                                 ind1=r12.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r13.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r13.substring(ind1+1);
                                   str2=r13.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r13=str2.concat(str1);
                                  }
                                 ind1=r13.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r14.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r14.substring(ind1+1);
                                   str2=r14.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r14=str2.concat(str1);
                                  }
                                 ind1=r14.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r15.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r15.substring(ind1+1);
                                   str2=r15.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r15=str2.concat(str1);
                                  }
                                 ind1=r15.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r16.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r16.substring(ind1+1);
                                   str2=r16.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r16=str2.concat(str1);
                                  }
                                 ind1=r16.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r17.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r17.substring(ind1+1);
                                   str2=r17.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r17=str2.concat(str1);
                                  }
                                 ind1=r17.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r18.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r18.substring(ind1+1);
                                   str2=r18.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r18=str2.concat(str1);
                                  }
                                 ind1=r18.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r19.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r19.substring(ind1+1);
                                   str2=r19.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r19=str2.concat(str1);
                                  }
                                 ind1=r19.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=r20.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=r20.substring(ind1+1);
                                   str2=r20.substring(0,ind1);
                                   str2=str2.concat(les);
                                   r20=str2.concat(str1);
                                  }
                                 ind1=r20.indexOf("'",ind1+2);
                               }
                            //t System.out.println(r1);

                            ind1=w1.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w1.substring(ind1+1);
                                   str2=w1.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w1=str2.concat(str1);
                                  }
                                 ind1=w1.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);


                            ind1=w2.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w2.substring(ind1+1);
                                   str2=w2.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w2=str2.concat(str1);
                                  }
                                 ind1=w2.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w3.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w3.substring(ind1+1);
                                   str2=w3.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w3=str2.concat(str1);
                                  }
                                 ind1=w3.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w4.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w4.substring(ind1+1);
                                   str2=w4.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w4=str2.concat(str1);
                                  }
                                 ind1=w4.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w5.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w5.substring(ind1+1);
                                   str2=w5.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w5=str2.concat(str1);
                                  }
                                 ind1=w5.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w6.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w6.substring(ind1+1);
                                   str2=w6.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w6=str2.concat(str1);
                                  }
                                 ind1=w6.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w7.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w7.substring(ind1+1);
                                   str2=w7.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w7=str2.concat(str1);
                                  }
                                 ind1=w7.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w8.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w8.substring(ind1+1);
                                   str2=w8.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w8=str2.concat(str1);
                                  }
                                 ind1=w8.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w9.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w9.substring(ind1+1);
                                   str2=w9.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w9=str2.concat(str1);
                                  }
                                 ind1=w9.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w10.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w10.substring(ind1+1);
                                   str2=w10.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w10=str2.concat(str1);
                                  }
                                 ind1=w10.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w11.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w11.substring(ind1+1);
                                   str2=w11.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w11=str2.concat(str1);
                                  }
                                 ind1=w11.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);


                            ind1=w12.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w12.substring(ind1+1);
                                   str2=w12.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w12=str2.concat(str1);
                                  }
                                 ind1=w12.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);


                            ind1=w13.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w13.substring(ind1+1);
                                   str2=w13.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w13=str2.concat(str1);
                                  }
                                 ind1=w13.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w14.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w14.substring(ind1+1);
                                   str2=w14.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w14=str2.concat(str1);
                                  }
                                 ind1=w14.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w15.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w15.substring(ind1+1);
                                   str2=w15.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w15=str2.concat(str1);
                                  }
                                 ind1=w15.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w16.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w16.substring(ind1+1);
                                   str2=w16.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w16=str2.concat(str1);
                                  }
                                 ind1=w16.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w17.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w17.substring(ind1+1);
                                   str2=w17.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w17=str2.concat(str1);
                                  }
                                 ind1=w17.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w18.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w18.substring(ind1+1);
                                   str2=w18.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w18=str2.concat(str1);
                                  }
                                 ind1=w18.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w19.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w19.substring(ind1+1);
                                   str2=w19.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w19=str2.concat(str1);
                                  }
                                 ind1=w1.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);

                            ind1=w20.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=w20.substring(ind1+1);
                                   str2=w20.substring(0,ind1);
                                   str2=str2.concat(les);
                                   w20=str2.concat(str1);
                                  }
                                 ind1=w20.indexOf("'",ind1+2);
                               }
                            //t System.out.println(w1);


                            ind1=qt.indexOf("'");
                            while(ind1 >=0)
                               {
                                 

                                 if(ind1 >= 0)
                                  {
                                   str1=qt.substring(ind1+1);
                                   str2=qt.substring(0,ind1);
                                   str2=str2.concat(les);
                                   qt=str2.concat(str1);
                                  }
                                 ind1=qt.indexOf("'",ind1+2);
                               }
                            //t System.out.println(qt);

                           
                           stmt.executeUpdate("INSERT INTO "+s2+s1+"v values("+q2+","+rn1+","+wn1+",'"+qt+"','"+q1+"','"+r1+"','"+r2+"','"+r3+"','"+r4+"','"+r5+"','"+r6+"','"+r7+"','"+r8+"','"+r9+"','"+r10+"','"+r11+"','"+r12+"','"+r13+"','"+r14+"','"+r15+"','"+r16+"','"+r17+"','"+r18+"','"+r19+"','"+r20+"','"+w1+"','"+w2+"','"+w3+"','"+w4+"','"+w5+"','"+w6+"','"+w7+"','"+w8+"','"+w9+"','"+w10+"','"+w11+"','"+w12+"','"+w13+"','"+w14+"','"+w15+"','"+w16+"','"+w17+"','"+w18+"','"+w19+"','"+w20+"',"+s1+","+l1+",'"+fon2+"')");
                           
                          }




                        out.println("<form method=\"GET\" action=\"http://"+request.getServerName()+":8080/servlet/Vlong1\" target=\"bottom\">");

                        out.println("<strong><center><font face=\"Times New Roman\" size=\"4\">Que No.- </font>"+q2+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face=\"Times New Roman\" size=\"5\">Give Question & It's Option(s)</font> </center></strong>");

                 

                        out.println("<center>");
                        out.println("<p><strong>&nbsp;<font face=\"Times New Roman\" size=\"4\">Question</font>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </strong>");
                        out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong>");
                     //   out.println("&nbsp;&nbsp;");
                        out.println("<input type=\"text\" name=\"question\" size=\"70\" maxlength=\"200\"  style=\"font-family : "+fon2+";font-size:15pt\"></strong></p>");
                        out.println("</center>");


                        for(int i=1;i<=rn1;i++)
                        {
                        out.println("<center>");
                        out.println("<p><strong><font face=\"Times New Roman\" size=\"4\">Right Ans</font>:"+i+"  </strong>");
                        
                        out.println("<input  type=\"text\" name=\""+i+"r\" size=\"70\" maxlength=\"200\" style=\"font-family : "+fon2+";font-size:15pt\" ></strong></p>");
                        out.println("</center>");
                        }


                        for(int j=1;j<=wn1;j++)
                        {
                        out.println("<center>");
                        out.println("<p><strong><font face=\"Times New Roman\" size=\"4\">Wrong Ans</font>:"+j+"  </strong>");
                        
                        out.println("<input  type=\"text\" name=\""+j+"w\" size=\"70\" maxlength=\"200\"  style=\"font-family : "+fon2+";font-size:15pt\" ></strong></p>");
                        out.println("</center>");
                        }
                        
                //        out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                //        out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                        out.println("</center>");

                        out.println("<center>");
                        out.println("<input  type=\"submit\" value=\"Click This Button To Enter Question\" name=\"submit\" style=\"font-family: Times New Roman; font-size: 18pt\">");
                        
                        out.println("</center>");                       



                        out.println("<INPUT TYPE=\"hidden\" NAME= \"std\" VALUE=\""+s1+"\">"); 
                        out.println("<INPUT TYPE=\"hidden\" NAME= \"lno\" VALUE=\""+l1+"\">");
                        out.println("<INPUT TYPE=\"hidden\" NAME= \"subject\" VALUE=\""+s2+"\">");
                        out.println("<INPUT TYPE=\"hidden\" NAME= \"Qtype\" VALUE=\""+qto+"\">");
                        out.println("<INPUT TYPE=\"hidden\" NAME= \"rightno\" VALUE=\""+rn1+"\">"); 
                        out.println("<INPUT TYPE=\"hidden\" NAME= \"wrongno\" VALUE=\""+wn1+"\">");
                        out.println("<INPUT TYPE=\"hidden\" NAME= \"hts\" VALUE=\""+htm1+"\">"); 

                        out.println("<INPUT TYPE=\"hidden\" NAME= \"F_name\" VALUE=\""+fname+"\">");

                        out.println("</form>");
                        

                      

             }

      catch (Exception e) {
                                      out.println("could not connect : The values you have entered is already exist ");
                                      out.println("<pre>");
                                      out.println(e.getMessage());
                                      out.println("</pre>");
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
                   

     out.println("</body>");
     out.println("</html>");
    }
}



