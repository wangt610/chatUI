cmake_minimum_required(VERSION 3.22.1)
project(chat_core)

set(CMAKE_CXX_STANDARD 17)

add_subdirectory(mysql)
add_subdirectory(login)

add_library(
        chat_core
        SHARED
        native-lib.cpp
)

find_library(log-lib log)

target_link_libraries(
        chat_core
        login_api
        mysql_lib
        ${log-lib}
)