package com.mvvm.kotlin.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.kotlin.App
import com.mvvm.kotlin.Car
import javax.inject.Inject
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car: Car

    @Inject
    lateinit var car2: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    

        (application as App).getCompoment().inject(this)
        // Initialize App Center SDK
        AppCenter.start(application, "7d53d9e4-a0c3-422b-b604-975cb9b273ab",
                    Analytics::class.java, Crashes::class.java)


        car.drive()
        car2.drive()

    }
}
