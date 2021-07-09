package com.sassaran.finapp.Activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityAddressesBinding

class Addresses_Activity : BaseActivity<ActivityAddressesBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_addresses
    }

    override fun initialise() {

        binding.rootHeader.backarrowimg.setOnClickListener(View.OnClickListener {
            finish()
        })

    }
}