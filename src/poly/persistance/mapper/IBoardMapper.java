package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.BoardDTO;

@Mapper("BoardMapper")
public interface IBoardMapper {

	List<BoardDTO> getBoardList();
	
	int insertPost(BoardDTO pDTO);

	int updatePost(BoardDTO pDTO);
	
	BoardDTO getBoardDetail(BoardDTO pDTO);

	int deletePost(BoardDTO rDTO);

}
