package br.pro.moraes.mvvmexample.data

class FakeDataBase private constructor() {

    var quoteDao = FakeQuoteDao()
        private set

    companion object{
        @Volatile private var instance: FakeDataBase? = null

        fun getInstance() =
            instance ?: synchronized(this){
                instance ?: FakeDataBase().also { instance = it }
            }
    }
}
//Criação de Singletons

//Repositorio será a classe que vai fazer toda a tomada de decisão em relação a dados do app.

//Armazenar os dados no servidor ou o armazenamento local é suficiente para armazenar esses dados?
//Manter 5 dias de dados armazenados localmente ou 3 dias é o suficiente?
//Esse tipo de decisão é tomada pelo Repositorio