package com.zhangyusen;

//学生类

public class Student{
    private String name;
    private String id;
    private String age;
    private String ban;
    private String address;

    static int num1 =0;//静态变量//本科生
    static int num2 =0;//静态变量//研究生
    static int num3 =0;//静态变量//总人数
    //构造无参方法
    public Student () {
        num3++;
    }

    //构造有参方法
    public Student (String name, String id, String age, String ban,String address) {  //构造一个学生方法
        this.name = name;//姓名
        this.id = id; //学号
        this.age = age; //年龄
        this.ban = ban; //班级
        this.address=address;//地址


        // set get方法
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {

        return age;
    }

    public void setAge(String age) {

        this.age = age;
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {

        this.ban = ban;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}







