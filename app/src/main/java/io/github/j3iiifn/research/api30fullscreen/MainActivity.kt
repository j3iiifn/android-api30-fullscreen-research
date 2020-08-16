package io.github.j3iiifn.research.api30fullscreen

import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickButtonStart(view: View) {
        window.insetsController?.apply {
            when (spinner_hide.selectedItemPosition) {
                0 -> hide(WindowInsets.Type.statusBars())
                1 -> hide(WindowInsets.Type.navigationBars())
                2 -> hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
            }
            systemBarsBehavior = when (spinner_behavior.selectedItemPosition) {
                0 -> WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_TOUCH
                1 -> WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE
                2 -> WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                else -> WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_TOUCH
            }
        }
    }

    fun onClickButtonShow(view: View) {
        window.insetsController?.apply {
            show(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
        }
    }
}