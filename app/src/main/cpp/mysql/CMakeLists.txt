add_library(mysql_lib STATIC
        SQLiteManager.cpp
        SQLiteManager.h
)

target_include_directories(mysql_lib PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})