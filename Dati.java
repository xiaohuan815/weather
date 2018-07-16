package cn.hnust;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import cn.hnust.DBConnection;

public class Dati extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=utf-8");
		String qa_id = request.getParameter("id");
		System.out.println("id:" + qa_id);
		
		try {
			DBConnection b =new DBConnection();
			String sql = "insert into qa(id,question,optA,optB,optC,optD,answer) values('1','1+1','0','1','2','3','C')";
			
			b.execute(sql);
			ResultSet rs = b.executeQuery("select * from qa");
			
			String id=" ";
			String question =" ";
			String optA=" ";
			String optB=" ";
			String optC=" ";
			String optD=" ";
			String answer=" ";
			
			
			int count=0;
			ArrayList<Question> list = new ArrayList<Question>();
			while(rs.next()){
				count++;
				id = rs.getString(1);
				question = rs.getString(2);
				optA = rs.getString(3);
			    optB = rs.getString(4);
			    optC = rs.getString(5);
			    optD = rs.getString(6);
			    answer = rs.getString(7);
				Question q = new Question("id","question","optA","optB","optC","optD","answer");
				list.add(q);
			}
			b.close();
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			
			JSONObject obj1 = new JSONObject();
			Question q1 =list.get(0);
			obj1.put("id", q1.id);
			obj1.put("question", q1.question);
			obj1.put("optA", q1.optA);
			obj1.put("optB", q1.optB);
			obj1.put("optC", q1.optC);
			obj1.put("optD", q1.optD);
			obj1.put("answer", q1.answer);
			obj.put("question1", obj1);
			
			JSONObject obj2 = new JSONObject();
			Question q2 =list.get(1);
			obj2.put("id", q2.id);
			obj2.put("question", q2.question);
			obj2.put("optA", q2.optA);
			obj2.put("optB", q2.optB);
			obj2.put("optC", q2.optC);
			obj2.put("optD", q2.optD);
			obj2.put("answer", q2.answer);
			obj.put("question2", obj2);
			
			
			System.out.println(obj.toString());
			out.print(obj.toString());
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void doSearch(String qa_id) {
		try {
			
			DBConnection db = new DBConnection();
			ResultSet rs = db.executeQuery("select * from qa where id = '" + qa_id +"'");
			
			String id = "";
			String question = "";
			String optA = "";
			String optB = "";
			String optC = "";
			String optD = "";
			String answer = "";
			
			while(rs.next()){
				id = rs.getString(1);
				question = rs.getString(2);
				optA = rs.getString(3);
			    optB = rs.getString(4);
			    optC = rs.getString(5);
			    optD = rs.getString(6);
			    answer = rs.getString(7);
			    
			}
			db.close();
			
			JSONObject obj = new JSONObject();
			
			obj.put("result", "ok");
			obj.put("tid", id);
			obj.put("question", question);
			obj.put("optA", optA);
			obj.put("optB", optB);
			obj.put("optC", optC);
			obj.put("optD", optD);
			obj.put("answer", answer);
			
			System.out.println(obj.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		doSearch("9");
	}

}
