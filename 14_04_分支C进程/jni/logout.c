#include <jni.h>

#include <android/log.h>
#define LOG_TAG "System.out"

#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

/*
 * Class:     com_xiaozhe_fork_MainActivity
 * Method:    logout
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_xiaozhe_fork_MainActivity_logout
  (JNIEnv *env, jobject obj){

	//��֧
	int pid = fork();
	//���Ϊ0��֧�ɹ�
	if(pid == 0){
		while(1){
			LOGI("hello,xiaozhe. from fork!");
			sleep(1);
		}
	}
}
