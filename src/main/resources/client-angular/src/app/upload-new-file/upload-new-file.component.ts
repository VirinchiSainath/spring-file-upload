import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {UploadFileService} from "../services/upload-file.service";
import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-upload-new-file',
  templateUrl: './upload-new-file.component.html',
  styleUrls: ['./upload-new-file.component.css']
})
export class UploadNewFileComponent implements OnInit {

  fileUplaoded : File;

  constructor(private uploadFileService: UploadFileService, private httpClient: HttpClient) { }

  ngOnInit() {
  }

  saveThisFile(event){
    this.fileUplaoded = <File>event.target.files[0];
  }

  sendPostRequest(uploadFileForm){
    let postData = uploadFileForm.value;
    postData.content = this.fileUplaoded;
    console.log(postData);

    let formData = new FormData();
    formData.append('file',postData.content);
    formData.append('fileAuthor', postData.fileAuthor);
    formData.append('fileType',postData.fileType);
    formData.append('programToRun', postData.programToRun);

    this.uploadFileService.sendFile(formData);
  }

}
