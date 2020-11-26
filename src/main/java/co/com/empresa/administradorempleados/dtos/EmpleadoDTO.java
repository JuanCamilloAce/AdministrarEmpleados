/**
 * EmpleadoDTO
 * VERSION 1.0.0
 * 15/11/2020
 * COPYRIGHT © 2019 JUAN ACEVEDO
 **/
package co.com.empresa.administradorempleados.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author Jacevedo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO implements Serializable {

    private Long id;
    private String tipoDocumento;
    private String documento;
    private String fullName;
    private String function;
    private Long bossId;

}
