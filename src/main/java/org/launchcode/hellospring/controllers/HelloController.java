package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
//    @PostMapping("hello")
    @RequestMapping(value="hello", method={RequestMethod.GET, RequestMethod.POST})
    public static String createMessage(@RequestParam String name, @RequestParam String language){
        if (language.equals("french")){
            return "Bonjour, " + name + "!";
        }else if(language.equals("german")) {
            return "Halo "+name+"!";
        }else if(language.equals("elvish")) {
            return "Suilad "+name+"!";
        }else if(language.equals("piglatin")) {
            return "Ohellay "+name+"!";
        }else if(language.equals("dothraki")) {
            return "M'ach "+name+"!";
        }else {
            return "Hello, " + name + "!";
        }
    }

    //Handles requests of the  /hello/LaunchCode
//    @GetMapping("hello/{name}/{language}")
//    public String helloWithPathParam(@PathVariable("name") String name, @PathVariable("language") String language){
//        if (language.equals("french")){
//            return "Bonjour, " + name + "!";
//        }else if(language.equals("german")) {
//            return "Halo "+name+"!";
//        }else if(language.equals("elvish")) {
//            return "Suilad "+name+"!";
//        }else if(language.equals("piglatin")) {
//            return "Ohellay "+name+"!";
//        }else if(language.equals("dothraki")) {
//            return "M'ach "+name+"!";
//        } else {
//            return "Hello, " + name + "!";
//        }
//    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body style='font-family: sans-serif, helvetica'>" +
                "<div>" +
                "<form action='hello'>" + //submit a request to /hello
                "<input type='text' name='name'/>" +
//                "<input type='text' name='language'/>"+
                "<select name='language'>" +
                "<option value='french'>French</option>" +
                "<option value='german'>German</option>"+
                "<option value='elvish'>Elvish</option>"+
                "<option value='piglatin'>PigLatin</option>"+
                "<option value='dothraki'>Dothraki</option>"+
                "</select>"+
                "<input type='submit' style='background-color: blue; border:none; color: white' value='Greet Me!'/>" +
                "</form>" +
                "</div>"+
                "</body" +
                "</html>";
    }


}
