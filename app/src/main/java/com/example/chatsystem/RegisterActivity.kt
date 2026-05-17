package com.example.chatsystem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etAccount: EditText
    private lateinit var etPwd: EditText
    private lateinit var etConfirmPwd: EditText
    private lateinit var btnRegister: Button
    private lateinit var tvLoginTip: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        // 绑定控件
        etAccount = findViewById(R.id.et_account)
        etPwd = findViewById(R.id.et_pwd)
        etConfirmPwd = findViewById(R.id.et_confirm_pwd)
        btnRegister = findViewById(R.id.btn_register)
        tvLoginTip = findViewById(R.id.tv_login_tip)

        // 注册按钮点击
        btnRegister.setOnClickListener {
            doRegister()
        }

        // 已有账号跳登录
        tvLoginTip.setOnClickListener {
            finish()
        }
    }

    private fun doRegister() {
        val account = etAccount.text.toString().trim()
        val pwd = etPwd.text.toString().trim()
        val confirmPwd = etConfirmPwd.text.toString().trim()

        if (account.isEmpty()) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show()
            return
        }
        if (pwd.isEmpty()) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
            return
        }
        if (confirmPwd.isEmpty()) {
            Toast.makeText(this, "请确认密码", Toast.LENGTH_SHORT).show()
            return
        }
        if (pwd != confirmPwd) {
            Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show()
            return
        }

        val result = NativeChatManager.register(account, pwd)
        if (result == 0) {
            Toast.makeText(this, "注册成功，请登录", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "注册失败，账号已存在", Toast.LENGTH_SHORT).show()
        }
    }
}