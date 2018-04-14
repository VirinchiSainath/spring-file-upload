import { Component, OnInit } from '@angular/core';
import { UploadFileService} from "../services/upload-file.service";
import { HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  randomVar: any;

  private baseUrl: string = "http://localhost:8080/api";

  constructor(private uploadFileService:UploadFileService) {

  }

  ngOnInit() {
/*    this.uploadFileService.getAllFiles().subscribe(value => {
      console.log("sadfasd"+value);
      this.randomVar = value;
    });*/

    //console.log(this.uploadFileService.getAllFiles().subscribe());
  }

  hideUploadNewFileTab: boolean = false;
  hideViewUploadsTab: boolean = true;

  showOtherTab(){
    if(this.hideUploadNewFileTab === false){
      this.hideUploadNewFileTab = true;
      this.hideViewUploadsTab = false;
    }
    else{
      this.hideUploadNewFileTab = false;
      this.hideViewUploadsTab = true;
    }
  }

}
