package com.koreait.community.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService service;

    @GetMapping("/login")
    public void login(){}

    @GetMapping("/join")
    public void join(){}

    @GetMapping("/idChk/{uid}")
    @ResponseBody //리턴이 json이 됨 받을때는 requestbody
    public Map<String, Integer> idChk(@PathVariable String uid){ //주소값의 값을 뽑아냄
        System.out.println("uid : " + uid);
        Map<String, Integer> res = new HashMap<>();
        res.put("result", service.idChk(uid));
        return res;
    }
}
