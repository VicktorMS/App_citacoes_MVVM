package br.pro.moraes.mvvmexample.ui.quotes

import androidx.lifecycle.ViewModel
import br.pro.moraes.mvvmexample.data.Quote
import br.pro.moraes.mvvmexample.data.QuoteRepository

class QuoteViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel(){

        fun getQuotes() = quoteRepository.getQuotes()
        fun addQuotes(quote: Quote) = quoteRepository.addQuote(quote)
}