import { async } from '@angular/core/testing';
import { EmpleadoService } from './../services/empleado.service';
import { Empleado } from './../modelos/empleado';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare var $: any;
@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  empleados: Empleado[] = [];
  jefe = '';

  constructor(private router: Router, private empleadoService: EmpleadoService) { }

  ngOnInit(): void {
    this.empleadoService.obtenerEmpleados().subscribe(async data => {
      this.empleados = data;
    }, (error) => {
      console.log('Fallo cliente consulta empleados', error);
    });
  }

  agregar() {
    this.router.navigate(['/registrar']);
  }

  consultarJefe(item: Empleado) {
    if (!item.bossId) {
      this.jefe = 'No posee un jefe asociado.';
      $('#modalJefe').modal({ backdrop: 'static', keyboard: false });
      return;
    }
    this.empleadoService.obtenerEmpleadoByID(item.bossId).subscribe(async data => {
      this.jefe = data.fullName;
      $('#modalJefe').modal({ backdrop: 'static', keyboard: false });
      return;
    }, (error) => {
      this.jefe = 'No se pudo consultar la información del jefe asociado.';
      $('#modalJefe').modal({ backdrop: 'static', keyboard: false });
      return;
     });

  }
}
