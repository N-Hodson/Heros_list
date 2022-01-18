package com.example.heroslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heroslist.databinding.ActivityHeroesDetailBinding
import com.example.heroslist.databinding.ActivityHeroesListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeroesListActivity : AppCompatActivity() {
    lateinit var adapter: HeroAdapter
    private lateinit var binding: ActivityHeroesListBinding

    companion object {
        val TAG = "HeroesListActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val inputStream = resources.openRawResource(R.raw.heroes)
        val jsonText = inputStream.bufferedReader().use { it.readText() }
        val gson = Gson()
        val type = object : TypeToken<List<Hero>>(){}.type
        val heroesList = gson.fromJson<List<Hero>>(jsonText,type)
        Log.d(TAG, "onCreate: \n$heroesList")

        adapter = HeroAdapter(heroesList)
        binding.recyclerViewHeroesList.adapter = adapter
        binding.recyclerViewHeroesList.layoutManager = LinearLayoutManager(this)
    }


}