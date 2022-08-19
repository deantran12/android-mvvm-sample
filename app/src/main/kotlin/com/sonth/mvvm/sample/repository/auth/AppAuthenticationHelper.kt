package com.sonth.mvvm.sample.repository.auth

import javax.inject.Inject


class AppAuthenticationHelper @Inject constructor() : AuthenticationHelper {
//    private val firebaseAuth = FirebaseAuth.getInstance()
//
//    override fun register(email: String, password: String): Observable<FirebaseUser> {
//        return Observable.create { emitter ->
//            firebaseAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        firebaseAuth.currentUser?.let { user ->
//                            emitter.onNext(user)
//                        }
//                    } else {
//                        emitter.onError(Throwable(task.exception))
//                    }
//                    emitter.onComplete()
//                }
//        }
//    }
//
//    override fun login(email: String, password: String): Observable<FirebaseUser> {
//        return Observable.create { emitter ->
//            firebaseAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        firebaseAuth.currentUser?.let { user ->
//                            emitter.onNext(user)
//                        }
//                    } else {
//                        emitter.onError(Throwable(task.exception))
//                    }
//                    emitter.onComplete()
//                }
//        }
//    }
//
//    override fun getUser(): FirebaseUser? {
//        return firebaseAuth.currentUser
//    }
//
//    override fun sentEmailVerification(
//        packageName: String,
//        firebaseUser: FirebaseUser
//    ): Observable<Boolean> {
//        val url = "${Constant.CONTINUE_URL_VERIFY}?uid=" + firebaseUser.uid
//        val actionCodeSettings = ActionCodeSettings.newBuilder()
//            .setHandleCodeInApp(true)
//            .setAndroidPackageName(packageName, false, null)
//            .setIOSBundleId(Constant.IOS_BUNDLE_ID)
//            .setUrl(url)
//            .build()
//        return Observable.create { emitter ->
//            firebaseUser.sendEmailVerification(actionCodeSettings)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        emitter.onNext(true)
//                    } else {
//                        emitter.onError(Throwable(task.exception))
//                    }
//                    emitter.onComplete()
//                }
//        }
//    }
//
//    override fun verifyEmail(code: String): Observable<Boolean> {
//        return Observable.create { emitter ->
//            firebaseAuth.applyActionCode(code)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        emitter.onNext(true)
//                    } else {
//                        emitter.onError(Throwable(task.exception))
//                    }
//                    emitter.onComplete()
//                }
//        }
//    }
//
//    override fun reloadUser(firebaseUser: FirebaseUser): Observable<Boolean> {
//        return Observable.create { emitter ->
//            firebaseUser.reload().addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    emitter.onNext(true)
//                } else {
//                    emitter.onError(Throwable(task.exception))
//                }
//                emitter.onComplete()
//            }
//        }
//    }
//
//    override fun logout() {
//        firebaseAuth.signOut()
//    }
//
//    override fun sentResetPasswordRequest(
//        packageName: String,
//        email: String
//    ): Observable<Boolean> {
//        val url = Constant.CONTINUE_URL_RESET
//        val actionCodeSettings = ActionCodeSettings.newBuilder()
//            .setHandleCodeInApp(true)
//            .setAndroidPackageName(packageName, false, null)
//            .setUrl(url)
//            .build()
//        return Observable.create { emitter ->
//            firebaseAuth.sendPasswordResetEmail(email, actionCodeSettings)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        emitter.onNext(true)
//                    } else {
//                        emitter.onError(Throwable(task.exception))
//                    }
//                    emitter.onComplete()
//                }
//        }
//    }
//
//    override fun setNewPassword(code: String, newPassword: String): Observable<Boolean> {
//        return Observable.create { emitter ->
//            firebaseAuth.confirmPasswordReset(code, newPassword)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        emitter.onNext(true)
//                    } else {
//                        emitter.onError(Throwable(task.exception))
//                    }
//                    emitter.onComplete()
//                }
//        }
//    }
//
//    override fun getIdToken(): Observable<String> {
//        return Observable.create { emitter ->
//            if (getUser() != null) {
//                getUser()!!.getIdToken(false).addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        task.result.token?.let { idToken ->
//                            emitter.onNext(idToken)
//                        }
//                    } else {
//                        emitter.onError(Throwable(task.exception))
//                    }
//                    emitter.onComplete()
//                }
//            } else {
//                emitter.onError(Throwable())
//                emitter.onComplete()
//            }
//        }
//    }
//
//    override fun changePassword(
//        firebaseUser: FirebaseUser,
//        newPassword: String
//    ): Observable<Boolean> {
//        return Observable.create { emitter ->
//            firebaseUser.updatePassword(newPassword)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        emitter.onNext(true)
//                    } else {
//                        emitter.onError(Throwable(task.exception))
//                    }
//                    emitter.onComplete()
//                }
//        }
//    }
//
//    override fun reAuthenticate(
//        firebaseUser: FirebaseUser,
//        oldPassword: String
//    ): Observable<Boolean> {
//        return Observable.create { emitter ->
//            if (firebaseUser.email != null) {
//                val credential = EmailAuthProvider
//                    .getCredential(firebaseUser.email!!, oldPassword)
//                firebaseUser.reauthenticate(credential)
//                    .addOnCompleteListener { task ->
//                        if (task.isSuccessful) {
//                            emitter.onNext(true)
//                        } else {
//                            emitter.onError(Throwable(task.exception))private val firebaseAuth = FirebaseAuth.getInstance()
////
////    override fun register(email: String, password: String): Observable<FirebaseUser> {
////        return Observable.create { emitter ->
////            firebaseAuth.createUserWithEmailAndPassword(email, password)
////                .addOnCompleteListener { task ->
////                    if (task.isSuccessful) {
////                        firebaseAuth.currentUser?.let { user ->
////                            emitter.onNext(user)
////                        }
////                    } else {
////                        emitter.onError(Throwable(task.exception))
////                    }
////                    emitter.onComplete()
////                }
////        }
////    }
////
////    override fun login(email: String, password: String): Observable<FirebaseUser> {
////        return Observable.create { emitter ->
////            firebaseAuth.signInWithEmailAndPassword(email, password)
////                .addOnCompleteListener { task ->
////                    if (task.isSuccessful) {
////                        firebaseAuth.currentUser?.let { user ->
////                            emitter.onNext(user)
////                        }
////                    } else {
////                        emitter.onError(Throwable(task.exception))
////                    }
////                    emitter.onComplete()
////                }
////        }
////    }
////
////    override fun getUser(): FirebaseUser? {
////        return firebaseAuth.currentUser
////    }
////
////    override fun sentEmailVerification(
////        packageName: String,
////        firebaseUser: FirebaseUser
////    ): Observable<Boolean> {
////        val url = "${Constant.CONTINUE_URL_VERIFY}?uid=" + firebaseUser.uid
////        val actionCodeSettings = ActionCodeSettings.newBuilder()
////            .setHandleCodeInApp(true)
////            .setAndroidPackageName(packageName, false, null)
////            .setIOSBundleId(Constant.IOS_BUNDLE_ID)
////            .setUrl(url)
////            .build()
////        return Observable.create { emitter ->
////            firebaseUser.sendEmailVerification(actionCodeSettings)
////                .addOnCompleteListener { task ->
////                    if (task.isSuccessful) {
////                        emitter.onNext(true)
////                    } else {
////                        emitter.onError(Throwable(task.exception))
////                    }
////                    emitter.onComplete()
////                }
////        }
////    }
////
////    override fun verifyEmail(code: String): Observable<Boolean> {
////        return Observable.create { emitter ->
////            firebaseAuth.applyActionCode(code)
////                .addOnCompleteListener { task ->
////                    if (task.isSuccessful) {
////                        emitter.onNext(true)
////                    } else {
////                        emitter.onError(Throwable(task.exception))
////                    }
////                    emitter.onComplete()
////                }
////        }
////    }
////
////    override fun reloadUser(firebaseUser: FirebaseUser): Observable<Boolean> {
////        return Observable.create { emitter ->
////            firebaseUser.reload().addOnCompleteListener { task ->
////                if (task.isSuccessful) {
////                    emitter.onNext(true)
////                } else {
////                    emitter.onError(Throwable(task.exception))
////                }
////                emitter.onComplete()
////            }
////        }
////    }
////
////    override fun logout() {
////        firebaseAuth.signOut()
////    }
////
////    override fun sentResetPasswordRequest(
////        packageName: String,
////        email: String
////    ): Observable<Boolean> {
////        val url = Constant.CONTINUE_URL_RESET
////        val actionCodeSettings = ActionCodeSettings.newBuilder()
////            .setHandleCodeInApp(true)
////            .setAndroidPackageName(packageName, false, null)
////            .setUrl(url)
////            .build()
////        return Observable.create { emitter ->
////            firebaseAuth.sendPasswordResetEmail(email, actionCodeSettings)
////                .addOnCompleteListener { task ->
////                    if (task.isSuccessful) {
////                        emitter.onNext(true)
////                    } else {
////                        emitter.onError(Throwable(task.exception))
////                    }
////                    emitter.onComplete()
////                }
////        }
////    }
////
////    override fun setNewPassword(code: String, newPassword: String): Observable<Boolean> {
////        return Observable.create { emitter ->
////            firebaseAuth.confirmPasswordReset(code, newPassword)
////                .addOnCompleteListener { task ->
////                    if (task.isSuccessful) {
////                        emitter.onNext(true)
////                    } else {
////                        emitter.onError(Throwable(task.exception))
////                    }
////                    emitter.onComplete()
////                }
////        }
////    }
////
////    override fun getIdToken(): Observable<String> {
////        return Observable.create { emitter ->
////            if (getUser() != null) {
////                getUser()!!.getIdToken(false).addOnCompleteListener { task ->
////                    if (task.isSuccessful) {
////                        task.result.token?.let { idToken ->
////                            emitter.onNext(idToken)
////                        }
////                    } else {
////                        emitter.onError(Throwable(task.exception))
////                    }
////                    emitter.onComplete()
////                }
////            } else {
////                emitter.onError(Throwable())
////                emitter.onComplete()
////            }
////        }
////    }
////
////    override fun changePassword(
////        firebaseUser: FirebaseUser,
////        newPassword: String
////    ): Observable<Boolean> {
////        return Observable.create { emitter ->
////            firebaseUser.updatePassword(newPassword)
////                .addOnCompleteListener { task ->
////                    if (task.isSuccessful) {
////                        emitter.onNext(true)
////                    } else {
////                        emitter.onError(Throwable(task.exception))
////                    }
////                    emitter.onComplete()
////                }
////        }
////    }
////
////    override fun reAuthenticate(
////        firebaseUser: FirebaseUser,
////        oldPassword: String
////    ): Observable<Boolean> {
////        return Observable.create { emitter ->
////            if (firebaseUser.email != null) {
////                val credential = EmailAuthProvider
////                    .getCredential(firebaseUser.email!!, oldPassword)
////                firebaseUser.reauthenticate(credential)
////                    .addOnCompleteListener { task ->
////                        if (task.isSuccessful) {
////                            emitter.onNext(true)
////                        } else {
////                            emitter.onError(Throwable(task.exception))
////                        }
////                        emitter.onComplete()
////                    }
////            } else {
////                emitter.onError(Throwable(message = "Cannot get the Email!"))
////            }
////        }
////    }
//                        }
//                        emitter.onComplete()
//                    }
//            } else {
//                emitter.onError(Throwable(message = "Cannot get the Email!"))
//            }
//        }
//    }
}