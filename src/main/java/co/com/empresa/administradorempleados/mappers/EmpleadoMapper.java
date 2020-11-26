/**
 * EmpleadoMapper
 * VERSION 1.0.0
 * 15/11/2020
 * COPYRIGHT © 2019 JUAN ACEVEDO
 **/
package co.com.empresa.administradorempleados.mappers;

import co.com.empresa.administradorempleados.dtos.EmpleadoDTO;
import co.com.empresa.administradorempleados.models.Empleado;
import org.mapstruct.Mapper;

import java.util.List;

/**
 *
 * @author Jacevedo
 */
@Mapper(componentModel = "spring")
public interface EmpleadoMapper {

    Empleado DTOtoEntity(EmpleadoDTO empleadoDTO);

    EmpleadoDTO EntityToDTO(Empleado empleado);

    List<EmpleadoDTO> EntityToDTO(List<Empleado> empleado);

}
