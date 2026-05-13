#include <jni.h>
#include <string>
#include "chat_version.h"

// 这个函数名不需要你改，我保持通用
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_chatsystem_NativeChatManager_getChatVersion(
        JNIEnv *env,
        jobject /* this */)
{
    std::string version = get_chat_version();
    return env->NewStringUTF(version.c_str());
}