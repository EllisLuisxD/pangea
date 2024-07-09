package com.certus.spring.controller;

import com.certus.spring.models.Paquete;
import com.certus.spring.service.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/paquetes")
public class PaqueteController {

    private static String UPLOAD_DIR = "src/main/resources/static/uploads/";

    @Autowired
    private PaqueteService paqueteService;

    @GetMapping("/add")
    public String mostrarFormulario(Model model) {
        model.addAttribute("paquete", new Paquete());
        return "Administrador/controlpaquetes/addpaquete";
    }

    @PostMapping("/add")
    public String agregarPaquete(@RequestParam("nombre") String nombre,
                                 @RequestParam("descripcion") String descripcion,
                                 @RequestParam("precioOferta") double precioOferta,
                                 @RequestParam(value = "cantidadPersonas", required = false, defaultValue = "0") int cantidadPersonas,
                                 @RequestParam(value = "duracionDias", required = false, defaultValue = "0") int duracionDias,
                                 @RequestParam(value = "duracionNoches", required = false, defaultValue = "0") int duracionNoches,
                                 @RequestParam(value = "categoria", required = false, defaultValue = "") String categoria,
                                 @RequestParam(value = "precioRegular", required = false, defaultValue = "0.0") double precioRegular,
                                 @RequestParam(value = "descuento", required = false, defaultValue = "0.0") double descuento,
                                 @RequestParam(value = "diaVencimiento", required = false, defaultValue = "0") int diaVencimiento,
                                 @RequestParam(value = "mesVencimiento", required = false, defaultValue = "0") int mesVencimiento,
                                 @RequestParam(value = "anioVencimiento", required = false, defaultValue = "0") int anioVencimiento,
                                 @RequestParam("codigoEmbebido") String codigoEmbebido,
                                 @RequestParam("imagen") MultipartFile imagen,
                                 Model model) {

        String imagenPath = null;

        if (!imagen.isEmpty()) {
            try {
                Path uploadPath = Paths.get(UPLOAD_DIR);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                byte[] bytes = imagen.getBytes();
                Path path = uploadPath.resolve(imagen.getOriginalFilename());
                Files.write(path, bytes);

                imagenPath = "/uploads/" + imagen.getOriginalFilename() + "?v=" + System.currentTimeMillis();

            } catch (IOException e) {
                model.addAttribute("mensaje", "Error al cargar la imagen: " + e.getMessage());
                e.printStackTrace();
                return "Administrador/controlpaquetes/addpaquete";
            }
        }

        Paquete paquete = new Paquete(nombre, descripcion, cantidadPersonas, duracionDias, duracionNoches,
                                      categoria, precioOferta, precioRegular, descuento, diaVencimiento, mesVencimiento,
                                      anioVencimiento, codigoEmbebido, imagenPath);

        paqueteService.guardarPaquete(paquete);
        model.addAttribute("mensaje", "Paquete agregado exitosamente");
        return "Administrador/controlpaquetes/addpaquete";
    }

    @GetMapping("/listarPromociones")
    public String listarPromociones(Model model) {
        List<Paquete> paquetes = paqueteService.obtenerPaquetesOrdenados();
        model.addAttribute("paquetes", paquetes);
        return "Administrador/controlpaquetes/listarPromociones";
    }
    
    @GetMapping("/listarPromocionesLogueado")
    public String listarPromocionesLogueado(Model model) {
        List<Paquete> paquetes = paqueteService.obtenerPaquetesOrdenados();
        model.addAttribute("paquetes", paquetes);
        return "Administrador/controlpaquetes/listarPromocionesLogueado";
    }
    
    

    @GetMapping("/detalle/{id}")
    public String mostrarDetallePaquete(@PathVariable Long id, Model model) {
        Paquete paquete = paqueteService.obtenerPaquetePorId(id);
        List<Paquete> otrosPaquetes = paqueteService.obtenerPaquetesOrdenados();
        
        if (otrosPaquetes.size() > 3) {
            otrosPaquetes = otrosPaquetes.subList(0, 3);
        }

        model.addAttribute("paquete", paquete);
        model.addAttribute("paquetes", otrosPaquetes);
        return "detallePaquete";
    }
    
    @GetMapping("/detalleLogueado/{id}")
    public String mostrarDetallePaqueteLogueado(@PathVariable Long id, Model model) {
        Paquete paquete = paqueteService.obtenerPaquetePorId(id);
        List<Paquete> otrosPaquetes = paqueteService.obtenerPaquetesOrdenados();
        
        if (otrosPaquetes.size() > 3) {
            otrosPaquetes = otrosPaquetes.subList(0, 3);
        }

        model.addAttribute("paquete", paquete);
        model.addAttribute("paquetes", otrosPaquetes);
        return "detallePaqueteLogueado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPaquete(@PathVariable Long id) {
        paqueteService.eliminarPaquete(id);
        return "redirect:/paquetes/listarPromociones";
    }

    @PostMapping("/editar")
    @ResponseBody
    public String editarPaquete(@RequestParam("id") Long id,
                                @RequestParam("nombre") String nombre,
                                @RequestParam("descripcion") String descripcion,
                                @RequestParam("precioOferta") double precioOferta) {
        Paquete paqueteExistente = paqueteService.obtenerPaquetePorId(id);
        if (paqueteExistente != null) {
            paqueteExistente.setNombre(nombre);
            paqueteExistente.setDescripcion(descripcion);
            paqueteExistente.setPrecioOferta(precioOferta);
            paqueteService.guardarPaquete(paqueteExistente);
            return "Paquete actualizado exitosamente";
        } else {
            return "Paquete no encontrado";
        }
    }
}