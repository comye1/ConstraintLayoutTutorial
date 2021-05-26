package com.example.constraintlayouttutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Placeholder

class MainActivity : AppCompatActivity() {

    private lateinit var layout : ConstraintLayout
    private lateinit var placeHolder : Placeholder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout9)

        layout = findViewById(R.id.layout)
        placeHolder = findViewById(R.id.placeholder)
    }

    fun swapView(v : View) {
        TransitionManager.beginDelayedTransition(layout)
        placeHolder.setContentId(v.id)
    }
}