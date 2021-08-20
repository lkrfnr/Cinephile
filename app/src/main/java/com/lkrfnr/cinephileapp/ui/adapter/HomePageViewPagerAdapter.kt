package com.lkrfnr.cinephileapp.ui.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.lkrfnr.cinephileapp.R;
import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularResult;


class HomePageViewPagerAdapter(
    private val popularResults : List<MoviePopularResult>
    ) : PagerAdapter() {

    private val baseUrl : String = "http://image.tmdb.org/t/p/w500";

    @Override
    override fun getCount() : Int {
        return 5;
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` == view
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val inflater : LayoutInflater  = LayoutInflater.from(container.context)
        val viewPagerItemView : ViewGroup  = inflater.inflate(R.layout.home_page_favorite_view_pager_item_view, container, false) as ViewGroup

        val imageView : ImageView = viewPagerItemView.findViewById(R.id.popular_content_image)

        val popularContent : MoviePopularResult = popularResults[position]

        Glide.with(container.context)
            .load(baseUrl + Uri.parse(popularContent.posterPath))
            .into(imageView)

        container.addView(viewPagerItemView)
        return viewPagerItemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }



}
