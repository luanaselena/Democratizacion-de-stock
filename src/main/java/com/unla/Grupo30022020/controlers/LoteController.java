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
import com.unla.Grupo30022020.models.LoteModel;
import com.unla.Grupo30022020.services.ILoteService;
import com.unla.Grupo30022020.services.IProductoService;


@Controller
@RequestMapping("/lote")
public class LoteController {
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_INDEX);
		mAV.addObject("lotes", loteService.getAll());
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_NEW);
		mAV.addObject("lote", new LoteModel());
		mAV.addObject("productos", productoService.getAll());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("lote") LoteModel loteModel) {
		System.out.println("el id es:" + loteModel.getProducto().getId());
		loteService.Insert(loteModel);
		return new RedirectView(ViewRouteHelper.LOTE_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_UPDATE);
		mAV.addObject("lote", loteService.findById(id));
		mAV.addObject("productos", productoService.getAll());
		return mAV;
	}


	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("lote") LoteModel loteModel) {
		System.out.println("el id es:" + loteModel.getProducto().getId());
		loteService.Update(loteModel);
		
		return new RedirectView(ViewRouteHelper.LOTE_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		loteService.remove(id);
		return new RedirectView(ViewRouteHelper.LOTE_ROOT);
	}
}
