package entity;

public class AnswerBean {
	
	private int aid = -1;
	private String text = "";
	private String ansTime = "";
	
    public void setAid(int aid){
    	this.aid = aid;
    }
    
    public void setText(String text){
    	this.text = text;
    }
    
    public void setAnsTime(String ansTime){
    	this.ansTime = ansTime;
    }

	public int getAid(){
		return this.aid;
	}
	
	public String getText(){
		return this.text;
	}
	
	public String getAnsTime(){
		return this.ansTime;
	}
}