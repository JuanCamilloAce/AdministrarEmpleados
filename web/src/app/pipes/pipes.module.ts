
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TipodocumentoPipe } from './tipodocumento.pipe';



@NgModule({
    declarations: [TipodocumentoPipe],
    imports: [
        FormsModule
    ],
    exports: [TipodocumentoPipe]
})
export class PipesModule { }
