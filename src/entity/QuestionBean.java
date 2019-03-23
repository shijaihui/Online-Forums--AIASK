package entity;

public class QuestionBean {
	
	private int qid = -1;
	private String text = "";
	private int follow = 0;    //回答数
	private int clickNum = 0;    //点击量
	private int is_top = 0;
	private String subTime="";
	private String category="";
	
	public void setQid(int qid){
		this.qid = qid;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void setFollow(int follow){
		this.follow = follow;
	}
	
	public void setClickNum(int clickNum){
		this.clickNum = clickNum;
	}

	public void setIsTop(int isTop){
		this.is_top = isTop;
	}
	
	public void setSubTime(String subTime){
		this.subTime = subTime;
	}
	
	public void setCategory(String category){
		this.category = category;
	}

	public int getQid(){
		return this.qid;
	}
	
	public String getText(){
		return this.text;
	}
	
	public int getFollow(){
		return this.follow;
	}
	
	public int getClickNum(){
		return this.clickNum;
	}
	
	public int getIsTop(){
		return this.is_top;
	}
	
	public String getSubTime(){
		return this.subTime;
	}
	
	public String getCategory(){
		return this.category;
	}
}