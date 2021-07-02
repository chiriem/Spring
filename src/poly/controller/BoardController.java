package poly.controller;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;

import poly.dto.BoardDTO;
import poly.service.IBoardService;
import poly.service.impl.BoardService;

@Controller
public class BoardController {
	
	//로거
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "BoardService")
	IBoardService boardService;
	
	@RequestMapping(value="board/boardList")
	public String BoardList(ModelMap model) {
		// 해당 매서드가 호출됨을 로그로 기록
		log.info("boardList start!!");
		
		List<BoardDTO> rList = boardService.getBoardList();
		
		if (rList == null) {
			rList = new ArrayList<>();
		}
		
		for (BoardDTO rDTO : rList) {
			log.info("postno : " + rDTO.getPostno());
		}
		
		model.addAttribute("rList", rList);
		
		return "/board/boardList";
	}
	
	@RequestMapping(value="board/newPost")
	public String newPost() {
		log.info("newpost start!!");
		return "/board/newPost";
	}
	
	@RequestMapping(value="board/doPost")
	public String doPost(HttpServletRequest request, ModelMap model) {
		
		// 임시 설정 아이디
		String id = "admin";
		
		// 요청으로부터 받은 바라미터를 변수에 저장
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		
		//게시자, 게시글 제목, 게시글 내용을 담아 서비스에 전송할 DTO객체 생성
		BoardDTO pDTO = new BoardDTO();
		
		pDTO.setRegid(id);
		pDTO.setPosttitle(post_title);
		pDTO.setPostcontent(post_content);
		
		int res = boardService.insertPost(pDTO);
		
		String msg;
		String url = "/board/boardList.do";
		
		if(res>0) {
			msg = "등록성공";
		}else {
			msg = "등록실패";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "/redirect";
	}
	
	@RequestMapping(value="board/editPost")
	public String editPost(HttpServletRequest request, ModelMap model) {
		log.info(this.getClass() + "---start");
		
		String postno=request.getParameter("no");
		log.info(postno);
		BoardDTO rDTO = new BoardDTO();
		rDTO.setPostno(postno);
		model.addAttribute("rDTO",rDTO);
		log.info(this.getClass() + "---end");
		return "/board/editPost";
	}	
	
	@RequestMapping(value="board/doEditPost")
	public String doEditPost(HttpServletRequest request, ModelMap model) {	
		// 요청으로부터 받은 바라미터를 변수에 저장
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		String post_no = request.getParameter("post_no");		

		log.info("에딧1");
		//게시자, 게시글 제목, 게시글 내용을 담아 서비스에 전송할 DTO객체 생성
		BoardDTO pDTO = new BoardDTO();

		pDTO.setPosttitle(post_title);
		pDTO.setPostcontent(post_content);
		pDTO.setPostno(post_no);
		log.info(pDTO.getPosttitle());
		log.info(pDTO.getPostcontent());
		log.info(pDTO.getPostno());
		int res = boardService.updatePost(pDTO);

		String msg;
		String url = "/board/boardList.do";
		
		if(res>0) {
			msg = "편집성공";
		}else {
			msg = "편집실패";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "/redirect";
	}
	
	@RequestMapping(value="board/boardDetail")
	public String boardDetail(HttpServletRequest request, ModelMap model) {
		log.info("boardDetail start!!");
		
		BoardDTO pDTO = new BoardDTO();
		String postno = request.getParameter("no");
		pDTO.setPostno(postno);
		
		BoardDTO rDTO = boardService.getBoardDetail(pDTO);
		
		if(rDTO==null) {
			model.addAttribute("msg", "존재하지 않는 게시물입니다.");
			model.addAttribute("url", "/board/boardList.do");
			return "/redirect";
		}
		
		model.addAttribute("rDTO", rDTO);
		
		return "/board/boardDetail";
	}
	
	@RequestMapping(value="board/deletePost")
	public String deletePost(HttpServletRequest request, ModelMap model) {
		log.info(this.getClass() + "---delete start");
		
		String postno=request.getParameter("no");
		log.info(postno);
		BoardDTO rDTO = new BoardDTO();
		rDTO.setPostno(postno);

		int res = boardService.deletePost(rDTO);
		
		String msg;
		String url = "/board/boardList.do";
		
		if(res>0) {
			msg = "삭제성공";
		}else {
			msg = "삭제실패";
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("url",url);
		log.info(this.getClass() + "---delete end");
		return "/redirect";
	}	
}
