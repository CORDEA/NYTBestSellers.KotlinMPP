package jp.cordea.nytbestsellers

import org.koin.dsl.module

val sharedModule = module {
    single { ApiClient(getProperty("token")) }
}
