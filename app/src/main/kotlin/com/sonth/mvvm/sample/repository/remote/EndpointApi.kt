package com.sonth.mvvm.sample.repository.remote

import com.sonth.mvvm.sample.data.remote.*
import com.sonth.mvvm.sample.utils.Global
import io.reactivex.Observable

class EndpointApi(private val endpointService: EndpointService) {
//    fun createNewUser(user: RegisterUserRequest): Observable<RegisterUserResponse> {
//        return endpointService.endpointInterface.createNewUser(
//            Global.getAuthToken(),
//            Global.getSecretKey(),
//            user
//        )
//    }
//
//    fun getUserInfo(): Observable<UserInfoResponse> {
//        return endpointService.endpointInterface.getUserInfo(
//            Global.getAuthToken(),
//            Global.getSecretKey()
//        )
//    }
//
//    fun getUserLokrs(): Observable<GetLokrsResponse> {
//        return endpointService.endpointInterface.getUserLokrs(
//            Global.getAuthToken(),
//            Global.getSecretKey()
//        )
//    }
//
//    fun getAdminLokrs(): Observable<GetLokrsResponse> {
//        return endpointService.endpointInterface.getAdminLokrs(
//            Global.getAuthToken(),
//            Global.getSecretKey()
//        )
//    }
//
//    fun addNewLokr(addLokrRequest: AddLokrRequest): Observable<AddLokrResponse> {
//        return endpointService.endpointInterface.addNewLokr(
//            Global.getAuthToken(),
//            Global.getSecretKey(),
//            addLokrRequest
//        )
//    }
//
//    fun createInvite(createInviteRequest: CreateInviteRequest): Observable<CreateInviteResponse> {
//        return endpointService.endpointInterface.createInvite(
//            Global.getAuthToken(),
//            Global.getSecretKey(),
//            createInviteRequest
//        )
//    }
//
//    fun acceptInvite(acceptInviteRequest: AcceptInviteRequest): Observable<AcceptInviteResponse> {
//        return endpointService.endpointInterface.acceptInvite(
//            Global.getAuthToken(),
//            Global.getSecretKey(),
//            acceptInviteRequest.token
//        )
//    }
//
//    fun userEditLokr(
//        lokrId: String,
//        patchLokrRequest: PatchLokrRequest
//    ): Observable<GetLokrByIdResponse> {
//        return endpointService.endpointInterface.userEditLokr(
//            Global.getAuthToken(),
//            Global.getSecretKey(),
//            lokrId = lokrId,
//            patchLokrRequest
//        )
//    }
//
//    fun adminEditLokr(
//        lokrId: String,
//        patchLokrRequest: PatchLokrRequest
//    ): Observable<GetLokrByIdResponse> {
//        return endpointService.endpointInterface.adminEditLokr(
//            Global.getAuthToken(),
//            Global.getSecretKey(),
//            lokrId = lokrId,
//            patchLokrRequest
//        )
//    }
//
//    fun deleteAccount(): Observable<DeleteAccountResponse> {
//        return endpointService.endpointInterface.deleteUser(
//            Global.getAuthToken(),
//            Global.getSecretKey()
//        )
//    }
//
//    fun deleteLokr(lokrId: String): Observable<DeleteLokrResponse> {
//        return endpointService.endpointInterface.deleteLokr(
//            Global.getAuthToken(),
//            Global.getSecretKey(),
//            lokrId
//        )
//    }
//
//    fun getLokr(lokrId: String): Observable<GetLokrByIdResponse> {
//        return endpointService.endpointInterface.getLokrById(
//            Global.getAuthToken(),
//            Global.getSecretKey(),
//            lokrId
//        )
//    }
//
//    fun updateBatteryLevel(
//        lokrId: String,
//        request: UpdateBatteryLevelRequest
//    ): Observable<UpdateBatteryLevelResponse> {
//        return endpointService.endpointInterface.updateBatteryLevel(
//            Global.getAuthToken(),
//            Global.getSecretKey(),
//            lokrId,
//            request
//        )
//    }
//
//    fun getUsersOfLokr(lokrId: String): Observable<GetUsersOfLokrResponse> {
//        return endpointService.endpointInterface.getUsersOfLokr(
//            Global.getAuthToken(),
//            Global.getSecretKey(),
//            lokrId
//        )
//    }
//
//    fun adminDeleteLokrOwner(lokrId: String, userId: String): Observable<DeleteLokrOwnerResponse> {
//        return endpointService.endpointInterface.adminDeleteLokrOwner(
//            Global.getAuthToken(),
//            Global.getSecretKey(),
//            lokrId,
//            userId
//        )
//    }
}