//#include <jni.h>
//#include <android/log.h>
//#define LOG_TAG "System.out"
//
//#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
//#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
//
//JNIEXPORT void JNICALL Java_com_xiaozhe_clog_MainActivity_logout
//  (JNIEnv *env, jobject obj){
//
//	LOGD("logd from c");
//
//}


#include <jni.h>
#include <android/log.h>
#define LOG_TAG "System.out"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)


JNIEXPORT void JNICALL Java_com_itheima_ccalljava_MainActivity_helloC
  (JNIEnv * env, jobject obj){
	//��ӡlog���
	LOGD("hello!");
	LOGI("hello!");

}
