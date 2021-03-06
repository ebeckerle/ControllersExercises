package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Fox!";
//    }

    // url now looks like /hello/goodbye
    @GetMapping("goodbye")
//    @ResponseBody
    public String goodbye(){
        return "Goodbye, Fox!, I love you!";
    }

    // create handler that handles request of the form /hello?name=LaunchCode
//    @GetMapping("hello")
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, "+ name +"!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
//    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
//        return "redirect:/DESIREDPATH";
    }

    @GetMapping("form")
//    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello'>" + //submit a request to /hello
                "<input type='text' name='name'/>" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>" +
                "</body" +
                "</html>";
    }
}
