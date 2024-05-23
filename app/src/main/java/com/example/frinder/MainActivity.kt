package com.yourappname.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.frinder.R
import com.example.frinder.adapter.CardAdapter
import com.example.frinder.model.Card

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var cardAdapter: CardAdapter
    private val cards = mutableListOf<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)

        // Add some sample data
        cards.add(Card(1, "Bill",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent imperdiet nisl eget erat tincidunt, ut maximus massa congue. Pellentesque ut dapibus mauris. Pellentesque nec augue venenatis, rhoncus ante vel, tempus libero. Vestibulum id tortor placerat, auctor tellus sit amet, fermentum turpis. Morbi elementum eros id imperdiet iaculis. Etiam vel enim nulla. Duis in odio tempus, ultricies massa quis, tempor enim. Nullam nec diam id mi sodales congue quis eu metus. Vivamus malesuada erat in lorem interdum egestas. Maecenas finibus placerat dui, id malesuada eros iaculis quis. Duis bibendum hendrerit faucibus. Nam sed interdum ligula. Donec erat elit, placerat cursus vestibulum ac, lobortis ullamcorper magna. Ut non tempus ligula. Sed a velit lorem. Nulla vestibulum metus ligula. ",
            listOf("Baking","Hiking","Boxing") ,
            "https://st2.depositphotos.com/1011382/7489/i/450/depositphotos_74896235-stock-photo-backpacker-man-taking-selfie-on.jpg"))
        cards.add(Card(2, "Rojan",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent imperdiet nisl eget erat tincidunt, ut maximus massa congue. Pellentesque ut dapibus mauris. Pellentesque nec augue venenatis, rhoncus ante vel, tempus libero. Vestibulum id tortor placerat, auctor tellus sit amet, fermentum turpis. Morbi elementum eros id imperdiet iaculis. Etiam vel enim nulla. Duis in odio tempus, ultricies massa quis, tempor enim. Nullam nec diam id mi sodales congue quis eu metus. Vivamus malesuada erat in lorem interdum egestas. Maecenas finibus placerat dui, id malesuada eros iaculis quis. Duis bibendum hendrerit faucibus. Nam sed interdum ligula. Donec erat elit, placerat cursus vestibulum ac, lobortis ullamcorper magna. Ut non tempus ligula. Sed a velit lorem. Nulla vestibulum metus ligula. ",
            listOf("Coffee","Cute Things","Eating") ,
            "https://st2.depositphotos.com/2015659/6496/i/450/depositphotos_64961499-stock-photo-beautiful-young-woman-selfie-in.jpg"))
        cards.add(Card(3, "Iana", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent imperdiet nisl eget erat tincidunt, ut maximus massa congue. Pellentesque ut dapibus mauris. Pellentesque nec augue venenatis, rhoncus ante vel, tempus libero. Vestibulum id tortor placerat, auctor tellus sit amet, fermentum turpis. Morbi elementum eros id imperdiet iaculis. Etiam vel enim nulla. Duis in odio tempus, ultricies massa quis, tempor enim. Nullam nec diam id mi sodales congue quis eu metus. Vivamus malesuada erat in lorem interdum egestas. Maecenas finibus placerat dui, id malesuada eros iaculis quis. Duis bibendum hendrerit faucibus. Nam sed interdum ligula. Donec erat elit, placerat cursus vestibulum ac, lobortis ullamcorper magna. Ut non tempus ligula. Sed a velit lorem. Nulla vestibulum metus ligula. ",
            listOf("Doing Stuff","Swordfighting","Driving", "IT") ,
            "https://images.squarespace-cdn.com/content/v1/541d14f8e4b09246971df445/1625729557397-8TTI2PX2KUF0T9SB0P0R/how-to-take-the-perfect-selfie-2.jpg"))

        cardAdapter = CardAdapter(cards)
        viewPager.adapter = cardAdapter

    }
}
