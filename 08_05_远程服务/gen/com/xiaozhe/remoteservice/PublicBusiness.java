/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\Android\\zhe\\workspace\\08_05_Զ�̷���\\src\\com\\xiaozhe\\remoteservice\\PublicBusiness.aidl
 */
package com.xiaozhe.remoteservice;
public interface PublicBusiness extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.xiaozhe.remoteservice.PublicBusiness
{
private static final java.lang.String DESCRIPTOR = "com.xiaozhe.remoteservice.PublicBusiness";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.xiaozhe.remoteservice.PublicBusiness interface,
 * generating a proxy if needed.
 */
public static com.xiaozhe.remoteservice.PublicBusiness asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.xiaozhe.remoteservice.PublicBusiness))) {
return ((com.xiaozhe.remoteservice.PublicBusiness)iin);
}
return new com.xiaozhe.remoteservice.PublicBusiness.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_QianXian:
{
data.enforceInterface(DESCRIPTOR);
this.QianXian();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.xiaozhe.remoteservice.PublicBusiness
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void QianXian() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_QianXian, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_QianXian = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void QianXian() throws android.os.RemoteException;
}
