#include "UserAPI.h"
#include "../mysql/SQLiteManager.h"

int user_register(const char* username, const char* password) {
    if (!username || !password) return -1;
    return SQLiteManager::getInstance().registerUser(username, password) ? 0 : -1;
}

int user_login(const char* username, const char* password) {
    if (!username || !password) return -1;
    return SQLiteManager::getInstance().loginCheck(username, password) ? 0 : -1;
}