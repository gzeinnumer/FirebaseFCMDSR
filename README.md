# FirebaseFCMDSR
 Work in DSR

 Tahap pertama ikuti sata Tools Firebase yang sudah disediakan oleh Android studio.

- [AndroidManifest.xml](https://github.com/gzeinnumer/FirebaseFCMDSR/blob/master/app/src/main/AndroidManifest.xml)
- app
  - helper
    -  [NotificationHelper.java](https://github.com/gzeinnumer/FirebaseFCMDSR/blob/master/app/src/main/java/com/gzeinnumer/firebasefcmdsr/helper/NotificationHelper.java)
  - service
    -  [FirebaseMessagingService.java](https://github.com/gzeinnumer/FirebaseFCMDSR/blob/master/app/src/main/java/com/gzeinnumer/firebasefcmdsr/service/FirebaseMessagingService.java)
  - ui
    -  [MainActivity.java](https://github.com/gzeinnumer/FirebaseFCMDSR/blob/master/app/src/main/java/com/gzeinnumer/firebasefcmdsr/ui/MainActivity.java)
  - [MyApp.java](https://github.com/gzeinnumer/FirebaseFCMDSR/blob/master/app/src/main/java/com/gzeinnumer/firebasefcmdsr/MyApp.java)
- [gradle](https://github.com/gzeinnumer/FirebaseFCMDSR/blob/master/app/build.gradle)

#

- AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest >

    <application
        android:name=".MyApp"

        <service
            android:name=".service.FirebaseMessagingService"
            android:enabled="true"
            android:exported="false">
            <intent-filter>
                <action android:name="com.google.firebase.MESSAGING_EVENT" />
            </intent-filter>
        </service>
    </application>
</manifest>
```

- MyApp
```java
public class MyApp  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Initial Firebase disini
        FirebaseApp.initializeApp(this);
    }
}
```

- MainActivity
```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...
        startService(new Intent(this, FirebaseMessagingService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(getClass().getSimpleName(), "onResume: "+FirebaseInstanceId.getInstance().getToken());

        ((TextView)findViewById(R.id.tv)).setText(FirebaseInstanceId.getInstance().getToken());
    }
}
```

- gradle
```xml
plugins {
    id 'com.android.application'
    id 'com.google.gms.google-services'
}

dependencies {
    implementation 'com.google.firebase:firebase-messaging:20.1.0'
}
```

---

```
Copyright 2021 M. Fadli Zein
```