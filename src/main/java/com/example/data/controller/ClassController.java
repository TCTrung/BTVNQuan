package com.example.data.controller;


import com.example.data.model.Classroom;
import com.example.data.model.Student;
import com.example.data.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.Action;

@Controller
@RequestMapping("/api/class")
public class ClassController {
    @Autowired
    private IClassService classService;

    @GetMapping
    public ModelAndView findAll(){
        ModelAndView model = new ModelAndView("/classroom/list");
        model.addObject("class",classService.findAll());
        return model;
    }
@GetMapping("/create")
    public ModelAndView createGet(){
    ModelAndView modelAndView = new ModelAndView("/classroom/form");
    modelAndView.addObject("class", new Classroom());
    return modelAndView;
}
    @PostMapping("/create")
    public String createPost(@ModelAttribute Classroom classroom) {
        classService.save(classroom);
        return "redirect:/api/class";
    }
    @GetMapping("/update/{id}")
    public ModelAndView updateGet(@PathVariable Long id) {
        Classroom classroom = classService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/classroom/form");
        if (classroom != null) {
            modelAndView.addObject("class", classroom);
        } else {
            modelAndView.addObject("message", "Khong tim thay classroom tuong ung");
        }
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable Long id,
                             @ModelAttribute Classroom classroom) {
        Classroom detail = classService.findById(id);
        if (detail != null) {
            classroom.setId(id);
            classService.save(classroom);
        }
        return "redirect:/api/class";
    }


}
