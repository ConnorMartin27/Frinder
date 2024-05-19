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
        cards.add(Card(1, "Title 1", "Description 1", "https://images.squarespace-cdn.com/content/v1/541d14f8e4b09246971df445/1625729557397-8TTI2PX2KUF0T9SB0P0R/how-to-take-the-perfect-selfie-2.jpg"))
        cards.add(Card(2, "Title 2", "Description 2", "https://scontent.xx.fbcdn.net/v/t1.15752-9/438299701_768635185259221_2057992124936410677_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=5f2048&_nc_ohc=i--pAub6gIYQ7kNvgGJpyOK&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.xx&oh=03_Q7cD1QEofql1Qk12qaAgA4Y06_xWpdrZ45hkcdADJpCVCaGw8Q&oe=667194B9"))
        cards.add(Card(3, "Title 3", "Description 3", "https://images.squarespace-cdn.com/content/v1/541d14f8e4b09246971df445/1625729557397-8TTI2PX2KUF0T9SB0P0R/how-to-take-the-perfect-selfie-2.jpg"))

        cardAdapter = CardAdapter(cards)
        viewPager.adapter = cardAdapter

        // Optional: Add page transformer for swipe animation
        viewPager.setPageTransformer { page, position ->
            page.translationX = -position * page.width
            page.alpha = 0f + (1 - kotlin.math.abs(position))
        }

        // Handle swipe actions
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // Handle card swipe actions here
                // e.g., log card swiped left or right based on position
                if (position == cardAdapter.itemCount - 1) {
                    // Perform an action when the user reaches the end of the list
                }
            }
        })
    }
}
