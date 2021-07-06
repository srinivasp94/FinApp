package com.sassaran.finapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.sassaran.finapp.R

class DiscPolicyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disc_policy)

        val checkstatus : String=""
        val policy_cb: CheckBox = findViewById(R.id.policy_cb)
        val proceed_tv: TextView = findViewById(R.id.proceed_tv)

        policy_cb.setOnClickListener(View.OnClickListener {
            if (policy_cb.isChecked)
            {
                checkstatus=="true"
            }
        })

        proceed_tv.setOnClickListener(View.OnClickListener {

            if (checkstatus.equals("true")) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

        })
    }
}