#include <jni.h>
#include "com_xiaozhe_ctocpp_MainActivity.h"


JNIEXPORT jstring JNICALL Java_com_xiaozhe_ctocpp_MainActivity_hello
  (JNIEnv *env, jobject obj){
	char * str = "hello , xiaozhe ! greed from c++!";

	return (env)->NewStringUTF(str);
}
