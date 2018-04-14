import { Component, OnInit } from '@angular/core';
import {UploadFileService} from "../services/upload-file.service";
import {FileEntity} from "../file-entity";

@Component({
  selector: 'app-view-files',
  templateUrl: './view-files.component.html',
  styleUrls: ['./view-files.component.css']
})
export class ViewFilesComponent implements OnInit {
  allFilesInJson : Array<any>;
  constructor(private uploadFileService:UploadFileService) {
  }

  ngOnInit() {
    this.uploadFileService.getAllFiles().subscribe(
      value => {
        this.allFilesInJson = value;
      });
  }

  method(){
    console.log(this.allFilesInJson);
  }

}
