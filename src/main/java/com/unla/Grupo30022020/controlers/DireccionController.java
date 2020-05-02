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
import com.unla.Grupo30022020.models.DireccionModel;
import com.unla.Grupo30022020.services.IDireccionService;


@Controller
@RequestMapping("/direccion")
public class DireccionController {
	
	@Autowired
	@Qualifier("direccionService")
	private IDireccionService direccionService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DIRECCION_INDEX);
		mAV.addObject("direcciones", direccionService.getAll());
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DIRECCION_NEW);
		mAV.addObject("direccion", new DireccionModel());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("direccion") DireccionModel direccionModel) {
		direccionService.Insert(direccionModel);
		return new RedirectView(ViewRouteHelper.DIRECCION_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DIRECCION_UPDATE);
		mAV.addObject("direccion", direccionService.findById(id));
		return mAV;
	}


	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("direccion") DireccionModel direccionModel) {
		direccionService.Update(direccionModel);
		return new RedirectView(ViewRouteHelper.DIRECCION_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		direccionService.remove(id);
		return new RedirectView(ViewRouteHelper.DIRECCION_ROOT);
	}
}
