 
  LOCAL_PATH := $(call my-dir)

    include $(CLEAR_VARS)

	#编译生成的文件类库叫什么名字
    LOCAL_MODULE    := hello
    #需要变异率的源文件叫什么名字
    LOCAL_SRC_FILES := Hello.c

    include $(BUILD_SHARED_LIBRARY)