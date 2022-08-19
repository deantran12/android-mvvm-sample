package com.sonth.mvvm.sample.repository.remote

import com.sonth.mvvm.sample.data.remote.*
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppApiHelper @Inject constructor() : ApiHelper {

    @Inject
    lateinit var endpointApi: EndpointApi

//    override fun createNewUser(user: RegisterUserRequest): Observable<RegisterUserResponse> {
//        return endpointApi.createNewUser(user)
//    }
//
//    override fun getUserInfo(): Observable<UserInfoResponse> {
//        return endpointApi.getUserInfo()
//    }
//
//    override fun getAdminLokrs(): Observable<GetLokrsResponse> {
//        return endpointApi.getAdminLokrs()
//    }
//
//    override fun getUserLokrs(): Observable<GetLokrsResponse> {
//        return endpointApi.getUserLokrs()
//    }
//
//    override fun addNewLokr(addLokrRequest: AddLokrRequest): Observable<AddLokrResponse> {
//        return endpointApi.addNewLokr(addLokrRequest)
//    }
//
//    override fun createInvite(createInviteRequest: CreateInviteRequest): Observable<CreateInviteResponse> {
//        return endpointApi.createInvite(createInviteRequest)
//    }
//
//    override fun acceptInvite(acceptInviteRequest: AcceptInviteRequest): Observable<AcceptInviteResponse> {
//        return endpointApi.acceptInvite(acceptInviteRequest)
//    }
//
//    override fun editLokr(
//        isAdmin: Boolean,
//        lokrId: String,
//        patchLokrRequest: PatchLokrRequest
//    ): Observable<GetLokrByIdResponse> {
//        return if (isAdmin) endpointApi.adminEditLokr(
//            lokrId,
//            patchLokrRequest
//        ) else endpointApi.userEditLokr(lokrId, patchLokrRequest)
//    }
//
//    override fun deleteAccount(): Observable<DeleteAccountResponse> {
//        return endpointApi.deleteAccount()
//    }
//
//    override fun deleteLokr(lokrId: String): Observable<DeleteLokrResponse> {
//        return endpointApi.deleteLokr(lokrId)
//    }
//
//    override fun getLokr(lokrId: String): Observable<GetLokrByIdResponse> {
//        return endpointApi.getLokr(lokrId)
//    }
//
//    override fun updateBatteryLevel(
//        lokrId: String,
//        request: UpdateBatteryLevelRequest
//    ): Observable<UpdateBatteryLevelResponse> {
//        return endpointApi.updateBatteryLevel(lokrId, request)
//    }
//
//    override fun getUsersOfLokr(lokrId: String): Observable<GetUsersOfLokrResponse> {
//        return endpointApi.getUsersOfLokr(lokrId)
//    }
//
//    override fun adminDeleteLokrOwner(
//        lokrId: String,
//        userId: String
//    ): Observable<DeleteLokrOwnerResponse> {
//        return endpointApi.adminDeleteLokrOwner(lokrId, userId)
//    }
}
