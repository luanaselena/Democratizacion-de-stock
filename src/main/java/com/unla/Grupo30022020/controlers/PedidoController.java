package com.unla.Grupo30022020.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.unla.Grupo30022020.helpers.ViewRouteHelper;
import com.unla.Grupo30022020.models.PedidoModel;
import com.unla.Grupo30022020.services.IPedidoService;
import com.unla.Grupo30022020.services.IProductoService;
import com.unla.Grupo30022020.services.ISucursalService;
import com.unla.Grupo30022020.services.IVentaService;




@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	
	@Autowired
	@Qualifier("ventaService")
	private IVentaService ventaService;
	
	@GetMapping("")
	public ModelAndView index() {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_INDEX);
		mAV.addObject("pedidos", pedidoService.getAll());
		mAV.addObject("sucursales", sucursalService.getAll());
		mAV.addObject("productos", sucursalService.getAll());
		return mAV;
	}
	
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_STOCK);
		mAV.addObject("pedido", new PedidoModel());
		mAV.addObject("ventas", ventaService.getAll());
		mAV.addObject("sucursales", sucursalService.getAll());
		mAV.addObject("productos", productoService.getAll());
		return mAV;
	}
	
	//-------------------------Generar pedido con stock
	@GetMapping("/create/")
	public ModelAndView create(
			@RequestParam(value = "idVenta", required = false) long idVenta,
			@RequestParam(value = "idSucursal", required = false) long idSucursal,
			@RequestParam(value = "idProducto", required = false) long idProducto,
			@RequestParam(value = "cantidad", required = false) int cantidad) {
		
		//Se intenta realizar el pedido, si el pedido fue satisfecho devuelve un true, si no lo fue devuelve false
		boolean bandera= ventaService.generarPedidoConStockPropio(ventaService.findById(idVenta),productoService.findById(idProducto)
				,sucursalService.findById(idSucursal), cantidad);
		
		ModelAndView mAV;
		if(bandera==true) {
		mAV = new ModelAndView(ViewRouteHelper.PEDIDO_INDEX);
		mAV.addObject("pedidos", pedidoService.getAll());
		mAV.addObject("sucursales", sucursalService.getAll());
		mAV.addObject("productos", sucursalService.getAll());
		}else {
			mAV = new ModelAndView(ViewRouteHelper.PEDIDO_NOSTOCK);
			
			//envio la sucursal que se intento usar para notificar cual es la que no tiene stock
			mAV.addObject("sucursalnostock",sucursalService.findById(idSucursal));
			mAV.addObject("pedido", new PedidoModel());
			mAV.addObject("ventas", ventaService.getAll());
			
			//----reemplazar estas sucursales por las sucursales cercanas---
			mAV.addObject("sucursales", sucursalService.getAll());
			
			mAV.addObject("productos", productoService.getAll());
		}
		
		return mAV;
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_UPDATE);
		mAV.addObject("pedido", pedidoService.findById(id));
		mAV.addObject("productos", productoService.getAll());
		return mAV;
		
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("pedido") PedidoModel pedidoModel) {
		
		pedidoService.update(pedidoModel);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id")long id) {
		pedidoService.remove(id);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
}
