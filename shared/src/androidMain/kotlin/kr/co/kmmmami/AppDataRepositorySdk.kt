package kr.co.kmmmami

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.di.createKoinApp
import kr.co.kmmmami.domain.model.response.TextsResponse
import kr.co.kmmmami.domain.model.response.UrlsResponse
import kr.co.kmmmami.domain.model.response.VersionResponse
import kr.co.kmmmami.domain.repository.AppDataRepository
import kr.co.kmmmami.util.createPlatformLogger
import org.koin.dsl.module

/**
 * Created by jangsc@brandi.co.kr on 2021/08/10
 */
class AppDataRepositorySdk(context: Context) {
    private val logger = createPlatformLogger("AppDataRepositorySdk")

    private val koinApp = createKoinApp().modules(module { single { context } })
    private val appDataRepository: AppDataRepository = koinApp.koin.get()

    suspend fun getVersion(token: String): Flow<ResultData<VersionResponse>> {
        return appDataRepository.getVersion(token)
    }

    suspend fun getUrls(token: String): Flow<ResultData<UrlsResponse>> {
        return appDataRepository.getUrls(token)
    }

    suspend fun getTexts(token: String): Flow<ResultData<TextsResponse>> {
        return appDataRepository.getTexts(token)
    }
}

