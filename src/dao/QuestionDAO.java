package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.QuestionBean;
import utils.DBConn;

public class QuestionDAO {
	
	public ArrayList<QuestionBean> selectAll(){
		ArrayList<QuestionBean> questions = new ArrayList<QuestionBean>();
		DBConn jdbc = DBConn.getInstance();
		jdbc.startConn();
		ResultSet rs = jdbc.query("select * from qiuwen_question");
		if(rs != null){
			try{
				while(rs.next()){
					QuestionBean question = new QuestionBean();
					question.setQid(rs.getInt("q_id"));
					question.setText(rs.getString("q_text"));
					question.setFollow(rs.getInt("follow"));
					question.setClickNum(rs.getInt("click_num"));
					question.setIsTop(rs.getInt("is_top"));
					question.setSubTime(rs.getString("sub_time"));
					questions.add(question);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		jdbc.close();
		return questions;
	}
	
	public boolean deleteQuestion(int id){
		DBConn jdbc=DBConn.getInstance();
		jdbc.startTrans();
		String sql1 = "delete from qiuwen_question where q_id = '"+String.valueOf(id)+"'";
		String sql2 = "delete from qiuwen_quesanswer where q_id = '"+String.valueOf(id)+"'";
		boolean rs1 = jdbc.execute(sql1);
		boolean rs2 = jdbc.execute(sql2);
		jdbc.commit();
		return rs1 && rs2;
	}
	
	public boolean topquestion(int id){
		DBConn jdbc=DBConn.getInstance();
		jdbc.startTrans();
		String sql = "update qiuwen_question set is_top = 1 where q_id = '"+String.valueOf(id)+"'";
		boolean rs = jdbc.execute(sql);
		jdbc.commit();
		return rs;
	}
	
	public boolean untopquestion(int id){
		DBConn jdbc=DBConn.getInstance();
		jdbc.startTrans();
		String sql = "update qiuwen_question set is_top = 0 where q_id = '"+String.valueOf(id)+"'";
		boolean rs = jdbc.execute(sql);
		jdbc.commit();
		return rs;
	}
	
	public ArrayList<QuestionBean> searchById(int id){
		ArrayList<QuestionBean> questions = new ArrayList<QuestionBean>();
		DBConn jdbc = DBConn.getInstance();
		jdbc.startConn();
		ResultSet rs = jdbc.query("select * from qiuwen_question where q_id = '"+String.valueOf(id)+"'");
		if(rs != null){
			try{
				while(rs.next()){
					QuestionBean question = new QuestionBean();
					question.setQid(rs.getInt("q_id"));
					question.setText(rs.getString("q_text"));
					question.setFollow(rs.getInt("follow"));
					question.setClickNum(rs.getInt("click_num"));
					question.setIsTop(rs.getInt("is_top"));
					question.setSubTime(rs.getString("sub_time"));
					questions.add(question);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		jdbc.close();
		return questions;
	}
	
	public ArrayList<QuestionBean> selectQuesOfUser(int uid) {
		ArrayList<QuestionBean> questions = new ArrayList<QuestionBean>();
		DBConn jdbc = DBConn.getInstance();
		jdbc.startConn();
		ResultSet rs = jdbc.query("select * from qiuwen_question natural join qiuwen_userques where u_id = "+ uid);
		if(rs != null){
			try{
				while(rs.next()){
					QuestionBean question = new QuestionBean();
					question.setQid(rs.getInt("q_id"));
					question.setText(rs.getString("q_text"));
					question.setFollow(rs.getInt("follow"));
					question.setClickNum(rs.getInt("click_num"));
					question.setIsTop(rs.getInt("is_top"));
					question.setSubTime(rs.getString("sub_time"));
					questions.add(question);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		jdbc.close();
		return questions;
	}
	
	public ResultSet insertQues(String text, String subTime){
		DBConn jdbc=DBConn.getInstance();
		jdbc.startTrans();
		String sql1 = "insert into qiuwen_question (q_text,follow,click_num,is_top,sub_time,category) values('"+text+"',0,0,0,'"+subTime+"','其他')";
		String sql2 = "select max(q_id) as qid from qiuwen_question";
		boolean rs = jdbc.execute(sql1);
		if(rs){
			ResultSet res = jdbc.query(sql2);
			jdbc.commit();
			return res;
		}else{
			jdbc.rollback();
			return null;
		}
	}

	public boolean insertItem(int uid , int qid){
		DBConn jdbc=DBConn.getInstance();
		jdbc.startTrans();
		boolean rs = jdbc.execute(" insert into qiuwen_userques values("+uid+","+qid+")");
		jdbc.commit();
		return rs;
	}

	public boolean updateText(int quesId,String text) {
		DBConn jdbc=DBConn.getInstance();
		jdbc.startTrans();
		boolean rs = jdbc.execute(" update qiuwen_question set q_text = '"+text+"' where q_id = "+quesId );
		jdbc.commit();
		return rs;
		
	}
	
	public boolean updateFollow(int qid){
		DBConn jdbc=DBConn.getInstance();
		jdbc.startTrans();
		boolean rs = jdbc.execute("update qiuwen_question set follow = follow+1 where q_id = "+qid);
		jdbc.commit();
		return rs;
	}
}