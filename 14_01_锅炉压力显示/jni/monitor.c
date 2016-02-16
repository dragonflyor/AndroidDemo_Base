#include <jni.h>
#include <stdlib.h>

int getPressure(){
	//模拟底层获取压力
	return random()%101;
}

//是否打开检测
int monitor = 0;

/*
 * Class:     com_xiaozhe_showpressure_MainActivity
 * Method:    startMonitor
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_xiaozhe_showpressure_MainActivity_startMonitor
  (JNIEnv *env, jobject obj){

	monitor=1;
	while(monitor){
		//获取压力值
			int prossure = getPressure();
			//调用java显示的方法
		    //jclass      (*FindClass)(JNIEnv*, const char*);
			jclass clazz = (*env)->FindClass(env ,"com/xiaozhe/showpressure/MainActivity");
			//    jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
			jmethodID methodID = (*env)->GetMethodID(env, clazz, "showProgress","(I)V");
			//void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);
			(*env)->CallVoidMethod(env, obj,methodID,prossure);

			//刷新周期
			sleep(1);
	}


}

/*
 * Class:     com_xiaozhe_showpressure_MainActivity
 * Method:    stopMonitor
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_xiaozhe_showpressure_MainActivity_stopMonitor
(JNIEnv *env, jobject obj){
	//关闭检测
	monitor=0;
}
