package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/loai-sua")
public class LoaiSuaController {

	@RequestMapping(path = "/them")//-->/loai-sua/them
	public String them(Model model) {
		model.addAttribute("tb", "Them loai sua"); // request.setAttribute("tb", "Them loai sua");
		return "loai-sua"; // request.getRequestDispatcher("/WEB-INF/views/loai-sua.jsp").forward(request,response);

	}

	@RequestMapping(path = "/tim")//-->/loai-sua/tim
	public String tim(Model model) {
		model.addAttribute("tb", "Tim loai sua");
		return "loai-sua";
	}

	@RequestMapping(path = "/xoa")//-->/loai-sua/xoa
	public String xoa(Model model) {
		model.addAttribute("tb", "Xoa loai sua");
		return "loai-sua";
	}
}
