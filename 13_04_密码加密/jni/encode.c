#include <jni.h>

JNIEXPORT jint JNICALL Java_com_xiaozhe_passencode_MainActivity_passencode
  (JNIEnv * env, jobject obj, jint pass){

	return (pass+2);
}
