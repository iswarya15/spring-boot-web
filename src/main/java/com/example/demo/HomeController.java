package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() { //homepage
        System.out.println("home");
        return "index";
    }

    @RequestMapping("add")
    public ModelAndView add(int num1, @RequestParam("num2") int num, ModelAndView mv) {
        int result = num1 + num;
        mv.addObject("result", result);
        mv.setViewName("result");

        return mv;
    }

    @RequestMapping("addStudent")
    public ModelAndView addStudent(int sid, String sname, ModelAndView mv) {

        Student student = new Student();
        student.setSid(sid);
        student.setSname(sname);

        mv.addObject("student", student);
        mv.setViewName("result");

        return mv;
    }
}
