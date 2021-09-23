package kr.co.kmmmami.di

import kr.co.kmmmami.data.repository.AppDataRepositoryImpl
import kr.co.kmmmami.data.repository.AppDataRepositoryIos
import kr.co.kmmmami.domain.repository.AppDataRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * Created by jangsc@brandi.co.kr on 2021/08/25
 */
//fun initIosDependencies() = startKoin {
//    modules(commonModule, iosModule, networkModule)
//}
//
//private val commonModule = module {
//    single<AppDataRepository> {
//        AppDataRepositoryImpl(get(), get())
//    }
//}

//private val iosModule = module {
//    factory { AppDataRepositoryIos(get()) }
//}
//
///**
// * This is a DI Component exposed for our Swift code. It contains all the business classes
// * that matter for the iOS app.
// */
//class IosComponent : KoinComponent {
//    fun provideAppDataRepository(): AppDataRepositoryIos = get()
//}