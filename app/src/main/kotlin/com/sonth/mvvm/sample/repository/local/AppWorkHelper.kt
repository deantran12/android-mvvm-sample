package com.sonth.mvvm.sample.repository.local

import javax.inject.Inject

class AppWorkHelper @Inject constructor(): WorkHelper {
//    val listLokr = ArrayList<Lokr>()
//
//    override fun uploadLokrPictureToStorage(uri: Uri, lockSerial: String): Observable<String> {
//        return Observable.create { emitter ->
//            val storageRef = Firebase.storage.reference
//            val riversRef = storageRef.child("locks/$lockSerial.jpg")
//            val uploadTask = riversRef.putFile(uri)
//
//            uploadTask.continueWithTask { task ->
//                if (!task.isSuccessful) {
//                    task.exception?.let {
//                        throw it
//                    }
//                }
//                riversRef.downloadUrl
//            }.addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    val downloadUri = task.result
//                    emitter.onNext(downloadUri.toString())
//                    emitter.onComplete()
//                } else {
//                    emitter.onError(Throwable(task.exception))
//                }
//            }
//        }
//    }
//
//    override fun setLokrs(lokrs: List<Lokr>) {
//        listLokr.clear()
//        listLokr.addAll(lokrs)
//    }
//
//    override fun getListLokrs(): List<Lokr> {
//        return listLokr
//    }
//
//    override fun addLokrs(lokr: Lokr) {
//
//    }
}