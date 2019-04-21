package jp.cordea.nytbestsellers

import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    scope(named<MainFragment>()) {
        bindMainPresenter()
    }
    scope(named<DetailFragment>()) {
        bindDetailPresenter()
    }
}
