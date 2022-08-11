import { Component, OnInit } from '@angular/core';
import { ApiDolarService } from 'src/app/generales/dolar/api-dolar.service';
import { BuscarProductosService } from '../buscar-productos.service';

@Component({
  templateUrl: './listado-productos.component.html',
  styleUrls: ['./listado-productos.component.css']
})
export class ListadoProductosComponent implements OnInit {
  busqueda: string|null;
  resultados=[];
  productos: Array<any> | undefined;
  page=0;
  size=3;
  categoria='AUDIO';
  isFirst=false;
  isLast=false;
  constructor(
    private dolarService: ApiDolarService,
    private buscarProductosService: BuscarProductosService,
  ) {
    this.busqueda="";
  }

  ngOnInit(): void {
    this.cargarProductos();
  }
  private funciondolar(){
    this.dolarService.precioActual().subscribe((dolar: any)=>{
      precioDolar: dolar.venta
    })
  }

  private cargarProductos(){
    this.buscarProductosService.productos(this.page, this.size,this.categoria).subscribe(
      data => {
        this.productos= data.content;
        this.isFirst=data.first;
        this.isLast=data.last;
        console.log(data);
      },
      err=>{
        console.log(err.error);
      }
    );
  }

  atras(): void{
    if(!this.isFirst){
        this.page--;
        this.cargarProductos();
    }
  }
  adelante(): void{
    if(!this.isLast){
      this.page++;
      this.cargarProductos();
    }
  }
}
