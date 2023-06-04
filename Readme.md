# ReRollBag

---

The "ReRollBag" project is an Android application aimed at promoting sustainable consumption by encouraging the use of reusable bags instead of plastic bags.

## Submit File(.apk)

---

- [Google drive](https://drive.google.com/file/d/1w965UfvgRYcKQR3xsoH5PsC8_3_rSKnh/view?usp=sharing)
- [Firebase App Distribution](https://appdistribution.firebase.google.com/testerapps/1:1037483029667:android:67f9546ca4de9f235abb16/releases/700l1eoomabng?utm_source=firebase-console)


## Features

---

### User
- Custom login and social media account login for "ReRollBag"
- Renting of reusable bags through QR codes attached to the bags
- Returning the rented bags to designated locations using QR codes before the one-week rental period ends
- Promoting the use of reusable bags by allowing users to borrow and return bags without a deposit for rental.
- Users can apply for administrator status through the administrator application menu, receive an authentication number, and enter the number and management area to register as an administrator.


### Admin
- The administrator can register a rental location using the latitude and longitude of the location.
- The administrator can register a return location using the latitude and longitude of the location.
- The administrator can register a bag and create information to be inserted into the QR code.
- The administrator can process the return of a bag that the user has requested to return.

## Technologies Used

---

<img src="https://img.shields.io/badge/Kotlin-black?logo=Kotlin&logoColor=ColorName&style=ShieldStyle" /> <img src="https://img.shields.io/badge/AndroidStudio-black?logo=AndroidStudio&logoColor=ColorName&style=ShieldStyle" /> <img src="https://img.shields.io/badge/GitHub-black?logo=GitHub&logoColor=ColorName&style=ShieldStyle" /> <img src="https://img.shields.io/badge/JetpackCompose-black?logo=JetpackCompose&logoColor=ColorName&style=ShieldStyle" />

## Restrictions

---

- To test the project, you must log in with the ID: test@test.com and password: test1234 OR ID: test12@test.com and password: test1234.
- The rental and return location markers cannot be placed worldwide, so they currently exist at "latitude":37.2963, "longitude":127.0471 and "latitude":37.2753, "longitude":127.0413 near Ajou University.
- A QR code is required to proceed with the test, and the code will be included in the presentation video's PPT.
- Currently, the application has not applied localization, so the language is set to Korean only.
- Additionally, not all key values have been uploaded to Github, which may cause problems when building. Therefore, an apk file for testing purposes exists in the submit folder of the Github project. [Firebase App Distribution](https://appdistribution.firebase.google.com/testerapps/1:1037483029667:android:67f9546ca4de9f235abb16/releases/700l1eoomabng?utm_source=firebase-console)

## Application Design

---

- The design work is currently being done through Figma.
- [Figma Link](https://www.figma.com/file/wQyYTV6415CC2EetVwbDKi/Untitled?node-id=0-1)


## Credits
The ReRollBag project was developed by a team consisting of a backend developer, Donghwan Lee (Github ID: hwanld) , an Android developer, Heehoon Jeon (Github ID: citytexi), and a designer, Hyeonji Kim, and was created for the 2023 Google Solution Challenge.
