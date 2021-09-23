package kr.co.kmmmami.di

import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.api.*
import kr.co.kmmmami.data.repository.AppDataRepositoryImpl
import kr.co.kmmmami.domain.repository.AppDataRepository
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.koinApplication
import org.koin.dsl.module

val networkModule = module {
    single { KtorHttpClient() }
    factory { CartApi(get()) }
    factory { CommentsApi(get()) }
    factory { HomeTodayApi(get()) }
    factory { HomeRankApi(get()) }
    factory { LoginAPI(get()) }
    factory { MarketApi(get()) }
    factory { HomeEventApi(get()) }
    factory { SmsAPI(get()) }
    factory { LoginCommerceAPI(get()) }
    factory { SearchAPI(get()) }
    factory { MyDeliveryApi(get()) }
    factory { CouponApi(get()) }
    factory { MyPointApi(get()) }
    factory { ProductApi(get()) }
    factory { RecommendAPI(get()) }
    factory { MyInquiryApi(get()) }
    factory { OrderApi(get()) }
}

val repositoryModule = module {
    single<AppDataRepository> {
        AppDataRepositoryImpl(get(), get(), get())
    }
}


fun createKoinApp() = koinApplication {
    modules(networkModule + repositoryModule)
}

//class KmmModule {
//    init {
//        createKoinApp()
//    }
//}
fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(networkModule + repositoryModule)
}

// called by iOS etc
fun initKoin() = initKoin{}