package com.sonth.mvvm.sample.repository

import com.sonth.mvvm.sample.repository.auth.AuthenticationHelper
import com.sonth.mvvm.sample.repository.local.WorkHelper
import com.sonth.mvvm.sample.repository.remote.ApiHelper
import javax.inject.Inject
import javax.inject.Singleton

const val HTTP_ERROR_UNAUTHORIZED = 401

@Singleton
class AppRepositoryManager @Inject constructor(
    private val apiHelper: ApiHelper,
    private val workHelper: WorkHelper,
    private val authHelper: AuthenticationHelper
) : RepositoryManager {

//    override fun uploadLokrPictureToStorage(uri: Uri, lockSerial: String): Observable<String> {
//        return workHelper.uploadLokrPictureToStorage(uri, lockSerial)
//    }
//
//    override fun getUser(): FirebaseUser? {
//        return authHelper.getUser()
//    }
//
//    override fun register(email: String, password: String): Observable<FirebaseUser> {
//        return authHelper.register(email, password)
//    }
//
//    override fun login(email: String, password: String): Observable<FirebaseUser> {
//        return authHelper.login(email, password)
//    }
//
//    override fun sentEmailVerification(
//        packageName: String,
//        firebaseUser: FirebaseUser
//    ): Observable<Boolean> {
//        return authHelper.sentEmailVerification(packageName, firebaseUser)
//    }
//
//    override fun verifyEmail(code: String): Observable<Boolean> {
//        return authHelper.verifyEmail(code)
//    }
//
//    override fun reloadUser(firebaseUser: FirebaseUser): Observable<Boolean> {
//        return authHelper.reloadUser(firebaseUser)
//    }
//
//    override fun logout() {
//        return authHelper.logout()
//    }
//
//    override fun sentResetPasswordRequest(packageName: String, email: String): Observable<Boolean> {
//        return authHelper.sentResetPasswordRequest(packageName, email)
//    }
//
//    override fun setNewPassword(code: String, newPassword: String): Observable<Boolean> {
//        return authHelper.setNewPassword(code, newPassword)
//    }
//
//    override fun getIdToken(): Observable<String> {
//        return authHelper.getIdToken()
//    }
//
//    override fun setLokrs(lokrs: List<Lokr>) {
//        return workHelper.setLokrs(lokrs)
//    }
//
//    override fun getListLokrs(): List<Lokr> {
//        return workHelper.getListLokrs()
//    }
//
//    override fun changePassword(
//        firebaseUser: FirebaseUser,
//        newPassword: String
//    ): Observable<Boolean> {
//        return authHelper.changePassword(firebaseUser, newPassword)
//    }
//
//    override fun reAuthenticate(
//        firebaseUser: FirebaseUser,
//        oldPassword: String
//    ): Observable<Boolean> {
//        return authHelper.reAuthenticate(firebaseUser, oldPassword)
//    }
//
//    override fun addLokrs(lokr: Lokr) {
//        return workHelper.addLokrs(lokr)
//    }
//
//
//    //APIs
//
//
//    override fun adminDeleteLokrOwner(
//        lokrId: String,
//        userId: String
//    ): Observable<DeleteLokrOwnerResponse> {
//        return checkIdTokenValid { apiHelper.adminDeleteLokrOwner(lokrId, userId) }
//    }
//
//    override fun getUsersOfLokr(lokrId: String): Observable<GetUsersOfLokrResponse> {
//        return checkIdTokenValid { apiHelper.getUsersOfLokr(lokrId) }
//    }
//
//    override fun updateBatteryLevel(
//        lokrId: String,
//        request: UpdateBatteryLevelRequest
//    ): Observable<UpdateBatteryLevelResponse> {
//        return checkIdTokenValid{ apiHelper.updateBatteryLevel(lokrId, request) }
//    }
//
//    override fun getLokr(lokrId: String): Observable<GetLokrByIdResponse> {
//        return checkIdTokenValid { apiHelper.getLokr(lokrId) }
//    }
//
//    override fun deleteLokr(lokrId: String): Observable<DeleteLokrResponse> {
//        return checkIdTokenValid { apiHelper.deleteLokr(lokrId) }
//    }
//
//    override fun deleteAccount(): Observable<DeleteAccountResponse> {
//        return checkIdTokenValid { apiHelper.deleteAccount() }
//    }
//
//    override fun editLokr(
//        isAdmin: Boolean,
//        lokrId: String,
//        patchLokrRequest: PatchLokrRequest
//    ): Observable<GetLokrByIdResponse> {
//        return checkIdTokenValid { apiHelper.editLokr(isAdmin, lokrId, patchLokrRequest) }
//    }
//
//    override fun acceptInvite(acceptInviteRequest: AcceptInviteRequest): Observable<AcceptInviteResponse> {
//        return checkIdTokenValid { apiHelper.acceptInvite(acceptInviteRequest) }
//    }
//
//    override fun createInvite(createInviteRequest: CreateInviteRequest): Observable<CreateInviteResponse> {
//        return checkIdTokenValid { apiHelper.createInvite(createInviteRequest) }
//    }
//
//    override fun addNewLokr(addLokrRequest: AddLokrRequest): Observable<AddLokrResponse> {
//        return checkIdTokenValid { apiHelper.addNewLokr(addLokrRequest) }
//    }
//
//    override fun createNewUser(user: RegisterUserRequest): Observable<RegisterUserResponse> {
//        return checkIdTokenValid { apiHelper.createNewUser(user) }
//    }
//
//    override fun getUserInfo(): Observable<UserInfoResponse> {
//        return checkIdTokenValid { apiHelper.getUserInfo() }
//    }
//
//    override fun getAdminLokrs(): Observable<GetLokrsResponse> {
//        return checkIdTokenValid { apiHelper.getAdminLokrs() }
//    }
//
//    override fun getUserLokrs(): Observable<GetLokrsResponse> {
//        return checkIdTokenValid { apiHelper.getUserLokrs() }
//    }
//
//    /*
//    * check idToken valid, if not, get a new one
//    * */
//    private fun <T> checkIdTokenValid(observableWrapper: ObservableWrapper<T>): Observable<T> {
//        return doCheckIdTokenValid(observableWrapper)
//    }
//
//    private fun <T> doCheckIdTokenValid(
//        observableWrapper: ObservableWrapper<T>
//    ): Observable<T> {
//        return Observable.create(createCheckTokenExpiryObservable(observableWrapper))
//    }
//
//    private fun <T> createCheckTokenExpiryObservable(
//        observableWrapper: ObservableWrapper<T>
//    ): ObservableOnSubscribe<T> {
//        return RequestProxyOnSubscribe(observableWrapper, authHelper)
//    }
//
//    class RequestProxyOnSubscribe<T>(
//        private val observableWrapper: ObservableWrapper<T>,
//        private val authHelper: AuthenticationHelper
//    ) :
//        ObservableOnSubscribe<T> {
//        override fun subscribe(emitter: ObservableEmitter<T>) {
//            observableWrapper.observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(createAfterWaitSubscriber(emitter, true))
//        }
//
//        private fun createAfterWaitSubscriber(
//            subscriber: ObservableEmitter<in T>,
//            firstRequest: Boolean
//        ): Observer<T> {
//            return object : Observer<T> {
//                override fun onComplete() {
//                    subscriber.onComplete()
//                }
//
//                override fun onError(e: Throwable) {
//                    if (e is HttpException &&
//                        firstRequest && e.code() == HTTP_ERROR_UNAUTHORIZED
//                    ) {
//                        refreshIdToken(subscriber)
//                    } else {
//                        subscriber.onError(e)
//                    }
//                }
//
//                override fun onSubscribe(d: Disposable) {
//                    subscriber.setDisposable(d)
//                }
//
//                override fun onNext(t: T) {
//                    subscriber.onNext(t)
//                }
//            }
//        }
//
//        private fun refreshIdToken(subscriber: ObservableEmitter<in T>) {
//            authHelper.getIdToken().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(object : Observer<String> {
//                    override fun onComplete() {}
//                    override fun onError(e: Throwable) {
//                        subscriber.onError(e)
//                    }
//
//                    override fun onSubscribe(d: Disposable) {
//                        subscriber.setDisposable(d)
//                    }
//
//                    override fun onNext(idToken: String) {
//                        Global.ID_TOKEN = idToken
//                        observableWrapper.observable.subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe(createAfterWaitSubscriber(subscriber, false))
//                    }
//                })
//        }
//    }
}