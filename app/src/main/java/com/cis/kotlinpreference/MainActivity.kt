package com.cis.kotlinpreference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

// preference : 간단한 내용을 저장하고 불러올 때 사용
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            val pref = getSharedPreferences("data", Context.MODE_PRIVATE)
            val editor = pref.edit()

            editor.putBoolean("data1", true)
            editor.putFloat("data2", 11.11f)
            editor.putInt("data3", 1000)
            editor.putLong("data4", 100000L)
            editor.putString("data5", "string data")

            val set = HashSet<String>()
            set.add("문자열1")
            set.add("문자열2")
            set.add("문자열3")
            editor.putStringSet("data6", set)

            editor.apply()

            Toast.makeText(this, "저장 완료", Toast.LENGTH_SHORT).show()
        }

        btn2.setOnClickListener {
            val pref = getSharedPreferences("data", Context.MODE_PRIVATE)

            val data1 = pref.getBoolean("data1", false)
            val data2 = pref.getFloat("data2", 0.0f)
            val data3 = pref.getInt("data3", 0)
            val data4 = pref.getLong("data4", 0L)
            val data5 = pref.getString("data5", "init")
            val data6 = pref.getStringSet("data6", null)

            tv.text = "data1 : ${data1}\n"
            tv.append("data2 : ${data2}\n")
            tv.append("data3 : ${data3}\n")
            tv.append("data4 : ${data4}\n")
            tv.append("data5 : ${data5}\n")

            for (str in data6!!) {
                 tv.append("data6 : ${str}\n")

            }
        }


    }
}
