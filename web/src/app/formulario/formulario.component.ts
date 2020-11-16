import { EmpleadoService } from './../services/empleado.service';
import { ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Empleado } from '../modelos/empleado';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  @ViewChild('formRegistrar') formRegistrar: NgForm;

  empleado: Empleado;
  spinner = false;
  formularioEnviado = false;
  requiereTipoDocJefe = false;
  requiereDocJefe = false;
  mensaje = '';
  jefe: any = {};

  constructor(private router: Router, private empleadoService: EmpleadoService, private cdRef: ChangeDetectorRef) {
    this.empleado = new Empleado();
  }

  ngOnInit(): void {
  }

  regresarEstado() {
    if (!this.jefe.tipoDocumento) {
      this.requiereTipoDocJefe = false;
    }
    if (!this.jefe.documento) {
      this.requiereDocJefe = false;
    }
    this.cdRef.detectChanges();
  }

  registrar() {
    this.spinner = true;
    this.formularioEnviado = true;
    if (this.formRegistrar.invalid) {
      this.spinner = false;
      return;
    }
    if ((this.jefe.tipoDocumento && !this.jefe.documento)) {
      this.requiereDocJefe = true;
      this.spinner = false;
      this.cdRef.detectChanges();
      return;
    }
    if ((!this.jefe.tipoDocumento && this.jefe.documento)) {
      this.requiereTipoDocJefe = true;
      this.spinner = false;
      this.cdRef.detectChanges();
      return;
    }
    this.empleadoService.obtenerEmpleado(this.empleado.tipoDocumento, this.empleado.documento).subscribe(async data => {
      if (data) {
        console.log(data);
        this.spinner = false;
        this.mensaje = 'El empleado con el tipo y número de documento ingresados ya existe en el sistema.';
        return;
      }
    }, (error) => {
      console.log('El empleado no existe', error);
      if (this.jefe.tipoDocumento && this.jefe.documento) {
        this.empleadoService.obtenerEmpleado(this.jefe.tipoDocumento, this.jefe.documento).subscribe(async data => {
          if (data) {
            console.log(data);
            this.empleado.bossId = data.id;
            this.registrarEmpleado();
          }
        }, (errorS) => {
          console.log('El empleado no existe', errorS);
          this.spinner = false;
          this.mensaje = 'El empleado con el tipo y número de documento ingresados en campos de jefe no existe en el sistema.';
          return;
        });
      } else {
        this.registrarEmpleado();
      }
    });
  }

  registrarEmpleado(){
    this.empleadoService.registrarEmpleado(this.empleado).subscribe(async data => {
      this.router.navigate(['/']);
    }, (error) => {
      this.mensaje = 'Error al almacenar el empleado.' + error;
      return;
    });
  }
}
