package com.unla.Grupo30022020.controlers;

import com.unla.Grupo30022020.helpers.ViewRouteHelper;
import com.unla.Grupo30022020.models.DireccionModel;
import com.unla.Grupo30022020.models.LoteModel;
import com.unla.Grupo30022020.models.SucursalModel;
import com.unla.Grupo30022020.models.VendedorModel;
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
		SucursalModel s = new SucursalModel();
		s.setDireccion(new DireccionModel());
		mAV.addObject("sucursal", s);
		mAV.addObject("gerentes", gerenteService.getAll());
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
		mAV.addObject("vendedorAgregar", new VendedorModel());

		mAV.addObject("lotesLista", sucursalService.TraerLotesDisponibles());
		mAV.addObject("vendedoresLista", sucursalService.TraerVendedoresDisponibles());

		mAV.addObject("sucursal", sucursalService.findById(id));
		mAV.addObject("gerentes", gerenteService.getAll());
		mAV.addObject("direcciones", direccionService.getAll());
		
		return mAV;
	}
	
	@GetMapping("/cierre/{id}")
	public ModelAndView cierre(@PathVariable long id) {
		
		ModelAndView mAV = new ModelAndView();
		mAV.setViewName(ViewRouteHelper.SUCURSAL_CIERRE);
		mAV.addObject("vendedores", sucursalService.cierreDelMes(id));
		return mAV;
	}

	// vista de distancia
	@GetMapping("/distancia")
	public ModelAndView distancia() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUCURSAL_DISTANCIA);
		// mAV.addObject("sucursal", new SucursalModel());
		mAV.addObject("sucursales", sucursalService.getAll());
		return mAV;
	}

	// calcular la sucursal mas cercana
	@GetMapping("/cercania/")
	public ModelAndView calcularSucursalMasCercana(@RequestParam(value = "id", required = true) long id) {
		System.out.println("el id es: " + id);
		SucursalModel sucursalModel = sucursalService.findById(id);
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

	// --------------------------------------------------------- Lista Lotes
	// --------------------------------

	// Borrar un lote de la lista de una sucursal

	@GetMapping("/{idSucursal}/loteDelete/{idLote}")
	public RedirectView deleteLote(@PathVariable("idSucursal") long idSucursal, @PathVariable("idLote") long idLote) {

		System.out.println(idSucursal + " " + idLote);

		SucursalModel sucursal = sucursalService.EliminarLote(idSucursal, idLote);

		sucursalService.update(sucursal);

		return new RedirectView("/sucursal/" + idSucursal);
	}

	

	// Agregar un lote de la lista de una sucursal

	@PostMapping("/{idSucursal}/loteAdd")
	public RedirectView insertLote(@PathVariable("idSucursal") long idSucursal,
			@ModelAttribute("loteAgregar") LoteModel loteModel) {
		System.out.println("ID sucursal:" + idSucursal + " id lote: " + loteModel.getId());

		loteModel = loteService.findById(loteModel.getId());

		SucursalModel sucursal = sucursalService.findById(idSucursal);

		sucursal.getLotes().add(loteModel);
		sucursalService.insert(sucursal);

		return new RedirectView("/sucursal/" + idSucursal);
	}

	// --------------------------------------------------------- Lista Vendedores
	// --------------------------------

	// Borrar un Vendedor de la lista de una sucursal
	@GetMapping("/{idSucursal}/vendedorDelete/{idVendedor}")
	public RedirectView deleteVendedor(@PathVariable("idSucursal") long idSucursal,
			@PathVariable("idVendedor") long idVendedor) {

		SucursalModel sucursal = sucursalService.EliminarVendedor(idSucursal, idVendedor);

		sucursalService.insert(sucursal);

		return new RedirectView("/sucursal/" + idSucursal);
	}

	// Agregar un Vendedor de la lista de una sucursal

	@PostMapping("/{idSucursal}/vendedorAdd")
	public RedirectView insertVendedor(@PathVariable("idSucursal") long idSucursal,
			@ModelAttribute("vendedorAgregar") VendedorModel vendedorModel) {

		vendedorModel = vendedorService.findById(vendedorModel.getId());

		SucursalModel sucursal = sucursalService.findById(idSucursal);

		sucursal.getVendedores().add(vendedorModel);

		sucursalService.insert(sucursal);

		return new RedirectView("/sucursal/" + idSucursal);
	}
}
