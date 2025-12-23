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
//  public String add(int num1, @RequestParam("num2") int num, Model model) {
//  public String add(HttpServletRequest req, HttpSession session) { //new page

//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = num1 + num;
//        model.addAttribute("result", result);
        mv.addObject("result", result);
        mv.setViewName("result");

//        session.setAttribute("result", result);

//        return "result";
        return mv;
    }
}
