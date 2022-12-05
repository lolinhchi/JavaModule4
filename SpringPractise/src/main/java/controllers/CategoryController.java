package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.CategoryBL;
import javaBeans.Category;

@Controller
public class CategoryController {
	
	@RequestMapping(path = "/them-loai", method = RequestMethod.GET)
	public static String getThemLoai(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("parents", CategoryBL.getParents());
		return "themLoaiSach";
	}
	@RequestMapping(path = "/them-loai", method = RequestMethod.POST)
	public static String ThemLoai(Category cat, Model model) {
		int them = CategoryBL.them(cat);
		model.addAttribute("parents", CategoryBL.getParents());
		if(them > 0) {
			model.addAttribute("msg", "Thêm thành công");
		}else {
			model.addAttribute("msg", "Xảy ra lỗi!");
		}
		return "themLoaiSach";
	}
	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public static String index(Model model) {
		model.addAttribute("parents", CategoryBL.getParents());
		model.addAttribute("children", CategoryBL.getParents());
		return "index";
	}
	
}
