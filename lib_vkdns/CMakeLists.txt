
cmake_minimum_required(VERSION 3.4.1)
set(libs_DIR src/main/jnilib/${ANDROID_ABI})
link_directories(${libs_DIR})

add_library( # Sets the name of the library.
             vkdns

             # Sets the library as a shared library.
             SHARED

             src/main/cpp/vkdns.cpp )

target_link_libraries( # Specifies the target library.
                       vkdns
                       vHook
                        )

find_library( # Sets the name of the path variable.
              log-lib
              log )


target_link_libraries( # Specifies the target library.
                       vkdns
                       ${log-lib}
                        )