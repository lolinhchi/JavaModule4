package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.AuthorBL;
import javaBeans.Author;

@Controller
public class AuthorController {

	@RequestMapping("/authors")
	public String authors(Model model) {
		model.addAttribute("authors", AuthorBL.docTatCa());
		return "authors";
	}
	
	/*
	 * @RequestMapping("/del-author") public String delAuthor(@RequestParam("id")
	 * int id) {
	 * 
	 * }
	 */
	@RequestMapping("/add-author")
	public String addAuthor() {
		return "addAuthor";
	}
	@RequestMapping(path = "/add-author", method = RequestMethod.POST)
	public String add(Model model, HttpServletRequest request) {
		String name = request.getParameter("txtName");
		Author au = new Author();
		au.setName(name);
		int row = AuthorBL.them(au);
		if(row > 0) {
			model.addAttribute("msg", "Thêm thành công");
		}else {
			model.addAttribute("msg","Xảy ra lỗi");
		}
		return "addAuthor";
	}
	
	@RequestMapping("/edit-author")
	public String edit(HttpServletRequest request,Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		Author au = AuthorBL.docTheoId(id);
		model.addAttribute("author", au);
		return "editAuthor";
	}
	@RequestMapping(path = "/edit-author", method = RequestMethod.POST)
	public String editAuthor(@RequestParam(name = "txtId", required = false) Integer id,@RequestParam(name = "txtName", required = false) String name, Model model) {
		Author au = AuthorBL.docTheoId(id);
		au.setName(name);
		int row = AuthorBL.sua(au);
		if(row > 0) {
			model.addAttribute("msg", "Sửa thành công");
		}else {
			model.addAttribute("msg","Xảy ra lỗi");
		}
		
		return "editAuthor";
	}
}
