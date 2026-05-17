package com.example.chatsystem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val textview = findViewById<TextView>(R.id.register_text)
        val loginbutton = findViewById<Button>(R.id.login_button)
        val useraccount = findViewById<EditText>(R.id.login_account)
        val userpwd = findViewById<EditText>(R.id.login_pwd)
        textview.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show()
            //finish()
        }
        loginbutton.setOnClickListener {
            val username = useraccount.text.toString().trim()
            val password = userpwd.text.toString().trim()
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 输入校验
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 调用 C++ 登录接口
            val result = NativeChatManager.login(username, password)

            // 根据返回结果处理逻辑
            if (result == 0) {
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
                // TODO: 跳转到主界面
                // startActivity(Intent(this, MainActivity::class.java))
                // finish()
            } else {
                Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show()
            }


        }
        // 调用 CMake + C++ 版本号
        //val version = NativeChatManager.getChatVersion()

        // 打印到控制台
        //android.util.Log.d("CHAT", "版本号：$version")

        // 显示到界面
        //findViewById<TextView>(R.id.versionText).text = "聊天室版本：$version"
    }
}