#include <jni.h>

jint Java_com_xiaozhe_localadd_MainActivity_add(JNIEnv * env, jobject obj, jint a, jint b)
{
	return a+b;
}
