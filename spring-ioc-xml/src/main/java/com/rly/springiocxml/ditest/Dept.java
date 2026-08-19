package com.rly.springiocxml.ditest;

import java.util.Arrays;
import java.util.List;

public class Dept {

    private String dname;

    private List<Emp> empList;

    public void info(){
        System.out.println("部门名称： "+dname);
        for (Emp emp : empList){
            System.out.println(emp.getEname());
            System.out.println(emp.getAge());
            System.out.println(Arrays.toString(emp.getLoves()));
        }
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }
}
