# 🎓 Student Guide: Building THS FINANCE

Welcome to the world of Fintech development! This guide explains how to connect your Android app to the "Cloud" (Firebase) and "Archives" (Google Sheets).

## 1. Firebase Setup (The Live Brain)
Firebase is like a live library. When an agent collects money, it tells Firebase, and the Owner sees it instantly.

1.  **Create Project:** Go to [Firebase Console](https://console.firebase.google.com/) and create "THS Finance".
2.  **Add Android App:** Enter `com.ths.finance`.
3.  **Download `google-services.json`:** This is your app's "ID Card". Put it in the `app/` folder of your project.
4.  **Enable Firestore:** Go to "Firestore Database" and click "Create Database". Start in **Test Mode**.
5.  **Enable Auth:** Go to "Authentication" and enable **Email/Password** or **Google Login**.

## 2. Google Sheets Setup (The Free Archive)
We use Sheets to save money because Firestore charges for storage.

1.  **Create Sheet:** Open Google Sheets and create one named "THS_Archive".
2.  **Apps Script:** Click `Extensions > Apps Script`.
3.  **Paste this code:**
    ```javascript
    function doPost(e) {
      var sheet = SpreadsheetApp.getActiveSpreadsheet().getActiveSheet();
      var data = JSON.parse(e.postData.contents);
      sheet.appendRow([new Date(), data.loanId, data.customerName, data.amount]);
      return ContentService.createTextOutput("Success");
    }
    ```
4.  **Deploy:** Click `Deploy > New Deployment`. Select `Web App`. Set "Who has access" to `Anyone`.
5.  **Copy URL:** Copy the Web App URL and put it in your app's `Constants.kt` file.

## 3. Google Drive Setup (Photo Storage)
1.  Create a folder in Google Drive.
2.  Copy the **Folder ID** from the URL.
3.  In your Apps Script, use `DriveApp.getFolderById("YOUR_ID")` to save photos.

## 4. Building the App
1.  Open **Android Studio**.
2.  Click `File > Open` and select this project folder.
3.  Wait for the "Gradle Sync" to finish (the elephant icon at the top).
4.  Connect your phone or start an Emulator (Android 15+).
5.  Click the **Green Play Button**.

---
**THS FINANCE** - Professional Microfinance Management.
