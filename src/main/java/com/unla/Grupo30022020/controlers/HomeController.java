package com.unla.Grupo30022020.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo30022020.helpers.ViewRouteHelper;
import com.unla.Grupo30022020.services.IPedidoService;
import com.unla.Grupo30022020.services.implementation.PedidoService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	//GET Example: SERVER/index
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);

		return modelAndView;
	}
	
	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView(ViewRouteHelper.ROUTE);
	}
	
	@GetMapping("/rankingproductosvendidos")
	public ModelAndView rankingproductosvendidos() {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.RANKINGPRODUCTOVENDIDO);
		mAV.addObject("rankingproductos", pedidoService.rankingproductosvendidos());
		return mAV;
	}
}