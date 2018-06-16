package guitar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guitar.entity.Guitar;
import guitar.service.GuitarService;

@Controller
public class GuitarController {
	@Autowired
	@Qualifier("guitarService")
	private GuitarService guitarService;

	@RequestMapping(value="index")
	private String Index(HttpSession session){
		List<Guitar> guitarList=guitarService.getAll();
		session.setAttribute("guitarList", guitarList);
		return "index";
	}
	
	
}