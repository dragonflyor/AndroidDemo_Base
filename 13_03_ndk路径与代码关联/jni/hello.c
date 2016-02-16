#include <jni.h>
#include <stdio.h>
#include <stdlib.h>

JNIEXPORT jstring JNICALL Java_com_xiaozhe_ndkpath_MainActivity_helloC
  (JNIEnv * env, jobject obj){
	char * str = "HELLO";

	return ((*env)->NewStringUTF( (env), str));
}
