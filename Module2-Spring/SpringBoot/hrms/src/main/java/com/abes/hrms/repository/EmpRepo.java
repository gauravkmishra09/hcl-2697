package com.abes.hrms.repository;

import org.springframework.stereotype.Repository;



    @Repository
    public interface EmpRepo{
        double squareRoot(double d);
        String empData();

        public int add(int a , int b);

    }

