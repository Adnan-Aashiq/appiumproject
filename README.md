# Appium Mobile Automation Testing Project

This repository contains a Maven and TestNG-based Appium automation framework for testing mobile applications using an Android emulator (configured via Android Studio).

## Prerequisites

To run the project, ensure you have the following installed:

1. **[Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)** - Version 20 or higher.
2. **[Maven](https://maven.apache.org/download.cgi)** - For managing dependencies.
3. **[Android Studio](https://developer.android.com/studio)** - To set up and run the Android emulator.
4. **[Appium Server](https://appium.io/downloads.html)** - Installed and running.
5. **[Git](https://git-scm.com/downloads)** - To clone this repository.

## Project Setup

Follow these steps to set up and run the tests:

### Step 1: Clone the repository
```bash
git clone https://github.com/Adnan-Aashiq/AppiumProject-Mobile-Login-page-Testing.git
```
Goto the Project diretory like the below command that will let you go to the Project directory.
```bash
cd AppiumProject-Mobile-Login-page-Testing
```
### Step 2: Install dependencies
Run the following command in the Project diretory to download all required dependencies:

```bash
mvn clean install
```
### Step 3: Start the Appium Server
Ensure the Appium server is running before executing the tests. You can start it via:

Appium Desktop App [Appium Server GUI](https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4) or through Command line by using the below command:
```bash
appium
```
### Step 4: Configure the Android Emulator [Watch this video from 12:00 till last to onfigure the Android Emulator](https://www.youtube.com/watch?v=fqwE6GdwCe0&list=PLnNg6KqJ3HGjH1qaJ50FoUmXPGnXbQZu7&index=4)
Open Android Studio and create an emulator matching the desired device configuration.
Start the emulator and verify it is running correctly by using below command.
```bash
adb devices
```
if your Emulator is running you'll see a response like this.
```bash
List of devices attached
emulator-5554	device
```
### Step 5: Run the tests
Execute the following Maven command to run the TestNG tests:

```bash
mvn test
```
## Framework Highlights
* TestNG: Used for test management and execution.
* Maven: Manages dependencies and builds the project.
* Appium: Automates mobile application interactions on the emulator.
## Customization
* Update configuration files (e.g., appium.properties) to adjust settings such as the device name, platform version, and application path.
* Modify test scripts located in the src/test folder to extend or customize the test scenarios.
## Test Results
After execution, test results are displayed in the console. For additional reporting:

* Integrate a reporting library like ExtentReports or Allure.
* Generate detailed HTML or other format reports as needed.
