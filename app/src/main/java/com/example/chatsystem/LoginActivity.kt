package com.example.chatsystem

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val textview = findViewById<TextView>(R.id.register_text)
        textview.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show()
            //finish()
        }
        // 调用 CMake + C++ 版本号
        //val version = NativeChatManager.getChatVersion()

        // 打印到控制台
        //android.util.Log.d("CHAT", "版本号：$version")

        // 显示到界面
        //findViewById<TextView>(R.id.versionText).text = "聊天室版本：$version"
    }
}