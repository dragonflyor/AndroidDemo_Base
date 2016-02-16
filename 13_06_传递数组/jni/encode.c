#include <jni.h>

JNIEXPORT void JNICALL Java_com_xiaozhe_sendintarray_MainActivity_encode
  (JNIEnv* env, jobject obj, jintArray intArray){

	//jsize       (*GetArrayLength)(JNIEnv*, jarray);

	int length = (*env)->GetArrayLength(env ,intArray);
	//jint*       (*GetIntArrayElements)(JNIEnv*, jintArray, jboolean*);
	int  * arrp = (*env)->GetIntArrayElements(env,intArray,0);

	int i;
	for(i=0;i<length;i++){
		*(arrp+i) += 10;
	}


}
