import { Injectable } from '@angular/core';
import { Http } from "@angular/http";
import { Response} from "@angular/http";
import 'rxjs/add/operator/map';
import {HttpClient} from "@angular/common/http";


@Injectable()
export class UploadFileService {
  private baseUrl: string = "http://localhost:8080/api";
  constructor(private httpClient : HttpClient, private http: Http){}

  getAllFiles(){
    return this.http.get(this.baseUrl+'/list-all-files').map(
      (res:Response) => res.json() );
  }

  sendFile(formData : FormData){
    this.httpClient.post(this.baseUrl+'/files', formData).subscribe(
      res => { console.log(res); }
    );
  }
}
