import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.net.*;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import java.awt.image.*;
import java.util.*;


public class Cretab extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
             
    {
//      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      
     
      out.println("<html>");
      out.println("<head>");
      out.println("<title>EducationHIT by H.T.Shekhada</title>");
      out.println("</head>");
      out.println("<body bgcolor=\"rgb(254,255,225)\">");
       
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
                 



//   stmt.executeUpdate("insert into biodata values ("+ r1+ ",'"+ n1+"',"+s1+",'"+c1+"','"+sub+"',"+h2+",'a','a','a','a') " );

 stmt.executeUpdate("CREATE TABLE biodata (rollno long,name VARCHAR(50),std INTEGER,class VARCHAR(20),subject varchar(50),endtime long,optional1 varchar(3),short1 varchar(3),long1 varchar(3),joint1 varchar(3),varlon1 varchar(3))");      
 con.commit();
 out.println("biodata");

 stmt.executeUpdate("create table course (std integer,class varchar(20),sub varchar(50),chapno integer,maxopt integer,maxsho integer,maxlon integer,maxjoi integer)");
 con.commit();                                 
 out.println("course");

 stmt.executeUpdate("create table course1 (std integer,class varchar(20),sub varchar(50),chapno integer,rightno integer,wrongno integer,maxvarlon integer)");
 con.commit();                                 
 out.println("course");

 stmt.executeUpdate("create table exmmsg (exmmsg varchar(50))");
 con.commit();
 stmt.executeUpdate("insert into exmmsg values('FIRST TEST')");
 stmt.executeUpdate("insert into exmmsg values('SECOND TEST')");
 stmt.executeUpdate("insert into exmmsg values('THIRD TEST')");
 stmt.executeUpdate("insert into exmmsg values('PRELIMINARY EXAM')");
 stmt.executeUpdate("insert into exmmsg values('FINAL EXAM')");
 con.commit();

 out.println("exmmsg");

 stmt.executeUpdate("create table login (lname varchar(20),pwd varchar(20))");
 con.commit();
 stmt.executeUpdate("insert into login values('hitesh','hitesh')");
 out.println("login");

 stmt.executeUpdate("create table result (name VARCHAR(50),class VARCHAR(20),roll_no long,std INTEGER,sub varchar(50),tot_opt integer,j_opt integer,tot_sho integer,j_sho integer,tot_lon integer,j_lon integer,tot_joi integer,j_joi integer,tot_var integer,j_var integer,date1 integer,month1 integer)");
 con.commit();
 out.println("result");

 stmt.executeUpdate("create table superuser (std integer,class varchar(20),subject varchar(50),examtime integer)");
 con.commit();
 out.println("superuser");

 stmt.executeUpdate("create table subresult (std integer,class varchar(20),subject varchar(50),rollno integer,name varchar(50),totalmarks integer,obtainmarks integer,obtaintime integer,percentage integer,date1 varchar(20))");
 con.commit();
 out.println("subresult");

 stmt.executeUpdate("create table genresult (std integer,class varchar(20),subject varchar(50),rollno integer,name varchar(50),totalmarks integer,obtainmarks integer,obtaintime integer,percentage integer,date1 integer,month1 integer)");
 con.commit();
 out.println("genresult");

 stmt.executeUpdate("create table genrank (std integer,class varchar(20),rollno integer,obtaintime integer,percentage integer,rank integer)");
 con.commit();
 out.println("genrank");


 stmt.executeUpdate("create table subject (std integer,sub_name varchar(50),fontname varchar(50))");
 con.commit();
 out.println("subject");

 stmt.executeUpdate("create table chapname (std integer,subject varchar(50),chap integer,chname varchar(100))");
 con.commit();
 out.println("chapname");

 stmt.executeUpdate("create table temp (temp integer)");
 con.commit();
 out.println("temp");


 out.println("<br>");
 out.println("Creating Demo");

 stmt.executeUpdate("CREATE TABLE DEMO10 (queno INTEGER,quefield VARCHAR(15),quetype VARCHAR(100),que VARCHAR(100),right1 VARCHAR(100),wrong1 VARCHAR(100),wrong2 VARCHAR(100),std INTEGER,chap INTEGER,fname VARCHAR(50))");
 con.commit();
 stmt.executeUpdate("CREATE TABLE DEMO10l (queno INTEGER,quefield VARCHAR(15),quetype VARCHAR(100),que VARCHAR(100),right1 VARCHAR(100),wrong1 VARCHAR(100),wrong2 VARCHAR(100),std INTEGER,chap INTEGER,fname VARCHAR(50))");
 con.commit();
 stmt.executeUpdate("CREATE TABLE DEMO10v (queno INTEGER,rightno integer,wrongno integer,quetype VARCHAR(100),que VARCHAR(100),right1 VARCHAR(100),right2 VARCHAR(100),right3 VARCHAR(100),right4 VARCHAR(100),right5 VARCHAR(100),right6 VARCHAR(100),right7 VARCHAR(100),right8 VARCHAR(100),right9 VARCHAR(100),right10 VARCHAR(100),right11 VARCHAR(100),right12 VARCHAR(100),right13 VARCHAR(100),right14 VARCHAR(100),right15 VARCHAR(100),right16 VARCHAR(100),right17 VARCHAR(100),right18 VARCHAR(100),right19 VARCHAR(100),right20 VARCHAR(100),wrong1 VARCHAR(100),wrong2 VARCHAR(100),wrong3 VARCHAR(100),wrong4 VARCHAR(100),wrong5 VARCHAR(100),wrong6 VARCHAR(100),wrong7 VARCHAR(100),wrong8 VARCHAR(100),wrong9 VARCHAR(100),wrong10 VARCHAR(100),wrong11 VARCHAR(100),wrong12 VARCHAR(100),wrong13 VARCHAR(100),wrong14 VARCHAR(100),wrong15 VARCHAR(100),wrong16 VARCHAR(100),wrong17 VARCHAR(100),wrong18 VARCHAR(100),wrong19 VARCHAR(100),wrong20 VARCHAR(100),std INTEGER,chap INTEGER,fname VARCHAR(50))");
 con.commit();
 stmt.executeUpdate("INSERT INTO subject values(10,'DEMO','Arial')");
 con.commit();

 stmt.executeUpdate("insert into DEMO10 values(1,'opt','Give Answer of Optional type Question','Give verb of courage','encourage','courage','imcourage',10,1,'Arial')");
 con.commit();
 stmt.executeUpdate("insert into DEMO10 values(2,'opt','Give Answer of Optional type Question','Give verb of able','enable','ability','eneble',10,1,'Arial')");
 con.commit();
 stmt.executeUpdate("insert into DEMO10 values(3,'opt','Give Answer of Optional type Question','Give verb of fool','befool','foolish','folish',10,1,'Arial')");
 con.commit();
 stmt.executeUpdate("insert into DEMO10 values(4,'opt','Give Answer of Optional type Question','Give verb of little','belittle','belitle','littelise',10,1,'Arial')");
 con.commit();
 stmt.executeUpdate("insert into DEMO10 values(5,'opt','Give Answer of Optional type Question','Give verb of company','accompany','acompany','imcompany',10,1,'Arial')");
 con.commit();

 stmt.executeUpdate("insert into DEMO10 values(6,'sho','Write Answer','What is the adjective of praise','praiseworthy','','',10,1,'Arial')");
 con.commit();
 stmt.executeUpdate("insert into DEMO10 values(7,'sho','Write Answer','What is the adjective of protect','protective','','',10,1,'Arial')");
 con.commit();
 stmt.executeUpdate("insert into DEMO10 values(8,'sho','Write Answer','What is the adjective of punish','punishable','','',10,1,'Arial')");
 con.commit();
 stmt.executeUpdate("insert into DEMO10 values(9,'sho','Write Answer','What is the adjective of signify','significant','','',10,1,'Arial')");
 con.commit();
 stmt.executeUpdate("insert into DEMO10 values(10,'sho','Write Answer','What is the adjective of stick','sticky','','',10,1,'Arial')");
 con.commit();

 stmt.executeUpdate("insert into DEMO10 values(11,'joi','Join Opposite Words','advantage','disallow','1','5',10,1,'Arial')");
 con.commit();
 stmt.executeUpdate("insert into DEMO10 values(11,'joi','Join Opposite Words','agree','disappear','2','3',10,1,'Arial')");
 con.commit();
 stmt.executeUpdate("insert into DEMO10 values(11,'joi','Join Opposite Words','allow','disagree','3','1',10,1,'Arial')");
 con.commit();
 stmt.executeUpdate("insert into DEMO10 values(11,'joi','Join Opposite Words','appear','disapprove','4','2',10,1,'Arial')");
 con.commit();
 stmt.executeUpdate("insert into DEMO10 values(11,'joi','Join Opposite Words','approve','disadvantage','5','4',10,1,'Arial')");
 con.commit();
 stmt.executeUpdate("insert into course values(10,'A','DEMO',1,5,5,0,1)");
 con.commit();
 stmt.executeUpdate("insert into superuser values(10,'A','DEMO',10)");



 out.println("Setup Done!");

                 
         }
      catch (Exception e) {
                                 //     out.println("Problem !");
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



