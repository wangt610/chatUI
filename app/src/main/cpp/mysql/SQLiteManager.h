#ifndef SQLITEMANAGER_H
#define SQLITEMANAGER_H

#include <string>
#include <unordered_map>

class SQLiteManager {
public:
    static SQLiteManager& getInstance();
    bool init();
    bool registerUser(const char* username, const char* password);
    bool loginCheck(const char* username, const char* password);

private:
    SQLiteManager() = default;
    std::unordered_map<std::string, std::string> m_users; // 内存存储
};

#endif