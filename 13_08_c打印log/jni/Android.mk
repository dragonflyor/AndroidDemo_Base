LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_LDLIBS += -llog

LOCAL_MODULE    := logofc
LOCAL_SRC_FILES := logofc.c

include $(BUILD_SHARED_LIBRARY)
