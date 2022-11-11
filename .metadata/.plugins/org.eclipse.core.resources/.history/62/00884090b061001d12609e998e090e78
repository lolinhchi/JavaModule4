package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.LoaiSuaBL;
import javaBeans.LoaiSua;

@Controller
public class LoaiSua2Controller {

	@RequestMapping(path = "/them-loai-sua", method = RequestMethod.GET)
	public String themLoaiSua() {
		return "them-loai-sua";
	}

	@RequestMapping(path = "/them-loai-sua", method = RequestMethod.POST)
	public String themLoaiSua(HttpServletRequest request, Model model)	 {
		String ml, tl;
		ml = request.getParameter("txtMaLoai");
		tl = request.getParameter("txtTenLoai");
		LoaiSua ls = new LoaiSua(ml, tl);
		LoaiSuaBL.them(ls);
		model.addAttribute("tb", "Da them loai sua");
		return "them-loai-sua";
	}

}
