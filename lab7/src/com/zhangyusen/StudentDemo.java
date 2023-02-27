package com.zhangyusen;

//学生测试类

/*
  学生成绩管理系统
  学生：本科生、研究生
*/

//导包
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//学生测试类
public class StudentDemo {
    //主函数
    public static void main(String[] args) throws IOException{
        //创建学生集合对象
        ArrayList<Undergraduate> array1 = new ArrayList<Undergraduate>();//本科生集合
        ArrayList<GraduateStudent> array2 = new ArrayList<GraduateStudent>();//研究生集合
        ReadData1(array1);
        ReadData2(array2);
        while (true) {
            System.out.println("-----欢迎来到学生管理系统-----");
            System.out.println("1.增加学生");
            System.out.println("2.删除学生信息");
            System.out.println("3.修改学生信息");
            System.out.println("4.浏览学生信息及学生个数");
            System.out.println("5.学生排序");
            System.out.println("6.关于");
            System.out.println("7.退出系统");
            System.out.println("请输入数字");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    addStudent(array1,array2);
                    WriteData1(array1);//导入学生信息
                    WriteData2(array2);
                    break;
                case "2":
                    removeStudent(array1,array2);
                    WriteData1(array1);//导入学生信息
                    WriteData2(array2);
                    break;
                case "3":
                    modifyStudent(array1,array2);
                    WriteData1(array1);//导入学生信息
                    WriteData2(array2);
                    break;
                case "4":
                    browseStudent(array1,array2);
                    break;
                case "5":
                    menuStudent(array1,array2);
                    Back();
                    break;
                case "6":
                    About();
                    break;
                case "7":
                    System.out.println("谢谢使用");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误请重试");
                    break;
            }
        }
    }

    //添加学生方法
    public static void addStudent(ArrayList<Undergraduate> array1,ArrayList<GraduateStudent> array2) {
        System.out.println("请选择您要添加的学生类");
        System.out.println("1.本科生，2.研究生");
        Scanner sc1 = new Scanner(System.in);
        int choose = sc1.nextInt();
        if (choose == 1) {
            Scanner sc = new Scanner(System.in);
            String id;
            while (true) {
                System.out.println("请您输入学生学号：");
                id = sc.nextLine();
                boolean flag = repeatStudent(array1, array2, id);
                if (flag) {
                    System.out.println("你输入的学号已重复，请重新输入");
                } else {
                    break;
                }
            }
            System.out.println("请您输入学生姓名：");
            String name = sc.nextLine();
            System.out.println("请您输入学生年龄：");
            String age = sc.nextLine();
            System.out.println("请您输入学生班级：");
            String ban = sc.nextLine();
            System.out.println("请您输入学生地址：");
            String address = sc.nextLine();
            System.out.println("请您输入学生专业：");
            String major = sc.nextLine();
            //创建本科生学生对象
            Undergraduate s1 = new Undergraduate();
            s1.setId(id);
            s1.setName(name);
            s1.setAge(age);
            s1.setBan(ban);
            s1.setAddress(address);
            s1.setMajor(major);
            array1.add(s1);

            Undergraduate.num1++;
            System.out.println("学生信息添加成功");
            return;
        }else if (choose == 2){
            Scanner sc = new Scanner(System.in);
            String id;
            while (true) {
                System.out.println("请您输入学生学号：");
                id = sc.nextLine();
                boolean flag = repeatStudent(array1, array2, id);
                if (flag) {
                    System.out.println("你输入的学号已重复，请重新输入");
                } else {
                    break;
                }
            }
            System.out.println("请您输入学生姓名：");
            String name = sc.nextLine();
            System.out.println("请您输入学生年龄：");
            String age = sc.nextLine();
            System.out.println("请您输入学生班级：");
            String ban = sc.nextLine();
            System.out.println("请您输入学生地址:");
            String address = sc.nextLine();
            System.out.println("请您输入学生导师：");
            String tutor = sc.nextLine();
            System.out.println("请您输入学生研究方向：");
            String direction = sc.nextLine();
            ////创建研究生学生对象
            GraduateStudent s2 = new GraduateStudent();
            s2.setId(id);
            s2.setName(name);
            s2.setAge(age);
            s2.setBan(ban);
            s2.setAddress(address);
            s2.setTutor(tutor);
            s2.setDirection(direction);
            array2.add(s2);
            GraduateStudent.num2++;
            System.out.println("学生信息添加成功");
            return;
        }else{
            System.out.println("输入错误请重试");
            return;
        }

    }

    //删除学生方法
    public static void removeStudent(ArrayList<Undergraduate> array1,ArrayList<GraduateStudent> array2) {
        System.out.println("请选择学生类");
        System.out.println("1.本科生，2.研究生");
        Scanner sc1 = new Scanner(System.in);
        int choose = sc1.nextInt();
        Scanner sc = new Scanner(System.in);
        int k = -2;//设定两个变量
        int g = -2;
        if(choose==1) {  //删除本科生学生
            System.out.println("请您输入您要删除的学生的学号：");
            String id1 = sc.nextLine();
            for (int i = 0; i < array1.size(); i++) {
                Undergraduate s1 = array1.get(i);
                if (s1.getId().equals(id1)) {
                    k = i;
                    break;
                }
            }
            if(k==-2){
                System.out.println("该学号不存在，请重新输入");
                return;
            }else{
                Undergraduate.num1--;
                Student.num3--;
                array1.remove(k); //删除
                System.out.println("删除成功");
            }
        }else if(choose==2) { //删除研究生学生
            System.out.println("请您输入您要删除的学生的学号：");
            String id2 = sc.nextLine();
            for (int i = 0; i < array2.size(); i++) {
                GraduateStudent s2 = array2.get(i);
                if (s2.getId().equals(id2)) {
                    g = i;
                    break;
                }
            }
            if (g == -2) {
                System.out.println("该学号不存在，请重新输入");
                return;
            } else {
                Undergraduate.num2--;
                Student.num3--;
                array1.remove(g); //删除
                System.out.println("删除成功");
            }
        }
    }

    //修改学生方法
    public static void modifyStudent(ArrayList<Undergraduate> array1,ArrayList<GraduateStudent> array2) {
        int l = -1;
        int v = -1;
        System.out.println("请选择您要添加的学生类");
        System.out.println("1.本科生，2.研究生");
        Scanner sc2 = new Scanner(System.in);
        int choose =sc2.nextInt();
        Scanner sc = new Scanner(System.in);
        if(choose==1) { //修改本科生学生信息
            while (l == -1) {
                System.out.println("请您输入您要修改的学生学号");
                String id1 = sc.nextLine();
                for (int i = 0; i < array1.size(); i++) {
                    Student student = array1.get(i);
                    if (student.getId().equals(id1)) {
                        l = i;
                        break;
                    }
                    System.out.println("暂无学生信息,请重新输入");
                    break;
                }
            }
            System.out.println("有该学生信息，请再次输入该学生学号");
            String id = sc.nextLine();
            System.out.println("请您输入您要修改的学生姓名：");
            String name = sc.nextLine();
            System.out.println("请您输入您要修改的学生年龄：");
            String age = sc.nextLine();
            System.out.println("请您输入您要修改的学生班级：");
            String ban = sc.nextLine();
            System.out.println("请您输入您要修改的学生地址");
            String address = sc.nextLine();
            System.out.println("请您输入学生专业：");
            String major = sc.nextLine();
            Undergraduate s1 = new Undergraduate();
            s1.setId(id);
            s1.setAge(age);
            s1.setName(name);
            s1.setBan(ban);
            s1.setAddress(address);
            s1.setMajor(major);
            array1.set(l,s1);//修改
            Undergraduate.num1--;
            Student.num3--;
            System.out.println("修改成功");
        }else if(choose==2) {  //修改研究生学生信息
            while (v== -1) {
                System.out.println("请您输入您要修改的学生学号");
                String id2 = sc.nextLine();
                for (int i = 0; i < array1.size(); i++) {
                    Student student = array1.get(i);
                    if (student.getId().equals(id2)) {
                        v = i;
                        break;
                    }
                    System.out.println("暂无学生信息,请重新输入");
                    break;
                }
            }
            System.out.println("有该学生信息，请再次输入该学生学号");
            String id = sc.nextLine();
            System.out.println("请您输入您要修改的学生姓名：");
            String name = sc.nextLine();
            System.out.println("请您输入您要修改的学生年龄：");
            String age = sc.nextLine();
            System.out.println("请您输入您要修改的学生班级：");
            String ban = sc.nextLine();
            System.out.println("请您输入您要修改的学生地址");
            String address = sc.nextLine();
            System.out.println("请您输入学生导师姓名：");
            String tutor = sc.nextLine();
            System.out.println("请您输入学生研究方向：");
            String direction = sc.nextLine();
            GraduateStudent s2 = new GraduateStudent();
            s2.setId(id);
            s2.setAge(age);
            s2.setName(name);
            s2.setBan(ban);
            s2.setAddress(address);
            s2.setTutor(tutor);
            s2.setDirection(direction);
            array2.set(v, s2);//修改
            GraduateStudent.num2--;
            Student.num3--;
            System.out.println("修改成功");
        }else{
            System.out.println("输入错误请重新输入");
        }
    }

    //浏览学生方法
    public static void browseStudent(ArrayList<Undergraduate> array1,ArrayList<GraduateStudent> array2){
        System.out.println("请选择您要添加的学生类");
        System.out.println("1.本科生，2.研究生");
        Scanner sc2 = new Scanner(System.in);
        int choose =sc2.nextInt();
        if(array1.size()==0&&array2.size()==0){
            System.out.println("暂无学生信息，请先添加");
            return;
        }
        if(choose==1) { //浏览本科生学生
            System.out.println("学号\t姓名\t年龄\t班级\t地址\t专业");
            //遍历学生信息
            for (int i = 0; i < array1.size(); i++) {
                Undergraduate s1 = array1.get(i);

                System.out.println(s1.getId() + "\t" + s1.getName() + "\t" + s1.getAge() + "\t" + s1.getBan()+"\t"+s1.getAddress()+"\t"+s1.getMajor());
            }
            System.out.println("学生人数为：" + Undergraduate.num1);
            System.out.println("学生总人数为：" + Student.num3);
        }else if(choose==2){ //浏览研究生学生
            System.out.println("学号\t姓名\t年龄\t班级\t地址\t导师\t研究方向");
            //遍历学生信息
            for (int i = 0; i < array2.size(); i++) {
                GraduateStudent s2 = array2.get(i);
                System.out.println(s2.getId() + "\t" + s2.getName() + "\t" + s2.getAge() + "\t" + s2.getBan()+"\t"+s2.getAddress()+"\t"+s2.getTutor()+"\t"+ s2.getDirection());
            }
            System.out.println("学生人数为：" + GraduateStudent.num2);
            System.out.println("学生总人数为：" + Student.num3);
        }else{
            System.out.println("输入错误请重试");
            return;
        }
    }

    //判断学生学号是否重复
    public static boolean repeatStudent(ArrayList<Undergraduate> array1,ArrayList<GraduateStudent> array2,String id){
        boolean flag=false;
        for( int i=0;i<array1.size();i++){ //遍历本科生
            Undergraduate s1 = array1.get(i);
            if(s1.getId().equals(id)){
                flag=true;
                break;
            }
        }
        for( int i=0;i<array2.size();i++){ //遍历研究生
            GraduateStudent s2 = array2.get(i);
            if(s2.getId().equals(id)){
                flag=true;
                break;
            }
        }
        return flag;

    }

    //二级菜单方法
    public static void menuStudent(ArrayList<Undergraduate> array1,ArrayList<GraduateStudent> array2){
        while(true) {
            System.out.println("1.按学生学号排名");
            System.out.println("2.按学生年龄排名");
            System.out.println("3.按学生班级排名");
            System.out.println("4.返回");
            Scanner sc = new Scanner(System.in);
            System.out.println("请您输入数字");
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    ISortStudent(array1, array2);
                    break;
                case "2":
                    ASortStudent(array1, array2);
                    break;
                case "3":
                    BSortStudent(array1, array2);
                    break;
                case "4":
                    System.out.println("谢谢使用");
                    return;
                default:
                    System.out.println("输入错误请重试");
                    break;
            }
        }
    }

    //学号排序方法
    public static void ISortStudent(ArrayList<Undergraduate> array1,ArrayList<GraduateStudent> array2){
        System.out.println("请选择您要添加的学生类");
        System.out.println("1.本科生，2.研究生");
        Scanner sc2 = new Scanner(System.in);
        int choose =sc2.nextInt();
        if(array1.size()==0&&array2.size()==0){
            System.out.println("暂无学生信息");
            return;
        }
        //克隆副本排序
        List<Undergraduate> fu=(ArrayList<Undergraduate> ) array1.clone();
        List<GraduateStudent> hu=(ArrayList<GraduateStudent> ) array2.clone();
        //按照学号排序
        Collections.sort(fu,new ISort(){
            @Override
            public int compare(Object o1, Object o2) {
                return super.compare(o1, o2);
            }
        });
        Collections.sort(hu,new ISort(){
            @Override
            public int compare(Object o1, Object o2) {
                return super.compare(o1, o2);
            }
        });
        //打印排序
        if (choose==1) {
            System.out.println("学号\t\t姓名\t\t年龄\t\t班级\t\t地址\t\t专业");
            for (int i = 0; i < fu.size(); i++) {
                Undergraduate s1 = fu.get(i);
                System.out.println(s1.getId() + "\t\t" + s1.getName() + "\t\t" + s1.getAge() + "\t\t" + s1.getBan() + "\t\t" + s1.getAddress()+ "\t\t"+s1.getMajor());

            }
        }else if(choose==2){
            System.out.println("学号\t\t姓名\t\t年龄\t\t班级\t\t地址\t\t导师\t\t研究方向");
            for (int i = 0; i < hu.size(); i++) {
                GraduateStudent s2 = hu.get(i);
                System.out.println(s2.getId() + "\t\t" + s2.getName() + "\t\t" + s2.getAge() + "\t\t" + s2.getBan() + "\t\t" + s2.getAddress()+"\t\t"+s2.getTutor()+"\t\t"+s2.getDirection());

            }
        }else{
            System.out.println("输入错误，请重试");
            return;
        }
    }

    //年龄排序方法
    public static void ASortStudent(ArrayList<Undergraduate> array1,ArrayList<GraduateStudent> array2) {
        System.out.println("请选择您要添加的学生类");
        System.out.println("1.本科生，2.研究生");
        Scanner sc2 = new Scanner(System.in);
        int choose =sc2.nextInt();
        if(array1.size()==0&&array2.size()==0){
            System.out.println("暂无学生信息");
            return;
        }
        //克隆副本排序
        List<Undergraduate> fu=(ArrayList<Undergraduate> ) array1.clone();
        List<GraduateStudent> hu=(ArrayList<GraduateStudent> ) array2.clone();
        //按照年龄排序
        Collections.sort(fu,new ASort(){
            @Override
            public int compare(Object o1, Object o2) {
                return super.compare(o1, o2);
            }
        });
        Collections.sort(hu,new ASort(){
            @Override
            public int compare(Object o1, Object o2) {
                return super.compare(o1, o2);
            }
        });
        //打印排序
        if (choose==1) {
            System.out.println("学号\t\t姓名\t\t年龄\t\t班级\t\t地址\t\t专业");
            for (int i = 0; i < fu.size(); i++) {
                Undergraduate s1 = fu.get(i);
                System.out.println(s1.getId() + "\t\t" + s1.getName() + "\t\t" + s1.getAge() + "\t\t" + s1.getBan() + "\t\t" +s1.getAddress()+"\t\t"+s1.getMajor());

            }
        }else if(choose==2){
            System.out.println("学号\t\t姓名\t\t年龄\t\t班级\t\t地址\t\t导师\t\t研究方向");
            for (int i = 0; i < hu.size(); i++) {
                GraduateStudent s2 = hu.get(i);
                System.out.println(s2.getId() + "\t\t" + s2.getName() + "\t\t" + s2.getAge() + "\t\t" + s2.getBan() + "\t\t" + s2.getAddress()+ "\t\t"+s2.getTutor()+"\t\t"+s2.getDirection());

            }
        }else{
            System.out.println("输入错误，请重试");
            return;
        }

    }

    //班级排序方法
    public static void BSortStudent(ArrayList<Undergraduate> array1,ArrayList<GraduateStudent> array2) {
        System.out.println("请选择您要添加的学生类");
        System.out.println("1.本科生，2.研究生");
        Scanner sc2 = new Scanner(System.in);
        int choose =sc2.nextInt();
        if(array1.size()==0&&array2.size()==0){
            System.out.println("暂无学生信息");
            return;
        }
        //克隆副本排序
        List<Undergraduate> fu=(ArrayList<Undergraduate> ) array1.clone();
        List<GraduateStudent> hu=(ArrayList<GraduateStudent> ) array2.clone();
        //按照班级排序
        Collections.sort(fu,new BSort(){
            @Override
            public int compare(Object o1, Object o2) {
                return super.compare(o1, o2);
            }
        });
        Collections.sort(hu,new BSort(){
            @Override
            public int compare(Object o1, Object o2) {
                return super.compare(o1, o2);
            }
        });
        //打印班级排序
        if (choose==1) {
            System.out.println("学号\t\t姓名\t\t年龄\t\t班级\t\t省份\t\t城市\t\t街道\t\t门牌号\t\t专业");
            for (int i = 0; i < array1.size(); i++) {
                Undergraduate s1 = array1.get(i);
                System.out.println(s1.getId() + "\t\t" + s1.getName() + "\t\t" + s1.getAge() + "\t\t" + s1.getBan() + "\t\t" +s1.getAddress()+ "\t\t"+s1.getMajor());

            }
        }else if(choose==2){
            System.out.println("学号\t\t姓名\t\t年龄\t\t班级\t\t省份\t\t城市\t\t街道\t\t门牌号\t\t导师\t\t研究方向");
            for (int i = 0; i < array2.size(); i++) {
                GraduateStudent s2 = array2.get(i);
                System.out.println(s2.getId() + "\t\t" + s2.getName() + "\t\t" + s2.getAge() + "\t\t" + s2.getBan() + "\t\t" + s2.getAddress()+"\t\t"+s2.getTutor()+"\t\t"+s2.getDirection());
            }
        }else{
            System.out.println("输入错误，请重试");
            return;
        }
    }

    //返回主菜单
    public static void Back(){
        System.out.println("---------按任意键返回主菜单---------");
        Scanner sc = new Scanner(System.in);
        String b = sc.nextLine();
    }

    //关于
    public static void About(){
        System.out.println("程序名称：学生信息管理系统");
        System.out.println("版本：");
        System.out.println("完成时间：2021年6月19日");
        System.out.println("姓名：张宇森");
        System.out.println("学号：8008120063");
        System.out.println("班级：2003");
    }


    //***本科生
    //读取数据
    private static void ReadData1(ArrayList<Undergraduate> array1) throws IOException{
        //初次打开应用会创建文件
        File file= new File("本科生.txt");//文件名
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("初次启动初始化完成！");
        }
        //从文件中读取数据进集合
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine())!=null){
            String [] str = line.split(" ");
            Undergraduate s1 = new Undergraduate();
            s1.setId(str[0]);
            s1.setName(str[1]);
            s1.setAge(str[2]);
            s1.setBan(str[3]);
            s1.setAddress(str[4]);
            s1.setMajor(str[5]);
            array1.add(s1);
        }
        br.close();
    }
    //储存数据到文件中

    //写入数据
    private static void WriteData1(ArrayList<Undergraduate> array1) throws IOException{
        File file= new File("本科生.txt");//文件名
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //直接将数据全部存储到文件中，不用追加方法，也方便增删查改
        //如何信息量比较大就不适应
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        //将数据存储进文件
        for(int i=0;i<array1.size();i++){
            Undergraduate s1 = array1.get(i);
            bw.write(s1.getId(),0,s1.getId().length());//导出学号
            bw.write(' ');//间隔不同数据
            bw.write(s1.getName(),0,s1.getName().length());//导出姓名
            bw.write(' ');//间隔不同数据
            bw.write(s1.getAge(),0,s1.getAge().length());//导出年龄
            bw.write(' ');//间隔不同数据
            bw.write(s1.getBan(),0,s1.getBan().length());//导出班级
            bw.write(' ');//间隔不同数据
            bw.write(s1.getAddress(),0,s1.getAddress().length());//导出所在地
            bw.write(' ');//间隔不同数据
            bw.write(s1.getMajor(),0,s1.getMajor().length());//导出专业
            bw.write(' ');//间隔不同数据
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }


    //***研究生
    //读取数据
    private static void ReadData2(ArrayList<GraduateStudent> array2) throws IOException{
        //初次打开应用会创建文件
        File file= new File("研究生.txt");//文件名
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("初次启动初始化完成！");
        }
        //从文件中读取数据进集合
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine())!=null){
            String [] str = line.split(" ");
            GraduateStudent s2 = new GraduateStudent();
            s2.setId(str[0]);
            s2.setName(str[1]);
            s2.setAge(str[2]);
            s2.setBan(str[3]);
            s2.setAddress(str[4]);
            s2.setTutor(str[5]);
            s2.setDirection(str[6]);
            array2.add(s2);
        }
        br.close();
    }

    //储存数据到文件中
    //写入数据
    private static void WriteData2(ArrayList<GraduateStudent> array2) throws IOException{
        File file= new File("研究生.txt");//文件名
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //直接将数据全部存储到文件中，不用追加方法，也方便增删查改
        //如何信息量比较大就不适应
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        //将数据存储进文件
        for(int i=0;i<array2.size();i++){
            GraduateStudent s2 = array2.get(i);
            bw.write(s2.getId(),0,s2.getId().length());//导出学号
            bw.write(' ');//间隔不同数据
            bw.write(s2.getName(),0,s2.getName().length());//导出姓名
            bw.write(' ');//间隔不同数据
            bw.write(s2.getAge(),0,s2.getAge().length());//导出年龄
            bw.write(' ');//间隔不同数据
            bw.write(s2.getBan(),0,s2.getBan().length());//导出班级
            bw.write(' ');//间隔不同数据
            bw.write(s2.getAddress(),0,s2.getAddress().length());//导出所在地
            bw.write(' ');//间隔不同数据
            bw.write(s2.getTutor(),0,s2.getTutor().length());//导出导师
            bw.write(' ');//间隔不同数据
            bw.write(s2.getDirection(),0,s2.getDirection().length());//导出研究方向
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

}







