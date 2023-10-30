package hu.paulolajos.dev.eshop.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.paulolajos.dev.eshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}