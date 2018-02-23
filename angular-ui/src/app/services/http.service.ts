import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import * as moment from 'moment/moment';

@Injectable()
export class HttpService {

  constructor(private httpClient: HttpClient) { }

  public get<T>(endPoint: string, incluirAutorizacion = true): Observable<T> {
    return this.httpClient.get<T>(this.buildUrl(endPoint), {headers: this.getRequestOptions(incluirAutorizacion)});
  }

  public post<T>(endPoint: string, body: any, incluirAutorizacion = true): Observable<T> {
    return this.httpClient.post<T>(this.buildUrl(endPoint), this.convertToJson(body), {headers: this.getRequestOptions(incluirAutorizacion)});
  }

  public put<T>(endPoint: string, body: any): Observable<T> {
    return this.httpClient.put<T>(this.buildUrl(endPoint), this.convertToJson(body), {headers: this.getRequestOptions()});
  }

  public patch<T>(endPoint: string, body: any): Observable<T> {
    return this.httpClient.patch<T>(this.buildUrl(endPoint), this.convertToJson(body), {headers: this.getRequestOptions()});
  }

  public delete<T>(endPoint: string): Observable<T> {
    return this.httpClient.delete<T>(this.buildUrl(endPoint));
  }

  private buildUrl(endPoint: string): string {
    return `http://localhost:8080/${endPoint}`;
  }

  private getRequestOptions(incluirAutorizacion = true): any {
    if (incluirAutorizacion) {
      return {
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem('cine-autorizacion')
      };
    } else {
      return {
        'Content-Type': 'application/json'
      };
    }
  }

  private convertToJson(body: any) {
    const temporalFunctionToJson = Date.prototype.toJSON;
    Date.prototype.toJSON = function() { return moment(this).format('YYYY-MM-DD'); };

    const jsonBody = JSON.stringify(body);

    Date.prototype.toJSON = temporalFunctionToJson;
    return jsonBody;
  }
}
