/**
 * EmpleadoService
 * VERSION 1.0.0
 * 15/11/2020
 * COPYRIGHT © 2019 JUAN ACEVEDO
 **/
package co.com.empresa.administradorempleados.services;

import co.com.empresa.administradorempleados.dtos.EmpleadoDTO;
import co.com.empresa.administradorempleados.mappers.EmpleadoMapper;
import co.com.empresa.administradorempleados.models.Empleado;
import co.com.empresa.administradorempleados.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 * @author Jacevedo
 */
@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private EmpleadoMapper empleadoMapper;

    /**
     * Metodo que permite consultar todos los empleados.
     *
     * @return
     */
    public ResponseEntity consultarTodos(){
        return new ResponseEntity(empleadoMapper.EntityToDTO(empleadoRepository.findAll()), HttpStatus.OK);
    }

    /**
     * Metodo que permite consultar un empleado por tipo y numero de documento.
     *
     * @param tipoDocumento
     * @param documento
     * @return
     */
    public ResponseEntity consultar(String tipoDocumento, String documento){
        Empleado empleado = empleadoRepository.findByTipoDocumentoAndDocumento(tipoDocumento, documento);
        if(empleado != null) {
            return new ResponseEntity(empleadoMapper.EntityToDTO(empleado), HttpStatus.OK);
        }else {
            return new ResponseEntity("No se encontro un empleado con el tipo y número de documento ingresado.", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo para obtener empleado por id.
     *
     * @param id
     * @return
     */
    public ResponseEntity consultar(Long id){
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        if(empleado.isPresent()) {
            return new ResponseEntity(empleadoMapper.EntityToDTO(empleado.get()), HttpStatus.OK);
        }else {
            return new ResponseEntity("No se encontro un empleado con el tipo y número de documento ingresado.", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que permite registrar un nuevo empleado.
     *
     * @param empleadoDTO
     * @return
     */
    public ResponseEntity registrar(EmpleadoDTO empleadoDTO){
        Empleado empleado = empleadoRepository.save(empleadoMapper.DTOtoEntity(empleadoDTO));
        return new ResponseEntity(empleadoMapper.EntityToDTO(empleado), HttpStatus.OK);
    }
}
