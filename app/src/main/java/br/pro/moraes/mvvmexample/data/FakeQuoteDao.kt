package br.pro.moraes.mvvmexample.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
        //conecta a lista de "quotes a uma live data, que pode ser observada
    }

    fun addQuote(quote: Quote){
        quoteList.add(quote)
        quotes.value = quoteList // Atualiza a lista de quotes
        //Quando atualizado vai ativar todas os observadores que estão observando está LiveData
    }
    fun getQuotes() = quotes as LiveData<List<Quote>>
    //Retorna todos as citações, ou seja retorna a mutablelivedata
}