/**
 * EmpleadoRepository
 * VERSION 1.0.0
 * 15/11/2020
 * COPYRIGHT © 2019 JUAN ACEVEDO
 **/
package co.com.empresa.administradorempleados.repositories;

import co.com.empresa.administradorempleados.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jacevedo
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Empleado findByTipoDocumentoAndDocumento(String tipoDocumento, String documento);

}
