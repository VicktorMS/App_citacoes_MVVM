package br.pro.moraes.mvvmexample.utilities

import br.pro.moraes.mvvmexample.data.FakeDataBase
import br.pro.moraes.mvvmexample.data.QuoteRepository
import br.pro.moraes.mvvmexample.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory():QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDataBase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}