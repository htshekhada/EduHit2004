import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.lang.*;


public class Democom2 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");

    //  out.println("<body background=\"c:/jsdk2.0/examples/image4.gif\">");
      out.println("<body bgcolor=\"rgb(254,255,225)\">");


       out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=5 color=\"rgb(0,0,255)\">V[HI]S[XGlC8 ;MO8J[Z</font></b></center>");
       out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=3 color=\"rgb(0,0,0)\">AGFJGFZ o </font></b></center>");
       out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=4 color=\"rgb(0,0,0)\"> lCT[XS]DFZ 8LP X[B0F   </font></b></center>");
       out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=4 color=\"rgb(0,0,0)\">!(4S{,FX GUZ ;M;FI8L4  8L\\AFJF0L4  HF]GFU-4 OMGs3Zfv_Z(5vZ&*&&$$P</font></b></center>");



       String u1=null,p1=null;
       u1=request.getParameter("uid");
       p1=request.getParameter("pwd");


      Connection con=null,con1=null;
      Statement stmt=null,stmt1=null,stmt2=null,stmt3=null;
      ResultSet rs=null,rs1=null,rs2=null,rs3=null;

      try  {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 con = DriverManager.getConnection("jdbc:odbc:usda");
                 
                 //       con.setAutoCommit(true); 
                 stmt = con.createStatement();
                 stmt1 = con.createStatement();
                 stmt2 = con.createStatement();
                 stmt3 = con.createStatement();



      int m1=0,m2=0,m3=0,m4=0,m5=0;
      java.util.Date d1;
      d1=new java.util.Date();
      m1=d1.getHours();

      stmt.executeUpdate("delete * from temp");
      stmt.executeUpdate("insert into temp values("+m1+") ");
      rs = stmt.executeQuery("select * from temp");
      rs.next();
      String mhit1 = rs.getString("temp");



      int hithit=0;

      HttpSession session = request.getSession(true);      
      String userid = (String) session.getValue("hit");

//      out.println("<br>session="+userid+",mhit1="+mhit1+",mhit2="+mhit2+",mhit3="+mhit3+"<br>");


      if( !userid.equals(mhit1) )
         {
            out.println("<br><br><center><b><font face=\"Lmg-Arun Condensed\" size=5 color=\"rgb(255,0,0)\">TDFZM 5F;J0\" BM8M K[4 5F;J0\" JUZ TD[ VF ;MO8J[ZGM p5IMU SZL XSXM GCLP</font></b></center>");
            hithit=1;
         }




         if(hithit==0)
           {

                 int i1=0,i2=0,i3=0,i4=0,i5=0,i6=0,i7=0,i8=0,i9=0,i10=0,i11=0,i12=0,i13=0,i14=0,i15=0;

               //  double i1=0,i2=0,i3=0,i4=0,i5=0,i6=0;
                 int n1=0,n2=0,n3=0,n4=0,n5=0,n6=0;
                 int f1=0,f2=0,f3=0,f4=0,f5=0,f6=0;
                 int number[] = new int[500];
                 int numberp[] = new int[500];
                 int tp[] = new int[500];
                 char ca1[] = new char[500];
                 char ca2[] = new char[500];

                 for(int m=0;m<=14;m++)
                  {
                      ca1[m]=u1.charAt(m);
                  }

                 for(int m=0;m<=8;m++)
                  {
                      ca2[m]=p1.charAt(m);
                  }



                 for(int m=0;m<=14;m++)
                  {
                  stmt.executeUpdate("delete * from temp");
                  stmt.executeUpdate("insert into temp values("+ca1[m]+") ");
                  rs = stmt.executeQuery("select * from temp");
                  rs.next();
                  number[m] = rs.getInt("temp");
                  }



           //      for(int m=0;m<=14;m++)
           //       { out.println(number[m]);
           //       }
                  out.println("<br>");
                 
              //    out.println(p1);
                  


                
                 char caz[] = new char[50];
                 caz[0]='a';
                 caz[1]='b';
                 caz[2]='C';
                 caz[3]='D';
                 caz[4]='e';
                 caz[5]='f';
                 caz[6]='g';
                 caz[7]='H';
                 caz[8]='i';
                 caz[9]='J';
                 caz[10]='k';
                 caz[11]='l';
                 caz[12]='M';
                 caz[13]='N';
                 caz[14]='O';
                 caz[15]='P';
                 caz[16]='q';
                 caz[17]='R';
                 caz[18]='s';
                 caz[19]='t';
                 caz[21]='u';
                 caz[22]='V';
                 caz[23]='w';
                 caz[24]='X';
                 caz[25]='Y';
                 caz[26]='Z';

                 /*
                   (no1*no5)%26+1>13 ,no1=ch
                                   ,no1=int
                   no2=(no6*no4)%9+1
                   no3=(no2*no10)%4+4
                   no4=(no3*no9)%26+1<20, ch
                                      , int
                   no5=(no7*no15)%26+1, ch
                   no6=((no8*no14)%26+1)%8+1
                   no7=(no11*no13)%5+3
                   no8=no12%26+1 ,ch
                   no9=(no5*no4)%26+1<15 ,int
                                         ,ch

                 */                

                 tp[0]=((number[0]*number[4])%26)+1;
                 tp[1]=((number[5]*number[3])%9)+1;
                 tp[2]=((number[1]*number[9])%4)+4;
                 tp[3]=((number[2]*number[8])%26)+1;
                 tp[4]=((number[6]*number[14])%26)+1;
                 tp[5]=((((number[7]*number[13])%26)+1)%8)+1;
                 tp[6]=((number[10]*number[12])%5)+3;
                 tp[7]=(number[11]%26)+1;
                 tp[8]=((number[4]*number[3])%26)+1;

                 String fan="";
                 for(int m=0;m<=8;m++)
                  {
                      if(tp[m] < 10)
                        {
                         stmt.executeUpdate("delete * from temp");
                         stmt.executeUpdate("insert into temp values("+tp[m]+") ");
                         rs = stmt.executeQuery("select * from temp");
                         rs.next();
                         fan = fan + rs.getString("temp");
                        }
                      else
                        {
                         fan=fan+caz[tp[m]];
                        }
                  }


                 out.println("<br>");

            //     out.println(fan);
                 

               

                 if(p1.equals(fan))        //p1.equals("1b9c6d4x2f7y1e2g"))
                   {
                     out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=5 color=\"rgb(0,0,255)\">TDFZM 5F;J0\" ;FRM K[4 CJ[ ;MO8J[ZG[ A\\W SZL OZL RF,] SZMP</font></b></center>");
                     File primitive = new File("c:/windows/system/Msd32.dll");
                     FileOutputStream fos = new FileOutputStream(primitive);
                     DataOutputStream dos =new DataOutputStream(fos);

                     dos.writeInt(999);
                  //   System.out.println(cts);

                     dos.close();
                     fos.close();


                   }
                 else
                   {
                     out.println("<center><b><font face=\"Lmg-Arun Condensed\" size=5 color=\"rgb(255,0,0)\">TDFZM 5F;J0\" BM8M K[4 5F;J0\" JUZ TD[ VF ;MO8J[ZGM p5IMU SZL XSXM GCLP</font></b></center>");
                   }

           }


          }
          catch(Exception e)
                           {
                        //   out.println(e.getMessage());
                           }



      out.println("</body>");
      out.println("</html>");



}
}



