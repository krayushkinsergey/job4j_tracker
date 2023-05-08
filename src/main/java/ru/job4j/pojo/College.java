package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student krayushkinsa = new Student();
        krayushkinsa.setFullName("Краюшкин Сергей");
        krayushkinsa.setGroup("ЭВТ");
        krayushkinsa.setDateAdmission(new Date(2000, 9, 1));

        System.out.println("Студент " + krayushkinsa.getFullName()
                           + " зачислин в группу " + krayushkinsa.getGroup()
                           + " " + krayushkinsa.getDateAdmissionString());
    }
}
