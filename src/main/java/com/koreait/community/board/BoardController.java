package com.koreait.community.board;

import com.koreait.community.Const;
import com.koreait.community.model.BoardDTO;
import com.koreait.community.model.BoardEntity;
import com.koreait.community.model.BoardPrevNextVO;
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
        BoardVO vo = service.detailBoard(dto);
        BoardPrevNextVO pnVo = service.selPrevNext(vo);
        model.addAttribute("data", vo);
        model.addAttribute("prev", pnVo);
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
    @GetMapping("/mod")
    public String mod(BoardDTO dto, Model model){
        model.addAttribute("data", service.detailBoard(dto));
        return "board/write";
    }
    @PostMapping("/mod")
    public String modProc(BoardEntity entity){
        int result = service.updBoard(entity);
        return "redirect:/board/detail?iboard=" + entity.getIboard();
    }
}
