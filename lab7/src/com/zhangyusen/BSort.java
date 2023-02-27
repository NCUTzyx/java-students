package com.zhangyusen;

import java.util.Comparator;
//定义Comparator比较器接口
public class BSort implements Comparator { //对班级进行排序

    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return s1.getBan().compareTo(s2.getBan());
    }

}

