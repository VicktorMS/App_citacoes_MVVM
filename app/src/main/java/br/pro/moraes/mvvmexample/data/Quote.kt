package br.pro.moraes.mvvmexample.data

data class Quote(val quoteText: String, val author: String){
    override fun toString(): String {
        return "  $quoteText - $author"
    }
}

//OBS: Checar biblioteca chamada "room"
