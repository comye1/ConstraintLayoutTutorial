package com.example.constraintlayouttutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Placeholder

class MainActivity : AppCompatActivity() {

    private lateinit var layout : ConstraintLayout
    private var constraintSetOld = ConstraintSet()
    private var constraintSetNew = ConstraintSet()
    private var altLayout : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_old)

        layout = findViewById(R.id.layout_main)

        constraintSetOld.clone(layout)
        constraintSetNew.clone(this, R.layout.layout_alt)
    }

    fun swapView(v : View) {
        var changeBounds = ChangeBounds()
        changeBounds.setInterpolator(OvershootInterpolator())

//        TransitionManager.beginDelayedTransition(layout)

        TransitionManager.beginDelayedTransition(layout, changeBounds)
        if(!altLayout) {
            constraintSetNew.applyTo(layout)
            altLayout = true
        }else{
            constraintSetOld.applyTo(layout)
            altLayout = false
        }
    }
}