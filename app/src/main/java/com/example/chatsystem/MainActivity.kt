package com.example.chatsystem

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 调用 CMake + C++ 版本号
        val version = NativeChatManager.getChatVersion()

        // 打印到控制台
        android.util.Log.d("CHAT", "版本号：$version")

        // 显示到界面
        findViewById<TextView>(R.id.versionText).text = "聊天室版本：$version"
    }
}