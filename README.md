# Calcolatrice

Applicazione Android di una calcolatrice semplice.

## Struttura

- `app/src/main/java`: codice Java dell'app
- `app/src/main/res`: layout, temi, stringhe e risorse Android
- `gradle/wrapper`: Gradle Wrapper per compilare senza installare Gradle a mano

## Build

Apri il progetto con Android Studio oppure compila da terminale:

```powershell
.\gradlew.bat assembleDebug
```

Se da terminale Gradle usa Java 25 e fallisce, imposta il JDK incluso in Android Studio prima della build:

```powershell
$env:JAVA_HOME='C:\Program Files\Android\Android Studio\jbr'
$env:Path="$env:JAVA_HOME\bin;$env:Path"
.\gradlew.bat assembleDebug
```
