#ifndef USERAPI_H
#define USERAPI_H

#ifdef __cplusplus
extern "C" {
#endif

int user_register(const char* username, const char* password);
int user_login(const char* username, const char* password);

#ifdef __cplusplus
}
#endif

#endif