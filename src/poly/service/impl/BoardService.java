package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.BoardDTO;
import poly.persistance.mapper.IBoardMapper;
import poly.service.IBoardService;

@Service("BoardService")
public class BoardService implements IBoardService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public List<BoardDTO> getBoardList() {
		// TODO Auto-generated method stub
		return boardMapper.getBoardList();
	}
	
	@Override
	public int insertPost(BoardDTO pDTO) {
		return boardMapper.insertPost(pDTO);
	}
	
	@Override
	public int updatePost(BoardDTO pDTO) {
		log.info("update 서비스 시작 ");
		return boardMapper.updatePost(pDTO);
	}
	
	@Resource(name="BoardMapper")
	IBoardMapper boardMapper;

	@Override
	public BoardDTO getBoardDetail(BoardDTO pDTO) {
		return boardMapper.getBoardDetail(pDTO);
	}

	@Override
	public int deletePost(BoardDTO rDTO) {
		return boardMapper.deletePost(rDTO);
	}
}
