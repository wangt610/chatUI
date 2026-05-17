#include "SQLiteManager.h"

SQLiteManager& SQLiteManager::getInstance() {
    static SQLiteManager instance;
    return instance;
}

bool SQLiteManager::init() {
    return true;
}

bool SQLiteManager::registerUser(const char* username, const char* password) {
    if (!username || !password) return false;
    std::string user = username;
    if (m_users.find(user) != m_users.end()) {
        return false; // 已存在
    }
    m_users[user] = password;
    return true;
}

bool SQLiteManager::loginCheck(const char* username, const char* password) {
    if (!username || !password) return false;
    std::string user = username;
    auto it = m_users.find(user);
    if (it == m_users.end()) return false;
    return it->second == password;
}