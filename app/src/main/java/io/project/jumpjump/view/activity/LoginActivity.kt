package io.project.jumpjump.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import io.project.jumpjump.view.adapter.ViewPagerAdapter
import io.project.jumpjump.view.fragment.LoginFragment
import io.project.jumpjump.view.fragment.SingUpFragment
import io.project.putushitogether.R
import io.project.putushitogether.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpTabLayout()
    }

    private fun setUpTabLayout() {
        val adapter = ViewPagerAdapter(this@LoginActivity)
        binding.viewPager.adapter = adapter
        adapter.addFragment(LoginFragment(), getString(R.string.login))
        adapter.addFragment(SingUpFragment(), getString(R.string.sing_up))
        binding.viewPager.offscreenPageLimit = adapter.itemCount
        mediator(adapter)
    }

    private fun mediator(adapter: ViewPagerAdapter) {
        val mediator = TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            run { tab.text = adapter.getTitle(position) }
        }
        mediator.attach()
    }
}