import { Component, OnInit, Output, EventEmitter} from '@angular/core';
import { Observable } from 'rxjs';
import { UploadFileService } from 'src/app/services/upload-file.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-uploadfiles',
  templateUrl: './uploadfiles.component.html',
  styleUrls: ['./uploadfiles.component.css']
})
export class UploadfilesComponent implements OnInit {

  @Output() message = new EventEmitter<any>();

  messagehere = '';
  selectedFiles!: FileList;
  currentFile!: File;
  progress = 0;

  fileInfos!: Observable<any>;

  constructor(private uploadService: UploadFileService) { }


  ngOnInit() {
    this.fileInfos = this.uploadService.getFiles();
  }
  selectFile(event:any) {
    this.selectedFiles = event.target.files;
  }
  upload() {
    this.progress = 0;
  
    this.currentFile = this.selectedFiles.item(0)!;
    this.uploadService.upload(this.currentFile).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress = Math.round(100 * event.loaded / event.total!);
        } else if (event instanceof HttpResponse) {
          this.message.emit(event.body);
          this.messagehere = 'Uploaded.';
          this.fileInfos = this.uploadService.getFiles();
        }
      },
      err => {
        this.progress = 0;
        this.message.emit('');
        this.messagehere = 'Couldnot Upload!';
        this.currentFile = undefined!;
      });
  
    this.selectedFiles = undefined!;
  }

}
