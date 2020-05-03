package com.unla.Grupo30022020.controlers;

import com.unla.Grupo30022020.helpers.ViewRouteHelper;
import com.unla.Grupo30022020.models.ProductoModel;
import com.unla.Grupo30022020.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    @Qualifier("productoService")
    private IProductoService productoService;

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_INDEX);
        mAV.addObject("productos", productoService.getAll());
        return mAV;
    }

    @GetMapping("/new")
    public ModelAndView create() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_NEW);
        mAV.addObject("producto", new ProductoModel());
        return mAV;
    }

    @PostMapping("/create")
    public RedirectView create(@ModelAttribute("producto") ProductoModel productoModel){
        productoService.insert(productoModel);
        return new RedirectView(ViewRouteHelper.PRODUCTO_ROOT);
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") long id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_UPDATE);
        mAV.addObject("producto", productoService.findById(id));
        return mAV;
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("producto") ProductoModel productoModel) {
        productoService.update(productoModel);
        return new RedirectView(ViewRouteHelper.PRODUCTO_ROOT);
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") int id) {
        productoService.remove(id);
        return new RedirectView(ViewRouteHelper.PRODUCTO_ROOT);
    }
}
