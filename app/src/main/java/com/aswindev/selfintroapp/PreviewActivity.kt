package com.aswindev.selfintroapp

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aswindev.selfintroapp.databinding.ActivityPreviewBinding
import java.io.Serializable

fun <T : Serializable> Intent.intentSerializable(key: String, clazz: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getSerializableExtra(key, clazz)
    } else {
        this.getSerializableExtra(key) as T?
    }
}

class PreviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPreviewBinding
    private lateinit var message: PreviewMessage
    private lateinit var messagePreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        displayMessage()
        setupButton()
    }

    private fun displayMessage() {
        message = intent.intentSerializable("Message", PreviewMessage::class.java) as PreviewMessage

        messagePreviewText = """
                Hi ${message.contactName},
                
                My name is ${message.myDisplayName} and I am a ${message.getFullJObDescription()}.
                
                I have a portfolio of apps to demonstrate my technical skills that I can show you on request.
                
                I am able to start a new position ${message.getAvailability()}.
                
                Please get in touch if you have any suitable roles for me.
                
                Thanks and Regards
            """.trimIndent()
        binding.textViewMessage.text = messagePreviewText
    }

    private fun setupButton() {
        binding.buttonSendMessage.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")  // Only SMS apps respond to this.
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }

}