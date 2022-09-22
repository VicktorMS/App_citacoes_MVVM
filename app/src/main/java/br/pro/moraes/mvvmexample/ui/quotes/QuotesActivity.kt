package br.pro.moraes.mvvmexample.ui.quotes

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import br.pro.moraes.mvvmexample.R
import br.pro.moraes.mvvmexample.data.Quote
import br.pro.moraes.mvvmexample.databinding.ActivityQuotesBinding
import br.pro.moraes.mvvmexample.utilities.InjectorUtils

//Activitys e Fragments estão aqui para meramente mostrar algo na tela e tambem receber o input do
//usuario

//tTodo dado lógico e manipulação de dados vai para a view model e assim:
//A VIEW APENAS CHAMA FUNÇÕES DA VIEWMODEL,dessa forma o dado não é resetado quando se muda a orientação
//por exemplo, porque o dado não está associado ao ciclo de vida da view

class QuotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuoteViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer {
            quotes -> val stringBuilder = StringBuilder()
            quotes.forEach{
                    quote -> stringBuilder.append("$quote\n\n")
            }
            binding.textViewQuotes.text = stringBuilder.toString()
        })

        binding.buttonAddQuote.setOnClickListener {
            val quote = Quote(binding.editTextQuote.text.toString(),
                binding.editTextAuthor.text.toString())
            viewModel.addQuotes(quote)
            binding.editTextQuote.setText("")
            binding.editTextAuthor.setText("")
        }
    }
}



//////PROJETO USANDO UMA FAKE DATABASE E UM FAKE DAO (Data ACCESS OBJECT)
//fake DAO vai salvar dados em uma mutable list, que não será persistente

//MVVM é um tipo Architectural parent
//MVVM é uma forma de se programar que induz uma melhor manutenção do codigo

//Significa Model - View - ViewModel
//MVVM é uma das melhores opções de arquitetura para Desenvolvimento Android

////////////////////////////////////////Conceitos///////////////////////////////////////////////////

//////////////////////////////////////////View//////////////////////////////////////////////////////
//  View - é a parte do app que comporta o que o usuario ve e interage na tela,
//         view faz tudo que um fragrament/activity consegue fazer
//
//OBS: VIEWs só comportam as interações imediatas com o usuario
//     ou seja, não coloca as regras de negocio com o banco de dados por exmplo nela.
//
// Views só conseguem exibir coisas na tela, coisas essas que vem o ViewModel.
//
// Views são responsaveis por coisas com clicks e arrastar, e o que esses clicks fazem é assunto do
// View model.
//
// Maior parte da lógica da UI está na ViewModel, não tem lógica real dentro da view exceto em casos
// bem pequenos


//////////////////////////////////////////ViewModel///////////////////////////////////////////////////
//
//É como a cola entre a view e a lógica de negócio
//ViewModel não tem ideia de que views estão usando a ViewMOdel
//a view se refere ao view model e o viewmodel observa o que a acontece na view

//view model tambem observa dados do repositorio, assim como a view observa o viewmodel


////////////////////////////////////////////Model///////////////////////////////////////////////////
//É onde se coloca todos os códigos especificos de negócios

//Respositorio: é um mediador entre o armazenamento local é um webservidor
//em um repositorio onde se checa quais dados serão armazenados em cache
//Quando a viewmodel quer pegar algum dado, pega do repositorio, dai o repositorio
//decide o que fazem em seguida.

//VM não se importa da onde os dados serão buscados, o repositorio sim




//