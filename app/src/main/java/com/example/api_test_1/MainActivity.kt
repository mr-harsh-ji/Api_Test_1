package com.example.api_test_1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        val button_1 = findViewById<Button>(R.id.to_do_model)
        button_1.setOnClickListener{

            val retrofit= Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build().create(ApiService::class.java).getToDoList()

            retrofit.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    Toast.makeText(this, "${it[0].id}", Toast.LENGTH_SHORT).show()
                }
        }

        val button_2 = findViewById<Button>(R.id.get_comments)
        button_2.setOnClickListener{

            val retrofit= Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build().create(ApiService::class.java).getcomments()

            retrofit.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    Toast.makeText(this, "${it[0].body}", Toast.LENGTH_SHORT).show()
                }
        }

        val button_3 = findViewById<Button>(R.id.get_photos)
        button_3.setOnClickListener{

            val retrofit= Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build().create(ApiService::class.java).getphotos()

            retrofit.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    Toast.makeText(this, "${it[0].url}", Toast.LENGTH_SHORT).show()
                }
        }

        val button_4 = findViewById<Button>(R.id.get_albums)
        button_4.setOnClickListener{

            val retrofit= Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build().create(ApiService::class.java).getalbums()

            retrofit.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    Toast.makeText(this, "${it[0].id}", Toast.LENGTH_SHORT).show()
                }
        }

        val button_5 = findViewById<Button>(R.id.get_posts)
        button_5.setOnClickListener{

            val retrofit= Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build().create(ApiService::class.java).getposts()

            retrofit.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    Toast.makeText(this, "${it[0].title}", Toast.LENGTH_SHORT).show()
                }
        }

        val button_6 = findViewById<Button>(R.id.get_users)
        button_6.setOnClickListener{

            val retrofit= Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build().create(ApiService::class.java).getusers()

            retrofit.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    Toast.makeText(this, "${it[0].name}", Toast.LENGTH_SHORT).show()
                }
        }

    }
}