package com.example.zayavkaapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2
import com.example.zayavkaapp.databinding.ActivityMainBinding

var firstFragmentFinished = false
var secondFragmentFinished = false
var thirdFragmentFinished = false

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var viewPager2: ViewPager2? = null

    fun setPageFragment(position: Int) {
        viewPager2?.currentItem = position
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager2 = binding.viewPager

        binding.backButton.setOnClickListener {
            finish()
        }

        binding.viewPager.adapter = ViewPagerAdapter(this)

        binding.viewPager.isUserInputEnabled = false

        binding.firstFragmentImage.setOnClickListener {
            setPageFragment(0)
        }

        binding.secondFragmentImage.setOnClickListener {
            setPageFragment(1)
        }

        binding.thirdFragmentImage.setOnClickListener {
            setPageFragment(2)
        }

        val clickImageButton: (Int) -> (Unit) = { position ->
            when (position) {
                0 -> {
                    if (thirdFragmentFinished) {
                        binding.thirdFragmentImage.background = ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.ic_baseline_check_circle_24,
                            null
                        )
                    }
                }
                1 -> {
                    if (firstFragmentFinished) {
                        binding.firstFragmentImage.background = ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.ic_baseline_check_circle_24,
                            null
                        )
                    }
                }
                2 -> {
                    if (secondFragmentFinished) {
                        binding.secondFragmentImage.background = ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.ic_baseline_check_circle_24,
                            null
                        )
                    }
                }
            }
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                clickImageButton(position)
            }
        })
    }
}