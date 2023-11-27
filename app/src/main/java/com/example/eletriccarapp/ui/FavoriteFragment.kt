package com.example.eletriccarapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.eletriccarapp.R
import com.example.eletriccarapp.data.local.CarRepository
import com.example.eletriccarapp.domain.Carro
import com.example.eletriccarapp.ui.adapter.CarAdapter

class FavoriteFragment : Fragment() {

    lateinit var listaCarrosFavoritos : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorite_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupList()
    }

    private fun getCarsOnLocalDb(): List<Carro> {
        val respository = CarRepository(requireContext())
        val carrList = respository.getAll()
        return carrList
    }

    fun setupView(view: View) {
        view.apply {
            listaCarrosFavoritos = findViewById(R.id.rv_lista_carros_favorito)
        }
    }

    fun setupList() {
        val cars = getCarsOnLocalDb()
        val carrosAdapter = CarAdapter(cars, isFavoriteScreen = true)

        listaCarrosFavoritos.apply {
            isVisible = true
            adapter = carrosAdapter
        }
        carrosAdapter.carItemLister = {carro ->
            //val isSaved = CarRepository(requireContext()).save(carro)
            //val isSaved = CarRepository(requireContext()).findCarById(carro.id)
            //val isSaved = CarRepository(requireContext()).saveIfNotExist(carro)
        }
    }
}