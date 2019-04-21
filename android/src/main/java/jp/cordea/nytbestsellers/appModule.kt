package jp.cordea.nytbestsellers

import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    scope(named<MainActivity>()) {
        scoped<ActivityTitleStateDispatcher> { ActivityTitleState() } bind ActivityTitleStateStore::class
    }
    scope(named<MainFragment>()) {
        bindMainPresenter()
    }
    scope(named<DetailFragment>()) {
        bindDetailPresenter()
    }
}
