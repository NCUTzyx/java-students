package com.zhangyusen;

//研究生类

//研究生类继承学生类
public class GraduateStudent extends Student{
    private String tutor;//导师
    private String direction;//研究方向

    public GraduateStudent(){
    }
    public GraduateStudent(String name,String id,String age,String ban,String address){
        super(name, id, age, ban,address);
    }

    public GraduateStudent(String tutor,String direction){
        this.tutor=tutor;
        this.direction=direction;
    }

    public String getTutor() {
        return tutor;
    }
    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
}

