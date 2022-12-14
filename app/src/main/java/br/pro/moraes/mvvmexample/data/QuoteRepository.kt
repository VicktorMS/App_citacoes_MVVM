package br.pro.moraes.mvvmexample.data

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao) {

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    fun deleteQuotes(){
        quoteDao.deleteQuotes()
    }

    companion object {
        @Volatile
        private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository(quoteDao).also { instance = it }
            }
    }

}