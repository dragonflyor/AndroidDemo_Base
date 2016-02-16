LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_LDLIBS += -llog

LOCAL_MODULE    := logout
LOCAL_SRC_FILES := logout.c

include $(BUILD_SHARED_LIBRARY)
