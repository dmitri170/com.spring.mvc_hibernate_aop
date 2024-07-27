package com.spring.mvc_hibernate_aop.controller;

import com.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @RequestMapping("/")
    public String showAllEmployees(Model model){
        try {
            List<Employee> allEmployees=employeeDAO.getAllEmployees();
            model.addAttribute("allEmps",allEmployees);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "all-employees";
    }
}
