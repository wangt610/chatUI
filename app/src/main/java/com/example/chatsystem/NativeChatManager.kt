package com.example.chatsystem

object NativeChatManager {
    // 加载你的 so 库（和 CMake 里的库名一致）
    init {
        System.loadLibrary("chat_core")
    }

    // 注册接口
    external fun register(username: String, pwd: String): Int

    // 登录接口
    external fun login(username: String, pwd: String): Int
}