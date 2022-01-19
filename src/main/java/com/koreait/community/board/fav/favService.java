package com.koreait.community.board.fav;

import com.koreait.community.UserUtils;
import com.koreait.community.model.BoardFavEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class favService {
    @Autowired private favMapper mapper;
    @Autowired private UserUtils utils;

    public int insBoardFav(BoardFavEntity entity){
        entity.setIuser(utils.getLoginUserPk());
        return mapper.insBoardFav(entity);
    }

    public BoardFavEntity selBoardFav(int iboard){
        return mapper.selBoardFav(createBoardFavEntity(iboard));
    }

    public int delBoardFav(int iboard){
        return mapper.delBoardFav(createBoardFavEntity(iboard));
    }

    private BoardFavEntity createBoardFavEntity(int iboard){
        BoardFavEntity entity = new BoardFavEntity();
        entity.setIboard(iboard);
        entity.setIuser(utils.getLoginUserPk());
        return entity;
    }

}
