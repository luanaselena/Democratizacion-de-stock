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

import com.unla.Grupo30022020.entities.Venta;
import com.unla.Grupo30022020.helpers.ViewRouteHelper;
import com.unla.Grupo30022020.models.SucursalModel;
import com.unla.Grupo30022020.models.VentaModel;
import com.unla.Grupo30022020.services.IClienteService;
import com.unla.Grupo30022020.services.IVendedorService;
import com.unla.Grupo30022020.services.IVentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {

	@Autowired
	@Qualifier("ventaService")
	private IVentaService ventaService;

	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;

	@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;

	@GetMapping("")
	public ModelAndView index() {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENTA_INDEX);
		mAV.addObject("ventas", ventaService.getAll());
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENTA_NEW);
		mAV.addObject("venta", new VentaModel());
		mAV.addObject("clientes", clienteService.getAll());
		mAV.addObject("vendedores", vendedorService.getAll());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("venta") VentaModel ventaModel) {
		System.out.println(ventaModel.getCliente().getId() + " " + ventaModel.getVendedorEncargado().getId() );
		ventaService.insert(ventaModel);
		return new RedirectView(ViewRouteHelper.VENTA_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENTA_UPDATE);
		
		mAV.addObject("venta", ventaService.findById(id));
		
		mAV.addObject("clientes", clienteService.getAll());
		
		mAV.addObject("vendedores", vendedorService.getAll());
		return mAV;
	}

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("venta") VentaModel ventaModel) {
		ventaService.update(ventaModel);

		return new RedirectView(ViewRouteHelper.VENTA_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		ventaService.remove(id);
		return new RedirectView(ViewRouteHelper.VENTA_ROOT);
	}
	
	//--------------------------------------------------------- Lista Pedidos --------------------------------

		//Borrar un Pedido de la lista de una sucursal

		@GetMapping("/{idVenta}/pedidoDelete/{idPedido}")
		public RedirectView deleteLote(@PathVariable("idVenta") long idVenta,@PathVariable("idPedido") long idPedido) {

			
			VentaModel venta = ventaService.EliminarPedido(idVenta,idPedido);

			ventaService.insert(venta);

			return new RedirectView("/venta/" + idVenta);
		}

}
