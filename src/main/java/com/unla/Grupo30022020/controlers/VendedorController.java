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
import com.unla.Grupo30022020.models.VendedorModel;
import com.unla.Grupo30022020.services.IVendedorService;

@Controller
@RequestMapping("/vendedor")
public class VendedorController {
	
	@Autowired
    @Qualifier("vendedorService")
    private IVendedorService vendedorService;

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENDEDOR_INDEX);
        mAV.addObject("vendedores", vendedorService.getAll());
        return mAV;
    }

    @GetMapping("/new")
    public ModelAndView create() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENDEDOR_NEW);
        mAV.addObject("vendedor", new VendedorModel());
        return mAV;
    }

    @PostMapping("/create")
    public RedirectView create(@ModelAttribute("vendedor") VendedorModel vendedorModel){
        vendedorService.insert(vendedorModel);
        return new RedirectView(ViewRouteHelper.VENDEDOR_ROOT);
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") long id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENDEDOR_UPDATE);
        mAV.addObject("vendedor", vendedorService.findById(id));
        return mAV;
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("vendedor") VendedorModel vendedorModel) {
        vendedorService.update(vendedorModel);
        return new RedirectView(ViewRouteHelper.VENDEDOR_ROOT);
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") int id) {
        vendedorService.remove(id);
        return new RedirectView(ViewRouteHelper.VENDEDOR_ROOT);
    }
    
}
