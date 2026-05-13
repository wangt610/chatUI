package com.example.chatsystem  // 改成你自己的包名

object NativeChatManager {
    init {
        System.loadLibrary("chatroom")
    }
    external fun getChatVersion(): String
}