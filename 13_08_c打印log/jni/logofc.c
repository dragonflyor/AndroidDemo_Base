#include <jni.h>

#include <android/log.h>
#define LOG_TAG "System.out"

#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

/*
 * Class:     com_xiaozhe_logfromc_MainActivity
 * Method:    logfromc
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_xiaozhe_logfromc_MainActivity_logfromc
  (JNIEnv * env, jobject obj){

	LOGD("logd from c");
	LOGI("logI from c");
	//jclass      (*FindClass)(JNIEnv*, const char*);
	jclass clazz = (*env)->FindClass(env ,"com/xiaozhe/logfromc/MainActivity");
	//    jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
	jmethodID methodID=(*env)->GetMethodID(env ,clazz,"show","(Ljava/lang/String;)V");
	// void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);
	// jstring     (*NewStringUTF)(JNIEnv*, const char*);
	(*env)->CallVoidMethod(env,obj,methodID,(*env)->NewStringUTF(env ,"hhihihih"));

}
