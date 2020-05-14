package com.unla.Grupo30022020.controlers;

import com.unla.Grupo30022020.helpers.ViewRouteHelper;
import com.unla.Grupo30022020.models.LoteModel;
import com.unla.Grupo30022020.models.SucursalModel;
import com.unla.Grupo30022020.services.IDireccionService;
import com.unla.Grupo30022020.services.IGerenteService;
import com.unla.Grupo30022020.services.ILoteService;
import com.unla.Grupo30022020.services.ISucursalService;
import com.unla.Grupo30022020.services.IVendedorService;
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
    
    @Autowired
	@Qualifier("gerenteService")
	private IGerenteService gerenteService;
    
    @Autowired
	@Qualifier("direccionService")
	private IDireccionService direccionService;
    
    @Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
    
    @Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUCURSAL_INDEX);
        mAV.addObject("sucursales", sucursalService.getAll());
        return mAV;
    }

    @GetMapping("/new")
    public ModelAndView create() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUCURSAL_NEW);
        mAV.addObject("sucursal", new SucursalModel());
        mAV.addObject("gerentes", gerenteService.getAll());
        mAV.addObject("direcciones", direccionService.getAll());
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
        mAV.addObject("loteAgregar", new LoteModel());
        mAV.addObject("sucursal", sucursalService.findById(id));
        mAV.addObject("lotesLista", loteService.getAll());
        mAV.addObject("gerentes", gerenteService.getAll());
        mAV.addObject("direcciones", direccionService.getAll());
        return mAV;
    }
    
    @GetMapping("/cercania")
    public ModelAndView calcularSucursalMasCercana(@ModelAttribute("sucursal") SucursalModel sucursalModel){
    	ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUCURSAL_CERCANIA);
        mAV.addObject("sucursal", sucursalService.calcularSucursalMasCercana(sucursalModel));
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
    
    //Borrar un lote de la lista de una sucursal
    
    @PostMapping("/{idSucursal}/loteDelete")
    public RedirectView deleteLote(@PathVariable("idSucursal") long idSucursal,@ModelAttribute("lote") LoteModel loteModel) {
        sucursalService.remove(idSucursal);
        return new RedirectView(ViewRouteHelper.SUCURSAL_ROOT);
    }
    
    //Agregar un lote de la lista de una sucursal
    
    @PostMapping("/{idSucursal}/loteAdd")
    public RedirectView insertLote(@PathVariable("idSucursal") long idSucursal,@ModelAttribute("loteAgregar") LoteModel loteModel) {
       System.out.println("id sucursal:" + idSucursal + " id lote: " + loteModel.getId());
      /* loteModel = loteService.findById(loteModel.getId());
       SucursalModel sucursal = sucursalService.findById(idSucursal);
       sucursal.getLotes().add(loteModel);*/
    	
        return new RedirectView(ViewRouteHelper.SUCURSAL_ROOT);
    }
}
