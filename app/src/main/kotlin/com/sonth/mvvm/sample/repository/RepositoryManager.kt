package com.sonth.mvvm.sample.repository

import com.sonth.mvvm.sample.repository.auth.AuthenticationHelper
import com.sonth.mvvm.sample.repository.local.WorkHelper
import com.sonth.mvvm.sample.repository.remote.ApiHelper


interface RepositoryManager : ApiHelper, WorkHelper, AuthenticationHelper