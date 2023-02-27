package com.zhangyusen;

import java.util.Comparator;
//定义Comparator比较器接口
public class ASort implements Comparator {//对年龄进行排序

    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return s1.getAge().compareTo(s2.getAge());
    }

}