package com.unla.Grupo30022020.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.unla.Grupo30022020.helpers.ViewRouteHelper;
import com.unla.Grupo30022020.models.PedidoModel;
import com.unla.Grupo30022020.services.IPedidoService;
import com.unla.Grupo30022020.services.IProductoService;




@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;

	
	@GetMapping("")
	public ModelAndView index() {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_INDEX);
		mAV.addObject("pedidos", pedidoService.getAll());
		return mAV;
	}
	
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_NEW);
		mAV.addObject("pedido",new PedidoModel());
		mAV.addObject("productos", productoService.getAll());
		return mAV;
	}
	
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("pedido") PedidoModel pedidoModel) {
		pedidoService.insert(pedidoModel);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_UPDATE);
		mAV.addObject("pedido", pedidoService.findById(id));
		mAV.addObject("productos", productoService.getAll());
		return mAV;
		
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("pedido") PedidoModel pedidoModel) {
		
		pedidoService.update(pedidoModel);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id")long id) {
		pedidoService.remove(id);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
}
