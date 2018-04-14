import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { AppComponent } from './app.component';
import { UploadNewFileComponent } from './upload-new-file/upload-new-file.component';
import { ViewFilesComponent } from './view-files/view-files.component';
import { MainComponent } from './main/main.component';
import {UploadFileService} from "./services/upload-file.service";
import { HttpModule} from "@angular/http";
import { FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AppComponent,
    UploadNewFileComponent,
    ViewFilesComponent,
    MainComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, HttpModule, FormsModule
  ],
  providers: [UploadFileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
