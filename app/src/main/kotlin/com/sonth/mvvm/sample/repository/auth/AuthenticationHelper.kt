package com.sonth.mvvm.sample.repository.auth

import io.reactivex.Observable

interface AuthenticationHelper {
    companion object{
        const val ERROR_REQUIRES_RECENT_LOGIN = "ERROR_REQUIRES_RECENT_LOGIN"
    }
//    fun getUser(): FirebaseUser?
//    fun register(email: String, password: String): Observable<FirebaseUser>
//    fun login(email: String, password: String): Observable<FirebaseUser>
//    fun sentEmailVerification(packageName: String, firebaseUser: FirebaseUser): Observable<Boolean>
//    fun verifyEmail(code: String): Observable<Boolean>
//    fun reloadUser(firebaseUser: FirebaseUser): Observable<Boolean>
//    fun logout()
//    fun sentResetPasswordRequest(packageName: String, email: String): Observable<Boolean>
//    fun setNewPassword(code: String, newPassword: String): Observable<Boolean>
//    fun getIdToken(): Observable<String>
//    fun changePassword(
//        firebaseUser: FirebaseUser, newPassword: String
//    ): Observable<Boolean>
//    fun reAuthenticate(firebaseUser: FirebaseUser, oldPassword: String) : Observable<Boolean>
}