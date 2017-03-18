package com.jointstarc.ssm.first.controller;

import com.jointstarc.ssm.first.dto.AppointExecutionDto;
import com.jointstarc.ssm.first.dto.ResultDto;
import com.jointstarc.ssm.first.entity.Book;
import com.jointstarc.ssm.first.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book") // url:/模块/资源/{id}/细分
public class BookController extends BaseController{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookService bookService;

	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		ModelAndView mav = new ModelAndView("/hello");
		String str = "这是返回给freemarker页面的值";
		List<Book> list = bookService.getList();
		mav.addObject("blist",list);
		mav.addObject("haha", str);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Book> list = bookService.getList();
		model.addAttribute("list", list);
		return "list";
	}

	// ajax json
	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET, produces = {
			"application/json; charset=utf-8"})
	@ResponseBody
	private String detail(@PathVariable("bookId") Long bookId, Model model) {
		if (bookId == null) {
			return "redirect:/book/list";
		}
		Book book = bookService.getById(bookId);
		if (book == null) {
			return "forward:/book/list";
		}
		model.addAttribute("book", book);
		//return bookId +"the detail";
		return book.toString();
	}

	@RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.GET, produces = {
			"application/json; charset=utf-8" })
	private ResultDto<AppointExecutionDto> appoint(@PathVariable("bookId") Long bookId, @Param("studentId") Long studentId) {
		if (studentId == null || studentId.equals("")) {
			return new ResultDto<>(false, "学号不能为空");
		}
		AppointExecutionDto execution = bookService.appoint(bookId, studentId);
		return new ResultDto<AppointExecutionDto>(true, execution);
	}


}
