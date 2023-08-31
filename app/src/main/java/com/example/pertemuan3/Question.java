package com.example.pertemuan3;

public class Question {
    private int resId;
    private boolean answer;
    public Question(int textId, boolean theanswer){
        resId = textId;
        answer = theanswer;
    }
    public int getResId(){
        return resId;
    }
    public void setResId(int Textid){
        resId = Textid;
    }
    public boolean getAnswer(){
        return answer;
    }
    public void setAnswer(boolean theanswer){
        answer = theanswer;
    }
}
