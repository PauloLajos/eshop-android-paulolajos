package hu.paulolajos.dev.eshop.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import hu.paulolajos.dev.eshop.databinding.ActivitySplashBinding
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_splash)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        val delayMillis = 2000L

        Handler(Looper.getMainLooper()).postDelayed({
            handlerIntent()
        }, delayMillis)
    }

    private fun handlerIntent() {
        // Create a new coroutine from the lifecycleScope
        // since repeatOnLifecycle is a suspend function
        lifecycleScope.launch {
            // Suspend the coroutine until the lifecycle is DESTROYED.
            // repeatOnLifecycle launches the block in a new coroutine every time the
            // lifecycle is in the STARTED state (or above) and cancels it when it's STOPPED.
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Safely collect from locations when the lifecycle is STARTED
                // and stop collecting when the lifecycle is STOPPED
                //someLocationProvider.locations.collect {
                    // New location! Update the map
                //}
                startActivity(
                    Intent(
                        this@SplashActivity,
                        MainActivity::class.java,
                    )
                )

            }
            // Note: at this point, the lifecycle is DESTROYED!
        }
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }
}