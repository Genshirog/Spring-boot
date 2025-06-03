package com.arc_based_solution.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@Controller
public class ApiController {
    private static final String user = "Genshirog";
    private static final String pass = "12345678";

    @GetMapping("/")
    public String index(){
        return "redirect:/index.html";
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestParam String username,@RequestParam String password, HttpSession session){
        if(user.equals(username) && pass.equals(password)){
         session.setAttribute("user", username);
         return ResponseEntity.ok(Collections.singletonMap("message","login successfully"));
     }
     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("message","login failed"));
    }

    @GetMapping("/main")
    public ResponseEntity<?> mainView(HttpSession session){
        String userCheck = (String) session.getAttribute("user");
        if (user.equals(userCheck)){
            return ResponseEntity.ok(Collections.singletonMap("message","Welcome to Main"));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("message","login failed"));
    }
}
