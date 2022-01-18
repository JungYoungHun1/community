package com.koreait.community.board.cmt;

import com.koreait.community.model.BoardCmtEntity;
import com.koreait.community.model.BoardCmtVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board/cmt")
public class BoardCmtController {
    @Autowired private BoardCmtService service;
    @PostMapping
    public Map<String, Integer> insBoardCmt(@RequestBody BoardCmtEntity entity){ //RequestBody - json으로 받아올때
        Map<String, Integer> result = new HashMap<>();
        result.put("result", service.insBoardCmt(entity));
        return result;
    }
    @GetMapping("/{iboard}")
    public List<BoardCmtVO> selBoardCmtList(@PathVariable int iboard){
        BoardCmtEntity entity = new BoardCmtEntity();
        entity.setIboard(iboard);
        return service.selBoardCmtList(iboard);
    }
    @DeleteMapping("/{icmt}")
    public Map<String, Integer> delBoardCmt(@PathVariable int icmt){
        Map<String, Integer> result = new HashMap<>();
        result.put("result", service.delBoardCmt(icmt));
        return result;
    }
    @PutMapping
    public Map<String, Integer> updBoardCmt(@RequestBody BoardCmtEntity entity){
        Map<String, Integer> result = new HashMap<>();
        result.put("result", service.updBoardCmt(entity));
        return result;
    }
}
