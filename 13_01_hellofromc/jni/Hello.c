#include <stdio.h>
#include <stdlib.h>
#include <jni.h>

jstring Java_com_xiaozhe_hellofromc_MainActivity_helloFromC(JNIEnv * env,jobject obj)
{
	char * cstr = "hello from c luaguage";

	// jstring     (*NewStringUTF)(JNIEnv*, const char*)
	//ת����java�ַ�
	jstring jstr = (* env)->NewStringUTF(env,cstr);

	return jstr;
}
