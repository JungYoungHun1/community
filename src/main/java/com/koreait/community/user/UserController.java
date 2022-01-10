package com.koreait.community.user;

import com.koreait.community.Const;
import com.koreait.community.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/login")
    public void login() {}

    @PostMapping("/login")
    public String loginProc(UserEntity entity, RedirectAttributes reAttr) {
        int result = service.login(entity);
        if(result != 1) {
            switch(result) {
                case 0:
                    reAttr.addFlashAttribute(Const.MSG, Const.ERR_1); //세션이용, addattribut는 겟방식 이용
                    break;
                case 2:
                    reAttr.addFlashAttribute(Const.MSG, Const.ERR_2);
                    break;
                case 3:
                    reAttr.addFlashAttribute(Const.MSG, Const.ERR_3);
                    break;
            }
            reAttr.addFlashAttribute("id", entity.getUid());
            return "redirect:/user/login";
        }
        return "redirect:/board/list/1";
    }

    @GetMapping("/logout")
    public String logout(HttpSession hs){
        hs.invalidate();
        return "redirect:/user/login";
    }

    @GetMapping("/join")
    public void join() {}

    @PostMapping("/join")
    public String joinProc(UserEntity entity, RedirectAttributes reAttr) {
        int result = service.join(entity);
        if(result == 0){
            reAttr.addFlashAttribute(Const.MSG, Const.ERR_4);
            return "redirect:/user/join";
        }
        service.login(entity);
        return "redirect:/board/list/1";
    }

    @GetMapping("/idChk/{uid}")
    @ResponseBody
    public Map<String, Integer> idChk(@PathVariable String uid) {
        System.out.println("uid : " + uid);

        Map<String, Integer> res = new HashMap();
        res.put("result", service.idChk(uid));

        return res;
    }
}
