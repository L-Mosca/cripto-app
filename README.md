# Crypto App

I create this app to learn about [Ktor client](https://ktor.io/docs/welcome.html).

## Android studio version

```
Android Studio Ladybug Feature Drop | 2024.2.2
Build #AI-242.23726.103.2422.12816248, built on December 17, 2024
Runtime version: 21.0.4+-12508038-b607.1 amd64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
```

## App Android settings

```
compileSdk = 35
minSdk = 28
targetSdk = 35

kotlinOptions {
    jvmTarget = "11"
}
buildFeatures {
    compose = true
    buildConfig = true
}
```

## Main Technologies

* [Hilt - dependency injection](https://developer.android.com/training/dependency-injection/hilt-android)
* [Navigation](https://developer.android.com/develop/ui/compose/navigation)
* [Ktor](https://ktor.io/docs/welcome.html)
* [Coil](https://coil-kt.github.io/coil/)

## Features

### Splash Screen - presentation/splash/SplashScreen.kt

Show dark screen with app icon for two seconds, then show list screen.

### List Screen - presentation/list.ListScreen.kt

Show list of crypto coins. When user select any item, show coin detail screen.

### Coin Details - presentation/details/DetailScreen.kt

Show coin details (only name, description and image [for now]).

---

Last doc update 02/2025.