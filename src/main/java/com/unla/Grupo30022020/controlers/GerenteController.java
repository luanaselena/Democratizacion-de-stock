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
import com.unla.Grupo30022020.models.GerenteModel;
import com.unla.Grupo30022020.services.IGerenteService;

@Controller
@RequestMapping("/gerente")
public class GerenteController {
	
	@Autowired
	@Qualifier("gerenteService")
	private IGerenteService gerenteService;
	
	@GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.GERENTE_INDEX);
        mAV.addObject("gerentes", gerenteService.getAll());
        return mAV;
    }

    @GetMapping("/new")
    public ModelAndView create() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.GERENTE_NEW);
        mAV.addObject("gerente", new GerenteModel());
        return mAV;
    }

    @PostMapping("/create")
    public RedirectView create(@ModelAttribute("gerente") GerenteModel gerenteModel){
        gerenteService.insert(gerenteModel);
        return new RedirectView(ViewRouteHelper.GERENTE_ROOT);
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") long id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.GERENTE_UPDATE);
        mAV.addObject("gerente", gerenteService.findById(id));
        return mAV;
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("gerente") GerenteModel gerenteModel) {
        gerenteService.update(gerenteModel);
        return new RedirectView(ViewRouteHelper.GERENTE_ROOT);
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") int id) {
        gerenteService.remove(id);
        return new RedirectView(ViewRouteHelper.GERENTE_ROOT);
    }
}
