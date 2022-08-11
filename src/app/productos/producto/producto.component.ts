import { ChangeDetectionStrategy, Component, Input, OnInit } from '@angular/core';
import { ApiDolarService } from 'src/app/generales/dolar/api-dolar.service';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ProductoComponent implements OnInit {
  @Input() producto: any = null;


  constructor(
    private dolarService: ApiDolarService,
  ) {

  }

  ngOnInit(): void {
  }
  private funciondolar(){
    this.dolarService.precioActual().subscribe((dolar: any)=>{
      precioDolar: dolar.venta
    })
  }

}
