package com.zhangyusen;

//本科生类

//本科生类继承学生类
public class Undergraduate extends Student{
    private String major;//专业

    public Undergraduate(){
    }

    public Undergraduate(String name,String id,String age,String ban,String address){
        super(name, id, age,ban,address);
    }

    public Undergraduate(String major){
        this.major=major;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

}

