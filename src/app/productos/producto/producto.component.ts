import { ChangeDetectionStrategy, ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { map } from 'rxjs';
import { ApiDolarService } from 'src/app/generales/dolar/api-dolar.service';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class ProductoComponent implements OnInit {
  @Input() producto: any = null;
  cotizacion: number;
  precio={
    dolar: '',
    peso: 0
  };
  constructor(
    private dolarService: ApiDolarService,
    private cdr: ChangeDetectorRef,
  ) {
      this.cotizacion=0;
  }

  ngOnInit(): void {
    this.funciondolar();
  }
  private funciondolar(){
    this.dolarService.precioActual().subscribe((dolar: any)=>{
      this.cotizacion= Number(dolar.venta);
      this.calcularPrecio(this.producto);
      this.cdr.detectChanges();
    })
  }

  private calcularPrecio(prod:any){
    if(prod.tipoDeMoneda=="DOLAR"){
        this.precio.dolar=prod.precio;
        this.pasarAPesos(Number(prod.precio));
    }else {
      this.precio.peso=prod.precio;
      this.pasaADolares(Number(prod.precio));
    }//this.cdr.detectChanges();
  }

  private pasarAPesos(precioEnDolares: number){
    this.precio.peso= precioEnDolares *this.cotizacion;
    console.log(this.precio.dolar);
  }

  private pasaADolares(precioEnPesos: number){
    this.precio.dolar= (precioEnPesos / this.cotizacion).toFixed(2);
  }
}
