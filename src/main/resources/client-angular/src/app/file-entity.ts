export class FileEntity {

  private _id:number;
  private _content: String;
  private _fileName: string;
  private _fileAuthor: string;
  private _fileType: string;
  private _programToRun : string;


  constructor(id: number, file: String, fileName: string, fileAuthor: string, fileType: string, programToRun: string) {
    this._id = id;
    this._content = file;
    this._fileName = fileName;
    this._fileAuthor = fileAuthor;
    this._fileType = fileType;
    this._programToRun = programToRun;
  }

  get programToRun(): string {
    return this._programToRun;
  }

  set programToRun(value: string) {
    this._programToRun = value;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get file(): String {
    return this._content;
  }

  set file(value: String) {
    this._content = value;
  }

  get fileName(): string {
    return this._fileName;
  }

  set fileName(value: string) {
    this._fileName = value;
  }

  get fileAuthor(): string {
    return this._fileAuthor;
  }

  set fileAuthor(value: string) {
    this._fileAuthor = value;
  }

  get fileType(): string {
    return this._fileType;
  }

  set fileType(value: string) {
    this._fileType = value;
  }

}
