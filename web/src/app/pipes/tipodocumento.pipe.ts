import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'tipodocumento'
})
export class TipodocumentoPipe implements PipeTransform {

  transform(tipoDoc: string): string {

    let descripcion: string;
    switch (tipoDoc) {
      case 'C':
        descripcion = 'CÉDULA CIUDADANÍA';
        break;
      case 'N':
        descripcion = 'NIT';
        break;
      case 'X':
        descripcion = 'NN';
        break;
      case 'P':
        descripcion = 'PASAPORTE';
        break;
      case 'E':
        descripcion = 'CÉDULA DE EXTRANJERÍA';
        break;
      case 'T':
        descripcion = 'TARJETA DE IDENTIDAD';
        break;
      case 'U':
        descripcion = 'REGISTRO CIVIL';
        break;
      case 'D':
        descripcion = 'CARNET DIPLOMÁTICO';
        break;
      default:
        descripcion = tipoDoc;
    }
    return descripcion;

  }



}
