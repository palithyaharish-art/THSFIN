# 📱 THS FINANCE - Android App Guide

Hello! You might see some instructions talking about `npm install` or `npm run dev`. **Ignore those!** Those are for websites. Since we built a **Native Android App**, we do things a little differently. 

Here is how to run your app, explained simply:

---

### 1. Getting the "Tools" (Instead of `npm install`)
In a website, you use `npm install`. In an Android app, we use something called **Gradle**.
*   **What it is:** Imagine your app is a LEGO set. Gradle is the person who goes to the store and buys all the missing pieces for you.
*   **How to do it:** When you open the project in **Android Studio**, look at the bottom right. You will see a bar moving that says "Syncing". 
*   **Action:** Just wait! Android Studio is "installing" everything automatically. If it stops, click the **Small Elephant Icon** at the top right to try again.

---

### 2. The "Secret Key" (Instead of Gemini API Key)
Websites use a Gemini Key. Your Android app uses a **Firebase Key** (a file called `google-services.json`).
*   **What it is:** Imagine your app wants to talk to a giant robot (the Database). The robot won't talk to anyone unless they show a "Secret ID Card."
*   **How to do it:** 
    1. Go to the [Firebase Website](https://console.firebase.google.com/).
    2. Download your "Secret ID Card" (the `google-services.json` file).
    3. Put that file into the **`app`** folder inside your project.
*   **Why:** This lets your app save loan details and photos safely.

---

### 3. Starting the App (Instead of `npm run dev`)
In a website, you type `npm run dev`. In Android, we use the **Green Play Button**.
*   **What it is:** This is like the "Start" button on a video game console.
*   **How to do it:** 
    1. Plug your Android phone into your computer with a cable.
    2. Look at the top of Android Studio for a **Green Triangle Button** (Play).
    3. Click it! The app will "build" and then magically appear on your phone screen.

---

### 📝 Summary for a 5th Grader:
1. **Wait for the Elephant:** Let the app download its pieces.
2. **Give it the ID Card:** Put the Firebase file in the `app` folder.
3. **Press Play:** Watch your app come to life on your phone!

**Note:** You must do this on a **Computer** (Laptop or Desktop) because Android Studio is too big to run on a phone!
