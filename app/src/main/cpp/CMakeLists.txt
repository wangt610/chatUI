# 版本号（唯一控制中心）
set(CHAT_VER_MAJOR 1)
set(CHAT_VER_MINOR 0)
set(CHAT_VER_PATCH 0)

# 自动从 GitHub 拉取 dsvm C++ 代码
include(FetchContent)
FetchContent_Declare(
        dsvm
        GIT_REPOSITORY https://github.com/wangt610/dsvm_chat.git
        GIT_TAG master
)
FetchContent_MakeAvailable(dsvm)
set(DSVM_CHAT_ROOT ${dsvm_SOURCE_DIR})

cmake_minimum_required(VERSION 3.22.1)
project("chat_native")

# 引入头文件
include_directories(${DSVM_CHAT_ROOT})

# 源码列表
set(CHAT_SRC
        native-lib.cpp
        ${DSVM_CHAT_ROOT}/chat_core.cpp
)

# 编译动态库
add_library(
        chatroom
        SHARED
        ${CHAT_SRC}
)

# 版本宏
target_compile_definitions(chatroom PRIVATE
        VER_MAJOR=${CHAT_VER_MAJOR}
        VER_MINOR=${CHAT_VER_MINOR}
        VER_PATCH=${CHAT_VER_PATCH}
)

# 安卓系统库
find_library(log-lib log)
target_link_libraries(chatroom ${log-lib})