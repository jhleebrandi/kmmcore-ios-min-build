package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.onCompletion
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.di.initKoin
import kr.co.kmmmami.domain.model.response.*
import kr.co.kmmmami.domain.repository.AppDataRepository
import kr.co.kmmmami.util.CFlow
import kr.co.kmmmami.util.createPlatformLogger
import kr.co.kmmmami.util.wrap
import platform.Foundation.NSLog

/**
 * Created by jangsc@brandi.co.kr on 2021/08/25
 */
class AppDataRepositoryIos {
    private val logger = createPlatformLogger("MovieSDK")

    private val koinApp = initKoin()
    private val appDataRepository: AppDataRepository = koinApp.koin.get()

    @Throws(Exception::class)
    suspend fun searchMovies(token: String): CFlow<ResultData<CategoryResponse>> {
        return appDataRepository.getCategories(token)
            .onCompletion {
                NSLog("searchMoviesTemp::onCompletion")
            }.wrap()
    }

    @Throws(Exception::class)
    suspend fun getImages(token: String): CFlow<ResultData<ImagesResponse>> {
        return appDataRepository.getImages(token)
            .onCompletion {
                NSLog("searchMoviesTemp::onCompletion")
            }.wrap()
    }

    @Throws(Exception::class)
    suspend fun getTexts(token: String): CFlow<ResultData<TextsResponse>> {
        return appDataRepository.getTexts(token)
            .onCompletion {
                NSLog("searchMoviesTemp::onCompletion")
            }.wrap()
    }

    @Throws(Exception::class)
    suspend fun getUrls(token: String): CFlow<ResultData<UrlsResponse>> {
        return appDataRepository.getUrls(token)
            .onCompletion {
                NSLog("searchMoviesTemp::onCompletion")
            }.wrap()
    }

    @Throws(Exception::class)
    suspend fun getVersion(token: String): CFlow<ResultData<VersionResponse>> {
        NSLog("getVersion::start")
        logger.d("getVersion::start")
        return appDataRepository.getVersion(token)
            .onCompletion {
                NSLog("getVersion::onCompletion")
                logger.d("getVersion::onCompletion")
            }.wrap()
    }
}
