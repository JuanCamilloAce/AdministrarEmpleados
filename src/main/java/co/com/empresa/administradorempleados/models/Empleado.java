/**
 * Empleado
 * VERSION 1.0.0
 * 15/11/2020
 * COPYRIGHT © 2019 JUAN ACEVEDO
 **/
package co.com.empresa.administradorempleados.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Jacevedo
 */
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoDocumento;
    private String documento;
    private String fullName;
    private String function;
    private Long bossId;

}