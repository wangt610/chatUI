#include <jni.h>
#include <android/log.h>
#include "login/UserAPI.h"
#include "mysql/SQLiteManager.h"

// 在 JNI_OnLoad 里初始化（APP 启动时执行）
jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    SQLiteManager::getInstance().init(); // 初始化数据库
    return JNI_VERSION_1_6;
}
#define LOG_TAG "CHAT_JNI"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

extern "C" {

// 注册
JNIEXPORT jint JNICALL
Java_com_example_chatsystem_NativeChatManager_register(JNIEnv *env, jobject /*thiz*/,
                                                       jstring username, jstring pwd) {
    const char *cUsername = env->GetStringUTFChars(username, nullptr);
    const char *cPwd = env->GetStringUTFChars(pwd, nullptr);

    int ret = user_register(cUsername, cPwd);
    LOGI("register ret = %d", ret);

    env->ReleaseStringUTFChars(username, cUsername);
    env->ReleaseStringUTFChars(pwd, cPwd);
    return ret;
}

// 登录
JNIEXPORT jint JNICALL
Java_com_example_chatsystem_NativeChatManager_login(JNIEnv *env, jobject /*thiz*/,
                                                    jstring username, jstring pwd) {
    const char *cUsername = env->GetStringUTFChars(username, nullptr);
    const char *cPwd = env->GetStringUTFChars(pwd, nullptr);

    int ret = user_login(cUsername, cPwd);
    LOGI("login ret = %d", ret);

    env->ReleaseStringUTFChars(username, cUsername);
    env->ReleaseStringUTFChars(pwd, cPwd);
    return ret;
}

} // extern "C"