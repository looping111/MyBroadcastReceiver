package com.example.mybroadcastreceiver

import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.Manifest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.mybroadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btnPermession?.setOnClickListener(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
    var requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            Toast.makeText(this, "Sms receiver permission diterima", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Sms receiver permission ditolak", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_permession -> requestPermissionLauncher.launch(Manifest.permission.RECEIVE_SMS)
        }
        
    }
}