add_library(login_api STATIC
        UserAPI.cpp
        UserAPI.h
)

target_include_directories(login_api PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})
target_link_libraries(login_api PUBLIC mysql_lib)