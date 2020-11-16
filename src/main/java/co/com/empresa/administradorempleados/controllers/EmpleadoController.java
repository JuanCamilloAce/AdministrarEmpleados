/**
 * EmpleadoController
 * VERSION 1.0.0
 * 15/11/2020
 * COPYRIGHT © 2019 REGISTRO UNICO NACIONAL DE TRANSITO
 **/
package co.com.empresa.administradorempleados.controllers;

import co.com.empresa.administradorempleados.dtos.EmpleadoDTO;
import co.com.empresa.administradorempleados.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jacevedo
 */
@RestController
@RequestMapping("api/empleados")
public class EmpleadoController {

    @Autowired
    private Environment env;
    @Autowired
    private EmpleadoService empleadoService;

    /**
     * Servicio informativo.
     *
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity info() {
        return new ResponseEntity<>(env.getProperty("build.version"), HttpStatus.OK);
    }

    /**
     * Servicio para consultar todos los empleados.
     *
     * @return
     */
    @GetMapping
    public ResponseEntity consultar() {
        return empleadoService.consultarTodos();
    }

    /**
     * Servicio para consultar si existe un empleado.
     *
     * @param tipoDocumento
     * @param documento
     * @return
     */
    @GetMapping(value = "/consultar")
    public ResponseEntity consultar(@RequestParam String tipoDocumento, @RequestParam String documento) {
        return empleadoService.consultar(tipoDocumento, documento);
    }

    /**
     * Consultar empleado por id.
     * @param id
     * @return
     */
    @GetMapping(value = "/consultarByID")
    public ResponseEntity consultar(@RequestParam Long id) {
        return empleadoService.consultar(id);
    }
    /**
     * Servicio para registrar un nuevo empleado.
     *
     * @param empleado
     * @return
     */
    @PostMapping(value = "/registrar")
    public ResponseEntity registrar(@RequestBody EmpleadoDTO empleado){
        return empleadoService.registrar(empleado);
    }
}
