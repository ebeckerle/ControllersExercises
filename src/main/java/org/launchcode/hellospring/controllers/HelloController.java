package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {


    // url now looks like /hello/goodbye
    @GetMapping("goodbye")

    public String goodbye(){
        return "Goodbye, Fox!, I love you!";
    }

    // create handler that handles request of the form /hello?name=LaunchCode
//    @GetMapping("hello")
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, "+ name +"!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
//        return "redirect:/DESIREDPATH";
    }

    @GetMapping("form")
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
