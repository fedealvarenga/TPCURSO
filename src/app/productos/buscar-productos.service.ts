import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class BuscarProductosService {
  private url: string=environment.backProductosURL;
  constructor(private httpClient: HttpClient) { }

  public productos(page: number, size: number, categoria: string): Observable<any>{
        return this.httpClient.get<any>(this.url +  `page=${page}&size=${size}&categoria=${categoria}`);
  }
}
