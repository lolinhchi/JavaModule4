package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(path = "/loai-sua")
	public String loaiSua2(@RequestParam(name = "maLoai", required = false) String ml, Model model) {
		List<LoaiSua> dsls ;
		if(ml == null) {
			dsls =  LoaiSuaBL.docTatCa();
		}else {
			dsls = new ArrayList<LoaiSua>();
			LoaiSua ls = LoaiSuaBL.docTheoMaLoai(ml);
			dsls.add(ls);
		}
		model.addAttribute("dsls", dsls);
		return "loai-sua";
	}
	
	@RequestMapping(path = "/loai-sua/{maLoai}")
	public String loaiSua(@PathVariable(name = "maLoai") String ml,  Model model) {
		LoaiSua ls = LoaiSuaBL.docTheoMaLoai(ml);
		List<LoaiSua> dsls = new ArrayList<>();
		dsls.add(ls);
		model.addAttribute("dsls", dsls);
		return "loai-sua";
	}
	
	@RequestMapping(path = "/them-loai-sua2", method = RequestMethod.POST)
	public String themLoaiSua(@RequestParam(name = "txtMaLoai") String ml, @RequestParam(name = "txtTenLoai") String tl, Model model)	 {
		LoaiSua ls = new LoaiSua(ml, tl);
		LoaiSuaBL.them(ls);
		model.addAttribute("tb", "Da them loai sua");
		return "them-loai-sua";
	}
	
	@RequestMapping(path = "/them-loai-sua3", method = RequestMethod.GET)
	public String themLoaiSua3() {
		return "them-loai-sua";
	}

	//bean
	@RequestMapping(path = "/them-loai-sua3", method = RequestMethod.POST)
	public String themLoaiSua(LoaiSua ls, Model model)	 {
		LoaiSuaBL.them(ls);
		model.addAttribute("tb", "Da them loai sua");
		return "them-loai-sua";
	}

}
