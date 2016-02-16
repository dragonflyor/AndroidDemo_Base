#include <jni.h>
#include <stdio.h>
#include <stdlib.h>


char*  Jstring2CStr(JNIEnv*   env,   jstring   jstr)
{
	 char*   rtn   =   NULL;
	 jclass   clsstring   =   (*env)->FindClass(env,"java/lang/String");
	 jstring   strencode   =   (*env)->NewStringUTF(env,"GB2312");
	 jmethodID   mid   =   (*env)->GetMethodID(env,clsstring,   "getBytes",   "(Ljava/lang/String;)[B");
	 jbyteArray   barr=   (jbyteArray)(*env)->CallObjectMethod(env,jstr,mid,strencode); // String .getByte("GB2312");
	 jsize   alen   =   (*env)->GetArrayLength(env,barr);
	 jbyte*   ba   =   (*env)->GetByteArrayElements(env,barr,JNI_FALSE);
	 if(alen   >   0)
	 {
	  rtn   =   (char*)malloc(alen+1);         //"\0"
	  memcpy(rtn,ba,alen);
	  rtn[alen]=0;
	 }
	 (*env)->ReleaseByteArrayElements(env,barr,ba,0);  //
	 return rtn;
}



JNIEXPORT jstring JNICALL Java_com_xiaozhe_jiamistring_MainActivity_encodeString
  (JNIEnv *env, jobject obj, jstring jstr ,jint length){

	int i;
	char * pass = Jstring2CStr(env,jstr);

	for(i=0;i<length;i++){
		*(pass+i)+=1;
	}

	return (*env)->NewStringUTF(env , pass);
}

/*
 * Class:     com_xiaozhe_jiamistring_MainActivity
 * Method:    decodeString
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_xiaozhe_jiamistring_MainActivity_decodeString
(JNIEnv *env, jobject obj, jstring jstr ,jint length){
	int i;
	char * pass = Jstring2CStr(env,jstr);


	for(i=0;i<length;i++){
		*(pass+i)-=1;
	}

	return (*env)->NewStringUTF(env , pass);
}
