#include <jni.h>
#include <stdlib.h>

int getPressure(){
	//ģ��ײ��ȡѹ��
	return random()%101;
}

//�Ƿ�򿪼��
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
		//��ȡѹ��ֵ
			int prossure = getPressure();
			//����java��ʾ�ķ���
		    //jclass      (*FindClass)(JNIEnv*, const char*);
			jclass clazz = (*env)->FindClass(env ,"com/xiaozhe/showpressure/MainActivity");
			//    jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
			jmethodID methodID = (*env)->GetMethodID(env, clazz, "showProgress","(I)V");
			//void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);
			(*env)->CallVoidMethod(env, obj,methodID,prossure);

			//ˢ������
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
	//�رռ��
	monitor=0;
}
