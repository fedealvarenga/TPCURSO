import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class HeaderComponent implements OnInit {
  busqueda: string;
  constructor(
    private router: Router
  ) {
    this.busqueda="";
  }

  ngOnInit(): void {

  }

  public irALogIn(){
    this.router.navigate(['/login']);
  }
  public buscar() {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.navigate(['/productos'], { queryParams: { busqueda: this.busqueda }});
  }
}
