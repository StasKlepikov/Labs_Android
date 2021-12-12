package com.example.lab1

import android.app.Application
import io.realm.Realm
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import io.realm.mongodb.Credentials
import io.realm.mongodb.User
import io.realm.mongodb.sync.SyncConfiguration

lateinit var realm: Realm

class AppInit : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val appID : String = "android_labs-biqbi"
        val app = App(
            AppConfiguration.Builder(appID)
                .build())
        val credentials: Credentials = Credentials.anonymous()
        var user: User? = null

        app.loginAsync(credentials) {
            if (it.isSuccess) {
                println("Successfully authenticated anonymously.")
                user = app.currentUser()
            } else {
                println(it.error.toString())
            }

            val partitionValue: String = "123"
            val config = SyncConfiguration.Builder(user!!, partitionValue).allowWritesOnUiThread(true)
                .build()
            Realm.getInstanceAsync(config, object: Realm.Callback() {
                override fun onSuccess(_realm: Realm) {
                    realm = _realm
                }
            })
        }
    }
}