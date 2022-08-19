package com.sonth.mvvm.sample.repository.remote

import com.sonth.mvvm.sample.data.remote.*
import io.reactivex.Observable
import retrofit2.http.*

interface EndpointInterface {

//    @GET("/v1/users/me")
//    fun getUserInfo(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String
//    ): Observable<UserInfoResponse>
//
//    @Headers("Content-Type: application/json")
//    @POST("/v1/users/")
//    fun createNewUser(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String,
//        @Body user: RegisterUserRequest
//    ): Observable<RegisterUserResponse>
//
//    @DELETE("/v1/users/")
//    fun deleteUser(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String
//    ): Observable<DeleteAccountResponse>
//
//    @GET("/v1/locks/")
//    fun getUserLokrs(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String
//    ): Observable<GetLokrsResponse>
//
//    @GET("/v1/admin/locks/")
//    fun getAdminLokrs(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String
//    ): Observable<GetLokrsResponse>
//
//    @Headers("Content-Type: application/json")
//    @POST("/v1/admin/locks/")
//    fun addNewLokr(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String,
//        @Body addLokrRequest: AddLokrRequest
//    ): Observable<AddLokrResponse>
//
//    @Headers("Content-Type: application/json")
//    @POST("v1/invites/")
//    fun createInvite(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String,
//        @Body createInviteRequest: CreateInviteRequest
//    ): Observable<CreateInviteResponse>
//
//    @Headers("Content-Type: application/json")
//    @PUT("/v1/invites/{token}/accept")
//    fun acceptInvite(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String,
//        @Path("token") token: String
//    ): Observable<AcceptInviteResponse>
//
//    @GET("/v1/locks/{id}")
//    fun getLokrById(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String,
//        @Path("id") lokrId: String
//    ): Observable<GetLokrByIdResponse>
//
//    @PUT("/v1/locks/{id}/battery")
//    fun updateBatteryLevel(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String,
//        @Path("id") lokrId: String,
//        @Body updateBatteryLevelRequest: UpdateBatteryLevelRequest
//    ): Observable<UpdateBatteryLevelResponse>
//
//    @PATCH("/v1/admin/locks/{id}")
//    fun adminEditLokr(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String,
//        @Path("id") lokrId: String,
//        @Body pathLokrRequest: PatchLokrRequest
//    ): Observable<GetLokrByIdResponse>
//
//    @PATCH("/v1/locks/{id}")
//    fun userEditLokr(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String,
//        @Path("id") lokrId: String,
//        @Body pathLokrRequest: PatchLokrRequest
//    ): Observable<GetLokrByIdResponse>
//
//    @DELETE("/v1/admin/locks/{id}")
//    fun deleteLokr(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String,
//        @Path("id") lokrId: String
//    ): Observable<DeleteLokrResponse>
//
//    @DELETE("/v1/admin/locks/{lokrId}/owners/{userId}")
//    fun adminDeleteLokrOwner(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String,
//        @Path("lokrId") lokrId: String,
//        @Path("userId") userId: String
//    ): Observable<DeleteLokrOwnerResponse>
//
//    @GET("/v1/locks/{id}/users")
//    fun getUsersOfLokr(
//        @Header("Authorization") authorization: String,
//        @Header("SECRET_KEY") secretKey: String,
//        @Path("id") lokrId: String
//    ): Observable<GetUsersOfLokrResponse>
}