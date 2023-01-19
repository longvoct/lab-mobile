package com.example.lab2_bai_6;

public class EmployeeFullTime extends Employee {

    @Override
    public double TinhLuong() {
        return 500;
    }

    @Override
    public String toString() {
        return super.toString() + " -->FullTime=" + TinhLuong();
    }
}