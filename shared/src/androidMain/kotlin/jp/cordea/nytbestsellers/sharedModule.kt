package jp.cordea.nytbestsellers

import org.koin.core.scope.ScopeSet
import org.koin.dsl.module

val sharedModule = module {
    single { ApiClient(getProperty("token")) }
    single { ListNamesRemoteDataSource(get()) }
    single { ListNamesRepository(get()) }
}

fun ScopeSet.bindPresenter() {
    scoped<MainContract.Presenter> { (view: MainContract.View) -> MainPresenter(view, get()) }
}
