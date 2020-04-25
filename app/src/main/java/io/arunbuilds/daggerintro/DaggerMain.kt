package io.arunbuilds.daggerintro

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.arunbuilds.daggerintro.scopes.DaggerReusableComponent
import io.arunbuilds.daggerintro.scopes.DaggerScopedComponent
import io.arunbuilds.daggerintro.scopes.DaggerUnscopedComponent

class DaggerMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_main)

        val reusableComponent = DaggerReusableComponent.create()
        for (i in 1..100) {
            Log.d("Arun", reusableComponent.giveMeIncrement().toString())
        }

        val scopedComponent = DaggerScopedComponent.create()
        for (i in 1..100) {
            Log.d("Arun", scopedComponent.giveMeIncrement().toString())
        }

        val unscopedComponent = DaggerUnscopedComponent.create()
        for (i in 1..10) {
            Log.d("Arun", unscopedComponent.giveMeIncrement().toString())
        }


        val unscopedProvider = unscopedComponent.incrementProvider()
        val unscopedLazy = unscopedComponent.incrementLazy()

        for (i in 1..10) {
            Log.d("Unscoped Provider", unscopedProvider.get().toString())
        }
        for (i in 1..10) {
            Log.d("Unscoped Lazy", unscopedLazy.get().toString())
        }


    }

}