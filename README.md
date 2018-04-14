# spring-file-upload

## Steps to run the project
1. Navigate to a folder when you want to clone the project and then `git clone https://github.com/VirinchiSainath/spring-file-upload.git`.
2. Open IDE of your choiced and import the project as an existing Maven project.
3. Locate `SpringFileUploadApplication.class` in `src\main\java\com\targetlabs\springfileupload`.
4. Run this class.

### Accessing API

#### via Postman
1. To get all files: GET `http://localhost:8080/api/list-all-files`.
2. To get file by id: GET `http://localhost:8080/api/files/{id}`.
3. To upload a file: POST `http://localhost:8080/api/files`.

#### via Client-Angular
The project also has a front end build on Angular.
1. From the folder where the repository is clone, enter the command `cd spring-file-upload\src\main\resources\client-angular`.
2. Now you have entered, the angular application folder. Install the dependencies using `npm install`.
3. Now start the application using `npm start`.
4. Open your favorite browser, and go to URL `http://localhost:4200`, to use the front end.

