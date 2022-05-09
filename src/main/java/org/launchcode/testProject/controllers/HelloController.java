package org.launchcode.testProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@ResponseBody
public class HelloController {
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "HelloHello, Spring";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "GoodBye, Spring";
    }

    // handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello," + name + "!";
    }

    // handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello," + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +  // submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
