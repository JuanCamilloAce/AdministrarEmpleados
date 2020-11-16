import { Empleado } from './../modelos/empleado';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  api: string;

  constructor(private httpClient: HttpClient) {
    this.api = environment.apiUrl;
  }

  obtenerEmpleados(): Observable<any> {
    return this.httpClient.get<any>(this.api + '/empleados');
  }

  obtenerEmpleado(tipoDoc: string, doc: string): Observable<any> {
    return this.httpClient.get<any>(this.api + '/empleados/consultar?tipoDocumento=' + tipoDoc + '&documento=' + doc);
  }

  obtenerEmpleadoByID(id: number): Observable<any> {
    return this.httpClient.get<any>(this.api + '/empleados/consultarByID?id=' + id);
  }

  registrarEmpleado(empleado: Empleado): Observable<any> {
    return this.httpClient.post<any>(this.api + '/empleados/registrar', empleado);
  }
}
