package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFileController {

	@RequestMapping(path = "/upload-file")
	public String uploadFile() {
		return "uploadFile";
	}
	
	@RequestMapping(path = "/upload-file", method = RequestMethod.POST)
	public String upLoadFile(@RequestParam(name = "file") MultipartFile part, HttpServletRequest request, Model model) {
		String tapTin = part.getOriginalFilename();
		
		String thuMuc = request.getServletContext().getRealPath("/img/");
		String msg = "";
		try(OutputStream os = new FileOutputStream(thuMuc + tapTin)) {
			byte[] mb = part.getBytes();
			os.write(mb);
			msg = "Upload file thành công";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!msg.equals("")) {
			model.addAttribute("msg", msg);
		}else {
			model.addAttribute("msg", "Xảy ra lỗi");
		}
		model.addAttribute("tapTin", tapTin);
		return "uploadFile";
		
	}
}
