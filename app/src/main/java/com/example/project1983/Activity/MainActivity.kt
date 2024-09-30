package com.example.project1983.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project1983.Adapter.CategoryAdapter
import com.example.project1983.R
import com.example.project1983.ViewModel.MainViewModel
import com.example.project1983.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCategory()


    }

    private fun initCategory() {
        binding.progressBarCategory.visibility= View.VISIBLE
            viewModel.category.observe(this, Observer {
                binding.viewCategory.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                binding.viewCategory.adapter=CategoryAdapter(it)
                binding.progressBarCategory.visibility = View.GONE
            })
        viewModel.loadCategory()
    }
}