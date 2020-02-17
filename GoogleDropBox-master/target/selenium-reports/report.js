$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/GoogleDropBox/GoogleDrive.feature");
formatter.feature({
  "line": 2,
  "name": "Upload Files in to Google Drive",
  "description": "",
  "id": "upload-files-in-to-google-drive",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "As a Registered your I will upload files in to Google Drive",
  "description": "",
  "id": "upload-files-in-to-google-drive;as-a-registered-your-i-will-upload-files-in-to-google-drive",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I Login to Google Drive account",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I Create a folder in google drive",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I upload multiple files in to google drive",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I logout from google account",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I should close google",
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleDriveSteps.i_Login_to_Google_account()"
});
formatter.result({
  "duration": 31620778321,
  "status": "passed"
});
formatter.match({
  "location": "GoogleDriveSteps.i_Create_a_folder_in_google_drive()"
});
formatter.result({
  "duration": 40839617831,
  "status": "passed"
});
formatter.match({
  "location": "GoogleDriveSteps.i_upload_multiple_files_in_to_google_drive()"
});
formatter.result({
  "duration": 31511740509,
  "status": "passed"
});
formatter.match({
  "location": "GoogleDriveSteps.i_logout_from_google_account()"
});
formatter.result({
  "duration": 1190751014,
  "status": "passed"
});
formatter.match({
  "location": "GoogleDriveSteps.i_should_close_google()"
});
formatter.result({
  "duration": 1457573474,
  "status": "passed"
});
});