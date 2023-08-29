package com.wahyouwebid.app.modules

import android.os.Bundle
import com.wahyouwebid.app.base.BaseActivity
import com.wahyouwebid.app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun setupView(savedInstanceState: Bundle?) {}

}