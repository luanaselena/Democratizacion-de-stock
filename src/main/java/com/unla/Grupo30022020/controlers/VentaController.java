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
import com.unla.Grupo30022020.models.VentaModel;
import com.unla.Grupo30022020.services.IVentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
    @Qualifier("ventaService")
    private IVentaService ventaService;

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENTA_INDEX);
        mAV.addObject("ventas", ventaService.getAll());
        return mAV;
    }

    @GetMapping("/new")
    public ModelAndView create() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENTA_NEW);
        mAV.addObject("venta", new VentaModel());
        return mAV;
    }

    @PostMapping("/create")
    public RedirectView create(@ModelAttribute("venta") VentaModel ventaModel){
        ventaService.insert(ventaModel);
        return new RedirectView(ViewRouteHelper.VENTA_ROOT);
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") long id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENTA_UPDATE);
        mAV.addObject("venta", ventaService.findById(id));
        return mAV;
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("venta") VentaModel ventaModel) {
        ventaService.update(ventaModel);
        return new RedirectView(ViewRouteHelper.VENTA_ROOT);
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") int id) {
        ventaService.remove(id);
        return new RedirectView(ViewRouteHelper.VENTA_ROOT);
    }
    
}
