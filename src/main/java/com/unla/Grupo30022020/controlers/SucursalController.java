package com.unla.Grupo30022020.controlers;

import com.unla.Grupo30022020.helpers.ViewRouteHelper;
import com.unla.Grupo30022020.models.LoteModel;
import com.unla.Grupo30022020.models.SucursalModel;
import com.unla.Grupo30022020.services.ILoteService;
import com.unla.Grupo30022020.services.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    @Qualifier("sucursalService")
    private ISucursalService sucursalService;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUCURSAL_INDEX);
        mAV.addObject("sucursal", sucursalService.getAll());
        return mAV;
    }

    @GetMapping("/new")
    public ModelAndView create() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUCURSAL_NEW);
        mAV.addObject("sucursal", new SucursalModel());
        return mAV;
    }

    @PostMapping("/create")
    public RedirectView create(@ModelAttribute("sucursal") SucursalModel sucursalModel) {
        sucursalService.insert(sucursalModel);
        return new RedirectView(ViewRouteHelper.SUCURSAL_ROOT);
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") long id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUCURSAL_UPDATE);
        mAV.addObject("sucursal", sucursalService.findById(id));
        return mAV;
    }


    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("sucursal") SucursalModel sucursalModel) {
        sucursalService.update(sucursalModel);
        return new RedirectView(ViewRouteHelper.SUCURSAL_ROOT);
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") long id) {
        sucursalService.remove(id);
        return new RedirectView(ViewRouteHelper.SUCURSAL_ROOT);
    }
}
