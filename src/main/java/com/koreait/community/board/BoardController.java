package com.koreait.community.board;

import com.koreait.community.Const;
import com.koreait.community.model.BoardDTO;
import com.koreait.community.model.BoardEntity;
import com.koreait.community.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping("/detail")
    public void detail(Model model, BoardDTO dto, HttpServletRequest req){
        String lastip = req.getHeader("X-FORWARDED-FOR");
        if(lastip == null){
            lastip = req.getRemoteAddr();
        }
        dto.setLastip(lastip);
        model.addAttribute("data", service.detailBoard(dto));
    }

    @GetMapping("/list/{icategory}")
    public String list(@PathVariable int icategory, BoardDTO dto, Model model){
        model.addAttribute(Const.ICATEGORY, icategory);
        model.addAttribute(Const.LIST, service.selBoardList(dto));
        dto.setIcategory(icategory);
        return "board/list";
    }
    @GetMapping("/write")
    public void write(){}

    @PostMapping("/write")
    public String writeProc(BoardEntity entity){
        int result = service.insBoard(entity);
        return "redirect:/board/list/" + entity.getIcategory();
    }
    @GetMapping("/del")
    public String del(BoardEntity entity){
        int result = service.delBoard(entity);
        return "redirect:/board/list/" + entity.getIcategory();
    }
}
